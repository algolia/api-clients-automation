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


class Metric(str, Enum):
    """
    Metric
    """

    """
    allowed enum values
    """
    AVG_BUILD_TIME = "avg_build_time"

    SSD_USAGE = "ssd_usage"

    RAM_SEARCH_USAGE = "ram_search_usage"

    RAM_INDEXING_USAGE = "ram_indexing_usage"

    CPU_USAGE = "cpu_usage"

    STAR = "*"

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of Metric from a JSON string"""
        return cls(loads(json_str))
