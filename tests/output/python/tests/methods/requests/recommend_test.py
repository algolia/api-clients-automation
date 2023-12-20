from json import loads
from os import environ

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.recommend.client import RecommendClient
from algoliasearch.recommend.config import Config


class TestRecommendClient:
    app_id = environ.get("ALGOLIA_APPLICATION_ID")
    if app_id is None:
        app_id = "test_app_id"

    api_key = environ.get("ALGOLIA_SEARCH_KEY")
    if api_key is None:
        api_key = "test_api_key"

    _config = Config(app_id, api_key)
    _client = RecommendClient(EchoTransporter(_config), _config)

    async def test_custom_delete_0(self):
        """
        allow del method for a custom path with minimal parameters
        """
        _req = await self._client.custom_delete_with_http_info(
            path="/test/minimal",
        )

        assert _req.path == "/1/test/minimal"
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() >= {}.items()
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
        assert _req.query_parameters.items() >= {"query": "parameters"}.items()
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
        assert _req.query_parameters.items() >= {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_custom_get_1(self):
        """
        allow get method for a custom path with all parameters
        """
        _req = await self._client.custom_get_with_http_info(
            path="/test/all",
            parameters={
                "query": "parameters",
            },
        )

        assert _req.path == "/1/test/all"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"query": "parameters"}.items()
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
        assert _req.query_parameters.items() >= {}.items()
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
        assert _req.query_parameters.items() >= {"query": "parameters"}.items()
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
        assert _req.query_parameters.items() >= {"query": "myQueryParameter"}.items()
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
            >= {"query": "parameters", "query2": "myQueryParameter"}.items()
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
        assert _req.query_parameters.items() >= {"query": "parameters"}.items()
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
        assert _req.query_parameters.items() >= {"query": "parameters"}.items()
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
            >= {"query": "parameters", "isItWorking": "true"}.items()
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
            >= {"query": "parameters", "myParam": "2"}.items()
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
            >= {"query": "parameters", "myParam": "c,d"}.items()
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
            >= {"query": "parameters", "myParam": "true,true,false"}.items()
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
            >= {"query": "parameters", "myParam": "1,2"}.items()
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
        assert _req.query_parameters.items() >= {}.items()
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
        assert _req.query_parameters.items() >= {"query": "parameters"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"body":"parameters"}""")

    async def test_delete_recommend_rule_0(self):
        """
        deleteRecommendRule0
        """
        _req = await self._client.delete_recommend_rule_with_http_info(
            index_name="indexName",
            model="related-products",
            object_id="objectID",
        )

        assert (
            _req.path
            == "/1/indexes/indexName/related-products/recommend/rules/objectID"
        )
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() >= {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_recommend_rule_0(self):
        """
        getRecommendRule0
        """
        _req = await self._client.get_recommend_rule_with_http_info(
            index_name="indexName",
            model="related-products",
            object_id="objectID",
        )

        assert (
            _req.path
            == "/1/indexes/indexName/related-products/recommend/rules/objectID"
        )
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_recommend_status_0(self):
        """
        getRecommendStatus0
        """
        _req = await self._client.get_recommend_status_with_http_info(
            index_name="indexName",
            model="related-products",
            task_id=12345,
        )

        assert _req.path == "/1/indexes/indexName/related-products/task/12345"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_recommendations_0(self):
        """
        get recommendations for recommend model with minimal parameters
        """
        _req = await self._client.get_recommendations_with_http_info(
            get_recommendations_params={
                "requests": [
                    {
                        "indexName": "indexName",
                        "objectID": "objectID",
                        "model": "related-products",
                        "threshold": 42,
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/*/recommendations"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() >= {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"indexName":"indexName","objectID":"objectID","model":"related-products","threshold":42}]}"""
        )

    async def test_get_recommendations_1(self):
        """
        get recommendations for recommend model with all parameters
        """
        _req = await self._client.get_recommendations_with_http_info(
            get_recommendations_params={
                "requests": [
                    {
                        "indexName": "indexName",
                        "objectID": "objectID",
                        "model": "related-products",
                        "threshold": 42,
                        "maxRecommendations": 10,
                        "queryParameters": {
                            "query": "myQuery",
                            "facetFilters": [
                                "query",
                            ],
                        },
                        "fallbackParameters": {
                            "query": "myQuery",
                            "facetFilters": [
                                "fallback",
                            ],
                        },
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/*/recommendations"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() >= {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"indexName":"indexName","objectID":"objectID","model":"related-products","threshold":42,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback"]}}]}"""
        )

    async def test_get_recommendations_2(self):
        """
        get recommendations for trending model with minimal parameters
        """
        _req = await self._client.get_recommendations_with_http_info(
            get_recommendations_params={
                "requests": [
                    {
                        "indexName": "indexName",
                        "model": "trending-items",
                        "threshold": 42,
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/*/recommendations"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() >= {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"indexName":"indexName","model":"trending-items","threshold":42}]}"""
        )

    async def test_get_recommendations_3(self):
        """
        get recommendations for trending model with all parameters
        """
        _req = await self._client.get_recommendations_with_http_info(
            get_recommendations_params={
                "requests": [
                    {
                        "indexName": "indexName",
                        "model": "trending-items",
                        "threshold": 42,
                        "maxRecommendations": 10,
                        "facetName": "myFacetName",
                        "facetValue": "myFacetValue",
                        "queryParameters": {
                            "query": "myQuery",
                            "facetFilters": [
                                "query",
                            ],
                        },
                        "fallbackParameters": {
                            "query": "myQuery",
                            "facetFilters": [
                                "fallback",
                            ],
                        },
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/*/recommendations"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() >= {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"indexName":"indexName","model":"trending-items","threshold":42,"maxRecommendations":10,"facetName":"myFacetName","facetValue":"myFacetValue","queryParameters":{"query":"myQuery","facetFilters":["query"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback"]}}]}"""
        )

    async def test_get_recommendations_4(self):
        """
        get multiple recommendations with minimal parameters
        """
        _req = await self._client.get_recommendations_with_http_info(
            get_recommendations_params={
                "requests": [
                    {
                        "indexName": "indexName1",
                        "objectID": "objectID1",
                        "model": "related-products",
                        "threshold": 21,
                    },
                    {
                        "indexName": "indexName2",
                        "objectID": "objectID2",
                        "model": "related-products",
                        "threshold": 21,
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/*/recommendations"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() >= {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"related-products","threshold":21},{"indexName":"indexName2","objectID":"objectID2","model":"related-products","threshold":21}]}"""
        )

    async def test_get_recommendations_5(self):
        """
        get multiple recommendations with all parameters
        """
        _req = await self._client.get_recommendations_with_http_info(
            get_recommendations_params={
                "requests": [
                    {
                        "indexName": "indexName1",
                        "objectID": "objectID1",
                        "model": "related-products",
                        "threshold": 21,
                        "maxRecommendations": 10,
                        "queryParameters": {
                            "query": "myQuery",
                            "facetFilters": [
                                "query1",
                            ],
                        },
                        "fallbackParameters": {
                            "query": "myQuery",
                            "facetFilters": [
                                "fallback1",
                            ],
                        },
                    },
                    {
                        "indexName": "indexName2",
                        "objectID": "objectID2",
                        "model": "related-products",
                        "threshold": 21,
                        "maxRecommendations": 10,
                        "queryParameters": {
                            "query": "myQuery",
                            "facetFilters": [
                                "query2",
                            ],
                        },
                        "fallbackParameters": {
                            "query": "myQuery",
                            "facetFilters": [
                                "fallback2",
                            ],
                        },
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/*/recommendations"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() >= {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"related-products","threshold":21,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query1"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback1"]}},{"indexName":"indexName2","objectID":"objectID2","model":"related-products","threshold":21,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query2"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback2"]}}]}"""
        )

    async def test_get_recommendations_6(self):
        """
        get frequently bought together recommendations
        """
        _req = await self._client.get_recommendations_with_http_info(
            get_recommendations_params={
                "requests": [
                    {
                        "indexName": "indexName1",
                        "objectID": "objectID1",
                        "model": "bought-together",
                        "threshold": 42,
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/*/recommendations"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() >= {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"bought-together","threshold":42}]}"""
        )

    async def test_search_recommend_rules_0(self):
        """
        searchRecommendRules0
        """
        _req = await self._client.search_recommend_rules_with_http_info(
            index_name="indexName",
            model="related-products",
        )

        assert (
            _req.path == "/1/indexes/indexName/related-products/recommend/rules/search"
        )
        assert _req.verb == "POST"
        assert _req.query_parameters.items() >= {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{}""")
