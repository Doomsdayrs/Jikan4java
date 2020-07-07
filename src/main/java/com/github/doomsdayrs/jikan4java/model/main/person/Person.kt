package com.github.doomsdayrs.jikan4java.model.main.person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.core.Retriever;
import com.github.doomsdayrs.jikan4java.model.support.pictures.Pictures;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

/*
 * This file is part of Jikan4java.
 *
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Jikan4java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 07 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Person extends Retriever {
    @JsonProperty("request_hash")
    public String request_hash;
    @JsonProperty("request_cached")
    public boolean request_cached;
    @JsonProperty("request_cache_expiry")
    public int request_cache_expiry;
    @JsonProperty("mal_id")
    public int mal_id;
    @JsonProperty("url")
    public String url;
    @JsonProperty("image_url")
    public String image_url;
    @JsonProperty("website_url")
    public String website_url;
    @JsonProperty("name")
    public String name;
    @JsonProperty("given_name")
    public String given_name;
    @JsonProperty("family_name")
    public String family_name;
    @JsonProperty("alternate_names")
    public ArrayList<String> alternate_names;
    @JsonProperty("birthday")
    public String birthday;
    @JsonProperty("member_favorites")
    public int member_favorites;
    @JsonProperty("about")
    public String about;
    @JsonProperty("voice_acting_roles")
    public ArrayList<VoiceActingRoles> voiceActingRoles;
    @JsonProperty("anime_staff_positions")
    public ArrayList<AnimeStaffPosition> animeStaffPositions;
    @JsonProperty("published_manga")
    public ArrayList<PublishedManga> publishedMangas;

    @JsonIgnore
    public CompletableFuture<Pictures> getPictures() {
        return retrieve(Pictures.class, baseURL + "/person/" + mal_id + "/pictures");
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
