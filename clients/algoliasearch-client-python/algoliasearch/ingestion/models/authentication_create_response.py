# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from typing import Any, Dict, Self

from pydantic import BaseModel, ConfigDict, Field, StrictStr


class AuthenticationCreateResponse(BaseModel):
    """
    API response for the successful creation of an authentication resource.
    """

    authentication_id: StrictStr = Field(
        description="Universally unique identifier (UUID) of an authentication resource.",
        alias="authenticationID",
    )
    name: StrictStr = Field(description="Descriptive name for the resource.")
    created_at: StrictStr = Field(
        description="Date of creation in RFC 3339 format.", alias="createdAt"
    )

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of AuthenticationCreateResponse from a JSON string"""
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
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of AuthenticationCreateResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "authenticationID": obj.get("authenticationID"),
                "name": obj.get("name"),
                "createdAt": obj.get("createdAt"),
            }
        )
        return _obj
