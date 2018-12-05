/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Model.Competition;
import Business.Network.League;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MyPC1
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private Competition championsLeague;
    private List<Competition> leaguesList;
    private UserAccountDirectory userAccountDirectory;
    
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
      //  roleList.add(new SystemAdminRole());
        return roleList;
    }
    private EcoSystem(){
        super(null);
        leaguesList=new ArrayList<Competition>();
        this.userAccountDirectory = new UserAccountDirectory();
        this.leaguesList = new ArrayList<>();
    }

    public List<Competition> getleaguesList() {
        return leaguesList;
    }

    public void setleaguesList(List<Competition> leaguesList) {
        for(Competition c:leaguesList){
            if(c.id == 2001){
                this.championsLeague = c;
            }else this.leaguesList.add(c);
        }
    }

    public Competition getChampionsLeague() {
        return championsLeague;
    }

    public void setChampionsLeague(Competition championsLeague) {
        this.championsLeague = championsLeague;
    }
    
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
        for(Competition league:leaguesList){
            
        }
        return true;
    }
}
