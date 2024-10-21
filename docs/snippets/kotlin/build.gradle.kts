import com.diffplug.gradle.spotless.SpotlessExtension

plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.serialization") version "2.0.21"
    alias(libs.plugins.spotless)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.algolia:algoliasearch-client-kotlin")
    implementation("io.ktor:ktor-client-okhttp:2.3.12")
    implementation("ch.qos.logback:logback-classic:1.5.10")
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.2")
}

configure<SpotlessExtension> {
    kotlin {
        target("**/*.kt")
        trimTrailingWhitespace()
        ktlint()
            .editorConfigOverride(
                mapOf(
                    "ktlint_standard_no-wildcard-imports" to "disabled",
                    "ktlint_standard_trailing-comma-on-declaration-site" to "disabled",
                    "ktlint_standard_filename" to "disabled",
                    "ktlint_standard_import-ordering" to "disabled",
                ),
            )
    }
}
