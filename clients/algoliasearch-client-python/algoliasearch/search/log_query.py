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


from typing import Optional
from pydantic import BaseModel, Field, StrictStr


class LogQuery(BaseModel):
    """
    LogQuery
    """

    index_name: Optional[StrictStr] = Field(
        None, description="Index targeted by the query."
    )
    user_token: Optional[StrictStr] = Field(None, description="User identifier.")
    query_id: Optional[StrictStr] = Field(None, description="Unique query identifier.")
    __properties = ["index_name", "user_token", "query_id"]

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
    def from_json(cls, json_str: str) -> LogQuery:
        """Create an instance of LogQuery from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True, exclude={}, exclude_none=True)
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> LogQuery:
        """Create an instance of LogQuery from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return LogQuery.parse_obj(obj)

        _obj = LogQuery.parse_obj(
            {
                "index_name": obj.get("index_name"),
                "user_token": obj.get("user_token"),
                "query_id": obj.get("query_id"),
            }
        )
        return _obj
