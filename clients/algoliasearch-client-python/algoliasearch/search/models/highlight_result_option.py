# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Any, ClassVar, Dict, List, Optional, Self

from pydantic import BaseModel, Field, StrictBool, StrictStr

from algoliasearch.search.models.match_level import MatchLevel


class HighlightResultOption(BaseModel):
    """
    Show highlighted section and words matched on a query.
    """

    value: StrictStr = Field(
        description="Markup text with `facetQuery` matches highlighted."
    )
    match_level: MatchLevel = Field(alias="matchLevel")
    matched_words: List[StrictStr] = Field(
        description="List of words from the query that matched the object.",
        alias="matchedWords",
    )
    fully_highlighted: Optional[StrictBool] = Field(
        default=None,
        description="Whether the entire attribute value is highlighted.",
        alias="fullyHighlighted",
    )
    __properties: ClassVar[List[str]] = [
        "value",
        "matchLevel",
        "matchedWords",
        "fullyHighlighted",
    ]

    model_config = {"populate_by_name": True, "validate_assignment": True}

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of HighlightResultOption from a JSON string"""
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
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of HighlightResultOption from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "value": obj.get("value"),
                "matchLevel": obj.get("matchLevel"),
                "matchedWords": obj.get("matchedWords"),
                "fullyHighlighted": obj.get("fullyHighlighted"),
            }
        )
        return _obj
