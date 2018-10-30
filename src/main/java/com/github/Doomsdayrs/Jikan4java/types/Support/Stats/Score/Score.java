package com.github.Doomsdayrs.Jikan4java.types.Support.Stats.Score;

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
    @JsonProperty("1")
    private Postion one;
    @JsonProperty("2")
    private Postion two;
    @JsonProperty("3")
    private Postion three;
    @JsonProperty("4")
    private Postion four;
    @JsonProperty("5")
    private Postion five;
    @JsonProperty("6")
    private Postion six;
    @JsonProperty("7")
    private Postion seven;
    @JsonProperty("8")
    private Postion eight;
    @JsonProperty("9")
    private Postion nine;
    @JsonProperty("10")
    private Postion ten;

    public Postion getOne() {
        return one;
    }

    public Postion getTwo() {
        return two;
    }

    public Postion getThree() {
        return three;
    }

    public Postion getFour() {
        return four;
    }

    public Postion getFive() {
        return five;
    }

    public Postion getSix() {
        return six;
    }

    public Postion getSeven() {
        return seven;
    }

    public Postion getEight() {
        return eight;
    }

    public Postion getNine() {
        return nine;
    }

    public Postion getTen() {
        return ten;
    }

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
