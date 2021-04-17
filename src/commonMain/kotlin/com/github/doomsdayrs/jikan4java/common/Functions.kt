package com.github.doomsdayrs.jikan4java.common

import java.util.concurrent.TimeUnit

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
 */

/**
 * Jikan4java
 * 10 / 07 / 2020
 *
 * @author github.com/doomsdayrs
 */

private var lastRequest = 0L

internal fun canContinue() = lastRequest + 2000 < System.currentTimeMillis()

@Throws(InterruptedException::class)
@Synchronized
fun rateLimit() {
	while (!canContinue()) {
		if (printRateLimit) println("$PROJECT_NAME: $RATE_LIMIT_MESSAGE")
		TimeUnit.SECONDS.sleep(2)
	}
	lastRequest = System.currentTimeMillis()
}

