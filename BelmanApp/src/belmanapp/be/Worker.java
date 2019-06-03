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
public class Worker {
    private int workerID;
    private String initials;
    private String name;
    private int salary;

    public Worker(int workerID, String initials, String name, int salary) {
        this.workerID = workerID;
        this.initials = initials;
        this.name = name;
        this.salary = salary;
    }

    public Worker() {
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return "Worker{" + "WorkerID=" + workerID + "initials=" + initials + " name=" + name + "salary=" + salary + "}";
    }
}
