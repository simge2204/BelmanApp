/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.gui.controller;

import belmanapp.BelmanApp;
import belmanapp.be.Order;
import belmanapp.JsonData;
import belmanapp.bll.BelmanAppManager;
import belmanapp.bll.JsonParser;
import belmanapp.gui.model.BelmanAppModel;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
    private TableView<Order> orderView;
    @FXML
    private TableColumn<JsonData, Date> startDate;
    @FXML
    private TableColumn<JsonData, Date> endDate;
    @FXML
    private TableColumn<JsonData, String> customer;
    @FXML
    private TableColumn<JsonData, Boolean> finishedOrder;
    @FXML
    private Button viewOrder;
    @FXML
    private Button viewSchedule;
    
    //    belmanapp.be.Order order = new belmanapp.be.Order();
    JsonParser jp = new JsonParser();
    belmanapp.be.Order order = null;
    JsonData jd = new JsonData();
    private Order orderID;
    belmanapp.gui.model.BelmanAppModel BM = new BelmanAppModel();
    Order selectedOrder;

    // connect main class to controller
    public void setMain(BelmanApp main) {
        this.main = main; 
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        orderNumber.setCellValueFactory(data -> data.getValue().getOrderID());
        orderNumber.setCellValueFactory(new PropertyValueFactory("OrderNumber"));
        startDate.setCellValueFactory(new PropertyValueFactory("StartDate"));
        endDate.setCellValueFactory(new PropertyValueFactory("EndDate"));
//        orderView.setItems(orderNumbers);
        orderView.setItems(BM.getOrderNumbers());
        try {
            BM.loadOrdNumbers();
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    //Liste af ordrenumre, fra JSON filen
//    private ObservableList<Order> orderNumbers = FXCollections.observableArrayList(
//            
//    );
    
    public ObservableList<Order> getOrderNumbers(JSONObject obj) throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException {
//        orderID = jp.parseOrderObject(orderList);     
        
        List list = new ArrayList<>();
        
        if (orderNumber == null) {
            list.add(jp.parseOrderObject(obj));

            System.out.println(orderNumber.getColumns().addAll(list));
            ObservableList data = FXCollections.observableList(list);
            return data;
        }
        return getOrderNumbers(obj);
    }
//        @SuppressWarnings("unchecked")
//        JSONParser jsonParser = new JSONParser();
//         
//        try (FileReader reader = new FileReader("C:/Github2/Data and interface - Belman v1/data.json"))
//        {
//            //Read JSON file
//            Object obj = jsonParser.parse(reader);
// 
//            JSONObject employeeList = (JSONObject) obj;
//            JSONArray orders = (JSONArray) employeeList.get("ProductionOrders");
//            orders.forEach( order -> parseOrderObject( (JSONObject) order ));
////            {JSONObject orderData = (JSONObject) order.get("Order");
////        
////        System.out.println(orderData.get("OrderNumber"));
////            });
//    }
//        return getAllOrderNumbers();
//    }
//    
//    private void parseOrderObject(JSONObject order)
//    {
//        ObservableList<Integer> numb;
//        
//        JSONObject orderData = (JSONObject) order.get("Order");
//        
//        System.out.println(orderData.get("OrderNumber"));
//        orderNumber.getColumns().setAll(orderData.values());
//    }   

    @FXML
    private void openOrderView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("belmanapp/gui/view/OrderView.fxml"));
        Parent root2 = (Parent) loader.load();
        Stage stage = new Stage();
        belmanapp.gui.controller.OrderViewController OVController = loader.getController();
        OVController.setOrderView(order);
        OVController.setMainController(this);
        selectedOrder = orderView.getSelectionModel().getSelectedItem();
        stage.setTitle("Order View");
        stage.setScene(new Scene(root2));
        stage.show();
    }

    @FXML
    private void openScheduleView(ActionEvent event) {
    }
}
