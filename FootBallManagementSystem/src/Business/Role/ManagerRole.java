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
import userinterface.ManagerRole.ManagerWorkAreaJPanel;

/**
 *
 * @author chowd
 */
public class ManagerRole extends Role {

    public ManagerRole() {
        super(Role.RoleType.Manager.getValue());
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ManagerWorkAreaJPanel(userProcessContainer, account, organization, business);
    }

    @Override
    public String toString() {
        return Role.RoleType.Manager.getValue();
    }
    
}

