/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Model;

import java.util.HashMap;

/**
 *
 * @author akash
 */
public class Team {
    
    private Player captain;
    private Player viceCaptain;
    private HashMap<Integer,Player> players;

    public Player getCaptain() {
        return captain;
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }

    public Player getViceCaptain() {
        return viceCaptain;
    }

    public void setViceCaptain(Player viceCaptain) {
        this.viceCaptain = viceCaptain;
    }

    public HashMap<Integer, Player> getPlayers() {
        return players;
    }

    public void setPlayers(HashMap<Integer, Player> players) {
        this.players = players;
    }
    
    
}
