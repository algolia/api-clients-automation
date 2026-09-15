@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl

/** AND-context builder for [Filter.Tag] leaves and [FilterGroup.Or.Tag] groups. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class TagFilterDsl {
  private val children: MutableList<FilterGroup> = mutableListOf()

  /** Adds a [Filter.Tag] for [value]. */
  public fun tag(value: String): Filter.Tag = Filter.Tag(value).also { children += it }

  /** Adds a [FilterGroup.Or.Tag] of the tag leaves in [block]. */
  public fun or(block: TagOrDsl.() -> Unit) {
    children += FilterGroup.Or.Tag(TagOrDsl().apply(block).snapshot())
  }

  /** Adds a typed [FilterGroup.Not] of the children in [block]. */
  public fun not(block: TagFilterDsl.() -> Unit) {
    children += negate(TagFilterDsl().apply(block).snapshot())
  }

  internal fun build(): Filters = Filters(asNode())

  internal fun snapshot(): List<FilterGroup> = children.toList()

  private fun asNode(): FilterGroup =
    when (children.size) {
      0 -> FilterGroup.And()
      1 -> children.single()
      else -> FilterGroup.And(children.toList())
    }
}

/**
 * OR-context builder for [TagAtom] children. Exposes only tag leaves and [not]. An empty [not]
 * block appends nothing.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class TagOrDsl {
  private val children: MutableList<TagAtom> = mutableListOf()

  /** Adds a [Filter.Tag] for [value]. */
  public fun tag(value: String): Filter.Tag = Filter.Tag(value).also { children += it }

  /**
   * Negates every tag atom collected in [block] and appends each as its own [TagAtom].
   *
   * An empty [block] appends nothing.
   */
  public fun not(block: TagOrDsl.() -> Unit) {
    for (atom in TagOrDsl().apply(block).snapshot()) {
      children += negateTagAtom(atom)
    }
  }

  internal fun snapshot(): List<TagAtom> = children.toList()
}

/** Constructs a [Filters] value from a tag-only DSL block. */
@AlgoliaExperimentalDsl
public fun tagFilters(block: TagFilterDsl.() -> Unit): Filters = TagFilterDsl().apply(block).build()
