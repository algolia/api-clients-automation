from re import compile

from algoliasearch.http.hosts import Host, HostsCollection
from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.search.client import SearchClient
from algoliasearch.search.config import SearchConfig


class TestSearchClient:
    _client: SearchClient

    def create_client(self) -> SearchClient:
        _config = SearchConfig("appId", "apiKey")
        self._client = SearchClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )

    async def test_api_0(self):
        """
        calls api with correct read host
        """

        _config = SearchConfig("test-app-id", "test-api-key")
        self._client = SearchClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )
        _req = await self._client.custom_get_with_http_info(
            path="/test",
        )
        assert _req.host == "test-app-id-dsn.algolia.net"

    async def test_api_1(self):
        """
        calls api with correct write host
        """

        _config = SearchConfig("test-app-id", "test-api-key")
        self._client = SearchClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )
        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )
        assert _req.host == "test-app-id.algolia.net"

    async def test_api_2(self):
        """
        tests the retry strategy
        """

        _config = SearchConfig("test-app-id", "test-api-key")
        _config.hosts = HostsCollection(
            [
                Host(url="localhost", scheme="http", port=6677),
                Host(url="localhost", scheme="http", port=6678),
            ]
        )
        self._client = SearchClient.create_with_config(config=_config)
        _req = await self._client.custom_get(
            path="/test",
        )
        assert _req == """{"message":"ok test server response"}"""

    async def test_common_api_0(self):
        """
        calls api with correct user agent
        """
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )
        regex_user_agent = compile(
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Search (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
        )
        assert regex_user_agent.match(_req.headers.get("user-agent")) is not None

    async def test_common_api_1(self):
        """
        calls api with default read timeouts
        """
        self.create_client()

        _req = await self._client.custom_get_with_http_info(
            path="/test",
        )
        assert _req.timeouts.get("connect") == 2000
        assert _req.timeouts.get("response") == 5000

    async def test_common_api_2(self):
        """
        calls api with default write timeouts
        """
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )
        assert _req.timeouts.get("connect") == 2000
        assert _req.timeouts.get("response") == 30000

    async def test_parameters_0(self):
        """
        client throws with invalid parameters
        """

        try:
            _config = SearchConfig("", "")
            self._client = SearchClient.create_with_config(
                config=_config, transporter=EchoTransporter(_config)
            )
            assert False
        except (ValueError, Exception) as e:
            assert str(e) == "`app_id` is missing."
        try:
            _config = SearchConfig("", "my-api-key")
            self._client = SearchClient.create_with_config(
                config=_config, transporter=EchoTransporter(_config)
            )
            assert False
        except (ValueError, Exception) as e:
            assert str(e) == "`app_id` is missing."
        try:
            _config = SearchConfig("my-app-id", "")
            self._client = SearchClient.create_with_config(
                config=_config, transporter=EchoTransporter(_config)
            )
            assert False
        except (ValueError, Exception) as e:
            assert str(e) == "`api_key` is missing."

    async def test_parameters_1(self):
        """
        &#x60;addApiKey&#x60; throws with invalid parameters
        """
        self.create_client()

        try:
            await self._client.add_api_key_with_http_info(
                api_key=None,
            )
            assert False
        except (ValueError, Exception) as e:
            assert (
                str(e) == "Parameter `api_key` is required when calling `add_api_key`."
            )

    async def test_parameters_2(self):
        """
        &#x60;addOrUpdateObject&#x60; throws with invalid parameters
        """
        self.create_client()

        try:
            await self._client.add_or_update_object_with_http_info(
                index_name=None,
                object_id="my-object-id",
                body={},
            )
            assert False
        except (ValueError, Exception) as e:
            assert (
                str(e)
                == "Parameter `index_name` is required when calling `add_or_update_object`."
            )
        try:
            await self._client.add_or_update_object_with_http_info(
                index_name="my-index-name",
                object_id=None,
                body={},
            )
            assert False
        except (ValueError, Exception) as e:
            assert (
                str(e)
                == "Parameter `object_id` is required when calling `add_or_update_object`."
            )
        try:
            await self._client.add_or_update_object_with_http_info(
                index_name="my-index-name",
                object_id="my-object-id",
                body=None,
            )
            assert False
        except (ValueError, Exception) as e:
            assert (
                str(e)
                == "Parameter `body` is required when calling `add_or_update_object`."
            )
