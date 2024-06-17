# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Any, Dict, Self

from pydantic import BaseModel, ConfigDict, Field, StrictStr

from algoliasearch.analytics.models.currencies_value import CurrenciesValue


class DailyRevenue(BaseModel):
    """
    DailyRevenue
    """

    currencies: Dict[str, CurrenciesValue] = Field(
        description="Revenue associated with this search, broken-down by currencies."
    )
    var_date: StrictStr = Field(
        description="Date in the format YYYY-MM-DD.", alias="date"
    )

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of DailyRevenue from a JSON string"""
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
        _field_dict = {}
        if self.currencies:
            for _key in self.currencies:
                if self.currencies[_key]:
                    _field_dict[_key] = self.currencies[_key].to_dict()
            _dict["currencies"] = _field_dict
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of DailyRevenue from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "currencies": (
                    dict(
                        (_k, CurrenciesValue.from_dict(_v))
                        for _k, _v in obj.get("currencies").items()
                    )
                    if obj.get("currencies") is not None
                    else None
                ),
                "date": obj.get("date"),
            }
        )
        return _obj
