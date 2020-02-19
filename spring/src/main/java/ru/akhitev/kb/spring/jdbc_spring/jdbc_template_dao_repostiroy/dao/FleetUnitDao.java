package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.FleetUnit;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.Ship;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FleetUnitDao implements InitializingBean {
    private static Logger logger = LoggerFactory.getLogger(FleetUnitDao.class);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FleetUnitDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    public List<FleetUnit> findAll() {
        return jdbcTemplate.query("select * from fleet_unit", (ResultSet rs, int rowNum) -> {
            FleetUnit fleetUnit = new FleetUnit();
            fleetUnit.setId(rs.getLong("id"));
            fleetUnit.setName(rs.getString("name"));
            return fleetUnit;
        });
    }

    public List<FleetUnit> findAllWithShips() {
        return jdbcTemplate.query("select f.id as f_id, f.name as fleet_unit_name, " +
                "s.id as ship_id, s.name as ship_name, s.fleet_unit_id, s.type, s.ship_class " +
                "from fleet_unit f " +
                "left join ship s on f.id = s.fleet_unit_id", new FLeetUnitResultSetExtractor());
    }

    public String findNameById(Long id) {
        Object[] objects = new Object[]{id};
        return jdbcTemplate.queryForObject("select name from fleet_unit where id = ?",
                objects,
                String.class);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (jdbcTemplate == null) {
            throw new BeanCreationException("Data Source must not be null");
        }
    }

    public static final class FLeetUnitResultSetExtractor implements ResultSetExtractor<List<FleetUnit>> {

        @Override
        public List<FleetUnit> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Long, FleetUnit> map = new HashMap<>();
            FleetUnit fleetUnit = null;
            while (rs.next()) {
                Long id = rs.getLong("f_id");
                fleetUnit = map.get(id);
                if (fleetUnit == null) {
                    fleetUnit = new FleetUnit();
                    fleetUnit.setId(id);
                    fleetUnit.setName(rs.getString("fleet_unit_name"));
                    fleetUnit.setShips(new ArrayList<>());
                    map.put(id, fleetUnit);
                }
                long shipId = rs.getLong("ship_id");
                if (shipId > 0) {
                    Ship ship = new Ship();
                    ship.setId(shipId);
                    ship.setName(rs.getString("ship_name"));
                    ship.setFleetUnitId(id);
                    ship.setType(rs.getString("type"));
                    ship.setShipClass(rs.getString("ship_class"));
                    fleetUnit.addShip(ship);
                }
            }
            return new ArrayList<>(map.values());
        }
    }
}
