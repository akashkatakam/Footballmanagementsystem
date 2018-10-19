/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Abstract.User;
import Business.Users.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harshalneelkamal
 */
public class CustomerDirectory {
    
    private List<User> customerList;
    
    public CustomerDirectory(){
        customerList = new ArrayList<>();
    }

    public List<User> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<User> supplierList) {
        this.customerList = supplierList;
    }
    
    public Customer addCustomer(String password, String userName,String name){
        Customer cust = new Customer(password, userName, name);
        this.customerList.add(cust);
        return cust;
    }
    
    public void removeCustomer(Customer cust){
        this.customerList.remove(cust);
    }
    
}
