package com.algolia.client.dsl.live.p0

import com.algolia.client.dsl.*
import com.algolia.client.dsl.filter.*
import com.algolia.client.dsl.samples.RowsP0
import com.algolia.client.dsl.testkit.LiveIndex
import com.algolia.client.dsl.testkit.ServerContract
import com.algolia.client.dsl.testkit.assertDelete
import com.algolia.client.dsl.testkit.assertRow
import com.algolia.client.dsl.testkit.live
import com.algolia.client.dsl.testkit.wire
import kotlin.test.Test
import kotlin.time.Duration.Companion.seconds
import org.junit.AfterClass
import org.junit.BeforeClass

/**
 * Live half of the phase-0 capability and cross-check rows: the wire body each [RowsP0] function
 * serializes to is sent to the engine and checked against the expectations of its server-contract
 * row, so the encoder and the engine evidence are asserted on the same bytes. The delete-by row
 * (C20) goes through the typed `SearchClient.deleteBy` on a per-test copy of the fixture.
 */
internal class MatrixP0LiveTest {

  companion object {
    private lateinit var fx: LiveIndex

    @JvmStatic
    @BeforeClass
    fun createFixture() {
      fx = LiveIndex.create("p0")
    }

    @JvmStatic
    @AfterClass
    fun deleteFixture() {
      if (::fx.isInitialized) fx.close()
    }
  }

  // ── Capability rows ───────────────────────────────────────────────────────────────────────────

  @Test fun C01_queryScalars() = live { fx.assertRow(ServerContract.L40, wire(RowsP0.c01())) }

  @Test
  fun C05_storedFilterLambdas() = live { fx.assertRow(ServerContract.L26c, wire(RowsP0.c05())) }

  @Test
  fun C20_sameFilterDslOnDeleteByAndSearch() =
    live(timeout = DELETE_TIMEOUT) {
      fx.assertRow(ServerContract.L39, wire(RowsP0.c20Search()))
      fx.assertDelete(ServerContract.D1) { copy ->
        copy.client.deleteBy(copy.name, RowsP0.c20()).taskID
      }
    }

  @Test
  fun C32_scoreOmittedVersusExplicitZeroInSqlOr() = live {
    fx.assertRow(ServerContract.L51, wire(RowsP0.c32()))
  }

  @Test fun C34_typedCompanions() = live { fx.assertRow(ServerContract.L53, wire(RowsP0.c34())) }

  // ── Encoder ↔ engine cross-check rows ─────────────────────────────────────────────────────────

  @Test
  fun X03_orContextNotInsideOrFacet() = live {
    fx.assertRow(ServerContract.L04, wire(RowsP0.x03()))
  }

  @Test fun X07_negatedRangeLeaf() = live { fx.assertRow(ServerContract.L11b, wire(RowsP0.x07())) }

  @Test
  fun X08_sqlLeadingDashIsLiteral() = live {
    fx.assertRow(ServerContract.L12a, wire(RowsP0.x08a()))
    fx.assertRow(ServerContract.L12b, wire(RowsP0.x08b()))
  }

  @Test
  fun X17_orScoresIncludingZero() = live {
    fx.assertRow(ServerContract.L09a, wire(RowsP0.x17a()))
    fx.assertRow(ServerContract.L09b, wire(RowsP0.x17b()))
  }
}

/** Copy + deleteBy + two waits: more than one query round-trip. */
private val DELETE_TIMEOUT = 180.seconds
