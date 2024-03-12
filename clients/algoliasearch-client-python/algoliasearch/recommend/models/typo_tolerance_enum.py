# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from enum import Enum
from json import loads
from typing import Self


class TypoToleranceEnum(str, Enum):
    """
    - `min`. Return matches with the lowest number of typos.   For example, if you have matches without typos, only include those.   But if there are no matches without typos (with 1 typo), include matches with 1 typo (2 typos). - `strict`. Return matches with the two lowest numbers of typos.   With `strict`, the Typo ranking criterion is applied first in the `ranking` setting.
    """

    """
    allowed enum values
    """
    MIN = "min"
    STRICT = "strict"

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of TypoToleranceEnum from a JSON string"""
        return cls(loads(json_str))
