package com.github.Doomsdayrs.Jikan4java.types.Support.Related;

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
public class Related {

    @JsonProperty("Prequel")
    private ArrayList<RelatedType> prequel;

    @JsonProperty("Alternative version")
    private ArrayList<RelatedType> altVersion;

    @JsonProperty("Spin-off")
    private ArrayList<RelatedType> spinOff;

    @JsonProperty("Adaptation")
    private ArrayList<RelatedType> adaptation;

    @JsonProperty("Summary")
    private ArrayList<RelatedType> summaries;

    @JsonProperty("Sequel")
    private ArrayList<RelatedType> sequels;

    @JsonProperty("Side story")
    private ArrayList<RelatedType> sideStories;

    @JsonProperty("Other")
    private ArrayList<RelatedType> other;

    @JsonProperty("Parent story")
    private ArrayList<RelatedType> parentStories;

    @JsonProperty("Alternative setting")
    private ArrayList<RelatedType> alternativeSettings;

    @JsonProperty("Character")
    private ArrayList<RelatedType> characters;

    @JsonProperty("Full story")
    private ArrayList<RelatedType> fullStories;

    public ArrayList<RelatedType> get(Relates type) {
        switch (type.getId())
        {
            default: return new ArrayList<>();
            case 0:  return prequel;
            case 1:  return altVersion;
            case 2:  return spinOff;
            case 3:  return adaptation;
            case 4:  return sequels;
            case 5:  return sideStories;
            case 6:  return other;
            case 7:  return parentStories;
            case 8:  return alternativeSettings;
            case 9:  return characters;
            case 10: return summaries;
            case 11: return fullStories;
        }

    }

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
