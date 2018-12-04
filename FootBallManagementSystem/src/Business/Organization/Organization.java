/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public abstract class Organization {

    private String organizationName;
    private WorkQueue workQueue;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=0;
    
    public enum Type{
        Player("Player Organization"), 
        Manager("Manager Organization"),
        SupportingStaff("SupportingStaff Organization"),
        YouthAcademy("YouthAcademy Organization"), 
        TicketSelling("Ticket selling Organization"),
        GroundStaff("Ground staff Organization"),
        BoardOfDirectors("BoardOfDirectors");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.organizationName = name;
        workQueue = new WorkQueue();
       // employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

//    public EmployeeDirectory getEmployeeDirectory() {
//        return employeeDirectory;
//    }
    
    public String getName() {
        return organizationName;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.organizationName = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    
}
