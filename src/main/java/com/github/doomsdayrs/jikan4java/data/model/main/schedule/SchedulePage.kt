package com.github.doomsdayrs.jikan4java.data.model.main.schedule

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.model.support.RequestHashing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
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
 * 01 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class SchedulePage(
	@SerialName("request_hash") override val requestHash: String? = null,
	@SerialName("request_cached") override val requestCached: Boolean = false,
	@SerialName("request_cache_expiry") override val requestCacheExpiry: Int = 0,
	@SerialName("monday") var monday: ArrayList<SubAnime>? = null,
	@SerialName("tuesday") var tuesday: ArrayList<SubAnime>? = null,
	@SerialName("wednesday") var wednesday: ArrayList<SubAnime>? = null,
	@SerialName("thursday") var thursday: ArrayList<SubAnime>? = null,
	@SerialName("friday") var friday: ArrayList<SubAnime>? = null,
	@SerialName("saturday") var saturday: ArrayList<SubAnime>? = null,
	@SerialName("sunday") var sunday: ArrayList<SubAnime>? = null,
	@SerialName("other") var others: ArrayList<SubAnime>? = null,
	@SerialName("unknown") var unknown: ArrayList<SubAnime>? = null
) : RequestHashing {
	companion object {
		@Suppress("unused")
		fun getSchedule(retriever: Retriever) =
			retriever<SchedulePage>("$JIKAN_URL/schedule")
	}
}