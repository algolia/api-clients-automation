# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Annotated, Any, Dict, Optional, Self

from pydantic import BaseModel, Field, StrictStr

from algoliasearch.ingestion.models.event_status import EventStatus
from algoliasearch.ingestion.models.event_type import EventType


class Event(BaseModel):
    """
    An event describe a step of the task execution flow..
    """

    event_id: StrictStr = Field(
        description="Universally unique identifier (UUID) of an event.", alias="eventID"
    )
    run_id: StrictStr = Field(
        description="Universally unique identifier (UUID) of a task run.", alias="runID"
    )
    parent_id: Optional[StrictStr] = Field(
        default=None,
        description="The parent event, the cause of this event.",
        alias="parentID",
    )
    status: EventStatus
    type: EventType
    batch_size: Annotated[int, Field(multiple_of=1, strict=True, ge=0)] = Field(
        description="The extracted record batch size.", alias="batchSize"
    )
    data: Optional[Dict[str, Any]] = None
    published_at: StrictStr = Field(
        description="Date of publish RFC 3339 format.", alias="publishedAt"
    )

    model_config = {"populate_by_name": True, "validate_assignment": True}

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of Event from a JSON string"""
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
        """Create an instance of Event from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "eventID": obj.get("eventID"),
                "runID": obj.get("runID"),
                "parentID": obj.get("parentID"),
                "status": obj.get("status"),
                "type": obj.get("type"),
                "batchSize": obj.get("batchSize"),
                "data": obj.get("data"),
                "publishedAt": obj.get("publishedAt"),
            }
        )
        return _obj
