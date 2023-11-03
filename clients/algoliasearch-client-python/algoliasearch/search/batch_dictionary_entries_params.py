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


from typing import List, Optional
from pydantic import BaseModel, Field, StrictBool, conlist
from algoliasearch.models.batch_dictionary_entries_request import (
    BatchDictionaryEntriesRequest,
)


class BatchDictionaryEntriesParams(BaseModel):
    """
    `batchDictionaryEntries` parameters.   # noqa: E501
    """

    clear_existing_dictionary_entries: Optional[StrictBool] = Field(
        False,
        alias="clearExistingDictionaryEntries",
        description="Incidates whether to replace all custom entries in the dictionary with the ones sent with this request.",
    )
    requests: conlist(BatchDictionaryEntriesRequest) = Field(
        ..., description="Operations to batch."
    )
    __properties = ["clearExistingDictionaryEntries", "requests"]

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
    def from_json(cls, json_str: str) -> BatchDictionaryEntriesParams:
        """Create an instance of BatchDictionaryEntriesParams from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True, exclude={}, exclude_none=True)
        # override the default output from pydantic by calling `to_dict()` of each item in requests (list)
        _items = []
        if self.requests:
            for _item in self.requests:
                if _item:
                    _items.append(_item.to_dict())
            _dict["requests"] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> BatchDictionaryEntriesParams:
        """Create an instance of BatchDictionaryEntriesParams from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return BatchDictionaryEntriesParams.parse_obj(obj)

        _obj = BatchDictionaryEntriesParams.parse_obj(
            {
                "clear_existing_dictionary_entries": obj.get(
                    "clearExistingDictionaryEntries"
                )
                if obj.get("clearExistingDictionaryEntries") is not None
                else False,
                "requests": [
                    BatchDictionaryEntriesRequest.from_dict(_item)
                    for _item in obj.get("requests")
                ]
                if obj.get("requests") is not None
                else None,
            }
        )
        return _obj
