from re import compile

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.recommend.client import RecommendClient
from algoliasearch.recommend.config import RecommendConfig


class TestRecommendClient:
    _client: RecommendClient

    def create_client(self) -> RecommendClient:
        _config = RecommendConfig("appId", "apiKey")
        self._client = RecommendClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )

    async def test_api_0(self):
        """
        calls api with correct read host
        """

        _config = RecommendConfig("test-app-id", "test-api-key")
        self._client = RecommendClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )
        _req = await self._client.custom_get_with_http_info(
            path="test",
        )
        assert _req.host == "test-app-id-dsn.algolia.net"

    async def test_api_1(self):
        """
        calls api with correct write host
        """

        _config = RecommendConfig("test-app-id", "test-api-key")
        self._client = RecommendClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )
        _req = await self._client.custom_post_with_http_info(
            path="test",
        )
        assert _req.host == "test-app-id.algolia.net"

    async def test_common_api_0(self):
        """
        calls api with correct user agent
        """
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="1/test",
        )
        regex_user_agent = compile(
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Recommend (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
        )
        assert regex_user_agent.match(_req.headers.get("user-agent")) is not None

    async def test_common_api_1(self):
        """
        calls api with default read timeouts
        """
        self.create_client()

        _req = await self._client.custom_get_with_http_info(
            path="1/test",
        )
        assert _req.timeouts.get("connect") == 2000
        assert _req.timeouts.get("response") == 5000

    async def test_common_api_2(self):
        """
        calls api with default write timeouts
        """
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="1/test",
        )
        assert _req.timeouts.get("connect") == 2000
        assert _req.timeouts.get("response") == 30000
