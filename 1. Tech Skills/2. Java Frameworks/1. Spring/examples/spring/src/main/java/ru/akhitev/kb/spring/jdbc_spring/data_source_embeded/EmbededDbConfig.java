package ru.akhitev.kb.spring.jdbc_spring.data_source_embeded;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class EmbededDbConfig {
    private static Logger logger = LoggerFactory.getLogger(EmbededDbConfig.class);

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
            return databaseBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts("spring/jdbc_spring/data_source_embeded/schema.sql", "spring/jdbc_spring/data_source_embeded/data.sql")
                    .build();
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }
}
