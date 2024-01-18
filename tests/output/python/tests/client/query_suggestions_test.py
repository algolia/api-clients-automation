from re import compile

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.query_suggestions.client import QuerySuggestionsClient
from algoliasearch.query_suggestions.config import QuerySuggestionsConfig


class TestQuerySuggestionsClient:
    _config: QuerySuggestionsConfig
    _client: QuerySuggestionsClient

    def create_client(self) -> QuerySuggestionsClient:
        self._config = QuerySuggestionsConfig("appId", "apiKey", "us")
        self._client = QuerySuggestionsClient.create_with_config(
            config=self._config, transporter=EchoTransporter(self._config)
        )

    async def test_common_api_0(self):
        self.create_client()

        _req = await self._client.custom_post_with_http_info(
            path="/test",
        )
        regex_user_agent = compile(
            "^Algolia for Python \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; QuerySuggestions (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
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
        try:
            self._client = QuerySuggestionsClient(
                transporter=EchoTransporter(
                    QuerySuggestionsConfig("my-app-id", "my-api-key", "")
                )
            )
        except (ValueError, Exception) as e:
            assert (
                str(e)
                == "`region` is required and must be one of the following: eu, us"
            )

    async def test_parameters_1(self):
        try:
            self._client = QuerySuggestionsClient(
                transporter=EchoTransporter(
                    QuerySuggestionsConfig("my-app-id", "my-api-key", "not_a_region")
                )
            )
        except (ValueError, Exception) as e:
            assert (
                str(e)
                == "`region` is required and must be one of the following: eu, us"
            )

    async def test_parameters_2(self):
        self._client = QuerySuggestionsClient(
            transporter=EchoTransporter(
                QuerySuggestionsConfig("my-app-id", "my-api-key", "us")
            )
        )
