package com.github.Doomsdayrs.Jikan4java.types.Main.Person;

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
