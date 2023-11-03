# coding: utf-8

"""
    Search API

    Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json


from typing import Any, Dict, List, Optional
from pydantic import BaseModel, Field, StrictBool, StrictInt, StrictStr, conlist


class BaseIndexSettings(BaseModel):
    """
    BaseIndexSettings
    """

    replicas: Optional[conlist(StrictStr)] = Field(
        None,
        description="Creates [replicas](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/), which are copies of a primary index with the same records but different settings.",
    )
    pagination_limited_to: Optional[StrictInt] = Field(
        1000,
        alias="paginationLimitedTo",
        description="Maximum number of hits accessible through pagination.",
    )
    unretrievable_attributes: Optional[conlist(StrictStr)] = Field(
        None,
        alias="unretrievableAttributes",
        description="Attributes that can't be retrieved at query time.",
    )
    disable_typo_tolerance_on_words: Optional[conlist(StrictStr)] = Field(
        None,
        alias="disableTypoToleranceOnWords",
        description="Words for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/).",
    )
    attributes_to_transliterate: Optional[conlist(StrictStr)] = Field(
        None,
        alias="attributesToTransliterate",
        description="Attributes in your index to which [Japanese transliteration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#japanese-transliteration-and-type-ahead) applies. This will ensure that words indexed in Katakana or Kanji can also be searched in Hiragana.",
    )
    camel_case_attributes: Optional[conlist(StrictStr)] = Field(
        None,
        alias="camelCaseAttributes",
        description="Attributes on which to split [camel case](https://wikipedia.org/wiki/Camel_case) words.",
    )
    decompounded_attributes: Optional[Dict[str, Any]] = Field(
        None,
        alias="decompoundedAttributes",
        description="Attributes in your index to which [word segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-segmentation/) (decompounding) applies.",
    )
    index_languages: Optional[conlist(StrictStr)] = Field(
        None,
        alias="indexLanguages",
        description="Set the languages of your index, for language-specific processing steps such as [tokenization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/tokenization/) and [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).",
    )
    disable_prefix_on_attributes: Optional[conlist(StrictStr)] = Field(
        None,
        alias="disablePrefixOnAttributes",
        description="Attributes for which you want to turn off [prefix matching](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#adjusting-prefix-search).",
    )
    allow_compression_of_integer_array: Optional[StrictBool] = Field(
        False,
        alias="allowCompressionOfIntegerArray",
        description="Incidates whether the engine compresses arrays with exclusively non-negative integers. When enabled, the compressed arrays may be reordered. ",
    )
    numeric_attributes_for_filtering: Optional[conlist(StrictStr)] = Field(
        None,
        alias="numericAttributesForFiltering",
        description="Numeric attributes that can be used as [numerical filters](https://www.algolia.com/doc/guides/managing-results/rules/detecting-intent/how-to/applying-a-custom-filter-for-a-specific-query/#numerical-filters).",
    )
    separators_to_index: Optional[StrictStr] = Field(
        "",
        alias="separatorsToIndex",
        description="Controls which separators are added to an Algolia index as part of [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean). Separators are all non-letter characters except spaces and currency characters, such as $€£¥.",
    )
    searchable_attributes: Optional[conlist(StrictStr)] = Field(
        None,
        alias="searchableAttributes",
        description="[Attributes used for searching](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/), including determining [if matches at the beginning of a word are important (ordered) or not (unordered)](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/how-to/configuring-searchable-attributes-the-right-way/#understanding-word-position). ",
    )
    user_data: Optional[Any] = Field(
        None,
        alias="userData",
        description="Lets you store custom data in your indices.",
    )
    custom_normalization: Optional[Dict[str, Dict[str, StrictStr]]] = Field(
        None,
        alias="customNormalization",
        description="A list of characters and their normalized replacements to override Algolia's default [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).",
    )
    attribute_for_distinct: Optional[StrictStr] = Field(
        None,
        alias="attributeForDistinct",
        description="Name of the deduplication attribute to be used with Algolia's [_distinct_ feature](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/#introducing-algolias-distinct-feature).",
    )
    __properties = [
        "replicas",
        "paginationLimitedTo",
        "unretrievableAttributes",
        "disableTypoToleranceOnWords",
        "attributesToTransliterate",
        "camelCaseAttributes",
        "decompoundedAttributes",
        "indexLanguages",
        "disablePrefixOnAttributes",
        "allowCompressionOfIntegerArray",
        "numericAttributesForFiltering",
        "separatorsToIndex",
        "searchableAttributes",
        "userData",
        "customNormalization",
        "attributeForDistinct",
    ]

    class Config:
        """Pydantic configuration"""

        allow_population_by_field_name = True
        validate_assignment = True

    def to_str(self) -> str:
        """Returns the string representation of the model using alias"""
        return pprint.pformat(self.dict(by_alias=True))

    def to_json(self) -> str:
        """Returns the JSON representation of the model using alias"""
        return json.dumps(self.to_dict())

    @classmethod
    def from_json(cls, json_str: str) -> BaseIndexSettings:
        """Create an instance of BaseIndexSettings from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True, exclude={}, exclude_none=True)
        # set to None if user_data (nullable) is None
        # and __fields_set__ contains the field
        if self.user_data is None and "user_data" in self.__fields_set__:
            _dict["userData"] = None

        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> BaseIndexSettings:
        """Create an instance of BaseIndexSettings from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return BaseIndexSettings.parse_obj(obj)

        _obj = BaseIndexSettings.parse_obj(
            {
                "replicas": obj.get("replicas"),
                "pagination_limited_to": obj.get("paginationLimitedTo")
                if obj.get("paginationLimitedTo") is not None
                else 1000,
                "unretrievable_attributes": obj.get("unretrievableAttributes"),
                "disable_typo_tolerance_on_words": obj.get(
                    "disableTypoToleranceOnWords"
                ),
                "attributes_to_transliterate": obj.get("attributesToTransliterate"),
                "camel_case_attributes": obj.get("camelCaseAttributes"),
                "decompounded_attributes": obj.get("decompoundedAttributes"),
                "index_languages": obj.get("indexLanguages"),
                "disable_prefix_on_attributes": obj.get("disablePrefixOnAttributes"),
                "allow_compression_of_integer_array": obj.get(
                    "allowCompressionOfIntegerArray"
                )
                if obj.get("allowCompressionOfIntegerArray") is not None
                else False,
                "numeric_attributes_for_filtering": obj.get(
                    "numericAttributesForFiltering"
                ),
                "separators_to_index": obj.get("separatorsToIndex")
                if obj.get("separatorsToIndex") is not None
                else "",
                "searchable_attributes": obj.get("searchableAttributes"),
                "user_data": obj.get("userData"),
                "custom_normalization": obj.get("customNormalization"),
                "attribute_for_distinct": obj.get("attributeForDistinct"),
            }
        )
        return _obj
