# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from re import match
from typing import Annotated, Any, Dict, Optional, Self

from pydantic import BaseModel, ConfigDict, Field, StrictInt, field_validator

from algoliasearch.insights.models.discount import Discount
from algoliasearch.insights.models.price import Price


class ObjectDataAfterSearch(BaseModel):
    """
    ObjectDataAfterSearch
    """

    query_id: Optional[
        Annotated[str, Field(min_length=32, strict=True, max_length=32)]
    ] = Field(
        default=None,
        description="Unique identifier for a search query, used to track purchase events with multiple records that originate from different searches.",
        alias="queryID",
    )
    price: Optional[Price] = None
    quantity: Optional[StrictInt] = Field(
        default=None,
        description="Quantity of a product that has been purchased or added to the cart. The total purchase value is the sum of `quantity` multiplied with the `price` for each purchased item. ",
    )
    discount: Optional[Discount] = None

    @field_validator("query_id")
    def query_id_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if value is None:
            return value

        if not match(r"[0-9a-f]{32}", value):
            raise ValueError(r"must validate the regular expression /[0-9a-f]{32}/")
        return value

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of ObjectDataAfterSearch from a JSON string"""
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
        if self.price:
            _dict["price"] = self.price.to_dict()
        if self.discount:
            _dict["discount"] = self.discount.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of ObjectDataAfterSearch from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "queryID": obj.get("queryID"),
                "price": (
                    Price.from_dict(obj.get("price"))
                    if obj.get("price") is not None
                    else None
                ),
                "quantity": obj.get("quantity"),
                "discount": (
                    Discount.from_dict(obj.get("discount"))
                    if obj.get("discount") is not None
                    else None
                ),
            }
        )
        return _obj
