from re import compile

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.ingestion.client import IngestionClient
from algoliasearch.ingestion.config import IngestionConfig


class TestIngestionClient:
    _config: IngestionConfig
    _client: IngestionClient

    def create_client(self) -> IngestionClient:
        self._config = IngestionConfig("appId", "apiKey", "us")
        self._client = IngestionClient.create_with_config(
            config=self._config, transporter=EchoTransporter(self._config)
        )

    async def test_common_api_0(self):
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )
        regex_user_agent = compile(
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Ingestion (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
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
        self._client = IngestionClient(
            transporter=EchoTransporter(
                IngestionConfig("my-app-id", "my-api-key", "us")
            )
        )
        _req = await self._client.get_source_with_http_info(
            source_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        )
        assert _req.host == "data.us.algolia.com"

    async def test_parameters_1(self):
        try:
            self._client = IngestionClient(
                transporter=EchoTransporter(
                    IngestionConfig("my-app-id", "my-api-key", "not_a_region")
                )
            )
        except (ValueError, Exception) as e:
            assert (
                str(e)
                == "`region` is required and must be one of the following: eu, us"
            )
