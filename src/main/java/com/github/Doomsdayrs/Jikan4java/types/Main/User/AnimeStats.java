package com.github.Doomsdayrs.Jikan4java.types.Main.User;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Jikan4java
 * 03 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
 /*
This file is part of Jikan4java.

Jikan4java is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Foobar is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
*/
public class AnimeStats {
    @JsonProperty("days_watched")
    private float days_watched;
    @JsonProperty("mean_score")
    private float mean_score;
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
    @JsonProperty("total_entries")
    private int total_entries;
    @JsonProperty("rewatched")
    private int rewatched;
    @JsonProperty("episodes_watched")
    private int episodes_watched;

    public float getDays_watched() {
        return days_watched;
    }

    public float getMean_score() {
        return mean_score;
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

    public int getTotal_entries() {
        return total_entries;
    }

    public int getRewatched() {
        return rewatched;
    }

    public int getEpisodes_watched() {
        return episodes_watched;
    }

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
