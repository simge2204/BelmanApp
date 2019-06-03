/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.dal;

import belmanapp.bll.JsonParser;
import belmanapp.JsonData;
import belmanapp.be.Department;
import belmanapp.be.DepartmentTask;
import belmanapp.be.Order;
import belmanapp.be.Worker;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    DBConnection db = new DBConnection();
    belmanapp.dal.JsonDAO jdao;
      
    public void addOrders(Order o) throws SQLException, SQLServerException, ParseException {
        try (Connection con = db.getConnection()) {
            String sql = "INSERT INTO Orders(OrderNumber, Customer, DeliveryTime) VALUES (?,?,?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, o.getOrderNumber());
            stmt.setString(2, o.getCustomer());
            stmt.setDate(3, o.getDeliveryDate());
//            stmt.setString(3, new SimpleDateFormat("MM/dd/yyyy").format(o.getDeliveryDate()));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Order> getOrders() throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();

        try(Connection con = db.getConnection()) {
            String sql = "SELECT * FROM Orders;";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("OrderID");
                String ordNum = rs.getString("OrderNumber");
                String customer = rs.getString("Customer");
                Date delDate = rs.getDate("DeliveryTime");
                orders.add(new Order(id, ordNum, customer, delDate));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }
    
    public void updateOrders(Order o) throws SQLException {
//        ArrayList<Order> orders = new ArrayList<>();
        try (Connection con = db.getConnection()) {
            String sql = "select distinct ordernumber\n"
                    + "from orders\n"
                    + "group by ordernumber;";
            PreparedStatement stmt = con.prepareStatement(sql);
            //"INSERT INTO Orders(OrderNumber, Customer, DeliveryTime) VALUES(?,?,?)"
                    //                    + "GROUP BY distinct OrderNumber FROM Orders;";
                    //            PreparedStatement stmt = con.prepareStatement(sql);
                    //            stmt.setString(1, o.getOrderNumber());
                    //            stmt.setString(2, o.getCustomer());
                    //            stmt.setDate(3, o.getDeliveryDate());
            stmt.executeQuery();
//            stmt.execute();
        }
    }
    
    public void addWorkers(Worker w) throws SQLException {
        try (Connection con = db.getConnection()) {
            String sql = "INSERT INTO Worker(WName, Initials, Salary) VALUES(?,?,?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, w.getName());
            stmt.setString(2, w.getInitials());
            stmt.setInt(3, w.getSalary());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Worker> getAvailableWorkers() throws SQLException {
        ArrayList<Worker> workers = new ArrayList<>();
        try (Connection con = db.getConnection()) {
            String sql = "SELECT * FROM Worker;";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int wID = rs.getInt("WorkerID");
                String wName = rs.getString("WName");
                String initial = rs.getString("Initials");
                int salary = rs.getInt("Salary");
                workers.add(new Worker(wID, initial, wName, salary));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return workers;
    }
    
    public void addDepartments(Department d) throws SQLException {
        try (Connection con = db.getConnection()) {
            String sql = "INSERT INTO Department(DepartmentID, depName) VALUES(?,?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, d.getDepID());
            stmt.setString(2, d.getDepName());
        } catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addDepTasks(DepartmentTask dt) throws SQLException {
        try (Connection con = db.getConnection()) {
            String sql = "INSERT INTO OrderTask(OrderID, DepartmentID, WorkerID, StartDate, EndDate, FinishedOrder, RealizedProgress, EstimatedProgress) VALUES(?,?,?,?,?,?,?,?,?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, dt.getOrderID());
            stmt.setInt(2, dt.getDepID());
            stmt.setDate(3, dt.getStartDate());
            stmt.setDate(4, dt.getEndDate());
            stmt.setBoolean(5, dt.getIsFinished());
        } catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<DepartmentTask> getDepTasks() throws SQLServerException, SQLException {
        ArrayList<DepartmentTask> departmentTasks = new ArrayList<>();
        try (Connection con = db.getConnection()) {
            String sql = "SELECT * FROM OrderTask;";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int oID = rs.getInt("OrderID");
                int dID = rs.getInt("DepartmentID");
                int wID = rs.getInt("WorkerID");
                Date sDate = rs.getDate("StartDate");
                Date eDate = rs.getDate("EndDate");
//                String dName = rs.getString("DepName");
                departmentTasks.add(new DepartmentTask(sDate, eDate, oID, dID, wID));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departmentTasks;
    }
    
    public List<Department> getDepartments() throws SQLException {
        ArrayList<Department> departments = new ArrayList<>();

        try (Connection con = db.getConnection()) {
            String sql = "SELECT * FROM Department;";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int depID = rs.getInt("DepartmentID");
                String depName = rs.getString("DepName");
                departments.add(new Department(depName, depID));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departments;
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
    
}
