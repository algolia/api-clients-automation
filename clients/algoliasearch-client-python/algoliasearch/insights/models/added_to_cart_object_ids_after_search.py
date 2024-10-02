# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from re import match
from sys import version_info
from typing import Any, Dict, List, Optional

from pydantic import BaseModel, ConfigDict, Field, field_validator

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.insights.models.add_to_cart_event import AddToCartEvent
from algoliasearch.insights.models.conversion_event import ConversionEvent
from algoliasearch.insights.models.object_data_after_search import ObjectDataAfterSearch
from algoliasearch.insights.models.value import Value


class AddedToCartObjectIDsAfterSearch(BaseModel):
    """
    Use this event to track when users add items to their shopping cart after a previous Algolia request. If you're building your category pages with Algolia, you'll also use this event.
    """

    event_name: str = Field(alias="eventName")
    """ Event name, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.  """
    event_type: ConversionEvent = Field(alias="eventType")
    event_subtype: AddToCartEvent = Field(alias="eventSubtype")
    index: str = Field(alias="index")
    """ Index name (case-sensitive) to which the event's items belong. """
    query_id: str = Field(alias="queryID")
    """ Unique identifier for a search query.  The query ID is required for events related to search or browse requests. If you add `clickAnalytics: true` as a search request parameter, the query ID is included in the API response.  """
    object_ids: List[str] = Field(alias="objectIDs")
    """ Object IDs of the records that are part of the event. """
    user_token: str = Field(alias="userToken")
    """ Anonymous or pseudonymous user identifier.  Don't use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).  """
    authenticated_user_token: Optional[str] = Field(
        default=None, alias="authenticatedUserToken"
    )
    """ Identifier for authenticated users.  When the user signs in, you can get an identifier from your system and send it as `authenticatedUserToken`. This lets you keep using the `userToken` from before the user signed in, while providing a reliable way to identify users across sessions. Don't use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).  """
    currency: Optional[str] = Field(default=None, alias="currency")
    """ Three-letter [currency code](https://www.iso.org/iso-4217-currency-codes.html). """
    object_data: Optional[List[ObjectDataAfterSearch]] = Field(
        default=None, alias="objectData"
    )
    """ Extra information about the records involved in a purchase or add-to-cart events.  If provided, it must be the same length as `objectIDs`.  """
    timestamp: Optional[int] = Field(default=None, alias="timestamp")
    """ Timestamp of the event, measured in milliseconds since the Unix epoch. By default, the Insights API uses the time it receives an event as its timestamp.  """
    value: Optional[Value] = Field(default=None, alias="value")

    @field_validator("event_name")
    def event_name_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not match(r"[\x20-\x7E]{1,64}", value):
            raise ValueError(
                r"must validate the regular expression /[\x20-\x7E]{1,64}/"
            )
        return value

    @field_validator("query_id")
    def query_id_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not match(r"[0-9a-f]{32}", value):
            raise ValueError(r"must validate the regular expression /[0-9a-f]{32}/")
        return value

    @field_validator("user_token")
    def user_token_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not match(r"[a-zA-Z0-9_=\/+-]{1,129}", value):
            raise ValueError(
                r"must validate the regular expression /[a-zA-Z0-9_=\/+-]{1,129}/"
            )
        return value

    @field_validator("authenticated_user_token")
    def authenticated_user_token_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if value is None:
            return value

        if not match(r"[a-zA-Z0-9_=\/+-]{1,129}", value):
            raise ValueError(
                r"must validate the regular expression /[a-zA-Z0-9_=\/+-]{1,129}/"
            )
        return value

    model_config = ConfigDict(
        use_enum_values=True,
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of AddedToCartObjectIDsAfterSearch from a JSON string"""
        return cls.from_dict(loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias."""
        return self.model_dump(
            by_alias=True,
            exclude_none=True,
            exclude_unset=True,
        )

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of AddedToCartObjectIDsAfterSearch from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["eventType"] = obj.get("eventType")
        obj["eventSubtype"] = obj.get("eventSubtype")
        obj["objectData"] = (
            [ObjectDataAfterSearch.from_dict(_item) for _item in obj["objectData"]]
            if obj.get("objectData") is not None
            else None
        )
        obj["value"] = (
            Value.from_dict(obj["value"]) if obj.get("value") is not None else None
        )

        return cls.model_validate(obj)
