/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;
import Business.Model.Club;
import Business.Model.Match;

/**
 *
 * @author raunak
 */
public class MatchWorkRequest extends WorkRequest{
    
    private Match match; 
    private Club homeClub;
    private Club awayClub;
    private int numberOfTicketsSold;
    public MatchWorkRequest(Match m){
        this.match = m;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Club getHomeClub() {
        return homeClub;
    }

    public void setHomeClub(Club homeClub) {
        this.homeClub = homeClub;
    }

    public Club getAwayClub() {
        return awayClub;
    }

    public void setAwayClub(Club awayClub) {
        this.awayClub = awayClub;
    }

    public int getNumberOfTicketsSold() {
        return numberOfTicketsSold;
    }

    public void setNumberOfTicketsSold(int numberOfTicketsSold) {
        this.numberOfTicketsSold = numberOfTicketsSold;
    }
    
    
}
