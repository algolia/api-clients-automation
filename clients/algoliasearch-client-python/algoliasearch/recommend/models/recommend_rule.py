# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, Optional

from pydantic import BaseModel, ConfigDict, Field

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.recommend.models.condition import Condition
from algoliasearch.recommend.models.consequence import Consequence
from algoliasearch.recommend.models.rule_metadata import RuleMetadata


class RecommendRule(BaseModel):
    """
    Recommend rule.
    """

    metadata: Optional[RuleMetadata] = Field(default=None, alias="_metadata")
    object_id: Optional[str] = Field(default=None, alias="objectID")
    """ Unique identifier of a rule object. """
    condition: Optional[Condition] = Field(default=None, alias="condition")
    consequence: Optional[Consequence] = Field(default=None, alias="consequence")
    description: Optional[str] = Field(default=None, alias="description")
    """ Description of the rule's purpose. This can be helpful for display in the Algolia dashboard. """
    enabled: Optional[bool] = Field(default=None, alias="enabled")
    """ Indicates whether to enable the rule. If it isn't enabled, it isn't applied at query time. """

    model_config = ConfigDict(
        use_enum_values=True,
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of RecommendRule from a JSON string"""
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
        """Create an instance of RecommendRule from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["_metadata"] = (
            RuleMetadata.from_dict(obj["_metadata"])
            if obj.get("_metadata") is not None
            else None
        )
        obj["condition"] = (
            Condition.from_dict(obj["condition"])
            if obj.get("condition") is not None
            else None
        )
        obj["consequence"] = (
            Consequence.from_dict(obj["consequence"])
            if obj.get("consequence") is not None
            else None
        )

        return cls.model_validate(obj)
