package com.github.Doomsdayrs.Jikan4java.enums.genres;

/*
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Jikan4java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
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
