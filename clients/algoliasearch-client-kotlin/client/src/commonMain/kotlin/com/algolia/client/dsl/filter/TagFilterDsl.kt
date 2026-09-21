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

  /**
   * Adds a [FilterGroup.Not] of the children in [block]. One child is wrapped as-is (a leaf under
   * `not { }` stays a leaf inside a [FilterGroup.Not]; its [Filter.negated] flag is not toggled).
   * Several children are wrapped as [FilterGroup.Not] of an [FilterGroup.And]. When the only child
   * is itself a [FilterGroup.Not], it is unwrapped, so `not { not { … } }` is the positive group.
   * An empty block adds a [FilterGroup.Not] of an empty [FilterGroup.And]: [filters] throws, the
   * legacy builders encode nothing.
   */
  public fun not(block: TagFilterDsl.() -> Unit) {
    nodes.add(negate(TagFilterDsl().apply(block).nodes.snapshot()))
  }

  internal fun root(): FilterGroup = nodes.root()
}

/**
 * OR-context builder for [Filter.Tag] children. Exposes only tag leaves and [not]. An empty [not]
 * block appends nothing.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class TagOrDsl internal constructor(private val nodes: FilterAccumulator<Filter.Tag>) :
  TagLeaves by TagLeafMixin(nodes::add) {

  public constructor() : this(FilterAccumulator())

  /**
   * Toggles [Filter.negated] on every tag leaf collected in [block] and appends each one.
   *
   * `not { tag(a); tag(b) }` yields two negated leaves (`NOT a OR NOT b` inside the OR); `not { not
   * { tag(a) } }` yields the positive leaf. An empty [block] appends nothing.
   */
  public fun not(block: TagOrDsl.() -> Unit) {
    for (leaf in TagOrDsl().apply(block).snapshot()) nodes.add(!leaf)
  }

  internal fun snapshot(): List<Filter.Tag> = nodes.snapshot()
}

/** Constructs [TagFilters] from a tag-only DSL block, or `null` when the block is empty. */
@AlgoliaExperimentalDsl
public fun tagFilters(block: TagFilterDsl.() -> Unit): TagFilters? =
  FilterLegacyConverter.tag(TagFilterDsl().apply(block).root())
