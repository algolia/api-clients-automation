# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, Optional

from pydantic import BaseModel, ConfigDict, Field

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.recommend.models.fallback_params import FallbackParams
from algoliasearch.recommend.models.looking_similar_model import LookingSimilarModel
from algoliasearch.recommend.models.recommend_search_params import RecommendSearchParams


class LookingSimilarQuery(BaseModel):
    """
    LookingSimilarQuery
    """

    index_name: str = Field(alias="indexName")
    """ Index name (case-sensitive). """
    threshold: float = Field(alias="threshold")
    """ Minimum score a recommendation must have to be included in the response. """
    max_recommendations: Optional[int] = Field(default=None, alias="maxRecommendations")
    """ Maximum number of recommendations to retrieve. By default, all recommendations are returned and no fallback request is made. Depending on the available recommendations and the other request parameters, the actual number of recommendations may be lower than this value.  """
    query_parameters: Optional[RecommendSearchParams] = Field(
        default=None, alias="queryParameters"
    )
    model: LookingSimilarModel = Field(alias="model")
    object_id: str = Field(alias="objectID")
    """ Unique record identifier. """
    fallback_parameters: Optional[FallbackParams] = Field(
        default=None, alias="fallbackParameters"
    )

    model_config = ConfigDict(
        use_enum_values=True,
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of LookingSimilarQuery from a JSON string"""
        return cls.from_dict(loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias."""
        return self.model_dump(
            by_alias=True,
            exclude_none=True,
            exclude_unset=True,
        )

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of LookingSimilarQuery from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["queryParameters"] = (
            RecommendSearchParams.from_dict(obj["queryParameters"])
            if obj.get("queryParameters") is not None
            else None
        )
        obj["model"] = obj.get("model")
        obj["fallbackParameters"] = (
            FallbackParams.from_dict(obj["fallbackParameters"])
            if obj.get("fallbackParameters") is not None
            else None
        )

        return cls.model_validate(obj)
