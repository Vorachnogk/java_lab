package model.dao.mysql;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;



public class MySQLConnectionPoolHolder {

    private static volatile DataSource dataSource;

    public static DataSource getDataSource() {
        if(dataSource==null){
            synchronized (MySQLConnectionPoolHolder.class){
                if(dataSource == null){
                    BasicDataSource ds = new BasicDataSource();
                    ds.setUrl("jdbc:mysql://localhost:3306/car?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
                    ds.setUsername("rooot");
                    ds.setPassword("root");
                    ds.setMinIdle(50);
                    ds.setMaxIdle(50);
                    ds.setMaxOpenPreparedStatements(100);
                    ds.setDriverClassName("com.mysql.jdbc.Driver");
                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }

}
