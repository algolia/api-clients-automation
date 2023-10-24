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
from algoliasearch.models.view_event import ViewEvent

class ViewedFilters(BaseModel):
    """
    Use this method to capture active filters. For example, when browsing a category page, users see content filtered on that specific category.   # noqa: E501
    """
    event_name: constr(strict=True, max_length=64, min_length=1) = Field(..., alias="eventName", description="Can contain up to 64 ASCII characters.   Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework. ")
    event_type: ViewEvent = Field(..., alias="eventType")
    index: StrictStr = Field(..., description="Name of the Algolia index.")
    filters: conlist(StrictStr, max_items=20, min_items=1) = Field(..., description="Facet filters.  Each facet filter string must be URL-encoded, such as, `discount:10%25`. ")
    user_token: constr(strict=True, max_length=129, min_length=1) = Field(..., alias="userToken", description="Anonymous or pseudonymous user identifier.   > **Note**: Never include personally identifiable information in user tokens. ")
    timestamp: Optional[StrictInt] = Field(None, description="Time of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp. ")
    authenticated_user_token: Optional[StrictStr] = Field(None, alias="authenticatedUserToken", description="User token for authenticated users.")
    __properties = ["eventName", "eventType", "index", "filters", "userToken", "timestamp", "authenticatedUserToken"]

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
    def from_json(cls, json_str: str) -> ViewedFilters:
        """Create an instance of ViewedFilters from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True,
                          exclude={
                          },
                          exclude_none=True)
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> ViewedFilters:
        """Create an instance of ViewedFilters from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return ViewedFilters.parse_obj(obj)

        _obj = ViewedFilters.parse_obj({
            "event_name": obj.get("eventName"),
            "event_type": obj.get("eventType"),
            "index": obj.get("index"),
            "filters": obj.get("filters"),
            "user_token": obj.get("userToken"),
            "timestamp": obj.get("timestamp"),
            "authenticated_user_token": obj.get("authenticatedUserToken")
        })
        return _obj


