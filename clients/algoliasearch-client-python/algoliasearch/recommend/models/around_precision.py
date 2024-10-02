# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import dumps, loads
from sys import version_info
from typing import Any, Dict, List, Optional, Set, Union

from pydantic import BaseModel, Field, ValidationError, model_serializer

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.recommend.models.range import Range


class AroundPrecision(BaseModel):
    """
    Precision of a coordinate-based search in meters to group results with similar distances.  The Geo ranking criterion considers all matches within the same range of distances to be equal.
    """

    oneof_schema_1_validator: Optional[int] = Field(default=None)
    """ Distance in meters to group results by similar distances.  For example, if you set `aroundPrecision` to 100, records wihin 100 meters to the central coordinate are considered to have the same distance, as are records between 100 and 199 meters.  """
    oneof_schema_2_validator: Optional[List[Range]] = Field(default=None)

    actual_instance: Optional[Union[List[Range], int]] = None
    one_of_schemas: Set[str] = {"List[Range]", "int"}

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

    @model_serializer
    def unwrap_actual_instance(self) -> Optional[Union[List[Range], int]]:
        """
        Unwraps the `actual_instance` when calling the `to_json` method.
        """
        return self.actual_instance if hasattr(self, "actual_instance") else self

    @classmethod
    def from_dict(cls, obj: Union[str, Dict[str, Any]]) -> Self:
        """Create an instance of AroundPrecision from a JSON string"""
        return cls.from_json(dumps(obj))

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Returns the object represented by the json string"""
        instance = cls.model_construct()
        error_messages = []

        try:
            instance.oneof_schema_1_validator = loads(json_str)
            instance.actual_instance = instance.oneof_schema_1_validator

            return instance
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        try:
            instance.oneof_schema_2_validator = loads(json_str)
            instance.actual_instance = instance.oneof_schema_2_validator

            return instance
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))

        raise ValueError(
            "No match found when deserializing the JSON string into AroundPrecision with oneOf schemas: List[Range], int. Details: "
            + ", ".join(error_messages)
        )

    def to_json(self) -> str:
        """Returns the JSON representation of the actual instance"""
        if self.actual_instance is None:
            return "null"

        if hasattr(self.actual_instance, "to_json") and callable(
            self.actual_instance.to_json
        ):
            return self.actual_instance.to_json()
        else:
            return dumps(self.actual_instance)

    def to_dict(self) -> Optional[Union[Dict[str, Any], List[Range], int]]:
        """Returns the dict representation of the actual instance"""
        if self.actual_instance is None:
            return None

        if hasattr(self.actual_instance, "to_dict") and callable(
            self.actual_instance.to_dict
        ):
            return self.actual_instance.to_dict()
        else:
            return self.actual_instance
