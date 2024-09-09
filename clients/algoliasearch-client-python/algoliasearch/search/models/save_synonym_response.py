# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict

from pydantic import BaseModel, ConfigDict, Field, StrictInt, StrictStr

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


class SaveSynonymResponse(BaseModel):
    """
    SaveSynonymResponse
    """

    task_id: StrictInt = Field(
        description="Unique identifier of a task.  A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the [`task` operation](#tag/Indices/operation/getTask) and this `taskID`. ",
        alias="taskID",
    )
    updated_at: StrictStr = Field(
        description="Date and time when the object was updated, in RFC 3339 format.",
        alias="updatedAt",
    )
    id: StrictStr = Field(description="Unique identifier of a synonym object.")

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of SaveSynonymResponse from a JSON string"""
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
        """Create an instance of SaveSynonymResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "taskID": obj.get("taskID"),
                "updatedAt": obj.get("updatedAt"),
                "id": obj.get("id"),
            }
        )
        return _obj
