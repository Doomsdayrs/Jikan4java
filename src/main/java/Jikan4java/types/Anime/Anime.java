package Jikan4java.types.Anime;

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
public class Anime {
    private int mal_id;
    private String url;
    private String iconURL;
    private String trailer_url;
    private String title;
    private String title_english;
    private String title_japanese;
    private String type;
    private String source;
    private int episodes;
    private String status;
    private String aired;
    private String duration;
    private String rating;
    private double score;
    private int scored_By;
    private int rank;
    private int members;
    private int favorites;
    private String synopsis;
    private String background;
    private String premiered;
    private ArrayList<String> genres;
    private ArrayList<String> opening_themes;
    private ArrayList<String> ending_themes;

    /**
     * Anime object constructor without variables
     */
    public Anime() {
    }

    /**
     * Anime object constructor
     *
     * @param mal_id         ID of the Anime
     * @param url            URL of the Anime
     * @param iconURL        Icon URL of the Anime
     * @param trailer_url    Trailer of the Anime
     * @param title          Tile of the Anime
     * @param title_english  English title of the Anime
     * @param title_japanese Japanese title of the Anime
     * @param type           Type of Anime
     * @param source         Source material of the Anime
     * @param episodes       Episodes of the Anime
     * @param status         Current status of the Anime
     * @param aired          The time frame of being aired
     * @param duration       Duration of each episode
     * @param rating         Rating of Anime
     * @param score          Score of the Anime
     * @param scoredBy       How many people scored the Anime
     * @param rank           Ranking ofthe Anime
     * @param members        Members affiliated with Anime
     * @param favorites      How many people favor this Anime
     * @param synopsis       Synopsis of the Anime
     * @param background     Background of the Anime
     * @param premiered      Premire date of Anime
     * @param genres         Genres of Anime
     * @param opening_themes Openings of Anime
     * @param ending_themes  Endings of Anime
     */
    public Anime(int mal_id, String url, String iconURL, String trailer_url, String title, String title_english, String title_japanese,
                 String type, String source, int episodes, String status, String aired, String duration, String rating,
                 double score, int scoredBy, int rank, int members, int favorites, String synopsis, String background,
                 String premiered, ArrayList<String> genres, ArrayList<String> opening_themes, ArrayList<String> ending_themes) {
        this.mal_id = mal_id;
        this.url = url;
        this.iconURL = iconURL;
        this.trailer_url = trailer_url;

        this.title = title;
        this.title_english = title_english;
        this.title_japanese = title_japanese;
        this.type = type;
        this.source = source;
        this.episodes = episodes;
        this.status = status;
        this.aired = aired;
        this.duration = duration;
        this.rating = rating;
        this.score = score;
        this.scored_By = scoredBy;
        this.rank = rank;
        this.members = members;
        this.favorites = favorites;
        this.synopsis = synopsis;
        this.background = background;
        this.premiered = premiered;
        this.genres = genres;
        this.opening_themes = opening_themes;
        this.ending_themes = ending_themes;
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
     * Returns iconURL
     */
    public String getIconURL() {
        return iconURL;
    }

    /**
     * Returns trailer_url
     */
    public String getTrailer_url() {
        return trailer_url;
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
     * Returns title_japanese
     */
    public String getTitle_japanese() {
        return title_japanese;
    }

    /**
     * Returns type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns source
     */
    public String getSource() {
        return source;
    }

    /**
     * Returns episodes
     */
    public int getEpisodes() {
        return episodes;
    }

    /**
     * Returns status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Returns aired
     */
    public String getAired() {
        return aired;
    }

    /**
     * Returns duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Returns rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * Returns score
     */
    public double getScore() {
        return score;
    }

    /**
     * Returns scoredBy
     */
    public int getScoredBy() {
        return scored_By;
    }

    /**
     * Returns rank
     */
    public int getRank() {
        return rank;
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
     * Returns premiered
     */
    public String getPremiered() {
        return premiered;
    }

    /**
     * Returns genres
     */
    public ArrayList<String> getGenres() {
        return genres;
    }

    /**
     * Returns opening_themes
     */
    public ArrayList<String> getOpening_themes() {
        return opening_themes;
    }

    /**
     * Returns ending_themes
     */
    public ArrayList<String> getEnding_themes() {
        return ending_themes;
    }

    /**
     * To string method
     *
     * @return Anime object data
     */
    public String toString() {
        return mal_id +
                "\n" + url + "\n" + iconURL +
                "\n" + trailer_url + "\n" + title +
                "\n" + title_english + "\n" + title_japanese +
                "\n" + type + "\n" + source +
                "\n" + episodes + "\n" + status +
                "\n" + aired + "\n" + duration +
                "\n" + rating + "\n" + score +
                "\n" + scored_By + "\n" + rank +
                "\n" + members + "\n" + favorites +
                "\n" + synopsis + "\n" + background +
                "\n" + premiered + "\n" + genres.toString() +
                "\n" + opening_themes.toString() + "\n" + ending_themes.toString();
    }
}
