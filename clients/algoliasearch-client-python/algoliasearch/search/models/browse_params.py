# coding: utf-8

"""
    Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

import json
import pprint
from typing import Dict, List, Optional, Union

from pydantic import BaseModel, ValidationError, field_validator
from search.models.browse_params_object import BrowseParamsObject
from search.models.search_params_string import SearchParamsString
from typing_extensions import Literal

try:
    from typing import Self
except ImportError:
    from typing_extensions import Self

BROWSEPARAMS_ONE_OF_SCHEMAS = ["BrowseParamsObject", "SearchParamsString"]


class BrowseParams(BaseModel):
    """
    BrowseParams
    """

    # data type: SearchParamsString
    oneof_schema_1_validator: Optional[SearchParamsString] = None
    # data type: BrowseParamsObject
    oneof_schema_2_validator: Optional[BrowseParamsObject] = None
    actual_instance: Optional[Union[BrowseParamsObject, SearchParamsString]] = None
    one_of_schemas: List[str] = Literal["BrowseParamsObject", "SearchParamsString"]

    model_config = {"validate_assignment": True}

    def __init__(self, *args, **kwargs) -> None:
        if args:
            if len(args) > 1:
                raise ValueError(
                    "If a position argument is used, only 1 is allowed to set `actual_instance`"
                )
            if kwargs:
                raise ValueError(
                    "If a position argument is used, keyword arguments cannot be used."
                )
            super().__init__(actual_instance=args[0])
        else:
            super().__init__(**kwargs)

    @field_validator("actual_instance")
    def actual_instance_must_validate_oneof(cls, v):
        BrowseParams.model_construct()
        error_messages = []
        match = 0
        # validate data type: SearchParamsString
        if not isinstance(v, SearchParamsString):
            error_messages.append(
                f"Error! Input type `{type(v)}` is not `SearchParamsString`"
            )  # noqa: E501
        else:
            match += 1
        # validate data type: BrowseParamsObject
        if not isinstance(v, BrowseParamsObject):
            error_messages.append(
                f"Error! Input type `{type(v)}` is not `BrowseParamsObject`"
            )  # noqa: E501
        else:
            match += 1
        if match > 1:
            # more than 1 match
            raise ValueError(
                "Multiple matches found when setting `actual_instance` in BrowseParams with oneOf schemas: BrowseParamsObject, SearchParamsString. Details: "
                + ", ".join(error_messages)
            )
        elif match == 0:
            # no match
            raise ValueError(
                "No match found when setting `actual_instance` in BrowseParams with oneOf schemas: BrowseParamsObject, SearchParamsString. Details: "
                + ", ".join(error_messages)
            )
        else:
            return v

    @classmethod
    def from_dict(cls, obj: dict) -> Self:
        return cls.from_json(json.dumps(obj))

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Returns the object represented by the json string"""
        instance = cls.model_construct()
        error_messages = []
        match = 0

        # deserialize data into SearchParamsString
        try:
            instance.actual_instance = SearchParamsString.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into BrowseParamsObject
        try:
            instance.actual_instance = BrowseParamsObject.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))

        if match > 1:
            # more than 1 match
            raise ValueError(
                "Multiple matches found when deserializing the JSON string into BrowseParams with oneOf schemas: BrowseParamsObject, SearchParamsString. Details: "
                + ", ".join(error_messages)
            )
        elif match == 0:
            # no match
            raise ValueError(
                "No match found when deserializing the JSON string into BrowseParams with oneOf schemas: BrowseParamsObject, SearchParamsString. Details: "
                + ", ".join(error_messages)
            )
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

    def to_dict(self) -> Dict:
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
        return pprint.pformat(self.model_dump())
