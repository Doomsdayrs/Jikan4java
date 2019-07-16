package com.github.Doomsdayrs.Jikan4java.types.Main.Magazine;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.Authors;
import com.github.Doomsdayrs.Jikan4java.types.Support.Genre;

import java.util.ArrayList;

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

public class Magazine {
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

    @JsonProperty("publishing_start")
    public String publishing_start;

    @JsonProperty("volumes")
    public int volumes;

    @JsonProperty("members")
    public int members;

    @JsonProperty("genres")
    public ArrayList<Genre> genres;

    @JsonProperty("authors")
    public ArrayList<Authors> authors;

    @JsonProperty("score")
    public float score;

    @JsonProperty("serialization")
    public ArrayList<String> serializations;

    @Override
    public String toString() {
        return "Magazine{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", subType='" + type + '\'' +
                ", publishing_start='" + publishing_start + '\'' +
                ", volumes=" + volumes +
                ", members=" + members +
                ", genres=" + genres +
                ", authors=" + authors +
                ", score=" + score +
                ", serializations=" + serializations +
                '}';
    }
}
