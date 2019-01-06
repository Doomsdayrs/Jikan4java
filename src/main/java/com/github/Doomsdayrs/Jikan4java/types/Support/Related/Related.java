package com.github.Doomsdayrs.Jikan4java.types.Support.Related;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private ArrayList<RelatedType> character;



    public ArrayList<RelatedType> get(Relates type) {
        if (type.getId() == 0) {
            return prequel;
        } else if (type.getId() == 1) {
            return altVersion;
        } else if (type.getId() == 2) {
            return spinOff;
        } else if (type.getId() == 3) {
            return adaptation;
        } else if (type.getId() == 4) {
            return summaries;
        } else if (type.getId() == 5) {
            return sequels;
        } else if (type.getId() == 6) {
            return sideStories;
        } else if (type.getId() == 7) {
            return parentStories;
        }   else if (type.getId() == 8) {
                return alternativeSettings;
        }   else if (type.getId() == 9) {
            return character;
        } else return new ArrayList<>();
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
                ", parentStories=" + alternativeSettings +
                '}';
    }
}
