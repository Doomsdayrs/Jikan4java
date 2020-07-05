package com.github.doomsdayrs.jikan4java.model.support.stats.score

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
 * 29 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
data class Score(
		@JsonProperty("1")
		val one: Position?,
		@JsonProperty("2")
		val two: Position?,
		@JsonProperty("3")
		val three: Position?,
		@JsonProperty("4")
		val four: Position?,
		@JsonProperty("5")
		val five: Position?,
		@JsonProperty("6")
		val six: Position?,
		@JsonProperty("7")
		val seven: Position?,
		@JsonProperty("8")
		val eight: Position?,
		@JsonProperty("9")
		val nine: Position?,
		@JsonProperty("10")
		val ten: Position?
)