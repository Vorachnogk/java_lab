package model.dao.mysql;

import model.dao.*;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;




public  class JDBCDaoFactory extends DaoFactory {
    private static final Logger log = Logger.getLogger(JDBCDaoFactory.class);
    private DataSource dataSource = MySQLConnectionPoolHolder.getDataSource();

    private Connection getConnection() {
        try{
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public AutoDao createAutoDao() {
        return new MySQLAuto(getConnection());
    }

    @Override
    public UserDao createUserDao() {
        return new MySQLUserDao(getConnection());
    }


}
