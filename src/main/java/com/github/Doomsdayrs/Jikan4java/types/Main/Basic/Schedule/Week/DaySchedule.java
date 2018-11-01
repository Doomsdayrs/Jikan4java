package com.github.Doomsdayrs.Jikan4java.types.Main.Basic.Schedule.Week;

import com.github.Doomsdayrs.Jikan4java.types.Support.SubAnime;

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
public class DaySchedule {
    private String request_hash;
    private boolean request_cached;
    private int request_cache_expiry;
    private ArrayList<SubAnime> day;

    public String getRequest_hash() {
        return request_hash;
    }

    public boolean isRequest_cached() {
        return request_cached;
    }

    public int getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    public ArrayList<SubAnime> getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "DaySchedule{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", day=" + day +
                '}';
    }
}

