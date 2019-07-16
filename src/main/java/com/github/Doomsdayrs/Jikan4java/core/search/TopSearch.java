package com.github.Doomsdayrs.Jikan4java.core.search;

import com.github.Doomsdayrs.Jikan4java.core.Retriever;
import com.github.Doomsdayrs.Jikan4java.enums.top.*;
import com.github.Doomsdayrs.Jikan4java.exceptions.IncompatibleEnumException;
import com.github.Doomsdayrs.Jikan4java.types.Main.Top.Top;

import java.util.concurrent.CompletableFuture;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 * Jikan4java
 * 21 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public class TopSearch extends Retriever {
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
        return searchTopSub(tops, subtype);
    }

    /**
     * Searches the top charts of MAL, page defaulted
     *
     * @param tops    What subType of media: anime, manga, people, characters
     * @param subtype The Anime subcategory to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops, AnimeTops subtype) throws IncompatibleEnumException {
        return searchTopSub(tops, subtype);
    }

    /**
     * Searches the top charts of MAL, page defaulted
     *
     * @param tops    What subType of media: anime, manga, people, characters
     * @param subtype The Manga subcategory to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchTop(Tops tops, MangaTops subtype) throws IncompatibleEnumException {
        return searchTopSub(tops, subtype);
    }

    /**
     * Searches the top charts of MAL, with subtype defaulted
     *
     * @param tops    What subType of media: anime, manga, people, characters
     * @param subtype The sub category to core for.
     * @return Top object
     */
    public CompletableFuture<Top> searchTopSub(Tops tops, TopSubType subtype) throws IncompatibleEnumException {
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
