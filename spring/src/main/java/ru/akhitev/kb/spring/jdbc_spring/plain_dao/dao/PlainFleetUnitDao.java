package ru.akhitev.kb.spring.jdbc_spring.plain_dao.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.FleetUnit;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlainFleetUnitDao implements FleetUnitDao {
    private static Logger logger = LoggerFactory.getLogger(PlainFleetUnitDao.class);

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/fleet?useSSL=true",
                "commander", "commander_123");
    }

    private void closeConnection(Connection connection) {
        if (connection == null) return;
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error("", e);
        }
    }

    @Override
    public List<FleetUnit> findAll() {
        List<FleetUnit> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from fleet_unit");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FleetUnit fleetUnit = new FleetUnit();
                fleetUnit.setId(resultSet.getLong("id"));
                fleetUnit.setName(resultSet.getString("name"));
                result.add(fleetUnit);
            }
            statement.close();
        } catch (SQLException e) {
            logger.error("", e);
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public void insert(FleetUnit fleetUnit) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("insert into fleet_unit(name) values(?)",
                            Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, fleetUnit.getName());
            statement.execute();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                fleetUnit.setId(generatedKeys.getLong(1));
            }
            statement.close();
        } catch (SQLException e) {
            logger.error("", e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(FleetUnit fleetUnit) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(Long fleetUnitId) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("delete from fleet_unit where id=?");
            statement.setLong(1, fleetUnitId);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            logger.error("", e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<FleetUnit> findByName(String name) {
        throw new NotImplementedException();
    }

    @Override
    public List<FleetUnit> findAllWithDetail() {
        throw new NotImplementedException();
    }

    @Override
    public List<FleetUnit> insertWithDetail(FleetUnit fleetUnit) {
        throw new NotImplementedException();
    }
}
