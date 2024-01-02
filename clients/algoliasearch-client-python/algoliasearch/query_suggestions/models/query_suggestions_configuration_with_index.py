# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Annotated, Any, Dict, List, Optional, Self

from pydantic import BaseModel, Field, StrictBool, StrictStr

from algoliasearch.query_suggestions.models.languages import Languages
from algoliasearch.query_suggestions.models.source_index import SourceIndex


class QuerySuggestionsConfigurationWithIndex(BaseModel):
    """
    Query Suggestions configuration.
    """

    index_name: StrictStr = Field(
        description="Query Suggestions index name.", alias="indexName"
    )
    source_indices: Annotated[List[SourceIndex], Field(min_length=1)] = Field(
        description="Algolia indices from which to get the popular searches for query suggestions.",
        alias="sourceIndices",
    )
    languages: Optional[Languages] = None
    exclude: Optional[List[StrictStr]] = Field(
        default=None, description="Patterns to exclude from query suggestions."
    )
    enable_personalization: Optional[StrictBool] = Field(
        default=False,
        description="Turn on personalized query suggestions.",
        alias="enablePersonalization",
    )
    allow_special_characters: Optional[StrictBool] = Field(
        default=False,
        description="Allow suggestions with special characters.",
        alias="allowSpecialCharacters",
    )

    model_config = {"populate_by_name": True, "validate_assignment": True}

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of QuerySuggestionsConfigurationWithIndex from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of
        # each item in source_indices (list)
        _items = []
        if self.source_indices:
            for _item in self.source_indices:
                if _item:
                    _items.append(_item.to_dict())
            _dict["sourceIndices"] = _items
        # override the default output from pydantic by calling `to_dict()` of
        # languages
        if self.languages:
            _dict["languages"] = self.languages.to_dict()
        # set to None if exclude (nullable) is None
        # and model_fields_set contains the field
        if self.exclude is None and "exclude" in self.model_fields_set:
            _dict["exclude"] = None

        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of QuerySuggestionsConfigurationWithIndex from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "indexName": obj.get("indexName"),
                "sourceIndices": [
                    SourceIndex.from_dict(_item) for _item in obj.get("sourceIndices")
                ]
                if obj.get("sourceIndices") is not None
                else None,
                "languages": Languages.from_dict(obj.get("languages"))
                if obj.get("languages") is not None
                else None,
                "exclude": obj.get("exclude"),
                "enablePersonalization": obj.get("enablePersonalization")
                if obj.get("enablePersonalization") is not None
                else False,
                "allowSpecialCharacters": obj.get("allowSpecialCharacters")
                if obj.get("allowSpecialCharacters") is not None
                else False,
            }
        )
        return _obj
