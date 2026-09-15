@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl

/**
 * A node in the typed filter tree.
 *
 * [And] stays mixed. [Or] is family typed: [Or.Facet], [Or.Tag], [Or.Numeric]. [Not] is a tree node
 * with a matching family variant so an OR child cannot change family.
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

  /** Children evaluated with `OR`. Each variant holds one filter family. */
  @AlgoliaDsl
  @AlgoliaExperimentalDsl
  public sealed interface Or : FilterGroup {
    public val children: List<FilterGroup>

    @AlgoliaDsl
    @AlgoliaExperimentalDsl
    public data class Facet(override val children: List<FacetAtom> = emptyList()) : Or {
      public constructor(vararg children: FacetAtom) : this(children.toList())
    }

    @AlgoliaDsl
    @AlgoliaExperimentalDsl
    public data class Tag(override val children: List<TagAtom> = emptyList()) : Or {
      public constructor(vararg children: TagAtom) : this(children.toList())
    }

    @AlgoliaDsl
    @AlgoliaExperimentalDsl
    public data class Numeric(override val children: List<NumericAtom> = emptyList()) : Or {
      public constructor(vararg children: NumericAtom) : this(children.toList())
    }
  }

  /** Negates [child]. Replaces version 2 `Filter.isNegated`. */
  @AlgoliaDsl
  @AlgoliaExperimentalDsl
  public sealed interface Not : FilterGroup {
    public val child: FilterGroup

    @AlgoliaDsl
    @AlgoliaExperimentalDsl
    public data class Group(override val child: FilterGroup) : Not

    @AlgoliaDsl
    @AlgoliaExperimentalDsl
    public data class Facet(override val child: Filter.Facet) : Not, FacetAtom

    @AlgoliaDsl
    @AlgoliaExperimentalDsl
    public data class Tag(override val child: Filter.Tag) : Not, TagAtom

    @AlgoliaDsl
    @AlgoliaExperimentalDsl
    public data class Numeric(override val child: NumericAtom) : Not, NumericAtom
  }
}

/** A facet leaf or a negated facet leaf. Legal children of [FilterGroup.Or.Facet]. */
@AlgoliaDsl @AlgoliaExperimentalDsl public sealed interface FacetAtom : FilterGroup

/** A tag leaf or a negated tag leaf. Legal children of [FilterGroup.Or.Tag]. */
@AlgoliaDsl @AlgoliaExperimentalDsl public sealed interface TagAtom : FilterGroup

/** A numeric leaf or a negated numeric node. Legal children of [FilterGroup.Or.Numeric]. */
@AlgoliaDsl @AlgoliaExperimentalDsl public sealed interface NumericAtom : FilterGroup

/** Unary `!` operator. Wraps this node in [FilterGroup.Not.Group]. */
@AlgoliaExperimentalDsl
public operator fun FilterGroup.not(): FilterGroup.Not.Group = FilterGroup.Not.Group(this)

/** Unary `!` operator. Wraps this facet in [FilterGroup.Not.Facet]. */
@AlgoliaExperimentalDsl
public operator fun Filter.Facet.not(): FilterGroup.Not.Facet = FilterGroup.Not.Facet(this)

/** Unary `!` operator. Wraps this tag in [FilterGroup.Not.Tag]. */
@AlgoliaExperimentalDsl
public operator fun Filter.Tag.not(): FilterGroup.Not.Tag = FilterGroup.Not.Tag(this)

/** Unary `!` operator. Wraps this comparison in [FilterGroup.Not.Numeric]. */
@AlgoliaExperimentalDsl
public operator fun Filter.Comparison.not(): FilterGroup.Not.Numeric = FilterGroup.Not.Numeric(this)

/** Unary `!` operator. Wraps this range in [FilterGroup.Not.Numeric]. */
@AlgoliaExperimentalDsl
public operator fun Filter.Range.not(): FilterGroup.Not.Numeric = FilterGroup.Not.Numeric(this)

internal fun negate(children: List<FilterGroup>): FilterGroup {
  return when (children.size) {
    0 -> FilterGroup.Not.Group(FilterGroup.And())
    1 -> negateNode(children.single())
    else -> FilterGroup.Not.Group(FilterGroup.And(children))
  }
}

internal fun negateNode(node: FilterGroup): FilterGroup {
  return when (node) {
    is Filter.Facet -> FilterGroup.Not.Facet(node)
    is Filter.Tag -> FilterGroup.Not.Tag(node)
    is Filter.Comparison -> FilterGroup.Not.Numeric(node)
    is Filter.Range -> FilterGroup.Not.Numeric(node)
    is FilterGroup.Not.Facet -> node.child
    is FilterGroup.Not.Tag -> node.child
    is FilterGroup.Not.Numeric -> node.child
    else -> FilterGroup.Not.Group(node)
  }
}

internal fun negateFacetAtom(atom: FacetAtom): FacetAtom {
  return when (atom) {
    is Filter.Facet -> FilterGroup.Not.Facet(atom)
    is FilterGroup.Not.Facet -> atom.child
  }
}

internal fun negateTagAtom(atom: TagAtom): TagAtom {
  return when (atom) {
    is Filter.Tag -> FilterGroup.Not.Tag(atom)
    is FilterGroup.Not.Tag -> atom.child
  }
}

internal fun negateNumericAtom(atom: NumericAtom): NumericAtom {
  return when (atom) {
    is Filter.Comparison -> FilterGroup.Not.Numeric(atom)
    is Filter.Range -> FilterGroup.Not.Numeric(atom)
    is FilterGroup.Not.Numeric -> atom.child
  }
}
