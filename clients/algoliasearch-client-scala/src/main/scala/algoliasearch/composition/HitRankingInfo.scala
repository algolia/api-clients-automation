/** Composition API Composition API.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.composition

/** HitRankingInfo
  *
  * @param filters
  *   Whether a filter matched the query.
  * @param firstMatchedWord
  *   Position of the first matched word in the best matching attribute of the record.
  * @param geoDistance
  *   Distance between the geo location in the search query and the best matching geo location in the record, divided by
  *   the geo precision (in meters).
  * @param geoPrecision
  *   Precision used when computing the geo distance, in meters.
  * @param nbExactWords
  *   Number of exactly matched words.
  * @param nbTypos
  *   Number of typos encountered when matching the record.
  * @param promoted
  *   Whether the record was promoted by a rule.
  * @param proximityDistance
  *   Number of words between multiple matches in the query plus 1. For single word queries, `proximityDistance` is 0.
  * @param userScore
  *   Overall ranking of the record, expressed as a single integer. This attribute is internal.
  * @param words
  *   Number of matched words.
  * @param promotedByReRanking
  *   Whether the record is re-ranked.
  */
case class HitRankingInfo(
    filters: Option[Int] = scala.None,
    firstMatchedWord: Int,
    geoDistance: Int,
    geoPrecision: Option[Int] = scala.None,
    matchedGeoLocation: Option[MatchedGeoLocation] = scala.None,
    personalization: Option[Personalization] = scala.None,
    nbExactWords: Int,
    nbTypos: Int,
    promoted: Option[Boolean] = scala.None,
    proximityDistance: Option[Int] = scala.None,
    userScore: Int,
    words: Option[Int] = scala.None,
    promotedByReRanking: Option[Boolean] = scala.None,
    composed: Option[Map[String, CompositionIdRankingInfo]] = scala.None
)
