import java.time.Duration
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.konan.target.HostManager

plugins {
  kotlin("multiplatform")
  kotlin("plugin.serialization")
  id("com.vanniktech.maven.publish")
  id("com.diffplug.spotless")
  id("binary-compatibility-validator")
}

kotlin {
  applyDefaultHierarchyTemplate()

  explicitApi()
  jvm {
    val main = compilations.getByName("main")
    val test = compilations.getByName("test")
    compilations.create("dslLive") {
      associateWith(main)
      associateWith(test) // live tests reuse the offline cases in jvmTest
      defaultSourceSet.dependencies {
        implementation(libs.kotlin.test.junit)
        implementation(libs.ktor.client.okhttp)
        implementation(libs.dotenv.kotlin)
      }
    }
  }

  if (HostManager.hostIsMac) {
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    macosArm64()
    macosX64()
  }

  sourceSets {
    all {
      languageSettings {
        optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
        optIn("kotlinx.serialization.ExperimentalSerializationApi")
        optIn("kotlin.io.encoding.ExperimentalEncodingApi")
      }
    }
    val commonMain by getting {
      dependencies {
        api(libs.ktor.client.core)
        api(libs.kotlinx.serialization.json)
        api(libs.ktor.client.logging)
        implementation(libs.ktor.client.serialization.json)
        implementation(libs.ktor.client.content.negotiation)
        implementation(libs.kotlin.datetime)
      }
    }

    val commonTest by getting {
      dependencies {
        implementation(libs.kotlin.test.common)
        implementation(libs.kotlin.test.annotations.common)
        implementation(libs.kotlinx.coroutines.test)
        implementation(libs.ktor.client.mock)
      }
    }

    val jvmTest by getting {
      dependencies {
        implementation(libs.kotlin.test.junit)
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

val dslLive = kotlin.jvm().compilations.getByName("dslLive")

tasks.register<Test>("jvmDslLiveTest") {
  group = "verification"
  description = "Kotlin DSL live suite against the Algolia API."
  useJUnit()
  dependsOn(dslLive.compileTaskProvider)
  testClassesDirs = dslLive.output.classesDirs
  classpath =
    dslLive.compileDependencyFiles +
      dslLive.runtimeDependencyFiles +
      dslLive.output.allOutputs +
      kotlin.jvm().compilations.getByName("test").output.allOutputs
  systemProperty("algolia.dsl.live", "true")
  systemProperty("algolia.repoRoot", rootDir.resolve("../..").canonicalPath)
  outputs.upToDateWhen { false }
  timeout.set(Duration.ofMinutes(12)) // must fit the 20-min client_gen job (check.yml)
  testLogging {
    events("failed", "skipped")
    exceptionFormat = TestExceptionFormat.FULL
  }
}

// Fork / [skip-e2e] PRs never run the live task: compile it in the client step instead.
tasks.named("jvmTest") { dependsOn(dslLive.compileTaskProvider) }
