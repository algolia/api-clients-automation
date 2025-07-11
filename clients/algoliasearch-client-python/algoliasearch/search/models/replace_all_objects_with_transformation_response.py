# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, List, Optional

from pydantic import BaseModel, ConfigDict

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.search.models.updated_at_response import UpdatedAtResponse
from algoliasearch.search.models.watch_response import WatchResponse

_ALIASES = {
    "copy_operation_response": "copyOperationResponse",
    "watch_responses": "watchResponses",
    "move_operation_response": "moveOperationResponse",
}


def _alias_generator(name: str) -> str:
    return _ALIASES.get(name, name)


class ReplaceAllObjectsWithTransformationResponse(BaseModel):
    """
    ReplaceAllObjectsWithTransformationResponse
    """

    copy_operation_response: UpdatedAtResponse
    watch_responses: List[WatchResponse]
    """ The response of the `push` request(s). """
    move_operation_response: UpdatedAtResponse

    model_config = ConfigDict(
        strict=False,
        use_enum_values=True,
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
        alias_generator=_alias_generator,
        extra="allow",
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of ReplaceAllObjectsWithTransformationResponse from a JSON string"""
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
        """Create an instance of ReplaceAllObjectsWithTransformationResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["copyOperationResponse"] = (
            UpdatedAtResponse.from_dict(obj["copyOperationResponse"])
            if obj.get("copyOperationResponse") is not None
            else None
        )
        obj["watchResponses"] = (
            [WatchResponse.from_dict(_item) for _item in obj["watchResponses"]]
            if obj.get("watchResponses") is not None
            else None
        )
        obj["moveOperationResponse"] = (
            UpdatedAtResponse.from_dict(obj["moveOperationResponse"])
            if obj.get("moveOperationResponse") is not None
            else None
        )

        return cls.model_validate(obj)
