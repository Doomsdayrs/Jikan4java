package com.github.doomsdayrs.jikan4java.data.model.support.stats

import com.github.doomsdayrs.jikan4java.data.model.support.stats.score.Score
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeStats(
	@SerialName("request_hash") override val requestHash: String,
	@SerialName("request_cached") override val requestCached: Boolean,
	@SerialName("request_cache_expiry") override val requestCacheExpiry: Int,
	@SerialName("completed") override val completed: Int,
	@SerialName("on_hold") override val onHold: Int,
	@SerialName("dropped") override val dropped: Int,
	@SerialName("plan_to_watch") val planToWatch: Int,
	@SerialName("total") override val total: Int,
	@SerialName("scores") override val scores: Score,
	@SerialName("watching") val watching: Int
) : Stats {

	@Deprecated("Migration to proper naming", ReplaceWith("planToWatch"))
	@Suppress("PropertyName", "unused")
	val plan_to_watch
		get() = planToWatch
}