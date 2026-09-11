@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.synonym

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.dsl.generated.SynonymHitBuilder
import com.algolia.client.model.search.SynonymHit
import com.algolia.client.model.search.SynonymType

/**
 * Constructs a [SynonymHit] from the generated [SynonymHitBuilder].
 *
 * Prefer the typed helpers ([synonym], [oneWaySynonym], [altCorrection1], [altCorrection2],
 * [placeholder]) so unused variant fields stay unset. Last write wins: a later assignment or helper
 * call replaces earlier values for the same field.
 *
 * ```
 * val hit =
 *   synonym("syn-1") {
 *     +"car"
 *     +"auto"
 *     +"vehicle"
 *   }
 * ```
 */
@AlgoliaExperimentalDsl
public fun synonym(block: SynonymHitBuilder.() -> Unit): SynonymHit =
  SynonymHitBuilder().apply(block).build()

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
public fun synonym(objectID: String, block: SynonymWordsDsl.() -> Unit): SynonymHit =
  SynonymHitBuilder()
    .apply {
      this.objectID = objectID
      type = SynonymType.Synonym
      synonyms(block)
    }
    .build()

/**
 * Constructs a one-way ([SynonymType.OneWaySynonym]) [SynonymHit].
 *
 * A query for [input] matches [block] words. The reverse does not apply.
 */
@AlgoliaExperimentalDsl
public fun oneWaySynonym(
  objectID: String,
  input: String,
  block: SynonymWordsDsl.() -> Unit,
): SynonymHit =
  SynonymHitBuilder()
    .apply {
      this.objectID = objectID
      type = SynonymType.OneWaySynonym
      this.input = input
      synonyms(block)
    }
    .build()

/** Constructs a one-typo alternative-correction ([SynonymType.AltCorrection1]) [SynonymHit]. */
@AlgoliaExperimentalDsl
public fun altCorrection1(
  objectID: String,
  word: String,
  block: SynonymWordsDsl.() -> Unit,
): SynonymHit =
  SynonymHitBuilder()
    .apply {
      this.objectID = objectID
      type = SynonymType.AltCorrection1
      this.word = word
      corrections(block)
    }
    .build()

/** Constructs a two-typo alternative-correction ([SynonymType.AltCorrection2]) [SynonymHit]. */
@AlgoliaExperimentalDsl
public fun altCorrection2(
  objectID: String,
  word: String,
  block: SynonymWordsDsl.() -> Unit,
): SynonymHit =
  SynonymHitBuilder()
    .apply {
      this.objectID = objectID
      type = SynonymType.AltCorrection2
      this.word = word
      corrections(block)
    }
    .build()

/** Constructs a placeholder ([SynonymType.Placeholder]) [SynonymHit]. */
@AlgoliaExperimentalDsl
public fun placeholder(
  objectID: String,
  placeholder: String,
  block: SynonymWordsDsl.() -> Unit,
): SynonymHit =
  SynonymHitBuilder()
    .apply {
      this.objectID = objectID
      type = SynonymType.Placeholder
      this.placeholder = placeholder
      replacements(block)
    }
    .build()

/**
 * Sets [SynonymHitBuilder.synonyms] from [block]. Last write wins if [synonyms] was already set in
 * the same builder.
 */
@AlgoliaExperimentalDsl
public fun SynonymHitBuilder.synonyms(block: SynonymWordsDsl.() -> Unit) {
  synonyms = SynonymWordsDsl().apply(block).build()
}

/**
 * Sets [SynonymHitBuilder.corrections] from [block]. Last write wins if [corrections] was already
 * set in the same builder.
 */
@AlgoliaExperimentalDsl
public fun SynonymHitBuilder.corrections(block: SynonymWordsDsl.() -> Unit) {
  corrections = SynonymWordsDsl().apply(block).build()
}

/**
 * Sets [SynonymHitBuilder.replacements] from [block]. Last write wins if [replacements] was already
 * set in the same builder.
 */
@AlgoliaExperimentalDsl
public fun SynonymHitBuilder.replacements(block: SynonymWordsDsl.() -> Unit) {
  replacements = SynonymWordsDsl().apply(block).build()
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
