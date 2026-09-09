package com.algolia.client.dsl

import com.algolia.client.dsl.generated.IndexSettingsBuilder
import com.algolia.client.model.search.IndexSettings

/**
 * Constructs an [IndexSettings] value from the generated [IndexSettingsBuilder].
 *
 * Last write wins: a later assignment to the same builder property replaces an earlier one,
 * including values set by the typed helpers.
 *
 * ```
 * val settings = settings {
 *   searchableAttributes {
 *     ordered("name")
 *     unordered("description")
 *   }
 *   attributesForFaceting {
 *     +"brand"
 *     filterOnly("internalSku")
 *     searchable("category")
 *   }
 *   customRanking { desc("followers") }
 *   ranking {
 *     typo()
 *     geo()
 *     words()
 *     filters()
 *     proximity()
 *     attribute()
 *     exact()
 *     custom()
 *   }
 * }
 * ```
 */
@AlgoliaExperimentalDsl
public fun settings(block: IndexSettingsBuilder.() -> Unit): IndexSettings =
  IndexSettingsBuilder().apply(block).build()

/**
 * Sets [IndexSettingsBuilder.searchableAttributes] from typed helpers.
 *
 * Ordered attributes emit the bare name, matching v2 `SearchableAttribute.Default`. Several
 * attributes in one [SearchableAttributesDsl.ordered] call share priority and join with `", "`.
 * [SearchableAttributesDsl.unordered] emits `unordered(attribute)`.
 */
@AlgoliaExperimentalDsl
public fun IndexSettingsBuilder.searchableAttributes(block: SearchableAttributesDsl.() -> Unit) {
  searchableAttributes = SearchableAttributesDsl().apply(block).build()
}

/**
 * Sets [IndexSettingsBuilder.attributesForFaceting] from typed helpers.
 *
 * A plain attribute emits the bare name. [AttributesForFacetingDsl.filterOnly] emits
 * `filterOnly(attribute)`. [AttributesForFacetingDsl.searchable] emits `searchable(attribute)`.
 */
@AlgoliaExperimentalDsl
public fun IndexSettingsBuilder.attributesForFaceting(block: AttributesForFacetingDsl.() -> Unit) {
  attributesForFaceting = AttributesForFacetingDsl().apply(block).build()
}

/**
 * Sets [IndexSettingsBuilder.customRanking] from typed helpers.
 *
 * [CustomRankingDsl.asc] emits `asc(attribute)`. [CustomRankingDsl.desc] emits `desc(attribute)`.
 */
@AlgoliaExperimentalDsl
public fun IndexSettingsBuilder.customRanking(block: CustomRankingDsl.() -> Unit) {
  customRanking = CustomRankingDsl().apply(block).build()
}

/**
 * Sets [IndexSettingsBuilder.ranking] from the same modifiers version 2 exposed: `typo`, `geo`,
 * `words`, `filters`, `proximity`, `attribute`, `exact`, `custom`, plus `asc(attribute)` and
 * `desc(attribute)`.
 */
@AlgoliaExperimentalDsl
public fun IndexSettingsBuilder.ranking(block: RankingDsl.() -> Unit) {
  ranking = RankingDsl().apply(block).build()
}

/** Builds searchable-attribute strings for [IndexSettings.searchableAttributes]. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class SearchableAttributesDsl {
  private val values: MutableList<String> = mutableListOf()

  /**
   * Adds an ordered searchable attribute, or several attributes that share the same priority.
   *
   * One attribute emits the bare name. Several attributes emit a comma-separated string, matching
   * v2 `SearchableAttribute.Default`.
   */
  public fun ordered(attribute: String, vararg more: String) {
    values += if (more.isEmpty()) attribute else listOf(attribute, *more).joinToString()
  }

  /** Adds an unordered searchable attribute as `unordered(attribute)`. */
  public fun unordered(attribute: String) {
    values += "unordered($attribute)"
  }

  /** Adds [this] as an ordered searchable attribute. Matches v2 `+"name"`. */
  public operator fun String.unaryPlus() {
    ordered(this)
  }

  internal fun build(): List<String> = values.toList()
}

/** Builds attribute-for-faceting strings for [IndexSettings.attributesForFaceting]. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class AttributesForFacetingDsl {
  private val values: MutableList<String> = mutableListOf()

  /** Adds a facet attribute with no modifier. */
  public fun attribute(attribute: String) {
    values += attribute
  }

  /** Adds a filter-only attribute as `filterOnly(attribute)`. */
  public fun filterOnly(attribute: String) {
    values += "filterOnly($attribute)"
  }

  /** Adds a searchable facet attribute as `searchable(attribute)`. */
  public fun searchable(attribute: String) {
    values += "searchable($attribute)"
  }

  /** Adds [this] as a facet attribute with no modifier. Matches v2 `+"brand"`. */
  public operator fun String.unaryPlus() {
    attribute(this)
  }

  internal fun build(): List<String> = values.toList()
}

/** Builds custom-ranking strings for [IndexSettings.customRanking]. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class CustomRankingDsl {
  private val values: MutableList<String> = mutableListOf()

  /** Adds an ascending custom-ranking criterion as `asc(attribute)`. */
  public fun asc(attribute: String) {
    values += "asc($attribute)"
  }

  /** Adds a descending custom-ranking criterion as `desc(attribute)`. */
  public fun desc(attribute: String) {
    values += "desc($attribute)"
  }

  internal fun build(): List<String> = values.toList()
}

/** Builds ranking-formula strings for [IndexSettings.ranking]. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class RankingDsl {
  private val values: MutableList<String> = mutableListOf()

  /** Adds the `typo` ranking criterion. */
  public fun typo() {
    values += "typo"
  }

  /** Adds the `geo` ranking criterion. */
  public fun geo() {
    values += "geo"
  }

  /** Adds the `words` ranking criterion. */
  public fun words() {
    values += "words"
  }

  /** Adds the `filters` ranking criterion. */
  public fun filters() {
    values += "filters"
  }

  /** Adds the `proximity` ranking criterion. */
  public fun proximity() {
    values += "proximity"
  }

  /** Adds the `attribute` ranking criterion. */
  public fun attribute() {
    values += "attribute"
  }

  /** Adds the `exact` ranking criterion. */
  public fun exact() {
    values += "exact"
  }

  /** Adds the `custom` ranking criterion. */
  public fun custom() {
    values += "custom"
  }

  /** Adds an ascending sort criterion as `asc(attribute)`. */
  public fun asc(attribute: String) {
    values += "asc($attribute)"
  }

  /** Adds a descending sort criterion as `desc(attribute)`. */
  public fun desc(attribute: String) {
    values += "desc($attribute)"
  }

  internal fun build(): List<String> = values.toList()
}
