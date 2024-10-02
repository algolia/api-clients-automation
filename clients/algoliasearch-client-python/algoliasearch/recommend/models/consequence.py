# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, List, Optional

from pydantic import BaseModel, ConfigDict, Field

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.recommend.models.hide_consequence_object import HideConsequenceObject
from algoliasearch.recommend.models.params_consequence import ParamsConsequence
from algoliasearch.recommend.models.promote_consequence_object import (
    PromoteConsequenceObject,
)


class Consequence(BaseModel):
    """
    Effect of the rule.
    """

    hide: Optional[List[HideConsequenceObject]] = Field(default=None, alias="hide")
    """ Exclude items from recommendations. """
    promote: Optional[List[PromoteConsequenceObject]] = Field(
        default=None, alias="promote"
    )
    """ Place items at specific positions in the list of recommendations. """
    params: Optional[ParamsConsequence] = Field(default=None, alias="params")

    model_config = ConfigDict(
        use_enum_values=True,
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of Consequence from a JSON string"""
        return cls.from_dict(loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias."""
        return self.model_dump(
            by_alias=True,
            exclude_none=True,
            exclude_unset=True,
        )

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of Consequence from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["hide"] = (
            [HideConsequenceObject.from_dict(_item) for _item in obj["hide"]]
            if obj.get("hide") is not None
            else None
        )
        obj["promote"] = (
            [PromoteConsequenceObject.from_dict(_item) for _item in obj["promote"]]
            if obj.get("promote") is not None
            else None
        )
        obj["params"] = (
            ParamsConsequence.from_dict(obj["params"])
            if obj.get("params") is not None
            else None
        )

        return cls.model_validate(obj)
