package com.github.doomsdayrs.jikan4java.model.support.basic

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.core.Retriever

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
 */ /**
 * com.github.doomsdayrs.jikan4java.types.support.basic
 * 17 / November / 2019
 *
 * @author github.com/doomsdayrs
 */
open class BasicObject(
		@field:JsonProperty("mal_id") val mal_id: Int,
		@field:JsonProperty("url") val url: String?,
		@field:JsonProperty("image_url") val image_url: String?,
		@field:JsonProperty("name") val name: String?
) : Retriever()