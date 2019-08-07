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
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
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

    static BelmanAppDAO DAO = new BelmanAppDAO();

    // @SuppressWarnings("unchecked")
    public static void main(String[] args) throws SQLServerException, SQLException, IOException, FileNotFoundException, ParseException, java.text.ParseException {
//        Order o = new Order();
//        DepartmentTask dt = new DepartmentTask();
//        Worker w = new Worker();
        parseOrders();
        parseWorkers();
    }

    public static void parseOrders() throws FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException, SQLServerException, java.text.ParseException {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("C:/Github2/Data and interface - Belman v1/data.json")) {
//            JsonParser jdata = new JsonParser();

            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject orderList = (JSONObject) obj;

            JSONArray orders = (JSONArray) orderList.get("ProductionOrders");
            System.out.println(orders);
            for (Object order : orders.toArray()) {
                JSONObject po = (JSONObject) order;

                String dDate = String.valueOf(((JSONObject) po.get("Delivery")).get("DeliveryTime").toString().substring(6, 19));//(20, 24);
                LocalDate deliveryDate = Instant.ofEpochMilli(Long.valueOf(dDate)).atZone(ZoneId.systemDefault()).toLocalDate();
                java.sql.Date sqlDate = java.sql.Date.valueOf(deliveryDate);

                long ordnum = Long.valueOf(((JSONObject) po.get("Order")).get("OrderNumber").toString().replace("-", ""));
                String cname = (((JSONObject) po.get("Customer")).get("Name").toString());
                Order oNum = DAO.getOrderNumber(ordnum);
                if (oNum == null) {
                    DAO.addOrders(new Order(ordnum, cname, sqlDate));
                    oNum = DAO.getOrderNumber(ordnum);
                }
                Order o = new Order(oNum.getOrderNumber(), cname, sqlDate);
                try {
                    DAO.addOrders(o);
                } catch (SQLException ex) {
                    Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
                } catch (java.text.ParseException ex) {
                    Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
                }

                JSONArray tasks = (JSONArray) po.get("DepartmentTasks");
                System.out.println(tasks);
                for (Object dtasks : tasks) {
                    JSONObject task = (JSONObject) dtasks;
                    JSONObject dt = (JSONObject) task;
                    String sDate = (dt.get("StartDate").toString().substring(6, 19));
                    LocalDate startDate = Instant.ofEpochMilli(Long.valueOf(sDate)).atZone(ZoneId.systemDefault()).toLocalDate();
                    java.sql.Date sqlSDate = java.sql.Date.valueOf(startDate);
                    String eDate = (dt.get("EndDate").toString().substring(6, 19));
                    LocalDate endDate = Instant.ofEpochMilli(Long.valueOf(eDate)).atZone(ZoneId.systemDefault()).toLocalDate();
                    java.sql.Date sqlEDate = java.sql.Date.valueOf(endDate);

                    String dname = (((JSONObject) dt.get("Department")).get("Name").toString());
                    boolean isfinish = (boolean) dt.get("FinishedOrder");
                    Department d = DAO.getDeparmentByName(dname);
                    if (d == null) {
                        try {
                            DAO.addDepartments(new Department(-1, dname));
                        } catch (SQLException ex) {
                            Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        d = DAO.getDeparmentByName(dname);
                    }
                    DepartmentTask depTask = new DepartmentTask(ordnum, d.getDepID(), sqlSDate, sqlEDate, isfinish);
                    try {
                        DAO.addDepTask(depTask);
                    } catch (SQLException ex) {
                        Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
                    }
//                catch (SQLException ex) {
//                            Logger.getLogger(JsonData.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                });
            }
            }
        }
    }

    public static void parseWorkers() throws FileNotFoundException, IOException, ParseException, SQLException {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("C:/Github2/Data and interface - Belman v1/data.json")) {
//            JsonParser jdata = new JsonParser();
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject workerList = (JSONObject) obj;
            JSONArray workers = (JSONArray) workerList.get("AvailableWorkers");

            System.out.println(workers);

            for (Object worker : workers) {
                JSONObject work = (JSONObject) worker;
                String wname = (String) work.get("Name");
                String initial = (String) work.get("Initials");
                long salary = (long) work.get("SalaryNumber");
                Worker w = new Worker(initial, wname, (int) salary);
                DAO.addWorker(w);
            }
        }
    }
}
//                orderList.put("Name", tasks);
//                orderList.put("StartDate", tasks);
//                orderList.put("FinishedOrder", tasks);
//                orderList.put("EndDate", tasks);