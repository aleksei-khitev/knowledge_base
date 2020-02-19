package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.FleetUnit;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class FleetUnitDao implements InitializingBean {
    private static Logger logger = LoggerFactory.getLogger(FleetUnitDao.class);
    private JdbcTemplate jdbcTemplate;

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
}
