/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.gui.controller;

import belmanapp.be.DepartmentTask;
import belmanapp.be.Order;
import belmanapp.be.Worker;
import belmanapp.bll.BelmanAppManager;
import belmanapp.gui.model.BelmanAppModel;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.awt.Color;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javax.swing.event.ChangeListener;

/**
 * FXML Controller class
 *
 * @author simge
 */
public class OrderViewController implements Initializable {

    @FXML
    private Label orderNumber;
    @FXML
    private Label customer;
    @FXML
    private Label deliveryDate;
    @FXML
    private Label txtOrdNum;
    @FXML
    private Label txtCustomer;
    @FXML
    private AnchorPane orderInfo;
    @FXML
    private AnchorPane progressView;
    @FXML
    private AnchorPane departments;
    @FXML
    private AnchorPane availableWorkers;
    @FXML
    private Button taskDone;
    @FXML
    private ProgressBar estimatedP;
    @FXML
    private ProgressBar realizedP;
    @FXML
    private Label txtDate;
    @FXML
    private TableView<Worker> workers;
    @FXML
    private TableColumn<Worker, String> workerNames;
    @FXML
    private Label startEP;
    @FXML
    private Label startRP;
    @FXML
    private Label endEP;
    @FXML
    private Label endRP;
    
    private Background GREEN;
    private Order selectedOrder;
    private DepartmentTask selectedOTask;
    belmanapp.gui.controller.MainController mainController;
    belmanapp.gui.model.BelmanAppModel BM = new BelmanAppModel();
    @FXML
    private Label progress1;
    @FXML
    private Label progress2;
    @FXML
    private Label progress3;
    @FXML
    private Label progress4;
    @FXML
    private Label progress5;
    @FXML
    private Label progress6;
    @FXML
    private Label progress7;

    public OrderViewController() throws ParseException {
        this.mainController = new MainController();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        workerNames.setCellValueFactory(new PropertyValueFactory("WName"));
        workers.setItems(BM.getActiveWorker());
        try {
            BM.loadWorkers();
        } catch (ParseException ex) {
            Logger.getLogger(OrderViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public void viewOrderInfo() throws SQLException, SQLServerException, SQLServerException, ParseException, ParseException
//    {
//        String number = txtOrdNum.getText();
//        selectedOrder.setOrderNumber(number);
//    }
    
    public void setMainController(MainController mainController)
    {
        this.mainController = mainController;
    }

    //Knappen "Færdig", hvilket har funktionen at markere afdelingen som færdig med opgaven, samt at vise dette til de andre afdelinger
    @FXML
    private void clickDone(MouseEvent event) {
        if(taskDone.isPressed())
        {
            taskDone.backgroundProperty().setValue(GREEN);
        }
    }
    
//    public List<String> getAvailableWorkers()
//    {
//        
//    }
//    
//    public Order calculateProgress()
//    {
//        realizedP = new ProgressBar(0);
//        ProgressIndicator prog = new ProgressIndicator(0);
//    }
    
    public void updateProgress()
    {

    }
    
    public void updateGUI()
    {
        
    }
    
    public void setOrderView(Order selectedOrder, DepartmentTask selectedOTask)
    {
        this.selectedOrder = selectedOrder;
        this.selectedOTask = selectedOTask;
        String number = selectedOrder.getOrderNumber();
        txtOrdNum.setText(number);
        String cName = selectedOrder.getCustomer();
        txtCustomer.setText(cName);
//        String delDate = selectedOrder.getDeliveryDate().toString();
//        txtDate.setText(delDate);
    }
}
