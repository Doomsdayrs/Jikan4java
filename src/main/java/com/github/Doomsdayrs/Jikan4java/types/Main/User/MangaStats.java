package com.github.Doomsdayrs.Jikan4java.types.Main.User;

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
 * 03 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class MangaStats {
    @JsonProperty("days_read")
    public float days_read;
    @JsonProperty("mean_score")
    public float mean_score;
    @JsonProperty("reading")
    public int reading;
    @JsonProperty("completed")
    public int completed;
    @JsonProperty("on_hold")
    public int on_hold;
    @JsonProperty("dropped")
    public int dropped;
    @JsonProperty("plan_to_read")
    public int plan_to_read;
    @JsonProperty("total_entries")
    public int total_entries;
    @JsonProperty("reread")
    public int reread;
    @JsonProperty("chapters_read")
    public int chapters_read;
    @JsonProperty("volumes_read")
    public int volumes_read;
    

    @Override
    public String toString() {
        return "MangaStats{" +
                "days_read=" + days_read +
                ", mean_score=" + mean_score +
                ", reading=" + reading +
                ", completed=" + completed +
                ", on_hold=" + on_hold +
                ", dropped=" + dropped +
                ", plan_to_read=" + plan_to_read +
                ", total_entries=" + total_entries +
                ", reread=" + reread +
                ", chapters_read=" + chapters_read +
                ", volumes_read=" + volumes_read +
                '}';
    }
}
