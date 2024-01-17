# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import dumps
from typing import Annotated, Any, Dict, List, Optional, Self, Tuple, Union
from urllib.parse import quote

from pydantic import Field, StrictStr

from algoliasearch.http.api_response import ApiResponse
from algoliasearch.http.request_options import RequestOptions
from algoliasearch.http.serializer import bodySerializer
from algoliasearch.http.transporter import Transporter
from algoliasearch.http.verb import Verb
from algoliasearch.insights.config import InsightsConfig
from algoliasearch.insights.models.events_response import EventsResponse
from algoliasearch.insights.models.insights_events import InsightsEvents


class InsightsClient:
    """The Algolia 'InsightsClient' class.

    Args:
    app_id (str): The Algolia application ID to retrieve information from.
    api_key (str): The Algolia api key bound to the given `app_id`.
    region ("de" | "us"): The region of your Algolia application.

    Returns:
    The initialized API client.

    Example:
    _client = InsightsClient("YOUR_ALGOLIA_APP_ID", "YOUR_ALGOLIA_API_KEY", region="'de' or 'us'")
    _client_with_named_args = InsightsClient(app_id="YOUR_ALGOLIA_APP_ID", api_key="YOUR_ALGOLIA_API_KEY", region="'de' or 'us'")

    See `InsightsClient.create_with_config` for advanced configuration.
    """

    _transporter: Transporter
    _config: InsightsConfig
    _request_options: RequestOptions

    def __init__(
        self,
        app_id: Optional[str] = None,
        api_key: Optional[str] = None,
        region: Optional[str] = None,
        transporter: Optional[Transporter] = None,
        config: Optional[InsightsConfig] = None,
    ) -> None:
        if transporter is not None and config is None:
            config = transporter._config

        if config is None:
            config = InsightsConfig(app_id, api_key, region)
        self._config = config
        self._request_options = RequestOptions(config)

        if transporter is None:
            transporter = Transporter(config)
        self._transporter = transporter

    def create_with_config(
        config: InsightsConfig, transporter: Optional[Transporter] = None
    ) -> Self:
        """Allows creating a client with a customized `InsightsConfig` and `Transporter`. If `transporter` is not provided, the default one will be initialized from the given `config`.

        Args:
        config (InsightsConfig): The config of the API client.
        transporter (Transporter): The HTTP transporter, see `http/transporter.py` for implementation details.

        Returns:
        The initialized API client.

        Example:
        _client_with_custom_config = InsightsClient.create_with_config(config=InsightsConfig(...))
        _client_with_custom_config_and_transporter = InsightsClient.create_with_config(config=InsightsConfig(...), transporter=Transporter(...))
        """
        if transporter is None:
            transporter = Transporter(config)

        return InsightsClient(
            app_id=config.app_id,
            api_key=config.api_key,
            region=config.region,
            transporter=transporter,
            config=config,
        )

    async def __aenter__(self) -> None:
        return self

    async def __aexit__(self, exc_type, exc_value, traceback) -> None:
        """Closes the underlying `transporter` of the API client."""
        await self.close()

    async def close(self) -> None:
        """Closes the underlying `transporter` of the API client."""
        return await self._transporter.close()

    async def custom_delete_with_http_info(
        self,
        path: Annotated[
            StrictStr,
            Field(
                description='Path of the endpoint, anything after "/1" must be specified.'
            ),
        ],
        parameters: Annotated[
            Optional[Dict[str, Any]],
            Field(description="Query parameters to apply to the current query."),
        ] = None,
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> ApiResponse[str]:
        """
        Send requests to the Algolia REST API.

        This method allow you to send requests to the Algolia REST API.

        :param path: Path of the endpoint, anything after \"/1\" must be specified. (required)
        :type path: str
        :param parameters: Query parameters to apply to the current query.
        :type parameters: Dict[str, object]
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        if path is None:
            raise ValueError(
                "Parameter `path` is required when calling `custom_delete`."
            )

        _query_parameters: List[Tuple[str, str]] = []

        if parameters is not None:
            for _qpkey, _qpvalue in parameters.items():
                _query_parameters.append((_qpkey, _qpvalue))

        return await self._transporter.request(
            verb=Verb.DELETE,
            path="/1{path}".replace("{path}", path),
            request_options=self._request_options.merge(
                query_parameters=_query_parameters,
                user_request_options=request_options,
            ),
            use_read_transporter=False,
        )

    async def custom_delete(
        self,
        path: Annotated[
            StrictStr,
            Field(
                description='Path of the endpoint, anything after "/1" must be specified.'
            ),
        ],
        parameters: Annotated[
            Optional[Dict[str, Any]],
            Field(description="Query parameters to apply to the current query."),
        ] = None,
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> object:
        """
        Send requests to the Algolia REST API.

        This method allow you to send requests to the Algolia REST API.

        :param path: Path of the endpoint, anything after \"/1\" must be specified. (required)
        :type path: str
        :param parameters: Query parameters to apply to the current query.
        :type parameters: Dict[str, object]
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the deserialized response in a 'object' result object.
        """
        return (
            await self.custom_delete_with_http_info(path, parameters, request_options)
        ).deserialize(object)

    async def custom_get_with_http_info(
        self,
        path: Annotated[
            StrictStr,
            Field(
                description='Path of the endpoint, anything after "/1" must be specified.'
            ),
        ],
        parameters: Annotated[
            Optional[Dict[str, Any]],
            Field(description="Query parameters to apply to the current query."),
        ] = None,
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> ApiResponse[str]:
        """
        Send requests to the Algolia REST API.

        This method allow you to send requests to the Algolia REST API.

        :param path: Path of the endpoint, anything after \"/1\" must be specified. (required)
        :type path: str
        :param parameters: Query parameters to apply to the current query.
        :type parameters: Dict[str, object]
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        if path is None:
            raise ValueError("Parameter `path` is required when calling `custom_get`.")

        _query_parameters: List[Tuple[str, str]] = []

        if parameters is not None:
            for _qpkey, _qpvalue in parameters.items():
                _query_parameters.append((_qpkey, _qpvalue))

        return await self._transporter.request(
            verb=Verb.GET,
            path="/1{path}".replace("{path}", path),
            request_options=self._request_options.merge(
                query_parameters=_query_parameters,
                user_request_options=request_options,
            ),
            use_read_transporter=False,
        )

    async def custom_get(
        self,
        path: Annotated[
            StrictStr,
            Field(
                description='Path of the endpoint, anything after "/1" must be specified.'
            ),
        ],
        parameters: Annotated[
            Optional[Dict[str, Any]],
            Field(description="Query parameters to apply to the current query."),
        ] = None,
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> object:
        """
        Send requests to the Algolia REST API.

        This method allow you to send requests to the Algolia REST API.

        :param path: Path of the endpoint, anything after \"/1\" must be specified. (required)
        :type path: str
        :param parameters: Query parameters to apply to the current query.
        :type parameters: Dict[str, object]
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the deserialized response in a 'object' result object.
        """
        return (
            await self.custom_get_with_http_info(path, parameters, request_options)
        ).deserialize(object)

    async def custom_post_with_http_info(
        self,
        path: Annotated[
            StrictStr,
            Field(
                description='Path of the endpoint, anything after "/1" must be specified.'
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
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> ApiResponse[str]:
        """
        Send requests to the Algolia REST API.

        This method allow you to send requests to the Algolia REST API.

        :param path: Path of the endpoint, anything after \"/1\" must be specified. (required)
        :type path: str
        :param parameters: Query parameters to apply to the current query.
        :type parameters: Dict[str, object]
        :param body: Parameters to send with the custom request.
        :type body: object
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        if path is None:
            raise ValueError("Parameter `path` is required when calling `custom_post`.")

        _query_parameters: List[Tuple[str, str]] = []

        if parameters is not None:
            for _qpkey, _qpvalue in parameters.items():
                _query_parameters.append((_qpkey, _qpvalue))

        _data = {}
        if body is not None:
            _data = body

        return await self._transporter.request(
            verb=Verb.POST,
            path="/1{path}".replace("{path}", path),
            request_options=self._request_options.merge(
                query_parameters=_query_parameters,
                data=dumps(bodySerializer(_data)),
                user_request_options=request_options,
            ),
            use_read_transporter=False,
        )

    async def custom_post(
        self,
        path: Annotated[
            StrictStr,
            Field(
                description='Path of the endpoint, anything after "/1" must be specified.'
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
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> object:
        """
        Send requests to the Algolia REST API.

        This method allow you to send requests to the Algolia REST API.

        :param path: Path of the endpoint, anything after \"/1\" must be specified. (required)
        :type path: str
        :param parameters: Query parameters to apply to the current query.
        :type parameters: Dict[str, object]
        :param body: Parameters to send with the custom request.
        :type body: object
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the deserialized response in a 'object' result object.
        """
        return (
            await self.custom_post_with_http_info(
                path, parameters, body, request_options
            )
        ).deserialize(object)

    async def custom_put_with_http_info(
        self,
        path: Annotated[
            StrictStr,
            Field(
                description='Path of the endpoint, anything after "/1" must be specified.'
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
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> ApiResponse[str]:
        """
        Send requests to the Algolia REST API.

        This method allow you to send requests to the Algolia REST API.

        :param path: Path of the endpoint, anything after \"/1\" must be specified. (required)
        :type path: str
        :param parameters: Query parameters to apply to the current query.
        :type parameters: Dict[str, object]
        :param body: Parameters to send with the custom request.
        :type body: object
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        if path is None:
            raise ValueError("Parameter `path` is required when calling `custom_put`.")

        _query_parameters: List[Tuple[str, str]] = []

        if parameters is not None:
            for _qpkey, _qpvalue in parameters.items():
                _query_parameters.append((_qpkey, _qpvalue))

        _data = {}
        if body is not None:
            _data = body

        return await self._transporter.request(
            verb=Verb.PUT,
            path="/1{path}".replace("{path}", path),
            request_options=self._request_options.merge(
                query_parameters=_query_parameters,
                data=dumps(bodySerializer(_data)),
                user_request_options=request_options,
            ),
            use_read_transporter=False,
        )

    async def custom_put(
        self,
        path: Annotated[
            StrictStr,
            Field(
                description='Path of the endpoint, anything after "/1" must be specified.'
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
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> object:
        """
        Send requests to the Algolia REST API.

        This method allow you to send requests to the Algolia REST API.

        :param path: Path of the endpoint, anything after \"/1\" must be specified. (required)
        :type path: str
        :param parameters: Query parameters to apply to the current query.
        :type parameters: Dict[str, object]
        :param body: Parameters to send with the custom request.
        :type body: object
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the deserialized response in a 'object' result object.
        """
        return (
            await self.custom_put_with_http_info(
                path, parameters, body, request_options
            )
        ).deserialize(object)

    async def delete_user_token_with_http_info(
        self,
        user_token: Annotated[
            str,
            Field(
                min_length=1,
                strict=True,
                max_length=129,
                description="The user token for which to delete all associated events.",
            ),
        ],
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> ApiResponse[str]:
        """
        Delete user token.

        Delete all events related to a certain user token from events metrics and analytics. To delete a personalization user profile, see [Delete a user profile](https://www.algolia.com/doc/rest-api/personalization/#delete-a-user-profile).

        :param user_token: The user token for which to delete all associated events. (required)
        :type user_token: str
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        if user_token is None:
            raise ValueError(
                "Parameter `user_token` is required when calling `delete_user_token`."
            )

        return await self._transporter.request(
            verb=Verb.DELETE,
            path="/1/usertokens/{userToken}".replace(
                "{userToken}", quote(str(user_token), safe="")
            ),
            request_options=self._request_options.merge(
                user_request_options=request_options,
            ),
            use_read_transporter=False,
        )

    async def delete_user_token(
        self,
        user_token: Annotated[
            str,
            Field(
                min_length=1,
                strict=True,
                max_length=129,
                description="The user token for which to delete all associated events.",
            ),
        ],
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> None:
        """
        Delete user token.

        Delete all events related to a certain user token from events metrics and analytics. To delete a personalization user profile, see [Delete a user profile](https://www.algolia.com/doc/rest-api/personalization/#delete-a-user-profile).

        :param user_token: The user token for which to delete all associated events. (required)
        :type user_token: str
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        """
        return (
            await self.delete_user_token_with_http_info(user_token, request_options)
        ).deserialize()

    async def push_events_with_http_info(
        self,
        insights_events: InsightsEvents,
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> ApiResponse[str]:
        """
        Send events.

        Send a list of events to the Insights API.  You can include up to 1,000 events in a single request, but the request body must be smaller than 2&nbsp;MB.

        :param insights_events: (required)
        :type insights_events: InsightsEvents
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        if insights_events is None:
            raise ValueError(
                "Parameter `insights_events` is required when calling `push_events`."
            )

        _data = {}
        if insights_events is not None:
            _data = insights_events

        return await self._transporter.request(
            verb=Verb.POST,
            path="/1/events",
            request_options=self._request_options.merge(
                data=dumps(bodySerializer(_data)),
                user_request_options=request_options,
            ),
            use_read_transporter=False,
        )

    async def push_events(
        self,
        insights_events: InsightsEvents,
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> EventsResponse:
        """
        Send events.

        Send a list of events to the Insights API.  You can include up to 1,000 events in a single request, but the request body must be smaller than 2&nbsp;MB.

        :param insights_events: (required)
        :type insights_events: InsightsEvents
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the deserialized response in a 'EventsResponse' result object.
        """
        return (
            await self.push_events_with_http_info(insights_events, request_options)
        ).deserialize(EventsResponse)
