package main.java.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

import java.sql.SQLException;

public class Get_connection {
    public  static DataSource ds=null;
    static{
        ComboPooledDataSource cpds=new ComboPooledDataSource("weather");
        ds=cpds;
    }
    public static DataSource getDataSource() throws SQLException {
        System.out.println(ds);
        return  ds;
    }
}
