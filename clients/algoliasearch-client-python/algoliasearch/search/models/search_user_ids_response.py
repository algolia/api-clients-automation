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


from algoliasearch.search.models.user_hit import UserHit

_ALIASES = {
    "hits": "hits",
    "nb_hits": "nbHits",
    "page": "page",
    "hits_per_page": "hitsPerPage",
    "updated_at": "updatedAt",
}


def _alias_generator(name: str) -> str:
    return _ALIASES.get(name, name)


class SearchUserIdsResponse(BaseModel):
    """
    userIDs data.
    """

    hits: List[UserHit]
    """ User objects that match the query. """
    nb_hits: int
    """ Number of results (hits). """
    page: int
    """ Page of search results to retrieve. """
    hits_per_page: int
    """ Maximum number of hits per page. """
    updated_at: str
    """ Date and time when the object was updated, in RFC 3339 format. """

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
        """Create an instance of SearchUserIdsResponse from a JSON string"""
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
        """Create an instance of SearchUserIdsResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["hits"] = (
            [UserHit.from_dict(_item) for _item in obj["hits"]]
            if obj.get("hits") is not None
            else None
        )

        return cls.model_validate(obj)
