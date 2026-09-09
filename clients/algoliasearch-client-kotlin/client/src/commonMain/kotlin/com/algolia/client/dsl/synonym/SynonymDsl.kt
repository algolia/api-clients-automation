@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.synonym

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.model.search.SynonymHit
import com.algolia.client.model.search.SynonymType

/**
 * Constructs a [SynonymHit] from the DSL block.
 *
 * Prefer the typed helpers ([regular], [oneWay], [altCorrection1], [altCorrection2], [placeholder])
 * so unused variant fields stay unset. Last write wins: a later assignment or helper call replaces
 * earlier values for the same field.
 *
 * ```
 * val regular =
 *   synonym {
 *     regular("syn-1") {
 *       +"car"
 *       +"auto"
 *       +"vehicle"
 *     }
 *   }
 *
 * val oneWay =
 *   synonym {
 *     oneWay("syn-2", input = "tablet") {
 *       +"ipad"
 *       +"galaxy tab"
 *     }
 *   }
 *
 * val alt1 =
 *   synonym {
 *     altCorrection1("syn-3", word = "trousers") { +"pants" }
 *   }
 *
 * val alt2 =
 *   synonym {
 *     altCorrection2("syn-4", word = "trousers") { +"pants" }
 *   }
 *
 * val token =
 *   synonym {
 *     placeholder("syn-5", placeholder = "<Street>") {
 *       +"street"
 *       +"st"
 *     }
 *   }
 * ```
 */
@AlgoliaExperimentalDsl
public fun synonym(block: SynonymDsl.() -> Unit): SynonymHit = SynonymDsl().apply(block).build()

/**
 * Constructs a regular ([SynonymType.Synonym]) [SynonymHit].
 *
 * ```
 * val hit = synonym("syn-1") {
 *   +"car"
 *   +"auto"
 *   +"vehicle"
 * }
 * ```
 */
@AlgoliaExperimentalDsl
public fun synonym(objectID: String, block: SynonymWordsDsl.() -> Unit): SynonymHit = synonym {
  regular(objectID, block)
}

/**
 * Constructs a regular ([SynonymType.Synonym]) [SynonymHit] from [synonyms].
 *
 * ```
 * val hit = synonym("syn-1", listOf("car", "auto", "vehicle"))
 * ```
 */
@AlgoliaExperimentalDsl
public fun synonym(objectID: String, synonyms: List<String>): SynonymHit =
  synonym(objectID) { synonyms.forEach { +it } }

/**
 * Constructs a one-way ([SynonymType.OneWaySynonym]) [SynonymHit].
 *
 * A query for [input] matches [block] words. The reverse does not apply.
 *
 * ```
 * val hit =
 *   oneWaySynonym("syn-2", input = "tablet") {
 *     +"ipad"
 *     +"galaxy tab"
 *   }
 * ```
 */
@AlgoliaExperimentalDsl
public fun oneWaySynonym(
  objectID: String,
  input: String,
  block: SynonymWordsDsl.() -> Unit,
): SynonymHit = synonym { oneWay(objectID, input, block) }

/**
 * Constructs a one-way ([SynonymType.OneWaySynonym]) [SynonymHit] from [synonyms].
 *
 * ```
 * val hit = oneWaySynonym("syn-2", input = "tablet", synonyms = listOf("ipad", "galaxy tab"))
 * ```
 */
@AlgoliaExperimentalDsl
public fun oneWaySynonym(objectID: String, input: String, synonyms: List<String>): SynonymHit =
  oneWaySynonym(objectID, input) { synonyms.forEach { +it } }

/**
 * Constructs a one-typo alternative-correction ([SynonymType.AltCorrection1]) [SynonymHit].
 *
 * ```
 * val hit = altCorrection1("syn-3", word = "trousers") { +"pants" }
 * ```
 */
