/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Handler;

import Business.Model.Club;
import Business.Model.Competition;
import Business.Model.Standing;
import Business.Model.Table;
import Business.Network.League;
import Business.Service.LeagueDataService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author akash
 */
public class DataHandler {
    
    LeagueDataService lds = new LeagueDataService();
    public List<League> getChampionsLeague(){
        List<League> TopLeagues = new ArrayList<>();
        HashMap<Integer, List> clubs = new HashMap<>(); 
        List<Competition> leagues = lds.getAllLeagues();
        for(Competition cm : leagues){
            if(cm.id == 2001 ||  cm.id == 2021 || cm.id == 2002 || cm.id == 2014 || cm.id == 2019 || cm.id == 2015){
                TopLeagues.add(lds.getClubs(cm.id));
            }
        } 
        return TopLeagues;
    }
    
    public ArrayList<Standing> getStandings(int i){
        return lds.getStandings(i);
    }
    
    public ArrayList<Table> getTableofStanding(ArrayList<Standing> plStandings){
        ArrayList<Table> table = new ArrayList<>();
        for(Standing s : plStandings){
            if(s.getType().equals("TOTAL") ){
                for(Table t : s.getTable()){
                    table.add(t);
                }
            }
        }
        return table;
        
    }
    
    public ArrayList<Club> getTopFourTeams(ArrayList<Standing> plStandings){
        ArrayList<Club> topFourClubs = new ArrayList<>();
        for(Standing s : plStandings){
            if(s.getType().equals("TOTAL") ){
                for(Table t : s.getTable()){
                    if(t.getPosition()<5){
                        topFourClubs.add(t.getClub());
                    }
                }
            }
        }
        return topFourClubs;
    }
}
