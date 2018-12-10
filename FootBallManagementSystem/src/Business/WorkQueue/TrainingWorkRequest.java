/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Model.Match;

/**
 *
 * @author raunak
 */
public class TrainingWorkRequest extends WorkRequest{
    
    private int dribblingHours;
    private int shootingours;
    private int passingHours;
    private int defensiveHours;
    private int fitnessHours;
    private MatchWorkRequest matchReqst ; 
    
    public enum TrainingType{
        Dribbling("Dribbling"),
        Shooting("Shooting"),
        Passing("Passing"),
        Defensive("Defensive"),
        Fitness("Fitness");
        
        private String value;
        private TrainingType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public TrainingWorkRequest() {
        
    }

    public int getDribblingHours() {
        return dribblingHours;
    }

    public void setDribblingHours(int dribblingHours) {
        this.dribblingHours = dribblingHours;
    }

    public int getShootingours() {
        return shootingours;
    }

    public void setShootingours(int shootingours) {
        this.shootingours = shootingours;
    }

    public int getPassingHours() {
        return passingHours;
    }

    public void setPassingHours(int passingHours) {
        this.passingHours = passingHours;
    }

    public int getDefensiveHours() {
        return defensiveHours;
    }

    public void setDefensiveHours(int defensiveHours) {
        this.defensiveHours = defensiveHours;
    }

    public int getFitnessHours() {
        return fitnessHours;
    }

    public void setFitnessHours(int fitnessHours) {
        this.fitnessHours = fitnessHours;
    }

    public MatchWorkRequest getMatch() {
        return matchReqst;
    }

    public void setMatch(MatchWorkRequest match) {
        this.matchReqst = match;
    }
    

    
}
