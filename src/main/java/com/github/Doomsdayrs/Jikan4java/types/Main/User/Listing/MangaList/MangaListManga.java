package com.github.Doomsdayrs.Jikan4java.types.Main.User.Listing.MangaList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Anime;
import com.github.Doomsdayrs.Jikan4java.types.Main.Magazine.Magazine;

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
 * 16 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public class MangaListManga extends Retriever {
    @JsonProperty("mal_id")
    public int mal_id;

    @JsonProperty("title")
    public String title;

    @JsonProperty("url")
    public String url;

    @JsonProperty("image_url")
    public String image_url;

    @JsonProperty("type")
    public String type;

    @JsonProperty("reading_status")
    public int reading_status;

    @JsonProperty("score")
    public int score;

    @JsonProperty("read_chapters")
    public int read_chapters;

    @JsonProperty("read_volumes")
    public int read_volumes;

    @JsonProperty("total_chapters")
    public int total_chapters;

    @JsonProperty("total_volumes")
    public int total_volumes;

    @JsonProperty("publishing_status")
    public int publishing_status;

    @JsonProperty("is_rereading")
    public boolean is_rereading;

    //This will become an error in the future, well. Ill be given a user tag that i can use
    @JsonProperty("tags")
    public ArrayList<String> tags;

    @JsonProperty("start_date")
    public String start_date;

    @JsonProperty("end_date")
    public String end_date;

    @JsonProperty("read_start_date")
    public String read_start_date;

    @JsonProperty("read_end_date")
    public String read_end_date;

    //Not sure of this
    @JsonProperty("days")
    public int days;
    //Also unsure
    @JsonProperty("retail")
    public String retail;

    @JsonProperty("priority")
    public String priority;

    @JsonProperty("added_to_list")
    public boolean added_to_list;

    //This will become an error in the future, well. Ill be given a user tag that i can use
    @JsonProperty("magazines")
    public ArrayList<Magazine> magazines;

    /**
     * Returns the Manga object of this object
     *
     * @return Manga Object
     */
    public CompletableFuture<Anime> getManga() {
        return retrieve(Anime.class, baseURL + "/manga/" + mal_id);
    }

    @Override
    public String toString() {
        return "MangaListManga{" +
                "mal_id=" + mal_id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", subType='" + type + '\'' +
                ", reading_status=" + reading_status +
                ", score=" + score +
                ", read_chapters=" + read_chapters +
                ", read_volumes=" + read_volumes +
                ", total_chapters=" + total_chapters +
                ", total_volumes=" + total_volumes +
                ", publishing_status=" + publishing_status +
                ", is_rereading=" + is_rereading +
                ", tags=" + tags +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", read_start_date='" + read_start_date + '\'' +
                ", read_end_date='" + read_end_date + '\'' +
                ", days=" + days +
                ", retail='" + retail + '\'' +
                ", priority='" + priority + '\'' +
                ", added_to_list=" + added_to_list +
                ", magazines=" + magazines +
                '}';
    }
}
