# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import dumps
from sys import version_info
from typing import Any, Dict, Optional, Set, Union

from pydantic import BaseModel, Field, ValidationError, model_serializer

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.search.models.promote_object_id import PromoteObjectID
from algoliasearch.search.models.promote_object_ids import PromoteObjectIDs


class Promote(BaseModel):
    """
    Promote
    """

    oneof_schema_1_validator: Optional[PromoteObjectIDs] = Field(default=None)

    oneof_schema_2_validator: Optional[PromoteObjectID] = Field(default=None)

    actual_instance: Union[PromoteObjectID, PromoteObjectIDs, None] = None
    one_of_schemas: Set[str] = {"PromoteObjectID", "PromoteObjectIDs"}

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
            super().__init__(actual_instance=args[0])  # pyright: ignore
        else:
            super().__init__(**kwargs)

    @model_serializer
    def unwrap_actual_instance(
        self,
    ) -> Union[PromoteObjectID, PromoteObjectIDs, Self, None]:
        """
        Unwraps the `actual_instance` when calling the `to_json` method.
        """
        return self.actual_instance if hasattr(self, "actual_instance") else self

    @classmethod
    def from_dict(cls, obj: Union[str, Dict[str, Any]]) -> Self:
        """Create an instance of Promote from a JSON string"""
        return cls.from_json(dumps(obj))

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Returns the object represented by the json string"""
        instance = cls.model_construct()
        error_messages = []

        try:
            instance.actual_instance = PromoteObjectIDs.from_json(json_str)

            return instance
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        try:
            instance.actual_instance = PromoteObjectID.from_json(json_str)

            return instance
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))

        raise ValueError(
            "No match found when deserializing the JSON string into Promote with oneOf schemas: PromoteObjectID, PromoteObjectIDs. Details: "
            + ", ".join(error_messages)
        )

    def to_json(self) -> str:
        """Returns the JSON representation of the actual instance"""
        if self.actual_instance is None:
            return "null"

        if hasattr(self.actual_instance, "to_json") and callable(
            self.actual_instance.to_json  # pyright: ignore
        ):
            return self.actual_instance.to_json()  # pyright: ignore
        else:
            return dumps(self.actual_instance)

    def to_dict(
        self,
    ) -> Optional[Union[Dict[str, Any], PromoteObjectID, PromoteObjectIDs]]:
        """Returns the dict representation of the actual instance"""
        if self.actual_instance is None:
            return None

        if hasattr(self.actual_instance, "to_dict") and callable(
            self.actual_instance.to_dict  # pyright: ignore
        ):
            return self.actual_instance.to_dict()  # pyright: ignore
        else:
            return self.actual_instance  # pyright: ignore
