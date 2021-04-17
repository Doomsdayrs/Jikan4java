package com.github.doomsdayrs.jikan4java.core.search

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.core.JikanResult
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.enums.top.TopSubType
import com.github.doomsdayrs.jikan4java.data.exceptions.IncompatibleEnumException
import com.github.doomsdayrs.jikan4java.data.model.main.top.base.Top
import com.github.doomsdayrs.jikan4java.data.model.main.top.base.TopListing
import com.github.doomsdayrs.jikan4java.data.model.main.top.model.anime.AnimeTop
import com.github.doomsdayrs.jikan4java.data.model.main.top.model.character.CharacterTop
import com.github.doomsdayrs.jikan4java.data.model.main.top.model.manga.MangaTop
import com.github.doomsdayrs.jikan4java.data.model.main.top.model.person.PersonTop
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
 */

/**
 * Jikan4java
 * 21 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
class TopSearch(
	val retriever: Retriever
) {

	/**
	 * Searches the top charts of MAL
	 *
	 * @param top       What subType of media: anime, manga, people, characters
	 * @param pageNumber Should be 1 by default, Each page has 50 entries; Page 2 would be the next page, so 50 - 100
	 * @param subtype    The sub category to core for.
	 * @return Top object
	 */
	@JvmOverloads
	inline fun <reified TOP, reified V> searchTop(
		top: TOP,
		pageNumber: Int = 0,
		subtype: TopSubType? = null
	): CompletableFuture<JikanResult<TOP>>
			where TOP : Top<V>,
			      V : TopListing {
		val options =
			StringBuilder("/${if (pageNumber == 0) 1 else pageNumber}")
		if (subtype != null) {
			if (top.compatible(subtype)) options.append("/").append(subtype)
			else throw IncompatibleEnumException("$top is not compatible with $subtype")
		}
		println("TOP IS: ${TOP::class.simpleName}")
		println("var IS: ${top::class.simpleName}")

		return retriever("$JIKAN_URL/top/${top.name}$options")
	}

	companion object {
		val PERSON by lazy { PersonTop() }
		val MANGA by lazy { MangaTop() }
		val CHARACTER by lazy { CharacterTop() }
		val ANIME by lazy { AnimeTop() }
	}
}