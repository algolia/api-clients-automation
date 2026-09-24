@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

/**
 * Sets [QueryBuilder.restrictSearchableAttributes] from [block]. Last write wins: replaces any
 * earlier value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike
 * the settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.restrictSearchableAttributes(block: DSLAttributes.() -> Unit) {
  restrictSearchableAttributes = DSLAttributes().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.attributesToHighlight] from [block]. Last write wins: replaces any earlier
 * value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the
 * settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.attributesToHighlight(block: DSLAttributes.() -> Unit) {
  attributesToHighlight = DSLAttributes().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.attributesToRetrieve] from [block]. Last write wins: replaces any earlier
 * value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the
 * settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 *
 * An empty list sent explicitly strips the response; the empty block omits the field instead.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.attributesToRetrieve(block: DSLAttributes.() -> Unit) {
  attributesToRetrieve = DSLAttributes().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.attributesToSnippet] from [block]. Last write wins: replaces any earlier
 * value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the
 * settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.attributesToSnippet(block: DSLStrings.() -> Unit) {
  attributesToSnippet = DSLStrings().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.ruleContexts] from [block]. Last write wins: replaces any earlier value. An
 * empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.ruleContexts(block: DSLStrings.() -> Unit) {
  ruleContexts = DSLStrings().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.analyticsTags] from [block]. Last write wins: replaces any earlier value. An
 * empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.analyticsTags(block: DSLStrings.() -> Unit) {
  analyticsTags = DSLStrings().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.facets] from [block]. Last write wins: replaces any earlier value. An empty
 * block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.facets(block: DSLAttributes.() -> Unit) {
  facets = DSLAttributes().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.disableTypoToleranceOnAttributes] from [block]. Last write wins: replaces any
 * earlier value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike
 * the settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.disableTypoToleranceOnAttributes(block: DSLAttributes.() -> Unit) {
  disableTypoToleranceOnAttributes = DSLAttributes().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.queryLanguages] from [block]. Last write wins: replaces any earlier value. An
 * empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.queryLanguages(block: DSLLanguage.() -> Unit) {
  queryLanguages = DSLLanguage().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.naturalLanguages] from [block]. Last write wins: replaces any earlier value.
 * An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings
 * helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.naturalLanguages(block: DSLLanguage.() -> Unit) {
  naturalLanguages = DSLLanguage().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [QueryBuilder.responseFields] from [block]. Last write wins: replaces any earlier value. An
 * empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 *
 * An empty list sent explicitly strips the response; the empty block omits the field instead.
 */
@AlgoliaExperimentalDsl
public fun QueryBuilder.responseFields(block: DSLStrings.() -> Unit) {
  responseFields = DSLStrings().apply(block).build().takeIf { it.isNotEmpty() }
}
