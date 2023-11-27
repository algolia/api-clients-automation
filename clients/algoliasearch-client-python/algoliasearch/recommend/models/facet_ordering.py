# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

import json
import pprint
from typing import Any, ClassVar, Dict, List, Optional

from pydantic import BaseModel, Field

from algoliasearch.recommend.models.facets import Facets
from algoliasearch.recommend.models.value import Value

try:
    from typing import Self
except ImportError:
    from typing_extensions import Self


class FacetOrdering(BaseModel):
    """
    Defines the ordering of facets (widgets).
    """

    facets: Optional[Facets] = None
    values: Optional[Dict[str, Value]] = Field(
        default=None, description="Ordering of facet values within an individual facet."
    )
    __properties: ClassVar[List[str]] = ["facets", "values"]

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
        """Create an instance of FacetOrdering from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of
        # facets
        if self.facets:
            _dict["facets"] = self.facets.to_dict()
        # override the default output from pydantic by calling `to_dict()` of
        # each value in values (dict)
        _field_dict = {}
        if self.values:
            for _key in self.values:
                if self.values[_key]:
                    _field_dict[_key] = self.values[_key].to_dict()
            _dict["values"] = _field_dict
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of FacetOrdering from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "facets": Facets.from_dict(obj.get("facets"))
                if obj.get("facets") is not None
                else None,
                "values": dict(
                    (_k, Value.from_dict(_v)) for _k, _v in obj.get("values").items()
                )
                if obj.get("values") is not None
                else None,
            }
        )
        return _obj
