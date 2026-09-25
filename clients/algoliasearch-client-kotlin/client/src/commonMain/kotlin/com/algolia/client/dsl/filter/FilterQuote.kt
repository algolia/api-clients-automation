package com.algolia.client.dsl.filter

/**
 * Quoting for SQL `filters` attributes and values.
 *
 * A token is written bare only when it is non-empty, made of ASCII letters, digits, `_`, `.`, and
 * `-`, and contains no `AND`, `OR`, `NOT`, or `TO` word. Anything else is quoted, with `\` and `"`
 * backslash-escaped: the engine rejects `(`, `)`, `:`, `<`, `>`, `=`, and `!` outside quotes, and
 * reads a `\` before the closing quote as an escape, leaving the string unterminated.
 */
internal object FilterQuote {
  private val BARE: Regex = Regex("[A-Za-z0-9_.\\-]+")
  private val KEYWORD: Regex = Regex("(?i)\\b(?:AND|OR|NOT|TO)\\b")

  fun quote(raw: String): String {
    if (!needsQuotes(raw)) return raw
    return "\"${raw.replace("\\", "\\\\").replace("\"", "\\\"")}\""
  }

  fun needsQuotes(raw: String): Boolean = !BARE.matches(raw) || KEYWORD.containsMatchIn(raw)
}
