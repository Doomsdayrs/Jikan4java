package com.github.doomsdayrs.jikan4java.types.support.basic.meta;

import com.fasterxml.jackson.annotation.JsonProperty;

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
 * ====================================================================*//**
 * Jikan4java
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Authors extends BasicMeta {
    public Authors(@JsonProperty("mal_id") int mal_id,
                   @JsonProperty("type") String type,
                   @JsonProperty("name") String name,
                   @JsonProperty("url") String url) {
        super(mal_id, type, name, url);
    }

    @Override
    public String toString() {
        return "Authors{" +
                "mal_id=" + mal_id +
                ", subType='" + type + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
