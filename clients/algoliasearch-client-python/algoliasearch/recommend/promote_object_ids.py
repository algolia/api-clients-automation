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


from typing import List
from pydantic import BaseModel, Field, StrictInt, StrictStr, conlist

class PromoteObjectIDs(BaseModel):
    """
    Records to promote.  # noqa: E501
    """
    object_ids: conlist(StrictStr) = Field(..., alias="objectIDs", description="Unique identifiers of the records to promote.")
    position: StrictInt = Field(..., description="The position to promote the records to. If you pass objectIDs, the records are placed at this position as a group. For example, if you pronmote four objectIDs to position 0, the records take the first four positions.")
    __properties = ["objectIDs", "position"]

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
    def from_json(cls, json_str: str) -> PromoteObjectIDs:
        """Create an instance of PromoteObjectIDs from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True,
                          exclude={
                          },
                          exclude_none=True)
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> PromoteObjectIDs:
        """Create an instance of PromoteObjectIDs from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return PromoteObjectIDs.parse_obj(obj)

        _obj = PromoteObjectIDs.parse_obj({
            "object_ids": obj.get("objectIDs"),
            "position": obj.get("position")
        })
        return _obj


