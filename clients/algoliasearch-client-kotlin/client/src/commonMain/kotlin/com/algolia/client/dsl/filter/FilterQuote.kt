package com.algolia.client.dsl.filter

/** Shared T5 quoting for SQL `filters` and for legacy numeric / tag leaves. */
internal object FilterQuote {
  private val KEYWORD: Regex = Regex("(?i)\\b(?:AND|OR|NOT)\\b")

  fun quote(raw: String): String {
    if (!needsQuotes(raw)) return raw
    return "\"${raw.replace("\"", "\\\"")}\""
  }

  fun needsQuotes(raw: String): Boolean {
    if (raw.isEmpty()) return true
    if (raw.any { it == ' ' || it == '"' || it == '\'' }) return true
    return KEYWORD.containsMatchIn(raw)
  }
}
