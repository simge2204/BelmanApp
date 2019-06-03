/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.gui.controller;

import belmanapp.BelmanApp;
import belmanapp.be.Order;
import belmanapp.JsonData;
import belmanapp.be.DepartmentTask;
import belmanapp.bll.BelmanAppManager;
import belmanapp.bll.JsonParser;
import belmanapp.dal.JsonDAO;
import belmanapp.gui.model.BelmanAppModel;
import com.microsoft.sqlserver.jdbc.SQLServerException;
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
    private TableColumn<Order, String> orderNumber;
    private belmanapp.BelmanApp main;
    @FXML
    private TableView<Order> orderView;
    @FXML
    private TableColumn<Order, String> customer;
    @FXML
    private Button viewOrder;
    @FXML
    private Button viewSchedule;
    
    //    belmanapp.be.Order order = new belmanapp.be.Order();
    JsonParser jp = new JsonParser();
    belmanapp.be.Order order = new Order();
    belmanapp.be.DepartmentTask depTask = new DepartmentTask();
    JsonData jd = new JsonData();
    Order o;
    belmanapp.gui.model.BelmanAppModel BM = new BelmanAppModel();
    Order selectedOrder;
    DepartmentTask selectedOTask;
    JsonDAO jDAO;
    @FXML
    private TableColumn<Order, Integer> orderID;
    @FXML
    private TableColumn<Order, Date> deliveryTime;

    public MainController() throws java.text.ParseException {
        this.jDAO = new JsonDAO();
    }

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
//        startDate.setCellValueFactory(new PropertyValueFactory("StartDate"));
//        endDate.setCellValueFactory(new PropertyValueFactory("EndDate"));
        customer.setCellValueFactory(new PropertyValueFactory("Customer"));
        orderID.setCellValueFactory(new PropertyValueFactory("OrderID"));
        deliveryTime.setCellValueFactory(new PropertyValueFactory("DeliveryDate"));
//        finishedOrder.setCellValueFactory(new PropertyValueFactory("FinishedOrder"));
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
    
//    public List<Order> getOrders() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException {
////        orderID = jp.parseOrderObject(orderList);     
//        
//        ArrayList list = new ArrayList<>();
////        ordNum = jp.parseOrderObject(order).toString();
////        o.orderNumber = ordNum;
////        orderView.getItems().addAll(elements)
////        if (orderNumber == null) {
////            list.add(ordNum);
//
//            System.out.println(orderNumber.getColumns().addAll(list));
//            List data = FXCollections.observableList(list);
//            return data;
//        }   

    @FXML
    private void openOrderView(ActionEvent event) throws IOException, SQLException, SQLServerException, java.text.ParseException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("belmanapp/gui/view/OrderView.fxml"));
        Parent root2 = (Parent) loader.load();
        Stage stage = new Stage();
        belmanapp.gui.controller.OrderViewController OVController = loader.getController();
        selectedOrder = orderView.getSelectionModel().getSelectedItem();
        OVController.setOrderView(order,depTask);
        OVController.setMainController(this);
        stage.setTitle("Order View");
        stage.setScene(new Scene(root2));
        stage.show();
    }

    @FXML
    private void openScheduleView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("belmanapp/gui/view/OrderView.fxml"));
        Parent root2 = (Parent) loader.load();
        Stage stage = new Stage();
//        belmanapp.gui.controller.OrderViewController OVController = loader.getController();
//        OVController.setOrderView(order);
//        OVController.setMainController(this);
//        selectedOrder = orderView.getSelectionModel().getSelectedItem();
//        stage.setTitle("Order View");
//        stage.setScene(new Scene(root2));
//        stage.show();
    }
}
