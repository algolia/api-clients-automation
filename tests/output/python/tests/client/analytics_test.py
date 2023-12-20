from re import compile

from algoliasearch.analytics.client import AnalyticsClient
from algoliasearch.analytics.config import Config
from algoliasearch.http.transporter import EchoTransporter


class TestAnalyticsClient:
    _config: Config
    _client: AnalyticsClient

    def create_client(self) -> AnalyticsClient:
        self._config = Config("appId", "apiKey", "us")
        self._client = AnalyticsClient(EchoTransporter(self._config), self._config)

    async def test_common_api_0(self):
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )

        regex_user_agent = compile(
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Analytics (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
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
        self._client = AnalyticsClient(
            EchoTransporter(Config("my-app-id", "my-api-key")),
            Config("my-app-id", "my-api-key"),
        )

        _req = await self._client.get_average_click_position_with_http_info(
            index="my-index",
        )

        assert "analytics.algolia.com" == _req.host

    async def test_parameters_1(self):
        self._client = AnalyticsClient(
            EchoTransporter(Config("my-app-id", "my-api-key", "de")),
            Config("my-app-id", "my-api-key", "de"),
        )

        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )

        assert "analytics.de.algolia.com" == _req.host

    async def test_parameters_2(self):
        try:
            self._client = AnalyticsClient(
                EchoTransporter(Config("my-app-id", "my-api-key", "not_a_region")),
                Config("my-app-id", "my-api-key", "not_a_region"),
            )

        except (ValueError, Exception) as e:
            assert "`region` must be one of the following: de, us" == str(e)

    async def test_parameters_3(self):
        self.create_client()

        try:
            await self._client.get_click_positions_with_http_info(
                index=None,
            )

        except (ValueError, Exception) as e:
            assert (
                "Parameter `index` is required when calling `get_click_positions`."
                == str(e)
            )
