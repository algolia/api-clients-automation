from algoliasearch.analytics.client import AnalyticsClient


async def snippet_for_custom_delete():
    """
    Snippet for the customDelete method.

    allow del method for a custom path with minimal parameters
    """
    # >SEPARATOR customDelete
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.custom_delete(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_custom_get():
    """
    Snippet for the customGet method.

    allow get method for a custom path with minimal parameters
    """
    # >SEPARATOR customGet
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.custom_get(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_custom_post():
    """
    Snippet for the customPost method.

    allow post method for a custom path with minimal parameters
    """
    # >SEPARATOR customPost
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.custom_post(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_custom_put():
    """
    Snippet for the customPut method.

    allow put method for a custom path with minimal parameters
    """
    # >SEPARATOR customPut
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.custom_put(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_average_click_position():
    """
    Snippet for the getAverageClickPosition method.

    get getAverageClickPosition with minimal parameters
    """
    # >SEPARATOR getAverageClickPosition
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_average_click_position(
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_click_positions():
    """
    Snippet for the getClickPositions method.

    get getClickPositions with minimal parameters
    """
    # >SEPARATOR getClickPositions
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_click_positions(
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_click_through_rate():
    """
    Snippet for the getClickThroughRate method.

    get getClickThroughRate with minimal parameters
    """
    # >SEPARATOR getClickThroughRate
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_click_through_rate(
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_conversation_rate():
    """
    Snippet for the getConversationRate method.

    get getConversationRate with minimal parameters
    """
    # >SEPARATOR getConversationRate
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_conversation_rate(
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_no_click_rate():
    """
    Snippet for the getNoClickRate method.

    get getNoClickRate with minimal parameters
    """
    # >SEPARATOR getNoClickRate
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_no_click_rate(
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_no_results_rate():
    """
    Snippet for the getNoResultsRate method.

    get getNoResultsRate with minimal parameters
    """
    # >SEPARATOR getNoResultsRate
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_no_results_rate(
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_searches_count():
    """
    Snippet for the getSearchesCount method.

    get getSearchesCount with minimal parameters
    """
    # >SEPARATOR getSearchesCount
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_searches_count(
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_searches_no_clicks():
    """
    Snippet for the getSearchesNoClicks method.

    get getSearchesNoClicks with minimal parameters
    """
    # >SEPARATOR getSearchesNoClicks
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_searches_no_clicks(
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_searches_no_results():
    """
    Snippet for the getSearchesNoResults method.

    get getSearchesNoResults with minimal parameters
    """
    # >SEPARATOR getSearchesNoResults
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_searches_no_results(
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_status():
    """
    Snippet for the getStatus method.

    get getStatus with minimal parameters
    """
    # >SEPARATOR getStatus
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_status(
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_top_countries():
    """
    Snippet for the getTopCountries method.

    get getTopCountries with minimal parameters
    """
    # >SEPARATOR getTopCountries
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_top_countries(
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_top_filter_attributes():
    """
    Snippet for the getTopFilterAttributes method.

    get getTopFilterAttributes with minimal parameters
    """
    # >SEPARATOR getTopFilterAttributes
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_top_filter_attributes(
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_top_filter_for_attribute():
    """
    Snippet for the getTopFilterForAttribute method.

    get getTopFilterForAttribute with minimal parameters
    """
    # >SEPARATOR getTopFilterForAttribute
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_top_filter_for_attribute(
        attribute="myAttribute",
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_top_filters_no_results():
    """
    Snippet for the getTopFiltersNoResults method.

    get getTopFiltersNoResults with minimal parameters
    """
    # >SEPARATOR getTopFiltersNoResults
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_top_filters_no_results(
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_top_hits():
    """
    Snippet for the getTopHits method.

    get getTopHits with minimal parameters
    """
    # >SEPARATOR getTopHits
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_top_hits(
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_top_searches():
    """
    Snippet for the getTopSearches method.

    get getTopSearches with minimal parameters
    """
    # >SEPARATOR getTopSearches
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_top_searches(
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_users_count():
    """
    Snippet for the getUsersCount method.

    get getUsersCount with minimal parameters
    """
    # >SEPARATOR getUsersCount
    # Initialize the client
    _client = AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_users_count(
        index="index",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<
