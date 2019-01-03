package com.github.Doomsdayrs.Jikan4java.types.Support.Recommendations;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Jikan4java
 * 02 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class RecommendationPage {
    @JsonProperty("request_hash")
    private String request_hash;

    @JsonProperty("request_cached")
    private boolean request_cached;

    @JsonProperty("request_cache_expiry")
    private int request_cache_expiry;

    @JsonProperty("recommendations")
    private ArrayList<Recommend> recommends;

    public String getRequest_hash() {
        return request_hash;
    }

    public boolean isRequest_cached() {
        return request_cached;
    }

    public int getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    public ArrayList<Recommend> getRecommends() {
        return recommends;
    }

    @Override
    public String toString() {
        return "RecommenationPage{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", recommends=" + recommends +
                '}';
    }
}
