# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict

from pydantic import BaseModel, ConfigDict, Field

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.search.models.highlight_result import HighlightResult


class UserHighlightResult(BaseModel):
    """
    UserHighlightResult
    """

    user_id: HighlightResult = Field(alias="userID")
    cluster_name: HighlightResult = Field(alias="clusterName")

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of UserHighlightResult from a JSON string"""
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
        if self.user_id:
            _dict["userID"] = self.user_id.to_dict()
        if self.cluster_name:
            _dict["clusterName"] = self.cluster_name.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of UserHighlightResult from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "userID": (
                    HighlightResult.from_dict(obj.get("userID"))
                    if obj.get("userID") is not None
                    else None
                ),
                "clusterName": (
                    HighlightResult.from_dict(obj.get("clusterName"))
                    if obj.get("clusterName") is not None
                    else None
                ),
            }
        )
        return _obj
