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


from algoliasearch.search.models.operation_type import OperationType
from algoliasearch.search.models.scope_type import ScopeType


class OperationIndexParams(BaseModel):
    """
    OperationIndexParams
    """

    operation: OperationType = Field(alias="operation")
    destination: str = Field(alias="destination")
    """ Index name (case-sensitive). """
    scope: Optional[List[ScopeType]] = Field(default=None, alias="scope")
    """ **Only for copying.**  If you specify a scope, only the selected scopes are copied. Records and the other scopes are left unchanged. If you omit the `scope` parameter, everything is copied: records, settings, synonyms, and rules.  """

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
        """Create an instance of OperationIndexParams from a JSON string"""
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
        """Create an instance of OperationIndexParams from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["operation"] = obj.get("operation")
        obj["scope"] = obj.get("scope")

        return cls.model_validate(obj)
