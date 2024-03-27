from json import loads

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.monitoring.client import MonitoringClient
from algoliasearch.monitoring.config import MonitoringConfig


class TestMonitoringClient:
    _config = MonitoringConfig("test_app_id", "test_api_key")
    _client = MonitoringClient.create_with_config(
        config=_config, transporter=EchoTransporter(_config)
    )

    async def test_custom_delete_0(self):
        """
        allow del method for a custom path with minimal parameters
        """
        _req = await self._client.custom_delete_with_http_info(
            path="test/minimal",
        )

        assert _req.path == "/test/minimal"
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_custom_delete_1(self):
        """
        allow del method for a custom path with all parameters
        """
        _req = await self._client.custom_delete_with_http_info(
            path="test/all",
            parameters={
                "query": "parameters",
            },
        )

        assert _req.path == "/test/all"
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() == {"query": "parameters"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_custom_get_0(self):
        """
        allow get method for a custom path with minimal parameters
        """
        _req = await self._client.custom_get_with_http_info(
            path="test/minimal",
        )

        assert _req.path == "/test/minimal"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_custom_get_1(self):
        """
        allow get method for a custom path with all parameters
        """
        _req = await self._client.custom_get_with_http_info(
            path="test/all",
            parameters={
                "query": "parameters with space",
            },
        )

        assert _req.path == "/test/all"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            == {"query": "parameters%20with%20space"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_custom_get_2(self):
        """
        requestOptions should be escaped too
        """
        _req = await self._client.custom_get_with_http_info(
            path="test/all",
            parameters={
                "query": "to be overriden",
            },
            request_options={
                "headers": loads("""{"x-header-1":"spaces are left alone"}"""),
                "query_parameters": loads(
                    """{"query":"parameters with space","and an array":["array","with spaces"]}"""
                ),
            },
        )

        assert _req.path == "/test/all"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            == {
                "query": "parameters%20with%20space",
                "and%20an%20array": "array%2Cwith%20spaces",
            }.items()
        )
        assert _req.headers.items() >= {"x-header-1": "spaces are left alone"}.items()
        assert _req.data is None

    async def test_custom_post_0(self):
        """
        allow post method for a custom path with minimal parameters
        """
        _req = await self._client.custom_post_with_http_info(
            path="test/minimal",
        )

        assert _req.path == "/test/minimal"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{}""")

    async def test_custom_post_1(self):
        """
        allow post method for a custom path with all parameters
        """
        _req = await self._client.custom_post_with_http_info(
            path="test/all",
            parameters={
                "query": "parameters",
            },
            body={
                "body": "parameters",
            },
        )

        assert _req.path == "/test/all"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {"query": "parameters"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"body":"parameters"}""")

    async def test_custom_post_2(self):
        """
        requestOptions can override default query parameters
        """
        _req = await self._client.custom_post_with_http_info(
            path="test/requestOptions",
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

        assert _req.path == "/test/requestOptions"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {"query": "myQueryParameter"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_3(self):
        """
        requestOptions merges query parameters with default ones
        """
        _req = await self._client.custom_post_with_http_info(
            path="test/requestOptions",
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

        assert _req.path == "/test/requestOptions"
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
            path="test/requestOptions",
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

        assert _req.path == "/test/requestOptions"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {"query": "parameters"}.items()
        assert _req.headers.items() >= {"x-algolia-api-key": "myApiKey"}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_5(self):
        """
        requestOptions merges headers with default ones
        """
        _req = await self._client.custom_post_with_http_info(
            path="test/requestOptions",
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

        assert _req.path == "/test/requestOptions"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {"query": "parameters"}.items()
        assert _req.headers.items() >= {"x-algolia-api-key": "myApiKey"}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_6(self):
        """
        requestOptions queryParameters accepts booleans
        """
        _req = await self._client.custom_post_with_http_info(
            path="test/requestOptions",
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

        assert _req.path == "/test/requestOptions"
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
            path="test/requestOptions",
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

        assert _req.path == "/test/requestOptions"
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
            path="test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "query_parameters": loads("""{"myParam":["b and c","d"]}"""),
            },
        )

        assert _req.path == "/test/requestOptions"
        assert _req.verb == "POST"
        assert (
            _req.query_parameters.items()
            == {"query": "parameters", "myParam": "b%20and%20c%2Cd"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_9(self):
        """
        requestOptions queryParameters accepts list of booleans
        """
        _req = await self._client.custom_post_with_http_info(
            path="test/requestOptions",
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

        assert _req.path == "/test/requestOptions"
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
            path="test/requestOptions",
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

        assert _req.path == "/test/requestOptions"
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
            path="test/minimal",
        )

        assert _req.path == "/test/minimal"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{}""")

    async def test_custom_put_1(self):
        """
        allow put method for a custom path with all parameters
        """
        _req = await self._client.custom_put_with_http_info(
            path="test/all",
            parameters={
                "query": "parameters",
            },
            body={
                "body": "parameters",
            },
        )

        assert _req.path == "/test/all"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {"query": "parameters"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"body":"parameters"}""")

    async def test_get_cluster_incidents_0(self):
        """
        getClusterIncidents
        """
        _req = await self._client.get_cluster_incidents_with_http_info(
            clusters="c1-de",
        )

        assert _req.path == "/1/incidents/c1-de"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_cluster_status_0(self):
        """
        getClusterStatus
        """
        _req = await self._client.get_cluster_status_with_http_info(
            clusters="c1-de",
        )

        assert _req.path == "/1/status/c1-de"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_incidents_0(self):
        """
        getIncidents
        """
        _req = await self._client.get_incidents_with_http_info()

        assert _req.path == "/1/incidents"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_indexing_time_0(self):
        """
        getIndexingTime
        """
        _req = await self._client.get_indexing_time_with_http_info(
            clusters="c1-de",
        )

        assert _req.path == "/1/indexing/c1-de"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_latency_0(self):
        """
        getLatency
        """
        _req = await self._client.get_latency_with_http_info(
            clusters="c1-de",
        )

        assert _req.path == "/1/latency/c1-de"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_metrics_0(self):
        """
        getMetrics
        """
        _req = await self._client.get_metrics_with_http_info(
            metric="avg_build_time",
            period="minute",
        )

        assert _req.path == "/1/infrastructure/avg_build_time/period/minute"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_reachability_0(self):
        """
        getReachability
        """
        _req = await self._client.get_reachability_with_http_info(
            clusters="c1-de",
        )

        assert _req.path == "/1/reachability/c1-de/probes"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_servers_0(self):
        """
        getInventory
        """
        _req = await self._client.get_servers_with_http_info()

        assert _req.path == "/1/inventory/servers"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_status_0(self):
        """
        getStatus
        """
        _req = await self._client.get_status_with_http_info()

        assert _req.path == "/1/status"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None
