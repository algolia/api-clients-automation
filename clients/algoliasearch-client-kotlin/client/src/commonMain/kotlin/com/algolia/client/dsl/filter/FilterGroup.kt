@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl

/**
 * A node in the typed filter tree.
 *
 * [And] stays mixed. [Or] is family typed and holds leaves only: [Or.Facet] holds [Filter.Facet],
 * [Or.Tag] holds [Filter.Tag], [Or.Numeric] holds [Filter.Numeric]. Negation lives on the leaves as
 * [Filter.negated]; groups are never negated.
 *
 * [Documentation](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/)
 */
internal sealed interface FilterGroup {

  /** Children evaluated with `AND`. */
  data class And(val children: List<FilterGroup> = emptyList()) : FilterGroup {

    internal constructor(vararg children: FilterGroup) : this(children.toList())
  }

  /** Children evaluated with `OR`. Each variant holds one filter family. */
  sealed interface Or : FilterGroup {
    val children: List<Filter>

    data class Facet(override val children: List<Filter.Facet> = emptyList()) : Or {
      internal constructor(vararg children: Filter.Facet) : this(children.toList())
    }

    data class Tag(override val children: List<Filter.Tag> = emptyList()) : Or {
      internal constructor(vararg children: Filter.Tag) : this(children.toList())
    }

    data class Numeric(override val children: List<Filter.Numeric> = emptyList()) : Or {
      internal constructor(vararg children: Filter.Numeric) : this(children.toList())
    }
  }
}
