from re import compile

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.insights.client import InsightsClient
from algoliasearch.insights.config import Config


class TestInsightsClient:
    _config: Config
    _client: InsightsClient

    def create_client(self) -> InsightsClient:
        self._config = Config("appId", "apiKey", "us")
        self._client = InsightsClient(EchoTransporter(self._config), self._config)

    async def test_common_api_0(self):
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )

        regex_user_agent = compile(
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Insights (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
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
        self._client = InsightsClient(
            EchoTransporter(Config("my-app-id", "my-api-key")),
            Config("my-app-id", "my-api-key"),
        )

        _req = await self._client.push_events_with_http_info(
            insights_events={
                "events": [],
            },
        )

        assert "insights.algolia.io" == _req.host

    async def test_parameters_1(self):
        self._client = InsightsClient(
            EchoTransporter(Config("my-app-id", "my-api-key", "us")),
            Config("my-app-id", "my-api-key", "us"),
        )

        _req = await self._client.custom_delete_with_http_info(
            path="/test",
        )

        assert "insights.us.algolia.io" == _req.host

    async def test_parameters_2(self):
        try:
            self._client = InsightsClient(
                EchoTransporter(Config("my-app-id", "my-api-key", "not_a_region")),
                Config("my-app-id", "my-api-key", "not_a_region"),
            )

        except (ValueError, Exception) as e:
            assert "`region` must be one of the following: de, us" == str(e)
