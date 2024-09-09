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


from algoliasearch.abtesting.models.empty_search import EmptySearch
from algoliasearch.abtesting.models.minimum_detectable_effect import (
    MinimumDetectableEffect,
)
from algoliasearch.abtesting.models.outliers import Outliers


class ABTestConfiguration(BaseModel):
    """
    A/B test configuration.
    """

    outliers: Outliers
    empty_search: Optional[EmptySearch] = Field(default=None, alias="emptySearch")
    minimum_detectable_effect: Optional[MinimumDetectableEffect] = Field(
        default=None, alias="minimumDetectableEffect"
    )

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of ABTestConfiguration from a JSON string"""
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
        if self.outliers:
            _dict["outliers"] = self.outliers.to_dict()
        if self.empty_search:
            _dict["emptySearch"] = self.empty_search.to_dict()
        if self.minimum_detectable_effect:
            _dict["minimumDetectableEffect"] = self.minimum_detectable_effect.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of ABTestConfiguration from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "outliers": (
                    Outliers.from_dict(obj.get("outliers"))
                    if obj.get("outliers") is not None
                    else None
                ),
                "emptySearch": (
                    EmptySearch.from_dict(obj.get("emptySearch"))
                    if obj.get("emptySearch") is not None
                    else None
                ),
                "minimumDetectableEffect": (
                    MinimumDetectableEffect.from_dict(
                        obj.get("minimumDetectableEffect")
                    )
                    if obj.get("minimumDetectableEffect") is not None
                    else None
                ),
            }
        )
        return _obj
