/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.dal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author simge
 */
public class jsonData {
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("C:/Github2/Data and interface - Belman v1/data.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONObject employeeList = (JSONObject) obj;
            JSONArray orders = (JSONArray) employeeList.get("ProductionOrders");
             
            System.out.println(orders);
            
            
            //Iterate over order array
            orders.forEach( order -> parseOrderObject( (JSONObject) order ));
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
     private static void parseOrderObject(JSONObject order)
    {
        
        JSONObject orderData = (JSONObject) order.get("Order");
        
        System.out.println(orderData.get("OrderNumber"));
        
        //System.out.println(order);
        
        /*
        //Get employee object within list
        JSONObject depObject = (JSONObject) DepartmentTasks.get("DepartmentTasks");
         
        //Get employee first name
        String customer = (String) depObject.get("EndDate");   
        System.out.println(customer);
         
        //Get employee last name
        String delivery = (String) depObject.get("FinishedOrder"); 
        System.out.println(delivery);
        
        //Get employee website name
        String departmentTasks = (String) depObject.get("StartDate");   
        System.out.println(departmentTasks);
        */
    }
}
