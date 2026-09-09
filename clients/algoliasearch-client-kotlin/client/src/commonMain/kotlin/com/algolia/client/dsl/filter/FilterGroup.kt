package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl
import kotlin.jvm.JvmInline

/**
 * A node in the typed filter tree.
 *
 * Version 2 used typed groups (`And.Any`, `Or.Facet`, `Or.Numeric`, `Or.Tag`) and per-filter
 * `isNegated`. This v3 tree uses untyped [And] / [Or] plus [Not]. Each [Filter] leaf is also a
 * [FilterGroup], so groups nest arbitrarily:
 * - [And] and [Or] hold a list of [FilterGroup] children (leaves or nested groups).
 * - [Not] wraps one [FilterGroup] child.
 *
 * [Documentation](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/)
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public sealed interface FilterGroup {

  /** Children evaluated with `AND`. */
  @AlgoliaDsl
  @AlgoliaExperimentalDsl
  public data class And(public val children: List<FilterGroup> = emptyList()) : FilterGroup {

    public constructor(vararg children: FilterGroup) : this(children.toList())
  }

  /** Children evaluated with `OR`. */
  @AlgoliaDsl
  @AlgoliaExperimentalDsl
  public data class Or(public val children: List<FilterGroup> = emptyList()) : FilterGroup {

    public constructor(vararg children: FilterGroup) : this(children.toList())
  }

  /** Negates [child]. Replaces version 2 `Filter.isNegated`. */
  @AlgoliaDsl
  @AlgoliaExperimentalDsl
  @JvmInline
  public value class Not(public val child: FilterGroup) : FilterGroup
}

/** Unary `!` operator. Wraps this node in [FilterGroup.Not]. */
@AlgoliaExperimentalDsl
public operator fun FilterGroup.not(): FilterGroup.Not = FilterGroup.Not(this)
