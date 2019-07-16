package com.github.Doomsdayrs.Jikan4java.types.Support.Userupdate.Anime;

import com.fasterxml.jackson.annotation.JsonProperty;

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
 * 04 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class AnimeUserUpdate {

    @JsonProperty("username")
    public String username;

    @JsonProperty("url")
    public String url;

    @JsonProperty("image_url")
    public String image_url;

    @JsonProperty("score")
    public int scores;

    @JsonProperty("status")
    public String status;

    @JsonProperty("episodes_seen")
    public int episodes_seen;

    @JsonProperty("episodes_total")
    public int episodes_total;

    @JsonProperty("date")
    public String date;
    

    @Override
    public String toString() {
        return "AnimeUserUpdate{" +
                "username='" + username + '\'' +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", scores=" + scores +
                ", status='" + status + '\'' +
                ", episodes_seen=" + episodes_seen +
                ", episodes_total=" + episodes_total +
                '}';
    }
}
