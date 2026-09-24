@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.DSLFacetFilters
import com.algolia.client.dsl.filter.DSLFilters
import com.algolia.client.model.search.SearchParamsObject

/**
 * Collects query fragments from several modules and builds one [SearchParamsObject].
 *
 * [add] and [override] only store their blocks; nothing runs until [build]. Each [build] runs every
 * stored [add] block, then writes each additive field once: all `filters { }` fragments run inside
 * one [DSLFilters] (so they are AND-ed), all `ruleContexts { }` fragments inside one [DSLStrings]
 * (so they concatenate in call order), and so on. Then every [override] block runs on the same
 * [QueryBuilder], in call order: last write wins, so an override that sets `filters` or a list
 * field replaces the accumulated value. Empty fragments leave the field omitted.
 *
 * Every [build] re-evaluates every stored block, so values captured by reference (a `var`, a
 * mutable list) are read at build time and side effects in a block repeat on each build. [build]
 * can be called repeatedly. Not thread-safe.
 */
@DSLParameters
@AlgoliaExperimentalDsl
public class QueryComposer public constructor() {
  private val core = ComposerCore(::QueryAdditions, ::QueryBuilder, QueryAdditions::applyTo)

  /**
   * Stores [block]. It runs on every [build], before the overrides; captured values are read then.
   */
  public fun add(block: QueryAdditions.() -> Unit): Unit = core.add(block)

  /** Stores [block]. It runs on every [build], after the additive fields. Last write wins. */
  public fun override(block: QueryBuilder.() -> Unit): Unit = core.override(block)

  public fun build(): SearchParamsObject = core.build().build()
}

/**
 * Additive receiver of [QueryComposer.add], created fresh on every [QueryComposer.build]. Each
 * method records its block for that field; the blocks for a field run together, in call order,
 * inside one receiver when the field is written.
 */
@DSLParameters
@AlgoliaExperimentalDsl
public class QueryAdditions internal constructor() {
  // Field names differ from the recorder names: `filters(it)` inside the lambda must resolve to the
  // builder helper, and a property must not appear in its own initializer.
  private val filtersField: Additive<QueryBuilder, DSLFilters> = Additive { filters(it) }
  private val optionalFiltersField: Additive<QueryBuilder, DSLFacetFilters> = Additive {
    optionalFilters(it)
  }
  private val restrictSearchableAttributesField: Additive<QueryBuilder, DSLAttributes> = Additive {
    restrictSearchableAttributes(it)
  }
  private val attributesToHighlightField: Additive<QueryBuilder, DSLAttributes> = Additive {
    attributesToHighlight(it)
  }
  private val attributesToRetrieveField: Additive<QueryBuilder, DSLAttributes> = Additive {
    attributesToRetrieve(it)
  }
  private val attributesToSnippetField: Additive<QueryBuilder, DSLStrings> = Additive {
    attributesToSnippet(it)
  }
  private val ruleContextsField: Additive<QueryBuilder, DSLStrings> = Additive { ruleContexts(it) }
  private val analyticsTagsField: Additive<QueryBuilder, DSLStrings> = Additive {
    analyticsTags(it)
  }
  private val facetsField: Additive<QueryBuilder, DSLAttributes> = Additive { facets(it) }
  private val disableTypoToleranceOnAttributesField: Additive<QueryBuilder, DSLAttributes> =
    Additive {
      disableTypoToleranceOnAttributes(it)
    }
  private val queryLanguagesField: Additive<QueryBuilder, DSLLanguage> = Additive {
    queryLanguages(it)
  }
  private val naturalLanguagesField: Additive<QueryBuilder, DSLLanguage> = Additive {
    naturalLanguages(it)
  }
  private val responseFieldsField: Additive<QueryBuilder, DSLStrings> = Additive {
    responseFields(it)
  }

  private val fields: List<Additive<QueryBuilder, *>> =
    listOf(
      filtersField,
      optionalFiltersField,
      restrictSearchableAttributesField,
      attributesToHighlightField,
      attributesToRetrieveField,
      attributesToSnippetField,
      ruleContextsField,
      analyticsTagsField,
      facetsField,
      disableTypoToleranceOnAttributesField,
      queryLanguagesField,
      naturalLanguagesField,
      responseFieldsField,
    )

  /**
   * Records a `filters` fragment. All fragments run inside one [DSLFilters], so they are AND-ed.
   */
  public fun filters(block: DSLFilters.() -> Unit): Unit = filtersField.add(block)

  /** Records an `optionalFilters` fragment. All fragments run inside one [DSLFacetFilters]. */
  public fun optionalFilters(block: DSLFacetFilters.() -> Unit): Unit =
    optionalFiltersField.add(block)

  /** Records a `restrictSearchableAttributes` fragment. Fragments concatenate in call order. */
  public fun restrictSearchableAttributes(block: DSLAttributes.() -> Unit): Unit =
    restrictSearchableAttributesField.add(block)

  /** Records an `attributesToHighlight` fragment. Fragments concatenate in call order. */
  public fun attributesToHighlight(block: DSLAttributes.() -> Unit): Unit =
    attributesToHighlightField.add(block)

  /** Records an `attributesToRetrieve` fragment. Fragments concatenate in call order. */
  public fun attributesToRetrieve(block: DSLAttributes.() -> Unit): Unit =
    attributesToRetrieveField.add(block)

  /** Records an `attributesToSnippet` fragment. Fragments concatenate in call order. */
  public fun attributesToSnippet(block: DSLStrings.() -> Unit): Unit =
    attributesToSnippetField.add(block)

  /** Records a `ruleContexts` fragment. Fragments concatenate in call order. */
  public fun ruleContexts(block: DSLStrings.() -> Unit): Unit = ruleContextsField.add(block)

  /** Records an `analyticsTags` fragment. Fragments concatenate in call order. */
  public fun analyticsTags(block: DSLStrings.() -> Unit): Unit = analyticsTagsField.add(block)

  /** Records a `facets` fragment. Fragments concatenate in call order. */
  public fun facets(block: DSLAttributes.() -> Unit): Unit = facetsField.add(block)

  /** Records a `disableTypoToleranceOnAttributes` fragment. Fragments concatenate in call order. */
  public fun disableTypoToleranceOnAttributes(block: DSLAttributes.() -> Unit): Unit =
    disableTypoToleranceOnAttributesField.add(block)

  /** Records a `queryLanguages` fragment. Fragments concatenate in call order. */
  public fun queryLanguages(block: DSLLanguage.() -> Unit): Unit = queryLanguagesField.add(block)

  /** Records a `naturalLanguages` fragment. Fragments concatenate in call order. */
  public fun naturalLanguages(block: DSLLanguage.() -> Unit): Unit =
    naturalLanguagesField.add(block)

  /** Records a `responseFields` fragment. Fragments concatenate in call order. */
  public fun responseFields(block: DSLStrings.() -> Unit): Unit = responseFieldsField.add(block)

  /**
   * Writes each field that has at least one recorded block onto [builder], once, through the
   * existing helper for that field. Fields without blocks are left untouched.
   */
  internal fun applyTo(builder: QueryBuilder) {
    for (field in fields) field.applyTo(builder)
  }
}

/** `QueryComposer().apply(block).build()`. */
@AlgoliaExperimentalDsl
public fun composeQuery(block: QueryComposer.() -> Unit): SearchParamsObject {
  return QueryComposer().apply(block).build()
}
