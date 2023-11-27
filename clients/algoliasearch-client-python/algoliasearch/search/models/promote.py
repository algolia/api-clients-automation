# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

import json
import pprint
from typing import Dict, List, Optional, Union

from pydantic import BaseModel, ValidationError, field_validator
from typing_extensions import Literal

from algoliasearch.search.models.promote_object_id import PromoteObjectID
from algoliasearch.search.models.promote_object_ids import PromoteObjectIDs

try:
    from typing import Self
except ImportError:
    from typing_extensions import Self

PROMOTE_ONE_OF_SCHEMAS = ["PromoteObjectID", "PromoteObjectIDs"]


class Promote(BaseModel):
    """
    Promote
    """

    # data type: PromoteObjectIDs
    oneof_schema_1_validator: Optional[PromoteObjectIDs] = None
    # data type: PromoteObjectID
    oneof_schema_2_validator: Optional[PromoteObjectID] = None
    actual_instance: Optional[Union[PromoteObjectID, PromoteObjectIDs]] = None
    one_of_schemas: List[str] = Literal["PromoteObjectID", "PromoteObjectIDs"]

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
        Promote.model_construct()
        error_messages = []
        match = 0
        # validate data type: PromoteObjectIDs
        if not isinstance(v, PromoteObjectIDs):
            error_messages.append(f"""Type '{type(v)}' is not 'PromoteObjectIDs'""")
        else:
            match += 1
        # validate data type: PromoteObjectID
        if not isinstance(v, PromoteObjectID):
            error_messages.append(f"""Type '{type(v)}' is not 'PromoteObjectID'""")
        else:
            match += 1
        if match > 1:
            # more than 1 match
            raise ValueError(
                "Multiple matches found when setting `actual_instance` in Promote with oneOf schemas: PromoteObjectID, PromoteObjectIDs. Details: "
                + ", ".join(error_messages)
            )
        elif match == 0:
            # no match
            raise ValueError(
                "No match found when setting `actual_instance` in Promote with oneOf schemas: PromoteObjectID, PromoteObjectIDs. Details: "
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

        # deserialize data into PromoteObjectIDs
        try:
            instance.actual_instance = PromoteObjectIDs.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into PromoteObjectID
        try:
            instance.actual_instance = PromoteObjectID.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))

        if match > 1:
            # more than 1 match
            raise ValueError(
                "Multiple matches found when deserializing the JSON string into Promote with oneOf schemas: PromoteObjectID, PromoteObjectIDs. Details: "
                + ", ".join(error_messages)
            )
        elif match == 0:
            # no match
            raise ValueError(
                "No match found when deserializing the JSON string into Promote with oneOf schemas: PromoteObjectID, PromoteObjectIDs. Details: "
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
