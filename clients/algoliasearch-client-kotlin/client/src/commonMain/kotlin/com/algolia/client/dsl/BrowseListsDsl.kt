@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

/**
 * Sets [BrowseBuilder.restrictSearchableAttributes] from [block]. Last write wins: replaces any
 * earlier value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike
 * the settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.restrictSearchableAttributes(block: StringListDsl.() -> Unit) {
  restrictSearchableAttributes = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.attributesToHighlight] from [block]. Last write wins: replaces any earlier
 * value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the
 * settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.attributesToHighlight(block: StringListDsl.() -> Unit) {
  attributesToHighlight = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.attributesToRetrieve] from [block]. Last write wins: replaces any earlier
 * value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the
 * settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 *
 * An empty list sent explicitly strips the response; the empty block omits the field instead.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.attributesToRetrieve(block: StringListDsl.() -> Unit) {
  attributesToRetrieve = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.attributesToSnippet] from [block]. Last write wins: replaces any earlier
 * value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the
 * settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.attributesToSnippet(block: StringListDsl.() -> Unit) {
  attributesToSnippet = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.ruleContexts] from [block]. Last write wins: replaces any earlier value. An
 * empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.ruleContexts(block: StringListDsl.() -> Unit) {
  ruleContexts = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.analyticsTags] from [block]. Last write wins: replaces any earlier value. An
 * empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.analyticsTags(block: StringListDsl.() -> Unit) {
  analyticsTags = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.facets] from [block]. Last write wins: replaces any earlier value. An empty
 * block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.facets(block: StringListDsl.() -> Unit) {
  facets = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.disableTypoToleranceOnAttributes] from [block]. Last write wins: replaces any
 * earlier value. An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike
 * the settings helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.disableTypoToleranceOnAttributes(block: StringListDsl.() -> Unit) {
  disableTypoToleranceOnAttributes = StringListDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.queryLanguages] from [block]. Last write wins: replaces any earlier value. An
 * empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.queryLanguages(block: LanguagesDsl.() -> Unit) {
  queryLanguages = LanguagesDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.naturalLanguages] from [block]. Last write wins: replaces any earlier value.
 * An empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings
 * helpers (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.naturalLanguages(block: LanguagesDsl.() -> Unit) {
  naturalLanguages = LanguagesDsl().apply(block).build().takeIf { it.isNotEmpty() }
}

/**
 * Sets [BrowseBuilder.responseFields] from [block]. Last write wins: replaces any earlier value. An
 * empty block sets `null` (omitted); assign `emptyList()` to send `[]`. Unlike the settings helpers
 * (`searchableAttributes { }` etc.), which send `[]` for an empty block.
 *
 * An empty list sent explicitly strips the response; the empty block omits the field instead.
 */
@AlgoliaExperimentalDsl
public fun BrowseBuilder.responseFields(block: ResponseFieldsDsl.() -> Unit) {
  responseFields = ResponseFieldsDsl().apply(block).build().takeIf { it.isNotEmpty() }
}
