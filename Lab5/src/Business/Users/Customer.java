/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Users;

import Business.Abstract.User;
import Business.CustomerDirectory;
import java.util.Date;

/**
 *
 * @author harshalneelkamal
 */
public class Customer extends User implements Comparable<Customer>{
    
    private CustomerDirectory directory;
    private String customerName;
    private Date date;
    public Customer(String password, String userName , Date date) {
        super(password, userName, "CUSTOMER");
        this.directory = new CustomerDirectory();;
        this.date = date;
        this.customerName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public int compareTo(Customer o) {
        return o.getUserName().compareTo(this.getUserName());
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return getUserName(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean verify(String password){
        if(password.equals(getPassword()))
            return true;
        return false;
    }
}
