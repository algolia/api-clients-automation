@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.model.search.DeleteByParams
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

/**
 * [DSLDeleteByComposer] collects `filters { }` fragments from several [DSLDeleteByComposer.add]
 * blocks into one [DeleteByParams]. All fragments run inside one filter receiver (so they are
 * AND-ed), then every [DSLDeleteByComposer.override] block runs on the same builder. A composer
 * whose result has no filter and no geo condition throws: the engine rejects it.
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

    assertFailsWith<IllegalArgumentException> { DSLDeleteByComposer().build() }
  }

  @Test
  fun baseFiltersMergeWithFragments() {
    val params =
      DSLDeleteByComposer(
          base = {
            aroundLatLng = "1,2"
            filters { facet("locale", "en-US") }
          }
        )
        .apply { add { filters { facet("entityId", "x", isNegated = true) } } }
        .build()
    assertEquals(
      DeleteByParams(filters = "locale:en-US AND NOT entityId:x", aroundLatLng = "1,2"),
      params,
    )

    assertFailsWith<IllegalStateException> {
      DSLDeleteByComposer(base = { filters = "a:1 OR b:2" })
        .apply { add { filters { facet("c", "3") } } }
        .build()
    }
  }
}
