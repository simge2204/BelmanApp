/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;

/**
 *
 * @author simge
 */
public class DBConnection {
    SQLServerDataSource ds = new SQLServerDataSource();
//    String path = "C:/Github2/Data and interface - Belman v1/data.json";
    
    public DBConnection()
    {
        ds.setUser("CS2018A_29");
        ds.setPassword("CS2018A_29");
        ds.setDatabaseName("BelmanDatabse");
        ds.setServerName("easv-db2");
        ds.setPortNumber(1433);
//        System.out.println("Connected to database!");
    }
    
    public Connection getConnection() throws SQLServerException
    {
        return ds.getConnection();
    }
}
