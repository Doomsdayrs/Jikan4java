package com.github.doomsdayrs.jikan4java.core.search

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.data.enums.TopType
import com.github.doomsdayrs.jikan4java.data.enums.top.TopSubType
import com.github.doomsdayrs.jikan4java.data.model.main.top.base.Top
import kotlin.jvm.JvmOverloads

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
 * Searches the top charts of MAL
 *
 * @param top       What subType of media: anime, manga, people, characters
 * @param pageNumber Should be 1 by default, Each page has 50 entries; Page 2 would be the next page, so 50 - 100
 * @param subtype    The sub category to core for.
 * @return Top object
 */
@JvmOverloads
inline fun <reified T : Top<*>> topUrl(
	top: TopType<T>,
	pageNumber: Int = 0,
	subtype: TopSubType<T>? = null
): String {
	val options = StringBuilder("/$pageNumber")
	if (subtype != null) options.append("/").append(subtype.urlKey)
	return "$JIKAN_URL/top/${top.name}$options"
}

