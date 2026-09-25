@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.DSLFacetFilters
import com.algolia.client.dsl.filter.DSLFilters
import com.algolia.client.model.search.SearchParamsObject
import kotlin.jvm.JvmOverloads

/**
 * Collects query fragments from several modules and builds one [SearchParamsObject].
 *
 * [add] and [override] only store their blocks; nothing runs until [build]. Each [build] runs every
 * stored [add] block, runs [base] on a fresh [DSLQuery], then merges each additive field into it
 * once: all `filters { }` fragments run inside one [DSLFilters] after the base rows (so they are
 * AND-ed with the base), all `ruleContexts { }` fragments inside one [DSLStrings] after the base
 * list (so they concatenate in call order), and so on. Then every [override] block runs on the same
 * [DSLQuery], in call order: last write wins, so an override that sets `filters` or a list field
 * replaces the merged value. A list field whose fragments add nothing is sent as `[]`; empty
 * `filters { }` / `optionalFilters { }` fragments leave the field as the base set it, or omitted.
 *
 * Put the starting query in [base], not in an [override]: an override replaces the fragments. A
 * base that assigns `filters` or `optionalFilters` directly (`filters = "a OR b"`) cannot be merged
 * with fragments for that field, so [build] throws [IllegalStateException]. Use the `filters { }`
 * block in the base instead.
 *
 * To start from an existing [SearchParamsObject], pass it as `from`: each [build] copies its values
 * into a fresh [DSLQuery] (the object itself is never modified), then every field that has `add {
 * }` fragments is replaced by those fragments, and every [override] runs last. Fields without
 * fragments keep the object's value. This is the version 2 `QueryWrapper(query).build()` behaviour,
 * without mutating the query.
 *
 * Every [build] re-evaluates every stored block, so values captured by reference (a `var`, a
 * mutable list) are read at build time and side effects in a block repeat on each build. [build]
 * can be called repeatedly. Not thread-safe.
 *
 * ```
 * val composer = DSLQueryComposer(base = { hitsPerPage = 10; filters { facet("base", "x") } })
 * composer.add { filters { facet("module", "y") } }
 * val params = composer.build() // filters = "base:x AND module:y"
 *
 * val seeded = DSLQueryComposer(from = existing) // existing.filters = "old:1", hitsPerPage = 5
 * seeded.add { filters { facet("module", "y") } }
 * seeded.build() // filters = "module:y", hitsPerPage = 5
 * ```
 */
@DSLParameters
@AlgoliaExperimentalDsl
public class DSLQueryComposer
private constructor(private val core: ComposerCore<DSLQueryAdditions, DSLQuery>) {

  /** Starts every [build] from [base] run on an empty [DSLQuery]; fragments merge into it. */
  @JvmOverloads
  public constructor(
    base: DSLQuery.() -> Unit = {}
  ) : this(
    ComposerCore(
      ::DSLQueryAdditions,
      { DSLQuery() },
      base,
      merge = true,
      DSLQueryAdditions::applyTo,
    )
  )

  /**
   * Starts every [build] from a copy of [from]; a field with `add { }` fragments is replaced by
   * them.
   */
  public constructor(
    from: SearchParamsObject
  ) : this(
    ComposerCore(
      ::DSLQueryAdditions,
      { DSLQuery(from) },
      {},
      merge = false,
      DSLQueryAdditions::applyTo,
    )
  )

  /**
   * Stores [block]. It runs on every [build], before the overrides; captured values are read then.
   */
  public fun add(block: DSLQueryAdditions.() -> Unit): Unit = core.add(block)

  /** Stores [block]. It runs on every [build], after the additive fields. Last write wins. */
  public fun override(block: DSLQuery.() -> Unit): Unit = core.override(block)

  public fun build(): SearchParamsObject = core.build().build()
}

/**
 * Additive receiver of [DSLQueryComposer.add], created fresh on every [DSLQueryComposer.build].
 * Each method records its block for that field; the blocks for a field run together, in call order,
 * inside one receiver when the field is written.
 */
