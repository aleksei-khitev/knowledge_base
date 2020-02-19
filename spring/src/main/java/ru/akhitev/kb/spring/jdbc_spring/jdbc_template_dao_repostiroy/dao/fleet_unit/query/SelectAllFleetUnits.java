package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.fleet_unit.query;

import org.springframework.jdbc.object.MappingSqlQuery;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.FleetUnit;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllFleetUnits extends MappingSqlQuery<FleetUnit> {
    private static final String QUERY = "select * from fleet_unit";

    public SelectAllFleetUnits(DataSource dataSource) {
        super(dataSource, QUERY);
    }

    @Override
    protected FleetUnit mapRow(ResultSet rs, int rowNum) throws SQLException {
        FleetUnit fleetUnit = new FleetUnit();
        fleetUnit.setId(rs.getLong("id"));
        fleetUnit.setName(rs.getString("name"));
        return fleetUnit;
    }
}
