# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from typing import Annotated, Any, Dict, List, Optional, Tuple, Union
from urllib.parse import quote

from pydantic import Field, StrictStr

from algoliasearch.http import ApiResponse, RequestOptions, Transporter, Verb
from algoliasearch.personalization.config import Config
from algoliasearch.personalization.models import (
    DeleteUserProfileResponse,
    GetUserTokenResponse,
    PersonalizationStrategyParams,
    SetPersonalizationStrategyResponse,
)

try:
    from typing import Self
except ImportError:
    from typing_extensions import Self


class PersonalizationClient:
    def app_id(self) -> str:
        return self._config.app_id

    def __init__(self, transporter: Transporter, config: Config) -> None:
        self._transporter = transporter
        self._config = config

    def create_with_config(config: Config) -> Self:
        transporter = Transporter(config)

        return PersonalizationClient(transporter, config)

    def create(app_id: Optional[str] = None, api_key: Optional[str] = None) -> Self:
        return PersonalizationClient.create_with_config(Config(app_id, api_key))

    async def close(self) -> None:
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
            raise ValueError("'path' is required when calling 'custom_delete'")

        _query_params: List[Tuple[str, str]] = []
        _body: Optional[bytes] = None
        _path = "/1{path}".replace("{path}", path)

        if parameters is not None:
            _query_params.append(("parameters", parameters))

        _param = self._transporter.param_serialize(
            query_params=_query_params,
            body=_body,
            request_options=request_options,
        )

        response = await self._transporter.request(
            verb=Verb.DELETE,
            path=_path,
            data=_param[0],
            request_options=_param[1],
            use_read_transporter=False,
        )

        response.data = response.raw_data

        return response

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

        response = await self.custom_delete_with_http_info(
            path, parameters, request_options
        )

        return response.deserialize(object)

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
            raise ValueError("'path' is required when calling 'custom_get'")

        _query_params: List[Tuple[str, str]] = []
        _body: Optional[bytes] = None
        _path = "/1{path}".replace("{path}", path)

        if parameters is not None:
            _query_params.append(("parameters", parameters))

        _param = self._transporter.param_serialize(
            query_params=_query_params,
            body=_body,
            request_options=request_options,
        )

        response = await self._transporter.request(
            verb=Verb.GET,
            path=_path,
            data=_param[0],
            request_options=_param[1],
            use_read_transporter=False,
        )

        response.data = response.raw_data

        return response

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

        response = await self.custom_get_with_http_info(
            path, parameters, request_options
        )

        return response.deserialize(object)

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
            raise ValueError("'path' is required when calling 'custom_post'")

        _query_params: List[Tuple[str, str]] = []
        _body: Optional[bytes] = None
        _path = "/1{path}".replace("{path}", path)

        if parameters is not None:
            _query_params.append(("parameters", parameters))

        if body is not None:
            _body = body

        _param = self._transporter.param_serialize(
            query_params=_query_params,
            body=_body,
            request_options=request_options,
        )

        response = await self._transporter.request(
            verb=Verb.POST,
            path=_path,
            data=_param[0],
            request_options=_param[1],
            use_read_transporter=False,
        )

        response.data = response.raw_data

        return response

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

        response = await self.custom_post_with_http_info(
            path, parameters, body, request_options
        )

        return response.deserialize(object)

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
            raise ValueError("'path' is required when calling 'custom_put'")

        _query_params: List[Tuple[str, str]] = []
        _body: Optional[bytes] = None
        _path = "/1{path}".replace("{path}", path)

        if parameters is not None:
            _query_params.append(("parameters", parameters))

        if body is not None:
            _body = body

        _param = self._transporter.param_serialize(
            query_params=_query_params,
            body=_body,
            request_options=request_options,
        )

        response = await self._transporter.request(
            verb=Verb.PUT,
            path=_path,
            data=_param[0],
            request_options=_param[1],
            use_read_transporter=False,
        )

        response.data = response.raw_data

        return response

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

        response = await self.custom_put_with_http_info(
            path, parameters, body, request_options
        )

        return response.deserialize(object)

    async def delete_user_profile_with_http_info(
        self,
        user_token: Annotated[
            StrictStr,
            Field(
                description="userToken representing the user for which to fetch the Personalization profile."
            ),
        ],
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> ApiResponse[str]:
        """
        Delete a user profile.

        Delete the user profile and all its associated data.  Returns, as part of the response, a date until which the data can safely be considered as deleted for the given user. This means if you send events for the given user before this date, they will be ignored. Any data received after the deletedUntil date will start building a new user profile.  It might take a couple hours for the deletion request to be fully processed.

        :param user_token: userToken representing the user for which to fetch the Personalization profile. (required)
        :type user_token: str
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        if user_token is None:
            raise ValueError(
                "'user_token' is required when calling 'delete_user_profile'"
            )

        _query_params: List[Tuple[str, str]] = []
        _body: Optional[bytes] = None
        _path = "/1/profiles/{userToken}".replace("{userToken}", quote(str(user_token)))

        _param = self._transporter.param_serialize(
            query_params=_query_params,
            body=_body,
            request_options=request_options,
        )

        response = await self._transporter.request(
            verb=Verb.DELETE,
            path=_path,
            data=_param[0],
            request_options=_param[1],
            use_read_transporter=False,
        )

        response.data = response.raw_data

        return response

    async def delete_user_profile(
        self,
        user_token: Annotated[
            StrictStr,
            Field(
                description="userToken representing the user for which to fetch the Personalization profile."
            ),
        ],
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> DeleteUserProfileResponse:
        """
        Delete a user profile.

        Delete the user profile and all its associated data.  Returns, as part of the response, a date until which the data can safely be considered as deleted for the given user. This means if you send events for the given user before this date, they will be ignored. Any data received after the deletedUntil date will start building a new user profile.  It might take a couple hours for the deletion request to be fully processed.

        :param user_token: userToken representing the user for which to fetch the Personalization profile. (required)
        :type user_token: str
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the deserialized response in a 'DeleteUserProfileResponse' result object.
        """

        response = await self.delete_user_profile_with_http_info(
            user_token, request_options
        )

        return response.deserialize(DeleteUserProfileResponse)

    async def get_personalization_strategy_with_http_info(
        self, request_options: Optional[Union[dict, RequestOptions]] = None
    ) -> ApiResponse[str]:
        """
        Get the current strategy.

        The strategy contains information on the events and facets that impact user profiles and personalized search results.

        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        _query_params: List[Tuple[str, str]] = []
        _body: Optional[bytes] = None
        _path = "/1/strategies/personalization"

        _param = self._transporter.param_serialize(
            query_params=_query_params,
            body=_body,
            request_options=request_options,
        )

        response = await self._transporter.request(
            verb=Verb.GET,
            path=_path,
            data=_param[0],
            request_options=_param[1],
            use_read_transporter=False,
        )

        response.data = response.raw_data

        return response

    async def get_personalization_strategy(
        self, request_options: Optional[Union[dict, RequestOptions]] = None
    ) -> PersonalizationStrategyParams:
        """
        Get the current strategy.

        The strategy contains information on the events and facets that impact user profiles and personalized search results.

        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the deserialized response in a 'PersonalizationStrategyParams' result object.
        """

        response = await self.get_personalization_strategy_with_http_info(
            request_options
        )

        return response.deserialize(PersonalizationStrategyParams)

    async def get_user_token_profile_with_http_info(
        self,
        user_token: Annotated[
            StrictStr,
            Field(
                description="userToken representing the user for which to fetch the Personalization profile."
            ),
        ],
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> ApiResponse[str]:
        """
        Get a user profile.

        Get the user profile built from Personalization strategy.  The profile is structured by facet name used in the strategy. Each facet value is mapped to its score. Each score represents the user affinity for a specific facet value given the userToken past events and the Personalization strategy defined. Scores are bounded to 20. The last processed event timestamp is provided using the ISO 8601 format for debugging purposes.

        :param user_token: userToken representing the user for which to fetch the Personalization profile. (required)
        :type user_token: str
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        if user_token is None:
            raise ValueError(
                "'user_token' is required when calling 'get_user_token_profile'"
            )

        _query_params: List[Tuple[str, str]] = []
        _body: Optional[bytes] = None
        _path = "/1/profiles/personalization/{userToken}".replace(
            "{userToken}", quote(str(user_token))
        )

        _param = self._transporter.param_serialize(
            query_params=_query_params,
            body=_body,
            request_options=request_options,
        )

        response = await self._transporter.request(
            verb=Verb.GET,
            path=_path,
            data=_param[0],
            request_options=_param[1],
            use_read_transporter=False,
        )

        response.data = response.raw_data

        return response

    async def get_user_token_profile(
        self,
        user_token: Annotated[
            StrictStr,
            Field(
                description="userToken representing the user for which to fetch the Personalization profile."
            ),
        ],
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> GetUserTokenResponse:
        """
        Get a user profile.

        Get the user profile built from Personalization strategy.  The profile is structured by facet name used in the strategy. Each facet value is mapped to its score. Each score represents the user affinity for a specific facet value given the userToken past events and the Personalization strategy defined. Scores are bounded to 20. The last processed event timestamp is provided using the ISO 8601 format for debugging purposes.

        :param user_token: userToken representing the user for which to fetch the Personalization profile. (required)
        :type user_token: str
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the deserialized response in a 'GetUserTokenResponse' result object.
        """

        response = await self.get_user_token_profile_with_http_info(
            user_token, request_options
        )

        return response.deserialize(GetUserTokenResponse)

    async def set_personalization_strategy_with_http_info(
        self,
        personalization_strategy_params: PersonalizationStrategyParams,
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> ApiResponse[str]:
        """
        Set a new strategy.

        A strategy defines the events and facets that impact user profiles and personalized search results.

        :param personalization_strategy_params: (required)
        :type personalization_strategy_params: PersonalizationStrategyParams
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the raw algoliasearch 'APIResponse' object.
        """

        if personalization_strategy_params is None:
            raise ValueError(
                "'personalization_strategy_params' is required when calling 'set_personalization_strategy'"
            )

        _query_params: List[Tuple[str, str]] = []
        _body: Optional[bytes] = None
        _path = "/1/strategies/personalization"

        if personalization_strategy_params is not None:
            _body = personalization_strategy_params

        _param = self._transporter.param_serialize(
            query_params=_query_params,
            body=_body,
            request_options=request_options,
        )

        response = await self._transporter.request(
            verb=Verb.POST,
            path=_path,
            data=_param[0],
            request_options=_param[1],
            use_read_transporter=False,
        )

        response.data = response.raw_data

        return response

    async def set_personalization_strategy(
        self,
        personalization_strategy_params: PersonalizationStrategyParams,
        request_options: Optional[Union[dict, RequestOptions]] = None,
    ) -> SetPersonalizationStrategyResponse:
        """
        Set a new strategy.

        A strategy defines the events and facets that impact user profiles and personalized search results.

        :param personalization_strategy_params: (required)
        :type personalization_strategy_params: PersonalizationStrategyParams
        :param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
        :return: Returns the deserialized response in a 'SetPersonalizationStrategyResponse' result object.
        """

        response = await self.set_personalization_strategy_with_http_info(
            personalization_strategy_params, request_options
        )

        return response.deserialize(SetPersonalizationStrategyResponse)
