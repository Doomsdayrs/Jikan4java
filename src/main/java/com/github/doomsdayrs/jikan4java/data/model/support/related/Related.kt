package com.github.doomsdayrs.jikan4java.data.model.support.related

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
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
@Serializable
data class Related(
	@SerialName("Prequel") val prequel: ArrayList<RelatedType>,
	@SerialName("Alternative version") val altVersion: ArrayList<RelatedType>,
	@SerialName("Spin-off") val spinOff: ArrayList<RelatedType>,
	@SerialName("Adaptation") val adaptation: ArrayList<RelatedType>,
	@SerialName("Summary") val summaries: ArrayList<RelatedType>,
	@SerialName("Sequel") val sequels: ArrayList<RelatedType>,
	@SerialName("Side story") val sideStories: ArrayList<RelatedType>,
	@SerialName("Other") val other: ArrayList<RelatedType>,
	@SerialName("Parent story") val parentStories: ArrayList<RelatedType>,
	@SerialName("Alternative setting") val alternativeSettings: ArrayList<RelatedType>,
	@SerialName("Character") val characters: ArrayList<RelatedType>,
	@SerialName("Full story") val fullStories: ArrayList<RelatedType>
)