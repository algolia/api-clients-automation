/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.insights

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Use this event to track when users make a purchase after a previous Algolia request. If you're building your category pages with Algolia, you'll also use this event.
 *
 * @param eventName Event name, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.
 * @param eventType
 * @param eventSubtype
 * @param index Index name to which the event's items belong.
 * @param objectIDs Object IDs of the records that are part of the event.
 * @param userToken Anonymous or pseudonymous user identifier.  Don't use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
 * @param authenticatedUserToken Identifier for authenticated users.  When the user signs in, you can get an identifier from your system and send it as `authenticatedUserToken`. This lets you keep using the `userToken` from before the user signed in, while providing a reliable way to identify users across sessions. Don't use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
 * @param currency Three-letter [currency code](https://www.iso.org/iso-4217-currency-codes.html).
 * @param objectData Extra information about the records involved in a purchase or add-to-cart events.  If provided, it must be the same length as `objectIDs`.
 * @param timestamp Timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp.
 * @param `value`
 */
@Serializable
public data class PurchasedObjectIDsAfterSearch(

  /** Event name, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.  */
  @SerialName(value = "eventName") val eventName: String,

  @SerialName(value = "eventType") val eventType: ConversionEvent,

  @SerialName(value = "eventSubtype") val eventSubtype: PurchaseEvent,

  /** Index name to which the event's items belong. */
  @SerialName(value = "index") val index: String,

  /** Object IDs of the records that are part of the event. */
  @SerialName(value = "objectIDs") val objectIDs: List<String>,

  /** Anonymous or pseudonymous user identifier.  Don't use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).  */
  @SerialName(value = "userToken") val userToken: String,

  /** Identifier for authenticated users.  When the user signs in, you can get an identifier from your system and send it as `authenticatedUserToken`. This lets you keep using the `userToken` from before the user signed in, while providing a reliable way to identify users across sessions. Don't use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).  */
  @SerialName(value = "authenticatedUserToken") val authenticatedUserToken: String? = null,

  /** Three-letter [currency code](https://www.iso.org/iso-4217-currency-codes.html). */
  @SerialName(value = "currency") val currency: String? = null,

  /** Extra information about the records involved in a purchase or add-to-cart events.  If provided, it must be the same length as `objectIDs`.  */
  @SerialName(value = "objectData") val objectData: List<ObjectDataAfterSearch>? = null,

  /** Timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp.  */
  @SerialName(value = "timestamp") val timestamp: Long? = null,

  @SerialName(value = "value") val `value`: Value? = null,
) : EventsItems
