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


from pydantic import BaseModel, Field, StrictStr
from algoliasearch.models.match_level import MatchLevel


class SnippetResultOption(BaseModel):
    """
    Snippeted attributes show parts of the matched attributes. Only returned when attributesToSnippet is non-empty.  # noqa: E501
    """

    value: StrictStr = Field(
        ..., description="Markup text with `facetQuery` matches highlighted."
    )
    match_level: MatchLevel = Field(..., alias="matchLevel")
    __properties = ["value", "matchLevel"]

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
    def from_json(cls, json_str: str) -> SnippetResultOption:
        """Create an instance of SnippetResultOption from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True, exclude={}, exclude_none=True)
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> SnippetResultOption:
        """Create an instance of SnippetResultOption from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return SnippetResultOption.parse_obj(obj)

        _obj = SnippetResultOption.parse_obj(
            {"value": obj.get("value"), "match_level": obj.get("matchLevel")}
        )
        return _obj
