package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.fleet_unit.query;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.FleetUnit;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class SelectFleetUnitNameById extends MappingSqlQuery<String> {
    private static final String QUERY = "select name from fleet_unit where id = :id";

    public SelectFleetUnitNameById(DataSource dataSource) {
        super(dataSource, QUERY);
        super.declareParameter(new SqlParameter("id", Types.INTEGER));
    }

    @Override
    protected String mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getString("name");
    }
}
