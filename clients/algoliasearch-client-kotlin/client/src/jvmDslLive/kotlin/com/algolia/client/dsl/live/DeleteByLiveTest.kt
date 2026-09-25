@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.live

import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.dsl.cases.DeleteCases
import com.algolia.client.dsl.cases.FilterCases
import com.algolia.client.dsl.deleteBy
import com.algolia.client.dsl.live.testkit.LiveIndex
import com.algolia.client.dsl.live.testkit.assertDelete
import com.algolia.client.dsl.live.testkit.live
import com.algolia.client.exception.AlgoliaApiException
import com.algolia.client.model.search.DeleteByParams
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.seconds
import org.junit.AfterClass
import org.junit.BeforeClass

/**
 * Live half of [DeleteCases]: each deletion goes through the typed `SearchClient.deleteBy` on a
 * per-test copy of the fixture, and the objectIDs left in the copy must be the case's `remaining`.
 */
internal class DeleteByLiveTest {

  companion object {
    private lateinit var fx: LiveIndex

    @JvmStatic
    @BeforeClass
    fun createFixture() {
      fx = LiveIndex.create("deleteby")
    }

    @JvmStatic
    @AfterClass
    fun deleteFixture() {
      if (::fx.isInitialized) fx.close()
    }
  }

  @Test
  fun orFacetOfTwoValues() =
    live(timeout = DELETE_TIMEOUT) {
      fx.assertDelete(DeleteCases.orFacetOfTwoValues) { copy ->
        copy.client.deleteBy(copy.name, DeleteCases.orFacetOfTwoValues.dsl()).taskID
      }
    }

  /** The block path `deleteBy(name) { filters(…) }`, with the fragment [FilterCases] shares. */
  @Test
  fun entityIdsExcludingBatch() =
    live(timeout = DELETE_TIMEOUT) {
      fx.assertDelete(DeleteCases.entityIdsExcludingBatch) { copy ->
        copy.client
          .deleteBy(copy.name) {
            filters(
              FilterCases.entityIdsExcludingBatchFilters(
                FilterCases.entityIds,
                FilterCases.CURRENT_BATCH_ID,
              )
            )
          }
          .taskID
      }
    }

  @Test
  fun composerFragmentsAnded() =
    live(timeout = DELETE_TIMEOUT) {
      fx.assertDelete(DeleteCases.composerFragmentsAnded) { copy ->
        copy.client.deleteBy(copy.name, DeleteCases.composerFragmentsAnded.dsl()).taskID
      }
    }

  /**
   * The engine rejects a delete-by with no filter and no geo condition, which is what the DSL's
   * client-side check (`requireDeleteCondition`) mirrors. Sent through the generated method, on a
   * copy, and nothing is deleted.
   */
  @Test
  fun emptyDeleteByRejectedByEngine() =
    live(timeout = DELETE_TIMEOUT) {
      fx.withCopy("delete") { copy ->
        val before = copy.remainingIds()
        val e =
          assertFailsWith<AlgoliaApiException> { copy.client.deleteBy(copy.name, DeleteByParams()) }
        assertEquals(400, e.httpErrorCode)
        assertTrue(
          e.message.orEmpty().contains("DeleteByQuery endpoint only supports"),
          "engine wording changed: ${e.message}",
        )
        assertEquals(before, copy.remainingIds())
      }
    }
}

/** Copy + deleteBy + two waits: more than one query round-trip. */
private val DELETE_TIMEOUT = 180.seconds
