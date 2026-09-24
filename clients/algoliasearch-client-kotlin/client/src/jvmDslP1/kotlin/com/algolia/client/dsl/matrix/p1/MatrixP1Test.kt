package com.algolia.client.dsl.matrix.p1

import com.algolia.client.dsl.*
import com.algolia.client.dsl.filter.*
import com.algolia.client.dsl.samples.RowsP1
import com.algolia.client.dsl.testkit.ServerContract
import com.algolia.client.dsl.testkit.assertWire
import kotlin.test.Test

/**
 * Offline half of the phase-1 capability rows: each [RowsP1] function must serialize to exactly the
 * wire body of its server-contract row (or inline JSON for builder-only semantics).
 */
internal class MatrixP1Test {

  @Test
  fun C02_filtersAndSingleFacet() {
    assertWire(ServerContract.L26a, RowsP1.c02())
  }

  @Test
  fun C06_fragmentsInOneScopeAndStoredFacetFilterDsl() {
    assertWire(ServerContract.L27, RowsP1.c06())
  }

  @Test
  fun C07_lookupByIdInjection() {
    assertWire(ServerContract.L28a, RowsP1.c07a())
    assertWire(ServerContract.L28b, RowsP1.c07b())
    assertWire(ServerContract.L28c, RowsP1.c07c())
  }

  @Test
  fun C15_severalGroupsAndedWithMixedValueTypes() {
    assertWire(ServerContract.L35, RowsP1.c15())
  }

  @Test
  fun C16_isNegatedFlag() {
    assertWire(ServerContract.L36a, RowsP1.c16a())
    assertWire(ServerContract.L36b, RowsP1.c16b())
  }

  @Test
  fun C17_filtersAndAddFacetModuleBodies() {
    assertWire(ServerContract.L37a, RowsP1.c17a())
    assertWire(ServerContract.L37b, RowsP1.c17b())
    assertWire(ServerContract.L37c, RowsP1.c17c())
    assertWire(ServerContract.L37d, RowsP1.c17d())
  }

  @Test
  fun C19_orFacetAndNegatedAndOnDeleteBy() {
    assertWire(ServerContract.D2, RowsP1.c19())
    assertWire(ServerContract.L38, RowsP1.c19Search())
  }

  @Test
  fun C21_sqlOrGroupsByFamily() {
    assertWire(ServerContract.L42, RowsP1.c21())
  }

  @Test
  fun C23_optionalFiltersOrWithScoresAndSumOrFiltersScores() {
    assertWire(ServerContract.L25, RowsP1.c23())
  }

  @Test
  fun C24_optionalFiltersAndOrScoreNegation() {
    assertWire(ServerContract.L44, RowsP1.c24())
  }

  @Test
  fun C31_userAddFacetExtensionOnFacetLeaves() {
    assertWire(ServerContract.L24, RowsP1.c31a())
    assertWire(ServerContract.L50a, RowsP1.c31b())
    assertWire(ServerContract.L50b, RowsP1.c31c())
    assertWire("""{"filters":"genre:comedy"}""", RowsP1.c31d())
    assertWire("""{"filters":"priority:2<score=0>"}""", RowsP1.c31e())
    assertWire("""{"optionalFilters":[["isFeatured:true<score=500>"]]}""", RowsP1.c31f())
  }

  @Test
  fun C33_explicitZeroInOptionalFilters() {
    assertWire(ServerContract.L52, RowsP1.c33())
  }
}
