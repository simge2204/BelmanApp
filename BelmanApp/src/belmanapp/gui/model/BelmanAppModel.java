/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.gui.model;

import belmanapp.be.Order;
import java.sql.SQLException;
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
    private SimpleStringProperty activeWorker;
    private SimpleStringProperty depName;
    private ObservableList<Order> orderID = FXCollections.observableArrayList();
    belmanapp.bll.BelmanAppManager BAManager = new belmanapp.bll.BelmanAppManager();


    public SimpleStringProperty getActiveWorker() {
        return activeWorker;
    }

    public void setActiveWorker(SimpleStringProperty activeWorker) {
        this.activeWorker = activeWorker;
    }

    public SimpleStringProperty getDepName() {
        return depName;
    }

    public void setDepName(SimpleStringProperty depName) {
        this.depName = depName;
    }
    
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
}
