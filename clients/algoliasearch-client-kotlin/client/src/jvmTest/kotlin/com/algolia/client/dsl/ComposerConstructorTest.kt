@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * The composers' `base` parameter has a default, so Java callers keep a parameterless constructor.
 * Placed under `jvmTest` because it needs JVM [Class] reflection.
 */
internal class ComposerConstructorTest {

  @Test
  fun composersKeepAParameterlessJvmConstructor() {
    assertEquals(0, DSLQueryComposer::class.java.getConstructor().parameterCount)
    assertEquals(0, DSLDeleteByComposer::class.java.getConstructor().parameterCount)
  }
}
