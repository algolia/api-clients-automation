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


from algoliasearch.composition.models.params import Params

_ALIASES = {
    "query": "query",
    "max_facet_hits": "maxFacetHits",
    "search_query": "searchQuery",
}


def _alias_generator(name: str) -> str:
    return _ALIASES.get(name, name)


class SearchForFacetValuesParams(BaseModel):
    """
    SearchForFacetValuesParams
    """

    query: Optional[str] = None
    """ Search query. """
    max_facet_hits: Optional[int] = None
    """ Maximum number of facet values to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values). """
    search_query: Optional[Params] = None

    model_config = ConfigDict(
        strict=False,
        use_enum_values=True,
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
        alias_generator=_alias_generator,
        extra="allow",
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of SearchForFacetValuesParams from a JSON string"""
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
        """Create an instance of SearchForFacetValuesParams from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["searchQuery"] = (
            Params.from_dict(obj["searchQuery"])
            if obj.get("searchQuery") is not None
            else None
        )

        return cls.model_validate(obj)
