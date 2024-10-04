# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""

from __future__ import annotations

from json import loads
from sys import version_info
from typing import Any, Dict, Optional

from pydantic import BaseModel, ConfigDict

if version_info >= (3, 11):
    from typing import Self
else:
    from typing_extensions import Self


from algoliasearch.recommend.models.highlight_result import HighlightResult
from algoliasearch.recommend.models.ranking_info import RankingInfo
from algoliasearch.recommend.models.snippet_result import SnippetResult

_ALIASES = {
    "object_id": "objectID",
    "highlight_result": "_highlightResult",
    "snippet_result": "_snippetResult",
    "ranking_info": "_rankingInfo",
    "distinct_seq_id": "_distinctSeqID",
    "score": "_score",
}


def _alias_generator(name: str) -> str:
    return _ALIASES.get(name, name)


class RecommendHit(BaseModel):
    """
    Recommend hit.
    """

    object_id: str
    """ Unique record identifier. """
    highlight_result: Optional[Dict[str, HighlightResult]] = None
    """ Surround words that match the query with HTML tags for highlighting. """
    snippet_result: Optional[Dict[str, SnippetResult]] = None
    """ Snippets that show the context around a matching search query. """
    ranking_info: Optional[RankingInfo] = None
    distinct_seq_id: Optional[int] = None
    score: float
    """ Recommendation score. """

    model_config = ConfigDict(
        use_enum_values=True,
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
        alias_generator=_alias_generator,
        extra="allow",
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of RecommendHit from a JSON string"""
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
        """Create an instance of RecommendHit from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["_highlightResult"] = (
            dict(
                (_k, HighlightResult.from_dict(_v))
                for _k, _v in obj["_highlightResult"].items()
            )
            if obj.get("_highlightResult") is not None
            else None
        )
        obj["_snippetResult"] = (
            dict(
                (_k, SnippetResult.from_dict(_v))
                for _k, _v in obj["_snippetResult"].items()
            )
            if obj.get("_snippetResult") is not None
            else None
        )
        obj["_rankingInfo"] = (
            RankingInfo.from_dict(obj["_rankingInfo"])
            if obj.get("_rankingInfo") is not None
            else None
        )

        return cls.model_validate(obj)
