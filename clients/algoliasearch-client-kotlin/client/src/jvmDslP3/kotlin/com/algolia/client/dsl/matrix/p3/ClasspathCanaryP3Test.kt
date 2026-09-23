package com.algolia.client.dsl.matrix.p3

import com.algolia.client.dsl.matrix.p2.CanaryP2
import com.algolia.client.dsl.testkit.ServerContract
import kotlin.test.Test
import kotlin.test.assertEquals

/** Marker kept for symmetry with the earlier phases; nothing above phase 3 reads it. */
internal object CanaryP3 {
  const val ID: String = "p3"
}

/** Proves that `dslP3` sees the phase-0 test kit and the phase-2 sources. */
internal class ClasspathCanaryP3Test {

  @Test
  fun seesPhase0TestKitAndPhase2() {
    assertEquals("L01", ServerContract.L01.id)
    assertEquals("p2", CanaryP2.ID)
  }
}
