package com.github.doomsdayrs.jikan4java.types.support.related;

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
public class Related {

    @SuppressWarnings("WeakerAccess")

    @JsonProperty("Prequel")
    public ArrayList<RelatedType> prequel;
    @SuppressWarnings("WeakerAccess")

    @JsonProperty("Alternative version")
    public ArrayList<RelatedType> altVersion;
    @SuppressWarnings("WeakerAccess")

    @JsonProperty("Spin-off")
    public ArrayList<RelatedType> spinOff;

    @JsonProperty("Adaptation")
    public ArrayList<RelatedType> adaptation;
    @SuppressWarnings("WeakerAccess")

    @JsonProperty("Summary")
    public ArrayList<RelatedType> summaries;
    @SuppressWarnings("WeakerAccess")

    @JsonProperty("Sequel")
    public ArrayList<RelatedType> sequels;

    @SuppressWarnings("WeakerAccess")
    @JsonProperty("Side story")
    public ArrayList<RelatedType> sideStories;

    @JsonProperty("Other")
    public ArrayList<RelatedType> other;
    @SuppressWarnings("WeakerAccess")

    @JsonProperty("Parent story")
    public ArrayList<RelatedType> parentStories;
    @SuppressWarnings("WeakerAccess")

    @JsonProperty("Alternative setting")
    public ArrayList<RelatedType> alternativeSettings;

    @JsonProperty("Character")
    public ArrayList<RelatedType> characters;
    @SuppressWarnings("WeakerAccess")

    @JsonProperty("Full story")
    public ArrayList<RelatedType> fullStories;

    @Override
    public String toString() {
        return "Related{" +
                "prequel=" + prequel +
                ", altVersion=" + altVersion +
                ", spinOff=" + spinOff +
                ", adaptation=" + adaptation +
                ", summaries=" + summaries +
                ", sequels=" + sequels +
                ", sideStories=" + sideStories +
                ", other=" + other +
                ", parentStories=" + parentStories +
                ", alternativeSettings=" + alternativeSettings +
                ", characters=" + characters +
                ", fullStories=" + fullStories +
                '}';
    }
}
