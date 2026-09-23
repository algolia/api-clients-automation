package com.algolia.client.dsl.live.p3

import com.algolia.client.dsl.samples.RowsP3
import com.algolia.client.dsl.samples.SearchRequest
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
 * Live half of the phase-3 capability rows: the wire body of each [RowsP3] function is sent raw to
 * the fixture index and must produce the engine result pinned by its server-contract row (TD6). The
 * delete row (C14) sends the `DeleteByComposer` output through the typed `SearchClient.deleteBy` on
 * a per-test copy of the fixture.
 */
internal class MatrixP3LiveTest {

  companion object {
    private lateinit var fx: LiveIndex

    @JvmStatic
    @BeforeClass
    fun createFixture() {
      fx = LiveIndex.create("p3")
    }

    @JvmStatic
    @AfterClass
    fun deleteFixture() {
      if (::fx.isInitialized) fx.close()
    }
  }

  @Test
  fun C09_queryComposerAddAndOverride() = live {
    fx.assertRow(ServerContract.L30, wire(RowsP3.c09()))
  }

  @Test
  fun C10_applyLocaleModule() = live {
    fx.assertRow(ServerContract.L31a, wire(RowsP3.c10(null)))
    fx.assertRow(ServerContract.L31b, wire(RowsP3.c10("fr-FR")))
  }

  @Test
  fun C11_applySearchableTitleModule() = live {
    fx.assertRow(ServerContract.L32, wire(RowsP3.c11()))
  }

  @Test
  fun C12_applyBoostModule() = live {
    fx.assertRow(ServerContract.L33, wire(RowsP3.c12()))
  }

  @Test
  fun C13_assembleContributorsAppliedOnce() = live {
    fx.assertRow(ServerContract.L34, wire(RowsP3.c13()))
  }

  @Test
  fun C14_deleteByComposer() =
    live(timeout = DELETE_TIMEOUT) {
      fx.assertDelete(ServerContract.D2) { copy ->
        copy.client.deleteBy(copy.name, RowsP3.c14()).taskID
      }
    }

  @Test
  fun C18_requestMapModulesOnQueryComposer() = live {
    fx.assertRow(
      ServerContract.L37d,
      wire(RowsP3.c18(SearchRequest(mapOf("suggestionType" to "show", "priority" to "2")))),
    )
    fx.assertRow(ServerContract.L37c, wire(RowsP3.c18(SearchRequest(mapOf("priority" to "abc")))))
  }
}

/** Copy + deleteBy + two waits: more than one query round-trip. */
private val DELETE_TIMEOUT = 180.seconds
