package com.github.Doomsdayrs.Jikan4java.types.Support.Userupdate.Manga;

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
public class MangaUserUpdate {

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

    @JsonProperty("chapters_read")
    public int chapters_seen;

    @JsonProperty("volumes_read")
    public int volumes_seen;

    @JsonProperty("chapters_total")
    public int episodes_total;

    @JsonProperty("volumes_total")
    public int volumes_total;

    @JsonProperty("date")
    public String date;
    
    @Override
    public String toString() {
        return "MangaUserUpdate{" +
                "username='" + username + '\'' +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", scores=" + scores +
                ", status='" + status + '\'' +
                ", chapters_seen=" + chapters_seen +
                ", volumes_seen=" + volumes_seen +
                ", episodes_total=" + episodes_total +
                ", volumes_total=" + volumes_total +
                '}';
    }
}
