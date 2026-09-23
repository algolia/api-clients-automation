@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.generated.ConsequenceParamsBuilder

/**
 * Sets [ConsequenceParamsBuilder.restrictSearchableAttributes] from [block]. Last write wins:
 * replaces any earlier value. An empty block sets `null` (omitted); assign `emptyList()` to send
 * `[]`. Unlike the settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty
 * block.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.restrictSearchableAttributes(block: StringListDsl.() -> Unit) {
  restrictSearchableAttributes = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [ConsequenceParamsBuilder.attributesToHighlight] from [block]. Last write wins: replaces any
 * earlier value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike
 * the settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.attributesToHighlight(block: StringListDsl.() -> Unit) {
  attributesToHighlight = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [ConsequenceParamsBuilder.attributesToRetrieve] from [block]. Last write wins: replaces any
 * earlier value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike
 * the settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 *
 * An empty list sent explicitly strips the response; the empty block omits the field instead.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.attributesToRetrieve(block: StringListDsl.() -> Unit) {
  attributesToRetrieve = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [ConsequenceParamsBuilder.attributesToSnippet] from [block]. Last write wins: replaces any
 * earlier value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike
 * the settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.attributesToSnippet(block: StringListDsl.() -> Unit) {
  attributesToSnippet = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [ConsequenceParamsBuilder.ruleContexts] from [block]. Last write wins: replaces any earlier
 * value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the
 * settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.ruleContexts(block: StringListDsl.() -> Unit) {
  ruleContexts = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [ConsequenceParamsBuilder.analyticsTags] from [block]. Last write wins: replaces any earlier
 * value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the
 * settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.analyticsTags(block: StringListDsl.() -> Unit) {
  analyticsTags = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [ConsequenceParamsBuilder.facets] from [block]. Last write wins: replaces any earlier value.
 * An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings
 * helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.facets(block: StringListDsl.() -> Unit) {
  facets = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [ConsequenceParamsBuilder.disableTypoToleranceOnAttributes] from [block]. Last write wins:
 * replaces any earlier value. An empty block sets `null` (omitted); assign `emptyList()` to send
 * `[]`. Unlike the settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty
 * block.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.disableTypoToleranceOnAttributes(
  block: StringListDsl.() -> Unit
) {
  disableTypoToleranceOnAttributes = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [ConsequenceParamsBuilder.queryLanguages] from [block]. Last write wins: replaces any
 * earlier value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike
 * the settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.queryLanguages(block: LanguagesDsl.() -> Unit) {
  queryLanguages = LanguagesDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [ConsequenceParamsBuilder.naturalLanguages] from [block]. Last write wins: replaces any
 * earlier value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike
 * the settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.naturalLanguages(block: LanguagesDsl.() -> Unit) {
  naturalLanguages = LanguagesDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [ConsequenceParamsBuilder.responseFields] from [block]. Last write wins: replaces any
 * earlier value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike
 * the settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 *
 * An empty list sent explicitly strips the response; the empty block omits the field instead.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.responseFields(block: ResponseFieldsDsl.() -> Unit) {
  responseFields = ResponseFieldsDsl().apply(block).build().takeIf { it.isNotEmpty() }
}
