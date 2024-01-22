from re import compile

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.monitoring.client import MonitoringClient
from algoliasearch.monitoring.config import MonitoringConfig


class TestMonitoringClient:
    _config: MonitoringConfig
    _client: MonitoringClient

    def create_client(self) -> MonitoringClient:
        self._config = MonitoringConfig("appId", "apiKey")
        self._client = MonitoringClient.create_with_config(
            config=self._config, transporter=EchoTransporter(self._config)
        )

    async def test_common_api_0(self):
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )
        regex_user_agent = compile(
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Monitoring (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
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
        self._client = MonitoringClient(
            transporter=EchoTransporter(MonitoringConfig("my-app-id", "my-api-key"))
        )
        _req = await self._client.custom_delete_with_http_info(
            path="/test",
        )
        assert _req.host == "status.algolia.com"
