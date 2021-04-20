plugins {
	kotlin("plugin.serialization") version "1.4.21"
	kotlin("multiplatform") version "1.5.0-RC"
}

group = "com.github.doomsdayrs"
version = "3.0.0"
description = "jikan4java"

repositories {
	mavenLocal()
	mavenCentral()
}

kotlin {
	jvm {
		compilations.all {
			kotlinOptions.jvmTarget = "1.8"
		}
		testRuns["test"].executionTask.configure {
			useJUnit()
		}
	}
	js(LEGACY) {
		browser {
			commonWebpackConfig {
				cssSupport.enabled = true
			}
			testTask{
				useKarma{
					useFirefox()
				}
			}
		}
	}
	val hostOs = System.getProperty("os.name")
	val isMingwX64 = hostOs.startsWith("Windows")
	val nativeTarget = when {
		hostOs == "Mac OS X" -> macosX64("native")
		hostOs == "Linux" -> linuxX64("native")
		isMingwX64 -> mingwX64("native")
		else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
	}


	sourceSets {
		val commonMain by getting {
			dependencies{
				implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")
			}
		}
		val commonTest by getting {
			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
				implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
			}
		}
		val jvmMain by getting
		val jvmTest by getting {
			dependencies {
				implementation(kotlin("test-junit"))
			}
		}
		val jsMain by getting
		val jsTest by getting {
			dependencies {
				implementation(kotlin("test-js"))
			}
		}
		val nativeMain by getting
		val nativeTest by getting
	}
}