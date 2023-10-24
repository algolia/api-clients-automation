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


from typing import Dict, List, Optional
from pydantic import BaseModel, Field, StrictBool, StrictStr, conlist

class HasPendingMappingsResponse(BaseModel):
    """
    HasPendingMappingsResponse
    """
    pending: StrictBool = Field(..., description="Indicates whether there are clusters undergoing migration, creation, or deletion.")
    clusters: Optional[Dict[str, conlist(StrictStr)]] = Field(None, description="Cluster pending mapping state: migrating, creating, deleting. ")
    __properties = ["pending", "clusters"]

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
    def from_json(cls, json_str: str) -> HasPendingMappingsResponse:
        """Create an instance of HasPendingMappingsResponse from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True,
                          exclude={
                          },
                          exclude_none=True)
        # override the default output from pydantic by calling `to_dict()` of each value in clusters (dict of array)
        _field_dict_of_array = {}
        if self.clusters:
            for _key in self.clusters:
                if self.clusters[_key]:
                    _field_dict_of_array[_key] = [
                        _item.to_dict() for _item in self.clusters[_key]
                    ]
            _dict['clusters'] = _field_dict_of_array
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> HasPendingMappingsResponse:
        """Create an instance of HasPendingMappingsResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return HasPendingMappingsResponse.parse_obj(obj)

        _obj = HasPendingMappingsResponse.parse_obj({
            "pending": obj.get("pending"),
            "clusters": obj.get("clusters")
        })
        return _obj


