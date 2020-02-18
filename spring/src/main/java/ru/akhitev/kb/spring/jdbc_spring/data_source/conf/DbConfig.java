package ru.akhitev.kb.spring.jdbc_spring.data_source.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
@PropertySource("spring/jdbc_spring/data_source/jdbc_for_utils.properties")
public class DbConfig {
    private static Logger logger = LoggerFactory.getLogger(DbConfig.class);

    @Value("${driverClassName}")
    private String driverClassName;

    @Value("${url}")
    private String url;

    @Value("${user_name}")
    private String userName;

    @Value("${password}")
    private String password;

    @Bean
    @Lazy
    public DataSource dataSource() {
        try {
            SimpleDriverDataSource dataSource
                    = new SimpleDriverDataSource();
            Class<? extends Driver> driver = (Class<? extends Driver>) Class.forName(driverClassName);
            dataSource.setDriverClass(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(userName);
            dataSource.setPassword(password);
            return dataSource;
        } catch (ClassNotFoundException e) {
            logger.error("", e);
            return null;
        }
    }
}
