@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.dsl.DSLParameters

/** OR-context builder for [Filter.Facet] leaves. Exposes only facet leaves. */
@DSLParameters
@AlgoliaExperimentalDsl
public class DSLGroupFacet private constructor(private val leaves: MutableList<Filter.Facet>) :
  DSLFacet by FacetLeafMixin({ leaves.add(it) }) {

  internal constructor() : this(mutableListOf())

  internal fun leaves(): List<Filter.Facet> = leaves.toList()
}

/** OR-context builder for [Filter.Tag] leaves. Exposes only tag leaves. */
@DSLParameters
@AlgoliaExperimentalDsl
public class DSLGroupTag private constructor(private val leaves: MutableList<Filter.Tag>) :
  DSLTag by TagLeafMixin({ leaves.add(it) }) {

  internal constructor() : this(mutableListOf())

  internal fun leaves(): List<Filter.Tag> = leaves.toList()
}

/** OR-context builder for [Filter.Numeric] leaves. Exposes only numeric leaves. */
@DSLParameters
@AlgoliaExperimentalDsl
public class DSLGroupNumeric private constructor(private val leaves: MutableList<Filter.Numeric>) :
  DSLNumeric by NumericLeafMixin({ leaves.add(it) }) {

  internal constructor() : this(mutableListOf())

  internal fun leaves(): List<Filter.Numeric> = leaves.toList()
}
