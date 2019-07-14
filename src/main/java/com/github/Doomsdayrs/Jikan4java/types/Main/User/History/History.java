package com.github.Doomsdayrs.Jikan4java.types.Main.User.History;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.Basic.BasicMeta;

/*
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Jikan4java is distributed in the hope that it will be useful,
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
public class History {
    @JsonProperty("meta")
    public BasicMeta basicMeta;
    @JsonProperty("increment")
    public int increment;
    @JsonProperty("date")
    public String date;
    

    @Override
    public String toString() {
        return "History{" +
                "meta=" + basicMeta +
                ", increment=" + increment +
                ", date='" + date + '\'' +
                '}';
    }
}
