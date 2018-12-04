
package Business.ObjectMapper;

import Business.Model.Season;
import Business.Model.Season;
import Business.Model.Standing;
import Business.Model.Standing;
import Business.Network.League;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StandingsMapper {

    @SerializedName("filters")
    @Expose
    private Object filters;
    @SerializedName("competition")
    @Expose
    private League competition;
    @SerializedName("season")
    @Expose
    private Season season;
    @SerializedName("standings")
    @Expose
    private List<Standing> standings = null;

    public Object getFilters() {
        return filters;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public List<Standing> getStandings() {
        return standings;
    }

    public void setStandings(List<Standing> standings) {
        this.standings = standings;
    }

}
