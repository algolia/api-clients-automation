# coding: utf-8

"""
    Insights API

    The Algolia Insights API lets you collect events related to your search and discovery experience. Events represent actions that users take on your app or website. They unlock powerful features, such as recommendations, personalization, smarter search results, and analytics that help you optimize your user experience.

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


import re  # noqa: F401
import io
import warnings

from pydantic import validate_arguments, ValidationError

from typing_extensions import Annotated
from pydantic import Field, StrictStr

from typing import Any, Dict, Optional

from algoliasearch.models.events_response import EventsResponse
from algoliasearch.models.insights_events import InsightsEvents

from algoliasearch.api_client import ApiClient
from algoliasearch.api_response import ApiResponse
from algoliasearch.exceptions import (  # noqa: F401
    ApiTypeError,
    ApiValueError,
)


class InsightsClient:
    """NOTE: This class is auto generated by OpenAPI Generator
    Ref: https://openapi-generator.tech

    Do not edit the class manually.
    """

    def __init__(self, api_client=None) -> None:
        if api_client is None:
            api_client = ApiClient.get_default()
        self.api_client = api_client

    @validate_arguments
    def call_del(
        self,
        path: Annotated[
            StrictStr,
            Field(
                ...,
                description='Path of the endpoint, anything after "/1" must be specified.',
            ),
        ],
        parameters: Annotated[
            Optional[Dict[str, Any]],
            Field(description="Query parameters to apply to the current query."),
        ] = None,
        **kwargs,
    ) -> object:  # noqa: E501
        """Send requests to the Algolia REST API.  # noqa: E501

        This method allow you to send requests to the Algolia REST API.  # noqa: E501
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please pass async_req=True

        >>> thread = api.call_del(path, parameters, async_req=True)
        >>> result = thread.get()

        :param path: Path of the endpoint, anything after \"/1\" must be specified. (required)
        :type path: str
        :param parameters: Query parameters to apply to the current query.
        :type parameters: Dict[str, object]
        :param async_req: Whether to execute the request asynchronously.
        :type async_req: bool, optional
        :param _request_timeout: timeout setting for this request.
               If one number provided, it will be total request
               timeout. It can also be a pair (tuple) of
               (connection, read) timeouts.
        :return: Returns the result object.
                 If the method is called asynchronously,
                 returns the request thread.
        :rtype: object
        """
        kwargs["_return_http_data_only"] = True
        if "_preload_content" in kwargs:
            message = "Error! Please call the call_del_with_http_info method with `_preload_content` instead and obtain raw data from ApiResponse.raw_data"  # noqa: E501
            raise ValueError(message)
        return self.call_del_with_http_info(path, parameters, **kwargs)  # noqa: E501

    @validate_arguments
    def call_del_with_http_info(
        self,
        path: Annotated[
            StrictStr,
            Field(
                ...,
                description='Path of the endpoint, anything after "/1" must be specified.',
            ),
        ],
        parameters: Annotated[
            Optional[Dict[str, Any]],
            Field(description="Query parameters to apply to the current query."),
        ] = None,
        **kwargs,
    ) -> ApiResponse:  # noqa: E501
        """Send requests to the Algolia REST API.  # noqa: E501

        This method allow you to send requests to the Algolia REST API.  # noqa: E501
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please pass async_req=True

        >>> thread = api.call_del_with_http_info(path, parameters, async_req=True)
        >>> result = thread.get()

        :param path: Path of the endpoint, anything after \"/1\" must be specified. (required)
        :type path: str
        :param parameters: Query parameters to apply to the current query.
        :type parameters: Dict[str, object]
        :param async_req: Whether to execute the request asynchronously.
        :type async_req: bool, optional
        :param _preload_content: if False, the ApiResponse.data will
                                 be set to none and raw_data will store the
                                 HTTP response body without reading/decoding.
                                 Default is True.
        :type _preload_content: bool, optional
        :param _return_http_data_only: response data instead of ApiResponse
                                       object with status code, headers, etc
        :type _return_http_data_only: bool, optional
        :param _request_timeout: timeout setting for this request. If one
                                 number provided, it will be total request
                                 timeout. It can also be a pair (tuple) of
                                 (connection, read) timeouts.
        :param _request_auth: set to override the auth_settings for an a single
                              request; this effectively ignores the authentication
                              in the spec for a single request.
        :type _request_auth: dict, optional
        :type _content_type: string, optional: force content-type for the request
        :return: Returns the result object.
                 If the method is called asynchronously,
                 returns the request thread.
        :rtype: tuple(object, status_code(int), headers(HTTPHeaderDict))
        """

        _params = locals()

        _all_params = ["path", "parameters"]
        _all_params.extend(
            [
                "async_req",
                "_return_http_data_only",
                "_preload_content",
                "_request_timeout",
                "_request_auth",
                "_content_type",
                "_headers",
            ]
        )

        # validate the arguments
        for _key, _val in _params["kwargs"].items():
            if _key not in _all_params:
                raise ApiTypeError(
                    "Got an unexpected keyword argument '%s'"
                    " to method call_del" % _key
                )
            _params[_key] = _val
        del _params["kwargs"]

        _collection_formats = {}

        # process the path parameters
        _path_params = {}
        if _params["path"]:
            _path_params["path"] = _params["path"]

        # process the query parameters
        _query_params = []
        if _params.get("parameters") is not None:  # noqa: E501
            _query_params.append(("parameters", _params["parameters"]))

        # process the header parameters
        _header_params = dict(_params.get("_headers", {}))
        # process the form parameters
        _form_params = []
        _files = {}
        # process the body parameter
        _body_params = None
        # set the HTTP header `Accept`
        _header_params["Accept"] = self.api_client.select_header_accept(
            ["application/json"]
        )  # noqa: E501

        # authentication setting
        _auth_settings = ["apiKey", "appId"]  # noqa: E501

        _response_types_map = {
            "200": "object",
            "400": "ErrorBase",
            "402": "ErrorBase",
            "403": "ErrorBase",
            "404": "ErrorBase",
        }

        return self.api_client.call_api(
            "/1{path}",
            "DELETE",
            _path_params,
            _query_params,
            _header_params,
            body=_body_params,
            post_params=_form_params,
            files=_files,
            response_types_map=_response_types_map,
            auth_settings=_auth_settings,
            async_req=_params.get("async_req"),
            _return_http_data_only=_params.get("_return_http_data_only"),  # noqa: E501
            _preload_content=_params.get("_preload_content", True),
            _request_timeout=_params.get("_request_timeout"),
            collection_formats=_collection_formats,
            _request_auth=_params.get("_request_auth"),
        )

    @validate_arguments
    def get(
        self,
        path: Annotated[
            StrictStr,
            Field(
                ...,
                description='Path of the endpoint, anything after "/1" must be specified.',
            ),
        ],
        parameters: Annotated[
            Optional[Dict[str, Any]],
            Field(description="Query parameters to apply to the current query."),
        ] = None,
        **kwargs,
    ) -> object:  # noqa: E501
        """Send requests to the Algolia REST API.  # noqa: E501

        This method allow you to send requests to the Algolia REST API.  # noqa: E501
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please pass async_req=True

        >>> thread = api.get(path, parameters, async_req=True)
        >>> result = thread.get()

        :param path: Path of the endpoint, anything after \"/1\" must be specified. (required)
        :type path: str
        :param parameters: Query parameters to apply to the current query.
        :type parameters: Dict[str, object]
        :param async_req: Whether to execute the request asynchronously.
        :type async_req: bool, optional
        :param _request_timeout: timeout setting for this request.
               If one number provided, it will be total request
               timeout. It can also be a pair (tuple) of
               (connection, read) timeouts.
        :return: Returns the result object.
                 If the method is called asynchronously,
                 returns the request thread.
        :rtype: object
        """
        kwargs["_return_http_data_only"] = True
        if "_preload_content" in kwargs:
            message = "Error! Please call the get_with_http_info method with `_preload_content` instead and obtain raw data from ApiResponse.raw_data"  # noqa: E501
            raise ValueError(message)
        return self.get_with_http_info(path, parameters, **kwargs)  # noqa: E501

    @validate_arguments
    def get_with_http_info(
        self,
        path: Annotated[
            StrictStr,
            Field(
                ...,
                description='Path of the endpoint, anything after "/1" must be specified.',
            ),
        ],
        parameters: Annotated[
            Optional[Dict[str, Any]],
            Field(description="Query parameters to apply to the current query."),
        ] = None,
        **kwargs,
    ) -> ApiResponse:  # noqa: E501
        """Send requests to the Algolia REST API.  # noqa: E501

        This method allow you to send requests to the Algolia REST API.  # noqa: E501
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please pass async_req=True

        >>> thread = api.get_with_http_info(path, parameters, async_req=True)
        >>> result = thread.get()

        :param path: Path of the endpoint, anything after \"/1\" must be specified. (required)
        :type path: str
        :param parameters: Query parameters to apply to the current query.
        :type parameters: Dict[str, object]
        :param async_req: Whether to execute the request asynchronously.
        :type async_req: bool, optional
        :param _preload_content: if False, the ApiResponse.data will
                                 be set to none and raw_data will store the
                                 HTTP response body without reading/decoding.
                                 Default is True.
        :type _preload_content: bool, optional
        :param _return_http_data_only: response data instead of ApiResponse
                                       object with status code, headers, etc
        :type _return_http_data_only: bool, optional
        :param _request_timeout: timeout setting for this request. If one
                                 number provided, it will be total request
                                 timeout. It can also be a pair (tuple) of
                                 (connection, read) timeouts.
        :param _request_auth: set to override the auth_settings for an a single
                              request; this effectively ignores the authentication
                              in the spec for a single request.
        :type _request_auth: dict, optional
        :type _content_type: string, optional: force content-type for the request
        :return: Returns the result object.
                 If the method is called asynchronously,
                 returns the request thread.
        :rtype: tuple(object, status_code(int), headers(HTTPHeaderDict))
        """

        _params = locals()

        _all_params = ["path", "parameters"]
        _all_params.extend(
            [
                "async_req",
                "_return_http_data_only",
                "_preload_content",
                "_request_timeout",
                "_request_auth",
                "_content_type",
                "_headers",
            ]
        )

        # validate the arguments
        for _key, _val in _params["kwargs"].items():
            if _key not in _all_params:
                raise ApiTypeError(
                    "Got an unexpected keyword argument '%s'" " to method get" % _key
                )
            _params[_key] = _val
        del _params["kwargs"]

        _collection_formats = {}

        # process the path parameters
        _path_params = {}
        if _params["path"]:
            _path_params["path"] = _params["path"]

        # process the query parameters
        _query_params = []
        if _params.get("parameters") is not None:  # noqa: E501
            _query_params.append(("parameters", _params["parameters"]))

        # process the header parameters
        _header_params = dict(_params.get("_headers", {}))
        # process the form parameters
        _form_params = []
        _files = {}
        # process the body parameter
        _body_params = None
        # set the HTTP header `Accept`
        _header_params["Accept"] = self.api_client.select_header_accept(
            ["application/json"]
        )  # noqa: E501

        # authentication setting
        _auth_settings = ["apiKey", "appId"]  # noqa: E501

        _response_types_map = {
            "200": "object",
            "400": "ErrorBase",
            "402": "ErrorBase",
            "403": "ErrorBase",
            "404": "ErrorBase",
        }

        return self.api_client.call_api(
            "/1{path}",
            "GET",
            _path_params,
            _query_params,
            _header_params,
            body=_body_params,
            post_params=_form_params,
            files=_files,
            response_types_map=_response_types_map,
            auth_settings=_auth_settings,
            async_req=_params.get("async_req"),
            _return_http_data_only=_params.get("_return_http_data_only"),  # noqa: E501
            _preload_content=_params.get("_preload_content", True),
            _request_timeout=_params.get("_request_timeout"),
            collection_formats=_collection_formats,
            _request_auth=_params.get("_request_auth"),
        )

    @validate_arguments
    def post(
        self,
        path: Annotated[
            StrictStr,
            Field(
                ...,
                description='Path of the endpoint, anything after "/1" must be specified.',
            ),
        ],
        parameters: Annotated[
            Optional[Dict[str, Any]],
            Field(description="Query parameters to apply to the current query."),
        ] = None,
        body: Annotated[
            Optional[Dict[str, Any]],
            Field(description="Parameters to send with the custom request."),
        ] = None,
        **kwargs,
    ) -> object:  # noqa: E501
        """Send requests to the Algolia REST API.  # noqa: E501

        This method allow you to send requests to the Algolia REST API.  # noqa: E501
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please pass async_req=True

        >>> thread = api.post(path, parameters, body, async_req=True)
        >>> result = thread.get()

        :param path: Path of the endpoint, anything after \"/1\" must be specified. (required)
        :type path: str
        :param parameters: Query parameters to apply to the current query.
        :type parameters: Dict[str, object]
        :param body: Parameters to send with the custom request.
        :type body: object
        :param async_req: Whether to execute the request asynchronously.
        :type async_req: bool, optional
        :param _request_timeout: timeout setting for this request.
               If one number provided, it will be total request
               timeout. It can also be a pair (tuple) of
               (connection, read) timeouts.
        :return: Returns the result object.
                 If the method is called asynchronously,
                 returns the request thread.
        :rtype: object
        """
        kwargs["_return_http_data_only"] = True
        if "_preload_content" in kwargs:
            message = "Error! Please call the post_with_http_info method with `_preload_content` instead and obtain raw data from ApiResponse.raw_data"  # noqa: E501
            raise ValueError(message)
        return self.post_with_http_info(path, parameters, body, **kwargs)  # noqa: E501

    @validate_arguments
    def post_with_http_info(
        self,
        path: Annotated[
            StrictStr,
            Field(
                ...,
                description='Path of the endpoint, anything after "/1" must be specified.',
            ),
        ],
        parameters: Annotated[
            Optional[Dict[str, Any]],
            Field(description="Query parameters to apply to the current query."),
        ] = None,
        body: Annotated[
            Optional[Dict[str, Any]],
            Field(description="Parameters to send with the custom request."),
        ] = None,
        **kwargs,
    ) -> ApiResponse:  # noqa: E501
        """Send requests to the Algolia REST API.  # noqa: E501

        This method allow you to send requests to the Algolia REST API.  # noqa: E501
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please pass async_req=True

        >>> thread = api.post_with_http_info(path, parameters, body, async_req=True)
        >>> result = thread.get()

        :param path: Path of the endpoint, anything after \"/1\" must be specified. (required)
        :type path: str
        :param parameters: Query parameters to apply to the current query.
        :type parameters: Dict[str, object]
        :param body: Parameters to send with the custom request.
        :type body: object
        :param async_req: Whether to execute the request asynchronously.
        :type async_req: bool, optional
        :param _preload_content: if False, the ApiResponse.data will
                                 be set to none and raw_data will store the
                                 HTTP response body without reading/decoding.
                                 Default is True.
        :type _preload_content: bool, optional
        :param _return_http_data_only: response data instead of ApiResponse
                                       object with status code, headers, etc
        :type _return_http_data_only: bool, optional
        :param _request_timeout: timeout setting for this request. If one
                                 number provided, it will be total request
                                 timeout. It can also be a pair (tuple) of
                                 (connection, read) timeouts.
        :param _request_auth: set to override the auth_settings for an a single
                              request; this effectively ignores the authentication
                              in the spec for a single request.
        :type _request_auth: dict, optional
        :type _content_type: string, optional: force content-type for the request
        :return: Returns the result object.
                 If the method is called asynchronously,
                 returns the request thread.
        :rtype: tuple(object, status_code(int), headers(HTTPHeaderDict))
        """

        _params = locals()

        _all_params = ["path", "parameters", "body"]
        _all_params.extend(
            [
                "async_req",
                "_return_http_data_only",
                "_preload_content",
                "_request_timeout",
                "_request_auth",
                "_content_type",
                "_headers",
            ]
        )

        # validate the arguments
        for _key, _val in _params["kwargs"].items():
            if _key not in _all_params:
                raise ApiTypeError(
                    "Got an unexpected keyword argument '%s'" " to method post" % _key
                )
            _params[_key] = _val
        del _params["kwargs"]

        _collection_formats = {}

        # process the path parameters
        _path_params = {}
        if _params["path"]:
            _path_params["path"] = _params["path"]

        # process the query parameters
        _query_params = []
        if _params.get("parameters") is not None:  # noqa: E501
            _query_params.append(("parameters", _params["parameters"]))

        # process the header parameters
        _header_params = dict(_params.get("_headers", {}))
        # process the form parameters
        _form_params = []
        _files = {}
        # process the body parameter
        _body_params = None
        if _params["body"] is not None:
            _body_params = _params["body"]

        # set the HTTP header `Accept`
        _header_params["Accept"] = self.api_client.select_header_accept(
            ["application/json"]
        )  # noqa: E501

        # set the HTTP header `Content-Type`
        _content_types_list = _params.get(
            "_content_type",
            self.api_client.select_header_content_type(["application/json"]),
        )
        if _content_types_list:
            _header_params["Content-Type"] = _content_types_list

        # authentication setting
        _auth_settings = ["apiKey", "appId"]  # noqa: E501

        _response_types_map = {
            "200": "object",
            "400": "ErrorBase",
            "402": "ErrorBase",
            "403": "ErrorBase",
            "404": "ErrorBase",
        }

        return self.api_client.call_api(
            "/1{path}",
            "POST",
            _path_params,
            _query_params,
            _header_params,
            body=_body_params,
            post_params=_form_params,
            files=_files,
            response_types_map=_response_types_map,
            auth_settings=_auth_settings,
            async_req=_params.get("async_req"),
            _return_http_data_only=_params.get("_return_http_data_only"),  # noqa: E501
            _preload_content=_params.get("_preload_content", True),
            _request_timeout=_params.get("_request_timeout"),
            collection_formats=_collection_formats,
            _request_auth=_params.get("_request_auth"),
        )

    @validate_arguments
    def push_events(self, insights_events: InsightsEvents, **kwargs) -> EventsResponse:  # noqa: E501
        """Send events.  # noqa: E501

        Send a list of events to the Insights API.  You can include up to 1,000 events in a single request, but the request body must be smaller than 2&nbsp;MB.   # noqa: E501
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please pass async_req=True

        >>> thread = api.push_events(insights_events, async_req=True)
        >>> result = thread.get()

        :param insights_events: (required)
        :type insights_events: InsightsEvents
        :param async_req: Whether to execute the request asynchronously.
        :type async_req: bool, optional
        :param _request_timeout: timeout setting for this request.
               If one number provided, it will be total request
               timeout. It can also be a pair (tuple) of
               (connection, read) timeouts.
        :return: Returns the result object.
                 If the method is called asynchronously,
                 returns the request thread.
        :rtype: EventsResponse
        """
        kwargs["_return_http_data_only"] = True
        if "_preload_content" in kwargs:
            message = "Error! Please call the push_events_with_http_info method with `_preload_content` instead and obtain raw data from ApiResponse.raw_data"  # noqa: E501
            raise ValueError(message)
        return self.push_events_with_http_info(insights_events, **kwargs)  # noqa: E501

    @validate_arguments
    def push_events_with_http_info(
        self, insights_events: InsightsEvents, **kwargs
    ) -> ApiResponse:  # noqa: E501
        """Send events.  # noqa: E501

        Send a list of events to the Insights API.  You can include up to 1,000 events in a single request, but the request body must be smaller than 2&nbsp;MB.   # noqa: E501
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please pass async_req=True

        >>> thread = api.push_events_with_http_info(insights_events, async_req=True)
        >>> result = thread.get()

        :param insights_events: (required)
        :type insights_events: InsightsEvents
        :param async_req: Whether to execute the request asynchronously.
        :type async_req: bool, optional
        :param _preload_content: if False, the ApiResponse.data will
                                 be set to none and raw_data will store the
                                 HTTP response body without reading/decoding.
                                 Default is True.
        :type _preload_content: bool, optional
        :param _return_http_data_only: response data instead of ApiResponse
                                       object with status code, headers, etc
        :type _return_http_data_only: bool, optional
        :param _request_timeout: timeout setting for this request. If one
                                 number provided, it will be total request
                                 timeout. It can also be a pair (tuple) of
                                 (connection, read) timeouts.
        :param _request_auth: set to override the auth_settings for an a single
                              request; this effectively ignores the authentication
                              in the spec for a single request.
        :type _request_auth: dict, optional
        :type _content_type: string, optional: force content-type for the request
        :return: Returns the result object.
                 If the method is called asynchronously,
                 returns the request thread.
        :rtype: tuple(EventsResponse, status_code(int), headers(HTTPHeaderDict))
        """

        _params = locals()

        _all_params = ["insights_events"]
        _all_params.extend(
            [
                "async_req",
                "_return_http_data_only",
                "_preload_content",
                "_request_timeout",
                "_request_auth",
                "_content_type",
                "_headers",
            ]
        )

        # validate the arguments
        for _key, _val in _params["kwargs"].items():
            if _key not in _all_params:
                raise ApiTypeError(
                    "Got an unexpected keyword argument '%s'"
                    " to method push_events" % _key
                )
            _params[_key] = _val
        del _params["kwargs"]

        _collection_formats = {}

        # process the path parameters
        _path_params = {}

        # process the query parameters
        _query_params = []
        # process the header parameters
        _header_params = dict(_params.get("_headers", {}))
        # process the form parameters
        _form_params = []
        _files = {}
        # process the body parameter
        _body_params = None
        if _params["insights_events"] is not None:
            _body_params = _params["insights_events"]

        # set the HTTP header `Accept`
        _header_params["Accept"] = self.api_client.select_header_accept(
            ["application/json", "text/html"]
        )  # noqa: E501

        # set the HTTP header `Content-Type`
        _content_types_list = _params.get(
            "_content_type",
            self.api_client.select_header_content_type(["application/json"]),
        )
        if _content_types_list:
            _header_params["Content-Type"] = _content_types_list

        # authentication setting
        _auth_settings = ["apiKey", "appId"]  # noqa: E501

        _response_types_map = {
            "200": "EventsResponse",
            "400": "str",
            "401": "EventsResponse",
            "404": "EventsResponse",
            "405": "EventsResponse",
            "413": "EventsResponse",
            "422": "EventsResponse",
        }

        return self.api_client.call_api(
            "/1/events",
            "POST",
            _path_params,
            _query_params,
            _header_params,
            body=_body_params,
            post_params=_form_params,
            files=_files,
            response_types_map=_response_types_map,
            auth_settings=_auth_settings,
            async_req=_params.get("async_req"),
            _return_http_data_only=_params.get("_return_http_data_only"),  # noqa: E501
            _preload_content=_params.get("_preload_content", True),
            _request_timeout=_params.get("_request_timeout"),
            collection_formats=_collection_formats,
            _request_auth=_params.get("_request_auth"),
        )

    @validate_arguments
    def put(
        self,
        path: Annotated[
            StrictStr,
            Field(
                ...,
                description='Path of the endpoint, anything after "/1" must be specified.',
            ),
        ],
        parameters: Annotated[
            Optional[Dict[str, Any]],
            Field(description="Query parameters to apply to the current query."),
        ] = None,
        body: Annotated[
            Optional[Dict[str, Any]],
            Field(description="Parameters to send with the custom request."),
        ] = None,
        **kwargs,
    ) -> object:  # noqa: E501
        """Send requests to the Algolia REST API.  # noqa: E501

        This method allow you to send requests to the Algolia REST API.  # noqa: E501
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please pass async_req=True

        >>> thread = api.put(path, parameters, body, async_req=True)
        >>> result = thread.get()

        :param path: Path of the endpoint, anything after \"/1\" must be specified. (required)
        :type path: str
        :param parameters: Query parameters to apply to the current query.
        :type parameters: Dict[str, object]
        :param body: Parameters to send with the custom request.
        :type body: object
        :param async_req: Whether to execute the request asynchronously.
        :type async_req: bool, optional
        :param _request_timeout: timeout setting for this request.
               If one number provided, it will be total request
               timeout. It can also be a pair (tuple) of
               (connection, read) timeouts.
        :return: Returns the result object.
                 If the method is called asynchronously,
                 returns the request thread.
        :rtype: object
        """
        kwargs["_return_http_data_only"] = True
        if "_preload_content" in kwargs:
            message = "Error! Please call the put_with_http_info method with `_preload_content` instead and obtain raw data from ApiResponse.raw_data"  # noqa: E501
            raise ValueError(message)
        return self.put_with_http_info(path, parameters, body, **kwargs)  # noqa: E501

    @validate_arguments
    def put_with_http_info(
        self,
        path: Annotated[
            StrictStr,
            Field(
                ...,
                description='Path of the endpoint, anything after "/1" must be specified.',
            ),
        ],
        parameters: Annotated[
            Optional[Dict[str, Any]],
            Field(description="Query parameters to apply to the current query."),
        ] = None,
        body: Annotated[
            Optional[Dict[str, Any]],
            Field(description="Parameters to send with the custom request."),
        ] = None,
        **kwargs,
    ) -> ApiResponse:  # noqa: E501
        """Send requests to the Algolia REST API.  # noqa: E501

        This method allow you to send requests to the Algolia REST API.  # noqa: E501
        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please pass async_req=True

        >>> thread = api.put_with_http_info(path, parameters, body, async_req=True)
        >>> result = thread.get()

        :param path: Path of the endpoint, anything after \"/1\" must be specified. (required)
        :type path: str
        :param parameters: Query parameters to apply to the current query.
        :type parameters: Dict[str, object]
        :param body: Parameters to send with the custom request.
        :type body: object
        :param async_req: Whether to execute the request asynchronously.
        :type async_req: bool, optional
        :param _preload_content: if False, the ApiResponse.data will
                                 be set to none and raw_data will store the
                                 HTTP response body without reading/decoding.
                                 Default is True.
        :type _preload_content: bool, optional
        :param _return_http_data_only: response data instead of ApiResponse
                                       object with status code, headers, etc
        :type _return_http_data_only: bool, optional
        :param _request_timeout: timeout setting for this request. If one
                                 number provided, it will be total request
                                 timeout. It can also be a pair (tuple) of
                                 (connection, read) timeouts.
        :param _request_auth: set to override the auth_settings for an a single
                              request; this effectively ignores the authentication
                              in the spec for a single request.
        :type _request_auth: dict, optional
        :type _content_type: string, optional: force content-type for the request
        :return: Returns the result object.
                 If the method is called asynchronously,
                 returns the request thread.
        :rtype: tuple(object, status_code(int), headers(HTTPHeaderDict))
        """

        _params = locals()

        _all_params = ["path", "parameters", "body"]
        _all_params.extend(
            [
                "async_req",
                "_return_http_data_only",
                "_preload_content",
                "_request_timeout",
                "_request_auth",
                "_content_type",
                "_headers",
            ]
        )

        # validate the arguments
        for _key, _val in _params["kwargs"].items():
            if _key not in _all_params:
                raise ApiTypeError(
                    "Got an unexpected keyword argument '%s'" " to method put" % _key
                )
            _params[_key] = _val
        del _params["kwargs"]

        _collection_formats = {}

        # process the path parameters
        _path_params = {}
        if _params["path"]:
            _path_params["path"] = _params["path"]

        # process the query parameters
        _query_params = []
        if _params.get("parameters") is not None:  # noqa: E501
            _query_params.append(("parameters", _params["parameters"]))

        # process the header parameters
        _header_params = dict(_params.get("_headers", {}))
        # process the form parameters
        _form_params = []
        _files = {}
        # process the body parameter
        _body_params = None
        if _params["body"] is not None:
            _body_params = _params["body"]

        # set the HTTP header `Accept`
        _header_params["Accept"] = self.api_client.select_header_accept(
            ["application/json"]
        )  # noqa: E501

        # set the HTTP header `Content-Type`
        _content_types_list = _params.get(
            "_content_type",
            self.api_client.select_header_content_type(["application/json"]),
        )
        if _content_types_list:
            _header_params["Content-Type"] = _content_types_list

        # authentication setting
        _auth_settings = ["apiKey", "appId"]  # noqa: E501

        _response_types_map = {
            "200": "object",
            "400": "ErrorBase",
            "402": "ErrorBase",
            "403": "ErrorBase",
            "404": "ErrorBase",
        }

        return self.api_client.call_api(
            "/1{path}",
            "PUT",
            _path_params,
            _query_params,
            _header_params,
            body=_body_params,
            post_params=_form_params,
            files=_files,
            response_types_map=_response_types_map,
            auth_settings=_auth_settings,
            async_req=_params.get("async_req"),
            _return_http_data_only=_params.get("_return_http_data_only"),  # noqa: E501
            _preload_content=_params.get("_preload_content", True),
            _request_timeout=_params.get("_request_timeout"),
            collection_formats=_collection_formats,
            _request_auth=_params.get("_request_auth"),
        )
