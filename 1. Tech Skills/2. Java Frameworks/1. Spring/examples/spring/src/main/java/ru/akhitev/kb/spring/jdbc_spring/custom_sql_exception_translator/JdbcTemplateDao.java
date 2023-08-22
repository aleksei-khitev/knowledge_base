package ru.akhitev.kb.spring.jdbc_spring.custom_sql_exception_translator;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcTemplateDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateDao(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        MySQLErrorCodesTranslator mySQLErrorCodesTranslator = new MySQLErrorCodesTranslator();
        mySQLErrorCodesTranslator.setDataSource(dataSource);

        jdbcTemplate.setExceptionTranslator(mySQLErrorCodesTranslator);
        this.jdbcTemplate = jdbcTemplate;
    }
}
