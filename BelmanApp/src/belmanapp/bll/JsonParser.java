/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.bll;

import belmanapp.be.Department;
import belmanapp.be.DepartmentTask;
import belmanapp.be.Order;
import belmanapp.be.Worker;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author simge
 */
public class JsonParser {
    
    public Order parseOrderObject(JSONObject order) throws java.text.ParseException, ParseException{
        Order o = new Order();
//        DepartmentTask dt = new DepartmentTask();
        
        //Order
//        JSONObject orderData = (JSONObject) order.get("Order");
//        System.out.println(orderData.get("OrderNumber"));
        String ordNum = (String) order.get("OrderNumber").toString().replace("-", "");
        long ord = Integer.parseInt(ordNum);
        System.out.println(ord);
//        o.setOrderNumber(ord);
        
        if(ord != o.getOrderNumber())
        {
             o.setOrderNumber(ord);
        }
        else if(ord == o.getOrderNumber())
        {
            o.getOrderNumber();
        }
        
        //Customer
//        JSONObject orderData = (JSONObject) order.get("Customer");
//        System.out.println(orderData.get("Name"));
////        System.out.println(((JSONObject) order.get("Customer")).get("Name"));
//        o.setCustomer(orderData.get("Name").toString());

//        if( != o.getOrderNumber())
//        {
//             o.setOrderNumber(ord);
//        }
//        else
//        {
//            o.getOrderNumber();
//        }
        
        //DeliveryTime
//        orderData = (JSONObject) order.get("Delivery");
//        String dDate = (String) orderData.get("DeliveryTime").toString().substring(6, 19);//(20, 24);
//        LocalDate deliveryDate = Instant.ofEpochMilli(Long.valueOf(dDate)).atZone(ZoneId.systemDefault()).toLocalDate();
//        
//        Date dtd = new Timestamp(Long.valueOf(dDate));
//        DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
//        String dateFormatted = formatter.format(dtd);
//        System.out.println(deliveryDate);
//        
//        java.sql.Date sqlDate = java.sql.Date.valueOf(deliveryDate);
//        
//        o.setDeliveryDate(sqlDate);//(java.sql.Date) orderData.get("DeliveyTime"));
//        
        return o;
    }
    
    public DepartmentTask parseDepObject(JSONObject task) throws ParseException, java.text.ParseException
    {
        DepartmentTask dt = new DepartmentTask();
        Department d = new Department();
        
//        JSONObject taskData = (JSONObject) task.get("DepartmentTasks");
        
        JSONObject taskData = (JSONObject) task.get("Department");
        System.out.println(taskData.get("Name"));
        d.setDepName(taskData.get("Name").toString());
        
        String sDate = (task.get("StartDate").toString().substring(6, 19));  
        LocalDate startDate = Instant.ofEpochMilli(Long.valueOf(sDate)).atZone(ZoneId.systemDefault()).toLocalDate();
        
        Date dts = new Timestamp(Long.valueOf(sDate));
        DateFormat sformatter = new SimpleDateFormat("dd-mm-yyyy");
        String dateSFormatted = sformatter.format(dts);
        
        java.sql.Date sqlSDate = java.sql.Date.valueOf(startDate);
        System.out.println(sqlSDate);
        
        dt.setStartDate(sqlSDate);

        String eDate = (task.get("EndDate").toString().substring(6, 19));
        LocalDate endDate = Instant.ofEpochMilli(Long.valueOf(eDate)).atZone(ZoneId.systemDefault()).toLocalDate();
        
        Date dte = new Timestamp(Long.valueOf(eDate));
        DateFormat eformatter = new SimpleDateFormat("dd-mm-yyyy");
        String dateEFormatted = eformatter.format(dte);
        
        java.sql.Date sqlEDate = java.sql.Date.valueOf(endDate);
        System.out.println(sqlEDate);
        
        dt.setEndDate(sqlEDate);
        
        boolean isFinished = (Boolean) task.get("FinishedOrder");
        System.out.println(isFinished); //System.out.println(task.get("FinishedOrder"));
        dt.setIsFinished(isFinished); //(String) taskData.get("FinishedOrder")
        
        return dt;
}
        
    public Worker parseWorkerObject(JSONObject worker)
    {
        Worker w = new Worker();
        JSONObject workerData = (JSONObject) worker.get("AvailableWorkers");
        
        String initials = (String) worker.get("Initials");
//        System.out.println(initials); //System.out.println(worker.get("Initials"));
//        w.setInitials(initials); //workerData.get("Initials").toString()
        if(initials != w.getInitials())
        {
             w.setInitials(initials);
        }
        
        String name = (String) worker.get("Name");
//        System.out.println(name); //System.out.println(worker.get("Name"));
//        w.setName(name); //workerData.get("Name").toString()
        if(name != w.getName())
        {
             w.setName(name);
        }
        
        long salary = (long) worker.get("SalaryNumber");
//        System.out.println(salary); //System.out.println(worker.get("SalaryNumber"));
//        w.setSalary((int) salary); //(int) workerData.get("SalaryNumber")
        if(salary != w.getSalary())
        {
             w.setSalary((int)salary);
        }
        
        return w;
    }
    }

//        //Departments
//        orderData = (JSONObject) order.get("Department");
//        System.out.println(orderData.get("Name")); //(taskData.get("Name"));
//        dt.setDepName(orderData.get("Name").toString());
//        
//        //Start Date
//        String sDate = (order.get("StartDate").toString().substring(6, 19));
//        
//        LocalDate startDate = Instant.ofEpochMilli(Long.valueOf(sDate)).atZone(ZoneId.systemDefault()).toLocalDate();
//        
//        Date dts = new Timestamp(Long.valueOf(sDate));
//        DateFormat sformatter = new SimpleDateFormat("dd-mm-yyyy");
//        String dateSFormatted = sformatter.format(dts);
//        
//        java.sql.Date sqlSDate = java.sql.Date.valueOf(startDate);
//        System.out.println(sqlSDate);
//        
//        dt.setStartDate(sqlSDate);
//        
//        //End Date
//        String eDate = (order.get("EndDate").toString().substring(6, 19));
//        
//        LocalDate endDate = Instant.ofEpochMilli(Long.valueOf(eDate)).atZone(ZoneId.systemDefault()).toLocalDate();
//        
//        Date dte = new Timestamp(Long.valueOf(eDate));
//        DateFormat eformatter = new SimpleDateFormat("dd-mm-yyyy");
//        String dateEFormatted = eformatter.format(dte);
//        
//        java.sql.Date sqlEDate = java.sql.Date.valueOf(endDate);
//        System.out.println(sqlEDate);
//        
//        dt.setEndDate(sqlEDate);
//        
//        //Finished Order
//        boolean isFinished = (Boolean) order.get("FinishedOrder");
//        System.out.println(isFinished); //System.out.println(task.get("FinishedOrder"));
//        dt.setIsFinished(isFinished); //(String) taskData.get("FinishedOrder")
////        parseDepObject(order);