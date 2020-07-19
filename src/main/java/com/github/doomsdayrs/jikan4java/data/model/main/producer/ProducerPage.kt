package com.github.doomsdayrs.jikan4java.data.model.main.producer

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.data.model.main.schedule.SubAnime
import com.github.doomsdayrs.jikan4java.data.model.support.RequestHashing
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.BasicMeta
import java.util.*

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
 * 04 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
data class ProducerPage(
		@field:JsonProperty("request_hash") override val request_hash: String? = null,
		@field:JsonProperty("request_cached") override val  request_cached: Boolean = false,
		@field:JsonProperty("request_cache_expiry") override val  request_cache_expiry: Int = 0,
		@field:JsonProperty("meta") val meta: BasicMeta? = null,
		@field:JsonProperty("anime") val subAnimes: ArrayList<SubAnime>? = null
):RequestHashing