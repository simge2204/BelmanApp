/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.be;

import belmanapp.JsonData;
import belmanapp.bll.JsonParser;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONObject;

/**
 *
 * @author simge
 */
public class Order {
    private int orderID;
    private String orderNumber;
    private Date deliveryDate;
    private String department;
    private String customer;
    belmanapp.bll.BelmanAppManager BAManager;

    public Order() {
        
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    public String getOrderNumber()
    {
        return orderNumber;
    }
    
    public void setOrderNumber(String orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    @Override
    public String toString() {
        return "Order [orderID=" + orderID + ", deliveryDate=" + deliveryDate + ", customer=" + customer + "]";
    }
}
