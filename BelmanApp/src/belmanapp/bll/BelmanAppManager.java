/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.bll;

import belmanapp.JsonData;
import belmanapp.be.Department;
import belmanapp.be.DepartmentTask;
import belmanapp.be.Order;
import belmanapp.be.Worker;
import belmanapp.dal.BelmanAppDAO;
import belmanapp.dal.DBConnection;
import belmanapp.dal.JsonDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import org.json.simple.JSONObject;

/**
 *
 * @author simge
 */
public class BelmanAppManager {
    private double progress;
    belmanapp.dal.BelmanAppDAO dao = new BelmanAppDAO();
    belmanapp.dal.JsonDAO jdao = new JsonDAO();
    DBConnection db = new DBConnection();

//    public BelmanAppManager() throws ParseException {
//        this.dao = new BelmanAppDAO();
//    }
    
//    public void addOrders(Order o) throws SQLException, SQLException, SQLServerException, SQLServerException, ParseException
//    {
//        dao.addOrders(o);
//    }
    
//    public List<Order> getOrders() throws SQLException, ParseException {
//        return dao.getOrders();
//    }
    
    public List<Worker> getAvailableWorkers() throws ParseException, SQLServerException, SQLException
    {
        return dao.getAvailableWorkers();
    }
    
//    public List<Department> getDepartments() throws SQLException
//    {
//        return dao.getDepartments();
//    }
    
    public List<DepartmentTask> getDepTasks() throws SQLException, SQLServerException, ParseException
    {
        return dao.getDepTasks();
    }
    
    public void addDeptasks(DepartmentTask dt) throws SQLException
    {
        dao.addDepTask(dt);
    }
    
    public void addWorkers(Worker w) throws SQLException
    {
        dao.addWorker(w);
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
