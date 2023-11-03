# coding: utf-8

"""
    Search API

    Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import json
import pprint
import re  # noqa: F401

from typing import Any, List, Optional
from pydantic import BaseModel, Field, ValidationError, conlist, validator
from algoliasearch.models.snippet_result_option import SnippetResultOption
from typing import Union, Any, List, TYPE_CHECKING
from pydantic import Field

SNIPPETRESULT_ONE_OF_SCHEMAS = ["List[SnippetResultOption]", "SnippetResultOption"]

class SnippetResult(BaseModel):
    """
    SnippetResult
    """
    # data type: SnippetResultOption
    oneof_schema_1_validator: Optional[SnippetResultOption] = None
    # data type: List[SnippetResultOption]
    oneof_schema_2_validator: Optional[conlist(SnippetResultOption)] = None
    if TYPE_CHECKING:
        actual_instance: Union[List[SnippetResultOption], SnippetResultOption]
    else:
        actual_instance: Any
    one_of_schemas: List[str] = Field(SNIPPETRESULT_ONE_OF_SCHEMAS, const=True)

    class Config:
        validate_assignment = True

    def __init__(self, *args, **kwargs) -> None:
        if args:
            if len(args) > 1:
                raise ValueError("If a position argument is used, only 1 is allowed to set `actual_instance`")
            if kwargs:
                raise ValueError("If a position argument is used, keyword arguments cannot be used.")
            super().__init__(actual_instance=args[0])
        else:
            super().__init__(**kwargs)

    @validator('actual_instance')
    def actual_instance_must_validate_oneof(cls, v):
        instance = SnippetResult.construct()
        error_messages = []
        match = 0
        # validate data type: SnippetResultOption
        if not isinstance(v, SnippetResultOption):
            error_messages.append(f"Error! Input type `{type(v)}` is not `SnippetResultOption`")
        else:
            match += 1
        # validate data type: List[SnippetResultOption]
        try:
            instance.oneof_schema_2_validator = v
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        if match > 1:
            # more than 1 match
            raise ValueError("Multiple matches found when setting `actual_instance` in SnippetResult with oneOf schemas: List[SnippetResultOption], SnippetResultOption. Details: " + ", ".join(error_messages))
        elif match == 0:
            # no match
            raise ValueError("No match found when setting `actual_instance` in SnippetResult with oneOf schemas: List[SnippetResultOption], SnippetResultOption. Details: " + ", ".join(error_messages))
        else:
            return v

    @classmethod
    def from_dict(cls, obj: dict) -> SnippetResult:
        return cls.from_json(json.dumps(obj))

    @classmethod
    def from_json(cls, json_str: str) -> SnippetResult:
        """Returns the object represented by the json string"""
        instance = SnippetResult.construct()
        error_messages = []
        match = 0

        # deserialize data into SnippetResultOption
        try:
            instance.actual_instance = SnippetResultOption.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into List[SnippetResultOption]
        try:
            # validation
            instance.oneof_schema_2_validator = json.loads(json_str)
            # assign value to actual_instance
            instance.actual_instance = instance.oneof_schema_2_validator
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))

        if match > 1:
            # more than 1 match
            raise ValueError("Multiple matches found when deserializing the JSON string into SnippetResult with oneOf schemas: List[SnippetResultOption], SnippetResultOption. Details: " + ", ".join(error_messages))
        elif match == 0:
            # no match
            raise ValueError("No match found when deserializing the JSON string into SnippetResult with oneOf schemas: List[SnippetResultOption], SnippetResultOption. Details: " + ", ".join(error_messages))
        else:
            return instance

    def to_json(self) -> str:
        """Returns the JSON representation of the actual instance"""
        if self.actual_instance is None:
            return "null"

        to_json = getattr(self.actual_instance, "to_json", None)
        if callable(to_json):
            return self.actual_instance.to_json()
        else:
            return json.dumps(self.actual_instance)

    def to_dict(self) -> dict:
        """Returns the dict representation of the actual instance"""
        if self.actual_instance is None:
            return None

        to_dict = getattr(self.actual_instance, "to_dict", None)
        if callable(to_dict):
            return self.actual_instance.to_dict()
        else:
            # primitive type
            return self.actual_instance

    def to_str(self) -> str:
        """Returns the string representation of the actual instance"""
        return pprint.pformat(self.dict())


