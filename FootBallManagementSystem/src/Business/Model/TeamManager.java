/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Model;

import Business.Model.Abstract.Person;
import Business.Network.League;

/**
 *
 * @author akash
 */
public class TeamManager extends Person{
    
    private Club club;
    
    public TeamManager(String firstName,Club n) {
        super(firstName);
        this.club = n;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public League getLeague() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
