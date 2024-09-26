# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from re import match
from sys import version_info
from typing import Any, Dict, List, Optional

from pydantic import BaseModel, ConfigDict, Field, field_validator

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.search.models.exhaustive import Exhaustive
from algoliasearch.search.models.facet_stats import FacetStats
from algoliasearch.search.models.hit import Hit
from algoliasearch.search.models.redirect import Redirect
from algoliasearch.search.models.rendering_content import RenderingContent


class BrowseResponse(BaseModel):
    """
    BrowseResponse
    """

    ab_test_id: Optional[int] = Field(default=None, alias="abTestID")
    """ A/B test ID. This is only included in the response for indices that are part of an A/B test. """
    ab_test_variant_id: Optional[int] = Field(default=None, alias="abTestVariantID")
    """ Variant ID. This is only included in the response for indices that are part of an A/B test. """
    around_lat_lng: Optional[str] = Field(default=None, alias="aroundLatLng")
    """ Computed geographical location. """
    automatic_radius: Optional[str] = Field(default=None, alias="automaticRadius")
    """ Distance from a central coordinate provided by `aroundLatLng`. """
    exhaustive: Optional[Exhaustive] = Field(default=None, alias="exhaustive")
    exhaustive_facets_count: Optional[bool] = Field(
        default=None, alias="exhaustiveFacetsCount"
    )
    """ See the `facetsCount` field of the `exhaustive` object in the response. """
    exhaustive_nb_hits: Optional[bool] = Field(default=None, alias="exhaustiveNbHits")
    """ See the `nbHits` field of the `exhaustive` object in the response. """
    exhaustive_typo: Optional[bool] = Field(default=None, alias="exhaustiveTypo")
    """ See the `typo` field of the `exhaustive` object in the response. """
    facets: Optional[Dict[str, Dict[str, int]]] = Field(default=None, alias="facets")
    """ Facet counts. """
    facets_stats: Optional[Dict[str, FacetStats]] = Field(
        default=None, alias="facets_stats"
    )
    """ Statistics for numerical facets. """
    index: Optional[str] = Field(default=None, alias="index")
    """ Index name used for the query. """
    index_used: Optional[str] = Field(default=None, alias="indexUsed")
    """ Index name used for the query. During A/B testing, the targeted index isn't always the index used by the query. """
    message: Optional[str] = Field(default=None, alias="message")
    """ Warnings about the query. """
    nb_sorted_hits: Optional[int] = Field(default=None, alias="nbSortedHits")
    """ Number of hits selected and sorted by the relevant sort algorithm. """
    parsed_query: Optional[str] = Field(default=None, alias="parsedQuery")
    """ Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean) query string that will be searched. """
    processing_time_ms: int = Field(alias="processingTimeMS")
    """ Time the server took to process the request, in milliseconds. """
    processing_timings_ms: Optional[object] = Field(
        default=None, alias="processingTimingsMS"
    )
    """ Experimental. List of processing steps and their times, in milliseconds. You can use this list to investigate performance issues. """
    query_after_removal: Optional[str] = Field(default=None, alias="queryAfterRemoval")
    """ Markup text indicating which parts of the original query have been removed to retrieve a non-empty result set. """
    redirect: Optional[Redirect] = Field(default=None, alias="redirect")
    rendering_content: Optional[RenderingContent] = Field(
        default=None, alias="renderingContent"
    )
    server_time_ms: Optional[int] = Field(default=None, alias="serverTimeMS")
    """ Time the server took to process the request, in milliseconds. """
    server_used: Optional[str] = Field(default=None, alias="serverUsed")
    """ Host name of the server that processed the request. """
    user_data: Optional[object] = Field(default=None, alias="userData")
    """ An object with custom data.  You can store up to 32kB as custom data.  """
    query_id: Optional[str] = Field(default=None, alias="queryID")
    """ Unique identifier for the query. This is used for [click analytics](https://www.algolia.com/doc/guides/analytics/click-analytics/). """
    automatic_insights: Optional[bool] = Field(default=None, alias="_automaticInsights")
    """ Whether automatic events collection is enabled for the application. """
    page: Optional[int] = Field(default=None, alias="page")
    """ Page of search results to retrieve. """
    nb_hits: Optional[int] = Field(default=None, alias="nbHits")
    """ Number of results (hits). """
    nb_pages: Optional[int] = Field(default=None, alias="nbPages")
    """ Number of pages of results. """
    hits_per_page: Optional[int] = Field(default=None, alias="hitsPerPage")
    """ Number of hits per page. """
    hits: List[Hit] = Field(alias="hits")
    """ Search results (hits).  Hits are records from your index that match the search criteria, augmented with additional attributes, such as, for highlighting.  """
    query: str = Field(alias="query")
    """ Search query. """
    params: str = Field(alias="params")
    """ URL-encoded string of all search parameters. """
    cursor: Optional[str] = Field(default=None, alias="cursor")
    """ Cursor to get the next page of the response.  The parameter must match the value returned in the response of a previous request. The last page of the response does not return a `cursor` attribute.  """

    @field_validator("around_lat_lng")
    def around_lat_lng_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if value is None:
            return value

        if not match(r"^(-?\d+(\.\d+)?),\s*(-?\d+(\.\d+)?)$", value):
            raise ValueError(
                r"must validate the regular expression /^(-?\d+(\.\d+)?),\s*(-?\d+(\.\d+)?)$/"
            )
        return value

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
        """Create an instance of BrowseResponse from a JSON string"""
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
        """Create an instance of BrowseResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["exhaustive"] = (
            Exhaustive.from_dict(obj["exhaustive"])
            if obj.get("exhaustive") is not None
            else None
        )
        obj["facets_stats"] = (
            dict(
                (_k, FacetStats.from_dict(_v)) for _k, _v in obj["facets_stats"].items()
            )
            if obj.get("facets_stats") is not None
            else None
        )
        obj["redirect"] = (
            Redirect.from_dict(obj["redirect"])
            if obj.get("redirect") is not None
            else None
        )
        obj["renderingContent"] = (
            RenderingContent.from_dict(obj["renderingContent"])
            if obj.get("renderingContent") is not None
            else None
        )
        obj["hits"] = (
            [Hit.from_dict(_item) for _item in obj["hits"]]
            if obj.get("hits") is not None
            else None
        )

        return cls.model_validate(obj)
