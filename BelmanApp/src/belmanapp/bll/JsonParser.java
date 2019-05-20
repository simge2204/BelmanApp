/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.bll;

import belmanapp.JsonData;
import belmanapp.be.Department;
import belmanapp.be.DepartmentTask;
import belmanapp.be.Order;
import belmanapp.dal.DBConnection;
import belmanapp.dal.JsonDAO;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author simge
 */
public class JsonParser {
    
    JsonData data;
    JsonDAO jDAO;
    Order ord = new Order();
    Department dep;
    DBConnection db;
//    String connectionString = "jdbc:sqlserver://10.176.111.31:1433;database=BelmanAppDatabse;user=CS2018A_29;password=CS2018A_29";
    
    public JSONObject parseOrderObject(JSONObject order) throws java.text.ParseException{
        //Order
        JSONObject orderData = (JSONObject) order.get("Order");
        System.out.println(orderData.get("OrderNumber"));
        
        //Customer
        orderData = (JSONObject) order.get("Customer");        
        System.out.println(orderData.get("Name"));
//        System.out.println(((JSONObject) order.get("Customer")).get("Name"));
//        System.out.println(orderData);

        //DeliveryTime
        orderData = (JSONObject) order.get("Delivery");
        String dDate = (String) orderData.get("DeliveryTime").toString().substring(6, 19);//(20, 24);
        SimpleDateFormat dformatter = new SimpleDateFormat("dd-mm-yyyy");
        Date date = new Date();
        String formattedDate = dformatter.format(date);
        Date parsedDate = dformatter.parse(formattedDate);
//        JSONObject store = new JSONObject(response);
//        Integer datetimestamp = Integer.parseInt(date.replaceAll("/Date()/", ""));
//        Date dateD = new Date(datetimestamp);
//        DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
//        String dateFormatted = formatter.format(dateD);
//        LocalDate delD = LocalDate.parse(date);
//        Date delDate = new SimpleDateFormat("ddmmyyyy").parse(date);
        System.out.println(parsedDate);
        
        return orderData;
    }
    
    public JSONObject parseDepObject(JSONObject task) throws ParseException, java.text.ParseException
    {
        //DepartmentTask
        JSONObject taskData = (JSONObject) task.get("DepartmentTasks");
        System.out.println(((JSONObject) task.get("Department")).get("Name"));
        String sDate = (task.get("StartDate").toString().substring(6, 19));
        SimpleDateFormat sformatter = new SimpleDateFormat("dd-mm-yyyy");
        Date dateS = new Date();
        String formattedSDate = sformatter.format(dateS);
        Date parsedSDate = sformatter.parse(formattedSDate);
        System.out.println(parsedSDate);
//        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
//        Date date = (Date) format.parse(sDate);
//        DepartmentTask depTask = new DepartmentTask();
//        LocalDate date = LocalDate.parse(sDate, DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
//        depTask.setStartDate(Date.valueOf(date));
//        LocalDate date = LocalDate.parse(sDate, DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        String eDate = (task.get("EndDate").toString().substring(6, 19));
        SimpleDateFormat eformatter = new SimpleDateFormat("dd-mm-yyyy");
        Date dateE = new Date();
        String formattedEDate = eformatter.format(dateE);
        Date parsedEDate = eformatter.parse(formattedEDate);
        System.out.println(parsedEDate);
        System.out.println(task.get("FinishedOrder"));
        return taskData;
}
        
    public JSONObject parseWorkerObject(JSONObject worker)
    {
        JSONObject workerData = (JSONObject) worker.get("AvailableWorkers");
        System.out.println(worker.get("Initials"));
        System.out.println(worker.get("Name"));
        System.out.println(worker.get("SalaryNumber"));
        
        return workerData;
    }
    }