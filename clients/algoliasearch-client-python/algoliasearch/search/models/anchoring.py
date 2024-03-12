# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from enum import Enum
from json import loads
from typing import Self


class Anchoring(str, Enum):
    """
    Which part of the search query the pattern should match:  - `startsWith`. The pattern must match the begginning of the query. - `endsWith`. The pattern must match the end of the query. - `is`. The pattern must match the query exactly. - `contains`. The pattern must match anywhere in the query.  Empty queries are only allowed as pattern with `anchoring: is`.
    """

    """
    allowed enum values
    """
    IS = "is"
    STARTSWITH = "startsWith"
    ENDSWITH = "endsWith"
    CONTAINS = "contains"

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of Anchoring from a JSON string"""
        return cls(loads(json_str))
