package model.dao;

import model.dao.mysql.JDBCDaoFactory;
import org.apache.log4j.Logger;


public abstract class DaoFactory {
    private static DaoFactory daoFactory;
    private static final Logger log = Logger.getLogger(DaoFactory.class);

    public abstract AutoDao createAutoDao();

    public abstract UserDao createUserDao();
    public static DaoFactory getInstance() {
        if(daoFactory == null) {
            synchronized (DaoFactory.class) {
                if(daoFactory == null) {
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
