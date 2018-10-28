package Jikan4java.types.Support.Related;
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

import Jikan4java.types.Support.Related.Types.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Related {

    @JsonProperty("prequel")
    private ArrayList<Prequel> prequel;

    @JsonProperty("Alternative version")
    private ArrayList<AltVersion> altVersion;

    @JsonProperty("Spin-off")
    private ArrayList<SpinOff> spinOff;

    @JsonProperty("Adaptation")
    private ArrayList<Adaptation> adaptation;

    @JsonProperty("Summary")
    private ArrayList<Summary> summaries;

    @JsonProperty("Sequel")
    private ArrayList<Sequel> sequels;

    @JsonProperty("Side story")
    private ArrayList<SideStory> sideStories;

    @JsonProperty("Other")
    private ArrayList<Other> other;

    public ArrayList<Prequel> getPrequel() {
        return prequel;
    }

    public ArrayList<AltVersion> getAltVersion() {
        return altVersion;
    }

    public ArrayList<SpinOff> getSpinOff() {
        return spinOff;
    }

    public ArrayList<Adaptation> getAdaptation() {
        return adaptation;
    }

    public ArrayList<Summary> getSummaries() {
        return summaries;
    }

    public ArrayList<Sequel> getSequels() {
        return sequels;
    }

    public ArrayList<SideStory> getSideStories() {
        return sideStories;
    }

    public ArrayList<Other> getOther() {
        return other;
    }
}
