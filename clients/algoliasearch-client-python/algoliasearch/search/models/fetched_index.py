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


_ALIASES = {
    "name": "name",
    "created_at": "createdAt",
    "updated_at": "updatedAt",
    "entries": "entries",
    "data_size": "dataSize",
    "file_size": "fileSize",
    "last_build_time_s": "lastBuildTimeS",
    "number_of_pending_tasks": "numberOfPendingTasks",
    "pending_task": "pendingTask",
    "primary": "primary",
    "replicas": "replicas",
    "virtual": "virtual",
}


def _alias_generator(name: str) -> str:
    return _ALIASES.get(name, name)


class FetchedIndex(BaseModel):
    """
    FetchedIndex
    """

    name: str
    """ Index name. """
    created_at: str
    """ Index creation date. An empty string means that the index has no records. """
    updated_at: str
    """ Date and time when the object was updated, in RFC 3339 format. """
    entries: int
    """ Number of records contained in the index. """
    data_size: int
    """ Number of bytes of the index in minified format. """
    file_size: int
    """ Number of bytes of the index binary file. """
    last_build_time_s: int
    """ Last build time. """
    number_of_pending_tasks: int
    """ Number of pending indexing operations. This value is deprecated and should not be used. """
    pending_task: bool
    """ A boolean which says whether the index has pending tasks. This value is deprecated and should not be used. """
    primary: Optional[str] = None
    """ Only present if the index is a replica. Contains the name of the related primary index. """
    replicas: Optional[List[str]] = None
    """ Only present if the index is a primary index with replicas. Contains the names of all linked replicas. """
    virtual: Optional[bool] = None
    """ Only present if the index is a [virtual replica](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/how-to/sort-an-index-alphabetically/#virtual-replicas). """

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
        """Create an instance of FetchedIndex from a JSON string"""
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
        """Create an instance of FetchedIndex from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        return cls.model_validate(obj)
