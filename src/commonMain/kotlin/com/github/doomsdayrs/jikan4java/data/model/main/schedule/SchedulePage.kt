package com.github.doomsdayrs.jikan4java.data.model.main.schedule

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.model.support.RequestHashing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
	@SerialName("request_hash") override val requestHash: String,
	@SerialName("request_cached") override val requestCached: Boolean = false,
	@SerialName("request_cache_expiry") override val requestCacheExpiry: Int = 0,

	@SerialName("sunday") val sunday: List<SubAnime> = listOf(),
	@SerialName("monday") val monday: List<SubAnime> = listOf(),
	@SerialName("tuesday") val tuesday: List<SubAnime> = listOf(),
	@SerialName("wednesday") val wednesday: List<SubAnime> = listOf(),
	@SerialName("thursday") val thursday: List<SubAnime> = listOf(),
	@SerialName("friday") val friday: List<SubAnime> = listOf(),
	@SerialName("saturday") val saturday: List<SubAnime> = listOf(),

	@SerialName("other") val others: List<SubAnime> = listOf(),
	@SerialName("unknown") val unknown: List<SubAnime> = listOf()
) : RequestHashing {
	companion object {
		@JvmStatic
		fun getSchedule(retriever: Retriever) =
			retriever<SchedulePage>("$JIKAN_URL/schedule")

		@JvmStatic
		fun getSundaySchedule(retriever: Retriever) =
			retriever<Day.Sunday>("$JIKAN_URL/schedule/sunday")

		@JvmStatic
		fun getMondaySchedule(retriever: Retriever) =
			retriever<Day.Monday>("$JIKAN_URL/schedule/monday")

		@JvmStatic
		fun getTuesdaySchedule(retriever: Retriever) =
			retriever<Day.Tuesday>("$JIKAN_URL/schedule/tuesday")

		@JvmStatic
		fun getWednesdaySchedule(retriever: Retriever) =
			retriever<Day.Wednesday>("$JIKAN_URL/schedule/wednesday")

		@JvmStatic
		fun getThursdaySchedule(retriever: Retriever) =
			retriever<Day.Thursday>("$JIKAN_URL/schedule/thursday")

		@JvmStatic
		fun getFridaySchedule(retriever: Retriever) =
			retriever<Day.Friday>("$JIKAN_URL/schedule/friday")

		@JvmStatic
		fun getSaturdaySchedule(retriever: Retriever) =
			retriever<Day.Saturday>("$JIKAN_URL/schedule/saturday")

		@JvmStatic
		fun getOtherSchedule(retriever: Retriever) =
			retriever<Day.Other>("$JIKAN_URL/schedule/other")

		@JvmStatic
		fun getUnknownSchedule(retriever: Retriever) =
			retriever<Day.Unknown>("$JIKAN_URL/schedule/unknown")

	}
}