/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Model.Club;
import Business.Model.Director;
import Business.Model.Season;
import Business.Model.Stadium;
import Business.Organization.Organization;
import Business.Role.Role;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 *
 * @author akash
 */
public class League {
    
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("area")
    @Expose
    private Object area;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("emblemUrl")
    @Expose
    private Object emblemUrl;
    @SerializedName("plan")
    @Expose
    private String plan;
    @SerializedName("currentSeason")
    @Expose
    private Season currentSeason;
    @SerializedName("numberOfAvailableSeasons")
    @Expose
    private Integer numberOfAvailableSeasons;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;
    private ArrayList<Club> clubs;
    private ArrayList<Stadium> stadiums;
    private ArrayList<Director> boardOfDirectors;
    private Director leagueAdmin;
    
    public League(String leaguename,String leagueAdminName){
        //super(null);
        this.name = leaguename;
        this.clubs = new ArrayList<>();
        this.stadiums = new ArrayList<>();
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
    
    
    //@Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    @Override
    public String toString() {
        return  name;
    }
    
    
}
