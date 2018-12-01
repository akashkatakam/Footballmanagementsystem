/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Model;


import Business.Enterprise.StadiumEnterprise;
import Business.Organization.GroundStaffOrganization;
import Business.Organization.ManagerOrganization;
import Business.Organization.PlayerOrganization;
import Business.Organization.TicketSellingOrganization;

/**
 *
 * @author chowd
 */
public class Stadium extends StadiumEnterprise {
    
    private GroundStaff groundStaffManager;
    private GroundStaffOrganization groundStaff;
    private TicketSellingOrganization ticketSellers;
    
    
    public Stadium(String name,GroundStaff groundStaffManager) {
        super(name);
        this.groundStaffManager = groundStaffManager;
    }

    public GroundStaff getGroundStaffManager() {
        return groundStaffManager;
    }

    public void setGroundStaffManager(GroundStaff groundStaffManager) {
        this.groundStaffManager = groundStaffManager;
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
