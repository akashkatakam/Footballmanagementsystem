/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Service;

import Business.Model.Club;
import Business.Model.Player;
import Business.Network.League;
import Business.ObjectMapper.LeagueObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
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
    public void getAllLeagues() throws UnirestException {
        HttpResponse<JsonNode> response 
          = Unirest.get("https://api.football-data.org/v2/competitions?plan=TIER_ONE")
          .header("X-Auth-Token", "8a560fde4b7b4ec3b5dfae2ba97fe928").asJson();
       // LeagueObjectMapper lom = gson.fromJson(json, LeagueObjectMapper.class);
        String responseAsString = response.getBody().toString();
        LeagueObjectMapper lm = gson.fromJson(responseAsString,LeagueObjectMapper.class );
        }
    public void getClubs(int id) throws UnirestException{
         HttpResponse<JsonNode> response 
          = Unirest.get("https://api.football-data.org/v2/competitions/"+id+"/teams")
          .header("X-Auth-Token", "8a560fde4b7b4ec3b5dfae2ba97fe928").asJson();
        System.out.println(response.getBody());
        League clubmap = gson.fromJson(response.getBody().toString(),League.class);
    }
    
    public List<Player> getPlayers(int id) throws UnirestException{
         HttpResponse<JsonNode> response 
          = Unirest.get("https://api.football-data.org/v2/teams/"+id)
          .header("X-Auth-Token", "8a560fde4b7b4ec3b5dfae2ba97fe928").asJson();
        Club cm = gson.fromJson(response.getBody().toString(),Club.class);
       return cm.getPlayers();
        
    }
    
    public static void main(String[] args) throws UnirestException {
        LeagueDataService ls = new LeagueDataService();
        ls.getAllLeagues();
        ls.getPlayers(57);
        ls.getClubs(2021);
    }
}
