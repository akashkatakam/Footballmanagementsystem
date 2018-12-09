/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Model.Abstract;

import java.util.Date;

/**
 *
 * @author akash
 */
public abstract class Person {
    String personName;
    String email;
    String phone;
    Date dateofBirth;

   
    
    public Person(String name){
        this.personName = name;
    }
    public Person(){
        
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }
    
     public String getName() {
        return personName;
    }

    public void setName(String name) {
        this.personName = name;
    }

    @Override
    public String toString() {
        return personName;
    }
    
    
}
