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
    private List<League> leaguesList;
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
        this.userAccountDirectory = new UserAccountDirectory();
        this.leaguesList = new ArrayList<>();
    }

    public List<League> getleaguesList() {
        return leaguesList;
    }

    public void setleaguesList(List<League> leaguesList) {
        for(League c:leaguesList){
            if(c.getLeague().getId() == 2001){
                this.championsLeague = c.getLeague();
            }else this.leaguesList.add(c);
        }
    }

    public Competition getChampionsLeague() {
        return championsLeague;
    }

    public void setChampionsLeague(Competition championsLeague) {
        this.championsLeague = championsLeague;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }
    
    
    
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
        return true;
    }
}
