# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Any, ClassVar, Dict, List, Optional

from pydantic import BaseModel, Field, StrictStr

try:
    from typing import Self
except ImportError:
    from typing_extensions import Self


class BaseQuerySuggestionsConfigurationResponse(BaseModel):
    """
    BaseQuerySuggestionsConfigurationResponse
    """

    app_id: Optional[StrictStr] = Field(
        default=None, description="Your Algolia application ID.", alias="appId"
    )
    source_indices_api_key: Optional[StrictStr] = Field(
        default=None,
        description="API key used to read from your source index.",
        alias="sourceIndicesAPIKey",
    )
    suggestions_indices_api_key: Optional[StrictStr] = Field(
        default=None,
        description="API key used to write and configure your Query Suggestions index.",
        alias="suggestionsIndicesAPIKey",
    )
    external_indices_api_key: Optional[StrictStr] = Field(
        default="",
        description="API key used to read from external Algolia indices.",
        alias="externalIndicesAPIKey",
    )
    __properties: ClassVar[List[str]] = [
        "appId",
        "sourceIndicesAPIKey",
        "suggestionsIndicesAPIKey",
        "externalIndicesAPIKey",
    ]

    model_config = {"populate_by_name": True, "validate_assignment": True}

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of BaseQuerySuggestionsConfigurationResponse from a JSON string"""
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
        """Create an instance of BaseQuerySuggestionsConfigurationResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "appId": obj.get("appId"),
                "sourceIndicesAPIKey": obj.get("sourceIndicesAPIKey"),
                "suggestionsIndicesAPIKey": obj.get("suggestionsIndicesAPIKey"),
                "externalIndicesAPIKey": obj.get("externalIndicesAPIKey")
                if obj.get("externalIndicesAPIKey") is not None
                else "",
            }
        )
        return _obj
