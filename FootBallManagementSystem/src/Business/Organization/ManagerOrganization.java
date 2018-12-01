/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Model.TeamManager;
import Business.Role.ManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

public class ManagerOrganization extends Organization{
    
    private TeamManager tm;
    
    public ManagerOrganization() {
     super(Organization.Type.Manager.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ManagerRole());
        return roles;
    }

    public TeamManager getTm() {
        return tm;
    }

    public void setTm(TeamManager tm) {
        this.tm = tm;
    }
    
}
