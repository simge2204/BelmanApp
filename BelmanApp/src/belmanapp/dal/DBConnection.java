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
    private SQLServerDataSource ds = new SQLServerDataSource();
    
    public DBConnection()
    {
        ds.setUser("CS2018A_29");
        ds.setPassword("CS2018A_29");
        ds.setDatabaseName("BelmanAppDatabase");
        ds.setServerName("easv-db2");
    }
    
    public Connection getConnection() throws SQLServerException
    {
        return ds.getConnection();
    }
}
