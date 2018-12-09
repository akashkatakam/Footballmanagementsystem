/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Service;

import Business.Model.Club;
import Business.Model.Competition;
import Business.Model.Match;
import Business.Model.Player;
import Business.Model.Standing;
import Business.Network.League;
import Business.ObjectMapper.LeagueObjectMapper;
import Business.ObjectMapper.MatchMapper;
import Business.ObjectMapper.StandingsMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author akash
 */
public class LeagueDataService {
    
   Gson gson = new Gson();
   static {
        Unirest.setTimeouts(1000, 5000);

        Unirest.setObjectMapper(new ObjectMapper() {
            private Gson gson = new GsonBuilder().disableHtmlEscaping()
                    .create();

            @Override
            public <T> T readValue(String value, Class<T> valueType) {
                return gson.fromJson(value, valueType);
            }

            @Override
            public String writeValue(Object value) {
                return gson.toJson(value);
            }
        });
    }
    public List<Competition> getAllLeagues() {
    try{
        HttpResponse<JsonNode> response = 
                Unirest.get("https://api.football-data.org/v2/competitions?plan=TIER_ONE")
          .header("X-Auth-Token", "8a560fde4b7b4ec3b5dfae2ba97fe928").asJson();
        String responseAsString = response.getBody().toString();
        LeagueObjectMapper lm = gson.fromJson(responseAsString,LeagueObjectMapper.class );
        return lm.getLeagues();
        }catch(Exception e){
            return null;
        }
        
        }
    public League getClubs(int id){
         try{
             HttpResponse<JsonNode> response 
          = Unirest.get("https://api.football-data.org/v2/competitions/"+id+"/teams")
          .header("X-Auth-Token", "8a560fde4b7b4ec3b5dfae2ba97fe928").asJson();
        System.out.println(response.getBody());
        League cm = gson.fromJson(response.getBody().toString(),League.class);
        return cm;
         }
         catch(Exception e){
             e.printStackTrace();
             return null;
         }
    }
    
    public ArrayList<Player> getPlayers(int id){
        try{
         HttpResponse<JsonNode> response 
          = Unirest.get("https://api.football-data.org/v2/teams/"+id)
          .header("X-Auth-Token", "8a560fde4b7b4ec3b5dfae2ba97fe928").asJson();
        System.out.println(response.getBody());
        Club cm = gson.fromJson(response.getBody().toString(),Club.class);
        return (ArrayList<Player>) cm.getPlayers();
        }
        catch(Exception e){
            return null;
        }
    }
    
    public ArrayList<Match> getMatches(String code) {
        try{
         HttpResponse<JsonNode> response 
          = Unirest.get("https://api.football-data.org/v2/competitions/"+code+"/matches")
          .header("X-Auth-Token", "8a560fde4b7b4ec3b5dfae2ba97fe928").asJson();
        System.out.println(response.getBody());
        MatchMapper mm = gson.fromJson(response.getBody().toString(),MatchMapper.class);
        return mm.getMatches();
        }
        catch(Exception e){
            return null;
        }
    }
    
    public ArrayList<Standing> getStandings(int code){
         try{
        HttpResponse<JsonNode> response 
          = Unirest.get("https://api.football-data.org/v2/competitions/"+code+"/standings")
          .header("X-Auth-Token", "8a560fde4b7b4ec3b5dfae2ba97fe928").asJson();
        System.out.println(response.getBody());
        StandingsMapper mm = gson.fromJson(response.getBody().toString(),StandingsMapper.class);
        return mm.getStandings();
         } catch(JsonSyntaxException | UnirestException e){
             return null;
         }
    }
    
//    public static void main(String[] args) throws UnirestException {
//        LeagueDataService ls = new LeagueDataService();
//        DataHandler dh = new DataHandler();
//        ls.getAllLeagues();
//        ls.getClubs(2021);
//        dh.getChampionsLeague();
//    }
    
}
