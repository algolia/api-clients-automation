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


from typing import Optional
from pydantic import BaseModel, Field
from algoliasearch.models.dictionary_language import DictionaryLanguage


class Languages(BaseModel):
    """
    Dictionary language.  # noqa: E501
    """

    plurals: Optional[DictionaryLanguage] = Field(...)
    stopwords: Optional[DictionaryLanguage] = Field(...)
    compounds: Optional[DictionaryLanguage] = Field(...)
    __properties = ["plurals", "stopwords", "compounds"]

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
    def from_json(cls, json_str: str) -> Languages:
        """Create an instance of Languages from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True, exclude={}, exclude_none=True)
        # override the default output from pydantic by calling `to_dict()` of plurals
        if self.plurals:
            _dict["plurals"] = self.plurals.to_dict()
        # override the default output from pydantic by calling `to_dict()` of stopwords
        if self.stopwords:
            _dict["stopwords"] = self.stopwords.to_dict()
        # override the default output from pydantic by calling `to_dict()` of compounds
        if self.compounds:
            _dict["compounds"] = self.compounds.to_dict()
        # set to None if plurals (nullable) is None
        # and __fields_set__ contains the field
        if self.plurals is None and "plurals" in self.__fields_set__:
            _dict["plurals"] = None

        # set to None if stopwords (nullable) is None
        # and __fields_set__ contains the field
        if self.stopwords is None and "stopwords" in self.__fields_set__:
            _dict["stopwords"] = None

        # set to None if compounds (nullable) is None
        # and __fields_set__ contains the field
        if self.compounds is None and "compounds" in self.__fields_set__:
            _dict["compounds"] = None

        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> Languages:
        """Create an instance of Languages from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return Languages.parse_obj(obj)

        _obj = Languages.parse_obj(
            {
                "plurals": DictionaryLanguage.from_dict(obj.get("plurals"))
                if obj.get("plurals") is not None
                else None,
                "stopwords": DictionaryLanguage.from_dict(obj.get("stopwords"))
                if obj.get("stopwords") is not None
                else None,
                "compounds": DictionaryLanguage.from_dict(obj.get("compounds"))
                if obj.get("compounds") is not None
                else None,
            }
        )
        return _obj
