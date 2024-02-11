from json import loads

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.query_suggestions.client import QuerySuggestionsClient
from algoliasearch.query_suggestions.config import QuerySuggestionsConfig


class TestQuerySuggestionsClient:
    _config = QuerySuggestionsConfig("test_app_id", "test_api_key", "us")
    _client = QuerySuggestionsClient.create_with_config(
        config=_config, transporter=EchoTransporter(_config)
    )

    async def test_create_config_0(self):
        """
        createConfig0
        """
        _req = await self._client.create_config_with_http_info(
            query_suggestions_configuration_with_index={
                "indexName": "theIndexName",
                "sourceIndices": [
                    {
                        "indexName": "testIndex",
                        "facets": [
                            {
                                "attribute": "test",
                            },
                        ],
                        "generate": [
                            [
                                "facetA",
                                "facetB",
                            ],
                            [
                                "facetC",
                            ],
                        ],
                    },
                ],
                "languages": [
                    "french",
                ],
                "exclude": [
                    "test",
                ],
            },
        )

        assert _req.path == "/1/configs"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"indexName":"theIndexName","sourceIndices":[{"indexName":"testIndex","facets":[{"attribute":"test"}],"generate":[["facetA","facetB"],["facetC"]]}],"languages":["french"],"exclude":["test"]}"""
        )

    async def test_custom_delete_0(self):
        """
        allow del method for a custom path with minimal parameters
        """
        _req = await self._client.custom_delete_with_http_info(
            path="/test/minimal",
        )

        assert _req.path == "/1/test/minimal"
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_custom_delete_1(self):
        """
        allow del method for a custom path with all parameters
        """
        _req = await self._client.custom_delete_with_http_info(
            path="/test/all",
            parameters={
                "query": "parameters",
            },
        )

        assert _req.path == "/1/test/all"
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() == {"query": "parameters"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_custom_get_0(self):
        """
        allow get method for a custom path with minimal parameters
        """
        _req = await self._client.custom_get_with_http_info(
            path="/test/minimal",
        )

        assert _req.path == "/1/test/minimal"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_custom_get_1(self):
        """
        allow get method for a custom path with all parameters
        """
        _req = await self._client.custom_get_with_http_info(
            path="/test/all",
            parameters={
                "query": "parameters with space",
            },
        )

        assert _req.path == "/1/test/all"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            == {"query": "parameters%20with%20space"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_custom_post_0(self):
        """
        allow post method for a custom path with minimal parameters
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/minimal",
        )

        assert _req.path == "/1/test/minimal"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{}""")

    async def test_custom_post_1(self):
        """
        allow post method for a custom path with all parameters
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/all",
            parameters={
                "query": "parameters",
            },
            body={
                "body": "parameters",
            },
        )

        assert _req.path == "/1/test/all"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {"query": "parameters"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"body":"parameters"}""")

    async def test_custom_post_2(self):
        """
        requestOptions can override default query parameters
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "query_parameters": loads("""{"query":"myQueryParameter"}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {"query": "myQueryParameter"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_3(self):
        """
        requestOptions merges query parameters with default ones
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "query_parameters": loads("""{"query2":"myQueryParameter"}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert (
            _req.query_parameters.items()
            == {"query": "parameters", "query2": "myQueryParameter"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_4(self):
        """
        requestOptions can override default headers
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "headers": loads("""{"x-algolia-api-key":"myApiKey"}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {"query": "parameters"}.items()
        assert _req.headers.items() >= {"x-algolia-api-key": "myApiKey"}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_5(self):
        """
        requestOptions merges headers with default ones
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "headers": loads("""{"x-algolia-api-key":"myApiKey"}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {"query": "parameters"}.items()
        assert _req.headers.items() >= {"x-algolia-api-key": "myApiKey"}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_6(self):
        """
        requestOptions queryParameters accepts booleans
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "query_parameters": loads("""{"isItWorking":true}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert (
            _req.query_parameters.items()
            == {"query": "parameters", "isItWorking": "true"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_7(self):
        """
        requestOptions queryParameters accepts integers
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "query_parameters": loads("""{"myParam":2}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert (
            _req.query_parameters.items()
            == {"query": "parameters", "myParam": "2"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_8(self):
        """
        requestOptions queryParameters accepts list of string
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "query_parameters": loads("""{"myParam":["c","d"]}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert (
            _req.query_parameters.items()
            == {"query": "parameters", "myParam": "c%2Cd"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_9(self):
        """
        requestOptions queryParameters accepts list of booleans
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "query_parameters": loads("""{"myParam":[true,true,false]}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert (
            _req.query_parameters.items()
            == {"query": "parameters", "myParam": "true%2Ctrue%2Cfalse"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_10(self):
        """
        requestOptions queryParameters accepts list of integers
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "query_parameters": loads("""{"myParam":[1,2]}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert (
            _req.query_parameters.items()
            == {"query": "parameters", "myParam": "1%2C2"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_put_0(self):
        """
        allow put method for a custom path with minimal parameters
        """
        _req = await self._client.custom_put_with_http_info(
            path="/test/minimal",
        )

        assert _req.path == "/1/test/minimal"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{}""")

    async def test_custom_put_1(self):
        """
        allow put method for a custom path with all parameters
        """
        _req = await self._client.custom_put_with_http_info(
            path="/test/all",
            parameters={
                "query": "parameters",
            },
            body={
                "body": "parameters",
            },
        )

        assert _req.path == "/1/test/all"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {"query": "parameters"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"body":"parameters"}""")

    async def test_delete_config_0(self):
        """
        deleteConfig0
        """
        _req = await self._client.delete_config_with_http_info(
            index_name="theIndexName",
        )

        assert _req.path == "/1/configs/theIndexName"
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_all_configs_0(self):
        """
        getAllConfigs0
        """
        _req = await self._client.get_all_configs_with_http_info()

        assert _req.path == "/1/configs"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_config_0(self):
        """
        getConfig0
        """
        _req = await self._client.get_config_with_http_info(
            index_name="theIndexName",
        )

        assert _req.path == "/1/configs/theIndexName"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_config_status_0(self):
        """
        getConfigStatus0
        """
        _req = await self._client.get_config_status_with_http_info(
            index_name="theIndexName",
        )

        assert _req.path == "/1/configs/theIndexName/status"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_log_file_0(self):
        """
        getLogFile0
        """
        _req = await self._client.get_log_file_with_http_info(
            index_name="theIndexName",
        )

        assert _req.path == "/1/logs/theIndexName"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_update_config_0(self):
        """
        updateConfig0
        """
        _req = await self._client.update_config_with_http_info(
            index_name="theIndexName",
            query_suggestions_configuration={
                "sourceIndices": [
                    {
                        "indexName": "testIndex",
                        "facets": [
                            {
                                "attribute": "test",
                            },
                        ],
                        "generate": [
                            [
                                "facetA",
                                "facetB",
                            ],
                            [
                                "facetC",
                            ],
                        ],
                    },
                ],
                "languages": [
                    "french",
                ],
                "exclude": [
                    "test",
                ],
            },
        )

        assert _req.path == "/1/configs/theIndexName"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"sourceIndices":[{"indexName":"testIndex","facets":[{"attribute":"test"}],"generate":[["facetA","facetB"],["facetC"]]}],"languages":["french"],"exclude":["test"]}"""
        )
