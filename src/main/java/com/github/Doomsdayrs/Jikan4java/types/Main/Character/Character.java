package com.github.Doomsdayrs.Jikan4java.types.Main.Character;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Support.Pictures.Pictures;
import com.github.Doomsdayrs.Jikan4java.types.Support.Voice_actors;
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
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Character extends Retriever {
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
    @JsonProperty("name")
    public String name;
    @JsonProperty("name_kanji")
    public String name_kanji;
    @JsonProperty("nicknames")
    public ArrayList<String> nicknames;
    @JsonProperty("about")
    public String about;
    @JsonProperty("member_favorites")
    public int member_favorites;
    @JsonProperty("image_url")
    public String image_url;
    @JsonProperty("animeography")
    public ArrayList<Animeography> animeography;
    @JsonProperty("mangaography")
    public ArrayList<Mangaography> mangaography;
    @JsonProperty("voice_actors")
    public ArrayList<Voice_actors> voice_actors;

    /**
     * Gets pictures
     *
     * @return pictures
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    @JsonProperty
    public CompletableFuture<Pictures> getPictures() throws IOException, ParseException {
        return retrieve(Pictures.class, baseURL + "/character/" + mal_id + "/pictures");
    }

    @Override
    public String toString() {
        return "Character{" +
                ",mal_id=" + mal_id +
                ",\n url='" + url + '\'' +
                ",\n name='" + name + '\'' +
                ",\n name_kanji='" + name_kanji + '\'' +
                ",\n nicknames=" + nicknames.toString() +
                ",\n about='" + about + '\'' +
                ",\n member_favorites=" + member_favorites +
                ",\n image_url='" + image_url + '\'' +
                ",\n animeography=" + animeography +
                ",\n mangaography=" + mangaography +
                ",\n voice_actors=" + voice_actors +
                '}';
    }
}
