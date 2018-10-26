package Jikan4java.types.Manga;

import java.util.ArrayList;

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
public class Manga {
    private int mal_id;
    private String url;
    private String title;
    private String title_english;
    private ArrayList<String> title_synonyms;
    private String title_japanese;
    private String status;
    private String image_url;
    private int volumes;
    private int chapters;
    private String publishing;
    private String published;
    private int rank;
    private int scored_By;
    private int popularity;
    private int members;
    private int favorites;
    private String synopsis;
    private String background;
    private ArrayList<String> genres;
    private ArrayList<String> serializations;

    /**
     * Manga object constructor without variables
     */
    public Manga() {
    }

    /**
     * Manga object constructor
     *
     * @param mal_id         ID of the Manga
     * @param url            URL of the Manga
     * @param title          Tile of the Manga
     * @param title_english  English title of the Manga
     * @param title_synonyms Different versions of the title
     * @param title_japanese Japanese title of the Manga
     * @param status         Current status of the Manga
     * @param image_url      Image url of Manga
     * @param volumes        Number of volumes in Manga
     * @param chapters       Number of chapters in Manga
     * @param publishing     Publising or not of the Manga
     * @param published      Published or not of the Manga
     * @param rank           Ranking of the Manga
     * @param scored_By      How many people scored the Manga
     * @param popularity     Popularity of the Manga
     * @param members        Members affiliated with Manga
     * @param favorites      How many people favor this Manga
     * @param synopsis       Synopsis of the Manga
     * @param background     Background of the Manga
     * @param genres         Genres of Manga
     * @param serializations Serializationgs(?) of the Manga
     */
    public Manga(int mal_id,
                 String url, String title, String title_english,
                 ArrayList<String> title_synonyms,
                 String title_japanese, String status, String image_url,
                 int volumes, int chapters,
                 String publishing, String published,
                 int rank, int scored_By, int popularity, int members, int favorites,
                 String synopsis, String background,
                 ArrayList<String> genres, ArrayList<String> serializations) {
        this.mal_id = mal_id;
        this.url = url;
        this.title = title;
        this.title_english = title_english;
        this.title_synonyms = title_synonyms;
        this.title_japanese = title_japanese;
        this.status = status;
        this.image_url = image_url;
        this.volumes = volumes;
        this.chapters = chapters;
        this.publishing = publishing;
        this.published = published;
        this.rank = rank;
        this.scored_By = scored_By;
        this.popularity = popularity;
        this.members = members;
        this.favorites = favorites;
        this.synopsis = synopsis;
        this.background = background;
        this.genres = genres;
        this.serializations = genres;
    }

    /**
     * Returns mal_id
     */
    public int getMal_id() {
        return mal_id;
    }

    /**
     * Returns url
     */
    public String getUrl() {
        return url;
    }



    /**
     * Returns title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns title_english
     */
    public String getTitle_english() {
        return title_english;
    }

    /**
     * Returns title synonyms
     */
    public ArrayList<String> getTitle_synonyms() {
        return title_synonyms;
    }

    /**
     * Returns title_japanese
     */
    public String getTitle_japanese() {
        return title_japanese;
    }

    /**
     * Returns status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return The image url
     */
    public String getImage_url() {
        return image_url;
    }

    public int getVolumes() {
        return volumes;
    }

    public int getChapters() {
        return chapters;
    }

    public String getPublishing() {
        return publishing;
    }

    public String getPublished() {
        return published;
    }

    /**
     * Returns rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * Returns scoredBy
     */
    public int getScoredBy() {
        return scored_By;
    }

    public int getPopularity() {
        return popularity;
    }

    /**
     * Returns members
     */
    public int getMembers() {
        return members;
    }

    /**
     * Returns favorites
     */
    public int getFavorites() {
        return favorites;
    }

    /**
     * Returns synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Returns background
     */
    public String getBackground() {
        return background;
    }

    /**
     * @return Serializations
     */
    public ArrayList<String> getSerializations() {
        return serializations;
    }

    /**
     * Returns genres
     */
    public ArrayList<String> getGenres() {
        return genres;
    }

    /**
     * To string method
     *
     * @return Manga object data
     */
    public String toString() {
        return mal_id +
                "\n" + url + "\n" +  title +
                "\n" + title_english + "\n" + title_synonyms +
                "\n" + title_synonyms + "\n" + title_japanese +
                "\n" + status + "\n" + image_url +
                "\n" + volumes + "\n" + chapters +
                "\n" + publishing + "\n" + published +
                "\n" + rank + "\n" + scored_By +
                "\n" + popularity + "\n" + members +
                "\n" + favorites + "\n" + synopsis +
                "\n" + background + "\n" + "\n" + genres.toString() +
                "\n" + serializations.toString();
    }
}
