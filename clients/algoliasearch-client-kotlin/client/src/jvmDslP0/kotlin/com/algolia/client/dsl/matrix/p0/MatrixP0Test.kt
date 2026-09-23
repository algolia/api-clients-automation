package com.algolia.client.dsl.matrix.p0

import com.algolia.client.dsl.*
import com.algolia.client.dsl.filter.*
import com.algolia.client.dsl.samples.RowsP0
import com.algolia.client.dsl.testkit.ServerContract
import com.algolia.client.dsl.testkit.assertWire
import kotlin.test.Test

/**
 * Offline half of the phase-0 capability and cross-check rows: each [RowsP0] function must
 * serialize to exactly the wire body of its server-contract row (or inline JSON for builder-only
 * semantics).
 */
internal class MatrixP0Test {

  @Test
  fun C01_queryScalars() {
    assertWire(ServerContract.L40, RowsP0.c01())
  }

  @Test
  fun C04_secondFiltersBlockReplacesTheFirst() {
    assertWire("""{"filters":"genre:drama"}""", RowsP0.c04())
  }

  @Test
  fun C05_storedFilterLambdas() {
    assertWire(ServerContract.L26c, RowsP0.c05())
  }

  @Test
  fun C20_sameFilterDslOnDeleteByAndSearch() {
    assertWire(ServerContract.D1, RowsP0.c20())
    assertWire(ServerContract.L39, RowsP0.c20Search())
  }

  @Test
  fun C22_legacyNumericAndTagOrGroups() {
    assertWire(ServerContract.L43, RowsP0.c22())
  }

  @Test
  fun C32_scoreOmittedVersusExplicitZeroInSqlOr() {
    assertWire(ServerContract.L51, RowsP0.c32())
  }

  @Test
  fun C34_typedCompanions() {
    assertWire(ServerContract.L53, RowsP0.c34())
    assertWire(
      """{"distinct":true,"typoTolerance":true,"ignorePlurals":true,"queryLanguages":["en"]}""",
      RowsP0.c34Variants(),
    )
  }

  @Test
  fun X03_orContextNotInsideOrFacet() {
    assertWire(ServerContract.L04, RowsP0.x03())
  }

  @Test
  fun X07_negatedRangeLeaf() {
    assertWire(ServerContract.L11b, RowsP0.x07())
  }

  @Test
  fun X08_sqlLeadingDashIsLiteral() {
    assertWire(ServerContract.L12a, RowsP0.x08a())
    assertWire(ServerContract.L12b, RowsP0.x08b())
  }

  @Test
  fun X17_orScoresIncludingZero() {
    assertWire(ServerContract.L09a, RowsP0.x17a())
    assertWire(ServerContract.L09b, RowsP0.x17b())
  }
}
