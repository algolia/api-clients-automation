# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, List, Optional

from pydantic import BaseModel, ConfigDict

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.recommend.models.auto_facet_filter import AutoFacetFilter

_ALIASES = {
    "automatic_facet_filters": "automaticFacetFilters",
    "filters": "filters",
    "optional_filters": "optionalFilters",
}


def _alias_generator(name: str) -> str:
    return _ALIASES.get(name, name)


class ParamsConsequence(BaseModel):
    """
    Filter or boost recommendations matching a facet filter.
    """

    automatic_facet_filters: Optional[List[AutoFacetFilter]] = None
    """ Filter recommendations that match or don't match the same `facet:facet_value` combination as the viewed item. """
    filters: Optional[str] = None
    """ Filter expression to only include items that match the filter criteria in the response.  You can use these filter expressions:  - **Numeric filters.** `<facet> <op> <number>`, where `<op>` is one of `<`, `<=`, `=`, `!=`, `>`, `>=`. - **Ranges.** `<facet>:<lower> TO <upper>` where `<lower>` and `<upper>` are the lower and upper limits of the range (inclusive). - **Facet filters.** `<facet>:<value>` where `<facet>` is a facet attribute (case-sensitive) and `<value>` a facet value. - **Tag filters.** `_tags:<value>` or just `<value>` (case-sensitive). - **Boolean filters.** `<facet>: true | false`.  You can combine filters with `AND`, `OR`, and `NOT` operators with the following restrictions:  - You can only combine filters of the same type with `OR`.   **Not supported:** `facet:value OR num > 3`. - You can't use `NOT` with combinations of filters.   **Not supported:** `NOT(facet:value OR facet:value)` - You can't combine conjunctions (`AND`) with `OR`.   **Not supported:** `facet:value OR (facet:value AND facet:value)`  Use quotes around your filters, if the facet attribute name or facet value has spaces, keywords (`OR`, `AND`, `NOT`), or quotes. If a facet attribute is an array, the filter matches if it matches at least one element of the array.  For more information, see [Filters](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/).  """
    optional_filters: Optional[List[str]] = None
    """ Filters to promote or demote records in the search results.  Optional filters work like facet filters, but they don't exclude records from the search results. Records that match the optional filter rank before records that don't match. Matches with higher weights (`<score=N>`) rank before matches with lower weights. If you're using a negative filter `facet:-value`, matching records rank after records that don't match.  """

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
        """Create an instance of ParamsConsequence from a JSON string"""
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
        """Create an instance of ParamsConsequence from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["automaticFacetFilters"] = (
            [AutoFacetFilter.from_dict(_item) for _item in obj["automaticFacetFilters"]]
            if obj.get("automaticFacetFilters") is not None
            else None
        )

        return cls.model_validate(obj)
