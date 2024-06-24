# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from typing import Annotated, Any, Dict, Optional, Self

from pydantic import BaseModel, ConfigDict, Field, StrictBool, StrictStr

from algoliasearch.ingestion.models.action_type import ActionType
from algoliasearch.ingestion.models.task_input import TaskInput
from algoliasearch.ingestion.models.trigger import Trigger


class Task(BaseModel):
    """
    Task
    """

    task_id: StrictStr = Field(
        description="Universally unique identifier (UUID) of a task.", alias="taskID"
    )
    source_id: StrictStr = Field(
        description="Universally uniqud identifier (UUID) of a source.",
        alias="sourceID",
    )
    destination_id: StrictStr = Field(
        description="Universally unique identifier (UUID) of a destination resource.",
        alias="destinationID",
    )
    trigger: Trigger
    input: Optional[TaskInput] = None
    enabled: StrictBool = Field(description="Whether the task is enabled.")
    failure_threshold: Optional[Annotated[int, Field(le=100, strict=True, ge=0)]] = (
        Field(
            default=None,
            description="Maximum accepted percentage of failures for a task run to finish successfully.",
            alias="failureThreshold",
        )
    )
    action: ActionType
    cursor: Optional[StrictStr] = Field(
        default=None, description="Date of the last cursor in RFC 3339 format."
    )
    created_at: StrictStr = Field(
        description="Date of creation in RFC 3339 format.", alias="createdAt"
    )
    updated_at: Optional[StrictStr] = Field(
        default=None,
        description="Date of last update in RFC 3339 format.",
        alias="updatedAt",
    )

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of Task from a JSON string"""
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
        if self.trigger:
            _dict["trigger"] = self.trigger.to_dict()
        if self.input:
            _dict["input"] = self.input.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of Task from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "taskID": obj.get("taskID"),
                "sourceID": obj.get("sourceID"),
                "destinationID": obj.get("destinationID"),
                "trigger": (
                    Trigger.from_dict(obj.get("trigger"))
                    if obj.get("trigger") is not None
                    else None
                ),
                "input": (
                    TaskInput.from_dict(obj.get("input"))
                    if obj.get("input") is not None
                    else None
                ),
                "enabled": obj.get("enabled"),
                "failureThreshold": obj.get("failureThreshold"),
                "action": obj.get("action"),
                "cursor": obj.get("cursor"),
                "createdAt": obj.get("createdAt"),
                "updatedAt": obj.get("updatedAt"),
            }
        )
        return _obj
