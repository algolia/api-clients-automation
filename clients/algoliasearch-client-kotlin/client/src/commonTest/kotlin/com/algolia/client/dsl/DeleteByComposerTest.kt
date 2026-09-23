@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.model.search.DeleteByParams
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * [DeleteByComposer] collects `filters { }` fragments from several [DeleteByComposer.add] blocks
 * into one [DeleteByParams]. All fragments run inside one filter receiver (so they are AND-ed),
 * then every [DeleteByComposer.override] block runs on the same builder. An empty composer builds
 * an empty [DeleteByParams].
 */
internal class DeleteByComposerTest {

  @Test
  fun fragmentsAndOverride() {
    val composer = DeleteByComposer()
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
