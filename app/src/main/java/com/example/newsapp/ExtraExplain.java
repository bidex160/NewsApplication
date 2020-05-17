package com.example.newsapp;

import com.google.gson.annotations.SerializedName;

public class ExtraExplain {

    @SerializedName("kickOff")
    private int kickOff;

    @SerializedName("minute")
    private int minute;

    @SerializedName("homeScore")
    private int homeScore;

    @SerializedName("awayScore")
    private int awayScore;

    public ExtraExplain(int kickOff, int minute, int homeScore, int awayScore) {
        this.kickOff = kickOff;
        this.minute = minute;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public int getKickOff() {
        return kickOff;
    }

    public void setKickOff(int kickOff) {
        this.kickOff = kickOff;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }
}
