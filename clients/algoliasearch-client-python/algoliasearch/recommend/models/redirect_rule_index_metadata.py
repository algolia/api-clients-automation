# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, Optional

from pydantic import BaseModel, ConfigDict

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.recommend.models.redirect_rule_index_data import (
    RedirectRuleIndexData,
)

_ALIASES = {
    "source": "source",
    "dest": "dest",
    "reason": "reason",
    "succeed": "succeed",
    "data": "data",
}


def _alias_generator(name: str) -> str:
    return _ALIASES.get(name, name)


class RedirectRuleIndexMetadata(BaseModel):
    """
    RedirectRuleIndexMetadata
    """

    source: str
    """ Source index for the redirect rule. """
    dest: str
    """ Destination index for the redirect rule. """
    reason: str
    """ Reason for the redirect rule. """
    succeed: bool
    """ Redirect rule status. """
    data: RedirectRuleIndexData

    model_config = ConfigDict(
        strict=False,
        use_enum_values=True,
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
        alias_generator=_alias_generator,
        extra="allow",
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of RedirectRuleIndexMetadata from a JSON string"""
        return cls.from_dict(loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias."""
        return self.model_dump(
            by_alias=True,
            exclude_none=True,
            exclude_unset=True,
        )

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of RedirectRuleIndexMetadata from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["data"] = (
            RedirectRuleIndexData.from_dict(obj["data"])
            if obj.get("data") is not None
            else None
        )

        return cls.model_validate(obj)
