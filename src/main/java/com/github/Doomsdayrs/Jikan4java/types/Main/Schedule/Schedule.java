/*
 *
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
 * /
 */

/*
 *
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
 * /
 */

package com.github.Doomsdayrs.Jikan4java.types.Main.Schedule;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Jikan4java
 * 01 / November / 2018
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
public class Schedule {
    @JsonProperty("request_hash")
    private String request_hash;
    @JsonProperty("request_cached")
    private boolean request_cached;
    @JsonProperty("request_cache_expiry")
    private int request_cache_expiry;

    @JsonProperty("monday")
    private ArrayList<SubAnime> monday;
    @JsonProperty("tuesday")
    private ArrayList<SubAnime> tuesday;
    @JsonProperty("wednesday")
    private ArrayList<SubAnime> wednesday;
    @JsonProperty("thursday")
    private ArrayList<SubAnime> thursday;
    @JsonProperty("friday")
    private ArrayList<SubAnime> friday;
    @JsonProperty("saturday")
    private ArrayList<SubAnime> saturday;
    @JsonProperty("sunday")
    private ArrayList<SubAnime> sunday;
    @JsonProperty("other")
    private ArrayList<SubAnime> others;
    @JsonProperty("unknown")
    private ArrayList<SubAnime> unknown;

    public String getRequest_hash() {
        return request_hash;
    }

    public boolean isRequest_cached() {
        return request_cached;
    }

    public int getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    public ArrayList<SubAnime> getMonday() {
        return monday;
    }

    public ArrayList<SubAnime> getTuesday() {
        return tuesday;
    }

    public ArrayList<SubAnime> getWednesday() {
        return wednesday;
    }

    public ArrayList<SubAnime> getThursday() {
        return thursday;
    }

    public ArrayList<SubAnime> getFriday() {
        return friday;
    }

    public ArrayList<SubAnime> getSaturday() {
        return saturday;
    }

    public ArrayList<SubAnime> getSunday() {
        return sunday;
    }

    public ArrayList<SubAnime> getOthers() {
        return others;
    }

    public ArrayList<SubAnime> getUnknown() {
        return unknown;
    }

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
