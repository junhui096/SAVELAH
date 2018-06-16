package com.example.junhu.savelah.dataObjects;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class HTTP_RecipeShort {
    private List<Recipe_Short> results;
    private String baseUri;
    private int offset;
    private int number;
    private int totalResults;
    private int processingTimeMs;
    private long expires;
    private boolean isStale;

    private HTTP_RecipeShort(String baseUri, long expires, boolean isStale, int number, int offset, int processingTimeMs, List<Recipe_Short> results, int totalResults) {
        this.baseUri = baseUri;
        this.expires = expires;
        this.isStale = isStale;
        this.number = number;
        this.offset = offset;
        this.processingTimeMs = processingTimeMs;
        this.results = results;
        this.totalResults = totalResults;
    }
    public HTTP_RecipeShort(String json) {
        Gson gson = new Gson();
        HTTP_RecipeShort handler = gson.fromJson(json, HTTP_RecipeShort.class);
        this.baseUri = handler.getBaseUri();
        this.expires = handler.getExpires();
        this.isStale = handler.isStale();
        this.offset = handler.getOffset();
        this.number = handler.getNumber();
        this.processingTimeMs = handler.getProcessingTimeMs();
        this.results = handler.getResults();
        this.totalResults = handler.getTotalResults();
    }

    public String getBaseUri() {
        return baseUri;
    }

    public long getExpires() {
        return expires;
    }

    public boolean isStale() {
        return isStale;
    }

    public int getNumber() {
        return number;
    }

    public int getOffset() {
        return offset;
    }

    public int getProcessingTimeMs() {
        return processingTimeMs;
    }

    public List<Recipe_Short> getResults() {
        return results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    @Override
    public String toString() {
        return "API_Handler{" +
                "baseUri='" + baseUri + '\'' +
                ", results='" + results + '\'' +
                ", offset=" + offset +
                ", number=" + number +
                ", totalResults=" + totalResults +
                ", processingTimeMs=" + processingTimeMs +
                ", expires=" + expires +
                ", isStale=" + isStale +
                '}';
    }

}
