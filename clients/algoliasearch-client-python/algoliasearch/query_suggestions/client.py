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
from algoliasearch.query_suggestions.config import QuerySuggestionsConfig
from algoliasearch.query_suggestions.models.base_response import BaseResponse
from algoliasearch.query_suggestions.models.configuration import Configuration
from algoliasearch.query_suggestions.models.configuration_response import (
    ConfigurationResponse,
)
from algoliasearch.query_suggestions.models.configuration_with_index import (
    ConfigurationWithIndex,
)
from algoliasearch.query_suggestions.models.get_config_status200_response import (
    GetConfigStatus200Response,
)
from algoliasearch.query_suggestions.models.get_log_file200_response import (
    GetLogFile200Response,
)


class QuerySuggestionsClient:
    """The Algolia 'QuerySuggestionsClient' class.

    Args:
    app_id (str): The Algolia application ID to retrieve information from.
    api_key (str): The Algolia api key bound to the given `app_id`.
    region ("eu" | "us"): The region of your Algolia application.

    Returns:
    The initialized API client.

    Example:
    _client = QuerySuggestionsClient("YOUR_ALGOLIA_APP_ID", "YOUR_ALGOLIA_API_KEY", region="'eu' or 'us'")
    _client_with_named_args = QuerySuggestionsClient(app_id="YOUR_ALGOLIA_APP_ID", api_key="YOUR_ALGOLIA_API_KEY", region="'eu' or 'us'")

    See `QuerySuggestionsClient.create_with_config` for advanced configuration.
    """

    _transporter: Transporter
    _config: QuerySuggestionsConfig
    _request_options: RequestOptions

    def __init__(
        self,
        app_id: Optional[str] = None,
        api_key: Optional[str] = None,
        region: str = None,
        transporter: Optional[Transporter] = None,
        config: Optional[QuerySuggestionsConfig] = None,
    ) -> None:
        if transporter is not None and config is None:
            config = transporter._config

        if config is None:
            config = QuerySuggestionsConfig(app_id, api_key, region)
        self._config = config
        self._request_options = RequestOptions(config)

        if transporter is None:
            transporter = Transporter(config)
        self._transporter = transporter

    def create_with_config(
        config: QuerySuggestionsConfig, transporter: Optional[Transporter] = None
    ) -> Self:
        """Allows creating a client with a customized `QuerySuggestionsConfig` and `Transporter`. If `transporter` is not provided, the default one will be initialized from the given `config`.

        Args:
        config (QuerySuggestionsConfig): The config of the API client.
        transporter (Transporter): The HTTP transporter, see `http/transporter.py` for implementation details.

        Returns:
        The initialized API client.

        Example:
        _client_with_custom_config = QuerySuggestionsClient.create_with_config(config=QuerySuggestionsConfig(...))
        _client_with_custom_config_and_transporter = QuerySuggestionsClient.create_with_config(config=QuerySuggestionsConfig(...), transporter=Transporter(...))
        """
        if transporter is None:
            transporter = Transporter(config)

        return QuerySuggestionsClient(
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

    async def create_config_with_http_info(
        self,
        configuration_with_index: ConfigurationWithIndex,
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> ApiResponse[str]:
        """
        Creates a new Query Suggestions configuration.  You can have up to 100 configurations per Algolia application.

        Required API Key ACLs:
          - editSettings

        :param configuration_with_index: (required)
        :type configuration_with_index: ConfigurationWithIndex
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        if configuration_with_index is None:
            raise ValueError(
                "Parameter `configuration_with_index` is required when calling `create_config`."
            )

        _data = {}
        if configuration_with_index is not None:
            _data = configuration_with_index

        return await self._transporter.request(
            verb=Verb.POST,
            path="/1/configs",
            request_options=self._request_options.merge(
                data=dumps(bodySerializer(_data)),
                user_request_options=request_options,
            ),
            use_read_transporter=False,
        )

    async def create_config(
        self,
        configuration_with_index: ConfigurationWithIndex,
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> BaseResponse:
        """
        Creates a new Query Suggestions configuration.  You can have up to 100 configurations per Algolia application.

        Required API Key ACLs:
          - editSettings

        :param configuration_with_index: (required)
        :type configuration_with_index: ConfigurationWithIndex
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the deserialized response in a 'BaseResponse' result object.
        """
        return (
            await self.create_config_with_http_info(
                configuration_with_index, request_options
            )
        ).deserialize(BaseResponse)

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
            path="/{path}".replace("{path}", path),
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
            path="/{path}".replace("{path}", path),
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
            path="/{path}".replace("{path}", path),
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
            path="/{path}".replace("{path}", path),
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

    async def delete_config_with_http_info(
        self,
        index_name: Annotated[
            StrictStr, Field(description="Query Suggestions index name.")
        ],
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> ApiResponse[str]:
        """
        Deletes a Query Suggestions configuration.  Deleting only removes the configuration and stops updates to the Query Suggestions index. To delete the Query Suggestions index itself, use the Search API and the [Delete an index](/specs/search#tag/Indices/operation/deleteIndex) operation.

        Required API Key ACLs:
          - editSettings

        :param index_name: Query Suggestions index name. (required)
        :type index_name: str
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        if index_name is None:
            raise ValueError(
                "Parameter `index_name` is required when calling `delete_config`."
            )

        return await self._transporter.request(
            verb=Verb.DELETE,
            path="/1/configs/{indexName}".replace(
                "{indexName}", quote(str(index_name), safe="")
            ),
            request_options=self._request_options.merge(
                user_request_options=request_options,
            ),
            use_read_transporter=False,
        )

    async def delete_config(
        self,
        index_name: Annotated[
            StrictStr, Field(description="Query Suggestions index name.")
        ],
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> BaseResponse:
        """
        Deletes a Query Suggestions configuration.  Deleting only removes the configuration and stops updates to the Query Suggestions index. To delete the Query Suggestions index itself, use the Search API and the [Delete an index](/specs/search#tag/Indices/operation/deleteIndex) operation.

        Required API Key ACLs:
          - editSettings

        :param index_name: Query Suggestions index name. (required)
        :type index_name: str
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the deserialized response in a 'BaseResponse' result object.
        """
        return (
            await self.delete_config_with_http_info(index_name, request_options)
        ).deserialize(BaseResponse)

    async def get_all_configs_with_http_info(
        self, request_options: Optional[Union[dict, RequestOptions]] = None
    ) -> ApiResponse[str]:
        """
        Retrieves all Query Suggestions configurations of your Algolia application.

        Required API Key ACLs:
          - settings

        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        return await self._transporter.request(
            verb=Verb.GET,
            path="/1/configs",
            request_options=self._request_options.merge(
                user_request_options=request_options,
            ),
            use_read_transporter=False,
        )

    async def get_all_configs(
        self, request_options: Optional[Union[dict, RequestOptions]] = None
    ) -> List[ConfigurationResponse]:
        """
        Retrieves all Query Suggestions configurations of your Algolia application.

        Required API Key ACLs:
          - settings

        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the deserialized response in a 'List[ConfigurationResponse]' result object.
        """
        return (await self.get_all_configs_with_http_info(request_options)).deserialize(
            List[ConfigurationResponse]
        )

    async def get_config_with_http_info(
        self,
        index_name: Annotated[
            StrictStr, Field(description="Query Suggestions index name.")
        ],
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> ApiResponse[str]:
        """
        Retrieves a single Query Suggestions configuration by its index name.

        Required API Key ACLs:
          - settings

        :param index_name: Query Suggestions index name. (required)
        :type index_name: str
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        if index_name is None:
            raise ValueError(
                "Parameter `index_name` is required when calling `get_config`."
            )

        return await self._transporter.request(
            verb=Verb.GET,
            path="/1/configs/{indexName}".replace(
                "{indexName}", quote(str(index_name), safe="")
            ),
            request_options=self._request_options.merge(
                user_request_options=request_options,
            ),
            use_read_transporter=False,
        )

    async def get_config(
        self,
        index_name: Annotated[
            StrictStr, Field(description="Query Suggestions index name.")
        ],
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> ConfigurationResponse:
        """
        Retrieves a single Query Suggestions configuration by its index name.

        Required API Key ACLs:
          - settings

        :param index_name: Query Suggestions index name. (required)
        :type index_name: str
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the deserialized response in a 'ConfigurationResponse' result object.
        """
        return (
            await self.get_config_with_http_info(index_name, request_options)
        ).deserialize(ConfigurationResponse)

    async def get_config_status_with_http_info(
        self,
        index_name: Annotated[
            StrictStr, Field(description="Query Suggestions index name.")
        ],
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> ApiResponse[str]:
        """
        Reports the status of a Query Suggestions index.

        Required API Key ACLs:
          - settings

        :param index_name: Query Suggestions index name. (required)
        :type index_name: str
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        if index_name is None:
            raise ValueError(
                "Parameter `index_name` is required when calling `get_config_status`."
            )

        return await self._transporter.request(
            verb=Verb.GET,
            path="/1/configs/{indexName}/status".replace(
                "{indexName}", quote(str(index_name), safe="")
            ),
            request_options=self._request_options.merge(
                user_request_options=request_options,
            ),
            use_read_transporter=False,
        )

    async def get_config_status(
        self,
        index_name: Annotated[
            StrictStr, Field(description="Query Suggestions index name.")
        ],
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> GetConfigStatus200Response:
        """
        Reports the status of a Query Suggestions index.

        Required API Key ACLs:
          - settings

        :param index_name: Query Suggestions index name. (required)
        :type index_name: str
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the deserialized response in a 'GetConfigStatus200Response' result object.
        """
        return (
            await self.get_config_status_with_http_info(index_name, request_options)
        ).deserialize(GetConfigStatus200Response)

    async def get_log_file_with_http_info(
        self,
        index_name: Annotated[
            StrictStr, Field(description="Query Suggestions index name.")
        ],
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> ApiResponse[str]:
        """
        Retrieves the logs for a single Query Suggestions index.

        Required API Key ACLs:
          - settings

        :param index_name: Query Suggestions index name. (required)
        :type index_name: str
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        if index_name is None:
            raise ValueError(
                "Parameter `index_name` is required when calling `get_log_file`."
            )

        return await self._transporter.request(
            verb=Verb.GET,
            path="/1/logs/{indexName}".replace(
                "{indexName}", quote(str(index_name), safe="")
            ),
            request_options=self._request_options.merge(
                user_request_options=request_options,
            ),
            use_read_transporter=False,
        )

    async def get_log_file(
        self,
        index_name: Annotated[
            StrictStr, Field(description="Query Suggestions index name.")
        ],
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> GetLogFile200Response:
        """
        Retrieves the logs for a single Query Suggestions index.

        Required API Key ACLs:
          - settings

        :param index_name: Query Suggestions index name. (required)
        :type index_name: str
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the deserialized response in a 'GetLogFile200Response' result object.
        """
        return (
            await self.get_log_file_with_http_info(index_name, request_options)
        ).deserialize(GetLogFile200Response)

    async def update_config_with_http_info(
        self,
        index_name: Annotated[
            StrictStr, Field(description="Query Suggestions index name.")
        ],
        configuration: Configuration,
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> ApiResponse[str]:
        """
        Updates a QuerySuggestions configuration.

        Required API Key ACLs:
          - editSettings

        :param index_name: Query Suggestions index name. (required)
        :type index_name: str
        :param configuration: (required)
        :type configuration: Configuration
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        if index_name is None:
            raise ValueError(
                "Parameter `index_name` is required when calling `update_config`."
            )

        if configuration is None:
            raise ValueError(
                "Parameter `configuration` is required when calling `update_config`."
            )

        _data = {}
        if configuration is not None:
            _data = configuration

        return await self._transporter.request(
            verb=Verb.PUT,
            path="/1/configs/{indexName}".replace(
                "{indexName}", quote(str(index_name), safe="")
            ),
            request_options=self._request_options.merge(
                data=dumps(bodySerializer(_data)),
                user_request_options=request_options,
            ),
            use_read_transporter=False,
        )

    async def update_config(
        self,
        index_name: Annotated[
            StrictStr, Field(description="Query Suggestions index name.")
        ],
        configuration: Configuration,
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> BaseResponse:
        """
        Updates a QuerySuggestions configuration.

        Required API Key ACLs:
          - editSettings

        :param index_name: Query Suggestions index name. (required)
        :type index_name: str
        :param configuration: (required)
        :type configuration: Configuration
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the deserialized response in a 'BaseResponse' result object.
        """
        return (
            await self.update_config_with_http_info(
                index_name, configuration, request_options
            )
        ).deserialize(BaseResponse)
