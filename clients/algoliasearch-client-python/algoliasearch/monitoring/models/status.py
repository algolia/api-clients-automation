# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from enum import Enum
from json import loads
from typing import Self


class Status(str, Enum):
    """
    Status of the cluster.
    """

    """
    allowed enum values
    """
    OPERATIONAL = "operational"
    DEGRADED_PERFORMANCE = "degraded_performance"
    PARTIAL_OUTAGE = "partial_outage"
    MAJOR_OUTAGE = "major_outage"

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of Status from a JSON string"""
        return cls(loads(json_str))
