/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Model;

import Business.Model.Abstract.Person;
import java.util.Date;

/**
 *
 * @author akash
 */
public class Player extends Person {
    
    private Club club;
    private String position;
    private int yearsOfContract;
    private  String email;
    
    public Player(String firstName,String lastName,String email) {
        super(firstName);
    }
    
    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getYearsOfContract() {
        return yearsOfContract;
    }

    public void setYearsOfContract(int yearsOfContract) {
        this.yearsOfContract = yearsOfContract;
    }
    
    
}
