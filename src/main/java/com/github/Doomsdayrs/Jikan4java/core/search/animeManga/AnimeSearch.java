package com.github.Doomsdayrs.Jikan4java.core.search.animeManga;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.AnimePage.AnimePage;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.genres.AnimeGenres;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.search.Ratings;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.search.Stati;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.search.Types;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.parser.JSONParser;

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
 * 13 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public class AnimeSearch extends AnimeMangaSearch<AnimePage> {

    public AnimeSearch() {
        super(Types.ANIME);
    }

    public AnimeSearch(ObjectMapper mapper) {
        super(Types.ANIME, mapper);
    }

    public AnimeSearch(Types type, OkHttpClient client) {
        super(type, client);
    }

    public AnimeSearch(Types type, JSONParser jsonParser) {
        super(type, jsonParser);
    }

    public AnimeSearch(Types type, Request.Builder builder) {
        super(type, builder);
    }

    @Override
    public AnimeSearch setPage(int page) {
        super.setPage(page);
        return this;
    }

    @Override
    public AnimeSearch setQuery(String title) {
        super.setQuery(title);
        return this;
    }

    @Override
    public AnimeSearch setStatus(Stati status) {
        super.setStatus(status);
        return this;
    }

    @Override
    public AnimeSearch setRating(Ratings rating) {
        super.setRating(rating);
        return this;
    }

    @Override
    public AnimeSearch addGenre(int genre) {
        super.addGenre(genre);
        return this;
    }

    @Override
    public AnimeSearch setScore(float score) {
        super.setScore(score);
        return this;
    }

    @Override
    public AnimeSearch toggleGenres() {
        super.toggleGenres();
        return this;
    }

    @Override
    public AnimeSearch setLimit(int pages) {
        super.setLimit(pages);
        return this;
    }

    public AnimeSearch addGenre(AnimeGenres animeGenres) {
        super.addGenre(animeGenres.getId());
        return this;
    }
}
