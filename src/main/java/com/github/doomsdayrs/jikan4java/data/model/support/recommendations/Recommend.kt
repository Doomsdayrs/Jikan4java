package com.github.doomsdayrs.jikan4java.data.model.support.recommendations

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
 * 02 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
data class Recommend(
		@JsonProperty("mal_id") val mal_id: Int ,
		@JsonProperty("url") val url: String? ,
		@JsonProperty("image_url") val image_url: String? ,
		@JsonProperty("recommendation_url") val recommendation_url: String? ,
		@JsonProperty("title") val title: String? ,
		@JsonProperty("recommendation_count") val recommendation_count: Int 
)