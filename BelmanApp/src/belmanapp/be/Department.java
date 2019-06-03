/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belmanapp.be;

/**
 *
 * @author simge
 */
public class Department {
    private String depName;
    private int depID;
//    private String worker;

    public Department(String depName, int depID) { //String worker
        this.depName = depName;
        this.depID = depID;
//        this.worker = worker;
    }

    public Department() {
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String name) {
        this.depName = name;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }
    
//    public String getWorker()
//    {
//        return worker;
//    }
//    
//    public void setWorker(String worker)
//    {
//        this.worker = worker;
//    }
    
    @Override
    public String toString() {
        return "Department{" + "depName=" + depName + ", depID=" + depID + "}"; //", worker=" + worker +
    }
}
