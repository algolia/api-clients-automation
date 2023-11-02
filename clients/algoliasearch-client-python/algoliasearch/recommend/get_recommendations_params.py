# coding: utf-8

"""
    Recommend API

    The Recommend API lets you generate recommendations with several AI models.  > **Note**: You should use Algolia's [libraries and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) to interact with the Recommend API. Using the HTTP endpoints directly is not covered by the [SLA](https://www.algolia.com/policies/sla/).

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json


from typing import List
from pydantic import BaseModel, Field, conlist
from algoliasearch.models.recommendations_request import RecommendationsRequest

class GetRecommendationsParams(BaseModel):
    """
    Recommend parameters.  # noqa: E501
    """
    requests: conlist(RecommendationsRequest) = Field(..., description="Request parameters depend on the model (recommendations or trending).")
    __properties = ["requests"]

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
    def from_json(cls, json_str: str) -> GetRecommendationsParams:
        """Create an instance of GetRecommendationsParams from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True,
                          exclude={
                          },
                          exclude_none=True)
        # override the default output from pydantic by calling `to_dict()` of each item in requests (list)
        _items = []
        if self.requests:
            for _item in self.requests:
                if _item:
                    _items.append(_item.to_dict())
            _dict['requests'] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> GetRecommendationsParams:
        """Create an instance of GetRecommendationsParams from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return GetRecommendationsParams.parse_obj(obj)

        _obj = GetRecommendationsParams.parse_obj({
            "requests": [RecommendationsRequest.from_dict(_item) for _item in obj.get("requests")] if obj.get("requests") is not None else None
        })
        return _obj


