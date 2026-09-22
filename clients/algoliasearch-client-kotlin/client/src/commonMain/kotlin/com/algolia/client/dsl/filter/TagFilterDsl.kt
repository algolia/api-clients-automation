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

  /** Adds a [FilterGroup.Or.Tag] of the tag leaves in [block]. */
  public fun or(block: TagOrDsl.() -> Unit) {
    core.or(TagOrDsl().apply(block).snapshot())
  }

  /**
   * Negates the children in [block].
   *
   * One child gets unary `!`: a leaf toggles its [Filter.negated] flag (`not { tag("a") }` builds
   * the same tree as `!Filter.Tag("a")`), a nested `not { }` is unwrapped so `not { not { … } }` is
   * the positive node, and an `or { }` group is wrapped in [FilterGroup.Not]. Several children are
   * wrapped as [FilterGroup.Not] of an [FilterGroup.And]. An empty block adds nothing. Both
   * encoders emit a toggled leaf and a [FilterGroup.Not] over that leaf identically.
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
   * Toggles [Filter.negated] on every tag leaf collected in [block] and appends each one.
   *
   * `not { tag(a); tag(b) }` yields two negated leaves (`NOT a OR NOT b` inside the OR); `not { not
   * { tag(a) } }` yields the positive leaf. An empty [block] appends nothing.
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
