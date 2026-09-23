package com.algolia.client.dsl.matrix.p1

import com.algolia.client.dsl.testkit.ServerContract
import kotlin.test.Test
import kotlin.test.assertEquals

/** Marker read by the next phase's canary to prove the association chain across compilations. */
internal object CanaryP1 {
  const val ID: String = "p1"
}

/** Proves that `dslP1` sees the phase-0 test kit (`associateWith(dslP0)`). */
internal class ClasspathCanaryP1Test {

  @Test
  fun seesPhase0TestKit() {
    assertEquals("L01", ServerContract.L01.id)
  }
}
