# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from typing import Any, Dict, Self

from pydantic import BaseModel, ConfigDict, Field, StrictBool, StrictStr

from algoliasearch.recommend.models.redirect_rule_index_data import (
    RedirectRuleIndexData,
)


class RedirectRuleIndexMetadata(BaseModel):
    """
    RedirectRuleIndexMetadata
    """

    source: StrictStr = Field(description="Source index for the redirect rule.")
    dest: StrictStr = Field(description="Destination index for the redirect rule.")
    reason: StrictStr = Field(description="Reason for the redirect rule.")
    succeed: StrictBool = Field(description="Redirect rule status.")
    data: RedirectRuleIndexData

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of RedirectRuleIndexMetadata from a JSON string"""
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
        if self.data:
            _dict["data"] = self.data.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of RedirectRuleIndexMetadata from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "source": obj.get("source"),
                "dest": obj.get("dest"),
                "reason": obj.get("reason"),
                "succeed": obj.get("succeed"),
                "data": (
                    RedirectRuleIndexData.from_dict(obj.get("data"))
                    if obj.get("data") is not None
                    else None
                ),
            }
        )
        return _obj
