package service;

import bl.Util;
import com.sun.org.apache.regexp.internal.RE;
import dao.AppUserDAO;
import enttity.AppUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppUserService implements AppUserDAO {
    public void create(AppUser user) {
        Connection connection = createConnection();
        if (connection == null) {
            return;
        }
        PreparedStatement prepareStatement = null;

        String sql = "Insert into app_usser (id, first_name, second_name, email) values(?, ?, ?, ?)";
        try {
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, user.getId());
            prepareStatement.setString(2, user.getFirst_name());
            prepareStatement.setString(3, user.getSecond_name());
            prepareStatement.setString(4, user.getEmail());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, prepareStatement);
        }
    }


    public List<AppUser> allAppUser() {
        List<AppUser> result = new ArrayList<AppUser>();
        Connection connection = createConnection();
        if (connection == null) {
            return result;
        }
        Statement statement = null;

        String sql = "Select * from app_usser";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                AppUser user = new AppUser(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));
                result.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, statement);
        }
        return result;
    }

    public AppUser getById(int id) {
        AppUser result = null;
        Connection connection = createConnection();
        if (connection == null) {
            return result;
        }
        PreparedStatement prepareStatement = null;

        String sql = "Select * from app_usser where id = ?";
        try {
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery(sql);
            if (resultSet != null) {
                result = new AppUser(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, prepareStatement);
        }
        return result;
    }

    public void update(AppUser user) {
        Connection connection = createConnection();
        if (connection == null) {
            return;
        }
        PreparedStatement prepareStatement = null;

        String sql = "update app_usser set first_name = ?, second_name = ?, email= ? where id = ?";
        try {
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, user.getFirst_name());
            prepareStatement.setString(2, user.getSecond_name());
            prepareStatement.setString(3, user.getEmail());
            prepareStatement.setInt(4, user.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, prepareStatement);
        }
    }

    public void delete(AppUser user) {
        Connection connection = createConnection();
        if (connection == null) {
            return;
        }
        PreparedStatement prepareStatement = null;

        String sql = "delete from app_usser where id = ?";
        try {
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, user.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, prepareStatement);
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = Util.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void closeConnection(Connection connection, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}