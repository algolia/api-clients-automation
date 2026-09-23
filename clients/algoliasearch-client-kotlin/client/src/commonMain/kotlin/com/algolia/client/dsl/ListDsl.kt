@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.model.search.SupportedLanguage

/** Builds a `List<String>` parameter: `+"title"`, `+listOf("a", "b")`, `extra.forEach { +it }`. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class StringListDsl {
  private val values: MutableList<String> = mutableListOf()

  public operator fun String.unaryPlus() {
    values += this
  }

  public operator fun Iterable<String>.unaryPlus() {
    values += this
  }

  internal fun build(): List<String> = values.toList()
}

/** Builds a `List<SupportedLanguage>` parameter: `+SupportedLanguage.En`. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class LanguagesDsl {
  private val values: MutableList<SupportedLanguage> = mutableListOf()

  public operator fun SupportedLanguage.unaryPlus() {
    values += this
  }

  public operator fun Iterable<SupportedLanguage>.unaryPlus() {
    values += this
  }

  internal fun build(): List<SupportedLanguage> = values.toList()
}
