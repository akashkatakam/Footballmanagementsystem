/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author akash
 */
public class Standing {
    @SerializedName("stage")
    @Expose
    private String stage;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("group")
    @Expose
    private Object group;
    @SerializedName("table")
    @Expose
    private ArrayList<Table> table = null;

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getGroup() {
        return group;
    }

    public void setGroup(Object group) {
        this.group = group;
    }

    public ArrayList<Table> getTable() {
        return table;
    }

    public void setTable(ArrayList<Table> table) {
        this.table = table;
    }
    
    
}
