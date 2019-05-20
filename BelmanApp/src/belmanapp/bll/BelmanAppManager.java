/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.bll;

import belmanapp.JsonData;
import belmanapp.be.Order;
import belmanapp.dal.BelmanAppDAO;
import belmanapp.dal.JsonDAO;
import java.util.List;
import javafx.collections.ObservableList;
import org.json.simple.JSONObject;

/**
 *
 * @author simge
 */
public class BelmanAppManager {
    private double progress;
    belmanapp.dal.BelmanAppDAO dao;
    belmanapp.dal.JsonDAO jDao = new JsonDAO();
    
    public List<String> getAvailableWorkers()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Order calculateProgress()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void updateProgress()
    {
        
    }
    
    public void updateGUI()
    {
        
    }

    public List<Order> getOrders() {
        return jDao.getOrders();
    }
}
