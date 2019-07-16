package com.github.Doomsdayrs.Jikan4java.types.Main.Manga.MangaPage;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * 04 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class MangaPageManga extends Retriever {
    @JsonProperty("mal_id")
    public int mal_id;
    @JsonProperty("url")
    public String url;
    @JsonProperty("image_url")
    public String iconURL;
    @JsonProperty("title")
    public String title;
    @JsonProperty("publishing")
    public boolean publishing;
    @JsonProperty("synopsis")
    public String synopsis;
    @JsonProperty("type")
    public String type;
    @JsonProperty("chapters")
    public int chapters;
    @JsonProperty("volumes")
    public int volumes;
    @JsonProperty("score")
    public double score;
    @JsonProperty("start_date")
    public String start_date;
    @JsonProperty("end_date")
    public String end_date;
    @JsonProperty("members")
    public int members;
    
    /**
     * Returns the Manga object of this object
     *
     * @return Manga Object
     * @throws IOException
     * @throws ParseException
     */
    public CompletableFuture<Manga> getManga() throws IOException, ParseException {
        return retrieve(Manga.class, baseURL + "/character/" + mal_id);
    }

    @Override
    public String toString() {
        return "MangaPageManga{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", iconURL='" + iconURL + '\'' +
                ", title='" + title + '\'' +
                ", publishing=" + publishing +
                ", synopsis='" + synopsis + '\'' +
                ", subType='" + type + '\'' +
                ", chapters=" + chapters +
                ", volumes=" + volumes +
                ", score=" + score +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", members=" + members +
                '}';
    }
}
