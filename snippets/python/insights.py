from algoliasearch.insights.client import InsightsClient


async def snippet_for_custom_delete():
    """
    Snippet for the customDelete method.

    allow del method for a custom path with minimal parameters
    """
    # >SEPARATOR customDelete
    # Initialize the client
    _client = InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

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
    _client = InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

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
    _client = InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

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
    _client = InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.custom_put(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_delete_user_token():
    """
    Snippet for the deleteUserToken method.

    deleteUserToken0
    """
    # >SEPARATOR deleteUserToken
    # Initialize the client
    _client = InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.delete_user_token(
        user_token="test-user-1",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_push_events():
    """
    Snippet for the pushEvents method.

    pushEvents0
    """
    # >SEPARATOR pushEvents
    # Initialize the client
    _client = InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.push_events(
        insights_events={
            "events": [
                {
                    "eventType": "click",
                    "eventName": "Product Clicked",
                    "index": "products",
                    "userToken": "user-123456",
                    "authenticatedUserToken": "user-123456",
                    "timestamp": 1641290601962,
                    "objectIDs": [
                        "9780545139700",
                        "9780439784542",
                    ],
                    "queryID": "43b15df305339e827f0ac0bdc5ebcaa7",
                    "positions": [
                        7,
                        6,
                    ],
                },
            ],
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<
