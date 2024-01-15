from algoliasearch.monitoring.client import MonitoringClient


async def snippet_for_custom_delete():
    """
    Snippet for the customDelete method.

    allow del method for a custom path with minimal parameters
    """
    # Initialize the client
    _client = MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.custom_delete(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_custom_get():
    """
    Snippet for the customGet method.

    allow get method for a custom path with minimal parameters
    """
    # Initialize the client
    _client = MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.custom_get(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_custom_post():
    """
    Snippet for the customPost method.

    allow post method for a custom path with minimal parameters
    """
    # Initialize the client
    _client = MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.custom_post(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_custom_put():
    """
    Snippet for the customPut method.

    allow put method for a custom path with minimal parameters
    """
    # Initialize the client
    _client = MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.custom_put(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_cluster_incidents():
    """
    Snippet for the getClusterIncidents method.

    getClusterIncidents
    """
    # Initialize the client
    _client = MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_cluster_incidents(
        clusters="c1-de",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_cluster_status():
    """
    Snippet for the getClusterStatus method.

    getClusterStatus
    """
    # Initialize the client
    _client = MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_cluster_status(
        clusters="c1-de",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_incidents():
    """
    Snippet for the getIncidents method.

    getIncidents
    """
    # Initialize the client
    _client = MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_incidents()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_indexing_time():
    """
    Snippet for the getIndexingTime method.

    getIndexingTime
    """
    # Initialize the client
    _client = MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_indexing_time(
        clusters="c1-de",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_inventory():
    """
    Snippet for the getInventory method.

    getInventory
    """
    # Initialize the client
    _client = MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_inventory()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_latency():
    """
    Snippet for the getLatency method.

    getLatency
    """
    # Initialize the client
    _client = MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_latency(
        clusters="c1-de",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_metrics():
    """
    Snippet for the getMetrics method.

    getMetrics
    """
    # Initialize the client
    _client = MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_metrics(
        metric="avg_build_time",
        period="minute",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_reachability():
    """
    Snippet for the getReachability method.

    getReachability
    """
    # Initialize the client
    _client = MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_reachability(
        clusters="c1-de",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_status():
    """
    Snippet for the getStatus method.

    getStatus
    """
    # Initialize the client
    _client = MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_status()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
