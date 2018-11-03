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
public class MangaStats {
    @JsonProperty("days_read")
    private int days_read;
    @JsonProperty("mean_score")
    private int mean_score;
    @JsonProperty("reading")
    private int reading;
    @JsonProperty("completed")
    private int completed;
    @JsonProperty("on_hold")
    private int on_hold;
    @JsonProperty("dropped")
    private int dropped;
    @JsonProperty("plan_to_read")
    private int plan_to_read;
    @JsonProperty("total_entries")
    private int total_entries;
    @JsonProperty("reread")
    private int reread;
    @JsonProperty("chapters_read")
    private int chapters_read;
    @JsonProperty("volumes_read")
    private int volumes_read;

    public int getDays_read() {
        return days_read;
    }

    public int getMean_score() {
        return mean_score;
    }

    public int getReading() {
        return reading;
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

    public int getPlan_to_read() {
        return plan_to_read;
    }

    public int getTotal_entries() {
        return total_entries;
    }

    public int getReread() {
        return reread;
    }

    public int getChapters_read() {
        return chapters_read;
    }

    public int getVolumes_read() {
        return volumes_read;
    }

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
