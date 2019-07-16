package com.github.Doomsdayrs.Jikan4java.enums.search;

import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.Anime;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.AnimePage.AnimePage;
import com.github.Doomsdayrs.Jikan4java.types.Main.Character.CharacterPage.CharacterPage;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.Manga;
import com.github.Doomsdayrs.Jikan4java.types.Main.Manga.MangaPage.MangaPage;
import com.github.Doomsdayrs.Jikan4java.types.Main.Person.Person;
import com.github.Doomsdayrs.Jikan4java.types.Main.Person.PersonPage.PersonPage;

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
 * 13 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
public enum Types {
    ANIME("anime", AnimePage.class, Anime.class),
    MANGA("manga", MangaPage.class, Manga.class),
    PERSON("person", PersonPage.class, Person.class),
    CHARACTER("character", CharacterPage.class, Character.class);
    private final String type;
    private final Class a;
    private final Class b;

    Types(String type, Class a, Class b) {
        this.type = type;
        this.a = a;
        this.b = b;
    }

    public Class getA() {
        return a;
    }

    public Class getB() {
        return b;
    }

    @Override
    public String toString() {
        return type;
    }
}
