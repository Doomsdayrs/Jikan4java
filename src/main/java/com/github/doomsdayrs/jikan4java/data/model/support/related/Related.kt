package com.github.doomsdayrs.jikan4java.data.model.support.related

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
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class Related(
	@SerialName("Prequel")
	val prequel: List<RelatedType> = listOf(),

	@SerialName("Alternative version")
	val altVersion: List<RelatedType> = listOf(),

	@SerialName("Spin-off")
	val spinOff: List<RelatedType> = listOf(),

	@SerialName("Adaptation")
	val adaptation: List<RelatedType> = listOf(),

	@SerialName("Summary")
	val summaries: List<RelatedType> = listOf(),

	@SerialName("Sequel")
	val sequels: List<RelatedType> = listOf(),

	@SerialName("Side story")
	val sideStories: List<RelatedType> = listOf(),

	@SerialName("Other")
	val other: List<RelatedType> = listOf(),

	@SerialName("Parent story")
	val parentStories: List<RelatedType> = listOf(),

	@SerialName("Alternative setting")
	val alternativeSettings: List<RelatedType> = listOf(),

	@SerialName("Character")
	val characters: List<RelatedType> = listOf(),

	@SerialName("Full story")
	val fullStories: List<RelatedType> = listOf()
)