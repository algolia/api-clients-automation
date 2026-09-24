@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.live.p1

import com.algolia.client.dsl.*
import com.algolia.client.dsl.samples.CrossCheckRowsP1
import com.algolia.client.dsl.samples.RowsP1
import com.algolia.client.dsl.testkit.LiveIndex
import com.algolia.client.dsl.testkit.ServerContract
import com.algolia.client.dsl.testkit.assertDelete
import com.algolia.client.dsl.testkit.assertRow
import com.algolia.client.dsl.testkit.assertWire
import com.algolia.client.dsl.testkit.live
import com.algolia.client.dsl.testkit.wire
import kotlin.test.Test
import kotlin.time.Duration.Companion.seconds
import org.junit.AfterClass
import org.junit.BeforeClass

/**
 * Live half of the phase-1 capability and cross-check rows: the wire body of each [RowsP1] /
 * [CrossCheckRowsP1] function is sent to the engine against one fixture index and must produce the
 * response its server-contract row pins. The encoder and the engine evidence are checked on the
 * same bytes. The delete row (C19) runs the DSL client extension on a per-test copy of the fixture.
 */
internal class MatrixP1LiveTest {

  companion object {
    private lateinit var fx: LiveIndex

    @JvmStatic
    @BeforeClass
    fun createFixture() {
      fx = LiveIndex.create("p1")
    }

    @JvmStatic
    @AfterClass
    fun deleteFixture() {
      if (::fx.isInitialized) fx.close()
    }
  }

  // ── Capability rows ───────────────────────────────────────────────────────────────────────────

  @Test
  fun C02_filtersAndSingleFacet() = live {
    fx.assertRow(ServerContract.L26a, wire(RowsP1.c02()))
  }

  @Test
  fun C06_storedFragmentsAndedWithOptionalBoost() = live {
    fx.assertRow(ServerContract.L27, wire(RowsP1.c06()))
  }

  @Test
  fun C07_lookupByIdInjection() = live {
    fx.assertRow(ServerContract.L28a, wire(RowsP1.c07a()))
    fx.assertRow(ServerContract.L28b, wire(RowsP1.c07b()))
    fx.assertRow(ServerContract.L28c, wire(RowsP1.c07c()))
  }

  @Test
  fun C15_severalGroupsAndedWithTypedValues() = live {
    fx.assertRow(ServerContract.L35, wire(RowsP1.c15()))
  }

  @Test
  fun C16_isNegatedFlag() = live {
    fx.assertRow(ServerContract.L36a, wire(RowsP1.c16a()))
    fx.assertRow(ServerContract.L36b, wire(RowsP1.c16b()))
  }

  @Test
  fun C17_addFacetInsideAnd() = live {
    fx.assertRow(ServerContract.L37a, wire(RowsP1.c17a()))
    fx.assertRow(ServerContract.L37b, wire(RowsP1.c17b()))
    fx.assertRow(ServerContract.L37c, wire(RowsP1.c17c()))
    fx.assertRow(ServerContract.L37d, wire(RowsP1.c17d()))
  }

  @Test
  fun C19_deleteByWithFiltersDsl() =
    live(timeout = DELETE_TIMEOUT) {
      fx.assertRow(ServerContract.L38, wire(RowsP1.c19Search()))
      assertWire(ServerContract.D2, RowsP1.c19())
      fx.assertDelete(ServerContract.D2) { copy ->
        copy.client
          .deleteBy(copy.name) {
            filters(RowsP1.c19Filters(RowsP1.entityIds, RowsP1.CURRENT_BATCH_ID))
          }
          .taskID
      }
    }

  @Test
  fun C21_sqlOrGroupsByFamily() = live {
    fx.assertRow(ServerContract.L42, wire(RowsP1.c21()))
  }

  @Test
  fun C23_optionalOrRowWithSum() = live {
    fx.assertRow(ServerContract.L25, wire(RowsP1.c23()))
  }

  @Test
  fun C24_optionalAndOrWithScoreAndNegation() = live {
    fx.assertRow(ServerContract.L44, wire(RowsP1.c24()))
  }

  @Test
  fun C31_userAddFacetExtension() = live {
    fx.assertRow(ServerContract.L24, wire(RowsP1.c31a()))
    fx.assertRow(ServerContract.L50a, wire(RowsP1.c31b()))
    fx.assertRow(ServerContract.L50b, wire(RowsP1.c31c()))
  }

  @Test
  fun C33_explicitZeroInOptionalFilters() = live {
    fx.assertRow(ServerContract.L52, wire(RowsP1.c33()))
  }

  // ── Encoder ↔ engine cross-check rows ─────────────────────────────────────────────────────────

  @Test
  fun X01_rootAndNoParens() = live {
    fx.assertRow(ServerContract.L01, wire(CrossCheckRowsP1.x01()))
  }

  @Test
  fun X02_deMorganAnd() = live {
    fx.assertRow(ServerContract.L03a, wire(CrossCheckRowsP1.x02()))
  }

  @Test
  fun X04_deMorganOr() = live {
    fx.assertRow(ServerContract.L05, wire(CrossCheckRowsP1.x04()))
  }

  @Test
  fun X05_flatNestedAnd() = live {
    fx.assertRow(ServerContract.L07b, wire(CrossCheckRowsP1.x05()))
  }

  @Test
  fun X06_andWithOrGroupFlat() = live {
    fx.assertRow(ServerContract.L11a, wire(CrossCheckRowsP1.x06()))
  }

  @Test
  fun X14_optionalUnquotedScoresAndNegation() = live {
    fx.assertRow(ServerContract.L19a, wire(CrossCheckRowsP1.x14a()))
    fx.assertRow(ServerContract.L19b, wire(CrossCheckRowsP1.x14b()))
    fx.assertRow(ServerContract.L19c, wire(CrossCheckRowsP1.x14c()))
    fx.assertRow(ServerContract.L19d, wire(CrossCheckRowsP1.x14d()))
    fx.assertRow(ServerContract.L19e, wire(CrossCheckRowsP1.x14e()))
  }

  @Test
  fun X15_optionalAndRowsSummedOrMax() = live {
    fx.assertRow(ServerContract.L20a, wire(CrossCheckRowsP1.x15a()))
    fx.assertRow(ServerContract.L20b, wire(CrossCheckRowsP1.x15b()))
  }

  @Test
  fun X16_optionalRawValues() = live {
    fx.assertRow(ServerContract.L21a, wire(CrossCheckRowsP1.x16a()))
    fx.assertRow(ServerContract.L21b, wire(CrossCheckRowsP1.x16b()))
    fx.assertRow(ServerContract.L21c, wire(CrossCheckRowsP1.x16c()))
  }

  @Test
  fun X18_andScoresSummedFlat() = live {
    fx.assertRow(ServerContract.L10, wire(CrossCheckRowsP1.x18()))
  }
}

/** Copy + deleteBy + two waits: more than one query round-trip. */
private val DELETE_TIMEOUT = 180.seconds
