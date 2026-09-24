package com.algolia.client.dsl.matrix.p0

import com.algolia.client.dsl.samples.RowsP0
import com.algolia.client.dsl.testkit.assertWire
import kotlin.test.Test

/**
 * Offline half of the phase-0 rows that have no server-contract twin: builder-only semantics
 * asserted against inline JSON. Every row with a contract twin is asserted live, on the same bytes
 * the engine receives ([com.algolia.client.dsl.testkit.assertRow]).
 */
internal class MatrixP0Test {

  @Test
  fun C04_secondFiltersBlockReplacesTheFirst() {
    assertWire("""{"filters":"genre:drama"}""", RowsP0.c04())
  }
}
