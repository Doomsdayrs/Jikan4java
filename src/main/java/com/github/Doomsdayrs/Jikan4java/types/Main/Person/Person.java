package com.github.Doomsdayrs.Jikan4java.types.Main.Person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Support.Pictures.Pictures;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
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
    public CompletableFuture<Pictures> getPictures() throws IOException, ParseException {
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
