/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Model.BOD;
import Business.Role.BODRole;
import Business.Role.Role;
import java.util.ArrayList;

public class BODOrganization extends Organization{
    
    public ArrayList<BOD> BoardOfDirectors;
    
    public BODOrganization() {
     super(Organization.Type.BoardOfDirectors.getValue());
     this.BoardOfDirectors = new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new BODRole());
        return roles;
    }
    public ArrayList<BOD> getBoardOfDirectors() {
        return BoardOfDirectors;
    }

    public void setBoardOfDirectors(ArrayList<BOD> BoardOfDirectors) {
        this.BoardOfDirectors = BoardOfDirectors;
    }
}
