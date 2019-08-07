/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.be;

import java.sql.Date;
import java.time.LocalDate;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author simge
 */
public class DepartmentTask {
    public long orderNumber;
    private Date startDate;
    private Date endDate;
    private int depID;
    private int workerID;
    private boolean isFinished;
    private double progressE;
    private DoubleProperty progressR;
    private DoubleProperty progress;
    belmanapp.bll.BelmanAppManager BAManager;
    
//    public DepartmentTask(long orderNumber, Date deliveryDate, String customer) {
//        this.orderNumber = orderNumber;
//        this.deliveryDate = deliveryDate;
//        this.customer = customer;
//    }
    
    public DepartmentTask(long orderNumber, int depID, Date startDate, Date endDate, boolean isFinished) {
        this.orderNumber = orderNumber;
        this.depID = depID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isFinished = isFinished;
    }

    public DepartmentTask() {
    }

    public long getOrderNumber()
    {
        return orderNumber;
    }
    
    public void setOrderNumber(long orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }
    
//    public String getDepName() {
//        return depName;
//    }
//
//    public void setDepName(String depName) {
//        this.depName = depName;
//    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }
    
    public double getProgressE() {
        if(progress != null)
        {
            return progress.get();
        }
        return 0;
    }

    public void setProgressE(double progress) {
        this.progressProperty().set(progress);
    }

//    public DoubleProperty getProgressR() {
//        return progressR;
//    }
//
//    public void setProgressR(DoubleProperty progressR) {
//        this.progressR = progressR;
//    }
    
    public DoubleProperty progressProperty()
    {
        if(progress == null)
        {
            progress = new SimpleDoubleProperty(0);
        }
        return progress;
    }
    
    @Override
    public String toString()
    {
        return "DepartmentTask{" + ", orderNumber=" + orderNumber + ", workerID=" + workerID + "depID=" + depID + "startDate=" + startDate + "endDate=" + endDate + "isFinished=" + isFinished + "}";
    }
}
