package com.github.doomsdayrs.jikan4java.types.support.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.types.support.RequestHashing;
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
 */

/**
 * Jikan4java
 * 29 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Stats extends RequestHashing {
    @JsonProperty("completed")
    public final int completed;

    @JsonProperty("on_hold")
    public final int on_hold;

    @JsonProperty("dropped")
    public final int dropped;

    @JsonProperty("total")
    public final int total;

    @JsonProperty("scores")
    public final Score scores;

    public Stats(@JsonProperty("request_hash") String request_hash, @JsonProperty("request_cached") boolean request_cached, @JsonProperty("request_cache_expiry") int request_cache_expiry, int completed, int on_hold, int dropped, int total, Score scores) {
        super(request_hash, request_cached, request_cache_expiry);
        this.request_hash = request_hash;
        this.request_cached = request_cached;
        this.request_cache_expiry = request_cache_expiry;
        this.completed = completed;
        this.on_hold = on_hold;
        this.dropped = dropped;
        this.total = total;
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", completed=" + completed +
                ", on_hold=" + on_hold +
                ", dropped=" + dropped +
                ", total=" + total +
                ", scores=" + scores.toString() +
                '}';
    }
}
