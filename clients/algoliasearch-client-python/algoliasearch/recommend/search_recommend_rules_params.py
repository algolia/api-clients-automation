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


from typing import Any, Dict, List, Optional
from pydantic import BaseModel, Field, StrictBool, StrictStr, conint, conlist


class SearchRecommendRulesParams(BaseModel):
    """
    Recommend rules search parameters.  # noqa: E501
    """

    query: Optional[StrictStr] = Field("", description="Full-text query.")
    context: Optional[StrictStr] = Field(
        None,
        description="Restricts responses to the specified [contextual rule](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#creating-contextual-rules).",
    )
    page: Optional[conint(strict=True, ge=0)] = Field(
        None, description="Requested page (the first page is page 0)."
    )
    hits_per_page: Optional[conint(strict=True, le=1000, ge=1)] = Field(
        20, alias="hitsPerPage", description="Maximum number of hits per page."
    )
    enabled: Optional[StrictBool] = Field(
        None,
        description="Restricts responses to enabled rules. When absent (default), _all_ rules are retrieved.",
    )
    request_options: Optional[conlist(Dict[str, Any])] = Field(
        None,
        alias="requestOptions",
        description="Request options to send with the API call.",
    )
    __properties = [
        "query",
        "context",
        "page",
        "hitsPerPage",
        "enabled",
        "requestOptions",
    ]

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
    def from_json(cls, json_str: str) -> SearchRecommendRulesParams:
        """Create an instance of SearchRecommendRulesParams from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True, exclude={}, exclude_none=True)
        # set to None if enabled (nullable) is None
        # and __fields_set__ contains the field
        if self.enabled is None and "enabled" in self.__fields_set__:
            _dict["enabled"] = None

        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> SearchRecommendRulesParams:
        """Create an instance of SearchRecommendRulesParams from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return SearchRecommendRulesParams.parse_obj(obj)

        _obj = SearchRecommendRulesParams.parse_obj(
            {
                "query": obj.get("query") if obj.get("query") is not None else "",
                "context": obj.get("context"),
                "page": obj.get("page"),
                "hits_per_page": obj.get("hitsPerPage")
                if obj.get("hitsPerPage") is not None
                else 20,
                "enabled": obj.get("enabled"),
                "request_options": obj.get("requestOptions"),
            }
        )
        return _obj
