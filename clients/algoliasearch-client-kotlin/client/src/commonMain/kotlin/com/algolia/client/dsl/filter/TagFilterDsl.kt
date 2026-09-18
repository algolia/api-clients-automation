@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.model.search.TagFilters

/** AND-context builder for [Filter.Tag] leaves and [FilterGroup.Or.Tag] groups. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class TagFilterDsl internal constructor(private val nodes: FilterAccumulator<FilterGroup>) :
  TagLeaves by TagLeafMixin({ nodes.add(it) }) {

  public constructor() : this(FilterAccumulator())

  /** Adds a [FilterGroup.Or.Tag] of the tag leaves in [block]. */
  public fun or(block: TagOrDsl.() -> Unit) {
    nodes.add(FilterGroup.Or.Tag(TagOrDsl().apply(block).snapshot()))
  }

  /** Adds a typed [FilterGroup.Not] of the children in [block]. */
  public fun not(block: TagFilterDsl.() -> Unit) {
    nodes.add(negate(TagFilterDsl().apply(block).nodes.snapshot()))
  }

  internal fun root(): FilterGroup = nodes.root()
}

/**
 * OR-context builder for [TagAtom] children. Exposes only tag leaves and [not]. An empty [not]
 * block appends nothing.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class TagOrDsl internal constructor(private val nodes: FilterAccumulator<TagAtom>) :
  TagLeaves by TagLeafMixin(nodes::add) {

  public constructor() : this(FilterAccumulator())

  /**
   * Negates every tag atom collected in [block] and appends each as its own [TagAtom].
   *
   * An empty [block] appends nothing.
   */
  public fun not(block: TagOrDsl.() -> Unit) {
    for (atom in TagOrDsl().apply(block).snapshot()) {
      nodes.add(negateTagAtom(atom))
    }
  }

  internal fun snapshot(): List<TagAtom> = nodes.snapshot()
}

/** Constructs [TagFilters] from a tag-only DSL block, or `null` when the block is empty. */
@AlgoliaExperimentalDsl
public fun tagFilters(block: TagFilterDsl.() -> Unit): TagFilters? =
  FilterLegacyConverter.tag(TagFilterDsl().apply(block).root())
