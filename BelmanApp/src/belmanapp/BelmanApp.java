/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp;

import belmanapp.be.Department;
import belmanapp.be.DepartmentTask;
import belmanapp.be.Order;
import belmanapp.be.Worker;
import belmanapp.bll.JsonParser;
import belmanapp.dal.BelmanAppDAO;
import belmanapp.dal.JsonDAO;
import belmanapp.gui.controller.MainController;
import belmanapp.gui.controller.OrderViewController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author simge
 */
public class BelmanApp extends Application {
    private Stage primaryStage;
    MainController mc;
    BelmanAppDAO bDAO = new BelmanAppDAO();
    Order o = new Order();
    Department d = new Department();
    Worker w = new Worker();
    DepartmentTask dt = new DepartmentTask();
    JsonParser jp = new JsonParser();
    OrderViewController ovc = new OrderViewController();

    public BelmanApp() throws java.text.ParseException {
        this.mc = new MainController();
    }
    
        @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage; // connect primary stage
        mainWindow();
    }
    
//      main window
    public void mainWindow() throws IOException, SQLException, FileNotFoundException, ParseException, java.text.ParseException {
            // view
            FXMLLoader loader = new FXMLLoader(BelmanApp.class.getClassLoader().getResource("belmanapp/gui/view/Main.fxml"));
            Parent root = (Parent)loader.load();

            // controller
            MainController mainWindowController = loader.getController();
            mainWindowController.setMain(this);

            // scene on stage
//            Scene scene = new Scene(root);
            primaryStage.setScene(new Scene(root));
//            stage.setScene(scene);
            primaryStage.show();
//            bDAO.addOrders(o);
            bDAO.getOrders();
//            bDAO.addWorker(w);
            bDAO.getAvailableWorkers();
//            bDAO.addDepartments(d);
            bDAO.getDepartments();
//            bDAO.addDepTask(dt);
            bDAO.getDepTasks();
            
//            ovc.doInBackground();
//            ovc.updateProgress();
    }
    
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        launch(args);
    }
}
