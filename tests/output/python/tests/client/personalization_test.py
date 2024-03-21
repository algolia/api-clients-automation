from re import compile

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.personalization.client import PersonalizationClient
from algoliasearch.personalization.config import PersonalizationConfig


class TestPersonalizationClient:
    _client: PersonalizationClient

    def create_client(self) -> PersonalizationClient:
        _config = PersonalizationConfig("appId", "apiKey", "us")
        self._client = PersonalizationClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )

    async def test_common_api_0(self):
        """
        calls api with correct user agent
        """
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="1/test",
        )
        regex_user_agent = compile(
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Personalization (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
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

    async def test_parameters_0(self):
        """
        throws when region is not given
        """

        try:
            _config = PersonalizationConfig("my-app-id", "my-api-key", "")
            self._client = PersonalizationClient.create_with_config(
                config=_config, transporter=EchoTransporter(_config)
            )
            assert False
        except (ValueError, Exception) as e:
            assert (
                str(e)
                == "`region` is required and must be one of the following: eu, us"
            )

    async def test_parameters_1(self):
        """
        throws when incorrect region is given
        """

        try:
            _config = PersonalizationConfig("my-app-id", "my-api-key", "not_a_region")
            self._client = PersonalizationClient.create_with_config(
                config=_config, transporter=EchoTransporter(_config)
            )
            assert False
        except (ValueError, Exception) as e:
            assert (
                str(e)
                == "`region` is required and must be one of the following: eu, us"
            )

    async def test_parameters_2(self):
        """
        does not throw when region is given
        """

        _config = PersonalizationConfig("my-app-id", "my-api-key", "us")
        self._client = PersonalizationClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )
