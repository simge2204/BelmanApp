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
    private String depName;
    private Boolean isFinished;

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

    public Boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }
    
    @Override
    public String toString()
    {
        return "DepartmentTask[depName=" + depName + "startDate=" + startDate + "endDate=" + endDate + "isFinished=" + isFinished + "]";
    }
}
