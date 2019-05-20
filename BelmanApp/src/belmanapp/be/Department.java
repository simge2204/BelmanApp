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
    private String name;
    private int depID;
    private String worker;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }
    
    public String getWorker()
    {
        return worker;
    }
    
    public void setWorker(String worker)
    {
        this.worker = worker;
    }
    
    @Override
    public String toString() {
        return "Department [name=" + name + ", depID=" + depID + ", worker=" + worker + "]";
    }
}
