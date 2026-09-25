package com.algolia.client.dsl.cases

import java.lang.reflect.Modifier
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Offline half of every case: the body the DSL sample serializes to must equal the case's expected
 * body (compared as JSON, so key order is free). Runs in `jvmTest`, on every PR; the live suite
 * re-checks the same bytes before querying the engine.
 *
 * Cases are discovered with Java reflection over the static fields of type [LiveCase] /
 * [DeleteCase] on the topic objects — the technique of
 * [com.algolia.client.dsl.GeneratedBuilderCoverageTest] — so a new `val` is covered without
 * registration. Engine probes (`dsl == null`) have no DSL half and are skipped.
 */
internal class DslWireTest {

  private val topics: List<Any> =
    listOf(
      FilterCases,
      OptionalFilterCases,
      QueryParamCases,
      ComposerCases,
      DeleteCases,
      EscapingCases,
      EngineProbes,
    )

  @Test
  fun everyDslSampleSerializesToItsBody() {
    var checked = 0
    var probes = 0
    for (topic in topics) {
      val topicName = topic::class.java.simpleName
      for ((name, case) in topic.cases()) {
        val message = "$topicName.$name"
        when (case) {
          is LiveCase -> {
            val dsl = case.dsl
            if (dsl == null) {
              probes++
              continue
            }
            assertEquals(json(case.body), wire(dsl()), message)
          }
          is DeleteCase -> assertEquals(json(case.body), wire(case.dsl()), message)
          else -> error("$message: unexpected case type ${case::class}")
        }
        checked++
      }
    }
    println("DslWireTest: $checked DSL-backed cases checked, $probes engine probes skipped")
    assertTrue(checked > 0, "no DSL-backed case found: the reflection scan is broken")
    assertTrue(probes > 0, "no engine probe found: the reflection scan is broken")
  }

  /** Static fields of type [LiveCase] or [DeleteCase] declared on a topic object, by name. */
  private fun Any.cases(): List<Pair<String, Any>> =
    this::class
      .java
      .declaredFields
      .filter { field ->
        !field.isSynthetic &&
          Modifier.isStatic(field.modifiers) &&
          (field.type == LiveCase::class.java || field.type == DeleteCase::class.java)
      }
      .sortedBy { it.name }
      .map { field ->
        field.isAccessible = true
        field.name to field.get(null)
      }
}
