package com.github.Doomsdayrs.Jikan4java.types.Main.Person;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PublishedManga {
    @JsonProperty("position")
    private String position;

    @JsonProperty("manga")
    private MangaBasic mangaBasic;

    public String getPosition() {
        return position;
    }

    public MangaBasic getMangaBasic() {
        return mangaBasic;
    }
}
