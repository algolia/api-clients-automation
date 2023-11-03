# coding: utf-8

"""
    Recommend API

    The Recommend API lets you generate recommendations with several AI models.  > **Note**: You should use Algolia's [libraries and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) to interact with the Recommend API. Using the HTTP endpoints directly is not covered by the [SLA](https://www.algolia.com/policies/sla/).

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json


from typing import Any, Dict, Optional
from pydantic import (
    BaseModel,
    Field,
    StrictBool,
    StrictInt,
    StrictStr,
    conint,
    constr,
    validator,
)
from algoliasearch.models.exhaustive import Exhaustive
from algoliasearch.models.facets_stats import FacetsStats
from algoliasearch.models.redirect import Redirect
from algoliasearch.models.rendering_content import RenderingContent


class BaseSearchResponse(BaseModel):
    """
    BaseSearchResponse
    """

    ab_test_id: Optional[StrictInt] = Field(
        None,
        alias="abTestID",
        description="A/B test ID. This is only included in the response for indices that are part of an A/B test.",
    )
    ab_test_variant_id: Optional[conint(strict=True, ge=1)] = Field(
        None,
        alias="abTestVariantID",
        description="Variant ID. This is only included in the response for indices that are part of an A/B test.",
    )
    around_lat_lng: Optional[constr(strict=True)] = Field(
        None, alias="aroundLatLng", description="Computed geographical location."
    )
    automatic_radius: Optional[StrictStr] = Field(
        None, alias="automaticRadius", description="Automatically-computed radius."
    )
    exhaustive: Optional[Exhaustive] = None
    exhaustive_facets_count: Optional[StrictBool] = Field(
        None,
        alias="exhaustiveFacetsCount",
        description="See the `facetsCount` field of the `exhaustive` object in the response.",
    )
    exhaustive_nb_hits: Optional[StrictBool] = Field(
        None,
        alias="exhaustiveNbHits",
        description="See the `nbHits` field of the `exhaustive` object in the response.",
    )
    exhaustive_typo: Optional[StrictBool] = Field(
        None,
        alias="exhaustiveTypo",
        description="See the `typo` field of the `exhaustive` object in the response.",
    )
    facets: Optional[Dict[str, Dict[str, StrictInt]]] = Field(
        None,
        description="Mapping of each facet name to the corresponding facet counts.",
    )
    facets_stats: Optional[Dict[str, FacetsStats]] = Field(
        None, description="Statistics for numerical facets."
    )
    hits_per_page: conint(strict=True, le=1000, ge=1) = Field(
        ..., alias="hitsPerPage", description="Number of hits per page."
    )
    index: Optional[StrictStr] = Field(
        None, description="Index name used for the query."
    )
    index_used: Optional[StrictStr] = Field(
        None,
        alias="indexUsed",
        description="Index name used for the query. During A/B testing, the targeted index isn't always the index used by the query.",
    )
    message: Optional[StrictStr] = Field(None, description="Warnings about the query.")
    nb_hits: StrictInt = Field(
        ..., alias="nbHits", description="Number of hits the search query matched."
    )
    nb_pages: StrictInt = Field(
        ...,
        alias="nbPages",
        description="Number of pages of results for the current query.",
    )
    nb_sorted_hits: Optional[StrictInt] = Field(
        None,
        alias="nbSortedHits",
        description="Number of hits selected and sorted by the relevant sort algorithm.",
    )
    page: StrictInt = Field(
        ..., description="Page to retrieve (the first page is `0`, not `1`)."
    )
    parsed_query: Optional[StrictStr] = Field(
        None,
        alias="parsedQuery",
        description="Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean) query string that will be searched.",
    )
    processing_time_ms: StrictInt = Field(
        ...,
        alias="processingTimeMS",
        description="Time the server took to process the request, in milliseconds.",
    )
    processing_timings_ms: Optional[Dict[str, Any]] = Field(
        None,
        alias="processingTimingsMS",
        description="Experimental. List of processing steps and their times, in milliseconds. You can use this list to investigate performance issues.",
    )
    query_after_removal: Optional[StrictStr] = Field(
        None,
        alias="queryAfterRemoval",
        description="Markup text indicating which parts of the original query have been removed to retrieve a non-empty result set.",
    )
    redirect: Optional[Redirect] = None
    rendering_content: Optional[RenderingContent] = Field(
        None, alias="renderingContent"
    )
    server_time_ms: Optional[StrictInt] = Field(
        None,
        alias="serverTimeMS",
        description="Time the server took to process the request, in milliseconds.",
    )
    server_used: Optional[StrictStr] = Field(
        None,
        alias="serverUsed",
        description="Host name of the server that processed the request.",
    )
    user_data: Optional[Any] = Field(
        None,
        alias="userData",
        description="Lets you store custom data in your indices.",
    )
    additional_properties: Dict[str, Any] = {}
    __properties = [
        "abTestID",
        "abTestVariantID",
        "aroundLatLng",
        "automaticRadius",
        "exhaustive",
        "exhaustiveFacetsCount",
        "exhaustiveNbHits",
        "exhaustiveTypo",
        "facets",
        "facets_stats",
        "hitsPerPage",
        "index",
        "indexUsed",
        "message",
        "nbHits",
        "nbPages",
        "nbSortedHits",
        "page",
        "parsedQuery",
        "processingTimeMS",
        "processingTimingsMS",
        "queryAfterRemoval",
        "redirect",
        "renderingContent",
        "serverTimeMS",
        "serverUsed",
        "userData",
    ]

    @validator("around_lat_lng")
    def around_lat_lng_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if value is None:
            return value

        if not re.match(r"^(-?\d+(\.\d+)?),\s*(-?\d+(\.\d+)?)$", value):
            raise ValueError(
                r"must validate the regular expression /^(-?\d+(\.\d+)?),\s*(-?\d+(\.\d+)?)$/"
            )
        return value

    class Config:
        """Pydantic configuration"""

        allow_population_by_field_name = True
        validate_assignment = True

    def to_str(self) -> str:
        """Returns the string representation of the model using alias"""
        return pprint.pformat(self.dict(by_alias=True))

    def to_json(self) -> str:
        """Returns the JSON representation of the model using alias"""
        return json.dumps(self.to_dict())

    @classmethod
    def from_json(cls, json_str: str) -> BaseSearchResponse:
        """Create an instance of BaseSearchResponse from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(
            by_alias=True, exclude={"additional_properties"}, exclude_none=True
        )
        # override the default output from pydantic by calling `to_dict()` of exhaustive
        if self.exhaustive:
            _dict["exhaustive"] = self.exhaustive.to_dict()
        # override the default output from pydantic by calling `to_dict()` of each value in facets_stats (dict)
        _field_dict = {}
        if self.facets_stats:
            for _key in self.facets_stats:
                if self.facets_stats[_key]:
                    _field_dict[_key] = self.facets_stats[_key].to_dict()
            _dict["facets_stats"] = _field_dict
        # override the default output from pydantic by calling `to_dict()` of redirect
        if self.redirect:
            _dict["redirect"] = self.redirect.to_dict()
        # override the default output from pydantic by calling `to_dict()` of rendering_content
        if self.rendering_content:
            _dict["renderingContent"] = self.rendering_content.to_dict()
        # puts key-value pairs in additional_properties in the top level
        if self.additional_properties is not None:
            for _key, _value in self.additional_properties.items():
                _dict[_key] = _value

        # set to None if user_data (nullable) is None
        # and __fields_set__ contains the field
        if self.user_data is None and "user_data" in self.__fields_set__:
            _dict["userData"] = None

        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> BaseSearchResponse:
        """Create an instance of BaseSearchResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return BaseSearchResponse.parse_obj(obj)

        _obj = BaseSearchResponse.parse_obj(
            {
                "ab_test_id": obj.get("abTestID"),
                "ab_test_variant_id": obj.get("abTestVariantID"),
                "around_lat_lng": obj.get("aroundLatLng"),
                "automatic_radius": obj.get("automaticRadius"),
                "exhaustive": Exhaustive.from_dict(obj.get("exhaustive"))
                if obj.get("exhaustive") is not None
                else None,
                "exhaustive_facets_count": obj.get("exhaustiveFacetsCount"),
                "exhaustive_nb_hits": obj.get("exhaustiveNbHits"),
                "exhaustive_typo": obj.get("exhaustiveTypo"),
                "facets": obj.get("facets"),
                "facets_stats": dict(
                    (_k, FacetsStats.from_dict(_v))
                    for _k, _v in obj.get("facets_stats").items()
                )
                if obj.get("facets_stats") is not None
                else None,
                "hits_per_page": obj.get("hitsPerPage")
                if obj.get("hitsPerPage") is not None
                else 20,
                "index": obj.get("index"),
                "index_used": obj.get("indexUsed"),
                "message": obj.get("message"),
                "nb_hits": obj.get("nbHits"),
                "nb_pages": obj.get("nbPages"),
                "nb_sorted_hits": obj.get("nbSortedHits"),
                "page": obj.get("page") if obj.get("page") is not None else 0,
                "parsed_query": obj.get("parsedQuery"),
                "processing_time_ms": obj.get("processingTimeMS"),
                "processing_timings_ms": obj.get("processingTimingsMS"),
                "query_after_removal": obj.get("queryAfterRemoval"),
                "redirect": Redirect.from_dict(obj.get("redirect"))
                if obj.get("redirect") is not None
                else None,
                "rendering_content": RenderingContent.from_dict(
                    obj.get("renderingContent")
                )
                if obj.get("renderingContent") is not None
                else None,
                "server_time_ms": obj.get("serverTimeMS"),
                "server_used": obj.get("serverUsed"),
                "user_data": obj.get("userData"),
            }
        )
        # store additional fields in additional_properties
        for _key in obj.keys():
            if _key not in cls.__properties:
                _obj.additional_properties[_key] = obj.get(_key)

        return _obj
