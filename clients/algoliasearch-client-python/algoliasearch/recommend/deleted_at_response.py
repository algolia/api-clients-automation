# coding: utf-8

"""
    Recommend API

    The Recommend API lets you generate recommendations with several AI models.  > **Note**: You should use Algolia's [libraries and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) to interact with the Recommend API. Using the HTTP endpoints directly is not covered by the [SLA](https://www.algolia.com/policies/sla/).

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json



from pydantic import BaseModel, Field, StrictInt, StrictStr

class DeletedAtResponse(BaseModel):
    """
    Response, taskID, and deletion timestamp.  # noqa: E501
    """
    task_id: StrictInt = Field(..., alias="taskID", description="Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the `task` operation and this `taskID`. ")
    deleted_at: StrictStr = Field(..., alias="deletedAt", description="Timestamp of deletion in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.")
    __properties = ["taskID", "deletedAt"]

    class Config:
        """Pydantic configuration"""
        allow_population_by_field_name = True
        validate_assignment = True

    def to_str(self) -> str:
        """Returns the string representation of the model using alias"""
        return pprint.pformat(self.dict(by_alias=True))

    def to_json(self) -> str:
        """Returns the JSON representation of the model using alias"""
        return json.dumps(self.to_dict())

    @classmethod
    def from_json(cls, json_str: str) -> DeletedAtResponse:
        """Create an instance of DeletedAtResponse from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True,
                          exclude={
                          },
                          exclude_none=True)
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> DeletedAtResponse:
        """Create an instance of DeletedAtResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return DeletedAtResponse.parse_obj(obj)

        _obj = DeletedAtResponse.parse_obj({
            "task_id": obj.get("taskID"),
            "deleted_at": obj.get("deletedAt")
        })
        return _obj


