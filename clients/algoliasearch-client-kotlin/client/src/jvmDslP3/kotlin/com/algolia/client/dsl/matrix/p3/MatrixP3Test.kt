package com.algolia.client.dsl.matrix.p3

import com.algolia.client.dsl.samples.RowsP3
import com.algolia.client.dsl.samples.SearchRequest
import com.algolia.client.dsl.testkit.ServerContract
import com.algolia.client.dsl.testkit.assertWire
import kotlin.test.Test

/**
 * Offline half of the phase-3 capability rows: each [RowsP3] function must serialize to exactly the
 * wire body of its server-contract row. The rows exercise the SDK composers (`QueryComposer`,
 * `DeleteByComposer`) and the user-land modules of `Modules.kt` built on them.
 */
internal class MatrixP3Test {

  @Test
  fun C09_queryComposerAddAndOverride() {
    assertWire(ServerContract.L30, RowsP3.c09())
  }

  @Test
  fun C10_applyLocaleModule() {
    assertWire(ServerContract.L31a, RowsP3.c10(null))
    assertWire(ServerContract.L31b, RowsP3.c10("fr-FR"))
  }

  @Test
  fun C11_applySearchableTitleModule() {
    assertWire(ServerContract.L32, RowsP3.c11())
  }

  @Test
  fun C12_applyBoostModule() {
    assertWire(ServerContract.L33, RowsP3.c12())
  }

  @Test
  fun C13_assembleContributorsAppliedOnce() {
    assertWire(ServerContract.L34, RowsP3.c13())
  }

  @Test
  fun C14_deleteByComposer() {
    assertWire(ServerContract.D2, RowsP3.c14())
  }

  @Test
  fun C18_requestMapModulesOnQueryComposer() {
    assertWire(
      ServerContract.L37d,
      RowsP3.c18(SearchRequest(mapOf("suggestionType" to "show", "priority" to "2"))),
    )
    assertWire(ServerContract.L37c, RowsP3.c18(SearchRequest(mapOf("priority" to "abc"))))
  }
}
