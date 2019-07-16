package com.github.Doomsdayrs.Jikan4java.types.Support.Userupdate.Manga;

import com.fasterxml.jackson.annotation.JsonProperty;

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
 * 04 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class MangaUserUpdatesPage {
    @JsonProperty("request_hash")
    public String request_hash;

    @JsonProperty("request_cached")
    public boolean request_cached;

    @JsonProperty("request_cache_expiry")
    public int request_cache_expiry;

    @JsonProperty("users")
    public ArrayList<MangaUserUpdate> userUpdates;
    
    @Override
    public String toString() {
        return "UserUpdatesPage{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", MangaUserUpdate=" + userUpdates +
                '}';
    }
}
