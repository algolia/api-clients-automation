# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, Optional

from pydantic import BaseModel, ConfigDict, Field

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.recommend.models.facets import Facets
from algoliasearch.recommend.models.value import Value


class FacetOrdering(BaseModel):
    """
    Order of facet names and facet values in your UI.
    """

    facets: Optional[Facets] = None
    values: Optional[Dict[str, Value]] = Field(
        default=None, description="Order of facet values. One object for each facet."
    )

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of FacetOrdering from a JSON string"""
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
        if self.facets:
            _dict["facets"] = self.facets.to_dict()
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
                "facets": (
                    Facets.from_dict(obj.get("facets"))
                    if obj.get("facets") is not None
                    else None
                ),
                "values": (
                    dict(
                        (_k, Value.from_dict(_v))
                        for _k, _v in obj.get("values").items()
                    )
                    if obj.get("values") is not None
                    else None
                ),
            }
        )
        return _obj
