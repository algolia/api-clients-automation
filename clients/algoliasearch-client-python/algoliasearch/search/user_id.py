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



from pydantic import BaseModel, Field, StrictInt, StrictStr, constr, validator

class UserId(BaseModel):
    """
    Unique user ID.  # noqa: E501
    """
    user_id: constr(strict=True) = Field(..., alias="userID", description="userID of the user.")
    cluster_name: StrictStr = Field(..., alias="clusterName", description="Cluster to which the user is assigned.")
    nb_records: StrictInt = Field(..., alias="nbRecords", description="Number of records belonging to the user.")
    data_size: StrictInt = Field(..., alias="dataSize", description="Data size used by the user.")
    __properties = ["userID", "clusterName", "nbRecords", "dataSize"]

    @validator('user_id')
    def user_id_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not re.match(r"^[a-zA-Z0-9 \-*.]+$", value):
            raise ValueError(r"must validate the regular expression /^[a-zA-Z0-9 \-*.]+$/")
        return value

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
    def from_json(cls, json_str: str) -> UserId:
        """Create an instance of UserId from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True,
                          exclude={
                          },
                          exclude_none=True)
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> UserId:
        """Create an instance of UserId from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return UserId.parse_obj(obj)

        _obj = UserId.parse_obj({
            "user_id": obj.get("userID"),
            "cluster_name": obj.get("clusterName"),
            "nb_records": obj.get("nbRecords"),
            "data_size": obj.get("dataSize")
        })
        return _obj


