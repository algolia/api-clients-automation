# coding: utf-8

"""
    Recommend API

    The Recommend API lets you generate recommendations with several AI models.  > **Note**: You should use Algolia's [libraries and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) to interact with the Recommend API. Using the HTTP endpoints directly is not covered by the [SLA](https://www.algolia.com/policies/sla/).

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
from inspect import getfullargspec
import json
import pprint
import re  # noqa: F401

from typing import Any, List, Optional
from pydantic import BaseModel, Field, StrictBool, StrictStr, ValidationError, conlist, validator
from typing import Union, Any, List, TYPE_CHECKING
from pydantic import StrictStr, Field

REMOVESTOPWORDS_ONE_OF_SCHEMAS = ["List[str]", "bool"]

class RemoveStopWords(BaseModel):
    """
    Removes stop (common) words from the query before executing it. `removeStopWords` is used in conjunction with the `queryLanguages` setting. _list_: language ISO codes for which stop words should be enabled. This list will override any values that you may have set in `queryLanguages`. _true_: enables the stop words feature, ensuring that stop words are removed from consideration in a search. The languages supported here are either [every language](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/) (this is the default) or those set by `queryLanguages`. _false_: turns off the stop words feature, allowing stop words to be taken into account in a search. 
    """
    # data type: List[str]
    oneof_schema_1_validator: Optional[conlist(StrictStr)] = None
    # data type: bool
    oneof_schema_2_validator: Optional[StrictBool] = False
    if TYPE_CHECKING:
        actual_instance: Union[List[str], bool]
    else:
        actual_instance: Any
    one_of_schemas: List[str] = Field(REMOVESTOPWORDS_ONE_OF_SCHEMAS, const=True)

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
        instance = RemoveStopWords.construct()
        error_messages = []
        match = 0
        # validate data type: List[str]
        try:
            instance.oneof_schema_1_validator = v
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # validate data type: bool
        try:
            instance.oneof_schema_2_validator = v
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        if match > 1:
            # more than 1 match
            raise ValueError("Multiple matches found when setting `actual_instance` in RemoveStopWords with oneOf schemas: List[str], bool. Details: " + ", ".join(error_messages))
        elif match == 0:
            # no match
            raise ValueError("No match found when setting `actual_instance` in RemoveStopWords with oneOf schemas: List[str], bool. Details: " + ", ".join(error_messages))
        else:
            return v

    @classmethod
    def from_dict(cls, obj: dict) -> RemoveStopWords:
        return cls.from_json(json.dumps(obj))

    @classmethod
    def from_json(cls, json_str: str) -> RemoveStopWords:
        """Returns the object represented by the json string"""
        instance = RemoveStopWords.construct()
        error_messages = []
        match = 0

        # deserialize data into List[str]
        try:
            # validation
            instance.oneof_schema_1_validator = json.loads(json_str)
            # assign value to actual_instance
            instance.actual_instance = instance.oneof_schema_1_validator
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into bool
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
            raise ValueError("Multiple matches found when deserializing the JSON string into RemoveStopWords with oneOf schemas: List[str], bool. Details: " + ", ".join(error_messages))
        elif match == 0:
            # no match
            raise ValueError("No match found when deserializing the JSON string into RemoveStopWords with oneOf schemas: List[str], bool. Details: " + ", ".join(error_messages))
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


