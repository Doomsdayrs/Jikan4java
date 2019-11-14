package com.github.doomsdayrs.jikan4java.types.support.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.types.support.stats.score.Score;

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
