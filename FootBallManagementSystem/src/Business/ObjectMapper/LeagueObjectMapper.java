/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ObjectMapper;

import Business.Model.League;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author akash
 */
public class LeagueObjectMapper {
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("filters")
    @Expose
    private Object filters;
    @SerializedName("competitions")
    @Expose
    private List<League> leagues;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getFilters() {
        return filters;
    }

    public void setFilters(Object filters) {
        this.filters = filters;
    }

    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }
    
    

}
