from re import compile

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.search.client import SearchClient
from algoliasearch.search.config import SearchConfig


class TestSearchClient:
    _config: SearchConfig
    _client: SearchClient

    def create_client(self) -> SearchClient:
        self._config = SearchConfig("appId", "apiKey")
        self._client = SearchClient.create_with_config(
            config=self._config, transporter=EchoTransporter(self._config)
        )

    async def test_api_0(self):
        self._client = SearchClient(
            transporter=EchoTransporter(SearchConfig("test-app-id", "test-api-key"))
        )
        _req = await self._client.custom_get_with_http_info(
            path="/test",
        )
        assert _req.host == "test-app-id-dsn.algolia.net"

    async def test_api_1(self):
        self._client = SearchClient(
            transporter=EchoTransporter(SearchConfig("test-app-id", "test-api-key"))
        )
        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )
        assert _req.host == "test-app-id.algolia.net"

    async def test_common_api_0(self):
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )
        regex_user_agent = compile(
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Search (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
        )
        assert regex_user_agent.match(_req.headers.get("user-agent")) is not None

    async def test_common_api_1(self):
        self.create_client()

        _req = await self._client.custom_get_with_http_info(
            path="/test",
        )
        assert _req.timeouts.get("connect") == 2000
        assert _req.timeouts.get("response") == 5000

    async def test_common_api_2(self):
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )
        assert _req.timeouts.get("connect") == 2000
        assert _req.timeouts.get("response") == 30000

    async def test_parameters_0(self):
        try:
            self._client = SearchClient(
                transporter=EchoTransporter(SearchConfig("", ""))
            )
        except (ValueError, Exception) as e:
            assert str(e) == "`app_id` is missing."
        try:
            self._client = SearchClient(
                transporter=EchoTransporter(SearchConfig("", "my-api-key"))
            )
        except (ValueError, Exception) as e:
            assert str(e) == "`app_id` is missing."
        try:
            self._client = SearchClient(
                transporter=EchoTransporter(SearchConfig("my-app-id", ""))
            )
        except (ValueError, Exception) as e:
            assert str(e) == "`api_key` is missing."

    async def test_parameters_1(self):
        self.create_client()

        try:
            await self._client.add_api_key_with_http_info(
                api_key=None,
            )
        except (ValueError, Exception) as e:
            assert (
                str(e) == "Parameter `api_key` is required when calling `add_api_key`."
            )

    async def test_parameters_2(self):
        self.create_client()

        try:
            await self._client.add_or_update_object_with_http_info(
                index_name=None,
                object_id="my-object-id",
                body={},
            )
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
        except (ValueError, Exception) as e:
            assert (
                str(e)
                == "Parameter `body` is required when calling `add_or_update_object`."
            )
