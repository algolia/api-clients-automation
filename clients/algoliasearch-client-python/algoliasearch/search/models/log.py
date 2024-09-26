# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, List, Optional

from pydantic import BaseModel, ConfigDict, Field

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.search.models.log_query import LogQuery


class Log(BaseModel):
    """
    Log
    """

    timestamp: str = Field(alias="timestamp")
    """ Date and time of the API request, in RFC 3339 format. """
    method: str = Field(alias="method")
    """ HTTP method of the request. """
    answer_code: str = Field(alias="answer_code")
    """ HTTP status code of the response. """
    query_body: str = Field(alias="query_body")
    """ Request body. """
    answer: str = Field(alias="answer")
    """ Response body. """
    url: str = Field(alias="url")
    """ URL of the API endpoint. """
    ip: str = Field(alias="ip")
    """ IP address of the client that performed the request. """
    query_headers: str = Field(alias="query_headers")
    """ Request headers (API keys are obfuscated). """
    sha1: str = Field(alias="sha1")
    """ SHA1 signature of the log entry. """
    nb_api_calls: str = Field(alias="nb_api_calls")
    """ Number of API requests. """
    processing_time_ms: str = Field(alias="processing_time_ms")
    """ Processing time for the query in milliseconds. This doesn't include latency due to the network.  """
    index: Optional[str] = Field(default=None, alias="index")
    """ Index targeted by the query. """
    var_query_params: Optional[str] = Field(default=None, alias="query_params")
    """ Query parameters sent with the request. """
    query_nb_hits: Optional[str] = Field(default=None, alias="query_nb_hits")
    """ Number of search results (hits) returned for the query. """
    inner_queries: Optional[List[LogQuery]] = Field(default=None, alias="inner_queries")
    """ Queries performed for the given request. """

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
        """Create an instance of Log from a JSON string"""
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
        """Create an instance of Log from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["inner_queries"] = (
            [LogQuery.from_dict(_item) for _item in obj["inner_queries"]]
            if obj.get("inner_queries") is not None
            else None
        )

        return cls.model_validate(obj)
