package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.ship.query;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

import javax.sql.DataSource;

import static java.sql.Types.VARCHAR;

public class InsertShipBatch extends BatchSqlUpdate {
    private final static String QUERY = "insert into ship(name, type, ship_class, fleet_unit_id) " +
            "values(:name,:type,:ship_class, :fu_id);";
    private final static int BATCH_SIZE = 5;

    public InsertShipBatch(DataSource dataSource) {
        super(dataSource, QUERY);
        declareParameter(new SqlParameter("name", VARCHAR));
        declareParameter(new SqlParameter("type", VARCHAR));
        declareParameter(new SqlParameter("ship_class", VARCHAR));
        declareParameter(new SqlParameter("fu_id", VARCHAR));
        setGeneratedKeysColumnNames("id");
        setReturnGeneratedKeys(true);
        setBatchSize(BATCH_SIZE);
    }
}
