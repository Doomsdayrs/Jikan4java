package com.github.Doomsdayrs.Jikan4java.types.Support.Stats.Score;

import com.fasterxml.jackson.annotation.JsonProperty;

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
 * 29 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Score {
    @JsonProperty("1")
    public Position one;
    @JsonProperty("2")
    public Position two;
    @JsonProperty("3")
    public Position three;
    @JsonProperty("4")
    public Position four;
    @JsonProperty("5")
    public Position five;
    @JsonProperty("6")
    public Position six;
    @JsonProperty("7")
    public Position seven;
    @JsonProperty("8")
    public Position eight;
    @JsonProperty("9")
    public Position nine;
    @JsonProperty("10")
    public Position ten;
    
    @Override
    public String toString() {
        return "Score{" +
                "one=" + one +
                ", two=" + two +
                ", three=" + three +
                ", four=" + four +
                ", five=" + five +
                ", six=" + six +
                ", seven=" + seven +
                ", eight=" + eight +
                ", nine=" + nine +
                ", ten=" + ten +
                '}';
    }
}
