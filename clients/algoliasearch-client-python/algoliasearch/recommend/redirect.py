# coding: utf-8

"""
    Recommend API

    The Recommend API lets you generate recommendations with several AI models.  > **Note**: You should use Algolia's [libraries and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) to interact with the Recommend API. Using the HTTP endpoints directly is not covered by the [SLA](https://www.algolia.com/policies/sla/).

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json


from typing import List, Optional
from pydantic import BaseModel, conlist
from algoliasearch.models.redirect_rule_index_metadata import RedirectRuleIndexMetadata


class Redirect(BaseModel):
    """
    [Redirect results to a URL](https://www.algolia.com/doc/guides/managing-results/rules/merchandising-and-promoting/how-to/redirects/).   # noqa: E501
    """

    index: Optional[conlist(RedirectRuleIndexMetadata)] = None
    __properties = ["index"]

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
    def from_json(cls, json_str: str) -> Redirect:
        """Create an instance of Redirect from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True, exclude={}, exclude_none=True)
        # override the default output from pydantic by calling `to_dict()` of each item in index (list)
        _items = []
        if self.index:
            for _item in self.index:
                if _item:
                    _items.append(_item.to_dict())
            _dict["index"] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> Redirect:
        """Create an instance of Redirect from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return Redirect.parse_obj(obj)

        _obj = Redirect.parse_obj(
            {
                "index": [
                    RedirectRuleIndexMetadata.from_dict(_item)
                    for _item in obj.get("index")
                ]
                if obj.get("index") is not None
                else None
            }
        )
        return _obj
