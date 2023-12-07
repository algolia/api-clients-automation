# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import dumps, loads
from typing import Dict, List, Optional, Union

from pydantic import BaseModel, StrictStr, ValidationError, field_validator
from typing_extensions import Literal

from algoliasearch.search.models.mixed_search_filters import MixedSearchFilters

try:
    from typing import Self
except ImportError:
    from typing_extensions import Self

RERANKINGAPPLYFILTER_ONE_OF_SCHEMAS = ["List[MixedSearchFilters]", "str"]


class ReRankingApplyFilter(BaseModel):
    """
    When [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/) is enabled, only records that match these filters will be affected by Dynamic Re-Ranking.
    """

    # data type: List[MixedSearchFilters]
    oneof_schema_1_validator: Optional[List[MixedSearchFilters]] = None
    # data type: str
    oneof_schema_2_validator: Optional[StrictStr] = None
    actual_instance: Optional[Union[List[MixedSearchFilters], str]] = None
    one_of_schemas: List[str] = Literal["List[MixedSearchFilters]", "str"]

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
        if v is None:
            return v

        instance = ReRankingApplyFilter.model_construct()
        error_messages = []
        match = 0
        # validate data type: List[MixedSearchFilters]
        try:
            instance.oneof_schema_1_validator = v
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # validate data type: str
        try:
            instance.oneof_schema_2_validator = v
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        if match > 1:
            # more than 1 match
            raise ValueError(
                "Multiple matches found when setting `actual_instance` in ReRankingApplyFilter with oneOf schemas: List[MixedSearchFilters], str. Details: "
                + ", ".join(error_messages)
            )
        elif match == 0:
            # no match
            raise ValueError(
                "No match found when setting `actual_instance` in ReRankingApplyFilter with oneOf schemas: List[MixedSearchFilters], str. Details: "
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
        if json_str is None:
            return instance

        error_messages = []
        match = 0

        # deserialize data into List[MixedSearchFilters]
        try:
            # validation
            instance.oneof_schema_1_validator = loads(json_str)
            # assign value to actual_instance
            instance.actual_instance = instance.oneof_schema_1_validator
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into str
        try:
            # validation
            instance.oneof_schema_2_validator = loads(json_str)
            # assign value to actual_instance
            instance.actual_instance = instance.oneof_schema_2_validator
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))

        if match > 1:
            # more than 1 match
            raise ValueError(
                "Multiple matches found when deserializing the JSON string into ReRankingApplyFilter with oneOf schemas: List[MixedSearchFilters], str. Details: "
                + ", ".join(error_messages)
            )
        elif match == 0:
            # no match
            raise ValueError(
                "No match found when deserializing the JSON string into ReRankingApplyFilter with oneOf schemas: List[MixedSearchFilters], str. Details: "
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
