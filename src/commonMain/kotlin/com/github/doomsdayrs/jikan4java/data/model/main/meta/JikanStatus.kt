package com.github.doomsdayrs.jikan4java.data.model.main.meta

import com.github.doomsdayrs.jikan4java.common.JIKAN_URL
import com.github.doomsdayrs.jikan4java.core.Retriever
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
 * 05 / November / 2018
 *
 * @author github.com/doomsdayrs
 */

@Deprecated(
	"Renamed",
	ReplaceWith(
		"JikanStatus",
		"com.github.doomsdayrs.jikan4java.data.model.main.meta.JikanStatus"
	)
)
typealias Status = JikanStatus

@Serializable
data class JikanStatus(
	@SerialName("cached_requests") val cached_requests: Int = 0,
	@SerialName("requests_today") val requests_today: Int = 0,
	@SerialName("requests_this_week") val requests_this_week: Int = 0,
	@SerialName("requests_this_month") val requests_this_month: Int = 0,
	@SerialName("connected_clients") val connected_clients: String? = null,
	@SerialName("total_connections_received") val total_connections_received: String? = null
) : Meta {
	companion object {
		@JvmStatic
		fun get(retriever: Retriever) =
			retriever<JikanStatus>("$JIKAN_URL/meta/status")
	}
}