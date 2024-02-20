# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Any, Dict, Optional, Self

from pydantic import BaseModel, Field, StrictStr

from algoliasearch.ingestion.models.auth_input_partial import AuthInputPartial
from algoliasearch.ingestion.models.authentication_type import AuthenticationType
from algoliasearch.ingestion.models.platform import Platform


class AuthenticationUpdate(BaseModel):
    """
    Payload to partially update an Authentication.
    """

    type: Optional[AuthenticationType] = None
    name: Optional[StrictStr] = Field(
        default=None, description="An human readable name describing the object."
    )
    platform: Optional[Platform] = None
    input: Optional[AuthInputPartial] = None

    model_config = {"populate_by_name": True, "validate_assignment": True}

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of AuthenticationUpdate from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of
        # input
        if self.input:
            _dict["input"] = self.input.to_dict()
        # set to None if platform (nullable) is None
        # and model_fields_set contains the field
        if self.platform is None and "platform" in self.model_fields_set:
            _dict["platform"] = None

        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of AuthenticationUpdate from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "type": obj.get("type"),
                "name": obj.get("name"),
                "platform": obj.get("platform"),
                "input": AuthInputPartial.from_dict(obj.get("input"))
                if obj.get("input") is not None
                else None,
            }
        )
        return _obj
