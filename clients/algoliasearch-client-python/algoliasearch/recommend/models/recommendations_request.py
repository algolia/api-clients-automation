# coding: utf-8

"""
    Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

import json
import pprint
from typing import Dict, List, Optional, Union

from pydantic import BaseModel, ValidationError, field_validator
from recommend.models.recommendations_query import RecommendationsQuery
from recommend.models.trending_facets_query import TrendingFacetsQuery
from recommend.models.trending_items_query import TrendingItemsQuery
from typing_extensions import Literal

try:
    from typing import Self
except ImportError:
    from typing_extensions import Self

RECOMMENDATIONSREQUEST_ONE_OF_SCHEMAS = [
    "RecommendationsQuery",
    "TrendingFacetsQuery",
    "TrendingItemsQuery",
]


class RecommendationsRequest(BaseModel):
    """
    RecommendationsRequest
    """

    # data type: TrendingItemsQuery
    oneof_schema_1_validator: Optional[TrendingItemsQuery] = None
    # data type: TrendingFacetsQuery
    oneof_schema_2_validator: Optional[TrendingFacetsQuery] = None
    # data type: RecommendationsQuery
    oneof_schema_3_validator: Optional[RecommendationsQuery] = None
    actual_instance: Optional[
        Union[RecommendationsQuery, TrendingFacetsQuery, TrendingItemsQuery]
    ] = None
    one_of_schemas: List[str] = Literal[
        "RecommendationsQuery", "TrendingFacetsQuery", "TrendingItemsQuery"
    ]

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
        RecommendationsRequest.model_construct()
        error_messages = []
        match = 0
        # validate data type: TrendingItemsQuery
        if not isinstance(v, TrendingItemsQuery):
            error_messages.append(
                f"Error! Input type `{type(v)}` is not `TrendingItemsQuery`"
            )  # noqa: E501
        else:
            match += 1
        # validate data type: TrendingFacetsQuery
        if not isinstance(v, TrendingFacetsQuery):
            error_messages.append(
                f"Error! Input type `{type(v)}` is not `TrendingFacetsQuery`"
            )  # noqa: E501
        else:
            match += 1
        # validate data type: RecommendationsQuery
        if not isinstance(v, RecommendationsQuery):
            error_messages.append(
                f"Error! Input type `{type(v)}` is not `RecommendationsQuery`"
            )  # noqa: E501
        else:
            match += 1
        if match > 1:
            # more than 1 match
            raise ValueError(
                "Multiple matches found when setting `actual_instance` in RecommendationsRequest with oneOf schemas: RecommendationsQuery, TrendingFacetsQuery, TrendingItemsQuery. Details: "
                + ", ".join(error_messages)
            )
        elif match == 0:
            # no match
            raise ValueError(
                "No match found when setting `actual_instance` in RecommendationsRequest with oneOf schemas: RecommendationsQuery, TrendingFacetsQuery, TrendingItemsQuery. Details: "
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

        # deserialize data into TrendingItemsQuery
        try:
            instance.actual_instance = TrendingItemsQuery.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into TrendingFacetsQuery
        try:
            instance.actual_instance = TrendingFacetsQuery.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into RecommendationsQuery
        try:
            instance.actual_instance = RecommendationsQuery.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))

        if match > 1:
            # more than 1 match
            raise ValueError(
                "Multiple matches found when deserializing the JSON string into RecommendationsRequest with oneOf schemas: RecommendationsQuery, TrendingFacetsQuery, TrendingItemsQuery. Details: "
                + ", ".join(error_messages)
            )
        elif match == 0:
            # no match
            raise ValueError(
                "No match found when deserializing the JSON string into RecommendationsRequest with oneOf schemas: RecommendationsQuery, TrendingFacetsQuery, TrendingItemsQuery. Details: "
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
