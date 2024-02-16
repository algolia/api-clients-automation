from re import compile

from algoliasearch.abtesting.client import AbtestingClient
from algoliasearch.abtesting.config import AbtestingConfig
from algoliasearch.http.transporter import EchoTransporter


class TestAbtestingClient:
    _client: AbtestingClient

    def create_client(self) -> AbtestingClient:
        _config = AbtestingConfig("appId", "apiKey", "us")
        self._client = AbtestingClient.create_with_config(
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
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Abtesting (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
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

        _config = AbtestingConfig("my-app-id", "my-api-key")
        self._client = AbtestingClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )
        _req = await self._client.get_ab_test_with_http_info(
            id=123,
        )
        assert _req.host == "analytics.algolia.com"

    async def test_parameters_1(self):
        """
        uses the correct region
        """

        _config = AbtestingConfig("my-app-id", "my-api-key", "us")
        self._client = AbtestingClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )
        _req = await self._client.get_ab_test_with_http_info(
            id=123,
        )
        assert _req.host == "analytics.us.algolia.com"

    async def test_parameters_2(self):
        """
        throws when incorrect region is given
        """

        try:
            _config = AbtestingConfig("my-app-id", "my-api-key", "not_a_region")
            self._client = AbtestingClient.create_with_config(
                config=_config, transporter=EchoTransporter(_config)
            )
            assert False
        except (ValueError, Exception) as e:
            assert str(e) == "`region` must be one of the following: de, us"
