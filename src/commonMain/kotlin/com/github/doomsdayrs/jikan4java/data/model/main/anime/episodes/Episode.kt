package com.github.doomsdayrs.jikan4java.data.model.main.anime.episodes

import com.github.doomsdayrs.jikan4java.data.base.values.MyAnimeListTitle
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
data class Episode(
	@SerialName("episode_id") val episodeID: Int = 0,
	@SerialName("title") override val title: String,
	@SerialName("title_japanese") val titleJapanese: String? = null,
	@SerialName("title_romanji") val titleRomanji: String? = null,
	@SerialName("aired") val aired: String? = null,
	@SerialName("filler") val filler: Boolean = false,
	@SerialName("recap") val recap: Boolean = false,
	@SerialName("video_url") val videoURL: String? = null,
	@SerialName("forum_url") val forumURL: String? = null
) : MyAnimeListTitle {
	@Suppress("PropertyName", "unused")
	@Deprecated(
		"Changed to proper naming format",
		ReplaceWith("episodeID")
	)
	val episode_id
		get() = episodeID

	@Suppress("PropertyName", "unused")
	@Deprecated(
		"Changed to proper naming format",
		ReplaceWith("titleJapanese")
	)
	val title_japanese
		get() = titleJapanese

	@Suppress("PropertyName", "unused")
	@Deprecated(
		"Changed to proper naming format",
		ReplaceWith("titleRomanji")
	)
	val title_romanji
		get() = titleRomanji

	@Suppress("PropertyName", "unused")
	@Deprecated(
		"Changed to proper naming format",
		ReplaceWith("videoURL")
	)
	val video_url
		get() = videoURL

	@Deprecated(
		"Changed to proper naming format",
		ReplaceWith("forumURL")
	)
	@Suppress("PropertyName", "unused")
	val forum_url
		get() = forumURL
}