package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.fleet_unit.query;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;

import static java.sql.Types.INTEGER;
import static java.sql.Types.VARCHAR;

public class UpdateFleetUnits extends SqlUpdate {
    private static final String QUERY = "update fleet_unit set name=:new_name where id=:id";

    public UpdateFleetUnits(DataSource dataSource) {
        super(dataSource, QUERY);
        super.declareParameter(new SqlParameter("id", INTEGER));
        super.declareParameter(new SqlParameter("new_name", VARCHAR));
        compile();
    }
}
