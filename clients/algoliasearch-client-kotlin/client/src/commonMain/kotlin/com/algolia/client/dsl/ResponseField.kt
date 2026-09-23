package com.algolia.client.dsl

/**
 * A value of the `responseFields` search parameter. The spec types it as `String`; these constants
 * cover every documented value plus `processingTimingsMS`. Use [Other] for anything else.
 *
 * [Documentation](https://www.algolia.com/doc/api-reference/api-parameters/responseFields/)
 */
@AlgoliaExperimentalDsl
public sealed class ResponseField(public val raw: String) {
  public data object All : ResponseField("*")

  public data object AroundLatLng : ResponseField("aroundLatLng")

  public data object AutomaticRadius : ResponseField("automaticRadius")

  public data object Exhaustive : ResponseField("exhaustive")

  public data object Facets : ResponseField("facets")

  public data object FacetsStats : ResponseField("facets_stats")

  public data object Hits : ResponseField("hits")

  public data object HitsPerPage : ResponseField("hitsPerPage")

  public data object Index : ResponseField("index")

  public data object Length : ResponseField("length")

  public data object NbHits : ResponseField("nbHits")

  public data object NbPages : ResponseField("nbPages")

  public data object Offset : ResponseField("offset")

  public data object Page : ResponseField("page")

  public data object Params : ResponseField("params")

  public data object ProcessingTimeMS : ResponseField("processingTimeMS")

  /** Undocumented; accepted by the engine (verified 2026-09-23). */
  public data object ProcessingTimingsMS : ResponseField("processingTimingsMS")

  public data object Query : ResponseField("query")

  public data object QueryAfterRemoval : ResponseField("queryAfterRemoval")

  public data object ServerTimeMS : ResponseField("serverTimeMS")

  public data object UserData : ResponseField("userData")

  /** Any other response property, sent as [name]. */
  public data class Other(public val name: String) : ResponseField(name)
}

/** Builds a `responseFields` list. `+ResponseField.Hits`, `+listOf(...)`. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class ResponseFieldsDsl {
  private val values: MutableList<String> = mutableListOf()

  internal fun build(): List<String> = values.toList()

  /** Adds [this] response field. */
  public operator fun ResponseField.unaryPlus() {
    values += raw
  }

  /** Adds every response field in [this]. */
  public operator fun Iterable<ResponseField>.unaryPlus() {
    forEach { values += it.raw }
  }
}
