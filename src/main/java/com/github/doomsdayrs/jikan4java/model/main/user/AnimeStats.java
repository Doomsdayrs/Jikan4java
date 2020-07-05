package com.github.doomsdayrs.jikan4java.model.main.user;

import com.fasterxml.jackson.annotation.JsonProperty;

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
 * 03 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class AnimeStats {
    @JsonProperty("days_watched")
    public float days_watched;
    @JsonProperty("mean_score")
    public float mean_score;
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
    @JsonProperty("total_entries")
    public int total_entries;
    @JsonProperty("rewatched")
    public int rewatched;
    @JsonProperty("episodes_watched")
    public int episodes_watched;

    @Override
    public String toString() {
        return "AnimeStats{" +
                "days_watched=" + days_watched +
                ", mean_score=" + mean_score +
                ", watching=" + watching +
                ", completed=" + completed +
                ", on_hold=" + on_hold +
                ", dropped=" + dropped +
                ", plan_to_watch=" + plan_to_watch +
                ", total_entries=" + total_entries +
                ", rewatched=" + rewatched +
                ", episodes_watched=" + episodes_watched +
                '}';
    }
}
