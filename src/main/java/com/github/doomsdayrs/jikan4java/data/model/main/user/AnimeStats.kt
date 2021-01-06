package com.github.doomsdayrs.jikan4java.data.model.main.user

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
 * 03 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class AnimeStats(
	@SerialName("days_watched") var days_watched: Float = 0f,
	@SerialName("mean_score") var mean_score: Float = 0f,
	@SerialName("watching") var watching: Int = 0,
	@SerialName("completed") var completed: Int = 0,
	@SerialName("on_hold") var on_hold: Int = 0,
	@SerialName("dropped") var dropped: Int = 0,
	@SerialName("plan_to_watch") var plan_to_watch: Int = 0,
	@SerialName("total_entries") var total_entries: Int = 0,
	@SerialName("rewatched") var rewatched: Int = 0,
	@SerialName("episodes_watched") var episodes_watched: Int = 0
)