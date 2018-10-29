package com.github.Doomsdayrs.Jikan4java.types.Support;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MALData {
    @JsonProperty("mal_id")
    private int mal_id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("image_url")
    private String image_url;

    public int getMal_id() {
        return mal_id;
    }

    public String getUrl() {
        return url;
    }

    public String getImage_url() {
        return image_url;
    }
}
