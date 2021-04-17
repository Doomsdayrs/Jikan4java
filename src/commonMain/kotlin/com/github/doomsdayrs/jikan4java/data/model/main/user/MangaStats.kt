package com.github.doomsdayrs.jikan4java.data.model.main.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** @noinspection ALL
 */
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
data class MangaStats(
	@SerialName("days_read") val days_read: Float = 0f,
	@SerialName("mean_score") val mean_score: Float = 0f,
	@SerialName("reading") val reading: Int = 0,
	@SerialName("completed") val completed: Int = 0,
	@SerialName("on_hold") val on_hold: Int = 0,
	@SerialName("dropped") val dropped: Int = 0,
	@SerialName("plan_to_read") val plan_to_read: Int = 0,
	@SerialName("total_entries") val total_entries: Int = 0,
	@SerialName("reread") val reread: Int = 0,
	@SerialName("chapters_read") val chapters_read: Int = 0,
	@SerialName("volumes_read") val volumes_read: Int = 0
)