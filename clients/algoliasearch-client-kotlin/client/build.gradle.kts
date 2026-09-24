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
    // One compilation per stacked phase: a phase whose API does not exist yet fails alone.
    val main = compilations.getByName("main")
    val phases = (0..3).map { compilations.create("dslP$it") }
    phases.forEachIndexed { index, compilation ->
      compilation.associateWith(main)
      phases.take(index).forEach { compilation.associateWith(it) }
      compilation.defaultSourceSet.dependencies {
        implementation(libs.kotlin.test.junit)
        implementation(libs.ktor.client.okhttp)
        implementation("io.github.cdimascio:dotenv-kotlin:6.5.1")
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

val dslPhases = 0..3
val repoRoot: String = rootDir.resolve("../..").canonicalPath

dslPhases.forEach { phase ->
  val compilation = kotlin.jvm().compilations.getByName("dslP$phase")
  fun Test.dslTest(suite: String) {
    group = "verification"
    useJUnit()
    dependsOn(compilation.compileTaskProvider)
    testClassesDirs = compilation.output.classesDirs
    classpath =
      compilation.compileDependencyFiles +
        compilation.runtimeDependencyFiles +
        compilation.output.allOutputs
    filter.includeTestsMatching("com.algolia.client.dsl.$suite.*")
    testLogging {
      events("failed", "skipped")
      exceptionFormat = TestExceptionFormat.FULL
    }
  }
  tasks.register<Test>("jvmDslP${phase}Test") {
    description = "Kotlin DSL capability matrix, phase $phase, offline."
    dslTest("matrix")
  }
  tasks.register<Test>("jvmDslP${phase}LiveTest") {
    description = "Kotlin DSL capability matrix, phase $phase, against the Algolia API."
    dslTest("live")
    systemProperty("algolia.dsl.live", "true")
    systemProperty("algolia.repoRoot", repoRoot)
    outputs.upToDateWhen { false }
    timeout.set(Duration.ofMinutes(15))
  }
}

tasks.register("jvmDslTest") {
  group = "verification"
  description = "Kotlin DSL capability matrix, all phases, offline."
  dependsOn(dslPhases.map { "jvmDslP${it}Test" })
}

tasks.register("jvmDslLiveTest") {
  group = "verification"
  description = "Kotlin DSL capability matrix, all phases, against the Algolia API."
  dependsOn(dslPhases.map { "jvmDslP${it}LiveTest" })
}
