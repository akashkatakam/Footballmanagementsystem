/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Model;

import Business.Model.Abstract.Person;

/**
 *
 * @author chowd
 */
public class GroundStaff extends Person{
    private Stadium stadium;
    
    public GroundStaff(String n,Stadium stadium) {
        super(n);
        this.stadium = stadium;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }
    
}
