@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.FilterSqlConverter
import com.algolia.client.dsl.filter.NumericOperator
import com.algolia.client.dsl.filter.filters
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

/** Golden and ported vectors for [FilterSqlConverter]. Fixtures in FilterConverterFixtures.kt. */
internal class FilterSqlConverterTest {

  @Test
  fun sqlGoldenVectors() {
    sqlVectors.forEach { vector ->
      assertEquals(vector.sql, FilterSqlConverter(vector.group), vector.name)
    }
  }

  @Test
  fun sqlRejectVectors() {
    rejectVectors.forEach { vector ->
      assertFailsWith<IllegalArgumentException>(vector.name) { FilterSqlConverter(vector.group) }
    }
  }

  @Test
  fun docsDslVectorsMatchConverters() {
    val sql = filters {
      and {
        facet("color", "red")
        facet("category", "shirt")
      }
      orNumeric {
        range("price", 0 until 10)
        comparison("price", NumericOperator.Equals, 15)
      }
    }
    assertEquals("((color:red AND category:shirt) AND (price:0 TO 9 OR price = 15))", sql)
  }

  @Test
  fun v2PortedSqlVectors() {
    // Skip twoAndGroups_OfTheSameType_balanced: version 2 used a Set and collapsed equal groups.
    val vectors =
      listOf(
        Triple(
          "orFacet",
          filters {
            orFacet {
              facet("attributeA", 0)
              facet("attributeA", 1)
            }
          },
          "(attributeA:0 OR attributeA:1)",
        ),
        Triple(
          "orTag",
          filters {
            orTag {
              tag("a")
              tag("b")
            }
          },
          "(_tags:a OR _tags:b)",
        ),
        Triple(
          "orNumeric",
          filters {
            orNumeric {
              range("attributeA", 0..1)
              comparison("attributeA", NumericOperator.NotEquals, 0)
            }
          },
          "(attributeA:0 TO 1 OR attributeA != 0)",
        ),
        Triple(
          "emptyGroups",
          filters {
            and {}
            orFacet {}
          },
          null,
        ),
        Triple(
          "oneOfEveryType",
          filters {
            and { facet("attributeA", 0) }
            orFacet { facet("attributeA", 0) }
            orTag { tag("unknown") }
            orNumeric { range("attributeA", 0..1) }
          },
          "((attributeA:0) AND (attributeA:0) AND (_tags:unknown) AND (attributeA:0 TO 1))",
        ),
        Triple(
          "twoOfEveryType",
          filters {
            and {
              facet("attributeA", 0)
              facet("attributeB", 0)
            }
            orFacet {
              facet("attributeA", 0)
              facet("attributeB", 0)
            }
            orTag {
              tag("attributeA")
              tag("attributeB")
            }
            orNumeric {
              range("attributeA", 0..1)
              comparison("attributeB", NumericOperator.Greater, 0)
            }
          },
          "((attributeA:0 AND attributeB:0) AND (attributeA:0 OR attributeB:0) AND (_tags:attributeA OR _tags:attributeB) AND (attributeA:0 TO 1 OR attributeB > 0))",
        ),
        Triple(
          "singleAndGroups_differentTypes",
          filters {
            and {
              facet("attributeA", 0)
              tag("unknown")
            }
          },
          "(attributeA:0 AND _tags:unknown)",
        ),
        Triple(
          "twoAndGroups_OfDifferentTypes_balanced",
          filters {
            orTag {
              tag("attributeA")
              tag("attributeB")
            }
            orNumeric {
              range("attributeA", 0..1)
              range("attributeB", 0..1)
            }
          },
          "((_tags:attributeA OR _tags:attributeB) AND (attributeA:0 TO 1 OR attributeB:0 TO 1))",
        ),
        Triple(
          "twoAndGroups_OfTheSameType_unbalanced",
          filters {
            orTag { tag("attributeA") }
            orTag {
              tag("attributeA")
              tag("attributeB")
            }
          },
          "((_tags:attributeA) AND (_tags:attributeA OR _tags:attributeB))",
        ),
        Triple(
          "twoAndGroups_OfDifferentTypes_unbalanced",
          filters {
            orTag {
              tag("attributeA")
              tag("attributeB")
            }
            orNumeric { range("attributeA", 0..1) }
          },
          "((_tags:attributeA OR _tags:attributeB) AND (attributeA:0 TO 1))",
        ),
      )
    for ((name, sql, expected) in vectors) {
      assertEquals(expected, sql, name)
    }
  }

  @Test
  fun sqlAcceptsEveryFamily() {
    assertEquals(
      "(a:b AND _tags:t AND p:0 TO 1)",
      filters {
        facet("a", "b")
        tag("t")
        range("p", 0..1)
      },
    )
  }
}
