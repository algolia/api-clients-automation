# coding: utf-8

"""
    Search API

    Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


import json
import pprint
import re  # noqa: F401
from aenum import Enum, no_arg


class DictionaryEntryState(str, Enum):
    """
    Indicates whether a dictionary entry is active (`enabled`) or inactive (`disabled`).
    """

    """
    allowed enum values
    """
    ENABLED = "enabled"
    DISABLED = "disabled"

    @classmethod
    def from_json(cls, json_str: str) -> DictionaryEntryState:
        """Create an instance of DictionaryEntryState from a JSON string"""
        return DictionaryEntryState(json.loads(json_str))
