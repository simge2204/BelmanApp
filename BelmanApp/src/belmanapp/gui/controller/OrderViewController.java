/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.gui.controller;

import belmanapp.be.Order;
import java.awt.Color;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
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
    private Label delDate;
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
    
    private Background GREEN;
    @FXML
    private ProgressBar estimatedP;
    @FXML
    private ProgressBar realizedP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
}
