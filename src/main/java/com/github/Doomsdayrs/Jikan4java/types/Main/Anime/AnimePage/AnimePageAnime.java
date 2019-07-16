package com.github.Doomsdayrs.Jikan4java.types.Main.Anime.AnimePage;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Anime;

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
 * 04 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class AnimePageAnime extends Retriever {
    @JsonProperty("mal_id")
    public int mal_id;
    @JsonProperty("url")
    public String url;
    @JsonProperty("image_url")
    public String iconURL;
    @JsonProperty("title")
    public String title;
    @JsonProperty("airing")
    public boolean airing;
    @JsonProperty("synopsis")
    public String synopsis;
    @JsonProperty("type")
    public String type;
    @JsonProperty("episodes")
    public int episodes;
    @JsonProperty("score")
    public double score;
    @JsonProperty("source")
    public String source;
    @JsonProperty("start_date")
    public String start_date;
    @JsonProperty("end_date")
    public String end_date;
    @JsonProperty("members")
    public int members;
    @JsonProperty("rated")
    public String rated;

    
    /**
     * Returns the Anime object of this object
     *
     * @return Anime Object
     */
    public CompletableFuture<Anime> getAnime() {
        return retrieve(Anime.class, baseURL + "anime/" + mal_id);
    }


    @Override
    public String toString() {
        return "AnimePageAnime{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", iconURL='" + iconURL + '\'' +
                ", title='" + title + '\'' +
                ", airing=" + airing +
                ", synopsis='" + synopsis + '\'' +
                ", subType='" + type + '\'' +
                ", episodes=" + episodes +
                ", score=" + score +
                ", source='" + source + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", members=" + members +
                ", rated='" + rated + '\'' +
                '}';
    }
}
