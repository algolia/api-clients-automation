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


from typing import List
from pydantic import BaseModel, Field, StrictInt, StrictStr, conlist

class BatchResponse(BaseModel):
    """
    BatchResponse
    """
    task_id: StrictInt = Field(..., alias="taskID", description="Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the `task` operation and this `taskID`. ")
    object_ids: conlist(StrictStr) = Field(..., alias="objectIDs", description="Unique object (record) identifiers.")
    __properties = ["taskID", "objectIDs"]

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
    def from_json(cls, json_str: str) -> BatchResponse:
        """Create an instance of BatchResponse from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True,
                          exclude={
                          },
                          exclude_none=True)
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> BatchResponse:
        """Create an instance of BatchResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return BatchResponse.parse_obj(obj)

        _obj = BatchResponse.parse_obj({
            "task_id": obj.get("taskID"),
            "object_ids": obj.get("objectIDs")
        })
        return _obj


