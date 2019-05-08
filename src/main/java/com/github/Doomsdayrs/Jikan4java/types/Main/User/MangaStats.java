package com.github.Doomsdayrs.Jikan4java.types.Main.User;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
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
