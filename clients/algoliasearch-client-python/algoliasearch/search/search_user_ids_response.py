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
from pydantic import BaseModel, Field, StrictInt, StrictStr, conint, conlist
from algoliasearch.models.user_hit import UserHit


class SearchUserIdsResponse(BaseModel):
    """
    userIDs data.  # noqa: E501
    """

    hits: conlist(UserHit) = Field(
        ..., description="User objects that match the query."
    )
    nb_hits: StrictInt = Field(
        ..., alias="nbHits", description="Number of hits the search query matched."
    )
    page: StrictInt = Field(
        ..., description="Page to retrieve (the first page is `0`, not `1`)."
    )
    hits_per_page: conint(strict=True, le=1000, ge=1) = Field(
        ..., alias="hitsPerPage", description="Maximum number of hits per page."
    )
    updated_at: StrictStr = Field(
        ...,
        alias="updatedAt",
        description="Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.",
    )
    __properties = ["hits", "nbHits", "page", "hitsPerPage", "updatedAt"]

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
    def from_json(cls, json_str: str) -> SearchUserIdsResponse:
        """Create an instance of SearchUserIdsResponse from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True, exclude={}, exclude_none=True)
        # override the default output from pydantic by calling `to_dict()` of each item in hits (list)
        _items = []
        if self.hits:
            for _item in self.hits:
                if _item:
                    _items.append(_item.to_dict())
            _dict["hits"] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> SearchUserIdsResponse:
        """Create an instance of SearchUserIdsResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return SearchUserIdsResponse.parse_obj(obj)

        _obj = SearchUserIdsResponse.parse_obj(
            {
                "hits": [UserHit.from_dict(_item) for _item in obj.get("hits")]
                if obj.get("hits") is not None
                else None,
                "nb_hits": obj.get("nbHits"),
                "page": obj.get("page") if obj.get("page") is not None else 0,
                "hits_per_page": obj.get("hitsPerPage")
                if obj.get("hitsPerPage") is not None
                else 20,
                "updated_at": obj.get("updatedAt"),
            }
        )
        return _obj
