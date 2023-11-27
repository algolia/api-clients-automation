# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

import json
from enum import Enum

try:
    from typing import Self
except ImportError:
    from typing_extensions import Self


class SourceType(str, Enum):
    """
    SourceType
    """

    """
    allowed enum values
    """
    BIGCOMMERCE = "bigcommerce"
    COMMERCETOOLS = "commercetools"
    JSON = "json"
    CSV = "csv"
    BIGQUERY = "bigquery"
    DOCKER = "docker"

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of SourceType from a JSON string"""
        return cls(json.loads(json_str))
