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


class Region(str, Enum):
    """
    Region where the cluster is located.
    """

    """
    allowed enum values
    """
    AU = "au"

    BR = "br"

    CA = "ca"

    DE = "de"

    EU = "eu"

    HK = "hk"

    IN = "in"

    JP = "jp"

    SG = "sg"

    UAE = "uae"

    UK = "uk"

    USC = "usc"

    USE = "use"

    USW = "usw"

    ZA = "za"

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of Region from a JSON string"""
        return cls(loads(json_str))
