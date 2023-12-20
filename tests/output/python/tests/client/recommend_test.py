from re import compile

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.recommend.client import RecommendClient
from algoliasearch.recommend.config import Config


class TestRecommendClient:
    _config: Config
    _client: RecommendClient

    def create_client(self) -> RecommendClient:
        self._config = Config("appId", "apiKey")
        self._client = RecommendClient(EchoTransporter(self._config), self._config)

    async def test_api_0(self):
        self._client = RecommendClient(
            EchoTransporter(Config("test-app-id", "test-api-key")),
            Config("test-app-id", "test-api-key"),
        )

        _req = await self._client.custom_get_with_http_info(
            path="/test",
        )

        assert "test-app-id-dsn.algolia.net" == _req.host

    async def test_api_1(self):
        self._client = RecommendClient(
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
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Recommend (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
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
