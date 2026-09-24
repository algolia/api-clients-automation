@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.DSLFilters
import java.io.File
import java.lang.reflect.Modifier
import kotlin.test.Test
import kotlin.test.assertTrue

/**
 * Naming rule: every public DSL receiver, that is every class annotated with [DSLParameters], is
 * named `DSL<Name>`.
 *
 * The receivers are what users see as `this` inside `query { }`, `filters { }`, `settings { }` and
 * the other blocks. The prefix tells them apart from the model classes they build (`DSLRule` vs
 * `Rule`) and is the version 2 convention. Hand-written and generated receivers are both covered:
 * the test scans the compiled main classes under `com/algolia/client/dsl/`, located from the code
 * source of [DSLFilters], instead of reading `.kt` sources, so a generated builder that drops the
 * prefix fails here too.
 *
 * Only top-level classes are scanned; names containing `$` (nested classes, lambdas) are skipped.
 * Kotlin `internal` compiles to a JVM-public class, so an internal class carrying the marker is
 * held to the same rule, which is intended: the marker is what makes it a DSL receiver.
 *
 * Typealiases (`DSLQuery`, `DSLSettings`, ...) leave no bytecode and are not covered here.
 *
 * Placed under `jvmTest` because it needs JVM [Class] loading and [Modifier] reflection.
 */
internal class DslNamingTest {

  @Test
  fun everyPublicDslReceiverStartsWithDsl() {
    val receivers = publicDslReceiverNames()

    // Guards against an empty or misdirected scan passing vacuously.
    val anchors = setOf("DSLFilters", "DSLQueryComposer", "DSLSearchParamsObject")
    assertTrue(
      receivers.containsAll(anchors),
      "The scan must find at least $anchors; missing ${anchors - receivers}, found $receivers",
    )

    val offenders = receivers.filterNot { it.startsWith("DSL") }.sorted()
    assertTrue(
      offenders.isEmpty(),
      "Public @DSLParameters classes must be named DSL<Name>, offenders: $offenders",
    )
  }

  /**
   * Simple names of every public top-level class under `com.algolia.client.dsl` (recursively)
   * annotated with [DSLParameters]. [DSLParameters] keeps Kotlin's default `RUNTIME` retention, so
   * the marker is visible through reflection.
   */
  private fun publicDslReceiverNames(): Set<String> {
    val root = File(DSLFilters::class.java.protectionDomain.codeSource.location.toURI())
    val dslDir = root.resolve("com/algolia/client/dsl")
    assertTrue(dslDir.isDirectory, "Expected compiled DSL classes under $dslDir")

    val loader = DSLFilters::class.java.classLoader
    return dslDir
      .walkTopDown()
      .filter { file -> file.isFile && file.name.endsWith(".class") && !file.name.contains('$') }
      .map { file ->
        val qualified =
          file.relativeTo(root).path.removeSuffix(".class").replace(File.separatorChar, '.')
        // initialize = false: reading annotations must not run static initializers.
        Class.forName(qualified, false, loader)
      }
      .filter { cls ->
        Modifier.isPublic(cls.modifiers) && cls.isAnnotationPresent(DSLParameters::class.java)
      }
      .map { it.simpleName }
      .toSet()
  }
}
