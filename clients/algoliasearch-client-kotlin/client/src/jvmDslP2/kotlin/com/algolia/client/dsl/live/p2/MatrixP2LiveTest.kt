@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.live.p2

import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.dsl.samples.RowsP2
import com.algolia.client.dsl.searchSingleIndex
import com.algolia.client.dsl.testkit.LiveIndex
import com.algolia.client.dsl.testkit.ServerContract
import com.algolia.client.dsl.testkit.assertRow
import com.algolia.client.dsl.testkit.live
import com.algolia.client.dsl.testkit.wire
import kotlin.test.Test
import kotlin.test.assertEquals
import org.junit.AfterClass
import org.junit.BeforeClass

/**
 * Live half of the phase-2 capability rows: the wire body of each [RowsP2] function is sent raw to
 * the fixture index and must produce the engine result pinned by its server-contract row (TD6). C03
 * additionally exercises the typed DSL path `SearchClient.searchSingleIndex(name) { }` once.
 */
internal class MatrixP2LiveTest {

  companion object {
    private lateinit var fx: LiveIndex

    @JvmStatic
    @BeforeClass
    fun createFixture() {
      fx = LiveIndex.create("p2")
    }

    @JvmStatic
    @AfterClass
    fun deleteFixture() {
      if (::fx.isInitialized) fx.close()
    }
  }

  @Test
  fun C03_fullSnippetWithSearchableRestriction() = live {
    fx.assertRow(ServerContract.L41a, wire(RowsP2.c03()))
    val response = fx.client.searchSingleIndex(fx.name, block = RowsP2.c03Block)
    assertEquals(
      listOf("1"),
      response.hits.map { it.objectID },
      "C03: hits of the typed searchSingleIndex path",
    )
  }

  @Test
  fun C08_queryWrapperPortedToV3Receivers() = live {
    fx.assertRow(ServerContract.L29, wire(RowsP2.c08()))
  }

  @Test
  fun C25_restrictSearchableAttributesWithForEach() = live {
    fx.assertRow(ServerContract.L45a, wire(RowsP2.c25(listOf("alternateTitles"))))
    fx.assertRow(ServerContract.L45b, wire(RowsP2.c25(emptyList())))
  }

  @Test
  fun C26_attributesToHighlight() = live {
    fx.assertRow(ServerContract.L46, wire(RowsP2.c26()))
  }

  @Test
  fun C27_attributesToRetrieveWithForEach() = live {
    fx.assertRow(ServerContract.L47, wire(RowsP2.c27()))
  }

  @Test
  fun C28_queryLanguagesWithOptionalSecondary() = live {
    fx.assertRow(ServerContract.L48a, wire(RowsP2.c28(null)))
    fx.assertRow(ServerContract.L48b, wire(RowsP2.c28French()))
  }

  @Test
  fun C29_responseFieldsWithOtherAndConstant() = live {
    fx.assertRow(ServerContract.L22a, wire(RowsP2.c29()))
  }

  @Test
  fun C30_ruleContexts() = live {
    fx.assertRow(ServerContract.L49a, wire(RowsP2.c30()))
  }
}
