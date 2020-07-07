package com.github.doomsdayrs.jikan4java.model.main.user

import com.fasterxml.jackson.annotation.JsonProperty

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
 * 03 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
data class AnimeStats(
		@field:JsonProperty("days_watched") var days_watched: Float = 0f,
		@field:JsonProperty("mean_score") var mean_score: Float = 0f,
		@field:JsonProperty("watching") var watching: Int = 0,
		@field:JsonProperty("completed") var completed: Int = 0,
		@field:JsonProperty("on_hold") var on_hold: Int = 0,
		@field:JsonProperty("dropped") var dropped: Int = 0,
		@field:JsonProperty("plan_to_watch") var plan_to_watch: Int = 0,
		@field:JsonProperty("total_entries") var total_entries: Int = 0,
		@field:JsonProperty("rewatched") var rewatched: Int = 0,
		@field:JsonProperty("episodes_watched") var episodes_watched: Int = 0
)