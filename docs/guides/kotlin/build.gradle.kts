import com.diffplug.gradle.spotless.SpotlessExtension

plugins {
    kotlin("jvm") version "2.2.10"
    kotlin("plugin.serialization") version "2.2.10"
    alias(libs.plugins.spotless)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.algolia:algoliasearch-client-kotlin")
    implementation("io.ktor:ktor-client-okhttp:3.0.0")
    implementation("ch.qos.logback:logback-classic:1.5.12")
    implementation("io.github.cdimascio:dotenv-kotlin:6.5.1")
}

configure<SpotlessExtension> {
    kotlin {
      target("**/*.kt")
      ktfmt().googleStyle()
    }
}
