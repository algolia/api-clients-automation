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


from algoliasearch.search.models.matched_geo_location import MatchedGeoLocation
from algoliasearch.search.models.personalization import Personalization

_ALIASES = {
    "filters": "filters",
    "first_matched_word": "firstMatchedWord",
    "geo_distance": "geoDistance",
    "geo_precision": "geoPrecision",
    "matched_geo_location": "matchedGeoLocation",
    "personalization": "personalization",
    "nb_exact_words": "nbExactWords",
    "nb_typos": "nbTypos",
    "promoted": "promoted",
    "proximity_distance": "proximityDistance",
    "user_score": "userScore",
    "words": "words",
    "promoted_by_re_ranking": "promotedByReRanking",
}


def _alias_generator(name: str) -> str:
    return _ALIASES.get(name, name)


class RankingInfo(BaseModel):
    """
    Object with detailed information about the record's ranking.
    """

    filters: Optional[int] = None
    """ Whether a filter matched the query. """
    first_matched_word: int
    """ Position of the first matched word in the best matching attribute of the record. """
    geo_distance: int
    """ Distance between the geo location in the search query and the best matching geo location in the record, divided by the geo precision (in meters). """
    geo_precision: Optional[int] = None
    """ Precision used when computing the geo distance, in meters. """
    matched_geo_location: Optional[MatchedGeoLocation] = None
    personalization: Optional[Personalization] = None
    nb_exact_words: int
    """ Number of exactly matched words. """
    nb_typos: int
    """ Number of typos encountered when matching the record. """
    promoted: Optional[bool] = None
    """ Whether the record was promoted by a rule. """
    proximity_distance: Optional[int] = None
    """ Number of words between multiple matches in the query plus 1. For single word queries, `proximityDistance` is 0. """
    user_score: int
    """ Overall ranking of the record, expressed as a single integer. This attribute is internal. """
    words: Optional[int] = None
    """ Number of matched words. """
    promoted_by_re_ranking: Optional[bool] = None
    """ Whether the record is re-ranked. """

    model_config = ConfigDict(
        strict=False,
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
        """Create an instance of RankingInfo from a JSON string"""
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
        """Create an instance of RankingInfo from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        obj["matchedGeoLocation"] = (
            MatchedGeoLocation.from_dict(obj["matchedGeoLocation"])
            if obj.get("matchedGeoLocation") is not None
            else None
        )
        obj["personalization"] = (
            Personalization.from_dict(obj["personalization"])
            if obj.get("personalization") is not None
            else None
        )

        return cls.model_validate(obj)
