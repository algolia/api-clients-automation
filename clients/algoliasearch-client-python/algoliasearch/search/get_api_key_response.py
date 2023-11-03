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
from pydantic import BaseModel, Field, StrictInt, StrictStr, conlist
from algoliasearch.models.acl import Acl

class GetApiKeyResponse(BaseModel):
    """
    GetApiKeyResponse
    """
    value: Optional[StrictStr] = Field(None, description="API key.")
    created_at: StrictInt = Field(..., alias="createdAt", description="Timestamp of creation in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time).")
    acl: conlist(Acl) = Field(..., description="[Permissions](https://www.algolia.com/doc/guides/security/api-keys/#access-control-list-acl) associated with the key. ")
    description: Optional[StrictStr] = Field('', description="Description of an API key for you and your team members.")
    indexes: Optional[conlist(StrictStr)] = Field(None, description="Restricts this API key to a list of indices or index patterns. If the list is empty, all indices are allowed. Specify either an exact index name or a pattern with a leading or trailing wildcard character (or both). For example: - `dev_*` matches all indices starting with \"dev_\" - `*_dev` matches all indices ending with \"_dev\" - `*_products_*` matches all indices containing \"_products_\". ")
    max_hits_per_query: Optional[StrictInt] = Field(0, alias="maxHitsPerQuery", description="Maximum number of hits this API key can retrieve in one query. If zero, no limit is enforced. > **Note**: Use this parameter to protect you from third-party attempts to retrieve your entire content by massively querying the index. ")
    max_queries_per_ip_per_hour: Optional[StrictInt] = Field(0, alias="maxQueriesPerIPPerHour", description="Maximum number of API calls per hour allowed from a given IP address or [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/). Each time an API call is performed with this key, a check is performed. If there were more than the specified number of calls within the last hour, the API returns an error with the status code `429` (Too Many Requests).  > **Note**: Use this parameter to protect you from third-party attempts to retrieve your entire content by massively querying the index. ")
    query_parameters: Optional[StrictStr] = Field('', alias="queryParameters", description="Force some [query parameters](https://www.algolia.com/doc/api-reference/api-parameters/) to be applied for each query made with this API key. It's a URL-encoded query string. ")
    referers: Optional[conlist(StrictStr)] = Field(None, description="Restrict this API key to specific [referrers](https://www.algolia.com/doc/guides/security/api-keys/in-depth/api-key-restrictions/#http-referrers). If empty, all referrers are allowed. For example: - `https://algolia.com/*` matches all referrers starting with \"https://algolia.com/\" - `*.algolia.com` matches all referrers ending with \".algolia.com\" - `*algolia.com*` allows everything in the domain \"algolia.com\". ")
    validity: Optional[StrictInt] = Field(0, description="Validity duration of a key (in seconds).  The key will automatically be removed after this time has expired. The default value of 0 never expires. Short-lived API keys are useful to grant temporary access to your data. For example, in mobile apps, you can't [control when users update your app](https://www.algolia.com/doc/guides/security/security-best-practices/#use-secured-api-keys-in-mobile-apps). So instead of encoding keys into your app as you would for a web app, you should dynamically fetch them from your mobile app's backend. ")
    __properties = ["value", "createdAt", "acl", "description", "indexes", "maxHitsPerQuery", "maxQueriesPerIPPerHour", "queryParameters", "referers", "validity"]

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
    def from_json(cls, json_str: str) -> GetApiKeyResponse:
        """Create an instance of GetApiKeyResponse from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True,
                          exclude={
                          },
                          exclude_none=True)
        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> GetApiKeyResponse:
        """Create an instance of GetApiKeyResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return GetApiKeyResponse.parse_obj(obj)

        _obj = GetApiKeyResponse.parse_obj({
            "value": obj.get("value"),
            "created_at": obj.get("createdAt"),
            "acl": obj.get("acl"),
            "description": obj.get("description") if obj.get("description") is not None else '',
            "indexes": obj.get("indexes"),
            "max_hits_per_query": obj.get("maxHitsPerQuery") if obj.get("maxHitsPerQuery") is not None else 0,
            "max_queries_per_ip_per_hour": obj.get("maxQueriesPerIPPerHour") if obj.get("maxQueriesPerIPPerHour") is not None else 0,
            "query_parameters": obj.get("queryParameters") if obj.get("queryParameters") is not None else '',
            "referers": obj.get("referers"),
            "validity": obj.get("validity") if obj.get("validity") is not None else 0
        })
        return _obj


