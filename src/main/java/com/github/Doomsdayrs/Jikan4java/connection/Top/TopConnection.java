package com.github.Doomsdayrs.Jikan4java.connection.Top;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.enums.top.*;
import com.github.Doomsdayrs.Jikan4java.exceptions.IncompatibleEnumException;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Top;

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
 * 31 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
@Deprecated
public class TopConnection extends Retriever {

    /**
     * Constructor
     */
    public TopConnection() {
        super(new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true));
    }

    /**
     * Searches the top charts of MAL, with all default cases
     *
     * @param tops What subType of media: anime, manga, people, characters
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops) throws IncompatibleEnumException {
        return searchCore(tops, 0, null);
    }

    /**
     * Searches the top charts of MAL, with subtype defaulted
     *
     * @param tops       What subType of media: anime, manga, people, characters
     * @param pageNumber Should be 1 by default, Each page has 50 entries; Page 2 would be the next page, so 50 - 100
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops, int pageNumber) throws IncompatibleEnumException {
        return searchCore(tops, pageNumber, null);
    }


    /**
     * Searches the top charts of MAL, page defaulted
     *
     * @param tops    What subType of media: anime, manga, people, characters
     * @param subtype Shared subcategory to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops, SharedTops subtype) throws IncompatibleEnumException {
        return searchSub(tops, subtype);
    }

    /**
     * Searches the top charts of MAL, page defaulted
     *
     * @param tops    What subType of media: anime, manga, people, characters
     * @param subtype The Anime subcategory to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops, AnimeTops subtype) throws IncompatibleEnumException {
        return searchSub(tops, subtype);
    }

    /**
     * Searches the top charts of MAL, page defaulted
     *
     * @param tops    What subType of media: anime, manga, people, characters
     * @param subtype The Manga subcategory to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops, MangaTops subtype) throws IncompatibleEnumException {
        return searchSub(tops, subtype);
    }

    /**
     * Searches the top charts of MAL, with subtype defaulted
     *
     * @param tops    What subType of media: anime, manga, people, characters
     * @param subtype The sub category to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchSub(Tops tops, TopSubType subtype) throws IncompatibleEnumException {
        return searchCore(tops, 0, subtype);
    }


    /**
     * Searches the top charts of MAL
     *
     * @param tops       What subType of media: anime, manga, people, characters
     * @param pageNumber Should be 1 by default, Each page has 50 entries; Page 2 would be the next page, so 50 - 100
     * @param subtype    The sub category to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops, int pageNumber, AnimeTops subtype) throws IncompatibleEnumException {
        return searchCore(tops, pageNumber, subtype);
    }

    /**
     * Searches the top charts of MAL
     *
     * @param tops       What subType of media: anime, manga, people, characters
     * @param pageNumber Should be 1 by default, Each page has 50 entries; Page 2 would be the next page, so 50 - 100
     * @param subtype    The sub category to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops, int pageNumber, MangaTops subtype) throws IncompatibleEnumException {
        return searchCore(tops, pageNumber, subtype);
    }

    /**
     * Searches the top charts of MAL
     *
     * @param tops       What subType of media: anime, manga, people, characters
     * @param pageNumber Should be 1 by default, Each page has 50 entries; Page 2 would be the next page, so 50 - 100
     * @param subtype    The sub category to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops, int pageNumber, SharedTops subtype) throws IncompatibleEnumException {
        return searchCore(tops, pageNumber, subtype);
    }


    /**
     * Searches the top charts of MAL
     *
     * @param tops       What subType of media: anime, manga, people, characters
     * @param pageNumber Should be 1 by default, Each page has 50 entries; Page 2 would be the next page, so 50 - 100
     * @param subtype    The sub category to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchCore(Tops tops, int pageNumber, TopSubType subtype) throws IncompatibleEnumException {
        if (tops == null) throw new EnumConstantNotPresentException(Tops.class, "Tops subType not present!");
        StringBuilder options = new StringBuilder();
        if (pageNumber == 0) pageNumber = 1;
        options.append("/");
        options.append(pageNumber);
        if (subtype != null) {
            if (tops.compatible(subtype))
                options.append("/").append(subtype);
            else throw new IncompatibleEnumException(tops + " is not compatible with " + subtype);
        }
        return retrieve(tops.getaClass(), baseURL + "/top/" + tops + options.toString());
    }
}

