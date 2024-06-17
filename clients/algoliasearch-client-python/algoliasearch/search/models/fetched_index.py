# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Any, Dict, List, Optional, Self

from pydantic import BaseModel, ConfigDict, Field, StrictBool, StrictInt, StrictStr


class FetchedIndex(BaseModel):
    """
    FetchedIndex
    """

    name: StrictStr = Field(description="Index name.")
    created_at: StrictStr = Field(
        description="Index creation date. An empty string means that the index has no records.",
        alias="createdAt",
    )
    updated_at: StrictStr = Field(
        description="Date and time when the object was updated, in RFC 3339 format.",
        alias="updatedAt",
    )
    entries: StrictInt = Field(description="Number of records contained in the index.")
    data_size: StrictInt = Field(
        description="Number of bytes of the index in minified format.", alias="dataSize"
    )
    file_size: StrictInt = Field(
        description="Number of bytes of the index binary file.", alias="fileSize"
    )
    last_build_time_s: StrictInt = Field(
        description="Last build time.", alias="lastBuildTimeS"
    )
    number_of_pending_tasks: StrictInt = Field(
        description="Number of pending indexing operations. This value is deprecated and should not be used.",
        alias="numberOfPendingTasks",
    )
    pending_task: StrictBool = Field(
        description="A boolean which says whether the index has pending tasks. This value is deprecated and should not be used.",
        alias="pendingTask",
    )
    primary: Optional[StrictStr] = Field(
        default=None,
        description="Only present if the index is a replica. Contains the name of the related primary index.",
    )
    replicas: Optional[List[StrictStr]] = Field(
        default=None,
        description="Only present if the index is a primary index with replicas. Contains the names of all linked replicas.",
    )

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of FetchedIndex from a JSON string"""
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
        """Create an instance of FetchedIndex from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "name": obj.get("name"),
                "createdAt": obj.get("createdAt"),
                "updatedAt": obj.get("updatedAt"),
                "entries": obj.get("entries"),
                "dataSize": obj.get("dataSize"),
                "fileSize": obj.get("fileSize"),
                "lastBuildTimeS": obj.get("lastBuildTimeS"),
                "numberOfPendingTasks": obj.get("numberOfPendingTasks"),
                "pendingTask": obj.get("pendingTask"),
                "primary": obj.get("primary"),
                "replicas": obj.get("replicas"),
            }
        )
        return _obj
