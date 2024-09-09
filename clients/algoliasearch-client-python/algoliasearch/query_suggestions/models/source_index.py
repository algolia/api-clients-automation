# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, List, Optional

from pydantic import BaseModel, ConfigDict, Field, StrictBool, StrictStr

if version_info >= (3, 11):
    from typing import Annotated, Self
else:
    from typing_extensions import Annotated, Self


from algoliasearch.query_suggestions.models.facet import Facet


class SourceIndex(BaseModel):
    """
    Configuration of an Algolia index for Query Suggestions.
    """

    index_name: StrictStr = Field(
        description="Name of the Algolia index (case-sensitive) to use as source for query suggestions.",
        alias="indexName",
    )
    replicas: Optional[StrictBool] = Field(
        default=False,
        description="If true, Query Suggestions uses all replica indices to find popular searches. If false, only the primary index is used. ",
    )
    analytics_tags: Optional[List[StrictStr]] = Field(
        default=None, alias="analyticsTags"
    )
    facets: Optional[List[Facet]] = None
    min_hits: Optional[Annotated[int, Field(strict=True, ge=0)]] = Field(
        default=5,
        description="Minimum number of hits required to be included as a suggestion.  A search query must at least generate `minHits` search results to be included in the Query Suggestions index. ",
        alias="minHits",
    )
    min_letters: Optional[Annotated[int, Field(strict=True, ge=0)]] = Field(
        default=4,
        description="Minimum letters required to be included as a suggestion.  A search query must be at least `minLetters` long to be included in the Query Suggestions index. ",
        alias="minLetters",
    )
    generate: Optional[List[List[StrictStr]]] = None
    external: Optional[List[StrictStr]] = None

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of SourceIndex from a JSON string"""
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
        if self.facets:
            for _item in self.facets:
                if _item:
                    _items.append(_item.to_dict())
            _dict["facets"] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of SourceIndex from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "indexName": obj.get("indexName"),
                "replicas": obj.get("replicas"),
                "analyticsTags": obj.get("analyticsTags"),
                "facets": (
                    [Facet.from_dict(_item) for _item in obj.get("facets")]
                    if obj.get("facets") is not None
                    else None
                ),
                "minHits": obj.get("minHits"),
                "minLetters": obj.get("minLetters"),
                "generate": obj.get("generate"),
                "external": obj.get("external"),
            }
        )
        return _obj
