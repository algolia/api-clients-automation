# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, Optional

from pydantic import BaseModel, ConfigDict

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.insights.models.discount import Discount
from algoliasearch.insights.models.price import Price

_ALIASES = {
    "price": "price",
    "quantity": "quantity",
    "discount": "discount",
}


def _alias_generator(name: str) -> str:
    return _ALIASES.get(name, name)


class ObjectData(BaseModel):
    """
    ObjectData
    """

    price: Optional[Price] = None
    quantity: Optional[int] = None
    """ Quantity of a product that has been purchased or added to the cart. The total purchase value is the sum of `quantity` multiplied with the `price` for each purchased item.  """
    discount: Optional[Discount] = None

    model_config = ConfigDict(
        use_enum_values=True,
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
        alias_generator=_alias_generator,
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of ObjectData from a JSON string"""
        return cls.from_dict(loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias."""
        return self.model_dump(
            by_alias=True,
            exclude_none=True,
            exclude_unset=True,
        )

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of ObjectData from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["price"] = (
            Price.from_dict(obj["price"]) if obj.get("price") is not None else None
        )
        obj["discount"] = (
            Discount.from_dict(obj["discount"])
            if obj.get("discount") is not None
            else None
        )

        return cls.model_validate(obj)
