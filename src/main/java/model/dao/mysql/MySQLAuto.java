package model.dao.mysql;

import model.dao.AutoDao;
import model.dao.mysql.update.Update;
import model.entity.Auto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class MySQLAuto implements AutoDao {


    private Connection connection;
    ResourceBundle sql = ResourceBundle.getBundle("sql");


    public MySQLAuto(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Auto entity) {
        final String query = sql.getString("CREATE_Auto");
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, entity.getNameAuto());
            statement.setString(2, entity.getNumberAuto());


            statement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public Auto findById(int id) {
        Auto e = null;

//
        return e;
    }

    @Override
    public List<Auto> findAll() {
        List<Auto> autoList = new ArrayList<>();

        return autoList;
    }

    @Override
    public void update(Auto entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }

    @Override
    public List<Auto> getSearchAuto(int idUser) {
        List<Auto> autoList = new ArrayList<>();
        int counter = 1;
        model.dao.mysql.update.Update update = new Update();
        update.setStrategy(idUser);
        final String query = sql.getString(update.execute());

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            if (idUser != 0) {
                statement.setLong(counter, idUser);
                counter++;
            }


            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id_expo");
                long idCat = resultSet.getLong("id_cat");
                long idHall = resultSet.getLong("id_hall");
                String name = resultSet.getString("name_expo");
                long price = resultSet.getLong("price");
                String nameAuto = resultSet.getString("name_auto");
                String numberAuto = resultSet.getString("number_auto");

                Auto auto = new Auto.Builder()
                        .setNameAuto(nameAuto)
                        .setNumberAuto(numberAuto)

                        .build();
                autoList.add(auto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//
        return autoList;
    }


}
