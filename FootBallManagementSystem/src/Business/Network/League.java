/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Model.Abstract.Person;
import Business.Model.Club;
import Business.Model.Director;
import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author akash
 */
public class League extends Organization{
    
    private String name;
    private ArrayList<Club> clubs;
    private ArrayList<Director> boardOfDirectors;
    private Director leagueAdmin;
    
    public League(String leaguename,String leagueAdminName){
        super(null);
        this.name = leaguename;
        this.leagueAdmin = new Director(leagueAdminName);
    }

    public ArrayList<Club> getClubs() {
        return clubs;
    }

    public void setClubs(ArrayList<Club> clubs) {
        this.clubs = clubs;
    }

    public ArrayList<Director> getBoardOfDirectors() {
        return boardOfDirectors;
    }

    public void setBoardOfDirectors(ArrayList<Director> boardOfDirectors) {
        this.boardOfDirectors = boardOfDirectors;
    }
    
    public void addClub(Club c){
        this.clubs.add(c);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
