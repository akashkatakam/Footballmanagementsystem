/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Model.Contract;

/**
 *
 * @author raunak
 */
public class ContractWorkRequest extends WorkRequest{
    
    private Contract  contract;
    
    public ContractWorkRequest(Contract contract){
        this.contract = contract;
    }
    
    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
