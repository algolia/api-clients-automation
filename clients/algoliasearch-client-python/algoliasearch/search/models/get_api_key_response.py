# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, List, Optional

from pydantic import BaseModel, ConfigDict

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.search.models.acl import Acl

_ALIASES = {
    "value": "value",
    "created_at": "createdAt",
    "acl": "acl",
    "description": "description",
    "indexes": "indexes",
    "max_hits_per_query": "maxHitsPerQuery",
    "max_queries_per_ip_per_hour": "maxQueriesPerIPPerHour",
    "query_parameters": "queryParameters",
    "referers": "referers",
    "validity": "validity",
}


def _alias_generator(name: str) -> str:
    return _ALIASES.get(name, name)


class GetApiKeyResponse(BaseModel):
    """
    GetApiKeyResponse
    """

    value: Optional[str] = None
    """ API key. """
    created_at: int
    """ Timestamp when the object was created, in milliseconds since the Unix epoch. """
    acl: List[Acl]
    """ Permissions that determine the type of API requests this key can make. The required ACL is listed in each endpoint's reference. For more information, see [access control list](https://www.algolia.com/doc/guides/security/api-keys/#access-control-list-acl).  """
    description: Optional[str] = None
    """ Description of an API key to help you identify this API key. """
    indexes: Optional[List[str]] = None
    """ Index names or patterns that this API key can access. By default, an API key can access all indices in the same application.  You can use leading and trailing wildcard characters (`*`):  - `dev_*` matches all indices starting with \"dev_\". - `*_dev` matches all indices ending with \"_dev\". - `*_products_*` matches all indices containing \"_products_\".  """
    max_hits_per_query: Optional[int] = None
    """ Maximum number of results this API key can retrieve in one query. By default, there's no limit.  """
    max_queries_per_ip_per_hour: Optional[int] = None
    """ Maximum number of API requests allowed per IP address or [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) per hour.  If this limit is reached, the API returns an error with status code `429`. By default, there's no limit.  """
    query_parameters: Optional[str] = None
    """ Query parameters to add when making API requests with this API key.  To restrict this API key to specific IP addresses, add the `restrictSources` parameter. You can only add a single source, but you can provide a range of IP addresses.  Creating an API key fails if the request is made from an IP address that's outside the restricted range.  """
    referers: Optional[List[str]] = None
    """ Allowed HTTP referrers for this API key.  By default, all referrers are allowed. You can use leading and trailing wildcard characters (`*`):  - `https://algolia.com/*` allows all referrers starting with \"https://algolia.com/\" - `*.algolia.com` allows all referrers ending with \".algolia.com\" - `*algolia.com*` allows all referrers in the domain \"algolia.com\".  Like all HTTP headers, referrers can be spoofed. Don't rely on them to secure your data. For more information, see [HTTP referrer restrictions](https://www.algolia.com/doc/guides/security/security-best-practices/#http-referrers-restrictions).  """
    validity: Optional[int] = None
    """ Duration (in seconds) after which the API key expires. By default, API keys don't expire.  """

    model_config = ConfigDict(
        use_enum_values=True,
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
        alias_generator=_alias_generator,
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of GetApiKeyResponse from a JSON string"""
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
        """Create an instance of GetApiKeyResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["acl"] = obj.get("acl")

        return cls.model_validate(obj)