@DSLParameters
@AlgoliaExperimentalDsl
public class DSLQueryAdditions internal constructor() {
  // Field names differ from the recorder names: `filters(it)` inside the lambda must resolve to the
  // builder helper, and a property must not appear in its own initializer.
  private val filtersField: Additive<DSLQuery, DSLFilters> =
    filterAdditive("filters", DSLQuery::filtersRows, DSLFilters::addRows, DSLFilters::and) {
      filters(it)
    }
  private val optionalFiltersField: Additive<DSLQuery, DSLFacetFilters> =
    filterAdditive(
      "optionalFilters",
      DSLQuery::optionalFiltersRows,
      DSLFacetFilters::addRows,
      DSLFacetFilters::and,
    ) {
      optionalFilters(it)
    }
  private val restrictSearchableAttributesField: Additive<DSLQuery, DSLAttributes> =
    listAdditive(DSLQuery::restrictSearchableAttributes, { +it }) {
      restrictSearchableAttributes(it)
    }
  private val attributesToHighlightField: Additive<DSLQuery, DSLAttributes> =
    listAdditive(DSLQuery::attributesToHighlight, { +it }) { attributesToHighlight(it) }
  private val attributesToRetrieveField: Additive<DSLQuery, DSLAttributes> =
    listAdditive(DSLQuery::attributesToRetrieve, { +it }) { attributesToRetrieve(it) }
  private val attributesToSnippetField: Additive<DSLQuery, DSLStrings> =
    listAdditive(DSLQuery::attributesToSnippet, { +it }) { attributesToSnippet(it) }
  private val ruleContextsField: Additive<DSLQuery, DSLStrings> =
    listAdditive(DSLQuery::ruleContexts, { +it }) { ruleContexts(it) }
  private val analyticsTagsField: Additive<DSLQuery, DSLStrings> =
    listAdditive(DSLQuery::analyticsTags, { +it }) { analyticsTags(it) }
  private val facetsField: Additive<DSLQuery, DSLAttributes> =
    listAdditive(DSLQuery::facets, { +it }) { facets(it) }
  private val disableTypoToleranceOnAttributesField: Additive<DSLQuery, DSLAttributes> =
    listAdditive(DSLQuery::disableTypoToleranceOnAttributes, { +it }) {
      disableTypoToleranceOnAttributes(it)
    }
  private val queryLanguagesField: Additive<DSLQuery, DSLLanguage> =
    listAdditive(DSLQuery::queryLanguages, { +it }) { queryLanguages(it) }
  private val naturalLanguagesField: Additive<DSLQuery, DSLLanguage> =
    listAdditive(DSLQuery::naturalLanguages, { +it }) { naturalLanguages(it) }
  private val responseFieldsField: Additive<DSLQuery, DSLStrings> =
    listAdditive(DSLQuery::responseFields, { +it }) { responseFields(it) }

  private val fields: List<Additive<DSLQuery, *>> =
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
   * existing helper for that field, after its current value when [merge] and in its place
   * otherwise. Fields without blocks are left untouched.
   */
  internal fun applyTo(builder: DSLQuery, merge: Boolean) {
    for (field in fields) field.applyTo(builder, merge)
  }
}

/** `DSLQueryComposer(base).apply(block).build()`. */
@AlgoliaExperimentalDsl
public fun composeQuery(
  base: DSLQuery.() -> Unit = {},
  block: DSLQueryComposer.() -> Unit,
): SearchParamsObject {
  return DSLQueryComposer(base).apply(block).build()
}

/** `DSLQueryComposer(from).apply(block).build()`. */
@AlgoliaExperimentalDsl
public fun composeQuery(
  from: SearchParamsObject,
  block: DSLQueryComposer.() -> Unit,
): SearchParamsObject {
  return DSLQueryComposer(from).apply(block).build()
}
