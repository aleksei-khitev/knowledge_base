package ru.akhitev.kb.spring_boot.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.akhitev.kb.spring_boot.jdbc.entity.FleetUnit;

import java.util.List;

@Repository
public class FleetUnitDao implements Dao<FleetUnit> {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FleetUnitDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<FleetUnit> findAll() {
        return jdbcTemplate.query("select * from fleet_unit", (rs, rowNumber) -> {
            return new FleetUnit(rs.getLong("id"), rs.getString("name"), null);
        });
    }
}
