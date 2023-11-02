# coding: utf-8

"""
    Recommend API

    The Recommend API lets you generate recommendations with several AI models.  > **Note**: You should use Algolia's [libraries and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) to interact with the Recommend API. Using the HTTP endpoints directly is not covered by the [SLA](https://www.algolia.com/policies/sla/).

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


import json
import pprint
import re  # noqa: F401
from aenum import Enum, no_arg





class TrendingFacetsModel(str, Enum):
    """
    Trending facets model.
    """

    """
    allowed enum values
    """
    TRENDING_MINUS_FACETS = 'trending-facets'

    @classmethod
    def from_json(cls, json_str: str) -> TrendingFacetsModel:
        """Create an instance of TrendingFacetsModel from a JSON string"""
        return TrendingFacetsModel(json.loads(json_str))


