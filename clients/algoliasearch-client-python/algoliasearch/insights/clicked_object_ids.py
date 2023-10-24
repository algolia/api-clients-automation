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
from algoliasearch.models.click_event import ClickEvent

class ClickedObjectIDs(BaseModel):
    """
    Use this event to track when users click items unrelated to a previous Algolia request. For example, if you don't use Algolia to build your category pages, use this event.  To track click events related to Algolia requests, use the \"Clicked object IDs after search\" event.   # noqa: E501
    """
    event_name: constr(strict=True, max_length=64, min_length=1) = Field(..., alias="eventName", description="Can contain up to 64 ASCII characters.   Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework. ")
    event_type: ClickEvent = Field(..., alias="eventType")
    index: StrictStr = Field(..., description="Name of the Algolia index.")
    object_ids: conlist(StrictStr, max_items=20, min_items=1) = Field(..., alias="objectIDs", description="List of object identifiers for items of an Algolia index.")
    user_token: constr(strict=True, max_length=129, min_length=1) = Field(..., alias="userToken", description="Anonymous or pseudonymous user identifier.   > **Note**: Never include personally identifiable information in user tokens. ")
    timestamp: Optional[StrictInt] = Field(None, description="Time of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp. ")
    __properties = ["eventName", "eventType", "index", "objectIDs", "userToken", "timestamp"]

    @validator('event_name')
    def event_name_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not re.match(r"[\x20-\x7E]{1,64}", value):
            raise ValueError(r"must validate the regular expression /[\x20-\x7E]{1,64}/")
        return value

    @validator('user_token')
    def user_token_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not re.match(r"[a-zA-Z0-9_=\/+-]{1,129}", value):
            raise ValueError(r"must validate the regular expression /[a-zA-Z0-9_=\/+-]{1,129}/")
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
    def from_json(cls, json_str: str) -> ClickedObjectIDs:
        """Create an instance of ClickedObjectIDs from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True,
                          exclude={
                          },
                          exclude_none=True)
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> ClickedObjectIDs:
        """Create an instance of ClickedObjectIDs from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return ClickedObjectIDs.parse_obj(obj)

        _obj = ClickedObjectIDs.parse_obj({
            "event_name": obj.get("eventName"),
            "event_type": obj.get("eventType"),
            "index": obj.get("index"),
            "object_ids": obj.get("objectIDs"),
            "user_token": obj.get("userToken"),
            "timestamp": obj.get("timestamp")
        })
        return _obj


