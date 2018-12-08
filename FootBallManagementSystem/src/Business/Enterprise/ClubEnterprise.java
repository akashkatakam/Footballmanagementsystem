/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.ManagerRole;
import Business.Role.PlayerRole;
import Business.Role.Role;
import Business.Role.YouthPlayerRole;
import java.util.ArrayList;

public class ClubEnterprise extends Enterprise {
    
    public ClubEnterprise(String name){
         super(name,EnterpriseType.Club);
    }
    public ClubEnterprise(){
    super(EnterpriseType.Club.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new PlayerRole());
        roles.add(new YouthPlayerRole());
        roles.add(new ManagerRole());
        return roles;
    }
    
    
}
