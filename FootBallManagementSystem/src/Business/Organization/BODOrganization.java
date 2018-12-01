/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Model.Director;
import Business.Role.DirectorRole;
import Business.Role.Role;
import java.util.ArrayList;

public class BODOrganization extends Organization{
    
    public ArrayList<Director> BoardOfDirectors;
    
    public BODOrganization() {
     super(Organization.Type.BoardOfDirectors.getValue());
     this.BoardOfDirectors = new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DirectorRole());
        return roles;
    }
    public ArrayList<Director> getBoardOfDirectors() {
        return BoardOfDirectors;
    }

    public void setBoardOfDirectors(ArrayList<Director> BoardOfDirectors) {
        this.BoardOfDirectors = BoardOfDirectors;
    }
}
