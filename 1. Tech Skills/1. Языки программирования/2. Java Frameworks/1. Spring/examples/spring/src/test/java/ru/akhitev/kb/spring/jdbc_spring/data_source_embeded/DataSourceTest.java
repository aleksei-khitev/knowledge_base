package ru.akhitev.kb.spring.jdbc_spring.data_source_embeded;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.akhitev.kb.spring.jdbc_spring.data_source.conf.DbConfig;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.FleetUnit;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataSourceTest {
    private static Logger logger = LoggerFactory.getLogger(DataSourceTest.class);

    @Test
    public void testWithXml() throws SQLException {
        logger.info("Start with DataSource from beans.xml");
        GenericXmlApplicationContext context =
                new GenericXmlApplicationContext("spring/jdbc_spring/data_source_embeded/beans.xml");
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        Assert.assertNotNull(dataSource);
        logger.info("Data Source: {}", dataSource);
        testDataSource(dataSource);
        logger.info("=====================================");
    }

    @Test
    public void testWithJavaConfig() throws SQLException {
        logger.info("Start with DataSource from Java Config");
        ApplicationContext context =
                new AnnotationConfigApplicationContext(EmbededDbConfig.class);
        DataSource dataSource = context.getBean(DataSource.class);
        Assert.assertNotNull(dataSource);
        logger.info("Data Source: {}", dataSource);
        testDataSource(dataSource);
        logger.info("=====================================");
    }

    private void testDataSource(DataSource dataSource) throws SQLException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from fleet_unit");
            ResultSet resultSet = statement.executeQuery();
            List<FleetUnit> result = new ArrayList<>();
            while (resultSet.next()) {
                FleetUnit fleetUnit = new FleetUnit();
                fleetUnit.setId(resultSet.getLong("id"));
                fleetUnit.setName(resultSet.getString("name"));
                result.add(fleetUnit);
            }
            Assert.assertTrue(result.size() == 2);
            logger.info("Fleet units: {}", result);
            statement.close();
        } catch (SQLException e) {
            logger.error("", e);
        } finally {
          if (connection != null) {
              connection.close();
          }
        }
    }
}
