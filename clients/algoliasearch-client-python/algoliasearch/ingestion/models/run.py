# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Annotated, Any, Dict, Optional, Self

from pydantic import BaseModel, ConfigDict, Field, StrictStr

from algoliasearch.ingestion.models.run_outcome import RunOutcome
from algoliasearch.ingestion.models.run_progress import RunProgress
from algoliasearch.ingestion.models.run_reason_code import RunReasonCode
from algoliasearch.ingestion.models.run_status import RunStatus
from algoliasearch.ingestion.models.run_type import RunType


class Run(BaseModel):
    """
    Run
    """

    run_id: StrictStr = Field(
        description="Universally unique identifier (UUID) of a task run.", alias="runID"
    )
    app_id: StrictStr = Field(alias="appID")
    task_id: StrictStr = Field(
        description="Universally unique identifier (UUID) of a task.", alias="taskID"
    )
    status: RunStatus
    progress: Optional[RunProgress] = None
    outcome: Optional[RunOutcome] = None
    failure_threshold: Optional[Annotated[int, Field(le=100, strict=True, ge=0)]] = (
        Field(
            default=None,
            description="Maximum accepted percentage of failures for a task run to finish successfully.",
            alias="failureThreshold",
        )
    )
    reason: Optional[StrictStr] = Field(
        default=None, description="More information about the task run's outcome."
    )
    reason_code: Optional[RunReasonCode] = Field(default=None, alias="reasonCode")
    type: RunType
    created_at: StrictStr = Field(
        description="Date of creation in RFC 3339 format.", alias="createdAt"
    )
    started_at: Optional[StrictStr] = Field(
        default=None, description="Date of start in RFC 3339 format.", alias="startedAt"
    )
    finished_at: Optional[StrictStr] = Field(
        default=None,
        description="Date of finish in RFC 3339 format.",
        alias="finishedAt",
    )

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of Run from a JSON string"""
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
        if self.progress:
            _dict["progress"] = self.progress.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of Run from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "runID": obj.get("runID"),
                "appID": obj.get("appID"),
                "taskID": obj.get("taskID"),
                "status": obj.get("status"),
                "progress": (
                    RunProgress.from_dict(obj.get("progress"))
                    if obj.get("progress") is not None
                    else None
                ),
                "outcome": obj.get("outcome"),
                "failureThreshold": obj.get("failureThreshold"),
                "reason": obj.get("reason"),
                "reasonCode": obj.get("reasonCode"),
                "type": obj.get("type"),
                "createdAt": obj.get("createdAt"),
                "startedAt": obj.get("startedAt"),
                "finishedAt": obj.get("finishedAt"),
            }
        )
        return _obj
