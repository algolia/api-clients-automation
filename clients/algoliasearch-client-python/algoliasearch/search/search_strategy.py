# coding: utf-8

"""
    Search API

    Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


import json
import re  # noqa: F401
from aenum import Enum





class SearchStrategy(str, Enum):
    """
    - `none`: executes all queries. - `stopIfEnoughMatches`: executes queries one by one, stopping further query execution as soon as a query matches at least the `hitsPerPage` number of results.  
    """

    """
    allowed enum values
    """
    NONE = 'none'
    STOPIFENOUGHMATCHES = 'stopIfEnoughMatches'

    @classmethod
    def from_json(cls, json_str: str) -> SearchStrategy:
        """Create an instance of SearchStrategy from a JSON string"""
        return SearchStrategy(json.loads(json_str))


