# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
from re import compile

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.monitoring.client import MonitoringClient
from algoliasearch.monitoring.config import MonitoringConfig


class TestMonitoringClient:
    _client: MonitoringClient

    def create_client(self) -> MonitoringClient:
        _config = MonitoringConfig("appId", "apiKey")
        self._client = MonitoringClient.create_with_config(
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
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Monitoring (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
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
        use the correct host
        """

        _config = MonitoringConfig("my-app-id", "my-api-key")
        self._client = MonitoringClient.create_with_config(
            config=_config, transporter=EchoTransporter(_config)
        )
        _req = await self._client.custom_delete_with_http_info(
            path="test",
        )
        assert _req.host == "status.algolia.com"
