# coding: utf-8

"""
    Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

import json
import pprint
from typing import Any, ClassVar, Dict, List

from pydantic import Annotated, BaseModel, Field, StrictInt, StrictStr
from search.models.user_hit import UserHit

try:
    from typing import Self
except ImportError:
    from typing_extensions import Self


class SearchUserIdsResponse(BaseModel):
    """
    userIDs data.
    """

    hits: List[UserHit] = Field(description="User objects that match the query.")
    nb_hits: StrictInt = Field(
        description="Number of hits the search query matched.", alias="nbHits"
    )
    page: StrictInt = Field(
        description="Page to retrieve (the first page is `0`, not `1`)."
    )
    hits_per_page: Annotated[int, Field(le=1000, strict=True, ge=1)] = Field(
        description="Maximum number of hits per page.", alias="hitsPerPage"
    )
    updated_at: StrictStr = Field(
        description="Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.",
        alias="updatedAt",
    )
    __properties: ClassVar[List[str]] = [
        "hits",
        "nbHits",
        "page",
        "hitsPerPage",
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
        """Create an instance of SearchUserIdsResponse from a JSON string"""
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
        """Create an instance of SearchUserIdsResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "hits": [UserHit.from_dict(_item) for _item in obj.get("hits")]
                if obj.get("hits") is not None
                else None,
                "nbHits": obj.get("nbHits"),
                "page": obj.get("page") if obj.get("page") is not None else 0,
                "hitsPerPage": obj.get("hitsPerPage")
                if obj.get("hitsPerPage") is not None
                else 20,
                "updatedAt": obj.get("updatedAt"),
            }
        )
        return _obj
