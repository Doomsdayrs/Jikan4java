package com.github.doomsdayrs.jikan4java.types.main.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/*
 * This file is part of Jikan4java.
 *
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Jikan4java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 01 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Schedule {
    @JsonProperty("request_hash")
    public String request_hash;
    @JsonProperty("request_cached")
    public boolean request_cached;
    @JsonProperty("request_cache_expiry")
    public int request_cache_expiry;
    @JsonProperty("monday")
    public ArrayList<SubAnime> monday;
    @JsonProperty("tuesday")
    public ArrayList<SubAnime> tuesday;
    @JsonProperty("wednesday")
    public ArrayList<SubAnime> wednesday;
    @JsonProperty("thursday")
    public ArrayList<SubAnime> thursday;
    @JsonProperty("friday")
    public ArrayList<SubAnime> friday;
    @JsonProperty("saturday")
    public ArrayList<SubAnime> saturday;
    @JsonProperty("sunday")
    public ArrayList<SubAnime> sunday;
    @JsonProperty("other")
    public ArrayList<SubAnime> others;
    @JsonProperty("unknown")
    public ArrayList<SubAnime> unknown;



    @Override
    public String toString() {
        return "Schedule{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", monday=" + monday +
                ", tuesday=" + tuesday +
                ", wednesday=" + wednesday +
                ", thursday=" + thursday +
                ", friday=" + friday +
                ", saturday=" + saturday +
                ", sunday=" + sunday +
                ", others=" + others +
                ", unknown=" + unknown +
                '}';
    }
}
