# coding: utf-8

"""
    Search API

    Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json


from typing import Optional
from pydantic import BaseModel, Field, StrictInt, StrictStr

class SaveObjectResponse(BaseModel):
    """
    SaveObjectResponse
    """
    created_at: StrictStr = Field(..., alias="createdAt", description="Date of creation (ISO-8601 format).")
    task_id: StrictInt = Field(..., alias="taskID", description="Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the `task` operation and this `taskID`. ")
    object_id: Optional[StrictStr] = Field(None, alias="objectID", description="Unique object identifier.")
    __properties = ["createdAt", "taskID", "objectID"]

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
    def from_json(cls, json_str: str) -> SaveObjectResponse:
        """Create an instance of SaveObjectResponse from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True,
                          exclude={
                          },
                          exclude_none=True)
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> SaveObjectResponse:
        """Create an instance of SaveObjectResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return SaveObjectResponse.parse_obj(obj)

        _obj = SaveObjectResponse.parse_obj({
            "created_at": obj.get("createdAt"),
            "task_id": obj.get("taskID"),
            "object_id": obj.get("objectID")
        })
        return _obj


