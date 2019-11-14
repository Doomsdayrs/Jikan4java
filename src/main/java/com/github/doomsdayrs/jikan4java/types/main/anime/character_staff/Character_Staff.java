package com.github.doomsdayrs.jikan4java.types.main.anime.character_staff;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/*
 * This file is part of Jikan4java.
 *
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Jikan4java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Character_Staff {

    @JsonProperty("request_hash")
    public String request_hash;

    @JsonProperty("request_cached")
    public boolean request_cached;

    @JsonProperty("request_cache_expiry")
    public int request_cache_expiry;

    @JsonProperty("characters")
    public ArrayList<AnimeCharacter> animeCharacters;

    @JsonProperty("staff")
    public ArrayList<Staff> staff;

    @Override
    public String toString() {
        return "Character_Staff{" +
                "request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", animeCharacters=" + animeCharacters +
                ", staff=" + staff +
                '}';
    }
}
