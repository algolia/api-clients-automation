# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from typing import Annotated, Any, Dict, Optional, Self

from pydantic import BaseModel, ConfigDict, Field, StrictInt


class BrowsePagination(BaseModel):
    """
    BrowsePagination
    """

    page: Optional[Annotated[int, Field(strict=True, ge=0)]] = Field(
        default=0, description="Page of search results to retrieve."
    )
    nb_hits: Optional[StrictInt] = Field(
        default=None, description="Number of results (hits).", alias="nbHits"
    )
    nb_pages: Optional[StrictInt] = Field(
        default=None, description="Number of pages of results.", alias="nbPages"
    )
    hits_per_page: Optional[Annotated[int, Field(le=1000, strict=True, ge=1)]] = Field(
        default=20, description="Number of hits per page.", alias="hitsPerPage"
    )

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of BrowsePagination from a JSON string"""
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
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of BrowsePagination from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "page": obj.get("page"),
                "nbHits": obj.get("nbHits"),
                "nbPages": obj.get("nbPages"),
                "hitsPerPage": obj.get("hitsPerPage"),
            }
        )
        return _obj