/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Model.Player;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author akash
 */
public class PlayerOrganization extends Organization{
    
    public ArrayList<Player> players;
    
    public PlayerOrganization() {
     super(Organization.Type.Player.getValue());
     this.players = new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        //roles.add(new LabAssistantRole());
        return roles;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    
    
}
