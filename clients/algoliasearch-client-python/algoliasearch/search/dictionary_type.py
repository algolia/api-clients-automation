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





class DictionaryType(str, Enum):
    """
    DictionaryType
    """

    """
    allowed enum values
    """
    PLURALS = 'plurals'
    STOPWORDS = 'stopwords'
    COMPOUNDS = 'compounds'

    @classmethod
    def from_json(cls, json_str: str) -> DictionaryType:
        """Create an instance of DictionaryType from a JSON string"""
        return DictionaryType(json.loads(json_str))


