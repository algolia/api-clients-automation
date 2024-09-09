# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from enum import Enum
from json import loads
from sys import version_info

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


class QueryType(str, Enum):
    """
    Determines if and how query words are interpreted as prefixes.  By default, only the last query word is treated as prefix (`prefixLast`). To turn off prefix search, use `prefixNone`. Avoid `prefixAll`, which treats all query words as prefixes. This might lead to counterintuitive results and makes your search slower.  For more information, see [Prefix searching](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/prefix-searching/).
    """

    """
    allowed enum values
    """
    PREFIXLAST = "prefixLast"
    PREFIXALL = "prefixAll"
    PREFIXNONE = "prefixNone"

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of QueryType from a JSON string"""
        return cls(loads(json_str))
