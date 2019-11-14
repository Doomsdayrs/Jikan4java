package com.github.doomsdayrs.jikan4java.core.search.animemanga;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.doomsdayrs.jikan4java.enums.SortBy;
import com.github.doomsdayrs.jikan4java.enums.genres.AnimeGenres;
import com.github.doomsdayrs.jikan4java.enums.search.Types;
import com.github.doomsdayrs.jikan4java.enums.search.animemanga.Ratings;
import com.github.doomsdayrs.jikan4java.enums.search.animemanga.orderby.AnimeOrderBy;
import com.github.doomsdayrs.jikan4java.enums.search.animemanga.subtype.SubTypes;
import com.github.doomsdayrs.jikan4java.enums.status.AnimeStati;
import com.github.doomsdayrs.jikan4java.types.main.anime.Anime;
import com.github.doomsdayrs.jikan4java.types.main.anime.animePage.AnimePage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.parser.JSONParser;

import java.util.concurrent.CompletableFuture;

/*
 * This file is part of Jikan4java.
 *
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Jikan4java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
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
    public CompletableFuture<Anime> getFirst() {
        return super.getFirst();
    }

    @Override
    public AnimeSearch setQuery(String title) {
        super.setQuery(title);
        return this;
    }

    @Override
    public AnimeSearch setPage(int page) {
        super.setPage(page);
        return this;
    }

    public AnimeSearch setStatus(AnimeStati status) {
        super.setStatus(status);
        return this;
    }

    @Override
    public AnimeSearch setRating(Ratings rating) {
        super.setRating(rating);
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
        super.addGenre(animeGenres);
        return this;
    }

    @Override
    public AnimeSearch setStartDate(int yyyy, int mm, int dd) {
        super.setStartDate(yyyy, mm, dd);
        return this;
    }

    @Override
    public AnimeSearch setEndDate(int yyyy, int mm, int dd) {
        super.setEndDate(yyyy, mm, dd);
        return this;
    }


    public AnimeSearch orderBy(AnimeOrderBy orderBy) {
        super.orderBy(orderBy);
        return this;
    }

    @Override
    public AnimeSearch sortBy(SortBy sortBy) {
        super.sortBy(sortBy);
        return this;
    }

    @Override
    public AnimeSearch setType(SubTypes subTypes) {
        super.setType(subTypes);
        return this;
    }

    @Override
    public CompletableFuture<Anime> getByID(int id) {
        return super.getByID(id);
    }
}
