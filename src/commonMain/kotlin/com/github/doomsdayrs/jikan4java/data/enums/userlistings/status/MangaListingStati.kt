package com.github.doomsdayrs.jikan4java.data.enums.userlistings.status

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
 * 25 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
enum class MangaListingStati(private val type: String) : ListingStati {
	PUBLISHING("publishing"), FINISHED("finished"), COMPLETE(FINISHED.type), TO_BE_PUBLISHED(
		"to_be_published"
	),
	NOT_YET_PUBLISHED(TO_BE_PUBLISHED.type), TBP(NOT_YET_PUBLISHED.type), NYP(
		TBP.type
	);

	override fun toString(): String {
		return type
	}

}