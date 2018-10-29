package com.github.Doomsdayrs.Jikan4java.types.Main.Person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.MALData;

import java.util.ArrayList;

public class Person extends MALData {
    @JsonIgnore
    private final String baseURL = "https://api.jikan.moe/v3";
    @JsonProperty("request_hash")
    private String request_hash;
    @JsonProperty("request_cached")
    private boolean request_cached;
    @JsonProperty("request_cache_expiry")
    private int request_cache_expiry;
    @JsonProperty("mal_id")
    private int mal_id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("image_url")
    private String image_url;
    @JsonProperty("website_url")
    private String website_url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("given_name")
    private String given_name;
    @JsonProperty("family_name")
    private String family_name;
    @JsonProperty("alternate_names")
    private ArrayList<String> alternate_names;
    @JsonProperty("birthday")
    private String birthday;
    @JsonProperty("member_favorites")
    private int member_favorites;
    @JsonProperty("about")
    private String about;
    @JsonProperty("voice_acting_roles")
    private ArrayList<VoiceActingRoles> voiceActingRoles;
    @JsonProperty("anime_staff_positions")
    private ArrayList<AnimeStaffPosition> animeStaffPositions;
    @JsonProperty("published_manga")
    private ArrayList<PublishedManga> publishedMangas;

    public String getBaseURL() {
        return baseURL;
    }

    public String getRequest_hash() {
        return request_hash;
    }

    public boolean isRequest_cached() {
        return request_cached;
    }

    public int getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    @Override
    public int getMal_id() {
        return mal_id;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getImage_url() {
        return image_url;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public String getName() {
        return name;
    }

    public String getGiven_name() {
        return given_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public ArrayList<String> getAlternate_names() {
        return alternate_names;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getMember_favorites() {
        return member_favorites;
    }

    public String getAbout() {
        return about;
    }

    public ArrayList<VoiceActingRoles> getVoiceActingRoles() {
        return voiceActingRoles;
    }

    public ArrayList<AnimeStaffPosition> getAnimeStaffPositions() {
        return animeStaffPositions;
    }

    public ArrayList<PublishedManga> getPublishedMangas() {
        return publishedMangas;
    }

    @Override
    public String toString() {
        return "Person{" +
                "baseURL='" + baseURL + '\'' +
                ",\n request_hash='" + request_hash + '\'' +
                ",\n request_cached=" + request_cached +
                ",\n request_cache_expiry=" + request_cache_expiry +
                ",\n mal_id=" + mal_id +
                ",\n url='" + url + '\'' +
                ",\n image_url='" + image_url + '\'' +
                ",\n website_url='" + website_url + '\'' +
                ",\n name='" + name + '\'' +
                ",\n given_name='" + given_name + '\'' +
                ",\n family_name='" + family_name + '\'' +
                ",\n alternate_names=" + alternate_names +
                ",\n birthday='" + birthday + '\'' +
                ",\n member_favorites=" + member_favorites +
                ",\n about='" + about + '\'' +
                ",\n voiceActingRoles=" + voiceActingRoles +
                ",\n animeStaffPositions=" + animeStaffPositions +
                ",\n publishedMangas=" + publishedMangas +
                '}';
    }
}
