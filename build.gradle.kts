plugins {
	java
	kotlin("jvm") version "1.4.21"
	kotlin("plugin.serialization") version "1.4.21"
}

group = "com.github.doomsdayrs"
version = "2.0.0"
description = "jikan4java"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenLocal()
	mavenCentral()
	maven("https://jitpack.io")
	maven("https://repo.maven.apache.org/maven2/")
}

dependencies {
	implementation("com.squareup.okhttp3:okhttp:4.9.0")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.21")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.4.2")

	testImplementation("org.jetbrains.kotlin:kotlin-test:1.4.21")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.4.21")

}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
	kotlinOptions.jvmTarget = "1.8"
}