/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.gui.controller;

import belmanapp.be.Department;
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
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;
import javax.swing.SwingWorker;

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
    public Label txtOrdNum;
    @FXML
    public Label txtCustomer;
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
    public Label txtDate;
    @FXML
    private TableView<Worker> workers;
    @FXML
    private TableColumn<Worker, String> workerNames;
    @FXML
    public Label startEP;
    @FXML
    public Label startRP;
    @FXML
    public Label endEP;
    @FXML
    public Label endRP;
    @FXML
    private TableColumn<DepartmentTask, Boolean> progress;
    @FXML
    private TableColumn<DepartmentTask, String> depNames;
    @FXML
    private TableView<DepartmentTask> Department;
        
    private Background GREEN;
    private DepartmentTask selectedOrder;
    belmanapp.gui.controller.MainController mainController;
    belmanapp.gui.model.BelmanAppModel BM = new BelmanAppModel();
    private Task task;
    final Float[] values = new Float[]{0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 1.0f};
    final Label[] labels = new Label[values.length];
    final ProgressBar[] pbs = new ProgressBar[values.length];

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
//        depID.setCellValueFactory(new PropertyValueFactory("DepartmentID"));
        depNames.setCellValueFactory(new PropertyValueFactory("DepName"));
        progress.setCellValueFactory(new PropertyValueFactory("FinishedOrder"));
        Department.setItems(BM.getDepName());
        try {
            BM.loadDepNames();
        } catch (SQLException ex) {
            Logger.getLogger(OrderViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(OrderViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        selectedOrder.setProgressE(0);
//        selectedOrder.progressProperty().addListener(new javafx.beans.value.ChangeListener<Object>() {
//            @Override
//            public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
//                realizedP.progressProperty().bind(selectedOrder.progressProperty());
//            }
//        });
    }

    public void viewOrderInfo() throws SQLException, SQLServerException, SQLServerException, ParseException, ParseException
    {
//        String number = new SimpleDateFormat("MM/dd/yyyy").format(selectedOrder.getOrderNumber());
//        txtOrdNum.setUserData(number);
//        String cname = selectedOrder.getCustomer();
//        txtCustomer.setText(cname);
//        String delDate = selectedOrder.getDeliveryDate().toString();
//        SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy");
//        String dd = s.format(selectedOrder.getDeliveryDate().toString());
//        txtDate.setText(dd);
//        txtDate.getText();
        
//        SimpleDateFormat dts = new SimpleDateFormat(String.valueOf(selectedOrder.getDeliveryDate()));
//        DateFormat sformatter = new SimpleDateFormat("DD-MM-YYYY");
//        String dateSFormatted = sformatter.format(dts);
//        txtDate.setText(dateSFormatted);
        
//        String sd = new SimpleDateFormat("MM/dd/yyyy").format(selectedOTask.getStartDate());
//        startEP.setUserData(sd);
        
    }
    
    public void setMainController(MainController mainController)
    {
        this.mainController = mainController;
    }

    //Knappen "Færdig", hvilket har funktionen at markere afdelingen som færdig med opgaven, samt at vise dette til de andre afdelinger
//    private void clickDone(MouseEvent event) {
//        if(taskDone.isPressed())
//        {
//            progress.setText("Done");
//            taskDone.backgroundProperty().setValue(GREEN);
//        }
//    }
    
//    public void doInBackground()
//    {
//            Random random = new Random();
//            int progress = 0;
//            //Initialize progress property.
//            selectedOrder.setProgressR(0);
//            while (progress < 100) {
//                //Sleep for up to one second.
//                try {
//                    Thread.sleep(random.nextInt(1000));
//                } catch (InterruptedException ignore) {}
//                //Make random progress.
//                progress += random.nextInt(10);
//                selectedOrder.setProgressR(Math.min(progress, 100));
//            }
//    }
//    
//    public void updateProgress() {
//        realizedP = new ProgressBar(0.7);
//        for (int i = 0; i < values.length; i++) {
//            final Label label = labels[i] = new Label();
//            label.setText("progress:" + values[i]);
// 
//            realizedP = pbs[i] = new ProgressBar();
//            realizedP.setProgress(values[i]);
////        realizedP = new ProgressBar();
////        realizedP.setProgress(0);
////        realizedP.setVisible(true);//StringPainted(true);
//    }
//    }
    
    public void updateGUI()
    {
        
    }
    
    public void setOrderView(DepartmentTask selectedOrder)
    {
        this.selectedOrder = selectedOrder;
    }

    @FXML
    private void clickDone(ActionEvent event) {
        selectedOrder.setProgressE(selectedOrder.progressProperty().doubleValue() + 0.1);
        if(taskDone.isPressed())
        {
            progress.setText("Done");
            taskDone.backgroundProperty().setValue(GREEN);
        }
    }
}
