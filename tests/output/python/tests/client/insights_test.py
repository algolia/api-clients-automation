from re import compile

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.insights.client import InsightsClient
from algoliasearch.insights.config import InsightsConfig


class TestInsightsClient:
    _client: InsightsClient

    def create_client(self) -> InsightsClient:
        _config = InsightsConfig("appId", "apiKey", "us")
        self._client = InsightsClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )

    async def test_common_api_0(self):
        """
        calls api with correct user agent
        """
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )
        regex_user_agent = compile(
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Insights (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
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
        fallbacks to the alias when region is not given
        """

        _config = InsightsConfig("my-app-id", "my-api-key")
        self._client = InsightsClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )
        _req = await self._client.push_events_with_http_info(
            insights_events={
                "events": [
                    {
                        "eventType": "click",
                        "eventName": "Product Clicked",
                        "index": "products",
                        "userToken": "user-123456",
                        "authenticatedUserToken": "user-123456",
                        "timestamp": 1641290601962,
                        "objectIDs": [
                            "9780545139700",
                            "9780439784542",
                        ],
                        "queryID": "43b15df305339e827f0ac0bdc5ebcaa7",
                        "positions": [
                            7,
                            6,
                        ],
                    },
                ],
            },
        )
        assert _req.host == "insights.algolia.io"

    async def test_parameters_1(self):
        """
        uses the correct region
        """

        _config = InsightsConfig("my-app-id", "my-api-key", "us")
        self._client = InsightsClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )
        _req = await self._client.custom_delete_with_http_info(
            path="/test",
        )
        assert _req.host == "insights.us.algolia.io"

    async def test_parameters_2(self):
        """
        throws when incorrect region is given
        """

        try:
            _config = InsightsConfig("my-app-id", "my-api-key", "not_a_region")
            self._client = InsightsClient.create_with_config(
                config=_config, transporter=EchoTransporter(_config)
            )
            assert False
        except (ValueError, Exception) as e:
            assert str(e) == "`region` must be one of the following: de, us"
