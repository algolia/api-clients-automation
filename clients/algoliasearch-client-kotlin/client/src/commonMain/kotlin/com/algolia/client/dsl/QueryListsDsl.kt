@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

/**
 * Sets [QueryBuilder.restrictSearchableAttributes] from [block]. Last write wins: replaces any
 * earlier value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike
 * the settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.restrictSearchableAttributes(block: StringListDsl.() -> Unit) {
  restrictSearchableAttributes = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.attributesToHighlight] from [block]. Last write wins: replaces any earlier
 * value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the
 * settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.attributesToHighlight(block: StringListDsl.() -> Unit) {
  attributesToHighlight = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.attributesToRetrieve] from [block]. Last write wins: replaces any earlier
 * value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the
 * settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 *
 * An empty list sent explicitly strips the response; the empty block omits the field instead.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.attributesToRetrieve(block: StringListDsl.() -> Unit) {
  attributesToRetrieve = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.attributesToSnippet] from [block]. Last write wins: replaces any earlier
 * value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the
 * settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.attributesToSnippet(block: StringListDsl.() -> Unit) {
  attributesToSnippet = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.ruleContexts] from [block]. Last write wins: replaces any earlier value. An
 * empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.ruleContexts(block: StringListDsl.() -> Unit) {
  ruleContexts = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.analyticsTags] from [block]. Last write wins: replaces any earlier value. An
 * empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.analyticsTags(block: StringListDsl.() -> Unit) {
  analyticsTags = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.facets] from [block]. Last write wins: replaces any earlier value. An empty
 * block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.facets(block: StringListDsl.() -> Unit) {
  facets = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.disableTypoToleranceOnAttributes] from [block]. Last write wins: replaces any
 * earlier value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike
 * the settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.disableTypoToleranceOnAttributes(block: StringListDsl.() -> Unit) {
  disableTypoToleranceOnAttributes = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.queryLanguages] from [block]. Last write wins: replaces any earlier value. An
 * empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.queryLanguages(block: LanguagesDsl.() -> Unit) {
  queryLanguages = LanguagesDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.naturalLanguages] from [block]. Last write wins: replaces any earlier value.
 * An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings
 * helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.naturalLanguages(block: LanguagesDsl.() -> Unit) {
  naturalLanguages = LanguagesDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.responseFields] from [block]. Last write wins: replaces any earlier value. An
 * empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 *
 * An empty list sent explicitly strips the response; the empty block omits the field instead.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.responseFields(block: StringListDsl.() -> Unit) {
  responseFields = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}
