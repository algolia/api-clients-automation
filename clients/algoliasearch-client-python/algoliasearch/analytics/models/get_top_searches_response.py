# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import dumps
from sys import version_info
from typing import Dict, Optional, Union

from pydantic import BaseModel, ValidationError, model_serializer

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.analytics.models.top_searches_response import TopSearchesResponse
from algoliasearch.analytics.models.top_searches_response_with_analytics import (
    TopSearchesResponseWithAnalytics,
)
from algoliasearch.analytics.models.top_searches_response_with_revenue_analytics import (
    TopSearchesResponseWithRevenueAnalytics,
)


class GetTopSearchesResponse(BaseModel):
    """
    GetTopSearchesResponse
    """

    oneof_schema_1_validator: Optional[TopSearchesResponse] = None
    oneof_schema_2_validator: Optional[TopSearchesResponseWithAnalytics] = None
    oneof_schema_3_validator: Optional[TopSearchesResponseWithRevenueAnalytics] = None
    actual_instance: Optional[
        Union[
            TopSearchesResponse,
            TopSearchesResponseWithAnalytics,
            TopSearchesResponseWithRevenueAnalytics,
        ]
    ] = None

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
    def unwrap_actual_instance(
        self,
    ) -> Optional[
        Union[
            TopSearchesResponse,
            TopSearchesResponseWithAnalytics,
            TopSearchesResponseWithRevenueAnalytics,
        ]
    ]:
        """
        Unwraps the `actual_instance` when calling the `to_json` method.
        """
        return self.actual_instance if hasattr(self, "actual_instance") else self

    @classmethod
    def from_dict(cls, obj: dict) -> Self:
        return cls.from_json(dumps(obj))

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Returns the object represented by the json string"""
        instance = cls.model_construct()
        error_messages = []

        try:
            instance.actual_instance = TopSearchesResponse.from_json(json_str)

            return instance
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        try:
            instance.actual_instance = TopSearchesResponseWithAnalytics.from_json(
                json_str
            )

            return instance
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        try:
            instance.actual_instance = (
                TopSearchesResponseWithRevenueAnalytics.from_json(json_str)
            )

            return instance
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))

        raise ValueError(
            "No match found when deserializing the JSON string into GetTopSearchesResponse with oneOf schemas: TopSearchesResponse, TopSearchesResponseWithAnalytics, TopSearchesResponseWithRevenueAnalytics. Details: "
            + ", ".join(error_messages)
        )

    def to_json(self) -> str:
        """Returns the JSON representation of the actual instance"""
        if self.actual_instance is None:
            return "null"

        if hasattr(self.actual_instance, "to_json"):
            return self.actual_instance.to_json()
        else:
            return dumps(self.actual_instance)

    def to_dict(self) -> Dict:
        """Returns the dict representation of the actual instance"""
        if self.actual_instance is None:
            return None

        if hasattr(self.actual_instance, "to_dict"):
            return self.actual_instance.to_dict()
        else:
            return self.actual_instance
