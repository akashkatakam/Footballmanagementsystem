/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Model;

import Business.Enterprise.ClubEnterprise;
import Business.Organization.ManagerOrganization;
import Business.Organization.PlayerOrganization;
import Business.Organization.SupportingStaffOrganization;

/**
 *
 * @author akash
 */
public class Club extends ClubEnterprise {
    
    private Team team;
    private Owner owner;
    private ManagerOrganization teamManager;
    private PlayerOrganization clubPlayers;
    private SupportingStaffOrganization supporttingStaff;
    
    
    public Club(String name,Owner owner) {
        super(name);
        this.owner = owner;
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

    public ManagerOrganization getTeamManager() {
        return teamManager;
    }

    public void setTeamManager(ManagerOrganization teamManager) {
        this.teamManager = teamManager;
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
    
}
