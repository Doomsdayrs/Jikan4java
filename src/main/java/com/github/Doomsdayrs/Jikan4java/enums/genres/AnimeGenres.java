package com.github.Doomsdayrs.Jikan4java.enums.genres;

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
 * 11 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
public enum AnimeGenres implements Genres {
    ACTION(1),
    action(ACTION.id),
    ADVENTURE(2),
    CARS(3),
    COMEDY(4),
    DEMENTIA(5),
    DEMONS(6),
    MYSTERY(7),
    DRAMA(8),
    ECCHI(9),
    FANTASY(10),
    GAME(11),
    HENTAI(12),
    HISTORICAL(13),
    HORROR(14),
    KIDS(15),
    MAGIC(16),
    MARTIAL_ARTS(17),
    MECHA(18),
    MUSIC(19),
    PARODY(20),
    SAMURAI(21),
    ROMANCE(22),
    SCHOOL(23),
    SCI_FI(24),
    SHOUJO(25),
    SHOUJO_AI(26),
    SHOUNEN(27),
    SHOUNEN_AI(28),
    SPACE(29),
    SPORTS(30),
    SUPER_POWER(31),
    VAMPIRE(32),
    YAOI(33),
    YURI(34),
    HAREM(35),
    SLICE_OF_LIFE(36),
    SUPERNATURAL(37),
    MILITARY(38),
    POLICE(39),
    PSYCHOLOGICAL(40),
    THRILLER(41),
    SEINEN(42),
    JOSEI(43);

    final int id;
    final String type = "anime";
    AnimeGenres(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.name() + "(" + id + ")";
    }
}
