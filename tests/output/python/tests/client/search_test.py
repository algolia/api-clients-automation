from re import compile

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.search.client import SearchClient
from algoliasearch.search.config import Config


class TestSearchClient:
    _config: Config
    _client: SearchClient

    def create_client(self) -> SearchClient:
        self._config = Config("appId", "apiKey")
        self._client = SearchClient(EchoTransporter(self._config), self._config)

    async def test_api_0(self):
        self._client = SearchClient(
            EchoTransporter(Config("test-app-id", "test-api-key")),
            Config("test-app-id", "test-api-key"),
        )

        _req = await self._client.custom_get_with_http_info(
            path="/test",
        )

        assert "test-app-id-dsn.algolia.net" == _req.host

    async def test_api_1(self):
        self._client = SearchClient(
            EchoTransporter(Config("test-app-id", "test-api-key")),
            Config("test-app-id", "test-api-key"),
        )

        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )

        assert "test-app-id.algolia.net" == _req.host

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

        assert 2000 == _req.timeouts.get("connect")
        assert 5000 == _req.timeouts.get("response")

    async def test_common_api_2(self):
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )

        assert 2000 == _req.timeouts.get("connect")
        assert 30000 == _req.timeouts.get("response")

    async def test_parameters_0(self):
        try:
            self._client = SearchClient(EchoTransporter(Config("", "")), Config("", ""))

        except (ValueError, Exception) as e:
            assert "`app_id` is missing." == str(e)
        try:
            self._client = SearchClient(
                EchoTransporter(Config("", "my-api-key")), Config("", "my-api-key")
            )

        except (ValueError, Exception) as e:
            assert "`app_id` is missing." == str(e)
        try:
            self._client = SearchClient(
                EchoTransporter(Config("my-app-id", "")), Config("my-app-id", "")
            )

        except (ValueError, Exception) as e:
            assert "`api_key` is missing." == str(e)

    async def test_parameters_1(self):
        self.create_client()

        try:
            await self._client.add_api_key_with_http_info(
                api_key=None,
            )

        except (ValueError, Exception) as e:
            assert "Parameter `api_key` is required when calling `add_api_key`." == str(
                e
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
                "Parameter `index_name` is required when calling `add_or_update_object`."
                == str(e)
            )
        try:
            await self._client.add_or_update_object_with_http_info(
                index_name="my-index-name",
                object_id=None,
                body={},
            )

        except (ValueError, Exception) as e:
            assert (
                "Parameter `object_id` is required when calling `add_or_update_object`."
                == str(e)
            )
        try:
            await self._client.add_or_update_object_with_http_info(
                index_name="my-index-name",
                object_id="my-object-id",
                body=None,
            )

        except (ValueError, Exception) as e:
            assert (
                "Parameter `body` is required when calling `add_or_update_object`."
                == str(e)
            )
