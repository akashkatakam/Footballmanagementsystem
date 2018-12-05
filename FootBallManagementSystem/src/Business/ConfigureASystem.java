package Business;

import Business.Handler.DataHandler;
import Business.Role.SuperAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    private DataHandler ch;
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", new SuperAdminRole(),null);
        
        return system;
    }
    
}
