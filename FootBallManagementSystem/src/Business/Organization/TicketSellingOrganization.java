/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Model.TicketSeller;
import Business.Role.Role;
import Business.Role.TicketSellerRole;
import java.util.ArrayList;

/**
 *
 * @author chowd
 */
public class TicketSellingOrganization extends Organization{
    
    public ArrayList<TicketSeller> TicketSellers;
    
    public TicketSellingOrganization() {
     super(Organization.Type.TicketSelling.getValue());
     this.TicketSellers = new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new TicketSellerRole());
        return roles;
    }

    public ArrayList<TicketSeller> getTicketSellers() {
        return TicketSellers;
    }

    public void setTicketSellers(ArrayList<TicketSeller> TicketSellers) {
        this.TicketSellers = TicketSellers;
    }
}
