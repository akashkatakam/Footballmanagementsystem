/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Model.BOD;
import Business.Model.Player;
import Business.Role.BODRole;
import Business.Role.PlayerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author chowd
 */
public class YouthAcademyOrganization extends Organization{
    
    public ArrayList<Player> YouthAcademyPlayer;
    
    public YouthAcademyOrganization() {
     super(Organization.Type.YouthAcademy.getValue());
     this.YouthAcademyPlayer = new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new PlayerRole());
        return roles;
    }

    public ArrayList<Player> getYouthAcademyPlayer() {
        return YouthAcademyPlayer;
    }

    public void setYouthAcademyPlayer(ArrayList<Player> YouthAcademyPlayer) {
        this.YouthAcademyPlayer = YouthAcademyPlayer;
    }
    
}
