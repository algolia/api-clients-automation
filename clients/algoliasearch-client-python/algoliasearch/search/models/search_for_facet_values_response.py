# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, List, Optional

from pydantic import BaseModel, ConfigDict, Field, StrictBool, StrictInt

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.search.models.facet_hits import FacetHits


class SearchForFacetValuesResponse(BaseModel):
    """
    SearchForFacetValuesResponse
    """

    facet_hits: List[FacetHits] = Field(
        description="Matching facet values.", alias="facetHits"
    )
    exhaustive_facets_count: StrictBool = Field(
        description="Whether the facet count is exhaustive (true) or approximate (false). For more information, see [Why are my facet and hit counts not accurate](https://support.algolia.com/hc/en-us/articles/4406975248145-Why-are-my-facet-and-hit-counts-not-accurate-). ",
        alias="exhaustiveFacetsCount",
    )
    processing_time_ms: Optional[StrictInt] = Field(
        default=None,
        description="Time the server took to process the request, in milliseconds.",
        alias="processingTimeMS",
    )

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of SearchForFacetValuesResponse from a JSON string"""
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
        if self.facet_hits:
            for _item in self.facet_hits:
                if _item:
                    _items.append(_item.to_dict())
            _dict["facetHits"] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of SearchForFacetValuesResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "facetHits": (
                    [FacetHits.from_dict(_item) for _item in obj.get("facetHits")]
                    if obj.get("facetHits") is not None
                    else None
                ),
                "exhaustiveFacetsCount": obj.get("exhaustiveFacetsCount"),
                "processingTimeMS": obj.get("processingTimeMS"),
            }
        )
        return _obj
