/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Model.Abstract.Person;
import Business.Model.Club;
import Business.Model.Director;
import Business.Model.Stadium;
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
    private ArrayList<Stadium> stadiums;
    private ArrayList<Director> boardOfDirectors;
    private Director leagueAdmin;

    
    public League(String leaguename,String leagueAdminName){
        super(null);
        this.name = leaguename;
        this.clubs = new ArrayList<>();
        this.leagueAdmin = new Director(leagueAdminName,this);
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
    
    public ArrayList<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadiums(ArrayList<Stadium> stadiums) {
        this.stadiums = stadiums;
    }
    
    public void addStadium(Stadium s){
        this.stadiums.add(s);
    }

    public Director getLeagueAdmin() {
        return leagueAdmin;
    }

    public void setLeagueAdmin(Director leagueAdmin) {
        this.leagueAdmin = leagueAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
