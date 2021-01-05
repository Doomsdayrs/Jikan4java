plugins {
	java
	kotlin("jvm") version "1.4.21"
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
	implementation("commons-lang:commons-lang:2.6")
	implementation("com.squareup.okhttp3:okhttp:3.14.2")
	implementation("com.fasterxml.jackson.core:jackson-annotations:2.11.0")
	implementation("com.fasterxml.jackson.core:jackson-core:2.11.0")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.11.0")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.0")
	implementation("com.googlecode.json-simple:json-simple:1.1.1")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.72")
	testImplementation("org.jetbrains.kotlin:kotlin-test:1.3.72")
}