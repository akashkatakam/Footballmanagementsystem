/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Model;

import java.util.Date;

/**
 *
 * @author akash
 */
public class Contract {
   private int ContractID;
   private Player Player;
   private Club fromClub;
   private Club toClub;
   private Integer price;
   private Integer yearsOfContract;
   private static int counter = 0;
    
   public Contract( Player player, Club fromClub, Club toClub, Integer p, Integer yoc){
       this.ContractID = counter;
       this.Player = player;
       this.fromClub = fromClub;
       this.toClub = toClub;
       this.price = p;
       this.yearsOfContract = yoc;
       counter++;
    }

    public int getContractID() {
        return ContractID;
    }

    public void setContractID(int ContractID) {
        this.ContractID = ContractID;
    }

    public Player getPlayer() {
        return Player;
    }

    public void setPlayer(Player Player) {
        this.Player = Player;
    }

    public Club getFromClub() {
        return fromClub;
    }

    public void setFromClub(Club fromClub) {
        this.fromClub = fromClub;
    }

    public Club getToClub() {
        return toClub;
    }

    public void setToClub(Club toClub) {
        this.toClub = toClub;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getYearsOfContract() {
        return yearsOfContract;
    }

    public void setYearsOfContract(Integer yearsOfContract) {
        this.yearsOfContract = yearsOfContract;
    }

    
    @Override
    public String toString() {
        return String.valueOf(this.price);
    }
    
}
