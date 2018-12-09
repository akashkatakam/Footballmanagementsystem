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
public class Team {
    
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("tla")
    @Expose
    private String tla;
    @SerializedName("crestUrl")
    @Expose
    private String crestUrl;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("founded")
    @Expose
    private Integer founded;
    @SerializedName("clubColors")
    @Expose
    private String clubColors;
    @SerializedName("venue")
    @Expose
    private String venue;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;
    
}
