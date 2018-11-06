package com.github.Doomsdayrs.Jikan4java.types.Support.Stats;
/*
 * This file is part of Jikan4java.
 *
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.JikanRequests;
import com.github.Doomsdayrs.Jikan4java.types.Support.Stats.Score.Score;

/**
 * Jikan4java
 * 29 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Stats implements JikanRequests {

    @JsonProperty("watching")
    private int watching;

    @JsonProperty("completed")
    private int completed;

    @JsonProperty("on_hold")
    private int on_hold;

    @JsonProperty("dropped")
    private int dropped;

    @JsonProperty("plan_to_watch")
    private int plan_to_watch;

    @JsonProperty("total")
    private int total;

    @JsonProperty("scores")
    private Score scores;

    @Override
    public String getRequest_hash() {
        return request_hash;
    }

    @Override
    public boolean isRequest_cached() {
        return request_cached;
    }

    @Override
    public int getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    public int getWatching() {
        return watching;
    }

    public int getCompleted() {
        return completed;
    }

    public int getOn_hold() {
        return on_hold;
    }

    public int getDropped() {
        return dropped;
    }

    public int getPlan_to_watch() {
        return plan_to_watch;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "watching=" + watching +
                ", completed=" + completed +
                ", on_hold=" + on_hold +
                ", dropped=" + dropped +
                ", plan_to_watch=" + plan_to_watch +
                ", total=" + total +
                ", scores=" + scores +
                ", request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                '}';
    }
}
