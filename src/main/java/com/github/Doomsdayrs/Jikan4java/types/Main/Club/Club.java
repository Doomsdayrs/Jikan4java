package com.github.Doomsdayrs.Jikan4java.types.Main.Club;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Support.Basic.BasicMeta;
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
 * 05 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class Club extends Retriever {

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
    @JsonProperty("title")
    public String title;
    @JsonProperty("members_count")
    public float members_count;
    @JsonProperty("pictures_count")
    public float pictures_count;
    @JsonProperty("category")
    public String category;
    @JsonProperty("created")
    public String created;
    @JsonProperty("type")
    public String type;
    @JsonProperty("staff")
    public ArrayList<BasicMeta> staff;
    @JsonProperty("anime_relations")
    public ArrayList<BasicMeta> anime_relations;
    @JsonProperty("manga_relations")
    public ArrayList<BasicMeta> manga_relations;
    @JsonProperty("character_relations")
    public ArrayList<BasicMeta> character_relations;

    @JsonProperty
    public CompletableFuture<ClubMemberPage> getMembers() throws IOException, ParseException {
        return retrieve(ClubMemberPage.class, baseURL + "/club/" + mal_id + "/members");
    }


    @Override
    public String toString() {
        return "Club{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", title=" + title +
                ", members_count=" + members_count +
                ", pictures_count=" + pictures_count +
                ", category='" + category + '\'' +
                ", created='" + created + '\'' +
                ", subType='" + type + '\'' +
                ", staff=" + staff +
                ", anime_relations=" + anime_relations +
                ", manga_relations=" + manga_relations +
                ", character_relations=" + character_relations +
                '}';
    }
}
