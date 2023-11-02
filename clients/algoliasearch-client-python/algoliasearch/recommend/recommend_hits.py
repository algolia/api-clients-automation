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


from typing import List, Optional
from pydantic import BaseModel, Field, StrictStr, conlist
from algoliasearch.models.recommend_hit import RecommendHit

class RecommendHits(BaseModel):
    """
    RecommendHits
    """
    hits: conlist(RecommendHit) = Field(...)
    query: Optional[StrictStr] = Field('', description="Text to search for in an index.")
    params: Optional[StrictStr] = Field(None, description="URL-encoded string of all search parameters.")
    __properties = ["hits", "query", "params"]

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
    def from_json(cls, json_str: str) -> RecommendHits:
        """Create an instance of RecommendHits from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True,
                          exclude={
                          },
                          exclude_none=True)
        # override the default output from pydantic by calling `to_dict()` of each item in hits (list)
        _items = []
        if self.hits:
            for _item in self.hits:
                if _item:
                    _items.append(_item.to_dict())
            _dict['hits'] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> RecommendHits:
        """Create an instance of RecommendHits from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return RecommendHits.parse_obj(obj)

        _obj = RecommendHits.parse_obj({
            "hits": [RecommendHit.from_dict(_item) for _item in obj.get("hits")] if obj.get("hits") is not None else None,
            "query": obj.get("query") if obj.get("query") is not None else '',
            "params": obj.get("params")
        })
        return _obj


