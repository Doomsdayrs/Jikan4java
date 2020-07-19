package com.github.doomsdayrs.jikan4java.data.model.main.schedule

import com.fasterxml.jackson.annotation.JsonProperty
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
class Schedule(
		@field:JsonProperty("request_hash") var request_hash: String? = null,
		@field:JsonProperty("request_cached") var request_cached: Boolean = false,
		@field:JsonProperty("request_cache_expiry") var request_cache_expiry: Int = 0,
		@field:JsonProperty("monday") var monday: ArrayList<SubAnime>? = null,
		@field:JsonProperty("tuesday") var tuesday: ArrayList<SubAnime>? = null,
		@field:JsonProperty("wednesday") var wednesday: ArrayList<SubAnime>? = null,
		@field:JsonProperty("thursday") var thursday: ArrayList<SubAnime>? = null,
		@field:JsonProperty("friday") var friday: ArrayList<SubAnime>? = null,
		@field:JsonProperty("saturday") var saturday: ArrayList<SubAnime>? = null,
		@field:JsonProperty("sunday") var sunday: ArrayList<SubAnime>? = null,
		@field:JsonProperty("other") var others: ArrayList<SubAnime>? = null,
		@field:JsonProperty("unknown") var unknown: ArrayList<SubAnime>? = null
)