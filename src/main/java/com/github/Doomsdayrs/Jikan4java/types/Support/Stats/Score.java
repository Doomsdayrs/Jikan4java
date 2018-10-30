package com.github.Doomsdayrs.Jikan4java.types.Support.Stats;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Jikan4java
 * 29 / October / 2018
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
public class Score {
    @JsonProperty("votes")
    private int votes;
    @JsonProperty("percentage")
    private double percentage;

    public int getVotes() {
        return votes;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return "Scores{" +
                "votes=" + votes +
                ", percentage=" + percentage +
                '}';
    }
}
