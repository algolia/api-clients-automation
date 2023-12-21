from re import compile

from algoliasearch.abtesting.client import AbtestingClient
from algoliasearch.abtesting.config import Config
from algoliasearch.http.transporter import EchoTransporter


class TestAbtestingClient:
    _config: Config
    _client: AbtestingClient

    def create_client(self) -> AbtestingClient:
        self._config = Config("appId", "apiKey", "us")
        self._client = AbtestingClient(EchoTransporter(self._config), self._config)

    async def test_common_api_0(self):
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )

        regex_user_agent = compile(
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Abtesting (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
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
        self._client = AbtestingClient(
            EchoTransporter(Config("my-app-id", "my-api-key")),
            Config("my-app-id", "my-api-key"),
        )

        _req = await self._client.get_ab_test_with_http_info(
            id=123,
        )

        assert _req.host == "analytics.algolia.com"

    async def test_parameters_1(self):
        self._client = AbtestingClient(
            EchoTransporter(Config("my-app-id", "my-api-key", "us")),
            Config("my-app-id", "my-api-key", "us"),
        )

        _req = await self._client.get_ab_test_with_http_info(
            id=123,
        )

        assert _req.host == "analytics.us.algolia.com"

    async def test_parameters_2(self):
        try:
            self._client = AbtestingClient(
                EchoTransporter(Config("my-app-id", "my-api-key", "not_a_region")),
                Config("my-app-id", "my-api-key", "not_a_region"),
            )

        except (ValueError, Exception) as e:
            assert str(e) == "`region` must be one of the following: de, us"
