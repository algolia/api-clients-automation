# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from typing import Annotated, Any, Dict, List, Self

from pydantic import BaseModel, ConfigDict, Field

from algoliasearch.analytics.models.click_position import ClickPosition


class GetClickPositionsResponse(BaseModel):
    """
    GetClickPositionsResponse
    """

    positions: Annotated[List[ClickPosition], Field(min_length=12, max_length=12)] = (
        Field(
            description="List of positions in the search results and clicks associated with this search."
        )
    )

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of GetClickPositionsResponse from a JSON string"""
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
        _items = []
        if self.positions:
            for _item in self.positions:
                if _item:
                    _items.append(_item.to_dict())
            _dict["positions"] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of GetClickPositionsResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "positions": (
                    [ClickPosition.from_dict(_item) for _item in obj.get("positions")]
                    if obj.get("positions") is not None
                    else None
                )
            }
        )
        return _obj
