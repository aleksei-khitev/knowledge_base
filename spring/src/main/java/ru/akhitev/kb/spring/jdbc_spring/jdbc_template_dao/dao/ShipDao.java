package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.Ship;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShipDao {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ShipDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Ship> findAll() {
        return namedParameterJdbcTemplate.query("select * from ship", new ShipRowMapper());
    }

    public String findNameById(Long id) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        return namedParameterJdbcTemplate.queryForObject("select name from ship where id = :id",
                parameters,
                String.class);
    }

    private static final class ShipRowMapper implements RowMapper<Ship> {

        @Override
        public Ship mapRow(ResultSet rs, int rowNum) throws SQLException {
            Ship ship = new Ship();
            ship.setId(rs.getLong("id"));
            ship.setFleetUnitId(rs.getLong("fleet_unit_id"));
            ship.setName(rs.getString("name"));
            ship.setType(rs.getString("type"));
            ship.setShipClass(rs.getString("ship_class"));
            return ship;
        }
    }
}
