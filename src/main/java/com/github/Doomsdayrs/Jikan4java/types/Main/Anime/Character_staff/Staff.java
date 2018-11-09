package com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Character_staff;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

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
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Staff {
    @JsonProperty("mal_id")
    private int mal_id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("image_url")
    private String image_url;
    @JsonProperty("positions")
    private ArrayList<String> positions;

    /**
     * Gets MAL ID
     * @return myanimelist id
     */
    public int getMal_id() {
        return mal_id;
    }

    /**
     * Gets URL of staff member
     * @return url of staff member
     */
    public String getUrl() {
        return url;
    }

    /**
     * Gets name of member
     * @return name of staff member
     */
    public String getName() {
        return name;
    }

    /**
     * Gets image of member
     * @return image url of the staff member
     */
    public String getImage_url() {
        return image_url;
    }

    /**
     * Gets Positions member
     * @return the positions the staff member has
     */
    public ArrayList<String> getPositions() {
        return positions;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", image_url='" + image_url + '\'' +
                ", positions=" + positions +
                '}';
    }
}

