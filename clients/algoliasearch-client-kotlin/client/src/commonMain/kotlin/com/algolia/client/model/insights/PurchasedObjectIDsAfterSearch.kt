/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.insights

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Use this event to track when users make a purchase after a previous Algolia request. If you're building your category pages with Algolia, you'll also use this event.
 *
 * @param eventName The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.
 * @param eventType
 * @param eventSubtype
 * @param index The name of an Algolia index.
 * @param objectIDs The object IDs of the records that are part of the event.
 * @param userToken An anonymous or pseudonymous user identifier.  > **Note**: Never include personally identifiable information in user tokens.
 * @param authenticatedUserToken An identifier for authenticated users.  > **Note**: Never include personally identifiable information in user tokens.
 * @param currency Three-letter [currency code](https://www.iso.org/iso-4217-currency-codes.html).
 * @param objectData Extra information about the records involved in a purchase or add-to-cart events.  If provided, it must be the same length as `objectIDs`.
 * @param timestamp The timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp.
 * @param `value`
 */
@Serializable
public data class PurchasedObjectIDsAfterSearch(

  /** The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.  */
  @SerialName(value = "eventName") val eventName: String,

  @SerialName(value = "eventType") val eventType: ConversionEvent,

  @SerialName(value = "eventSubtype") val eventSubtype: PurchaseEvent,

  /** The name of an Algolia index. */
  @SerialName(value = "index") val index: String,

  /** The object IDs of the records that are part of the event. */
  @SerialName(value = "objectIDs") val objectIDs: List<String>,

  /** An anonymous or pseudonymous user identifier.  > **Note**: Never include personally identifiable information in user tokens.  */
  @SerialName(value = "userToken") val userToken: String,

  /** An identifier for authenticated users.  > **Note**: Never include personally identifiable information in user tokens.  */
  @SerialName(value = "authenticatedUserToken") val authenticatedUserToken: String? = null,

  /** Three-letter [currency code](https://www.iso.org/iso-4217-currency-codes.html). */
  @SerialName(value = "currency") val currency: String? = null,

  /** Extra information about the records involved in a purchase or add-to-cart events.  If provided, it must be the same length as `objectIDs`.  */
  @SerialName(value = "objectData") val objectData: List<ObjectDataAfterSearch>? = null,

  /** The timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp.  */
  @SerialName(value = "timestamp") val timestamp: Long? = null,

  @SerialName(value = "value") val `value`: Value? = null,
) : EventsItems
