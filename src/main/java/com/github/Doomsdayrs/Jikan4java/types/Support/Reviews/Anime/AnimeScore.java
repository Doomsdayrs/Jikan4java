package com.github.Doomsdayrs.Jikan4java.types.Support.Reviews.Anime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.Reviews.Scores;

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
 * 30 / December / 2018
 *
 * @author github.com/doomsdayrs
 */
public class AnimeScore extends Scores {
    @JsonProperty("overall")
    public int overall;

    @JsonProperty("story")
    public int story;

    @JsonProperty("animation")
    public int animation;

    @JsonProperty("sound")
    public int sound;

    @JsonProperty("character")
    public int character;

    @JsonProperty("enjoyment")
    public int enjoyment;
    
    @Override
    public String toString() {
        return "AnimeScore{" +
                "overall=" + overall +
                ", story=" + story +
                ", animation=" + animation +
                ", sound=" + sound +
                ", character=" + character +
                ", enjoyment=" + enjoyment +
                '}';
    }
}
