# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

import json
import pprint
from typing import Any, ClassVar, Dict, List

from pydantic import BaseModel, Field, StrictInt

from algoliasearch.search.models.rule import Rule

try:
    from typing import Self
except ImportError:
    from typing_extensions import Self


class SearchRulesResponse(BaseModel):
    """
    SearchRulesResponse
    """

    hits: List[Rule] = Field(description="Fetched rules.")
    nb_hits: StrictInt = Field(description="Number of fetched rules.", alias="nbHits")
    page: StrictInt = Field(description="Current page.")
    nb_pages: StrictInt = Field(description="Number of pages.", alias="nbPages")
    __properties: ClassVar[List[str]] = ["hits", "nbHits", "page", "nbPages"]

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
        """Create an instance of SearchRulesResponse from a JSON string"""
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
        # each item in hits (list)
        _items = []
        if self.hits:
            for _item in self.hits:
                if _item:
                    _items.append(_item.to_dict())
            _dict["hits"] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of SearchRulesResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "hits": [Rule.from_dict(_item) for _item in obj.get("hits")]
                if obj.get("hits") is not None
                else None,
                "nbHits": obj.get("nbHits"),
                "page": obj.get("page"),
                "nbPages": obj.get("nbPages"),
            }
        )
        return _obj
