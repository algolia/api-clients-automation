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
from pydantic import BaseModel, Field
from algoliasearch.models.automatic_facet_filters import AutomaticFacetFilters
from algoliasearch.models.consequence_query import ConsequenceQuery
from algoliasearch.models.rendering_content import RenderingContent


class Params(BaseModel):
    """
    Additional search parameters.  # noqa: E501
    """

    query: Optional[ConsequenceQuery] = None
    automatic_facet_filters: Optional[AutomaticFacetFilters] = Field(
        None, alias="automaticFacetFilters"
    )
    automatic_optional_facet_filters: Optional[AutomaticFacetFilters] = Field(
        None, alias="automaticOptionalFacetFilters"
    )
    rendering_content: Optional[RenderingContent] = Field(
        None, alias="renderingContent"
    )
    __properties = [
        "query",
        "automaticFacetFilters",
        "automaticOptionalFacetFilters",
        "renderingContent",
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
    def from_json(cls, json_str: str) -> Params:
        """Create an instance of Params from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True, exclude={}, exclude_none=True)
        # override the default output from pydantic by calling `to_dict()` of query
        if self.query:
            _dict["query"] = self.query.to_dict()
        # override the default output from pydantic by calling `to_dict()` of automatic_facet_filters
        if self.automatic_facet_filters:
            _dict["automaticFacetFilters"] = self.automatic_facet_filters.to_dict()
        # override the default output from pydantic by calling `to_dict()` of automatic_optional_facet_filters
        if self.automatic_optional_facet_filters:
            _dict[
                "automaticOptionalFacetFilters"
            ] = self.automatic_optional_facet_filters.to_dict()
        # override the default output from pydantic by calling `to_dict()` of rendering_content
        if self.rendering_content:
            _dict["renderingContent"] = self.rendering_content.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> Params:
        """Create an instance of Params from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return Params.parse_obj(obj)

        _obj = Params.parse_obj(
            {
                "query": ConsequenceQuery.from_dict(obj.get("query"))
                if obj.get("query") is not None
                else None,
                "automatic_facet_filters": AutomaticFacetFilters.from_dict(
                    obj.get("automaticFacetFilters")
                )
                if obj.get("automaticFacetFilters") is not None
                else None,
                "automatic_optional_facet_filters": AutomaticFacetFilters.from_dict(
                    obj.get("automaticOptionalFacetFilters")
                )
                if obj.get("automaticOptionalFacetFilters") is not None
                else None,
                "rendering_content": RenderingContent.from_dict(
                    obj.get("renderingContent")
                )
                if obj.get("renderingContent") is not None
                else None,
            }
        )
        return _obj
