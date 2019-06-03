/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.dal;

import belmanapp.JsonData;
import belmanapp.be.Department;
import belmanapp.be.DepartmentTask;
import belmanapp.be.Order;
import belmanapp.be.Worker;
import belmanapp.bll.JsonParser;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Statement;
import java.text.ParseException;
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
    
//    public void addOrders(Order o) throws SQLException, SQLServerException, ParseException {
////        ordNum = o.getOrderNumber();
//        try (Connection con = db.getConnection()) {
//            String sql = "INSERT INTO Orders(OrderNumber, Customer, DeliveryTime) VALUES (?,?,?);";
////                    + dt.getStartDate() + "," 
////                    + dt.getEndDate() + "," 
//            PreparedStatement stmt = con.prepareStatement(sql);
////            stmt.setInt(1, o.getOrderID());
//            stmt.setString(1, o.getOrderNumber());
//////            stmt.setDate(3, dt.getStartDate());
//////            stmt.setDate(4, dt.getEndDate());
////            stmt.setInt(3, o.getCustomerID());
//            stmt.setString(2, o.getCustomer());
//            stmt.setDate(3, o.getDeliveryDate());
////            stmt.setObject(1, jp.parseOrderObject(order), 2);
//            stmt.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(JsonDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public List<Order> getOrders() throws SQLException {
//        ArrayList<Order> orders = new ArrayList<>();
//        
//        try (Connection con = db.getConnection()) {
//            String sql = "SELECT * FROM Orders ;"; //INNER JOIN Customer ON Orders.CustomerID = Customer.CustomerID
////                String sql = "Select * FROM Orders;";
//            PreparedStatement stmt = con.prepareStatement(sql);
////            stmt.setInt(1, o.getOrderID());
//            ResultSet rs = stmt.executeQuery();
//            
//            while (rs.next()) {
//                int id = rs.getInt("OrderID");
//                String ordNum = rs.getString("OrderNumber");
////                int cID = rs.getInt("CustomerID");
//                String customer = rs.getString("Customer");
//                Date delDate = rs.getDate("DeliveryTime");
//                orders.add(new Order(id, ordNum, customer, delDate));
//            }
//        }
//        return orders;
//    }
//    
//    public void addWorkers(Worker w) throws SQLException
//    {
//        try(Connection con = db.getConnection())
//        {
//            String sql = "INSERT INTO Worker(WName, Initials, Salary);";
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setString(1, w.getName());
//            stmt.setString(2, w.getInitials());
//            stmt.setInt(3, w.getSalary());
//            stmt.executeUpdate();
//        }
//    }
//    
//    public List<Worker> getAvailableWorkers() throws SQLException
//    {
//            ArrayList<Worker> workers = new ArrayList<>();
//            try(Connection con = db.getConnection())
//            {
//            String sql = "SELECT * FROM Worker;";
//            PreparedStatement stmt = con.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery();
//            
//            while(rs.next())
//            {
//                int wID = rs.getInt("WorkerID");
//                String wName = rs.getString("WName");
//                String initial = rs.getString("Initials");
//                int salary = rs.getInt("Salary");
//                workers.add(new Worker(wID, initial, wName, salary));
//            }
//        }
//            return workers;
//    }
//    
//    public void addDepartments(Department d) throws SQLException
//    {
//     try(Connection con = db.getConnection())
//     {
//         String sql = "INSERT INTO Department(DepartmentID, depName);";
//         PreparedStatement stmt = con.prepareStatement(sql);
//         stmt.setInt(1, d.getDepID());
//         stmt.setString(2, d.getDepName());
//     }
//    }
//    
//    public void addDepTasks(DepartmentTask dt) throws SQLException
//    {
//        try(Connection con = db.getConnection())
//     {
//         String sql = "INSERT INTO OrderTask(OrderID, DepartmentID, WorkerID, StartDate, EndDate, FinishedOrder, RealizedProgress, EstimatedProgress);";
//         PreparedStatement stmt = con.prepareStatement(sql);
//         stmt.setInt(1, dt.getOrderID());
//         stmt.setInt(2, dt.getDepID());
//         stmt.setDate(3, dt.getStartDate());
//         stmt.setDate(4, dt.getEndDate());
//         stmt.setBoolean(5, dt.getIsFinished());
//     }
//    }
//    
//    public List<DepartmentTask> getDepTasks() throws SQLServerException, SQLException
//    {
//        ArrayList<DepartmentTask> departmentTasks = new ArrayList<>();
//        try(Connection con = db.getConnection())
//        {
//            String sql = "SELECT * FROM OrderTask;";
//            PreparedStatement stmt = con.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery();
//            
//            while(rs.next())
//            {
//                int oID = rs.getInt("OrderID");
//                int dID = rs.getInt("DepartmentID");
//                int wID = rs.getInt("WorkerID");
//                Date sDate = rs.getDate("StartDate");
//                Date eDate = rs.getDate("EndDate");
////                String dName = rs.getString("DepName");
//                departmentTasks.add(new DepartmentTask(sDate, eDate, oID, dID, wID));
//            }
//        }
//        return departmentTasks;
//    }
    
    }