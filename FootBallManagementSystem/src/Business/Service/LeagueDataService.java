/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Service;

import Business.Model.League;
import Business.Model.Match;
import Business.ObjectMapper.ClubMapper;
import Business.ObjectMapper.LeagueObjectMapper;
import Business.ObjectMapper.MatchMapper;
import Business.ObjectMapper.PlayerMapper;
import Business.ObjectMapper.StandingsMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;

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
          .header("X-Auth-Token", "d84604099194435ca39551f3071238c6").asJson();
       // LeagueObjectMapper lom = gson.fromJson(json, LeagueObjectMapper.class);
        String responseAsString = response.getBody().toString();
        LeagueObjectMapper lm = gson.fromJson(responseAsString,LeagueObjectMapper.class );
        }
    public void getClubs(int id) throws UnirestException{
         HttpResponse<JsonNode> response 
          = Unirest.get("https://api.football-data.org/v2/competitions/"+id+"/teams")
          .header("X-Auth-Token", "d84604099194435ca39551f3071238c6").asJson();
        System.out.println(response.getBody());
        ClubMapper cm = gson.fromJson(response.getBody().toString(),ClubMapper.class);
    }
    
    public void getPlayers(int id) throws UnirestException{
         HttpResponse<JsonNode> response 
          = Unirest.get("https://api.football-data.org/v2/teams/"+id)
          .header("X-Auth-Token", "d84604099194435ca39551f3071238c6").asJson();
        System.out.println(response.getBody());
        PlayerMapper cm = gson.fromJson(response.getBody().toString(),PlayerMapper.class);
    }
    
    public void getMatches(String code) throws UnirestException{
         HttpResponse<JsonNode> response 
          = Unirest.get("https://api.football-data.org/v2/competitions/"+code+"/matches")
          .header("X-Auth-Token", "d84604099194435ca39551f3071238c6").asJson();
        System.out.println(response.getBody());
        MatchMapper mm = gson.fromJson(response.getBody().toString(),MatchMapper.class);
    }
    
    public void getStandings(String code) throws UnirestException{
         HttpResponse<JsonNode> response 
          = Unirest.get("https://api.football-data.org/v2/competitions/"+code+"/standings")
          .header("X-Auth-Token", "d84604099194435ca39551f3071238c6").asJson();
        System.out.println(response.getBody());
        StandingsMapper mm = gson.fromJson(response.getBody().toString(),StandingsMapper.class);
    }
    
    
    
}
