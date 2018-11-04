/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Users;

import Business.Abstract.User;
import Business.ProductDirectory;

/**
 *
 * @author harshalneelkamal
 */
public class Supplier extends User implements Comparable<Supplier>{
    
    private ProductDirectory directory;
    private String supplierName;
    
    
    public Supplier(String password, String userName,String supplierName) {
        super(password, userName, "SUPPLIER");
        directory = new ProductDirectory();
        this.supplierName = supplierName;
    }

    public ProductDirectory getDirectory() {
        return directory;
    }

    public void setDirectory(ProductDirectory directory) {
        this.directory = directory;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Override
    public int compareTo(Supplier o) {
        return o.getUserName().compareTo(this.getUserName());
    }

    @Override
    public String toString() {
        return getSupplierName(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean verify(String password){
        if(password.equals(getPassword()))
            return true;
        return false;
    }
    
}
