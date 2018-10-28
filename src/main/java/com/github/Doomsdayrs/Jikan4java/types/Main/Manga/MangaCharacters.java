package com.github.Doomsdayrs.Jikan4java.types.Main.Manga;
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

import java.util.ArrayList;

public class MangaCharacters {
    @JsonProperty("request_hash")
    private String request_hash;

    @JsonProperty("request_cached")
    private boolean request_cached;

    @JsonProperty("request_cache_expiry")
    private int request_cache_expiry;

    @JsonProperty("characters")
    private ArrayList<MangaCharacter> characterArrayList;

    public ArrayList<MangaCharacter> getCharacterArrayList() {
        return characterArrayList;
    }
}
