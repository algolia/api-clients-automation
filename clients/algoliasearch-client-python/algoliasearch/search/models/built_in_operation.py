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


from algoliasearch.search.models.built_in_operation_type import BuiltInOperationType
from algoliasearch.search.models.built_in_operation_value import BuiltInOperationValue


class BuiltInOperation(BaseModel):
    """
    Update to perform on the attribute.
    """

    operation: BuiltInOperationType = Field(alias="_operation")
    value: BuiltInOperationValue = Field(alias="value")

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
        """Create an instance of BuiltInOperation from a JSON string"""
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
        """Create an instance of BuiltInOperation from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["_operation"] = obj.get("_operation")
        obj["value"] = (
            BuiltInOperationValue.from_dict(obj["value"])
            if obj.get("value") is not None
            else None
        )

        return cls.model_validate(obj)
