package com.github.Doomsdayrs.Jikan4java.types.Support.Reviews.Anime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.Reviews.Review;

public class AnimeReview extends Review {
    @JsonProperty("mal_id")
    private int mal_id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("helpful_count")
    private int helpful_count;

    @JsonProperty("date")
    private String date;

    @JsonProperty("reviewer")
    private AnimeReviewer reviewer;

    @JsonProperty("content")
    private String content;

    @Override
    public int getMal_id() {
        return mal_id;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public int getHelpful_count() {
        return helpful_count;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public AnimeReviewer getReviewer() {
        return reviewer;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "AnimeReview{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", helpful_count=" + helpful_count +
                ", date='" + date + '\'' +
                ", reviewer=" + reviewer +
                ", content='" + content + '\'' +
                '}';
    }
}
