/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Model;

import Business.Model.Abstract.Person;

/**
 *
 * @author akash
 */
public class Owner extends Person{
    
   private Club club;
   private Stadium stadium;
   
    public Owner(String n) {
        super(n);
    }
    public Owner(String n,Club c){
        super(n);
        this.club = c;
    }
    public Owner(String n,Stadium s){
        super(n);
        this.stadium = s;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }
    
}
