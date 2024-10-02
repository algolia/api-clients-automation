# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, List, Optional

from pydantic import BaseModel, ConfigDict, Field

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.ingestion.models.commercetools_custom_fields import (
    CommercetoolsCustomFields,
)


class SourceCommercetools(BaseModel):
    """
    SourceCommercetools
    """

    store_keys: Optional[List[str]] = Field(default=None, alias="storeKeys")
    locales: Optional[List[str]] = Field(default=None, alias="locales")
    """ Locales for your commercetools stores. """
    url: str = Field(alias="url")
    project_key: str = Field(alias="projectKey")
    fallback_is_in_stock_value: Optional[bool] = Field(
        default=None, alias="fallbackIsInStockValue"
    )
    """ Whether a fallback value is stored in the Algolia record if there's no inventory information about the product.  """
    custom_fields: Optional[CommercetoolsCustomFields] = Field(
        default=None, alias="customFields"
    )

    model_config = ConfigDict(
        use_enum_values=True,
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of SourceCommercetools from a JSON string"""
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
        """Create an instance of SourceCommercetools from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["customFields"] = (
            CommercetoolsCustomFields.from_dict(obj["customFields"])
            if obj.get("customFields") is not None
            else None
        )

        return cls.model_validate(obj)
