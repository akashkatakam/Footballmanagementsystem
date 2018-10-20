/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utils;

import Business.CustomerDirectory;
import Business.Users.Admin;
import Business.Users.Customer;
import java.util.Date;

/**
 *
 * @author akash
 */
public class Data {
    public Data(Admin a){
        CustomerDirectory cd = new CustomerDirectory();
        cd.addCustomer("Akash1995+", "akashkatakam1@gmail.com", new Date());
        cd.addCustomer("google67Y$", "akashkat_akam1@111.gmail", new Date());
        cd.addCustomer("Aed123$1+", "a_ka12am1@gmail.com", new Date());
        a.setCustDir(cd);
    }
}
