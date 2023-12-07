# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Any, ClassVar, Dict, List, Optional

from pydantic import BaseModel, Field, StrictInt

from algoliasearch.insights.models.discount import Discount
from algoliasearch.insights.models.price import Price

try:
    from typing import Self
except ImportError:
    from typing_extensions import Self


class ObjectData(BaseModel):
    """
    ObjectData
    """

    price: Optional[Price] = None
    quantity: Optional[StrictInt] = Field(
        default=None,
        description="The quantity of the purchased or added-to-cart item. The total value of a purchase is the sum of `quantity` multiplied with the `price` for each purchased item.",
    )
    discount: Optional[Discount] = None
    __properties: ClassVar[List[str]] = ["price", "quantity", "discount"]

    model_config = {"populate_by_name": True, "validate_assignment": True}

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of ObjectData from a JSON string"""
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
        # price
        if self.price:
            _dict["price"] = self.price.to_dict()
        # override the default output from pydantic by calling `to_dict()` of
        # discount
        if self.discount:
            _dict["discount"] = self.discount.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of ObjectData from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "price": Price.from_dict(obj.get("price"))
                if obj.get("price") is not None
                else None,
                "quantity": obj.get("quantity"),
                "discount": Discount.from_dict(obj.get("discount"))
                if obj.get("discount") is not None
                else None,
            }
        )
        return _obj
