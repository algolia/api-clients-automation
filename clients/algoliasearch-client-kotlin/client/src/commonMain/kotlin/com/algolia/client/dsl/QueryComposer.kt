@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.FacetFilterDsl
import com.algolia.client.dsl.filter.FilterDsl
import com.algolia.client.model.search.SearchParamsObject

/**
 * Collects query fragments from several modules and builds one [SearchParamsObject].
 *
 * [add] and [override] only store their blocks; nothing runs until [build]. Each [build] runs every
 * stored [add] block, then writes each additive field once: all `filters { }` fragments run inside
 * one [FilterDsl] (so they are AND-ed), all `ruleContexts { }` fragments inside one [StringListDsl]
 * (so they concatenate in call order), and so on. Then every [override] block runs on the same
 * [QueryBuilder], in call order: last write wins, so an override that sets `filters` or a list
 * field replaces the accumulated value. Empty fragments leave the field omitted.
 *
 * Every [build] re-evaluates every stored block, so values captured by reference (a `var`, a
 * mutable list) are read at build time and side effects in a block repeat on each build. [build]
 * can be called repeatedly. Not thread-safe.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class QueryComposer public constructor() {
  private val additions = mutableListOf<QueryAdditions.() -> Unit>()
  private val overrides = mutableListOf<QueryBuilder.() -> Unit>()

  /**
   * Stores [block]. It runs on every [build], before the overrides; captured values are read then.
   */
  public fun add(block: QueryAdditions.() -> Unit) {
    additions += block
  }

  /** Stores [block]. It runs on every [build], after the additive fields. Last write wins. */
  public fun override(block: QueryBuilder.() -> Unit) {
    overrides += block
  }

  public fun build(): SearchParamsObject {
    val collected = QueryAdditions()
    for (block in additions) collected.block()
    val builder = QueryBuilder()
    collected.applyTo(builder)
    for (block in overrides) builder.block()
    return builder.build()
  }
}

