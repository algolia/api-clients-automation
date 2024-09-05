# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
from re import compile

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.usage.client import UsageClient
from algoliasearch.usage.config import UsageConfig


class TestUsageClient:
    _client: UsageClient

    def create_client(self) -> UsageClient:
        _config = UsageConfig("appId", "apiKey")
        self._client = UsageClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )

    async def test_api_0(self):
        """
        calls api with correct read host
        """

        _config = UsageConfig("test-app-id", "test-api-key")
        self._client = UsageClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )
        _req = await self._client.custom_get_with_http_info(
            path="test",
        )
        assert _req.host == "usage.algolia.com"

    async def test_api_1(self):
        """
        calls api with correct write host
        """

        _config = UsageConfig("test-app-id", "test-api-key")
        self._client = UsageClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )
        _req = await self._client.custom_post_with_http_info(
            path="test",
        )
        assert _req.host == "usage.algolia.com"

    async def test_common_api_0(self):
        """
        calls api with correct user agent
        """
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="1/test",
        )
        regex_user_agent = compile(
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Usage (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
        )
        assert regex_user_agent.match(_req.headers.get("user-agent")) is not None

    async def test_common_api_1(self):
        """
        the user agent contains the latest version
        """
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="1/test",
        )
        regex_user_agent = compile("^Algolia for Python \\(4.2.4\\).*")
        assert regex_user_agent.match(_req.headers.get("user-agent")) is not None

    async def test_common_api_2(self):
        """
        calls api with default read timeouts
        """
        self.create_client()

        _req = await self._client.custom_get_with_http_info(
            path="1/test",
        )
        assert _req.timeouts.get("connect") == 2000
        assert _req.timeouts.get("response") == 5000

    async def test_common_api_3(self):
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
        client throws with invalid parameters
        """

        try:
            _config = UsageConfig("", "")
            self._client = UsageClient.create_with_config(
                config=_config, transporter=EchoTransporter(_config)
            )
            assert False
        except (ValueError, Exception) as e:
            assert str(e) == "`app_id` is missing."
        try:
            _config = UsageConfig("", "my-api-key")
            self._client = UsageClient.create_with_config(
                config=_config, transporter=EchoTransporter(_config)
            )
            assert False
        except (ValueError, Exception) as e:
            assert str(e) == "`app_id` is missing."
        try:
            _config = UsageConfig("my-app-id", "")
            self._client = UsageClient.create_with_config(
                config=_config, transporter=EchoTransporter(_config)
            )
            assert False
        except (ValueError, Exception) as e:
            assert str(e) == "`api_key` is missing."
