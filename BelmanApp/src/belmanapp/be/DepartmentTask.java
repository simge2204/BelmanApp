/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.be;

import java.sql.Date;

/**
 *
 * @author simge
 */
public class DepartmentTask {
    private Date startDate;
    private Date endDate;
    private int OrderID;
    private int depID;
    private int workerID;
    private String depName;
    private boolean isFinished;

    public DepartmentTask(Date startDate, Date endDate, int OrderID, int depID, int workerID) { //Boolean isFinished
        this.startDate = startDate;
        this.endDate = endDate;
        this.OrderID = OrderID;
        this.depID = depID;
        this.workerID = workerID;
//        this.isFinished = isFinished;
    }

    public DepartmentTask() {
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
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
    
    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

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
    
    @Override
    public String toString()
    {
        return "DepartmentTask{" + "OrderID=" + OrderID + "depID=" + depID + "WorkerID=" + workerID + "startDate=" + startDate + "endDate=" + endDate + "}"; //"depName=" + depName & "isFinished=" + isFinished + 
    }
}
