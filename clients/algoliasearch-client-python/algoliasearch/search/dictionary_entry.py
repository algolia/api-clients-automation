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


from typing import List, Optional
from pydantic import BaseModel, Field, StrictStr, conlist
from algoliasearch.models.dictionary_entry_state import DictionaryEntryState

class DictionaryEntry(BaseModel):
    """
    Dictionary entry.  # noqa: E501
    """
    object_id: StrictStr = Field(..., alias="objectID", description="Unique identifier for a dictionary object.")
    language: StrictStr = Field(..., description="[Supported language ISO code](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/). ")
    word: Optional[StrictStr] = Field(None, description="Dictionary entry word. Usage depends on the type of dictionary entry. **`stopwordEntry`** The stop word you want to add or update. If the entry already exists in Algolia's standard dictionary, you can override its behavior by adding it to the custom dictionary and setting its `state` to `disabled`. **`compoundEntry`** When `decomposition` is empty: adds `word` as a compound atom. For example, atom “kino” decomposes the query “kopfkino” into \"kopf\" and \"kino\". When `decomposition` isn't empty: creates a decomposition exception. For example, when decomposition is set to the [\"hund\", \"hutte\"] exception, \"hundehutte\" decomposes into “hund” and “hutte”, discarding the linking \"e\". ")
    words: Optional[conlist(StrictStr)] = Field(None, description="Compound dictionary [word declensions](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-plurals-and-other-declensions/). If the entry already exists in Algolia's standard dictionary, you can override its behavior by adding it to the custom dictionary and setting its `state` to `disabled`. ")
    decomposition: Optional[conlist(StrictStr)] = Field(None, description="For compound entries, governs the behavior of the `word` parameter.")
    state: Optional[DictionaryEntryState] = None
    additional_properties: Dict[str, Any] = {}
    __properties = ["objectID", "language", "word", "words", "decomposition", "state"]

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
    def from_json(cls, json_str: str) -> DictionaryEntry:
        """Create an instance of DictionaryEntry from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True,
                          exclude={
                            "additional_properties"
                          },
                          exclude_none=True)
        # puts key-value pairs in additional_properties in the top level
        if self.additional_properties is not None:
            for _key, _value in self.additional_properties.items():
                _dict[_key] = _value

        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> DictionaryEntry:
        """Create an instance of DictionaryEntry from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return DictionaryEntry.parse_obj(obj)

        _obj = DictionaryEntry.parse_obj({
            "object_id": obj.get("objectID"),
            "language": obj.get("language"),
            "word": obj.get("word"),
            "words": obj.get("words"),
            "decomposition": obj.get("decomposition"),
            "state": obj.get("state")
        })
        # store additional fields in additional_properties
        for _key in obj.keys():
            if _key not in cls.__properties:
                _obj.additional_properties[_key] = obj.get(_key)

        return _obj


