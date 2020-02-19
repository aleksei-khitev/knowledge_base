package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.fleet_unit.FleetUnitDao;

import javax.sql.DataSource;

@Configuration
@PropertySource("spring/jdbc_spring/data_source/jdbc_for_utils.properties")
@ComponentScan(basePackageClasses = FleetUnitDao.class)
public class DbConfig {
    private static Logger logger = LoggerFactory.getLogger(DbConfig.class);
    @Value("${driverClassName}") private String driverClassName;
    @Value("${url}") private String url;
    @Value("${user_name}") private String userName;
    @Value("${password}") private String password;

    @Bean
    public DataSource dataSource() {
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(driverClassName);
            dataSource.setUrl(url);
            dataSource.setUsername(userName);
            dataSource.setPassword(password);
            return dataSource;
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }
}
