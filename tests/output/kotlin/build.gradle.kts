import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent.*
import org.jetbrains.kotlin.konan.target.HostManager

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.multiplaform)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.spotless)
}

repositories {
    mavenCentral()
}


kotlin {
    applyDefaultHierarchyTemplate()

    explicitApi()
    jvm()

    if (HostManager.hostIsMac) {
        iosX64()
        iosArm64()
        iosSimulatorArm64()
    }

    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
                optIn("kotlinx.serialization.ExperimentalSerializationApi")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation("com.algolia:algoliasearch-client-kotlin")
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation(libs.coroutines.test)
                implementation(libs.kotlinx.serialization.json)
                implementation("io.github.cdimascio:dotenv-kotlin:6.5.1")
                implementation("org.skyscreamer:jsonassert:1.5.3")
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(libs.ktor.client.okhttp)
            }
        }

        if (HostManager.hostIsMac) {
            val appleTest by getting {
                dependencies {
                    implementation(libs.ktor.client.darwin)
                }
            }
        }
    }
}

tasks.withType<Test> {
    testLogging {
        events(STARTED, PASSED, SKIPPED, FAILED)
        exceptionFormat = TestExceptionFormat.FULL
        showStandardStreams = false
    }
}

configure<SpotlessExtension> {
    kotlin {
        target("**/*.kt")
        ktfmt().googleStyle()
    }
}
