# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Any, Dict, List, Self

from pydantic import BaseModel, Field, StrictInt

from algoliasearch.personalization.models.event_scoring import EventScoring
from algoliasearch.personalization.models.facet_scoring import FacetScoring


class PersonalizationStrategyParams(BaseModel):
    """
    PersonalizationStrategyParams
    """

    event_scoring: List[EventScoring] = Field(
        description="Scores associated with the events.", alias="eventScoring"
    )
    facet_scoring: List[FacetScoring] = Field(
        description="Scores associated with the facets.", alias="facetScoring"
    )
    personalization_impact: StrictInt = Field(
        description="The impact that personalization has on search results: a number between 0 (personalization disabled) and 100 (personalization fully enabled).",
        alias="personalizationImpact",
    )

    model_config = {"populate_by_name": True, "validate_assignment": True}

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of PersonalizationStrategyParams from a JSON string"""
        return cls.from_dict(loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias.

        This has the following differences from calling pydantic's
        `self.model_dump(by_alias=True)`:

        * `None` is only added to the output dict for nullable fields that
          were set at model initialization. Other fields with value `None`
          are ignored.
        """
        _dict = self.model_dump(
            by_alias=True,
            exclude={},
            exclude_none=True,
        )
        _items = []
        if self.event_scoring:
            for _item in self.event_scoring:
                if _item:
                    _items.append(_item.to_dict())
            _dict["eventScoring"] = _items
        _items = []
        if self.facet_scoring:
            for _item in self.facet_scoring:
                if _item:
                    _items.append(_item.to_dict())
            _dict["facetScoring"] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of PersonalizationStrategyParams from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "eventScoring": [
                    EventScoring.from_dict(_item) for _item in obj.get("eventScoring")
                ]
                if obj.get("eventScoring") is not None
                else None,
                "facetScoring": [
                    FacetScoring.from_dict(_item) for _item in obj.get("facetScoring")
                ]
                if obj.get("facetScoring") is not None
                else None,
                "personalizationImpact": obj.get("personalizationImpact"),
            }
        )
        return _obj
