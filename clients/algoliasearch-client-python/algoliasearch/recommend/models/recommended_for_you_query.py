# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, Optional, Union

from pydantic import BaseModel, ConfigDict, Field, StrictStr

if version_info >= (3, 11):
    from typing import Annotated, Self
else:
    from typing_extensions import Annotated, Self


from algoliasearch.recommend.models.fallback_params import FallbackParams
from algoliasearch.recommend.models.recommend_search_params import RecommendSearchParams
from algoliasearch.recommend.models.recommended_for_you_model import (
    RecommendedForYouModel,
)


class RecommendedForYouQuery(BaseModel):
    """
    RecommendedForYouQuery
    """

    index_name: StrictStr = Field(
        description="Index name (case-sensitive).", alias="indexName"
    )
    threshold: Union[
        Annotated[float, Field(le=100, strict=True, ge=0)],
        Annotated[int, Field(le=100, strict=True, ge=0)],
    ] = Field(
        description="Minimum score a recommendation must have to be included in the response."
    )
    max_recommendations: Optional[Annotated[int, Field(le=1000, strict=True, ge=1)]] = (
        Field(
            default=30,
            description="Maximum number of recommendations to retrieve. By default, all recommendations are returned and no fallback request is made. Depending on the available recommendations and the other request parameters, the actual number of recommendations may be lower than this value. ",
            alias="maxRecommendations",
        )
    )
    query_parameters: Optional[RecommendSearchParams] = Field(
        default=None, alias="queryParameters"
    )
    model: RecommendedForYouModel
    fallback_parameters: Optional[FallbackParams] = Field(
        default=None, alias="fallbackParameters"
    )

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of RecommendedForYouQuery from a JSON string"""
        return cls.from_dict(loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias.

        This has the following differences from calling pydantic's
        `self.model_dump(by_alias=True)`:

        * `None` is only added to the output dict for nullable fields that
          were set at model initialization. Other fields with value `None`
          are ignored.
        """
        _dict = self.model_dump(
            by_alias=True,
            exclude={},
            exclude_none=True,
        )
        if self.query_parameters:
            _dict["queryParameters"] = self.query_parameters.to_dict()
        if self.fallback_parameters:
            _dict["fallbackParameters"] = self.fallback_parameters.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of RecommendedForYouQuery from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "indexName": obj.get("indexName"),
                "threshold": obj.get("threshold"),
                "maxRecommendations": obj.get("maxRecommendations"),
                "queryParameters": (
                    RecommendSearchParams.from_dict(obj.get("queryParameters"))
                    if obj.get("queryParameters") is not None
                    else None
                ),
                "model": obj.get("model"),
                "fallbackParameters": (
                    FallbackParams.from_dict(obj.get("fallbackParameters"))
                    if obj.get("fallbackParameters") is not None
                    else None
                ),
            }
        )
        return _obj
