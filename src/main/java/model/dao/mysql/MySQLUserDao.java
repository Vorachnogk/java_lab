package model.dao.mysql;

import model.dao.UserDao;
import model.entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;



public class MySQLUserDao implements UserDao {
    private static final Logger log = Logger.getLogger(MySQLUserDao.class);
    private Connection connection;
    private final ResourceBundle sql = ResourceBundle.getBundle("sql");

    public MySQLUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User entity) {
        final String query = sql.getString("CREATE_NEW_USER");
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getLogin());
            statement.setString(3, entity.getPass());
            statement.setString(4, entity.getRole());

            int affected = statement.executeUpdate();
            log.info("insertion complete: " + affected + " rows affected");
        } catch (SQLException e) {
            log.error("sql exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }

    public User findByLogin(String login) {
        User user = null;
        final String query = sql.getString("GET_USER_BY_LOGIN");
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                long id = resultSet.getLong("id_user");
                String name = resultSet.getString("name_user");
                String userLogin = resultSet.getString("login");
                String pass = resultSet.getString("pass");
                String role = resultSet.getString("role");

                user = new User.Builder()
                        .setIdUser(id)
                        .setLogin(userLogin)
                        .setName(name)
                        .setRole(role)
                        .setPassword(pass)
                        .build();
            }
            else {
                //wrong login/password
            }
        } catch (SQLException e) {
            log.error("sql exception: " + e.getMessage());
            e.printStackTrace();
        }
        return user;
    }
}
