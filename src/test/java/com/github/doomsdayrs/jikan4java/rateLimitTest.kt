package com.github.doomsdayrs.jikan4java

import com.github.doomsdayrs.jikan4java.common.printRateLimit
import com.github.doomsdayrs.jikan4java.common.rateLimit
import org.junit.jupiter.api.Test

@Test
fun rateLimitTest() {
	printRateLimit = true

	// Checks the 2 second rule
	for (i in 0..40) {
		val t = Thread @Throws(InterruptedException::class) {
			rateLimit()
			println(i)
		}
		t.start()
	}
}