package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao.dao.FleetUnitDao;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao.dao.ShipDao;

import javax.sql.DataSource;

@Configuration
public class DbConfig {
    private static Logger logger = LoggerFactory.getLogger(DbConfig.class);

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
            return builder.setType(EmbeddedDatabaseType.H2)
                    .addScripts("spring/jdbc_spring/data_source_embeded/schema.sql", "spring/jdbc_spring/data_source_embeded/data.sql")
                    .build();
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

    @Bean
    public FleetUnitDao fleetUnitDao() {
        return new FleetUnitDao(dataSource());
    }

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public ShipDao shipDao() {
        return new ShipDao(jdbcTemplate());
    }
}
