package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.fleet_unit.stored_function;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlFunction;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Предварительно в базе выполнить:
 *
 * DELIMITER //
 * CREATE FUNCTION getNameById(in_id INT)
 *     RETURNS VARCHAR(60)
 *     BEGIN
 *         RETURN (SELECT name FROM fleet_unit WHERE id = in_id);
 *     END //
 * DELIMITER;
 */
public class GetNameById extends SqlFunction<String> {
    private static final String QUERY = "select getNameById(?)";

    public GetNameById(DataSource dataSource) {
        super(dataSource, QUERY);
        declareParameter(new SqlParameter(Types.INTEGER));
        compile();
    }
}
