# coding: utf-8

"""
    Insights API

    The Algolia Insights API lets you collect events related to your search and discovery experience. Events represent actions that users take on your app or website. They unlock powerful features, such as recommendations, personalization, smarter search results, and analytics that help you optimize your user experience.

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json


from typing import List, Optional
from pydantic import BaseModel, Field, StrictInt, StrictStr, conlist, constr, validator
from algoliasearch.models.add_to_cart_event import AddToCartEvent
from algoliasearch.models.conversion_event import ConversionEvent
from algoliasearch.models.object_data import ObjectData


class AddedToCartObjectIDs(BaseModel):
    """
    Use this event to track when users add items to their shopping cart unrelated to a previous Algolia request. For example, if you don't use Algolia to build your category pages, use this event.  To track add-to-cart events related to Algolia requests, use the \"Added to cart object IDs after search\" event.   # noqa: E501
    """

    event_name: constr(strict=True, max_length=64, min_length=1) = Field(
        ...,
        alias="eventName",
        description="Can contain up to 64 ASCII characters.   Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework. ",
    )
    event_type: ConversionEvent = Field(..., alias="eventType")
    event_subtype: AddToCartEvent = Field(..., alias="eventSubtype")
    index: StrictStr = Field(..., description="Name of the Algolia index.")
    object_ids: conlist(StrictStr, max_items=20, min_items=1) = Field(
        ...,
        alias="objectIDs",
        description="List of object identifiers for items of an Algolia index.",
    )
    object_data: Optional[conlist(ObjectData)] = Field(
        None,
        alias="objectData",
        description="Extra information about the records involved in the event—for example, to add price and quantities of purchased products.  If provided, must be the same length as `objectIDs`. ",
    )
    currency: Optional[StrictStr] = Field(
        None,
        description="If you include pricing information in the `objectData` parameter, you must also specify the currency as ISO-4217 currency code, such as USD or EUR.",
    )
    user_token: constr(strict=True, max_length=129, min_length=1) = Field(
        ...,
        alias="userToken",
        description="Anonymous or pseudonymous user identifier.   > **Note**: Never include personally identifiable information in user tokens. ",
    )
    timestamp: Optional[StrictInt] = Field(
        None,
        description="Time of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp. ",
    )
    authenticated_user_token: Optional[StrictStr] = Field(
        None,
        alias="authenticatedUserToken",
        description="User token for authenticated users.",
    )
    __properties = [
        "eventName",
        "eventType",
        "eventSubtype",
        "index",
        "objectIDs",
        "objectData",
        "currency",
        "userToken",
        "timestamp",
        "authenticatedUserToken",
    ]

    @validator("event_name")
    def event_name_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not re.match(r"[\x20-\x7E]{1,64}", value):
            raise ValueError(
                r"must validate the regular expression /[\x20-\x7E]{1,64}/"
            )
        return value

    @validator("user_token")
    def user_token_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not re.match(r"[a-zA-Z0-9_=\/+-]{1,129}", value):
            raise ValueError(
                r"must validate the regular expression /[a-zA-Z0-9_=\/+-]{1,129}/"
            )
        return value

    class Config:
        """Pydantic configuration"""

        allow_population_by_field_name = True
        validate_assignment = True

    def to_str(self) -> str:
        """Returns the string representation of the model using alias"""
        return pprint.pformat(self.dict(by_alias=True))

    def to_json(self) -> str:
        """Returns the JSON representation of the model using alias"""
        return json.dumps(self.to_dict())

    @classmethod
    def from_json(cls, json_str: str) -> AddedToCartObjectIDs:
        """Create an instance of AddedToCartObjectIDs from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True, exclude={}, exclude_none=True)
        # override the default output from pydantic by calling `to_dict()` of each item in object_data (list)
        _items = []
        if self.object_data:
            for _item in self.object_data:
                if _item:
                    _items.append(_item.to_dict())
            _dict["objectData"] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> AddedToCartObjectIDs:
        """Create an instance of AddedToCartObjectIDs from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return AddedToCartObjectIDs.parse_obj(obj)

        _obj = AddedToCartObjectIDs.parse_obj(
            {
                "event_name": obj.get("eventName"),
                "event_type": obj.get("eventType"),
                "event_subtype": obj.get("eventSubtype"),
                "index": obj.get("index"),
                "object_ids": obj.get("objectIDs"),
                "object_data": [
                    ObjectData.from_dict(_item) for _item in obj.get("objectData")
                ]
                if obj.get("objectData") is not None
                else None,
                "currency": obj.get("currency"),
                "user_token": obj.get("userToken"),
                "timestamp": obj.get("timestamp"),
                "authenticated_user_token": obj.get("authenticatedUserToken"),
            }
        )
        return _obj
