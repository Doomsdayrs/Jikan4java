package com.github.Doomsdayrs.Jikan4java.types.Main.Schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Anime;
import com.github.Doomsdayrs.Jikan4java.types.Support.Genre;
import com.github.Doomsdayrs.Jikan4java.types.Support.Producer;
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
 * 31 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class SubAnime extends Retriever {
    @JsonProperty("mal_id")
    public int mal_id;
    @JsonProperty("url")
    public String url;
    @JsonProperty("title")
    public String title;
    @JsonProperty("image_url")
    public String image_url;
    @JsonProperty("synopsis")
    public String synopsis;
    @JsonProperty("type")
    public String type;
    @JsonProperty("airing_start")
    public String airing_start;
    @JsonProperty("episodes")
    public int episodes;
    @JsonProperty("members")
    public int members;
    @JsonProperty("genres")
    public ArrayList<Genre> genres;
    @JsonProperty("source")
    public String source;
    @JsonProperty("producers")
    public ArrayList<Producer> producers;
    @JsonProperty("score")
    public float score;
    @JsonProperty("licensors")
    public ArrayList<String> licensors;
    @JsonProperty("r18")
    public boolean r18;
    @JsonProperty("kids")
    public boolean kids;


    /**
     * Returns the Anime object of this object
     *
     * @return Anime Object
     * @throws IOException
     * @throws ParseException
     */
    public CompletableFuture<Anime> getAnime() throws IOException, ParseException {
        return retrieve(Anime.class, baseURL + "/anime/" + mal_id);
    }

    @Override
    public String toString() {
        return "GenreSearchAnime{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", subType='" + type + '\'' +
                ", airing_start='" + airing_start + '\'' +
                ", episodes=" + episodes +
                ", members=" + members +
                ", genres=" + genres +
                ", source='" + source + '\'' +
                ", producers=" + producers +
                ", score=" + score +
                ", licensors=" + licensors +
                ", r18=" + r18 +
                ", kids=" + kids +
                '}';
    }
}
