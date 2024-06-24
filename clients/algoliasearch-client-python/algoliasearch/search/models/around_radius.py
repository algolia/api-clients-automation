# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import dumps, loads
from typing import Annotated, Dict, Optional, Self, Union

from pydantic import BaseModel, Field, ValidationError, model_serializer

from algoliasearch.search.models.around_radius_all import AroundRadiusAll


class AroundRadius(BaseModel):
    """
    Maximum radius for a search around a central location.  This parameter works in combination with the `aroundLatLng` and `aroundLatLngViaIP` parameters. By default, the search radius is determined automatically from the density of hits around the central location. The search radius is small if there are many hits close to the central coordinates.
    """

    oneof_schema_1_validator: Optional[Annotated[int, Field(strict=True, ge=1)]] = (
        Field(
            default=None,
            description="Maximum search radius around a central location in meters.",
        )
    )
    oneof_schema_2_validator: Optional[AroundRadiusAll] = None
    actual_instance: Optional[Union[AroundRadiusAll, int]] = None

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
    def unwrap_actual_instance(self) -> Optional[Union[AroundRadiusAll, int]]:
        """
        Unwraps the `actual_instance` when calling the `to_json` method.
        """
        return self.actual_instance

    @classmethod
    def from_dict(cls, obj: dict) -> Self:
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
            instance.actual_instance = AroundRadiusAll.from_json(json_str)

            return instance
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))

        raise ValueError(
            "No match found when deserializing the JSON string into AroundRadius with oneOf schemas: AroundRadiusAll, int. Details: "
            + ", ".join(error_messages)
        )

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
            return self.actual_instance
