# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Annotated, Any, Dict, Optional, Self

from pydantic import BaseModel, Field, StrictBool, StrictStr


class SearchRecommendRulesParams(BaseModel):
    """
    Recommend rules search parameters.
    """

    query: Optional[StrictStr] = Field(default="", description="Search query.")
    context: Optional[StrictStr] = Field(
        default=None,
        description="Restricts responses to the specified [contextual rule](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#creating-contextual-rules).",
    )
    page: Optional[Annotated[int, Field(strict=True, ge=0)]] = Field(
        default=None, description="Requested page of the API response."
    )
    hits_per_page: Optional[Annotated[int, Field(le=1000, strict=True, ge=1)]] = Field(
        default=20, description="Maximum number of hits per page.", alias="hitsPerPage"
    )
    enabled: Optional[StrictBool] = Field(
        default=None,
        description="Restricts responses to enabled rules. When absent (default), _all_ rules are retrieved.",
    )

    model_config = {"populate_by_name": True, "validate_assignment": True}

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of SearchRecommendRulesParams from a JSON string"""
        return cls.from_dict(loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias.

        This has the following differences from calling pydantic's
        `self.model_dump(by_alias=True)`:

        * `None` is only added to the output dict for nullable fields that
          were set at model initialization. Other fields with value `None`
          are ignored.
        """
        _dict = self.model_dump(
            by_alias=True,
            exclude={},
            exclude_none=True,
        )
        # set to None if enabled (nullable) is None
        # and model_fields_set contains the field
        if self.enabled is None and "enabled" in self.model_fields_set:
            _dict["enabled"] = None

        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of SearchRecommendRulesParams from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "query": obj.get("query"),
                "context": obj.get("context"),
                "page": obj.get("page"),
                "hitsPerPage": obj.get("hitsPerPage"),
                "enabled": obj.get("enabled"),
            }
        )
        return _obj
