package ru.akhitev.kb.spring_boot.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.akhitev.kb.spring_boot.jdbc.entity.Ship;

import java.util.List;

@Repository
public class ShipDao implements Dao<Ship> {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ShipDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Ship> findAll() {
        return jdbcTemplate.query("select * from ship", (rs, rowNum) -> {
            return new Ship(rs.getLong("id"), rs.getString("name"), rs.getString("type"), rs.getString("ship_class"), rs.getLong("fleet_unit_id"));
        });
    }
}
