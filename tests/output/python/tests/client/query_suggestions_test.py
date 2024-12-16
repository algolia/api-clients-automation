# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
from os import environ
from re import compile
from json import loads

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.http.transporter_sync import EchoTransporterSync
from algoliasearch.http.hosts import Host, HostsCollection
from algoliasearch.query_suggestions.client import QuerySuggestionsClient
from algoliasearch.query_suggestions.client import QuerySuggestionsClientSync
from algoliasearch.query_suggestions.config import QuerySuggestionsConfig


class TestQuerySuggestionsClient:
    def create_client(self) -> QuerySuggestionsClient:
        _config = QuerySuggestionsConfig("appId", "apiKey", "us")
        return QuerySuggestionsClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )

    async def test_common_api_0(self):
        """
        calls api with correct user agent
        """
        _client = self.create_client()

        _req = await _client.custom_post_with_http_info(
            path="1/test",
        )
        regex_user_agent = compile(
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; QuerySuggestions (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
        )
        assert regex_user_agent.match(_req.headers.get("user-agent")) is not None

    async def test_common_api_1(self):
        """
        the user agent contains the latest version
        """
        _client = self.create_client()

        _req = await _client.custom_post_with_http_info(
            path="1/test",
        )
        regex_user_agent = compile("^Algolia for Python \\(4.11.1\\).*")
        assert regex_user_agent.match(_req.headers.get("user-agent")) is not None

    async def test_parameters_0(self):
        """
        throws when region is not given
        """

        try:
            _config = QuerySuggestionsConfig("my-app-id", "my-api-key", "")
            _client = QuerySuggestionsClient.create_with_config(
                config=_config, transporter=EchoTransporter(_config)
            )
            assert False
        except (ValueError, Exception) as e:
            assert (
                str(e)
                == "`region` is required and must be one of the following: eu, us"
            )

    async def test_parameters_1(self):
        """
        throws when incorrect region is given
        """

        try:
            _config = QuerySuggestionsConfig("my-app-id", "my-api-key", "not_a_region")
            _client = QuerySuggestionsClient.create_with_config(
                config=_config, transporter=EchoTransporter(_config)
            )
            assert False
        except (ValueError, Exception) as e:
            assert (
                str(e)
                == "`region` is required and must be one of the following: eu, us"
            )

    async def test_parameters_2(self):
        """
        does not throw when region is given
        """

        _config = QuerySuggestionsConfig("my-app-id", "my-api-key", "us")
        _client = QuerySuggestionsClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )

    async def test_set_client_api_key_0(self):
        """
        switch API key
        """

        _config = QuerySuggestionsConfig("test-app-id", "test-api-key", "us")
        _config.hosts = HostsCollection(
            [
                Host(
                    url="localhost"
                    if environ.get("CI") == "true"
                    else "host.docker.internal",
                    scheme="http",
                    port=6683,
                )
            ]
        )
        _client = QuerySuggestionsClient.create_with_config(config=_config)
        _req = await _client.custom_get(
            path="check-api-key/1",
        )
        assert (
            _req
            if isinstance(_req, dict)
            else [elem.to_dict() for elem in _req]
            if isinstance(_req, list)
            else _req.to_dict()
        ) == loads("""{"headerAPIKeyValue":"test-api-key"}""")
        await _client.set_client_api_key(
            api_key="updated-api-key",
        )
        _req = await _client.custom_get(
            path="check-api-key/2",
        )
        assert (
            _req
            if isinstance(_req, dict)
            else [elem.to_dict() for elem in _req]
            if isinstance(_req, list)
            else _req.to_dict()
        ) == loads("""{"headerAPIKeyValue":"updated-api-key"}""")


class TestQuerySuggestionsClientSync:
    def create_client(self) -> QuerySuggestionsClientSync:
        _config = QuerySuggestionsConfig("appId", "apiKey", "us")
        return QuerySuggestionsClientSync.create_with_config(
            config=_config, transporter=EchoTransporterSync(_config)
        )

    def test_common_api_0(self):
        """
        calls api with correct user agent
        """
        _client = self.create_client()

        _req = _client.custom_post_with_http_info(
            path="1/test",
        )
        regex_user_agent = compile(
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; QuerySuggestions (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
        )
        assert regex_user_agent.match(_req.headers.get("user-agent")) is not None

    def test_common_api_1(self):
        """
        the user agent contains the latest version
        """
        _client = self.create_client()

        _req = _client.custom_post_with_http_info(
            path="1/test",
        )
        regex_user_agent = compile("^Algolia for Python \\(4.11.1\\).*")
        assert regex_user_agent.match(_req.headers.get("user-agent")) is not None

    def test_parameters_0(self):
        """
        throws when region is not given
        """

        try:
            _config = QuerySuggestionsConfig("my-app-id", "my-api-key", "")
            _client = QuerySuggestionsClientSync.create_with_config(
                config=_config, transporter=EchoTransporterSync(_config)
            )
            assert False
        except (ValueError, Exception) as e:
            assert (
                str(e)
                == "`region` is required and must be one of the following: eu, us"
            )

    def test_parameters_1(self):
        """
        throws when incorrect region is given
        """

        try:
            _config = QuerySuggestionsConfig("my-app-id", "my-api-key", "not_a_region")
            _client = QuerySuggestionsClientSync.create_with_config(
                config=_config, transporter=EchoTransporterSync(_config)
            )
            assert False
        except (ValueError, Exception) as e:
            assert (
                str(e)
                == "`region` is required and must be one of the following: eu, us"
            )

    def test_parameters_2(self):
        """
        does not throw when region is given
        """

        _config = QuerySuggestionsConfig("my-app-id", "my-api-key", "us")
        _client = QuerySuggestionsClientSync.create_with_config(
            config=_config, transporter=EchoTransporterSync(_config)
        )

    def test_set_client_api_key_0(self):
        """
        switch API key
        """

        _config = QuerySuggestionsConfig("test-app-id", "test-api-key", "us")
        _config.hosts = HostsCollection(
            [
                Host(
                    url="localhost"
                    if environ.get("CI") == "true"
                    else "host.docker.internal",
                    scheme="http",
                    port=6683,
                )
            ]
        )
        _client = QuerySuggestionsClientSync.create_with_config(config=_config)
        _req = _client.custom_get(
            path="check-api-key/1",
        )
        assert (
            _req
            if isinstance(_req, dict)
            else [elem.to_dict() for elem in _req]
            if isinstance(_req, list)
            else _req.to_dict()
        ) == loads("""{"headerAPIKeyValue":"test-api-key"}""")
        _client.set_client_api_key(
            api_key="updated-api-key",
        )
        _req = _client.custom_get(
            path="check-api-key/2",
        )
        assert (
            _req
            if isinstance(_req, dict)
            else [elem.to_dict() for elem in _req]
            if isinstance(_req, list)
            else _req.to_dict()
        ) == loads("""{"headerAPIKeyValue":"updated-api-key"}""")
