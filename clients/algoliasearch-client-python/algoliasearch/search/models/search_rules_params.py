# coding: utf-8

"""
    Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

import json
import pprint
from typing import Any, ClassVar, Dict, List, Optional, Union

from pydantic import Annotated, BaseModel, Field, StrictBool, StrictStr
from search.models.anchoring import Anchoring

try:
    from typing import Self
except ImportError:
    from typing_extensions import Self


class SearchRulesParams(BaseModel):
    """
    Rules search parameters.
    """

    query: Optional[StrictStr] = Field(default="", description="Rule object query.")
    anchoring: Optional[Anchoring] = None
    context: Optional[StrictStr] = Field(
        default=None,
        description="Restricts responses to the specified [contextual rule](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#creating-contextual-rules).",
    )
    page: Optional[Annotated[int, Field(strict=True, ge=0)]] = Field(
        default=None, description="Requested page (the first page is page 0)."
    )
    hits_per_page: Optional[Annotated[int, Field(le=1000, strict=True, ge=1)]] = Field(
        default=20, description="Maximum number of hits per page.", alias="hitsPerPage"
    )
    enabled: Optional[StrictBool] = Field(
        default=None,
        description="Restricts responses to enabled rules. When not specified (default), _all_ rules are retrieved.",
    )
    request_options: Optional[List[Union[str, Any]]] = Field(
        default=None,
        description="Request options to send with the API call.",
        alias="requestOptions",
    )
    __properties: ClassVar[List[str]] = [
        "query",
        "anchoring",
        "context",
        "page",
        "hitsPerPage",
        "enabled",
        "requestOptions",
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
        """Create an instance of SearchRulesParams from a JSON string"""
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
        # set to None if enabled (nullable) is None
        # and model_fields_set contains the field
        if self.enabled is None and "enabled" in self.model_fields_set:
            _dict["enabled"] = None

        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of SearchRulesParams from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "query": obj.get("query") if obj.get("query") is not None else "",
                "anchoring": obj.get("anchoring"),
                "context": obj.get("context"),
                "page": obj.get("page"),
                "hitsPerPage": obj.get("hitsPerPage")
                if obj.get("hitsPerPage") is not None
                else 20,
                "enabled": obj.get("enabled"),
                "requestOptions": obj.get("requestOptions"),
            }
        )
        return _obj
