
package Business.Model;

import Business.Model.Season;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("season")
    @Expose
    private Season season;
    @SerializedName("utcDate")
    @Expose
    private String utcDate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("matchday")
    @Expose
    private String matchday;
    @SerializedName("stage")
    @Expose
    private String stage;
    @SerializedName("group")
    @Expose
    private String group;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;
    @SerializedName("score")
    @Expose
    private Score score;
    @SerializedName("homeTeam")
    @Expose
    private Team homeTeam;
    @SerializedName("awayTeam")
    @Expose
    private Team awayTeam;
    @SerializedName("referees")
    @Expose
    private List<Player> referees = null;
     @SerializedName("goals")
    @Expose
    private List<Goal> goals = null;
    @SerializedName("bookings")
    @Expose
    private List<Booking> bookings = null;
    @SerializedName("substitutions")
    @Expose
    private List<Substitution> substitutions = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public String getUtcDate() {
        return utcDate;
    }

    public void setUtcDate(String utcDate) {
        this.utcDate = utcDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMatchday() {
        return matchday;
    }

    public void setMatchday(String matchday) {
        this.matchday = matchday;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public List<Player> getReferees() {
        return referees;
    }

    public void setReferees(List<Player> referees) {
        this.referees = referees;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public void setSubstitutions(List<Substitution> substitutions) {
        this.substitutions = substitutions;
    }
    
    
}
