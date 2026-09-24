package com.algolia.client.dsl.matrix.p1

import com.algolia.client.dsl.*
import com.algolia.client.dsl.filter.*
import com.algolia.client.dsl.samples.CrossCheckRowsP1
import com.algolia.client.dsl.testkit.ServerContract
import com.algolia.client.dsl.testkit.assertWire
import kotlin.test.Test
import kotlin.test.assertFailsWith

/**
 * Offline half of the phase-1 encoder ↔ engine cross-check rows: each [CrossCheckRowsP1] function
 * must serialize to exactly the wire body the engine was proven to accept (X19 must be rejected by
 * the encoder before it reaches the engine).
 */
internal class EncoderCrossCheckP1Test {

  @Test
  fun X01_rootAndNoParens() {
    assertWire(ServerContract.L01, CrossCheckRowsP1.x01())
  }

  @Test
  fun X02_deMorganAndToOrOfNots() {
    assertWire(ServerContract.L03a, CrossCheckRowsP1.x02())
  }

  @Test
  fun X04_deMorganOrToAndOfNots() {
    assertWire(ServerContract.L05, CrossCheckRowsP1.x04())
  }

  @Test
  fun X05_flatNestedAnd() {
    assertWire(ServerContract.L07b, CrossCheckRowsP1.x05())
  }

  @Test
  fun X06_andWithOrGroupFlat() {
    assertWire(ServerContract.L11a, CrossCheckRowsP1.x06())
  }

  @Test
  fun X14_unquotedOptionalScoreZeroAndNegativeOptional() {
    assertWire(ServerContract.L19a, CrossCheckRowsP1.x14a())
    assertWire(ServerContract.L19b, CrossCheckRowsP1.x14b())
    assertWire(ServerContract.L19c, CrossCheckRowsP1.x14c())
    assertWire(ServerContract.L19d, CrossCheckRowsP1.x14d())
    assertWire(ServerContract.L19e, CrossCheckRowsP1.x14e())
  }

  @Test
  fun X15_optionalAndRowsSummedOrMax() {
    assertWire(ServerContract.L20a, CrossCheckRowsP1.x15a())
    assertWire(ServerContract.L20b, CrossCheckRowsP1.x15b())
  }

  @Test
  fun X16_rawOptionalValues() {
    assertWire(ServerContract.L21a, CrossCheckRowsP1.x16a())
    assertWire(ServerContract.L21b, CrossCheckRowsP1.x16b())
    assertWire(ServerContract.L21c, CrossCheckRowsP1.x16c())
  }

  @Test
  fun X18_andScoresSummedFlat() {
    assertWire(ServerContract.L10, CrossCheckRowsP1.x18())
  }

  @Test
  fun X19_encoderRejectsMixedFamilyAndNestedNot() {
    assertFailsWith<IllegalArgumentException> { CrossCheckRowsP1.x19a() }
    assertFailsWith<IllegalArgumentException> { CrossCheckRowsP1.x19b() }
  }
}
