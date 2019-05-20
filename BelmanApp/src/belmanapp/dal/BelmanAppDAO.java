/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.dal;

import belmanapp.bll.JsonParser;
import belmanapp.JsonData;
import belmanapp.be.Department;
import belmanapp.be.Order;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONObject;

/**
 *
 * @author simge
 */
public class BelmanAppDAO {
    BelmanAppDAO dao;
    belmanapp.dal.DBConnection db;
    belmanapp.bll.JsonParser jp;
    
    //Liste af aktive medarbejdere for den enkelte ordre, fra JSON filen
    public List<Department> getAvailableWorkers(String name) throws SQLException
    {
        List<Department> workers = new ArrayList<>();
        try(Connection con = db.getConnection())
        {
            PreparedStatement stmt;
            stmt = con.prepareStatement("SELECT * FROM Worker");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Department dep = new Department();
                dep.setWorker(name);
                workers.add(dep);
            }
        }
            return workers;
    }
    
    public Order calculateProgress()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void updateProgress()
    {
        
    }
    
    public void updateGUI()
    {
        
    }

    public List<Order> getOrders() throws SQLServerException, SQLException {
        ArrayList<Order> orders = new ArrayList<>();
        try
        {
            DBConnection dc = new DBConnection();
            try (Connection con = dc.getConnection())
            {
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery("Select * FROM Orders;");
                
                while(rs.next())
                {
                    int id = rs.getInt("OrderID");
                    String ordNum = rs.getString("OrderNumber");
                    String customer = rs.getString("Customer");
                    Date delDate = rs.getDate("DeliveryTime");
                    orders.add(new Order());
                }
            }
        }
      
//        try (Connection con = db.getConnection()){
//            PreparedStatement stmt;
//            stmt = con.prepareStatement("SELECT * FROM Orders");
//            ResultSet rs = stmt.executeQuery();
//            
//            while(rs.next())
//            {
//                Order number = new Order();
//                number.
//                orders.add(number);
//            }
//        } 
        catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
