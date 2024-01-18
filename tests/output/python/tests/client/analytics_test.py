from re import compile

from algoliasearch.analytics.client import AnalyticsClient
from algoliasearch.analytics.config import AnalyticsConfig
from algoliasearch.http.transporter import EchoTransporter


class TestAnalyticsClient:
    _config: AnalyticsConfig
    _client: AnalyticsClient

    def create_client(self) -> AnalyticsClient:
        self._config = AnalyticsConfig("appId", "apiKey", "us")
        self._client = AnalyticsClient.create_with_config(
            config=self._config, transporter=EchoTransporter(self._config)
        )

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
        self._client = AnalyticsClient(
            transporter=EchoTransporter(AnalyticsConfig("my-app-id", "my-api-key"))
        )
        _req = await self._client.get_average_click_position_with_http_info(
            index="my-index",
        )
        assert _req.host == "analytics.algolia.com"

    async def test_parameters_1(self):
        self._client = AnalyticsClient(
            transporter=EchoTransporter(
                AnalyticsConfig("my-app-id", "my-api-key", "de")
            )
        )
        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )
        assert _req.host == "analytics.de.algolia.com"

    async def test_parameters_2(self):
        try:
            self._client = AnalyticsClient(
                transporter=EchoTransporter(
                    AnalyticsConfig("my-app-id", "my-api-key", "not_a_region")
                )
            )
        except (ValueError, Exception) as e:
            assert str(e) == "`region` must be one of the following: de, us"

    async def test_parameters_3(self):
        self.create_client()

        try:
            await self._client.get_click_positions_with_http_info(
                index=None,
            )
        except (ValueError, Exception) as e:
            assert (
                str(e)
                == "Parameter `index` is required when calling `get_click_positions`."
            )
