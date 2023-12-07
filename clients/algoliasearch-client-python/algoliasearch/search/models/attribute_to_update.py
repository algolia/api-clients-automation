# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import dumps, loads
from typing import Dict, List, Optional, Union

from pydantic import BaseModel, Field, StrictStr, ValidationError, field_validator
from typing_extensions import Literal

from algoliasearch.search.models.built_in_operation import BuiltInOperation

try:
    from typing import Self
except ImportError:
    from typing_extensions import Self

ATTRIBUTETOUPDATE_ONE_OF_SCHEMAS = ["BuiltInOperation", "str"]


class AttributeToUpdate(BaseModel):
    """
    AttributeToUpdate
    """

    # data type: str
    oneof_schema_1_validator: Optional[StrictStr] = Field(
        default=None, description="Value of the attribute to be updated."
    )
    # data type: BuiltInOperation
    oneof_schema_2_validator: Optional[BuiltInOperation] = None
    actual_instance: Optional[Union[BuiltInOperation, str]] = None
    one_of_schemas: List[str] = Literal["BuiltInOperation", "str"]

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
        instance = AttributeToUpdate.model_construct()
        error_messages = []
        match = 0
        # validate data type: str
        try:
            instance.oneof_schema_1_validator = v
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # validate data type: BuiltInOperation
        if not isinstance(v, BuiltInOperation):
            error_messages.append(f"""Type '{type(v)}' is not 'BuiltInOperation'""")
        else:
            match += 1
        if match > 1:
            # more than 1 match
            raise ValueError(
                "Multiple matches found when setting `actual_instance` in AttributeToUpdate with oneOf schemas: BuiltInOperation, str. Details: "
                + ", ".join(error_messages)
            )
        elif match == 0:
            # no match
            raise ValueError(
                "No match found when setting `actual_instance` in AttributeToUpdate with oneOf schemas: BuiltInOperation, str. Details: "
                + ", ".join(error_messages)
            )
        else:
            return v

    @classmethod
    def from_dict(cls, obj: dict) -> Self:
        return cls.from_json(dumps(obj))

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Returns the object represented by the json string"""
        instance = cls.model_construct()
        error_messages = []
        match = 0

        # deserialize data into str
        try:
            # validation
            instance.oneof_schema_1_validator = loads(json_str)
            # assign value to actual_instance
            instance.actual_instance = instance.oneof_schema_1_validator
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into BuiltInOperation
        try:
            instance.actual_instance = BuiltInOperation.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))

        if match > 1:
            # more than 1 match
            raise ValueError(
                "Multiple matches found when deserializing the JSON string into AttributeToUpdate with oneOf schemas: BuiltInOperation, str. Details: "
                + ", ".join(error_messages)
            )
        elif match == 0:
            # no match
            raise ValueError(
                "No match found when deserializing the JSON string into AttributeToUpdate with oneOf schemas: BuiltInOperation, str. Details: "
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
            return dumps(self.actual_instance)

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
