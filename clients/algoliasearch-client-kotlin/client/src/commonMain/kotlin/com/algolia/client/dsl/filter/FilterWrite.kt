package com.algolia.client.dsl.filter

/**
 * What a generated filter helper wrote: the encoded [value] and the [rows] it was encoded from, so
 * a composer can merge rows instead of an encoded value.
 */
internal class FilterWrite<V : Any, L : Filter>(val value: V?, val rows: List<List<L>>)

/**
 * The rows behind [current]: none when it is `null`, the rows of [write] when [current] is still
 * the value it wrote, and `null` when [current] was assigned directly and cannot be merged.
 */
internal fun <V : Any, L : Filter> rowsBehind(
  current: V?,
  write: FilterWrite<V, L>?,
): List<List<L>>? =
  when {
    current == null -> emptyList()
    write != null && current == write.value -> write.rows
    else -> null
  }
