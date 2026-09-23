@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.samples

import com.algolia.client.dsl.*
import com.algolia.client.dsl.filter.*
import com.algolia.client.model.search.*

internal object CrossCheckRowsP1 {
  fun x01(): SearchParamsObject = query {
    filters {
      facet("color", "red")
      facet("category", "shirt")
    }
  }

  fun x02(): SearchParamsObject = query {
    filters {
      not {
        facet("color", "red")
        facet("category", "shirt")
      }
    }
  }

  fun x04(): SearchParamsObject = query {
    filters {
      not {
        orFacet {
          facet("color", "red")
          facet("color", "blue")
        }
      }
    }
  }

  fun x05(): SearchParamsObject = query {
    filters {
      and {
        facet("color", "red")
        facet("category", "shirt")
      }
      orNumeric {
        range("count", 0..9)
        comparison("count", NumericOperator.Equals, 10)
      }
    }
  }

  fun x06(): SearchParamsObject = query {
    filters {
      facet("color", "red")
      orFacet {
        facet("category", "shirt")
        facet("category", "pants")
      }
    }
  }

  fun x09a(): SearchParamsObject = query { facetFilters { facet("label", "-Movie") } }

  fun x09b(): SearchParamsObject = query { facetFilters { facet("count", 10) } }

  fun x09c(): SearchParamsObject = query { facetFilters { facet("count", -12) } }

  fun x10a(): SearchParamsObject = query {
    facetFilters { facet("color", "red", isNegated = true) }
  }

  fun x10b(): SearchParamsObject = query { facetFilters { not { facet("color", "red") } } }

  fun x11(): SearchParamsObject = query {
    facetFilters { facet("label", "-Movie", isNegated = true) }
  }

  fun x12a(): SearchParamsObject = query {
    facetFilters { facet("provider", "NBC: Universal \"East\"") }
  }

  fun x12b(): SearchParamsObject = query { facetFilters { facet("color", "navy blue") } }

  fun x12c(): SearchParamsObject = query {
    facetFilters { facet("color", "navy blue", isNegated = true) }
  }

  fun x13a(): SearchParamsObject = query { tagFilters { tag("-x") } }

  fun x13b(): SearchParamsObject = query { tagFilters { tag("-x", isNegated = true) } }

  private fun optional(block: FacetFilterDsl.() -> Unit): SearchParamsObject = query {
    optionalFilters(block)
    getRankingInfo = true
  }

  fun x14a(): SearchParamsObject = optional { facet("color", "red") }

  fun x14b(): SearchParamsObject = optional { facet("color", "red", score = 3) }

  fun x14c(): SearchParamsObject = optional { facet("color", "red", score = 0) }

  fun x14d(): SearchParamsObject = optional { facet("color", "red", score = 2, isNegated = true) }

  fun x14e(): SearchParamsObject = optional { facet("label", "-Movie") }

  fun x15a(): SearchParamsObject = optional {
    and {
      facet("color", "red")
      facet("category", "shirt")
    }
  }

  fun x15b(): SearchParamsObject = optional {
    or {
      facet("color", "red", score = 2)
      facet("category", "shirt", score = 1)
    }
  }

  fun x16a(): SearchParamsObject = optional { facet("color", "navy blue") }

  fun x16b(): SearchParamsObject = optional { facet("provider", "NBC: Universal \"East\"") }

  fun x16c(): SearchParamsObject = optional {
    facet("color", "navy blue", score = 2, isNegated = true)
  }

  fun x18(): SearchParamsObject = query {
    filters {
      facet("color", "red", score = 3)
      facet("category", "shirt")
    }
    getRankingInfo = true
  }

  fun x19a(): SearchParamsObject = query {
    filters {
      not {
        facet("color", "red")
        tag("x")
      }
    }
  }

  fun x19b(): SearchParamsObject = query {
    filters {
      not {
        orFacet {
          facet("color", "red")
          facet("color", "blue")
        }
        facet("category", "shirt")
      }
    }
  }
}
