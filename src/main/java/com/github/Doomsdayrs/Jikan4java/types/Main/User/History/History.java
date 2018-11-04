package com.github.Doomsdayrs.Jikan4java.types.Main.User.History;

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
public class History {
    @JsonProperty("meta")
    private Meta meta;
    @JsonProperty("increment")
    private int increment;
    @JsonProperty("date")
    private String date;

    public Meta getMeta() {
        return meta;
    }

    public int getIncrement() {
        return increment;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "History{" +
                "meta=" + meta +
                ", increment=" + increment +
                ", date='" + date + '\'' +
                '}';
    }
}
