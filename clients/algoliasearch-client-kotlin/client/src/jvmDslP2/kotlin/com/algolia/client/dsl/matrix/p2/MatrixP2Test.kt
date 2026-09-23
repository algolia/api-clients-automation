package com.algolia.client.dsl.matrix.p2

import com.algolia.client.dsl.samples.RowsP2
import com.algolia.client.dsl.testkit.ServerContract
import com.algolia.client.dsl.testkit.assertWire
import com.algolia.client.model.search.SupportedLanguage
import kotlin.test.Test

/**
 * Offline half of the phase-2 capability rows: each [RowsP2] function must serialize to exactly the
 * wire body of its server-contract row (or inline JSON where no row exists).
 */
internal class MatrixP2Test {

  @Test
  fun C03_fullSnippetWithSearchableRestriction() {
    assertWire(ServerContract.L41a, RowsP2.c03())
  }

  @Test
  fun C08_queryWrapperPortedToV3Receivers() {
    assertWire(ServerContract.L29, RowsP2.c08())
  }

  @Test
  fun C25_restrictSearchableAttributesWithForEach() {
    assertWire(ServerContract.L45a, RowsP2.c25(listOf("alternateTitles")))
    assertWire(ServerContract.L45b, RowsP2.c25(emptyList()))
  }

  @Test
  fun C26_attributesToHighlight() {
    assertWire(ServerContract.L46, RowsP2.c26())
  }

  @Test
  fun C27_attributesToRetrieveWithForEach() {
    assertWire(ServerContract.L47, RowsP2.c27())
  }

  @Test
  fun C28_queryLanguagesWithOptionalSecondary() {
    assertWire(ServerContract.L48a, RowsP2.c28(null))
    assertWire(ServerContract.L48b, RowsP2.c28French())
    assertWire(
      """{"query":"the office","removeStopWords":true,"queryLanguages":["en","fr"]}""",
      RowsP2.c28(SupportedLanguage.Fr),
    )
  }

  @Test
  fun C29_responseFieldsWithOtherAndConstant() {
    assertWire(ServerContract.L22a, RowsP2.c29())
    assertWire(ServerContract.L22a, RowsP2.c29Constant())
  }

  @Test
  fun C30_ruleContexts() {
    assertWire(ServerContract.L49a, RowsP2.c30())
  }
}
