@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.model.search.DeleteByParams
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * [DSLDeleteByComposer] collects `filters { }` fragments from several [DSLDeleteByComposer.add]
 * blocks into one [DeleteByParams]. All fragments run inside one filter receiver (so they are
 * AND-ed), then every [DSLDeleteByComposer.override] block runs on the same builder. An empty
 * composer builds an empty [DeleteByParams].
 */
internal class DSLDeleteByComposerTest {

  @Test
  fun fragmentsAndOverride() {
    val composer = DSLDeleteByComposer()
    composer.add { filters { facet("a", "1") } }
    composer.add { filters { facet("b", "2", isNegated = true) } }
    composer.override { aroundLatLng = "1,2" }
    assertEquals(
      DeleteByParams(filters = "a:1 AND NOT b:2", aroundLatLng = "1,2"),
      composer.build(),
    )

    assertEquals(DeleteByParams(), composeDeleteBy {})
  }
}
