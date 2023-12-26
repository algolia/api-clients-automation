from json import loads

from algoliasearch.analytics.client import AnalyticsClient
from algoliasearch.analytics.config import Config
from algoliasearch.http.transporter import EchoTransporter


class TestAnalyticsClient:
    _config = Config("test_app_id", "test_api_key", "us")
    _client = AnalyticsClient(EchoTransporter(_config), _config)

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

    async def test_get_average_click_position_0(self):
        """
        get getAverageClickPosition with minimal parameters
        """
        _req = await self._client.get_average_click_position_with_http_info(
            index="index",
        )

        assert _req.path == "/2/clicks/averageClickPosition"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_average_click_position_1(self):
        """
        get getAverageClickPosition with all parameters
        """
        _req = await self._client.get_average_click_position_with_http_info(
            index="index",
            start_date="1999-09-19",
            end_date="2001-01-01",
            tags="tag",
        )

        assert _req.path == "/2/clicks/averageClickPosition"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_click_positions_0(self):
        """
        get getClickPositions with minimal parameters
        """
        _req = await self._client.get_click_positions_with_http_info(
            index="index",
        )

        assert _req.path == "/2/clicks/positions"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_click_positions_1(self):
        """
        get getClickPositions with all parameters
        """
        _req = await self._client.get_click_positions_with_http_info(
            index="index",
            start_date="1999-09-19",
            end_date="2001-01-01",
            tags="tag",
        )

        assert _req.path == "/2/clicks/positions"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_click_through_rate_0(self):
        """
        get getClickThroughRate with minimal parameters
        """
        _req = await self._client.get_click_through_rate_with_http_info(
            index="index",
        )

        assert _req.path == "/2/clicks/clickThroughRate"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_click_through_rate_1(self):
        """
        get getClickThroughRate with all parameters
        """
        _req = await self._client.get_click_through_rate_with_http_info(
            index="index",
            start_date="1999-09-19",
            end_date="2001-01-01",
            tags="tag",
        )

        assert _req.path == "/2/clicks/clickThroughRate"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_conversation_rate_0(self):
        """
        get getConversationRate with minimal parameters
        """
        _req = await self._client.get_conversation_rate_with_http_info(
            index="index",
        )

        assert _req.path == "/2/conversions/conversionRate"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_conversation_rate_1(self):
        """
        get getConversationRate with all parameters
        """
        _req = await self._client.get_conversation_rate_with_http_info(
            index="index",
            start_date="1999-09-19",
            end_date="2001-01-01",
            tags="tag",
        )

        assert _req.path == "/2/conversions/conversionRate"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_no_click_rate_0(self):
        """
        get getNoClickRate with minimal parameters
        """
        _req = await self._client.get_no_click_rate_with_http_info(
            index="index",
        )

        assert _req.path == "/2/searches/noClickRate"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_no_click_rate_1(self):
        """
        get getNoClickRate with all parameters
        """
        _req = await self._client.get_no_click_rate_with_http_info(
            index="index",
            start_date="1999-09-19",
            end_date="2001-01-01",
            tags="tag",
        )

        assert _req.path == "/2/searches/noClickRate"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_no_results_rate_0(self):
        """
        get getNoResultsRate with minimal parameters
        """
        _req = await self._client.get_no_results_rate_with_http_info(
            index="index",
        )

        assert _req.path == "/2/searches/noResultRate"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_no_results_rate_1(self):
        """
        get getNoResultsRate with all parameters
        """
        _req = await self._client.get_no_results_rate_with_http_info(
            index="index",
            start_date="1999-09-19",
            end_date="2001-01-01",
            tags="tag",
        )

        assert _req.path == "/2/searches/noResultRate"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_searches_count_0(self):
        """
        get getSearchesCount with minimal parameters
        """
        _req = await self._client.get_searches_count_with_http_info(
            index="index",
        )

        assert _req.path == "/2/searches/count"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_searches_count_1(self):
        """
        get getSearchesCount with all parameters
        """
        _req = await self._client.get_searches_count_with_http_info(
            index="index",
            start_date="1999-09-19",
            end_date="2001-01-01",
            tags="tag",
        )

        assert _req.path == "/2/searches/count"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_searches_no_clicks_0(self):
        """
        get getSearchesNoClicks with minimal parameters
        """
        _req = await self._client.get_searches_no_clicks_with_http_info(
            index="index",
        )

        assert _req.path == "/2/searches/noClicks"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_searches_no_clicks_1(self):
        """
        get getSearchesNoClicks with all parameters
        """
        _req = await self._client.get_searches_no_clicks_with_http_info(
            index="index",
            start_date="1999-09-19",
            end_date="2001-01-01",
            limit=21,
            offset=42,
            tags="tag",
        )

        assert _req.path == "/2/searches/noClicks"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "limit": "21",
                "offset": "42",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_searches_no_results_0(self):
        """
        get getSearchesNoResults with minimal parameters
        """
        _req = await self._client.get_searches_no_results_with_http_info(
            index="index",
        )

        assert _req.path == "/2/searches/noResults"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_searches_no_results_1(self):
        """
        get getSearchesNoResults with all parameters
        """
        _req = await self._client.get_searches_no_results_with_http_info(
            index="index",
            start_date="1999-09-19",
            end_date="2001-01-01",
            limit=21,
            offset=42,
            tags="tag",
        )

        assert _req.path == "/2/searches/noResults"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "limit": "21",
                "offset": "42",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_status_0(self):
        """
        get getStatus with minimal parameters
        """
        _req = await self._client.get_status_with_http_info(
            index="index",
        )

        assert _req.path == "/2/status"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_top_countries_0(self):
        """
        get getTopCountries with minimal parameters
        """
        _req = await self._client.get_top_countries_with_http_info(
            index="index",
        )

        assert _req.path == "/2/countries"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_top_countries_1(self):
        """
        get getTopCountries with all parameters
        """
        _req = await self._client.get_top_countries_with_http_info(
            index="index",
            start_date="1999-09-19",
            end_date="2001-01-01",
            limit=21,
            offset=42,
            tags="tag",
        )

        assert _req.path == "/2/countries"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "limit": "21",
                "offset": "42",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_top_filter_attributes_0(self):
        """
        get getTopFilterAttributes with minimal parameters
        """
        _req = await self._client.get_top_filter_attributes_with_http_info(
            index="index",
        )

        assert _req.path == "/2/filters"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_top_filter_attributes_1(self):
        """
        get getTopFilterAttributes with all parameters
        """
        _req = await self._client.get_top_filter_attributes_with_http_info(
            index="index",
            search="mySearch",
            start_date="1999-09-19",
            end_date="2001-01-01",
            limit=21,
            offset=42,
            tags="tag",
        )

        assert _req.path == "/2/filters"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "search": "mySearch",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "limit": "21",
                "offset": "42",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_top_filter_for_attribute_0(self):
        """
        get getTopFilterForAttribute with minimal parameters
        """
        _req = await self._client.get_top_filter_for_attribute_with_http_info(
            attribute="myAttribute",
            index="index",
        )

        assert _req.path == "/2/filters/myAttribute"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_top_filter_for_attribute_1(self):
        """
        get getTopFilterForAttribute with minimal parameters and multiple attributes
        """
        _req = await self._client.get_top_filter_for_attribute_with_http_info(
            attribute="myAttribute1,myAttribute2",
            index="index",
        )

        assert _req.path == "/2/filters/myAttribute1%2CmyAttribute2"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_top_filter_for_attribute_2(self):
        """
        get getTopFilterForAttribute with all parameters
        """
        _req = await self._client.get_top_filter_for_attribute_with_http_info(
            attribute="myAttribute",
            index="index",
            search="mySearch",
            start_date="1999-09-19",
            end_date="2001-01-01",
            limit=21,
            offset=42,
            tags="tag",
        )

        assert _req.path == "/2/filters/myAttribute"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "search": "mySearch",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "limit": "21",
                "offset": "42",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_top_filter_for_attribute_3(self):
        """
        get getTopFilterForAttribute with all parameters and multiple attributes
        """
        _req = await self._client.get_top_filter_for_attribute_with_http_info(
            attribute="myAttribute1,myAttribute2",
            index="index",
            search="mySearch",
            start_date="1999-09-19",
            end_date="2001-01-01",
            limit=21,
            offset=42,
            tags="tag",
        )

        assert _req.path == "/2/filters/myAttribute1%2CmyAttribute2"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "search": "mySearch",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "limit": "21",
                "offset": "42",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_top_filters_no_results_0(self):
        """
        get getTopFiltersNoResults with minimal parameters
        """
        _req = await self._client.get_top_filters_no_results_with_http_info(
            index="index",
        )

        assert _req.path == "/2/filters/noResults"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_top_filters_no_results_1(self):
        """
        get getTopFiltersNoResults with all parameters
        """
        _req = await self._client.get_top_filters_no_results_with_http_info(
            index="index",
            search="mySearch",
            start_date="1999-09-19",
            end_date="2001-01-01",
            limit=21,
            offset=42,
            tags="tag",
        )

        assert _req.path == "/2/filters/noResults"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "search": "mySearch",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "limit": "21",
                "offset": "42",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_top_hits_0(self):
        """
        get getTopHits with minimal parameters
        """
        _req = await self._client.get_top_hits_with_http_info(
            index="index",
        )

        assert _req.path == "/2/hits"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_top_hits_1(self):
        """
        get getTopHits with all parameters
        """
        _req = await self._client.get_top_hits_with_http_info(
            index="index",
            search="mySearch",
            click_analytics=True,
            start_date="1999-09-19",
            end_date="2001-01-01",
            limit=21,
            offset=42,
            tags="tag",
        )

        assert _req.path == "/2/hits"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "search": "mySearch",
                "clickAnalytics": "true",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "limit": "21",
                "offset": "42",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_top_searches_0(self):
        """
        get getTopSearches with minimal parameters
        """
        _req = await self._client.get_top_searches_with_http_info(
            index="index",
        )

        assert _req.path == "/2/searches"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_top_searches_1(self):
        """
        get getTopSearches with all parameters
        """
        _req = await self._client.get_top_searches_with_http_info(
            index="index",
            click_analytics=True,
            start_date="1999-09-19",
            end_date="2001-01-01",
            order_by="searchCount",
            direction="asc",
            limit=21,
            offset=42,
            tags="tag",
        )

        assert _req.path == "/2/searches"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "clickAnalytics": "true",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "orderBy": "searchCount",
                "direction": "asc",
                "limit": "21",
                "offset": "42",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_users_count_0(self):
        """
        get getUsersCount with minimal parameters
        """
        _req = await self._client.get_users_count_with_http_info(
            index="index",
        )

        assert _req.path == "/2/users/count"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() >= {"index": "index"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_users_count_1(self):
        """
        get getUsersCount with all parameters
        """
        _req = await self._client.get_users_count_with_http_info(
            index="index",
            start_date="1999-09-19",
            end_date="2001-01-01",
            tags="tag",
        )

        assert _req.path == "/2/users/count"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            >= {
                "index": "index",
                "startDate": "1999-09-19",
                "endDate": "2001-01-01",
                "tags": "tag",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None
