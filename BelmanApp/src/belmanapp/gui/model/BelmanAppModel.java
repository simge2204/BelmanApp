/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.gui.model;

import belmanapp.be.DepartmentTask;
import belmanapp.be.Order;
import belmanapp.be.Worker;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONObject;

/**
 *
 * @author simge
 */
public class BelmanAppModel {
    private ObservableList<Worker> activeWorker = FXCollections.observableArrayList();
    private ObservableList<DepartmentTask> depName = FXCollections.observableArrayList();
    private ObservableList<Order> orderID = FXCollections.observableArrayList();
    belmanapp.bll.BelmanAppManager BAManager;

    public BelmanAppModel() throws ParseException {
        this.BAManager = new belmanapp.bll.BelmanAppManager();
    }

    public ObservableList<DepartmentTask> getDepName() {
        return depName;
    }
    
    public void loadDepNames() throws SQLException
    {
        List<DepartmentTask> loadedDepNames = BAManager.getDepTasks();
        
        depName.clear();
        depName.addAll(loadedDepNames);
    }

//    public void setDepName(SimpleStringProperty depName) {
//        this.depName = depName;
//    }
    
    public ObservableList<Order> getOrderNumbers()
    {
        return orderID;
    }
    
    public void loadOrdNumbers() throws SQLException
    {
        List<Order> loadedNumbers = BAManager.getOrders();

        orderID.clear();
        orderID.addAll(loadedNumbers);
    }
    
    public ObservableList<Worker> getActiveWorker() {
        return activeWorker;
    }
    
    public void loadWorkers() throws ParseException, SQLException
    {
        List<Worker> loadedWorkers = BAManager.getAvailableWorkers();
        
        activeWorker.clear();
        activeWorker.addAll(loadedWorkers);
    }

//    public void setActiveWorker(SimpleStringProperty activeWorker) {
//        this.activeWorker = activeWorker;
//    }
    
    public void addOrders(Order o) throws SQLException, SQLException, SQLServerException, ParseException, ParseException
    {
        BAManager.addOrders(o);
    }
    
    public void addDepTasks(DepartmentTask dt) throws SQLException
    {
        BAManager.addDeptasks(dt);
    }
    
    public void addWorkers(Worker w) throws SQLException
    {
        BAManager.addWorkers(w);
    }
}
