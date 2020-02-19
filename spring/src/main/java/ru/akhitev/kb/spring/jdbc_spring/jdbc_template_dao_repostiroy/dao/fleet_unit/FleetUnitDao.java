package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.fleet_unit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.fleet_unit.query.InsertFleetUnit;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.fleet_unit.query.SelectAllFleetUnits;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.fleet_unit.query.SelectFleetUnitNameById;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.fleet_unit.query.UpdateFleetUnits;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.fleet_unit.stored_function.GetNameById;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.FleetUnit;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.Ship;

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
    private SelectAllFleetUnits selectAllFleetUnits;
    private SelectFleetUnitNameById selectFleetUnitNameById;
    private UpdateFleetUnits updateFleetUnits;
    private InsertFleetUnit insertFleetUnit;
    private GetNameById getNameById;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public FleetUnitDao(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        selectAllFleetUnits = new SelectAllFleetUnits(dataSource);
        selectFleetUnitNameById = new SelectFleetUnitNameById(dataSource);
        updateFleetUnits = new UpdateFleetUnits(dataSource);
        insertFleetUnit = new InsertFleetUnit(dataSource);
        getNameById = new GetNameById(dataSource);
    }

    public List<FleetUnit> findAll() {
        return selectAllFleetUnits.execute();
    }

    public List<FleetUnit> findAllWithShips() {
        return jdbcTemplate.query("select f.id as f_id, f.name as fleet_unit_name, " +
                "s.id as ship_id, s.name as ship_name, s.fleet_unit_id, s.type, s.ship_class " +
                "from fleet_unit f " +
                "left join ship s on f.id = s.fleet_unit_id", new FLeetUnitResultSetExtractor());
    }

    public String findNameById(Long id) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        List<String> names = selectFleetUnitNameById.executeByNamedParam(parameters);
        if (names.size() > 0) {
            return names.get(0);
        } else {
            return null;
        }
    }

    public String getNameByIdViaFunction(Long id) {
        List<String> result = getNameById.execute(id);
        return result.get(0);
    }

    public void updateName(long id, String newName) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        parameters.put("new_name", newName);
        updateFleetUnits.updateByNamedParam(parameters);
    }

    public void insert(FleetUnit fleetUnit) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", fleetUnit.getName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertFleetUnit.updateByNamedParam(parameters, keyHolder);
        fleetUnit.setId(keyHolder.getKey().longValue());
        logger.info("insert complete. Generated id = {}", fleetUnit.getId());
    }

    public void delete(long id) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        jdbcTemplate.update("delete from fleet_unit where id=:id", parameters);
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
