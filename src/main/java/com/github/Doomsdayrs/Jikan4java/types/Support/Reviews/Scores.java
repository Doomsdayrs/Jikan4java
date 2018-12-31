package com.github.Doomsdayrs.Jikan4java.types.Support.Reviews;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 30 / December / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Scores {

    @JsonProperty("overall")
    private int overall;

    @JsonProperty("story")
    private int story;

    @JsonProperty("character")
    private int character;

    @JsonProperty("enjoyment")
    private int enjoyment;


    public int getOverall() {
        return overall;
    }

    public int getStory() {
        return story;
    }

    public int getCharacter() {
        return character;
    }

    public int getEnjoyment() {
        return enjoyment;
    }

    @Override
    public String toString() {
        return "Scores{" +
                "overall=" + overall +
                ", story=" + story +
                ", character=" + character +
                ", enjoyment=" + enjoyment +
                '}';
    }
}
