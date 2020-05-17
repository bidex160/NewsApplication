package com.example.newsapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LiveResponse {
    @SerializedName("code")
   private int code;

    @SerializedName("message")
   private String message;

    @SerializedName("data")
   private List<LiveScores> liveScores = null;






    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LiveScores> getLiveScores() {
        return liveScores;
    }

    public void setLiveScores(List<LiveScores> liveScores) {
        this.liveScores = liveScores;
    }
}
