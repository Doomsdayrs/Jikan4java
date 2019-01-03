package com.github.Doomsdayrs.Jikan4java.types.Support.Recommendations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Recommend {

    @JsonProperty("mal_id")
    private int mal_id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("image_url")
    private String image_url;

    @JsonProperty("recommendation_url")
    private String recommendation_url;

    @JsonProperty("title")
    private String title;

    @JsonProperty("recommendation_count")
    private int recommendation_count;

    public int getMal_id() {
        return mal_id;
    }

    public String getUrl() {
        return url;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getRecommendation_url() {
        return recommendation_url;
    }

    public String getTitle() {
        return title;
    }

    public int getRecommendation_count() {
        return recommendation_count;
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", recommendation_url='" + recommendation_url + '\'' +
                ", title='" + title + '\'' +
                ", recommendation_count=" + recommendation_count +
                '}';
    }
}
