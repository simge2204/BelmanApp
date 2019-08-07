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
import belmanapp.gui.controller.OrderViewController;
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
import java.time.Clock;
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
            String sql = "INSERT INTO Orders(OrderNumber, Customer, DeliveryTime) VALUES(?,?,?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, o.getOrderNumber());
            stmt.setString(2, o.getCustomer());
            stmt.setDate(3, o.getDeliveryDate());
//            stmt.setString(3, new SimpleDateFormat("MM/dd/yyyy").format(o.getDeliveryDate()));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Order> getOrders() throws SQLException, ParseException {
        ArrayList<Order> orders = new ArrayList<>();

        try (Connection con = db.getConnection()) {
            String sql = "SELECT OrderNumber, Customer, DeliveryTime\n"
                    + "FROM Orders\n";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                long ordNum = rs.getLong("OrderNumber");
                String customer = rs.getString("Customer");
                Date delDate = rs.getDate("DeliveryTime");
                orders.add(new Order(ordNum, customer, delDate));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }
    
    public Order getOrderNumber(long orderID)
    {
        try (Connection con = db.getConnection()) {
            String sql = "SELECT OrderNumber, Customer, DeliveryTime FROM Orders where OrderNumber = ?;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, orderID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                long ordNum = rs.getLong("OrderNumber");
                String customer = rs.getString("Customer");
                Date delDate = rs.getDate("DeliveryTime");
                return new Order(ordNum, customer, delDate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void addWorker(Worker w) throws SQLException {
        try (Connection con = db.getConnection()) {
            String sql = "INSERT INTO Worker(Initials, WName, Salary) VALUES(?,?,?)\n";
            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setInt(1, w.getWorkerID());
            stmt.setString(1, w.getInitials());
            stmt.setString(2, w.getName());
            stmt.setInt(3, w.getSalary());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Worker> getAvailableWorkers() throws SQLException {
        ArrayList<Worker> workers = new ArrayList<>();
        try (Connection con = db.getConnection()) {
            String sql = "SELECT WorkerID, Initials, WName, Salary\n"
                    + "from Worker\n;";
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
            String sql = "INSERT INTO Department(DepName) VALUES(?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, d.getDepName());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Department> getDepartments() throws SQLException {
        ArrayList<Department> departments = new ArrayList<>();

        try (Connection con = db.getConnection()) {
            String sql = "SELECT DepID, DepName FROM Department;";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int depID = rs.getInt("DepID");
                String depName = rs.getString("DepName");
                departments.add(new Department(depID, depName));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departments;
    }
    
    public Department getDeparmentByName(String name)
    {
        try (Connection con = db.getConnection()) {
            String sql = "SELECT DepID, DepName FROM Department where DepName = ?;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int depID = rs.getInt("DepID");
                String depName = rs.getString("DepName");
               return new Department(depID, depName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void addDepTask(DepartmentTask dt) throws SQLException {
        try (Connection con = db.getConnection()) {
            String sql = "INSERT INTO OrderTask(OrderNumber, DepID, StartDate, EndDate, FinishedOrder) VALUES(?,?,?,?,?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, dt.getOrderNumber());
            stmt.setInt(2, dt.getDepID());
            stmt.setDate(3, dt.getStartDate());
            stmt.setDate(4, dt.getEndDate());
            stmt.setBoolean(5, dt.getIsFinished());
            stmt.executeUpdate();
        }
    }
    
    public List<DepartmentTask> getDepTasks() throws SQLServerException, SQLException, ParseException {
        ArrayList<DepartmentTask> departmentTasks = new ArrayList<>();
        try (Connection con = db.getConnection()) {
            String sql = "select * from OrderTask;";
                    //"SELECT OrderNumber, DepID, StartDate, EndDate, FinishedOrder\n"
                    //+ "from OrderTask\n;";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                long ordNum = rs.getLong("OrderNumber");
                int depID = rs.getInt("DepID");
//                int wID = rs.getInt("WorkerID");
                Date sDate = rs.getDate("StartDate");
                Date eDate = rs.getDate("EndDate");
                Boolean isFinish = rs.getBoolean("FinishedOrder");
                departmentTasks.add(new DepartmentTask(ordNum, depID, sDate, eDate, isFinish));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BelmanAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departmentTasks;
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
    //    public void updateOrders(Order o) throws SQLException {
////        ArrayList<Order> orders = new ArrayList<>();
//        try (Connection con = db.getConnection()) {
//            String sql = "UPDATE Orders SET OrderID = OrderID - 1;"; //UPDATE Orders SET OrderNumber = ? WHERE OrderID = ? AND OrderNumber = ?;
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setInt(1, o.getOrderID());
//            stmt.executeUpdate();
//        }
//    }
}
