package com.github.doomsdayrs.jikan4java

import com.github.doomsdayrs.jikan4java.core.JikanResult

/**
 * Convenience method to easily handle the HResult
 */
internal inline fun <reified I> JikanResult<I>.handle(
	onEmpty: () -> Unit = {},
	onError: (JikanResult.JException) -> Unit = {},
	onSuccess: (I) -> Unit = {}
) = when (this) {
	is JikanResult.Success -> onSuccess(this.data)
	JikanResult.Empty -> onEmpty()
	is JikanResult.JException -> onError(this)
}
