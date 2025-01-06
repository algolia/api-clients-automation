/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.personalization

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * PersonalizationStrategyParams
 *
 * @param eventsScoring Scores associated with each event.  The higher the scores, the higher the impact of those events on the personalization of search results.
 * @param facetsScoring Scores associated with each facet.  The higher the scores, the higher the impact of those events on the personalization of search results.
 * @param personalizationImpact Impact of personalization on the search results.  If set to 0, personalization has no impact on the search results.
 */
@Serializable
public data class PersonalizationStrategyParams(

  /** Scores associated with each event.  The higher the scores, the higher the impact of those events on the personalization of search results.  */
  @SerialName(value = "eventsScoring") val eventsScoring: List<EventsScoring>,

  /** Scores associated with each facet.  The higher the scores, the higher the impact of those events on the personalization of search results.  */
  @SerialName(value = "facetsScoring") val facetsScoring: List<FacetsScoring>,

  /** Impact of personalization on the search results.  If set to 0, personalization has no impact on the search results.  */
  @SerialName(value = "personalizationImpact") val personalizationImpact: Int,
)
