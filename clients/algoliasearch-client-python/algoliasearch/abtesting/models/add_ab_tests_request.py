# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Annotated, Any, ClassVar, Dict, List, Self

from pydantic import BaseModel, Field, StrictStr

from algoliasearch.abtesting.models.add_ab_tests_variant import AddABTestsVariant


class AddABTestsRequest(BaseModel):
    """
    AddABTestsRequest
    """

    name: StrictStr = Field(description="A/B test name.")
    variants: Annotated[
        List[AddABTestsVariant], Field(min_length=2, max_length=2)
    ] = Field(description="A/B test variants.")
    end_at: StrictStr = Field(
        description="End date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format.",
        alias="endAt",
    )
    __properties: ClassVar[List[str]] = ["name", "variants", "endAt"]

    model_config = {"populate_by_name": True, "validate_assignment": True}

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of AddABTestsRequest from a JSON string"""
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
        # each item in variants (list)
        _items = []
        if self.variants:
            for _item in self.variants:
                if _item:
                    _items.append(_item.to_dict())
            _dict["variants"] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of AddABTestsRequest from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "name": obj.get("name"),
                "variants": [
                    AddABTestsVariant.from_dict(_item) for _item in obj.get("variants")
                ]
                if obj.get("variants") is not None
                else None,
                "endAt": obj.get("endAt"),
            }
        )
        return _obj
