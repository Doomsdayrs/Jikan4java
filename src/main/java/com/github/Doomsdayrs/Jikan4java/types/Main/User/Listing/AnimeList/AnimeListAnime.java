package com.github.Doomsdayrs.Jikan4java.types.Main.User.Listing.AnimeList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Anime;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Licensors;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Studios;

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
 * 03 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class AnimeListAnime extends Retriever {

    @JsonProperty("mal_id")
    public int mal_id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("video_url")
    public String video_url;
    @JsonProperty("url")
    public String url;
    @JsonProperty("image_url")
    public String image_url;
    @JsonProperty("type")
    public String type;
    @JsonProperty("watching_status")
    public int watching_status;
    @JsonProperty("score")
    public int score;
    @JsonProperty("watched_episodes")
    public int watched_episodes;
    @JsonProperty("total_episodes")
    public int total_episodes;
    @JsonProperty("airing_status")
    public int airing_status;
    @JsonProperty("season_name")
    public String season_name;
    @JsonProperty("season_year")
    public String season_year;
    @JsonProperty("has_episode_video")
    public boolean has_episode_video;
    @JsonProperty("has_promo_video")
    public boolean has_promo_video;
    @JsonProperty("has_video")
    public boolean has_video;
    @JsonProperty("is_rewatching")
    public boolean is_rewatching;
    @JsonProperty("tags")
    public String tags;
    @JsonProperty("rating")
    public String rating;
    @JsonProperty("start_date")
    public String start_date;
    @JsonProperty("end_date")
    public String end_date;
    @JsonProperty("watch_start_date")
    public String watch_start_date;
    @JsonProperty("watch_end_date")
    public String watch_end_date;
    @JsonProperty("days")
    public String days;
    @JsonProperty("storage")
    public String storage;
    @JsonProperty("priority")
    public String priority;
    @JsonProperty("added_to_list")
    public boolean added_to_list;
    @JsonProperty("studios")
    public ArrayList<Studios> studios;
    @JsonProperty("licensors")
    public ArrayList<Licensors> licensors;

    /**
     * Returns the Anime object of this object
     *
     * @return Anime Object
     */
    public CompletableFuture<Anime> getAnime() {
        return retrieve(Anime.class, baseURL + "/anime/" + mal_id);
    }

    @Override
    public String toString() {
        return "AnimeListAnime{" +
                "mal_id=" + mal_id +
                ", title='" + title + '\'' +
                ", video_url='" + video_url + '\'' +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", subType='" + type + '\'' +
                ", watching_status=" + watching_status +
                ", score=" + score +
                ", watched_episodes=" + watched_episodes +
                ", total_episodes=" + total_episodes +
                ", airing_status=" + airing_status +
                ", season_name='" + season_name + '\'' +
                ", season_year='" + season_year + '\'' +
                ", has_episode_video=" + has_episode_video +
                ", has_promo_video=" + has_promo_video +
                ", has_video=" + has_video +
                ", is_rewatching=" + is_rewatching +
                ", tags='" + tags + '\'' +
                ", rating='" + rating + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", watch_start_date='" + watch_start_date + '\'' +
                ", watch_end_date='" + watch_end_date + '\'' +
                ", days='" + days + '\'' +
                ", storage='" + storage + '\'' +
                ", priority='" + priority + '\'' +
                ", added_to_list=" + added_to_list +
                ", studios=" + studios +
                ", licensors=" + licensors +
                '}';
    }
}
