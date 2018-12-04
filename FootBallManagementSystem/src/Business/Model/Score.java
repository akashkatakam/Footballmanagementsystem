
package Business.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Score {

    @SerializedName("winner")
    @Expose
    private String winner;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("fullTime")
    @Expose
    private Subscore fullTime;
    @SerializedName("halfTime")
    @Expose
    private Subscore halfTime;
    @SerializedName("extraTime")
    @Expose
    private Subscore extraTime;
    @SerializedName("penalties")
    @Expose
    private Subscore penalties;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Subscore getFullTime() {
        return fullTime;
    }

    public void setFullTime(Subscore fullTime) {
        this.fullTime = fullTime;
    }

}
