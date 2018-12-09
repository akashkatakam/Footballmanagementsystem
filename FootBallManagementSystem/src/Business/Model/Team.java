/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

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
    @SerializedName("coach")
    @Expose
    private Player coach;
    @SerializedName("captain")
    @Expose
    private Player captain;
    @SerializedName("lineup")
    @Expose
    private ArrayList<Player> lineup;
    @SerializedName("bench")
    @Expose
    private ArrayList<Player> bench;
    
}
