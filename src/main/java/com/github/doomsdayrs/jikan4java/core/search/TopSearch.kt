package com.github.doomsdayrs.jikan4java.core.search

import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.enums.top.*
import com.github.doomsdayrs.jikan4java.data.exceptions.IncompatibleEnumException
import com.github.doomsdayrs.jikan4java.data.model.main.top.base.Top
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
 * 21 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
class TopSearch : Retriever() {
	/**
	 * Searches the top charts of MAL
	 *
	 * @param tops       What subType of media: anime, manga, people, characters
	 * @param pageNumber Should be 1 by default, Each page has 50 entries; Page 2 would be the next page, so 50 - 100
	 * @param subtype    The sub category to core for.
	 * @return Top object
	 */
	@Throws(IncompatibleEnumException::class)
	@JvmOverloads
	inline fun <reified T : Top<*>> searchTop(
			tops: Tops?,
			pageNumber: Int = 0,
			subtype: AnimeSubTops?
	): CompletableFuture<T> {
		return searchCore(tops, pageNumber, subtype)
	}

	/**
	 * Searches the top charts of MAL
	 *
	 * @param tops       What subType of media: anime, manga, people, characters
	 * @param pageNumber Should be 1 by default, Each page has 50 entries; Page 2 would be the next page, so 50 - 100
	 * @param subtype    The sub category to core for.
	 * @return Top object
	 */
	@Throws(IncompatibleEnumException::class)
	@JvmOverloads
	inline fun <reified T : Top<*>> searchTop(
			tops: Tops?,
			pageNumber: Int = 0,
			subtype: MangaSubTops?
	): CompletableFuture<T> {
		return searchCore(tops, pageNumber, subtype)
	}

	/**
	 * Searches the top charts of MAL
	 *
	 * @param tops       What subType of media: anime, manga, people, characters
	 * @param pageNumber Should be 1 by default, Each page has 50 entries; Page 2 would be the next page, so 50 - 100
	 * @param subtype    The sub category to core for.
	 * @return Top object
	 */
	@Throws(IncompatibleEnumException::class)
	@JvmOverloads
	inline fun <reified T : Top<*>> searchTop(
			tops: Tops?,
			pageNumber: Int = 0,
			subtype: SharedSubTops?
	): CompletableFuture<T> {
		return searchCore(tops, pageNumber, subtype)
	}

	/**
	 * Searches the top charts of MAL
	 *
	 * @param tops       What subType of media: anime, manga, people, characters
	 * @param pageNumber Should be 1 by default, Each page has 50 entries; Page 2 would be the next page, so 50 - 100
	 * @param subtype    The sub category to core for.
	 * @return Top object
	 */
	@Throws(IncompatibleEnumException::class)
	@JvmOverloads
	inline fun <reified T : Top<*>> searchCore(
			tops: Tops?,
			pageNumber: Int = 0,
			subtype: TopSubType?
	): CompletableFuture<T> {
		if (tops == null) throw EnumConstantNotPresentException(Tops::class.java, "Tops subType not present!")
		val options = StringBuilder()
		options.append("/")
		options.append(if (pageNumber == 0) 1 else pageNumber)
		if (subtype != null) {
			if (tops.compatible(subtype)) options.append("/").append(subtype)
			else throw IncompatibleEnumException("$tops is not compatible with $subtype")
		}
		return retrieve("$baseURL/top/$tops$options")
	}
}