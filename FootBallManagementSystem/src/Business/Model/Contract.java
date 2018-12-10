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
   private String price;
   private static int counter = 0;
    
   public Contract( Player player, Club fromClub, Club toClub, String p){
       this.ContractID = counter;
       this.Player = player;
       this.fromClub = fromClub;
       this.toClub = toClub;
       this.price = p;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return this.price;
    }
    
}
