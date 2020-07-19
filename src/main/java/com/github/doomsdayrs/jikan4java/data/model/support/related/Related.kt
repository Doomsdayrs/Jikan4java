package com.github.doomsdayrs.jikan4java.data.model.support.related

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
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
data class Related(
		@JsonProperty("Prequel") val prequel: ArrayList<RelatedType>,
		@JsonProperty("Alternative version") val altVersion: ArrayList<RelatedType>,
		@JsonProperty("Spin-off") val spinOff: ArrayList<RelatedType>,
		@JsonProperty("Adaptation") val adaptation: ArrayList<RelatedType>,
		@JsonProperty("Summary") val summaries: ArrayList<RelatedType>,
		@JsonProperty("Sequel") val sequels: ArrayList<RelatedType>,
		@JsonProperty("Side story") val sideStories: ArrayList<RelatedType>,
		@JsonProperty("Other") val other: ArrayList<RelatedType>,
		@JsonProperty("Parent story") val parentStories: ArrayList<RelatedType>,
		@JsonProperty("Alternative setting") val alternativeSettings: ArrayList<RelatedType>,
		@JsonProperty("Character") val characters: ArrayList<RelatedType>,
		@JsonProperty("Full story") val fullStories: ArrayList<RelatedType>
)