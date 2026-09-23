package com.algolia.client.dsl.matrix.p2

import com.algolia.client.dsl.matrix.p1.CanaryP1
import com.algolia.client.dsl.testkit.ServerContract
import kotlin.test.Test
import kotlin.test.assertEquals

/** Marker read by the next phase's canary to prove the association chain across compilations. */
internal object CanaryP2 {
  const val ID: String = "p2"
}

/** Proves that `dslP2` sees the phase-0 test kit and the phase-1 sources. */
internal class ClasspathCanaryP2Test {

  @Test
  fun seesPhase0TestKitAndPhase1() {
    assertEquals("L01", ServerContract.L01.id)
    assertEquals("p1", CanaryP1.ID)
  }
}
