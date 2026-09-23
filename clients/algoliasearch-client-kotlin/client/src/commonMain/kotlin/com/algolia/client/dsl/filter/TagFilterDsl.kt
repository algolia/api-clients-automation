@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.model.search.TagFilters

/** AND-context builder for [Filter.Tag] leaves and [FilterGroup.Or.Tag] groups. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class TagFilterDsl internal constructor(private val core: FamilyAndBuilder<Filter.Tag>) :
  TagLeaves by TagLeafMixin(core::add) {

  public constructor() : this(FamilyAndBuilder<Filter.Tag> { FilterGroup.Or.Tag(it) })

  /**
   * Adds an [FilterGroup.And] of the children in [block]. An empty block adds nothing. The encoders
   * flatten it into the enclosing `AND`, so `tagFilters { and { tag("a"); tag("b") } }` encodes as
   * `[["a"], ["b"]]`.
   */
  public fun and(block: TagFilterDsl.() -> Unit) {
    core.and(TagFilterDsl().apply(block).core.snapshot())
  }

  /** Adds a [FilterGroup.Or.Tag] of the tag leaves in [block]. An empty block adds nothing. */
  public fun or(block: TagOrDsl.() -> Unit) {
    core.or(TagOrDsl().apply(block).snapshot())
  }

  /**
   * Negates the children in [block]. One child gets unary `!` ([FilterGroup.not]); several become
   * [FilterGroup.Not] of an [FilterGroup.And]; an empty block adds nothing.
   */
  public fun not(block: TagFilterDsl.() -> Unit) {
    core.not(TagFilterDsl().apply(block).core.snapshot())
  }

  internal fun root(): FilterGroup = core.root()
}

/**
 * OR-context builder for [Filter.Tag] children. Exposes only tag leaves and [not]. An empty [not]
 * block appends nothing.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class TagOrDsl internal constructor(private val core: FamilyOrBuilder<Filter.Tag>) :
  TagLeaves by TagLeafMixin(core::add) {

  public constructor() : this(FamilyOrBuilder<Filter.Tag> { !it })

  /**
   * Appends each tag leaf in [block] with [Filter.negated] toggled: `not { a; b }` contributes `NOT
   * a OR NOT b`. An empty block appends nothing.
   */
  public fun not(block: TagOrDsl.() -> Unit) {
    core.not(TagOrDsl().apply(block).snapshot())
  }

  internal fun snapshot(): List<Filter.Tag> = core.snapshot()
}

/** Constructs [TagFilters] from a tag-only DSL block, or `null` when the block is empty. */
@AlgoliaExperimentalDsl
public fun tagFilters(block: TagFilterDsl.() -> Unit): TagFilters? =
  FilterLegacyConverter.tag(TagFilterDsl().apply(block).root())
