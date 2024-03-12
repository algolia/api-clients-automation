# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Any, Dict, List, Optional, Self

from pydantic import BaseModel, Field, StrictInt, StrictStr

from algoliasearch.search.models.acl import Acl


class GetApiKeyResponse(BaseModel):
    """
    GetApiKeyResponse
    """

    value: Optional[StrictStr] = Field(default=None, description="API key.")
    created_at: StrictInt = Field(
        description="Timestamp of creation in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time).",
        alias="createdAt",
    )
    acl: List[Acl] = Field(
        description="Permissions that determine the type of API requests this key can make. The required ACL is listed in each endpoint's reference. For more information, see [access control list](https://www.algolia.com/doc/guides/security/api-keys/#access-control-list-acl). "
    )
    description: Optional[StrictStr] = Field(
        default="",
        description="Description of an API key to help you identify this API key.",
    )
    indexes: Optional[List[StrictStr]] = Field(
        default=None,
        description='Index names or patterns that this API key can access. By default, an API key can access all indices in the same application.  You can use leading and trailing wildcard characters (`*`):  - `dev_*` matches all indices starting with "dev_". - `*_dev` matches all indices ending with "_dev". - `*_products_*` matches all indices containing "_products_". ',
    )
    max_hits_per_query: Optional[StrictInt] = Field(
        default=0,
        description="Maximum number of results this API key can retrieve in one query. By default, there's no limit. ",
        alias="maxHitsPerQuery",
    )
    max_queries_per_ip_per_hour: Optional[StrictInt] = Field(
        default=0,
        description="Maximum number of API requests allowed per IP address or [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) per hour.  If this limit is reached, the API returns an error with status code `429`. By default, there's no limit. ",
        alias="maxQueriesPerIPPerHour",
    )
    query_parameters: Optional[StrictStr] = Field(
        default="",
        description="Query parameters to add when making API requests with this API key.  To restrict this API key to specific IP addresses, add the `restrictSources` parameter. You can only add a single source, but you can provide a range of IP addresses.  Creating an API key fails if the request is made from an IP address that's outside the restricted range. ",
        alias="queryParameters",
    )
    referers: Optional[List[StrictStr]] = Field(
        default=None,
        description='Allowed HTTP referrers for this API key.  By default, all referrers are allowed. You can use leading and trailing wildcard characters (`*`):  - `https://algolia.com/*` allows all referrers starting with "https://algolia.com/" - `*.algolia.com` allows all referrers ending with ".algolia.com" - `*algolia.com*` allows all referrers in the domain "algolia.com".  Like all HTTP headers, referrers can be spoofed. Don\'t rely on them to secure your data. For more information, see [HTTP referrer restrictions](https://www.algolia.com/doc/guides/security/security-best-practices/#http-referrers-restrictions). ',
    )
    validity: Optional[StrictInt] = Field(
        default=0,
        description="Duration (in seconds) after which the API key expires. By default, API keys don't expire. ",
    )

    model_config = {"populate_by_name": True, "validate_assignment": True}

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of GetApiKeyResponse from a JSON string"""
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
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of GetApiKeyResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "value": obj.get("value"),
                "createdAt": obj.get("createdAt"),
                "acl": obj.get("acl"),
                "description": obj.get("description"),
                "indexes": obj.get("indexes"),
                "maxHitsPerQuery": obj.get("maxHitsPerQuery"),
                "maxQueriesPerIPPerHour": obj.get("maxQueriesPerIPPerHour"),
                "queryParameters": obj.get("queryParameters"),
                "referers": obj.get("referers"),
                "validity": obj.get("validity"),
            }
        )
        return _obj
