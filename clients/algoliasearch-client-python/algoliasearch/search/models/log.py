# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from typing import Annotated, Any, Dict, List, Optional, Self

from pydantic import BaseModel, ConfigDict, Field, StrictStr

from algoliasearch.search.models.log_query import LogQuery


class Log(BaseModel):
    """
    Log
    """

    timestamp: StrictStr = Field(
        description="Date and time of the API request, in RFC 3339 format."
    )
    method: StrictStr = Field(description="HTTP method of the request.")
    answer_code: StrictStr = Field(description="HTTP status code of the response.")
    query_body: Annotated[str, Field(strict=True, max_length=1000)] = Field(
        description="Request body."
    )
    answer: Annotated[str, Field(strict=True, max_length=1000)] = Field(
        description="Response body."
    )
    url: StrictStr = Field(description="URL of the API endpoint.")
    ip: StrictStr = Field(
        description="IP address of the client that performed the request."
    )
    query_headers: StrictStr = Field(
        description="Request headers (API keys are obfuscated)."
    )
    sha1: StrictStr = Field(description="SHA1 signature of the log entry.")
    nb_api_calls: StrictStr = Field(description="Number of API requests.")
    processing_time_ms: StrictStr = Field(
        description="Processing time for the query in milliseconds. This doesn't include latency due to the network. "
    )
    index: Optional[StrictStr] = Field(
        default=None, description="Index targeted by the query."
    )
    var_query_params: Optional[StrictStr] = Field(
        default=None,
        description="Query parameters sent with the request.",
        alias="query_params",
    )
    query_nb_hits: Optional[StrictStr] = Field(
        default=None,
        description="Number of search results (hits) returned for the query.",
    )
    inner_queries: Optional[List[LogQuery]] = Field(
        default=None, description="Queries performed for the given request."
    )

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of Log from a JSON string"""
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
        if self.inner_queries:
            for _item in self.inner_queries:
                if _item:
                    _items.append(_item.to_dict())
            _dict["inner_queries"] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of Log from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "timestamp": obj.get("timestamp"),
                "method": obj.get("method"),
                "answer_code": obj.get("answer_code"),
                "query_body": obj.get("query_body"),
                "answer": obj.get("answer"),
                "url": obj.get("url"),
                "ip": obj.get("ip"),
                "query_headers": obj.get("query_headers"),
                "sha1": obj.get("sha1"),
                "nb_api_calls": obj.get("nb_api_calls"),
                "processing_time_ms": obj.get("processing_time_ms"),
                "index": obj.get("index"),
                "query_params": obj.get("query_params"),
                "query_nb_hits": obj.get("query_nb_hits"),
                "inner_queries": (
                    [LogQuery.from_dict(_item) for _item in obj.get("inner_queries")]
                    if obj.get("inner_queries") is not None
                    else None
                ),
            }
        )
        return _obj
