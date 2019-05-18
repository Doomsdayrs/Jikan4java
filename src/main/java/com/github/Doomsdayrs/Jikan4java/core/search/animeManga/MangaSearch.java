package com.github.Doomsdayrs.Jikan4java.core.search.animeManga;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.enums.SortBy;
import com.github.Doomsdayrs.Jikan4java.enums.genres.MangaGenres;
import com.github.Doomsdayrs.Jikan4java.enums.search.Types;
import com.github.Doomsdayrs.Jikan4java.enums.search.animeManga.Ratings;
import com.github.Doomsdayrs.Jikan4java.enums.search.animeManga.orderBy.MangaOrderBy;
import com.github.Doomsdayrs.Jikan4java.enums.search.animeManga.status.AnimeStati;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.Manga;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.MangaPage.MangaPage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.parser.JSONParser;

import java.util.concurrent.CompletableFuture;

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
public class MangaSearch extends AnimeMangaSearch<MangaPage> {

    public MangaSearch() {
        super(Types.MANGA);
    }

    public MangaSearch(ObjectMapper mapper) {
        super(Types.MANGA, mapper);
    }

    public MangaSearch(Types type, OkHttpClient client) {
        super(type, client);
    }

    public MangaSearch(Types type, JSONParser jsonParser) {
        super(type, jsonParser);
    }

    public MangaSearch(Types type, Request.Builder builder) {
        super(type, builder);
    }


    public MangaSearch addGenre(MangaGenres mangaGenres) {
        super.addGenre(mangaGenres);
        return this;
    }

    @Override
    public CompletableFuture<Manga> getFirst() {
        return (CompletableFuture<Manga>) super.getFirst();
    }

    @Override
    public MangaSearch setPage(int page) {
        super.setPage(page);
        return this;
    }

    @Override
    public MangaSearch setQuery(String title) {
        super.setQuery(title);
        return this;
    }

    @Override
    public MangaSearch setStatus(AnimeStati status) {
        super.setStatus(status);
        return this;
    }

    @Override
    public MangaSearch setRating(Ratings rating) {
        super.setRating(rating);
        return this;
    }

    @Override
    public MangaSearch setScore(float score) {
        super.setScore(score);
        return this;
    }

    @Override
    public MangaSearch toggleGenres() {
        super.toggleGenres();
        return this;
    }

    @Override
    public MangaSearch setLimit(int pages) {
        super.setLimit(pages);
        return this;
    }

    @Override
    public MangaSearch setStartDate(int yyyy, int mm, int dd) {
        super.setStartDate(yyyy, mm, dd);
        return this;
    }

    @Override
    public MangaSearch setEndDate(int yyyy, int mm, int dd) {
        super.setEndDate(yyyy, mm, dd);
        return this;
    }

    public MangaSearch orderBy(MangaOrderBy orderBy) {
        super.orderBy(orderBy);
        return this;
    }

    @Override
    public MangaSearch sortBy(SortBy sortBy) {
        super.sortBy(sortBy);
        return this;
    }
}
