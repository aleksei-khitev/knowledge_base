package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class ShipDao {
    private JdbcTemplate jdbcTemplate;

    public ShipDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String findNameById(Long id) {
        Object[] objects = new Object[]{id};
        return jdbcTemplate.queryForObject("select name from ship where id = ?",
                objects,
                String.class);
    }
}
