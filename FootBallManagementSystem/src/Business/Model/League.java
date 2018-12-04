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
public class League {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("area")
    @Expose
    private Object area;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("emblemUrl")
    @Expose
    private Object emblemUrl;
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
}
