/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.gui.controller;

import belmanapp.BelmanApp;
import belmanapp.be.Order;
import belmanapp.dal.jsonData;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * FXML Controller class
 *
 * @author simge
 */
public class MainController implements Initializable{

    @FXML
    private TableColumn<Order, JSONObject> orderNumber;
    private BelmanApp main;
    @FXML
    private TableView<?> orderView;
    @FXML
    private TableColumn<?, ?> startDate;
    @FXML
    private TableColumn<?, ?> endDate;

    // connect main class to controller
    public void setMain(BelmanApp main) {
        this.main = main; 
    }

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //Liste af ordre numre, fra JSON filen
    public List<Integer> getAllOrderNumbers() throws FileNotFoundException, IOException, ParseException
    {
//        @SuppressWarnings("unchecked")
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("C:/Github2/Data and interface - Belman v1/data.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONObject employeeList = (JSONObject) obj;
            JSONArray orders = (JSONArray) employeeList.get("ProductionOrders");
            orders.forEach( order -> parseOrderObject( (JSONObject) order ));
//            {JSONObject orderData = (JSONObject) order.get("Order");
//        
//        System.out.println(orderData.get("OrderNumber"));
//            });
    }
        return getAllOrderNumbers();
    }
    
    private void parseOrderObject(JSONObject order)
    {
        ObservableList<Integer> numb;
        
        JSONObject orderData = (JSONObject) order.get("Order");
        
        System.out.println(orderData.get("OrderNumber"));
        orderNumber.getColumns().setAll(orderData.values());
    }   
}
