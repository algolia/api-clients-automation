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


class RemoveWordsIfNoResults(str, Enum):
    """
    Strategy for removing words from the query when it doesn't return any results. This helps to avoid returning empty search results.  - `none`.   No words are removed when a query doesn't return results.  - `lastWords`.   Treat the last (then second to last, then third to last) word as optional,   until there are results or at most 5 words have been removed.  - `firstWords`.   Treat the first (then second, then third) word as optional,   until there are results or at most 5 words have been removed.  - `allOptional`.   Treat all words as optional.  For more information, see [Remove words to improve results](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/in-depth/why-use-remove-words-if-no-results/).
    """

    """
    allowed enum values
    """
    NONE = "none"
    LASTWORDS = "lastWords"
    FIRSTWORDS = "firstWords"
    ALLOPTIONAL = "allOptional"

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of RemoveWordsIfNoResults from a JSON string"""
        return cls(loads(json_str))
