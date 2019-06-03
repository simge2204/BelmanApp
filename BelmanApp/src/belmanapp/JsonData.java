/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp;

import belmanapp.be.DepartmentTask;
import belmanapp.be.Order;
import belmanapp.be.Worker;
import belmanapp.bll.JsonParser;
import belmanapp.dal.BelmanAppDAO;
import belmanapp.dal.DBConnection;
import belmanapp.dal.JsonDAO;
import belmanapp.gui.controller.MainController;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author simge
 */
public class JsonData {

    static Order o = new Order();
    static JsonDAO jDAO = new JsonDAO();
    static BelmanAppDAO DAO = new BelmanAppDAO();
//    static JsonParser jp = new JsonParser();
//    static DepartmentTask dt = new DepartmentTask();
//    static Worker w = new Worker();

    // @SuppressWarnings("unchecked")
    public static void main(String[] args) throws SQLServerException, SQLException, IOException, FileNotFoundException, ParseException, java.text.ParseException {
//        Order o = new Order();
        DepartmentTask dt = new DepartmentTask();
        Worker w = new Worker();
        parseOrder();
//        jDAO = new JsonDAO();
//        jDAO.Orders(0, ordNum, deliveryDate, ordNum, order);
        DAO.addOrders(o);
        DAO.getOrders();
        parseDepTask();
        DAO.addDepTasks(dt);
        parseWorker();
        DAO.addWorkers(w);
    }
    
    public static void parseOrder() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException, SQLServerException, java.text.ParseException
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("C:/Github2/Data and interface - Belman v1/data.json")) {
            JsonParser jdata = new JsonParser();
            
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject orderList = (JSONObject) obj;
            JSONArray orders = (JSONArray) orderList.get("ProductionOrders");
            System.out.println(orders);

            //Iterate over order array
            orders.forEach(order -> {
                try {
                    o = jdata.parseOrderObject((JSONObject) order);
                    DAO.addOrders(o);
                } catch (java.text.ParseException ex) {
                    Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void parseDepTask() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("C:/Github2/Data and interface - Belman v1/data.json")) {
            JsonParser jdata = new JsonParser();
            Object obj = jsonParser.parse(reader);

            JSONObject orderList = (JSONObject) obj;
            
            //Read JSON file
             JSONArray orders = (JSONArray) orderList.get("ProductionOrders");
            for (Object dObj : orders.toArray()) {
                JSONObject taskList = (JSONObject) dObj;
                JSONArray tasks = (JSONArray) taskList.get("DepartmentTasks");
                for (Object dtasks : tasks.toArray()) {
                    JSONObject task = (JSONObject) dtasks;
                    System.out.println(tasks);

                    tasks.forEach(dtask -> {
                        try {
                            DepartmentTask dt = jdata.parseDepObject((JSONObject) dtask);
                            DAO.addDepTasks(dt);
                        } catch (ParseException ex) {
                            Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (java.text.ParseException ex) {
                            Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public static void parseWorker() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("C:/Github2/Data and interface - Belman v1/data.json")) {
            JsonParser jdata = new JsonParser();
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject workerList = (JSONObject) obj;
            JSONArray workers = (JSONArray) workerList.get("AvailableWorkers");

            System.out.println(workers);

            workers.forEach(worker -> {
                try {
                    Worker w = jdata.parseWorkerObject((JSONObject) worker);
                   DAO.addWorkers(w);
                } catch (SQLException ex) {
                    Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
