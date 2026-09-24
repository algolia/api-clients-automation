@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

/**
 * Sets [BrowseBuilder.restrictSearchableAttributes] from [block]. Last write wins: replaces any
 * earlier value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike
 * the settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.restrictSearchableAttributes(block: DSLAttributes.() -> Unit) {
  restrictSearchableAttributes = DSLAttributes().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.attributesToHighlight] from [block]. Last write wins: replaces any earlier
 * value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the
 * settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.attributesToHighlight(block: DSLAttributes.() -> Unit) {
  attributesToHighlight = DSLAttributes().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.attributesToRetrieve] from [block]. Last write wins: replaces any earlier
 * value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the
 * settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 *
 * An empty list sent explicitly strips the response; the empty block omits the field instead.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.attributesToRetrieve(block: DSLAttributes.() -> Unit) {
  attributesToRetrieve = DSLAttributes().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.attributesToSnippet] from [block]. Last write wins: replaces any earlier
 * value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the
 * settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.attributesToSnippet(block: DSLStrings.() -> Unit) {
  attributesToSnippet = DSLStrings().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.ruleContexts] from [block]. Last write wins: replaces any earlier value. An
 * empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.ruleContexts(block: DSLStrings.() -> Unit) {
  ruleContexts = DSLStrings().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.analyticsTags] from [block]. Last write wins: replaces any earlier value. An
 * empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.analyticsTags(block: DSLStrings.() -> Unit) {
  analyticsTags = DSLStrings().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.facets] from [block]. Last write wins: replaces any earlier value. An empty
 * block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.facets(block: DSLAttributes.() -> Unit) {
  facets = DSLAttributes().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.disableTypoToleranceOnAttributes] from [block]. Last write wins: replaces any
 * earlier value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike
 * the settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.disableTypoToleranceOnAttributes(block: DSLAttributes.() -> Unit) {
  disableTypoToleranceOnAttributes = DSLAttributes().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.queryLanguages] from [block]. Last write wins: replaces any earlier value. An
 * empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.queryLanguages(block: DSLLanguage.() -> Unit) {
  queryLanguages = DSLLanguage().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.naturalLanguages] from [block]. Last write wins: replaces any earlier value.
 * An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings
 * helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.naturalLanguages(block: DSLLanguage.() -> Unit) {
  naturalLanguages = DSLLanguage().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.responseFields] from [block]. Last write wins: replaces any earlier value. An
 * empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 *
 * An empty list sent explicitly strips the response; the empty block omits the field instead.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.responseFields(block: DSLStrings.() -> Unit) {
  responseFields = DSLStrings().apply(block).build().takeIf { it.isNotEmpty() }
}
