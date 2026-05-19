package algoliasearch.config

import algoliasearch.exception.AlgoliaClientException

/** Configuration for the ingestion transporter used by the `*WithTransformation` helpers on
  * [[algoliasearch.api.SearchClient]].
  *
  * When passed to [[algoliasearch.api.SearchClient.withTransformation]], an [[algoliasearch.api.IngestionClient]] is
  * eagerly built using Ingestion API defaults (25s timeouts, region-derived hosts, no compression). Pass a
  * [[ClientOptions]] to override specific defaults; only the fields explicitly set there replace the Ingestion API
  * defaults.
  *
  * @param region
  *   Algolia region for the Ingestion API (e.g. `"us"` or `"eu"`). Required.
  * @param clientOptions
  *   optional [[ClientOptions]] forwarded to the ingestion transporter.
  */
case class TransformationOptions(
    region: String,
    clientOptions: Option[ClientOptions] = None
) {
  if (region == null || region.trim.isEmpty) {
    throw new AlgoliaClientException(
      "`region` is required in `transformationOptions`." +
        " See https://www.algolia.com/doc/libraries/sdk/methods/ingestion"
    )
  }
}
