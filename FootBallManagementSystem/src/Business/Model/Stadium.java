/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Model;


import Business.Enterprise.StadiumEnterprise;
import Business.Organization.GroundStaffOrganization;
import Business.Organization.TicketSellingOrganization;

/**
 *
 * @author chowd
 */
public class Stadium extends StadiumEnterprise {
    
    private Owner owner;
    private GroundStaffOrganization groundStaff;
    private TicketSellingOrganization ticketSellers;
    
    public Stadium(String name,Owner owner) {
        super(name);
        this.owner = owner;
        this.groundStaff = new GroundStaffOrganization();
        this.ticketSellers = new TicketSellingOrganization();
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    
    public GroundStaffOrganization getGroundStaff() {
        return groundStaff;
    }

    public void setGroundStaff(GroundStaffOrganization groundStaff) {
        this.groundStaff = groundStaff;
    }

    public TicketSellingOrganization getTicketSellers() {
        return ticketSellers;
    }

    public void setTicketSellers(TicketSellingOrganization ticketSellers) {
        this.ticketSellers = ticketSellers;
    }
    
}
