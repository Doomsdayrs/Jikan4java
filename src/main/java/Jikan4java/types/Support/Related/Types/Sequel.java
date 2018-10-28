package Jikan4java.types.Support.Related.Types;
/**
 * Jikan4java
 * 28 / October / 2018
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

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sequel {

    @JsonProperty("mal_id")
    private int mal_id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;

    public int getMal_id() {
        return mal_id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
