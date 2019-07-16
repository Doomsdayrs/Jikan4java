package com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Manga;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.Manga;
import org.json.simple.parser.ParseException;

import java.io.IOException;
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
 * 01 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class TopManga extends Retriever {
    @JsonProperty("mal_id")
    public int mal_id;

    @JsonProperty("rank")
    public int rank;

    @JsonProperty("title")
    public String title;

    @JsonProperty("url")
    public String url;

    @JsonProperty("type")
    public String type;

    @JsonProperty("volumes")
    public int volumes;

    @JsonProperty("start_date")
    public String start_date;

    @JsonProperty("end_date")
    public String end_date;

    @JsonProperty("members")
    public int members;

    @JsonProperty("score")
    public float score;

    @JsonProperty("image_url")
    public String image_url;


    /**
     * Returns the Manga object of this object
     *
     * @return Manga Object
     * @throws IOException
     * @throws ParseException
     */
    public CompletableFuture<Manga> getManga() {
        return retrieve(Manga.class, baseURL + "/manga/" + mal_id);
    }

    @Override
    public String toString() {
        return "TopManga{" +
                "mal_id=" + mal_id +
                ", rank=" + rank +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", subType='" + type + '\'' +
                ", volumes=" + volumes +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", members=" + members +
                ", score=" + score +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
