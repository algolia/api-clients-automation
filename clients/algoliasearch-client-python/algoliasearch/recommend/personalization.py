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


from typing import Optional
from pydantic import BaseModel, Field, StrictInt

class Personalization(BaseModel):
    """
    Personalization
    """
    filters_score: Optional[StrictInt] = Field(None, alias="filtersScore", description="The score of the filters.")
    ranking_score: Optional[StrictInt] = Field(None, alias="rankingScore", description="The score of the ranking.")
    score: Optional[StrictInt] = Field(None, description="The score of the event.")
    __properties = ["filtersScore", "rankingScore", "score"]

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
    def from_json(cls, json_str: str) -> Personalization:
        """Create an instance of Personalization from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True,
                          exclude={
                          },
                          exclude_none=True)
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> Personalization:
        """Create an instance of Personalization from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return Personalization.parse_obj(obj)

        _obj = Personalization.parse_obj({
            "filters_score": obj.get("filtersScore"),
            "ranking_score": obj.get("rankingScore"),
            "score": obj.get("score")
        })
        return _obj