@AlgoliaExperimentalDsl
public fun altCorrection1(
  objectID: String,
  word: String,
  block: SynonymWordsDsl.() -> Unit,
): SynonymHit = synonym { altCorrection1(objectID, word, block) }

/**
 * Constructs a one-typo alternative-correction ([SynonymType.AltCorrection1]) [SynonymHit] from
 * [corrections].
 *
 * ```
 * val hit = altCorrection1("syn-3", word = "trousers", corrections = listOf("pants"))
 * ```
 */
@AlgoliaExperimentalDsl
public fun altCorrection1(objectID: String, word: String, corrections: List<String>): SynonymHit =
  altCorrection1(objectID, word) { corrections.forEach { +it } }

/**
 * Constructs a two-typo alternative-correction ([SynonymType.AltCorrection2]) [SynonymHit].
 *
 * ```
 * val hit = altCorrection2("syn-4", word = "trousers") { +"pants" }
 * ```
 */
@AlgoliaExperimentalDsl
public fun altCorrection2(
  objectID: String,
  word: String,
  block: SynonymWordsDsl.() -> Unit,
): SynonymHit = synonym { altCorrection2(objectID, word, block) }

/**
 * Constructs a two-typo alternative-correction ([SynonymType.AltCorrection2]) [SynonymHit] from
 * [corrections].
 *
 * ```
 * val hit = altCorrection2("syn-4", word = "trousers", corrections = listOf("pants"))
 * ```
 */
@AlgoliaExperimentalDsl
public fun altCorrection2(objectID: String, word: String, corrections: List<String>): SynonymHit =
  altCorrection2(objectID, word) { corrections.forEach { +it } }

/**
 * Constructs a placeholder ([SynonymType.Placeholder]) [SynonymHit].
 *
 * ```
 * val hit =
 *   placeholder("syn-5", placeholder = "<Street>") {
 *     +"street"
 *     +"st"
 *   }
 * ```
 */
@AlgoliaExperimentalDsl
public fun placeholder(
  objectID: String,
  placeholder: String,
  block: SynonymWordsDsl.() -> Unit,
): SynonymHit = synonym { placeholder(objectID, placeholder, block) }

/**
 * Constructs a placeholder ([SynonymType.Placeholder]) [SynonymHit] from [replacements].
 *
 * ```
 * val hit = placeholder("syn-5", placeholder = "<Street>", replacements = listOf("street", "st"))
 * ```
 */
@AlgoliaExperimentalDsl
public fun placeholder(
  objectID: String,
  placeholder: String,
  replacements: List<String>,
): SynonymHit = placeholder(objectID, placeholder) { replacements.forEach { +it } }

