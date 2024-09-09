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


from algoliasearch.monitoring.models.probes_metric import ProbesMetric


class Metrics(BaseModel):
    """
    Metrics
    """

    cpu_usage: Optional[Dict[str, List[ProbesMetric]]] = Field(
        default=None, description="CPU idleness in %."
    )
    ram_indexing_usage: Optional[Dict[str, List[ProbesMetric]]] = Field(
        default=None, description="RAM used for indexing in MB."
    )
    ram_search_usage: Optional[Dict[str, List[ProbesMetric]]] = Field(
        default=None, description="RAM used for search in MB."
    )
    ssd_usage: Optional[Dict[str, List[ProbesMetric]]] = Field(
        default=None,
        description="Solid-state disk (SSD) usage expressed as % of RAM.  0% means no SSD usage. A value of 50% indicates 32&nbsp;GB SSD usage for a machine with 64&nbsp;RAM. ",
    )
    avg_build_time: Optional[Dict[str, List[ProbesMetric]]] = Field(
        default=None, description="Average build time of the indices in seconds."
    )

    model_config = ConfigDict(
        use_enum_values=True, populate_by_name=True, validate_assignment=True
    )

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of Metrics from a JSON string"""
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
        _field_dict_of_array = {}
        if self.cpu_usage:
            for _key in self.cpu_usage:
                if self.cpu_usage[_key] is not None:
                    _field_dict_of_array[_key] = [
                        _item.to_dict() for _item in self.cpu_usage[_key]
                    ]
            _dict["cpu_usage"] = _field_dict_of_array
        _field_dict_of_array = {}
        if self.ram_indexing_usage:
            for _key in self.ram_indexing_usage:
                if self.ram_indexing_usage[_key] is not None:
                    _field_dict_of_array[_key] = [
                        _item.to_dict() for _item in self.ram_indexing_usage[_key]
                    ]
            _dict["ram_indexing_usage"] = _field_dict_of_array
        _field_dict_of_array = {}
        if self.ram_search_usage:
            for _key in self.ram_search_usage:
                if self.ram_search_usage[_key] is not None:
                    _field_dict_of_array[_key] = [
                        _item.to_dict() for _item in self.ram_search_usage[_key]
                    ]
            _dict["ram_search_usage"] = _field_dict_of_array
        _field_dict_of_array = {}
        if self.ssd_usage:
            for _key in self.ssd_usage:
                if self.ssd_usage[_key] is not None:
                    _field_dict_of_array[_key] = [
                        _item.to_dict() for _item in self.ssd_usage[_key]
                    ]
            _dict["ssd_usage"] = _field_dict_of_array
        _field_dict_of_array = {}
        if self.avg_build_time:
            for _key in self.avg_build_time:
                if self.avg_build_time[_key] is not None:
                    _field_dict_of_array[_key] = [
                        _item.to_dict() for _item in self.avg_build_time[_key]
                    ]
            _dict["avg_build_time"] = _field_dict_of_array
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of Metrics from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "cpu_usage": dict(
                    (
                        _k,
                        [ProbesMetric.from_dict(_item) for _item in _v]
                        if _v is not None
                        else None,
                    )
                    for _k, _v in obj.get("cpu_usage").items()
                ),
                "ram_indexing_usage": dict(
                    (
                        _k,
                        [ProbesMetric.from_dict(_item) for _item in _v]
                        if _v is not None
                        else None,
                    )
                    for _k, _v in obj.get("ram_indexing_usage").items()
                ),
                "ram_search_usage": dict(
                    (
                        _k,
                        [ProbesMetric.from_dict(_item) for _item in _v]
                        if _v is not None
                        else None,
                    )
                    for _k, _v in obj.get("ram_search_usage").items()
                ),
                "ssd_usage": dict(
                    (
                        _k,
                        [ProbesMetric.from_dict(_item) for _item in _v]
                        if _v is not None
                        else None,
                    )
                    for _k, _v in obj.get("ssd_usage").items()
                ),
                "avg_build_time": dict(
                    (
                        _k,
                        [ProbesMetric.from_dict(_item) for _item in _v]
                        if _v is not None
                        else None,
                    )
                    for _k, _v in obj.get("avg_build_time").items()
                ),
            }
        )
        return _obj
