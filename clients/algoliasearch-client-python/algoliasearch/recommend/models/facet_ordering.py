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


from algoliasearch.recommend.models.index_settings_facets import IndexSettingsFacets
from algoliasearch.recommend.models.value import Value

_ALIASES = {
    "facets": "facets",
    "values": "values",
}


def _alias_generator(name: str) -> str:
    return _ALIASES.get(name, name)


class FacetOrdering(BaseModel):
    """
    Order of facet names and facet values in your UI.
    """

    facets: Optional[IndexSettingsFacets] = None
    values: Optional[Dict[str, Value]] = None
    """ Order of facet values. One object for each facet. """

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
        """Create an instance of FacetOrdering from a JSON string"""
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
        """Create an instance of FacetOrdering from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["facets"] = (
            IndexSettingsFacets.from_dict(obj["facets"])
            if obj.get("facets") is not None
            else None
        )
        obj["values"] = (
            dict((_k, Value.from_dict(_v)) for _k, _v in obj["values"].items())
            if obj.get("values") is not None
            else None
        )

        return cls.model_validate(obj)
