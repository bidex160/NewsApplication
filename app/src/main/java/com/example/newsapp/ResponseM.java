package com.example.newsapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseM {
    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private int totalResults;
    @SerializedName("articles")
     private List<articles> articles = null;

    public String getStatus() {
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<com.example.newsapp.articles> getArticles() {
        return articles;
    }

    public void setArticles(List<com.example.newsapp.articles> articles) {
        this.articles = articles;
    }
}
