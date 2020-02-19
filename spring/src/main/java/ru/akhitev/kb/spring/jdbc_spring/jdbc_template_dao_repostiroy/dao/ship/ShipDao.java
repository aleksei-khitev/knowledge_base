package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.ship;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.Ship;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ShipDao implements InitializingBean {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ShipDao(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
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

    @Override
    public void afterPropertiesSet() throws Exception {
        if (namedParameterJdbcTemplate == null) {
            throw new BeanCreationException("Data Source must not be null");
        }
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
