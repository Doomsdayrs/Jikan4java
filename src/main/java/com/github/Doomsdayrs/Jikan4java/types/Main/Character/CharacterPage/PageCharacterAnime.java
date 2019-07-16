package com.github.Doomsdayrs.Jikan4java.types.Main.Character.CharacterPage;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Anime;
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
public class PageCharacterAnime extends Retriever {
    @JsonProperty("mal_id")
    public int mal_id;
    @JsonProperty("type")
    public String type;
    @JsonProperty("name")
    public String name;
    @JsonProperty("url")
    public String url;

    /**
     * Returns the Anime object of this object
     *
     * @return Anime Object
     * @throws IOException    IOException
     * @throws ParseException ParseException
     */
    public CompletableFuture<Anime> getAnime() throws IOException, ParseException {
        return retrieve(Anime.class, baseURL + "/anime/" + mal_id);
    }

    @Override
    public String toString() {
        return "PageCharacterAnime{" +
                "mal_id=" + mal_id +
                ", subType='" + type + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
