package com.github.doomsdayrs.jikan4java.data.model.support.stats.score

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
 * 29 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class Score(
	@SerialName("1")
	val one: Position?,
	@SerialName("2")
	val two: Position?,
	@SerialName("3")
	val three: Position?,
	@SerialName("4")
	val four: Position?,
	@SerialName("5")
	val five: Position?,
	@SerialName("6")
	val six: Position?,
	@SerialName("7")
	val seven: Position?,
	@SerialName("8")
	val eight: Position?,
	@SerialName("9")
	val nine: Position?,
	@SerialName("10")
	val ten: Position?
)