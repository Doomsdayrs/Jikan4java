package com.github.Doomsdayrs.Jikan4java.types.Main.Person;
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

public class AnimeStaffPosition {
    @JsonProperty("position")
    private String position;

    @JsonProperty("anime")
    private AnimeBasic animeBasic;

    public String getPosition() {
        return position;
    }

    public AnimeBasic getAnimeBasic() {
        return animeBasic;
    }
}
