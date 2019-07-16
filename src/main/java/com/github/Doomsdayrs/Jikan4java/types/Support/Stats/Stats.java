package com.github.Doomsdayrs.Jikan4java.types.Support.Stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.Stats.Score.Score;

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
 * 29 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Stats {
    @JsonProperty("request_hash")
    public String request_hash;

    @JsonProperty("request_cached")
    public boolean request_cached;

    @JsonProperty("request_cache_expiry")
    public int request_cache_expiry;

    @JsonProperty("watching")
    public int watching;

    @JsonProperty("completed")
    public int completed;

    @JsonProperty("on_hold")
    public int on_hold;

    @JsonProperty("dropped")
    public int dropped;

    @JsonProperty("plan_to_watch")
    public int plan_to_watch;

    @JsonProperty("total")
    public int total;

    @JsonProperty("scores")
    public Score scores;
    
    @Override
    public String toString() {
        return "Stats{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", watching=" + watching +
                ", completed=" + completed +
                ", on_hold=" + on_hold +
                ", dropped=" + dropped +
                ", plan_to_watch=" + plan_to_watch +
                ", total=" + total +
                ", scores=" + scores.toString() +
                '}';
    }
}
