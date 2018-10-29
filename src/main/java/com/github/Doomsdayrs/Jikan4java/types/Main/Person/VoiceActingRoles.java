package com.github.Doomsdayrs.Jikan4java.types.Main.Person;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VoiceActingRoles {
    @JsonProperty("role")
    private String role;
    @JsonProperty("anime")
    private AnimeBasic animeBasic;
    @JsonProperty("character")
    private CharacterBasic characterBasic;

    public String getRole() {
        return role;
    }

    public AnimeBasic getAnimeBasic() {
        return animeBasic;
    }

    public CharacterBasic getCharacterBasic() {
        return characterBasic;
    }
}
