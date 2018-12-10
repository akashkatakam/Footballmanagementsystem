/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Model.Player;
import Business.Role.Role;
import java.util.ArrayList;

public class SupportingStaffOrganization extends Organization{
    
    public ArrayList<Player> staff;
    
    public SupportingStaffOrganization() {
     super(Organization.Type.SupportingStaff.getValue());
     this.staff = new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        //roles.add(new LabAssistantRole());
        return roles;
    }
    
    public void addSupportingStaff(Player p){
        this.staff.add(p);
    }

    public ArrayList<Player> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<Player> staff) {
        this.staff = staff;
    }
    
    
    
}
