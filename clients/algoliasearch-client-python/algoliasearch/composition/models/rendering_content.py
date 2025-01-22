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


from algoliasearch.composition.models.facet_ordering import FacetOrdering
from algoliasearch.composition.models.redirect_url import RedirectURL
from algoliasearch.composition.models.widgets import Widgets

_ALIASES = {
    "facet_ordering": "facetOrdering",
    "redirect": "redirect",
    "widgets": "widgets",
}


def _alias_generator(name: str) -> str:
    return _ALIASES.get(name, name)


class RenderingContent(BaseModel):
    """
    Extra data that can be used in the search UI.  You can use this to control aspects of your search UI, such as the order of facet names and values without changing your frontend code.
    """

    facet_ordering: Optional[FacetOrdering] = None
    redirect: Optional[RedirectURL] = None
    widgets: Optional[Widgets] = None

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
        """Create an instance of RenderingContent from a JSON string"""
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
        """Create an instance of RenderingContent from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["facetOrdering"] = (
            FacetOrdering.from_dict(obj["facetOrdering"])
            if obj.get("facetOrdering") is not None
            else None
        )
        obj["redirect"] = (
            RedirectURL.from_dict(obj["redirect"])
            if obj.get("redirect") is not None
            else None
        )
        obj["widgets"] = (
            Widgets.from_dict(obj["widgets"])
            if obj.get("widgets") is not None
            else None
        )

        return cls.model_validate(obj)
