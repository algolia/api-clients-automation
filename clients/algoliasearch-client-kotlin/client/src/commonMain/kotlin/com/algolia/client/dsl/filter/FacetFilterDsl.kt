@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl

/** AND-context builder for [Filter.Facet] leaves and [FilterGroup.Or.Facet] groups. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class FacetFilterDsl {
  private val children: MutableList<FilterGroup> = mutableListOf()

  /** Adds a [Filter.Facet] on [attribute] equal to [value]. */
  public fun facet(attribute: String, value: String, score: Int? = null): Filter.Facet =
    Filter.Facet(attribute, value, score).also { children += it }

  /** Adds a [Filter.Facet] on [attribute] equal to [value]. */
  public fun facet(attribute: String, value: Boolean, score: Int? = null): Filter.Facet =
    Filter.Facet(attribute, value, score).also { children += it }

  /** Adds a [Filter.Facet] on [attribute] equal to [value]. */
  public fun facet(attribute: String, value: Number, score: Int? = null): Filter.Facet =
    Filter.Facet(attribute, value, score).also { children += it }

  /** Adds a [FilterGroup.Or.Facet] of the facet leaves in [block]. */
  public fun or(block: FacetOrDsl.() -> Unit) {
    children += FilterGroup.Or.Facet(FacetOrDsl().apply(block).snapshot())
  }

  /** Adds a typed [FilterGroup.Not] of the children in [block]. */
  public fun not(block: FacetFilterDsl.() -> Unit) {
    children += negate(FacetFilterDsl().apply(block).snapshot())
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
 * OR-context builder for [FacetAtom] children. Exposes only facet leaves and [not]. An empty [not]
 * block appends nothing.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class FacetOrDsl {
  private val children: MutableList<FacetAtom> = mutableListOf()

  /** Adds a [Filter.Facet] on [attribute] equal to [value]. */
  public fun facet(attribute: String, value: String, score: Int? = null): Filter.Facet =
    Filter.Facet(attribute, value, score).also { children += it }

  /** Adds a [Filter.Facet] on [attribute] equal to [value]. */
  public fun facet(attribute: String, value: Boolean, score: Int? = null): Filter.Facet =
    Filter.Facet(attribute, value, score).also { children += it }

  /** Adds a [Filter.Facet] on [attribute] equal to [value]. */
  public fun facet(attribute: String, value: Number, score: Int? = null): Filter.Facet =
    Filter.Facet(attribute, value, score).also { children += it }

  /**
   * Negates every facet atom collected in [block] and appends each as its own [FacetAtom].
   *
   * `not { facet(a); facet(b) }` yields two negated atoms. An empty [block] appends nothing.
   */
  public fun not(block: FacetOrDsl.() -> Unit) {
    for (atom in FacetOrDsl().apply(block).snapshot()) {
      children += negateFacetAtom(atom)
    }
  }

  internal fun snapshot(): List<FacetAtom> = children.toList()
}

/** Constructs a [Filters] value from a facet-only DSL block. */
@AlgoliaExperimentalDsl
public fun facetFilters(block: FacetFilterDsl.() -> Unit): Filters =
  FacetFilterDsl().apply(block).build()
