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


class LogLevel(str, Enum):
    """
    Type of log entry.  - `SKIP`. A query is skipped because it doesn't match the conditions for successful inclusion. For example, when a query doesn't generate enough search results. - `INFO`. An informative log entry. - `ERROR`. The Query Suggestions process encountered an error.
    """

    """
    allowed enum values
    """
    SKIP = "SKIP"

    INFO = "INFO"

    ERROR = "ERROR"

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of LogLevel from a JSON string"""
        return cls(loads(json_str))
