package com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Character_staff;
/*
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
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.MALData;

import java.util.ArrayList;
/**
 * Jikan4java
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Staff implements MALData {
    @JsonProperty("name")
    private String name;
    @JsonProperty("positions")
    private ArrayList<String> positions;

    /**
     * @return myanimelist id
     */
    public int getMal_id() {
        return mal_id;
    }

    /**
     * @return url of staff member
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return name of staff member
     */
    public String getName() {
        return name;
    }

    /**
     * @return image url of the staff member
     */
    public String getImage_url() {
        return image_url;
    }

    /**
     * @return the positions the staff member has
     */
    public ArrayList<String> getPositions() {
        return positions;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", positions=" + positions +
                ", mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}

