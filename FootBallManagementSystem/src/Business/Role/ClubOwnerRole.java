/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.ClubOwner.ClubOwnerWorkAreaJPanel;

/**
 *
 * @author chowd
 */
public class ClubOwnerRole extends Role {

    public ClubOwnerRole() {
        super(Role.RoleType.ClubOwner.getValue());
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ClubOwnerWorkAreaJPanel(userProcessContainer, account, organization, business);
    }
    
}
