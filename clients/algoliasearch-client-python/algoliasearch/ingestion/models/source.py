# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

import json
import pprint
from typing import Any, ClassVar, Dict, List, Optional

from pydantic import BaseModel, Field, StrictStr

from algoliasearch.ingestion.models.source_input import SourceInput
from algoliasearch.ingestion.models.source_type import SourceType

try:
    from typing import Self
except ImportError:
    from typing_extensions import Self


class Source(BaseModel):
    """
    Source
    """

    source_id: StrictStr = Field(description="The source UUID.", alias="sourceID")
    type: SourceType
    name: StrictStr
    input: SourceInput
    authentication_id: Optional[StrictStr] = Field(
        default=None, description="The authentication UUID.", alias="authenticationID"
    )
    created_at: StrictStr = Field(
        description="Date of creation (RFC3339 format).", alias="createdAt"
    )
    updated_at: Optional[StrictStr] = Field(
        default=None,
        description="Date of last update (RFC3339 format).",
        alias="updatedAt",
    )
    __properties: ClassVar[List[str]] = [
        "sourceID",
        "type",
        "name",
        "input",
        "authenticationID",
        "createdAt",
        "updatedAt",
    ]

    model_config = {"populate_by_name": True, "validate_assignment": True}

    def to_str(self) -> str:
        """Returns the string representation of the model using alias"""
        return pprint.pformat(self.model_dump(by_alias=True))

    def to_json(self) -> str:
        """Returns the JSON representation of the model using alias"""
        # TODO: pydantic v2: use .model_dump_json(by_alias=True,
        # exclude_unset=True) instead
        return json.dumps(self.to_dict())

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of Source from a JSON string"""
        return cls.from_dict(json.loads(json_str))

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
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of Source from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "sourceID": obj.get("sourceID"),
                "type": obj.get("type"),
                "name": obj.get("name"),
                "input": SourceInput.from_dict(obj.get("input"))
                if obj.get("input") is not None
                else None,
                "authenticationID": obj.get("authenticationID"),
                "createdAt": obj.get("createdAt"),
                "updatedAt": obj.get("updatedAt"),
            }
        )
        return _obj