/**
 * Additive receiver of [QueryComposer.add], created fresh on every [QueryComposer.build]. Each
 * method records its block for that field; the blocks for a field run together, in call order,
 * inside one receiver when the field is written.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class QueryAdditions internal constructor() {
  private val filterBlocks = Blocks<FilterDsl>()
  private val optionalFilterBlocks = Blocks<FacetFilterDsl>()
  private val restrictSearchableAttributeBlocks = Blocks<StringListDsl>()
  private val attributesToHighlightBlocks = Blocks<StringListDsl>()
  private val attributesToRetrieveBlocks = Blocks<StringListDsl>()
  private val attributesToSnippetBlocks = Blocks<StringListDsl>()
  private val ruleContextBlocks = Blocks<StringListDsl>()
  private val analyticsTagBlocks = Blocks<StringListDsl>()
  private val facetBlocks = Blocks<StringListDsl>()
  private val disableTypoToleranceOnAttributeBlocks = Blocks<StringListDsl>()
  private val queryLanguageBlocks = Blocks<LanguagesDsl>()
  private val naturalLanguageBlocks = Blocks<LanguagesDsl>()
  private val responseFieldBlocks = Blocks<ResponseFieldsDsl>()

  /** Records a `filters` fragment. All fragments run inside one [FilterDsl], so they are AND-ed. */
  public fun filters(block: FilterDsl.() -> Unit) {
    filterBlocks.add(block)
  }

  /** Records an `optionalFilters` fragment. All fragments run inside one [FacetFilterDsl]. */
  public fun optionalFilters(block: FacetFilterDsl.() -> Unit) {
    optionalFilterBlocks.add(block)
  }

  /** Records a `restrictSearchableAttributes` fragment. Fragments concatenate in call order. */
  public fun restrictSearchableAttributes(block: StringListDsl.() -> Unit) {
    restrictSearchableAttributeBlocks.add(block)
  }

  /** Records an `attributesToHighlight` fragment. Fragments concatenate in call order. */
  public fun attributesToHighlight(block: StringListDsl.() -> Unit) {
    attributesToHighlightBlocks.add(block)
  }

  /** Records an `attributesToRetrieve` fragment. Fragments concatenate in call order. */
  public fun attributesToRetrieve(block: StringListDsl.() -> Unit) {
    attributesToRetrieveBlocks.add(block)
  }

  /** Records an `attributesToSnippet` fragment. Fragments concatenate in call order. */
  public fun attributesToSnippet(block: StringListDsl.() -> Unit) {
    attributesToSnippetBlocks.add(block)
  }

  /** Records a `ruleContexts` fragment. Fragments concatenate in call order. */
  public fun ruleContexts(block: StringListDsl.() -> Unit) {
    ruleContextBlocks.add(block)
  }

  /** Records an `analyticsTags` fragment. Fragments concatenate in call order. */
  public fun analyticsTags(block: StringListDsl.() -> Unit) {
    analyticsTagBlocks.add(block)
  }

  /** Records a `facets` fragment. Fragments concatenate in call order. */
  public fun facets(block: StringListDsl.() -> Unit) {
    facetBlocks.add(block)
  }

  /** Records a `disableTypoToleranceOnAttributes` fragment. Fragments concatenate in call order. */
  public fun disableTypoToleranceOnAttributes(block: StringListDsl.() -> Unit) {
    disableTypoToleranceOnAttributeBlocks.add(block)
  }

  /** Records a `queryLanguages` fragment. Fragments concatenate in call order. */
  public fun queryLanguages(block: LanguagesDsl.() -> Unit) {
    queryLanguageBlocks.add(block)
  }

  /** Records a `naturalLanguages` fragment. Fragments concatenate in call order. */
  public fun naturalLanguages(block: LanguagesDsl.() -> Unit) {
    naturalLanguageBlocks.add(block)
  }

  /** Records a `responseFields` fragment. Fragments concatenate in call order. */
  public fun responseFields(block: ResponseFieldsDsl.() -> Unit) {
    responseFieldBlocks.add(block)
  }

  /**
   * Writes each field that has at least one recorded block onto [builder], once, through the
   * existing helper for that field. Fields without blocks are left untouched.
   *
   * Each `Blocks` is bound to a local before entering the helper's lambda: this class and the inner
   * receivers are all [AlgoliaDsl], so the DSL marker forbids reaching this instance implicitly
   * from inside the lambda.
   */
  internal fun applyTo(builder: QueryBuilder) {
    val filters = filterBlocks
    if (!filters.isEmpty()) builder.filters { filters.replay(this) }
    val optionalFilters = optionalFilterBlocks
    if (!optionalFilters.isEmpty()) builder.optionalFilters { optionalFilters.replay(this) }
    val restrictSearchableAttributes = restrictSearchableAttributeBlocks
    if (!restrictSearchableAttributes.isEmpty()) {
      builder.restrictSearchableAttributes { restrictSearchableAttributes.replay(this) }
    }
    val attributesToHighlight = attributesToHighlightBlocks
    if (!attributesToHighlight.isEmpty()) {
      builder.attributesToHighlight { attributesToHighlight.replay(this) }
    }
    val attributesToRetrieve = attributesToRetrieveBlocks
    if (!attributesToRetrieve.isEmpty()) {
      builder.attributesToRetrieve { attributesToRetrieve.replay(this) }
    }
    val attributesToSnippet = attributesToSnippetBlocks
    if (!attributesToSnippet.isEmpty()) {
      builder.attributesToSnippet { attributesToSnippet.replay(this) }
    }
    val ruleContexts = ruleContextBlocks
    if (!ruleContexts.isEmpty()) builder.ruleContexts { ruleContexts.replay(this) }
    val analyticsTags = analyticsTagBlocks
    if (!analyticsTags.isEmpty()) builder.analyticsTags { analyticsTags.replay(this) }
    val facets = facetBlocks
    if (!facets.isEmpty()) builder.facets { facets.replay(this) }
    val disableTypoToleranceOnAttributes = disableTypoToleranceOnAttributeBlocks
    if (!disableTypoToleranceOnAttributes.isEmpty()) {
      builder.disableTypoToleranceOnAttributes { disableTypoToleranceOnAttributes.replay(this) }
    }
    val queryLanguages = queryLanguageBlocks
    if (!queryLanguages.isEmpty()) builder.queryLanguages { queryLanguages.replay(this) }
    val naturalLanguages = naturalLanguageBlocks
    if (!naturalLanguages.isEmpty()) builder.naturalLanguages { naturalLanguages.replay(this) }
    val responseFields = responseFieldBlocks
    if (!responseFields.isEmpty()) builder.responseFields { responseFields.replay(this) }
  }
}

/** `QueryComposer().apply(block).build()`. */
@AlgoliaExperimentalDsl
public fun composeQuery(block: QueryComposer.() -> Unit): SearchParamsObject {
  return QueryComposer().apply(block).build()
}
