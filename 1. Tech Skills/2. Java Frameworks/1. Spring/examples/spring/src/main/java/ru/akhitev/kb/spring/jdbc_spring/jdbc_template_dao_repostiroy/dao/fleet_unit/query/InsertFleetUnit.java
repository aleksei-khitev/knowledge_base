package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.fleet_unit.query;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;

import static java.sql.Types.VARCHAR;

public class InsertFleetUnit extends SqlUpdate {
    private static final String QUERY = "insert into fleet_unit(name) values(:name);";

    public InsertFleetUnit(DataSource dataSource) {
        super(dataSource, QUERY);
        super.declareParameter(new SqlParameter("name", VARCHAR));
        super.setGeneratedKeysColumnNames("id");
        super.setReturnGeneratedKeys(true);
    }
}
