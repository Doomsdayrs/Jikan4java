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
    private Position one;
    @JsonProperty("2")
    private Position two;
    @JsonProperty("3")
    private Position three;
    @JsonProperty("4")
    private Position four;
    @JsonProperty("5")
    private Position five;
    @JsonProperty("6")
    private Position six;
    @JsonProperty("7")
    private Position seven;
    @JsonProperty("8")
    private Position eight;
    @JsonProperty("9")
    private Position nine;
    @JsonProperty("10")
    private Position ten;

    public Position getOne() {
        return one;
    }

    public Position getTwo() {
        return two;
    }

    public Position getThree() {
        return three;
    }

    public Position getFour() {
        return four;
    }

    public Position getFive() {
        return five;
    }

    public Position getSix() {
        return six;
    }

    public Position getSeven() {
        return seven;
    }

    public Position getEight() {
        return eight;
    }

    public Position getNine() {
        return nine;
    }

    public Position getTen() {
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
