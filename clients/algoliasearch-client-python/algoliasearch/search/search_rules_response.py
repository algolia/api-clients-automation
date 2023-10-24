# coding: utf-8

"""
    Search API

    Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json


from typing import List
from pydantic import BaseModel, Field, StrictInt, conlist
from algoliasearch.models.rule import Rule

class SearchRulesResponse(BaseModel):
    """
    SearchRulesResponse
    """
    hits: conlist(Rule) = Field(..., description="Fetched rules.")
    nb_hits: StrictInt = Field(..., alias="nbHits", description="Number of fetched rules.")
    page: StrictInt = Field(..., description="Current page.")
    nb_pages: StrictInt = Field(..., alias="nbPages", description="Number of pages.")
    __properties = ["hits", "nbHits", "page", "nbPages"]

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
    def from_json(cls, json_str: str) -> SearchRulesResponse:
        """Create an instance of SearchRulesResponse from a JSON string"""
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
    def from_dict(cls, obj: dict) -> SearchRulesResponse:
        """Create an instance of SearchRulesResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return SearchRulesResponse.parse_obj(obj)

        _obj = SearchRulesResponse.parse_obj({
            "hits": [Rule.from_dict(_item) for _item in obj.get("hits")] if obj.get("hits") is not None else None,
            "nb_hits": obj.get("nbHits"),
            "page": obj.get("page"),
            "nb_pages": obj.get("nbPages")
        })
        return _obj


