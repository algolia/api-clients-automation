# coding: utf-8

"""
    Search API

    Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json


from typing import List, Optional, Union
from pydantic import BaseModel, Field, StrictBool, StrictFloat, StrictInt, StrictStr, conint, conlist
from algoliasearch.models.around_precision import AroundPrecision
from algoliasearch.models.around_radius import AroundRadius
from algoliasearch.models.facet_filters import FacetFilters
from algoliasearch.models.numeric_filters import NumericFilters
from algoliasearch.models.optional_filters import OptionalFilters
from algoliasearch.models.tag_filters import TagFilters

class BaseSearchParams(BaseModel):
    """
    BaseSearchParams
    """
    query: Optional[StrictStr] = Field('', description="Text to search for in an index.")
    similar_query: Optional[StrictStr] = Field('', alias="similarQuery", description="Overrides the query parameter and performs a more generic search.")
    filters: Optional[StrictStr] = Field('', description="[Filter](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/) the query with numeric, facet, or tag filters. ")
    facet_filters: Optional[FacetFilters] = Field(None, alias="facetFilters")
    optional_filters: Optional[OptionalFilters] = Field(None, alias="optionalFilters")
    numeric_filters: Optional[NumericFilters] = Field(None, alias="numericFilters")
    tag_filters: Optional[TagFilters] = Field(None, alias="tagFilters")
    sum_or_filters_scores: Optional[StrictBool] = Field(False, alias="sumOrFiltersScores", description="Determines how to calculate [filter scores](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/filter-scoring/#accumulating-scores-with-sumorfiltersscores). If `false`, maximum score is kept. If `true`, score is summed. ")
    restrict_searchable_attributes: Optional[conlist(StrictStr)] = Field(None, alias="restrictSearchableAttributes", description="Restricts a query to only look at a subset of your [searchable attributes](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/).")
    facets: Optional[conlist(StrictStr)] = Field(None, description="Returns [facets](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#contextual-facet-values-and-counts), their facet values, and the number of matching facet values.")
    faceting_after_distinct: Optional[StrictBool] = Field(False, alias="facetingAfterDistinct", description="Forces faceting to be applied after [de-duplication](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/) (with the distinct feature). Alternatively, the `afterDistinct` [modifier](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers) of `attributesForFaceting` allows for more granular control. ")
    page: Optional[StrictInt] = Field(0, description="Page to retrieve (the first page is `0`, not `1`).")
    offset: Optional[StrictInt] = Field(None, description="Specifies the offset of the first hit to return. > **Note**: Using `page` and `hitsPerPage` is the recommended method for [paging results](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/). However, you can use `offset` and `length` to implement [an alternative approach to paging](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/#retrieving-a-subset-of-records-with-offset-and-length). ")
    length: Optional[conint(strict=True, le=1000, ge=1)] = Field(None, description="Sets the number of hits to retrieve (for use with `offset`). > **Note**: Using `page` and `hitsPerPage` is the recommended method for [paging results](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/). However, you can use `offset` and `length` to implement [an alternative approach to paging](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/#retrieving-a-subset-of-records-with-offset-and-length). ")
    around_lat_lng: Optional[StrictStr] = Field('', alias="aroundLatLng", description="Search for entries [around a central location](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filter-around-a-central-point), enabling a geographical search within a circular area.")
    around_lat_lng_via_ip: Optional[StrictBool] = Field(False, alias="aroundLatLngViaIP", description="Search for entries around a location. The location is automatically computed from the requester's IP address.")
    around_radius: Optional[AroundRadius] = Field(None, alias="aroundRadius")
    around_precision: Optional[AroundPrecision] = Field(None, alias="aroundPrecision")
    minimum_around_radius: Optional[conint(strict=True, ge=1)] = Field(None, alias="minimumAroundRadius", description="Minimum radius (in meters) used for a geographical search when `aroundRadius` isn't set.")
    inside_bounding_box: Optional[conlist(conlist(Union[StrictFloat, StrictInt]))] = Field(None, alias="insideBoundingBox", description="Search inside a [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates).")
    inside_polygon: Optional[conlist(conlist(Union[StrictFloat, StrictInt]))] = Field(None, alias="insidePolygon", description="Search inside a [polygon](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates).")
    natural_languages: Optional[conlist(StrictStr)] = Field(None, alias="naturalLanguages", description="Changes the default values of parameters that work best for a natural language query, such as `ignorePlurals`, `removeStopWords`, `removeWordsIfNoResults`, `analyticsTags`, and `ruleContexts`. These parameters work well together when the query consists of fuller natural language strings instead of keywords, for example when processing voice search queries.")
    rule_contexts: Optional[conlist(StrictStr)] = Field(None, alias="ruleContexts", description="Assigns [rule contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context) to search queries.")
    personalization_impact: Optional[StrictInt] = Field(100, alias="personalizationImpact", description="Defines how much [Personalization affects results](https://www.algolia.com/doc/guides/personalization/personalizing-results/in-depth/configuring-personalization/#understanding-personalization-impact).")
    user_token: Optional[StrictStr] = Field(None, alias="userToken", description="Associates a [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) with the current search.")
    get_ranking_info: Optional[StrictBool] = Field(False, alias="getRankingInfo", description="Incidates whether the search response includes [detailed ranking information](https://www.algolia.com/doc/guides/building-search-ui/going-further/backend-search/in-depth/understanding-the-api-response/#ranking-information).")
    explain: Optional[conlist(StrictStr)] = Field(None, description="Enriches the API's response with information about how the query was processed.")
    synonyms: Optional[StrictBool] = Field(True, description="Whether to take into account an index's synonyms for a particular search.")
    click_analytics: Optional[StrictBool] = Field(False, alias="clickAnalytics", description="Indicates whether a query ID parameter is included in the search response. This is required for [tracking click and conversion events](https://www.algolia.com/doc/guides/sending-events/concepts/event-types/#events-related-to-algolia-requests).")
    analytics: Optional[StrictBool] = Field(True, description="Indicates whether this query will be included in [analytics](https://www.algolia.com/doc/guides/search-analytics/guides/exclude-queries/).")
    analytics_tags: Optional[conlist(StrictStr)] = Field(None, alias="analyticsTags", description="Tags to apply to the query for [segmenting analytics data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/).")
    percentile_computation: Optional[StrictBool] = Field(True, alias="percentileComputation", description="Whether to include or exclude a query from the processing-time percentile computation.")
    enable_ab_test: Optional[StrictBool] = Field(True, alias="enableABTest", description="Incidates whether this search will be considered in A/B testing.")
    __properties = ["query", "similarQuery", "filters", "facetFilters", "optionalFilters", "numericFilters", "tagFilters", "sumOrFiltersScores", "restrictSearchableAttributes", "facets", "facetingAfterDistinct", "page", "offset", "length", "aroundLatLng", "aroundLatLngViaIP", "aroundRadius", "aroundPrecision", "minimumAroundRadius", "insideBoundingBox", "insidePolygon", "naturalLanguages", "ruleContexts", "personalizationImpact", "userToken", "getRankingInfo", "explain", "synonyms", "clickAnalytics", "analytics", "analyticsTags", "percentileComputation", "enableABTest"]

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
    def from_json(cls, json_str: str) -> BaseSearchParams:
        """Create an instance of BaseSearchParams from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True,
                          exclude={
                          },
                          exclude_none=True)
        # override the default output from pydantic by calling `to_dict()` of facet_filters
        if self.facet_filters:
            _dict['facetFilters'] = self.facet_filters.to_dict()
        # override the default output from pydantic by calling `to_dict()` of optional_filters
        if self.optional_filters:
            _dict['optionalFilters'] = self.optional_filters.to_dict()
        # override the default output from pydantic by calling `to_dict()` of numeric_filters
        if self.numeric_filters:
            _dict['numericFilters'] = self.numeric_filters.to_dict()
        # override the default output from pydantic by calling `to_dict()` of tag_filters
        if self.tag_filters:
            _dict['tagFilters'] = self.tag_filters.to_dict()
        # override the default output from pydantic by calling `to_dict()` of around_radius
        if self.around_radius:
            _dict['aroundRadius'] = self.around_radius.to_dict()
        # override the default output from pydantic by calling `to_dict()` of around_precision
        if self.around_precision:
            _dict['aroundPrecision'] = self.around_precision.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> BaseSearchParams:
        """Create an instance of BaseSearchParams from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return BaseSearchParams.parse_obj(obj)

        _obj = BaseSearchParams.parse_obj({
            "query": obj.get("query") if obj.get("query") is not None else '',
            "similar_query": obj.get("similarQuery") if obj.get("similarQuery") is not None else '',
            "filters": obj.get("filters") if obj.get("filters") is not None else '',
            "facet_filters": FacetFilters.from_dict(obj.get("facetFilters")) if obj.get("facetFilters") is not None else None,
            "optional_filters": OptionalFilters.from_dict(obj.get("optionalFilters")) if obj.get("optionalFilters") is not None else None,
            "numeric_filters": NumericFilters.from_dict(obj.get("numericFilters")) if obj.get("numericFilters") is not None else None,
            "tag_filters": TagFilters.from_dict(obj.get("tagFilters")) if obj.get("tagFilters") is not None else None,
            "sum_or_filters_scores": obj.get("sumOrFiltersScores") if obj.get("sumOrFiltersScores") is not None else False,
            "restrict_searchable_attributes": obj.get("restrictSearchableAttributes"),
            "facets": obj.get("facets"),
            "faceting_after_distinct": obj.get("facetingAfterDistinct") if obj.get("facetingAfterDistinct") is not None else False,
            "page": obj.get("page") if obj.get("page") is not None else 0,
            "offset": obj.get("offset"),
            "length": obj.get("length"),
            "around_lat_lng": obj.get("aroundLatLng") if obj.get("aroundLatLng") is not None else '',
            "around_lat_lng_via_ip": obj.get("aroundLatLngViaIP") if obj.get("aroundLatLngViaIP") is not None else False,
            "around_radius": AroundRadius.from_dict(obj.get("aroundRadius")) if obj.get("aroundRadius") is not None else None,
            "around_precision": AroundPrecision.from_dict(obj.get("aroundPrecision")) if obj.get("aroundPrecision") is not None else None,
            "minimum_around_radius": obj.get("minimumAroundRadius"),
            "inside_bounding_box": obj.get("insideBoundingBox"),
            "inside_polygon": obj.get("insidePolygon"),
            "natural_languages": obj.get("naturalLanguages"),
            "rule_contexts": obj.get("ruleContexts"),
            "personalization_impact": obj.get("personalizationImpact") if obj.get("personalizationImpact") is not None else 100,
            "user_token": obj.get("userToken"),
            "get_ranking_info": obj.get("getRankingInfo") if obj.get("getRankingInfo") is not None else False,
            "explain": obj.get("explain"),
            "synonyms": obj.get("synonyms") if obj.get("synonyms") is not None else True,
            "click_analytics": obj.get("clickAnalytics") if obj.get("clickAnalytics") is not None else False,
            "analytics": obj.get("analytics") if obj.get("analytics") is not None else True,
            "analytics_tags": obj.get("analyticsTags"),
            "percentile_computation": obj.get("percentileComputation") if obj.get("percentileComputation") is not None else True,
            "enable_ab_test": obj.get("enableABTest") if obj.get("enableABTest") is not None else True
        })
        return _obj


