/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp;

import belmanapp.be.Order;
import belmanapp.dal.BelmanAppDAO;
import belmanapp.dal.JsonDAO;
import belmanapp.gui.controller.MainController;
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
    MainController mc = new MainController();
    private String ord;
    BelmanAppDAO bDAO = new BelmanAppDAO();
    
//    belmanapp.gui.controller.MainController getAllOrderNumbers;
    
//    @Override
//    public void start(Stage stage) throws IOException, Exception {
//        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();
//        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
////        FXMLLoader loader = new FXMLLoader(BelmanApp.class.getClassLoader().getResource("Main.fxml"));
////            AnchorPane pane = loader.load();
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();
//    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage; // connect primary stage
        mainWindow();
    }
    
     // main window
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
//            jDAO.createOrderNumbers(ord);
//            mc.getOrderNumbers(obj);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
