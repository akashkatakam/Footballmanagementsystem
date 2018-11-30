/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;
import Business.Model.GroundStaff;
import Business.Role.GroundStaffManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author chowd
 */
public class GroundStaffOrganization extends Organization{
    
    public ArrayList<GroundStaff> GroundStaff;
    public GroundStaff manager;
    
    public GroundStaffOrganization() {
     super(Organization.Type.GroundStaff.getValue());
     this.GroundStaff = new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new GroundStaffManagerRole());
        return roles;
    }

    public ArrayList<GroundStaff> getGroundStaff() {
        return GroundStaff;
    }

    public void setGroundStaff(ArrayList<GroundStaff> GroundStaff) {
        this.GroundStaff = GroundStaff;
    }

    public GroundStaff getManager() {
        return manager;
    }

    public void setManager(GroundStaff manager) {
        this.manager = manager;
    }
    
}