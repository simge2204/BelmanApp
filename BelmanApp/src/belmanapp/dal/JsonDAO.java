/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.dal;

import belmanapp.JsonData;
import belmanapp.be.Order;
import belmanapp.bll.JsonParser;
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
public class JsonDAO {
    BelmanAppDAO dao = new BelmanAppDAO();
    DBConnection db = new DBConnection();
    JsonParser jp = new JsonParser();
    JsonData jd = new JsonData();
    
    public void createOrders(int id, String ordNum, String customer, Date delivery) throws SQLServerException, SQLException {
        String SQL_INSERT = "INSERT INTO Orders(OrderID, OrderNumber, DeliveryTime, Customer) values(?,?,?,?)";
        try (
                Connection con = db.getConnection();
                PreparedStatement stmt = con.prepareStatement(SQL_INSERT,
                        Statement.RETURN_GENERATED_KEYS);) {
            stmt.setInt(1, id);
            stmt.setString(2, ordNum);
            stmt.setString(3, customer);
            stmt.setDate(4, delivery);
//            stmt.setDate(2, order.getDeliveryDate());
//            stmt.setString(3, order.getCustomer());
            // ...

//            int affectedRows = stmt.executeUpdate();
//
//            if (affectedRows == 0) {
//                throw new SQLException("Creating user failed, no rows affected.");
//            }
//
//            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    order.setOrderNumber(generatedKeys.getString(SQL_INSERT));
//                    order.setOrderID((int) generatedKeys.getLong(1));
//                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
//        }
//    }
    
    public void addOrders(JsonParser jp, Order order) throws SQLException, SQLServerException {
        try (Connection con = db.getConnection()) {
            String sql = "INSERT INTO Orders(OrderNumber, DeliveryTime, CustomerID) VALUES (?,?,?) ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, order.getOrderNumber());
            stmt.setString(2, order.getCustomer());
            stmt.setDate(3, order.getDeliveryDate());
            stmt.execute();
            stmt.addBatch();
        }
         catch (SQLException ex) 
        {
            Logger.getLogger(JsonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public List<Order> getOrders() {
        
        ArrayList<Order> orders = new ArrayList();
      
        try (Connection con = db.getConnection()){
            PreparedStatement stmt;
            stmt = con.prepareStatement("select * from Orders");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Order number = new Order();
                number.setOrderID(rs.getInt("OrderID"));
                number.setOrderNumber(rs.getString("OrderNumber"));
                number.setCustomer(rs.getString("Customer"));
                number.setDeliveryDate(rs.getDate("DeliveryTime"));
                orders.add(number);
            }
        } 
        catch (SQLException ex) {
//            ex.printStackTrace();
            Logger.getLogger(JsonDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return orders;
    }
}