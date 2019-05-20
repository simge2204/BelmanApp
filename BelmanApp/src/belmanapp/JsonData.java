/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp;

import belmanapp.be.Order;
import belmanapp.bll.JsonParser;
import belmanapp.dal.DBConnection;
import belmanapp.dal.JsonDAO;
import belmanapp.gui.controller.MainController;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
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

    static DBConnection db;
    static Order o;
    static JsonDAO jDAO = new JsonDAO();

    // @SuppressWarnings("unchecked")
    public static void main(String[] args) throws SQLServerException, SQLException, IOException, FileNotFoundException, ParseException {
        parseOrder();
        parseDepartment();
        parseWorker();

        //JSON parser object to parse read file
//        JSONParser jsonParser = new JSONParser();
//
//        try (FileReader reader = new FileReader("C:/Github2/Data and interface - Belman v1/data.json")) {
//            JsonParser jdata = new JsonParser();
//            //Read JSON file
//            Object obj = jsonParser.parse(reader);

//            JSONObject orderList = (JSONObject) obj;
//            JSONArray orders = (JSONArray) orderList.get("ProductionOrders");
//
//            System.out.println(orders);
//
//            //Iterate over order array
//            orders.forEach(order -> {
//                try {
//                    jdata.parseOrderObject((JSONObject) order);
//                } catch (java.text.ParseException ex) {
//                    Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            });
////            jDAO.createOrders(0, ordNum, customer, delivery);
//            jDAO.addOrders(jdata, o);
//            jDAO.getOrders();
            
//            JSONObject taskList = (JSONObject) obj;
//            JSONArray task = (JSONArray) taskList.get("DepartmentTasks");
//            System.out.println(task);
//            
//            task.forEach(tasks -> {
//                try {
//                    jdata.parseOrderObject((JSONObject) tasks);
//                } catch (java.text.ParseException ex) {
//                    Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            });
 
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException ex) {
//            Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public static void parseOrder() throws FileNotFoundException, IOException, ParseException
    {
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
                    jdata.parseOrderObject((JSONObject) order);
                } catch (java.text.ParseException ex) {
                    Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
////            jDAO.createOrders(0, ordNum, customer, delivery);
//            jDAO.addOrders(jdata, o);
//            jDAO.getOrders();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void parseDepartment() {
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
                    System.out.println(task);

                    tasks.forEach(dtask -> {
                        try {
                            jdata.parseDepObject((JSONObject) dtask);
                        } catch (ParseException ex) {
                            Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (java.text.ParseException ex) {
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
        
    public static void parseWorker()
    {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("C:/Github2/Data and interface - Belman v1/data.json")) {
            JsonParser jdata = new JsonParser();
            //Read JSON file
            Object obj = jsonParser.parse(reader);
        JSONObject workerList = (JSONObject) obj;
            JSONArray workers = (JSONArray) workerList.get("AvailableWorkers");

            System.out.println(workers);

            workers.forEach(worker -> {
                jdata.parseWorkerObject((JSONObject) worker);
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
