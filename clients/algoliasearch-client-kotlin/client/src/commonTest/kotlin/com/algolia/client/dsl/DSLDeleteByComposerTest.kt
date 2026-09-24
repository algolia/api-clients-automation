@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.model.search.DeleteByParams
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

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

  @Test
  fun baseFiltersMergeWithFragments() {
    val params =
      composeDeleteBy(
        base = {
          aroundLatLng = "1,2"
          filters { facet("locale", "en-US") }
        }
      ) {
        add { filters { facet("entityId", "x", isNegated = true) } }
      }
    assertEquals(
      DeleteByParams(filters = "locale:en-US AND NOT entityId:x", aroundLatLng = "1,2"),
      params,
    )

    assertFailsWith<IllegalStateException> {
      composeDeleteBy(base = { filters = "a:1 OR b:2" }) { add { filters { facet("c", "3") } } }
    }
  }
}
