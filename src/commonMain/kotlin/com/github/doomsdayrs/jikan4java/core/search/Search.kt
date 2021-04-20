package com.github.doomsdayrs.jikan4java.core.search

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.data.enums.search.Types

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
 * 13 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
open class Search<SET>(
	val type: Types
) where SET : Search<SET> {
	@Suppress("MemberVisibilityCanBePrivate")
	var query = ""

	@Suppress("MemberVisibilityCanBePrivate")
	var limit = 10

	/**
	 * Creates the URL to be used to retrieve the Object
	 *
	 * @return StringBuilder of the URL so far
	 */
	open fun createURL(): String {

		return "$JIKAN_URL/search/${type.urlKey}?q=${
			query.replace(
				" ".toRegex(),
				"%20"
			)
		}${
			if (limit != 0)
				"&limit=$limit"
			else ""
		}"
	}

	/**
	 * Set how many result to be listed per page, limit is greater then 0
	 *
	 * @param limit how many entries
	 * @return This
	 * @throws IndexOutOfBoundsException incase you input a 0
	 */
	@Throws(IndexOutOfBoundsException::class)
	open fun setLimit(limit: Int): SET {
		this.limit = limit
		return this as SET
	}

	/**
	 * Set the title that will be queried
	 *
	 * @param title Title or name of what you want
	 * @return This
	 */
	open fun setQuery(title: String): SET {
		query = title
		return this as SET
	}

	fun get(): String =
		createURL()

	fun getByID(id: Int): String =
		"$JIKAN_URL/${type.urlKey}/$id"
}