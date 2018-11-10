package com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Anime;
import com.github.Doomsdayrs.Jikan4java.types.Main.Character.Character;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.Manga;
import com.github.Doomsdayrs.Jikan4java.types.Main.Person.Person;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Character.TopCharacterAnime;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Objects.Character.TopCharacterManga;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
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
 * 01 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class TopList {
    //Universal
    private int mal_id;
    private int rank;
    private String title;
    private String url;
    private String type;
    private String start_date;
    private String end_date;
    private String image_url;
    private int members;
    private float score;
    private int favorites;
    private String name_kanji;

    //Character
    private ArrayList<TopCharacterAnime> characterAnimes;
    private ArrayList<TopCharacterManga> characterMangas;

    //Person
    private String birthday;

    //Manga
    private int volumes;

    //Anime
    private int episodes;


    public int getMal_id() {
        return mal_id;
    }

    public int getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getImage_url() {
        return image_url;
    }

    public int getMembers() {
        return members;
    }

    public float getScore() {
        return score;
    }

    public int getFavorites() {
        return favorites;
    }

    public String getName_kanji() {
        return name_kanji;
    }

    public ArrayList<TopCharacterAnime> getCharacterAnimes() {
        return characterAnimes;
    }

    public ArrayList<TopCharacterManga> getCharacterMangas() {
        return characterMangas;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getVolumes() {
        return volumes;
    }

    public int getEpisodes() {
        return episodes;
    }

    /**
     * Applies only to TopCharacter
     * Returns the Character object of this object
     *
     * @return Character Object
     * @throws IOException
     * @throws ParseException
     */
    public Character getCharacter() throws IOException, ParseException {
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("api.jikan.moe/v3/character/" + mal_id).build()).execute().body().string())).toJSONString(), Character.class);
    }

    /**
     * Applies only to TopManga
     * Returns the Manga object of this object
     *
     * @return Manga Object
     * @throws IOException
     * @throws ParseException
     */
    public Manga getManga() throws IOException, ParseException {
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("api.jikan.moe/v3/character/" + mal_id).build()).execute().body().string())).toJSONString(), Manga.class);
    }

    /**
     * Applies to only TopAnime
     * Returns the Anime object of this object
     *
     * @return Anime Object
     * @throws IOException
     * @throws ParseException
     */
    public Anime getAnime() throws IOException, ParseException {
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("api.jikan.moe/v3/character/" + mal_id).build()).execute().body().string())).toJSONString(), Anime.class);
    }

    /**
     * Applies to only TopPerson
     * Returns the Person object of this object
     *
     * @return Person Object
     * @throws IOException
     * @throws ParseException
     */
    public Person getPerson() throws IOException, ParseException {
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(((JSONObject) new JSONParser().parse(new OkHttpClient().newCall(new Request.Builder().url("api.jikan.moe/v3/manga/" + mal_id).build()).execute().body().string())).toJSONString(), Person.class);
    }

    @Override
    public String toString() {
        return "TopList{" +
                "mal_id=" + mal_id +
                ", rank=" + rank +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", image_url='" + image_url + '\'' +
                ", members=" + members +
                ", score=" + score +
                ", favorites=" + favorites +
                ", name_kanji='" + name_kanji + '\'' +
                ", characterAnimes=" + characterAnimes +
                ", characterMangas=" + characterMangas +
                ", birthday='" + birthday + '\'' +
                ", volumes=" + volumes +
                ", episodes=" + episodes +
                '}';
    }
}
