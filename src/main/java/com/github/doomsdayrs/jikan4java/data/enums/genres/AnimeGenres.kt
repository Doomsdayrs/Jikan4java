package com.github.doomsdayrs.jikan4java.data.enums.genres

import com.github.doomsdayrs.jikan4java.core.JikanResult
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.model.main.genresearch.anime.GenreSearchAnime
import com.github.doomsdayrs.jikan4java.data.model.main.genresearch.anime.GenreSearchAnimePage
import java.util.concurrent.CompletableFuture

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
 * 11 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
enum class AnimeGenres(override val id: Int) :
	Genres<GenreSearchAnime, GenreSearchAnimePage> {
	ACTION(1),
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

	override val type = "anime"

	override fun toString(): String = "${super.name}($id)"

	/**
	 * Searches for Anime/manga by genre,
	 * There are more than one page since each page has a hundred entries max.
	 *
	 * @param page    The page number to go to,
	 * 1 should be the default unless you know else wise
	 *
	 * @return [GenreSearchAnimePage]
	 */
	@JvmOverloads
	override fun search(
		retriever: Retriever,
		page: Int
	): CompletableFuture<JikanResult<GenreSearchAnimePage>> =
		iSearch(retriever, page)

}