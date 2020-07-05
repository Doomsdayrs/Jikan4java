package com.github.doomsdayrs.jikan4java.model.main.season.seasonarchive;

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
public class Archive {
    @JsonProperty("year")
    public int year;
    @JsonProperty("seasons")
    public ArrayList<String> seasons;
    
    @Override
    public String toString() {
        return "Archive{" +
                "year=" + year +
                ", seasons=" + seasons +
                '}';
    }
}
