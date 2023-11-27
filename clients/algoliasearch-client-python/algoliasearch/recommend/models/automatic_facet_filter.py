# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

import json
import pprint
from typing import Any, ClassVar, Dict, List, Optional

from pydantic import BaseModel, Field, StrictBool, StrictInt, StrictStr

try:
    from typing import Self
except ImportError:
    from typing_extensions import Self


class AutomaticFacetFilter(BaseModel):
    """
    Automatic facet Filter.
    """

    facet: StrictStr = Field(
        description="Attribute to filter on. This must match a facet placeholder in the Rule's pattern."
    )
    score: Optional[StrictInt] = Field(
        default=1,
        description="Score for the filter. Typically used for optional or disjunctive filters.",
    )
    disjunctive: Optional[StrictBool] = Field(
        default=False,
        description="Whether the filter is disjunctive (true) or conjunctive (false).",
    )
    __properties: ClassVar[List[str]] = ["facet", "score", "disjunctive"]

    model_config = {"populate_by_name": True, "validate_assignment": True}

    def to_str(self) -> str:
        """Returns the string representation of the model using alias"""
        return pprint.pformat(self.model_dump(by_alias=True))

    def to_json(self) -> str:
        """Returns the JSON representation of the model using alias"""
        # TODO: pydantic v2: use .model_dump_json(by_alias=True,
        # exclude_unset=True) instead
        return json.dumps(self.to_dict())

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of AutomaticFacetFilter from a JSON string"""
        return cls.from_dict(json.loads(json_str))

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
        """Create an instance of AutomaticFacetFilter from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "facet": obj.get("facet"),
                "score": obj.get("score") if obj.get("score") is not None else 1,
                "disjunctive": obj.get("disjunctive")
                if obj.get("disjunctive") is not None
                else False,
            }
        )
        return _obj
