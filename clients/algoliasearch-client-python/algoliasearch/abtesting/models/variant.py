# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Annotated, Any, Dict, Optional, Self, Union

from pydantic import BaseModel, Field, StrictFloat, StrictInt, StrictStr

from algoliasearch.abtesting.models.currency import Currency
from algoliasearch.abtesting.models.filter_effects import FilterEffects


class Variant(BaseModel):
    """
    Variant
    """

    add_to_cart_count: StrictInt = Field(
        description="Number of add-to-cart events for this variant.",
        alias="addToCartCount",
    )
    add_to_cart_rate: Optional[Union[StrictFloat, StrictInt]] = Field(
        description="[Add-to-cart rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#add-to-cart-rate) for this variant. ",
        alias="addToCartRate",
    )
    average_click_position: Optional[StrictInt] = Field(
        description="[Average click position](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-position) for this variant. ",
        alias="averageClickPosition",
    )
    click_count: StrictInt = Field(
        description="Number of click events for this variant.", alias="clickCount"
    )
    click_through_rate: Optional[Union[StrictFloat, StrictInt]] = Field(
        description="[Click-through rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate) for this variant. ",
        alias="clickThroughRate",
    )
    conversion_count: StrictInt = Field(
        description="Number of click events for this variant.", alias="conversionCount"
    )
    conversion_rate: Optional[Union[StrictFloat, StrictInt]] = Field(
        description="[Conversion rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#conversion-rate) for this variant. ",
        alias="conversionRate",
    )
    currencies: Optional[Dict[str, Currency]] = Field(
        default=None, description="A/B test currencies."
    )
    description: StrictStr = Field(description="Description for this variant.")
    estimated_sample_size: Optional[StrictInt] = Field(
        default=None,
        description="Estimated number of searches required to achieve the desired statistical significance.  The A/B test configuration must include a `mininmumDetectableEffect` setting for this number to be included in the response. ",
        alias="estimatedSampleSize",
    )
    filter_effects: Optional[FilterEffects] = Field(default=None, alias="filterEffects")
    index: StrictStr = Field(
        description="Index name of the A/B test variant (case-sensitive)."
    )
    no_result_count: Optional[StrictInt] = Field(
        description="Number of [searches without results](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#searches-without-results) for this variant.",
        alias="noResultCount",
    )
    purchase_count: StrictInt = Field(
        description="Number of purchase events for this variant.", alias="purchaseCount"
    )
    purchase_rate: Optional[Union[StrictFloat, StrictInt]] = Field(
        description="[Purchase rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#purchase-rate) for this variant. ",
        alias="purchaseRate",
    )
    search_count: Optional[StrictInt] = Field(
        description="Number of searches for this variant.", alias="searchCount"
    )
    tracked_search_count: Optional[StrictInt] = Field(
        default=0,
        description="Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.",
        alias="trackedSearchCount",
    )
    traffic_percentage: Annotated[int, Field(le=100, strict=True, ge=0)] = Field(
        description="Percentage of search requests each variant receives.",
        alias="trafficPercentage",
    )
    user_count: Optional[StrictInt] = Field(
        description="Number of users that made searches to this variant.",
        alias="userCount",
    )
    tracked_user_count: Optional[StrictInt] = Field(
        description="Number of users that made tracked searches to this variant.",
        alias="trackedUserCount",
    )

    model_config = {"populate_by_name": True, "validate_assignment": True}

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of Variant from a JSON string"""
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
        _field_dict = {}
        if self.currencies:
            for _key in self.currencies:
                if self.currencies[_key]:
                    _field_dict[_key] = self.currencies[_key].to_dict()
            _dict["currencies"] = _field_dict
        if self.filter_effects:
            _dict["filterEffects"] = self.filter_effects.to_dict()
        # set to None if add_to_cart_rate (nullable) is None
        # and model_fields_set contains the field
        if (
            self.add_to_cart_rate is None
            and "add_to_cart_rate" in self.model_fields_set
        ):
            _dict["addToCartRate"] = None

        # set to None if average_click_position (nullable) is None
        # and model_fields_set contains the field
        if (
            self.average_click_position is None
            and "average_click_position" in self.model_fields_set
        ):
            _dict["averageClickPosition"] = None

        # set to None if click_through_rate (nullable) is None
        # and model_fields_set contains the field
        if (
            self.click_through_rate is None
            and "click_through_rate" in self.model_fields_set
        ):
            _dict["clickThroughRate"] = None

        # set to None if conversion_rate (nullable) is None
        # and model_fields_set contains the field
        if self.conversion_rate is None and "conversion_rate" in self.model_fields_set:
            _dict["conversionRate"] = None

        # set to None if no_result_count (nullable) is None
        # and model_fields_set contains the field
        if self.no_result_count is None and "no_result_count" in self.model_fields_set:
            _dict["noResultCount"] = None

        # set to None if purchase_rate (nullable) is None
        # and model_fields_set contains the field
        if self.purchase_rate is None and "purchase_rate" in self.model_fields_set:
            _dict["purchaseRate"] = None

        # set to None if search_count (nullable) is None
        # and model_fields_set contains the field
        if self.search_count is None and "search_count" in self.model_fields_set:
            _dict["searchCount"] = None

        # set to None if user_count (nullable) is None
        # and model_fields_set contains the field
        if self.user_count is None and "user_count" in self.model_fields_set:
            _dict["userCount"] = None

        # set to None if tracked_user_count (nullable) is None
        # and model_fields_set contains the field
        if (
            self.tracked_user_count is None
            and "tracked_user_count" in self.model_fields_set
        ):
            _dict["trackedUserCount"] = None

        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of Variant from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "addToCartCount": obj.get("addToCartCount"),
                "addToCartRate": obj.get("addToCartRate"),
                "averageClickPosition": obj.get("averageClickPosition"),
                "clickCount": obj.get("clickCount"),
                "clickThroughRate": obj.get("clickThroughRate"),
                "conversionCount": obj.get("conversionCount"),
                "conversionRate": obj.get("conversionRate"),
                "currencies": (
                    dict(
                        (_k, Currency.from_dict(_v))
                        for _k, _v in obj.get("currencies").items()
                    )
                    if obj.get("currencies") is not None
                    else None
                ),
                "description": obj.get("description"),
                "estimatedSampleSize": obj.get("estimatedSampleSize"),
                "filterEffects": (
                    FilterEffects.from_dict(obj.get("filterEffects"))
                    if obj.get("filterEffects") is not None
                    else None
                ),
                "index": obj.get("index"),
                "noResultCount": obj.get("noResultCount"),
                "purchaseCount": obj.get("purchaseCount"),
                "purchaseRate": obj.get("purchaseRate"),
                "searchCount": obj.get("searchCount"),
                "trackedSearchCount": obj.get("trackedSearchCount"),
                "trafficPercentage": obj.get("trafficPercentage"),
                "userCount": obj.get("userCount"),
                "trackedUserCount": obj.get("trackedUserCount"),
            }
        )
        return _obj
