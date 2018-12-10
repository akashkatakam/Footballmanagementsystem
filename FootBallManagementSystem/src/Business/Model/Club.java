/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Model;

import Business.Enterprise.ClubEnterprise;
import Business.Network.League;
import Business.Organization.ManagerOrganization;
import Business.Organization.PlayerOrganization;
import Business.Organization.SupportingStaffOrganization;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author akash
 */
public class Club extends ClubEnterprise {
    
    private Team team;
    private Owner owner;
    private ManagerOrganization managerOrganization = new ManagerOrganization();
    private PlayerOrganization clubPlayers ;
    private SupportingStaffOrganization supporttingStaff;
    private Stadium stadium;
    private League league;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("activeCompetitions")
    @Expose
    private List<Competition> activeCompetitions = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("tla")
    @Expose
    private String tla;
    @SerializedName("crestUrl")
    @Expose
    private String crestUrl;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("founded")
    @Expose
    private Integer founded;
    @SerializedName("clubColors")
    @Expose
    private String clubColors;
    @SerializedName("venue")
    @Expose
    private String venue;
    @SerializedName("squad")
    @Expose
    private ArrayList<Player> players = null;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;
    
    
    public Club(String name,String owner) {
        super(name);
        this.name = name;
        this.owner = new Owner(owner,this);
        this.clubPlayers = new PlayerOrganization();
        this.supporttingStaff = new SupportingStaffOrganization();
        this.managerOrganization = new ManagerOrganization();
    }
    public Club(){
        super();
        this.players = new ArrayList<>();
        this.clubPlayers = new PlayerOrganization();
        this.supporttingStaff = new SupportingStaffOrganization();
        this.managerOrganization = new ManagerOrganization();
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Competition> getActiveCompetitions() {
        return activeCompetitions;
    }

    public void setActiveCompetitions(List<Competition> activeCompetitions) {
        this.activeCompetitions = activeCompetitions;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTla() {
        return tla;
    }

    public void setTla(String tla) {
        this.tla = tla;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFounded() {
        return founded;
    }

    public void setFounded(Integer founded) {
        this.founded = founded;
    }

    public String getClubColors() {
        return clubColors;
    }

    public void setClubColors(String clubColors) {
        this.clubColors = clubColors;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        for(Player p : players){
            if(p.getRole().equals("PLAYER")){
                this.clubPlayers.addPlayer(p);
            }else{
                if(this.managerOrganization.getTm() == null){
                    TeamManager tm = new TeamManager();
                    tm.setManager(p);
                    this.managerOrganization.setTm(tm);
                }
                else this.supporttingStaff.addSupportingStaff(p);
            }
        }
        this.players = players;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public ManagerOrganization getManagerOrganization() {
        return managerOrganization;
    }

    public void setManagerOrganization(ManagerOrganization managerOrganization) {
        this.managerOrganization = managerOrganization;
    }

    
    public PlayerOrganization getClubPlayers() {
        return clubPlayers;
    }

    public void setClubPlayers(PlayerOrganization clubPlayers) {
        this.clubPlayers = clubPlayers;
    }

    public SupportingStaffOrganization getSupporttingStaff() {
        return supporttingStaff;
    }

    public void setSupporttingStaff(SupportingStaffOrganization supporttingStaff) {
        this.supporttingStaff = supporttingStaff;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
}
