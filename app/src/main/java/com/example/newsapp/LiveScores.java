package com.example.newsapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LiveScores {
    @SerializedName("matchId")
    private int matchId;

    @SerializedName("leagueType ")
    private int leagueType;

    @SerializedName("leagueName")
    private String leagueName;

    @SerializedName("leagueId")
    private String leagueId;

    @SerializedName("leagueShortName")
    private String leagueShortName;

    @SerializedName("matchTime")
    private int matchTime;

    @SerializedName("halfStartTime")
    private int halfStartTime;

    @SerializedName("status")
    private int status;

    @SerializedName("homeName")
    private String homeName;

    @SerializedName("homeRank")
    private String homeRank;

    @SerializedName("awayName")
    private String awayName;

    @SerializedName("awayRank")
    private String awayRank;

    @SerializedName("homeScore")
    private int homeScore;

    @SerializedName("awayScore")
    private int awayScore;

    @SerializedName("homeHalfScore")
    private int homeHalfScore;

    @SerializedName("awayHalfScore")
    private int awayHalfScore;

    @SerializedName("extraExplain")
    private ExtraExplain extraExplains;



    public int getLeagueType() {
        return leagueType;
    }

    public void setLeagueType(int leagueType) {
        this.leagueType = leagueType;
    }

    public int getHalfStartTime() {
        return halfStartTime;
    }

    public void setHalfStartTime(int halfStartTime) {
        this.halfStartTime = halfStartTime;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueShortName() {
        return leagueShortName;
    }

    public void setLeagueShortName(String leagueShortName) {
        this.leagueShortName = leagueShortName;
    }

    public int getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(int matchTime) {
        this.matchTime = matchTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getHomeRank() {
        return homeRank;
    }

    public void setHomeRank(String homeRank) {
        this.homeRank = homeRank;
    }

    public String getAwayName() {
        return awayName;
    }

    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    public String getAwayRank() {
        return awayRank;
    }

    public void setAwayRank(String awayRank) {
        this.awayRank = awayRank;
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

    public int getHomeHalfScore() {
        return homeHalfScore;
    }

    public void setHomeHalfScore(int homeHalfScore) {
        this.homeHalfScore = homeHalfScore;
    }

    public int getAwayHalfScore() {
        return awayHalfScore;
    }

    public void setAwayHalfScore(int awayHalfScore) {
        this.awayHalfScore = awayHalfScore;
    }

    public ExtraExplain getExtraExplains() {
        return extraExplains;
    }

    public void setExtraExplains(ExtraExplain extraExplains) {
        this.extraExplains = extraExplains;
    }
}
