# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, Optional

from pydantic import BaseModel, ConfigDict, Field

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.ingestion.models.action_type import ActionType
from algoliasearch.ingestion.models.task_input import TaskInput


class Task(BaseModel):
    """
    Task
    """

    task_id: str = Field(alias="taskID")
    """ Universally unique identifier (UUID) of a task. """
    source_id: str = Field(alias="sourceID")
    """ Universally uniqud identifier (UUID) of a source. """
    destination_id: str = Field(alias="destinationID")
    """ Universally unique identifier (UUID) of a destination resource. """
    cron: Optional[str] = Field(default=None, alias="cron")
    """ Cron expression for the task's schedule. """
    last_run: Optional[str] = Field(default=None, alias="lastRun")
    """ The last time the scheduled task ran in RFC 3339 format. """
    next_run: Optional[str] = Field(default=None, alias="nextRun")
    """ The next scheduled run of the task in RFC 3339 format. """
    input: Optional[TaskInput] = Field(default=None, alias="input")
    enabled: bool = Field(alias="enabled")
    """ Whether the task is enabled. """
    failure_threshold: Optional[int] = Field(default=None, alias="failureThreshold")
    """ Maximum accepted percentage of failures for a task run to finish successfully. """
    action: ActionType = Field(alias="action")
    cursor: Optional[str] = Field(default=None, alias="cursor")
    """ Date of the last cursor in RFC 3339 format. """
    created_at: str = Field(alias="createdAt")
    """ Date of creation in RFC 3339 format. """
    updated_at: Optional[str] = Field(default=None, alias="updatedAt")
    """ Date of last update in RFC 3339 format. """

    model_config = ConfigDict(
        use_enum_values=True,
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of Task from a JSON string"""
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
        """Create an instance of Task from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["input"] = (
            TaskInput.from_dict(obj["input"]) if obj.get("input") is not None else None
        )
        obj["action"] = obj.get("action")

        return cls.model_validate(obj)
