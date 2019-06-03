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
    public int orderID;
    public String orderNumber;
    public Date deliveryDate;
//    private String department;
//    public int customerID;
    public String customer;
    belmanapp.bll.BelmanAppManager BAManager;
    
    public Order(int id, String ordNum, String cName, Date delTime)
    {
        this.orderID = id;
        this.orderNumber = ordNum;
//        this.customerID = cID;
        this.customer = cName;
        this.deliveryDate = delTime;
    }

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

//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }

//    public int getCustomerID() {
//        return customerID;
//    }
//
//    public void setCustomerID(int customerID) {
//        this.customerID = customerID;
//    }
    
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", orderNumber=" + orderNumber + ", customer=" + customer + ", deliveryDate=" + deliveryDate + "}";
    }
}