/**
 * Builder for a [SynonymHit].
 *
 * Variant helpers set [type] and the fields that variant uses, and clear the rest. Last write wins
 * if a later assignment or helper call replaces a field.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class SynonymDsl {
  /** Unique identifier of a synonym object. */
  public var objectID: String? = null

  /** Synonym type. */
  public var type: SynonymType? = null

  /** Words or phrases considered equivalent. Used by regular and one-way synonyms. */
  public var synonyms: List<String>? = null

  /** Query word or phrase for a one-way synonym. */
  public var input: String? = null

  /** Query word or phrase for an alternative correction. */
  public var word: String? = null

  /** Record words for an alternative correction. */
  public var corrections: List<String>? = null

  /** Placeholder token to put inside records. */
  public var placeholder: String? = null

  /** Query words that match [placeholder]. */
  public var replacements: List<String>? = null

  /**
   * Sets [synonyms] from [block]. Last write wins if [synonyms] was already set in the same
   * builder.
   */
  public fun synonyms(block: SynonymWordsDsl.() -> Unit) {
    synonyms = SynonymWordsDsl().apply(block).build()
  }

  /**
   * Sets [corrections] from [block]. Last write wins if [corrections] was already set in the same
   * builder.
   */
  public fun corrections(block: SynonymWordsDsl.() -> Unit) {
    corrections = SynonymWordsDsl().apply(block).build()
  }

  /**
   * Sets [replacements] from [block]. Last write wins if [replacements] was already set in the same
   * builder.
   */
  public fun replacements(block: SynonymWordsDsl.() -> Unit) {
    replacements = SynonymWordsDsl().apply(block).build()
  }

  /**
   * Fills this builder as a regular ([SynonymType.Synonym]) synonym.
   *
   * Clears fields that other variants use.
   */
  public fun regular(objectID: String, block: SynonymWordsDsl.() -> Unit) {
    this.objectID = objectID
    type = SynonymType.Synonym
    synonyms = SynonymWordsDsl().apply(block).build()
    clearUnused(keepSynonyms = true)
  }

  /**
   * Fills this builder as a one-way ([SynonymType.OneWaySynonym]) synonym.
   *
   * Clears fields that other variants use.
   */
  public fun oneWay(objectID: String, input: String, block: SynonymWordsDsl.() -> Unit) {
    this.objectID = objectID
    type = SynonymType.OneWaySynonym
    this.input = input
    synonyms = SynonymWordsDsl().apply(block).build()
    clearUnused(keepSynonyms = true, keepInput = true)
  }

  /**
   * Fills this builder as a one-typo alternative correction ([SynonymType.AltCorrection1]).
   *
   * Clears fields that other variants use.
   */
  public fun altCorrection1(objectID: String, word: String, block: SynonymWordsDsl.() -> Unit) {
    this.objectID = objectID
    type = SynonymType.AltCorrection1
    this.word = word
    corrections = SynonymWordsDsl().apply(block).build()
    clearUnused(keepWord = true, keepCorrections = true)
  }

  /**
   * Fills this builder as a two-typo alternative correction ([SynonymType.AltCorrection2]).
   *
   * Clears fields that other variants use.
   */
  public fun altCorrection2(objectID: String, word: String, block: SynonymWordsDsl.() -> Unit) {
    this.objectID = objectID
    type = SynonymType.AltCorrection2
    this.word = word
    corrections = SynonymWordsDsl().apply(block).build()
    clearUnused(keepWord = true, keepCorrections = true)
  }

  /**
   * Fills this builder as a placeholder ([SynonymType.Placeholder]) synonym.
   *
   * Clears fields that other variants use.
   */
  public fun placeholder(
    objectID: String,
    placeholder: String,
    block: SynonymWordsDsl.() -> Unit,
  ) {
    this.objectID = objectID
    type = SynonymType.Placeholder
    this.placeholder = placeholder
    replacements = SynonymWordsDsl().apply(block).build()
    clearUnused(keepPlaceholder = true, keepReplacements = true)
  }

  internal fun build(): SynonymHit =
    SynonymHit(
      objectID = requireNotNull(objectID) { "objectID is required" },
      type = requireNotNull(type) { "type is required" },
      synonyms = synonyms,
      input = input,
      word = word,
      corrections = corrections,
      placeholder = placeholder,
      replacements = replacements,
    )

  private fun clearUnused(
    keepSynonyms: Boolean = false,
    keepInput: Boolean = false,
    keepWord: Boolean = false,
    keepCorrections: Boolean = false,
    keepPlaceholder: Boolean = false,
    keepReplacements: Boolean = false,
  ) {
    if (!keepSynonyms) synonyms = null
    if (!keepInput) input = null
    if (!keepWord) word = null
    if (!keepCorrections) corrections = null
    if (!keepPlaceholder) placeholder = null
    if (!keepReplacements) replacements = null
  }
}

/** Collects synonym, correction, or replacement words. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class SynonymWordsDsl {
  private val values: MutableList<String> = mutableListOf()

  /** Adds [this] word or phrase. Matches other DSL `+"word"` helpers. */
  public operator fun String.unaryPlus() {
    values += this
  }

  internal fun build(): List<String> = values.toList()
}
