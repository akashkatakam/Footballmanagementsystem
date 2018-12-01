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
import userinterface.SystemAdmin.SuperAdminWorkAreaJPanel;

/**
 *
 * @author chowd
 */
public class SuperAdminRole extends Role {

    public SuperAdminRole() {
        super("Super Admin");
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new SuperAdminWorkAreaJPanel(userProcessContainer, account, organization, business);
    }
    
}
