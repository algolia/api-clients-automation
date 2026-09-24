@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.synonym

import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.dsl.DSLStrings
import com.algolia.client.dsl.generated.DSLSynonymHit
import com.algolia.client.model.search.SynonymHit
import com.algolia.client.model.search.SynonymType

/**
 * Constructs a [SynonymHit] from the generated [DSLSynonymHit].
 *
 * Prefer the typed helpers ([synonym], [oneWaySynonym], [altCorrection1], [altCorrection2],
 * [placeholder]) so unused variant fields stay unset. Last write wins: a later assignment or helper
 * call replaces earlier values for the same field.
 *
 * ```
 * val hit =
 *   synonym {
 *     objectID = "syn-1"
 *     type = SynonymType.Synonym
 *     synonyms {
 *       +"car"
 *       +"auto"
 *     }
 *   }
 * ```
 */
@AlgoliaExperimentalDsl
public fun synonym(block: DSLSynonymHit.() -> Unit): SynonymHit =
  DSLSynonymHit().apply(block).build()

private fun synonymHit(
  objectID: String,
  type: SynonymType,
  configure: DSLSynonymHit.() -> Unit,
): SynonymHit =
  DSLSynonymHit()
    .apply {
      this.objectID = objectID
      this.type = type
      configure()
    }
    .build()

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
public fun synonym(objectID: String, block: DSLStrings.() -> Unit): SynonymHit =
  synonymHit(objectID, SynonymType.Synonym) { synonyms(block) }

/**
 * Constructs a one-way ([SynonymType.OneWaySynonym]) [SynonymHit].
 *
 * A query for [input] matches [block] words. The reverse does not apply.
 */
@AlgoliaExperimentalDsl
public fun oneWaySynonym(
  objectID: String,
  input: String,
  block: DSLStrings.() -> Unit,
): SynonymHit =
  synonymHit(objectID, SynonymType.OneWaySynonym) {
    this.input = input
    synonyms(block)
  }

/** Constructs a one-typo alternative-correction ([SynonymType.AltCorrection1]) [SynonymHit]. */
@AlgoliaExperimentalDsl
public fun altCorrection1(
  objectID: String,
  word: String,
  block: DSLStrings.() -> Unit,
): SynonymHit =
  synonymHit(objectID, SynonymType.AltCorrection1) {
    this.word = word
    corrections(block)
  }

/** Constructs a two-typo alternative-correction ([SynonymType.AltCorrection2]) [SynonymHit]. */
@AlgoliaExperimentalDsl
public fun altCorrection2(
  objectID: String,
  word: String,
  block: DSLStrings.() -> Unit,
): SynonymHit =
  synonymHit(objectID, SynonymType.AltCorrection2) {
    this.word = word
    corrections(block)
  }

/** Constructs a placeholder ([SynonymType.Placeholder]) [SynonymHit]. */
@AlgoliaExperimentalDsl
public fun placeholder(
  objectID: String,
  placeholder: String,
  block: DSLStrings.() -> Unit,
): SynonymHit =
  synonymHit(objectID, SynonymType.Placeholder) {
    this.placeholder = placeholder
    replacements(block)
  }

/**
 * Sets [DSLSynonymHit.synonyms] from [block]. Last write wins if [synonyms] was already set in the
 * same builder. An empty block sends `[]`.
 */
@AlgoliaExperimentalDsl
public fun DSLSynonymHit.synonyms(block: DSLStrings.() -> Unit) {
  synonyms = DSLStrings().apply(block).build()
}

/**
 * Sets [DSLSynonymHit.corrections] from [block]. Last write wins if [corrections] was already set
 * in the same builder. An empty block sends `[]`.
 */
@AlgoliaExperimentalDsl
public fun DSLSynonymHit.corrections(block: DSLStrings.() -> Unit) {
  corrections = DSLStrings().apply(block).build()
}

/**
 * Sets [DSLSynonymHit.replacements] from [block]. Last write wins if [replacements] was already set
 * in the same builder. An empty block sends `[]`.
 */
@AlgoliaExperimentalDsl
public fun DSLSynonymHit.replacements(block: DSLStrings.() -> Unit) {
  replacements = DSLStrings().apply(block).build()
}
