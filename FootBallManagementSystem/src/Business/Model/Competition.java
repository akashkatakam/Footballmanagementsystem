/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author akash
 */
public class Competition {
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("emblemUrl")
    @Expose
    private String emblemUrl;
    @SerializedName("plan")
    @Expose
    private String plan;
    @SerializedName("currentSeason")
    @Expose
    private Season currentSeason;
    @SerializedName("numberOfAvailableSeasons")
    @Expose
    private Integer numberOfAvailableSeasons;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmblemUrl() {
        return emblemUrl;
    }

    public void setEmblemUrl(String emblemUrl) {
        this.emblemUrl = emblemUrl;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Season getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(Season currentSeason) {
        this.currentSeason = currentSeason;
    }

    public Integer getNumberOfAvailableSeasons() {
        return numberOfAvailableSeasons;
    }

    public void setNumberOfAvailableSeasons(Integer numberOfAvailableSeasons) {
        this.numberOfAvailableSeasons = numberOfAvailableSeasons;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
