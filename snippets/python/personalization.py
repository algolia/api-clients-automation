from algoliasearch.personalization.client import PersonalizationClient


async def snippet_for_custom_delete():
    """
    Snippet for the customDelete method.

    allow del method for a custom path with minimal parameters
    """
    # >SEPARATOR customDelete
    # Initialize the client
    _client = PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

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
    _client = PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

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
    _client = PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

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
    _client = PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.custom_put(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_delete_user_profile():
    """
    Snippet for the deleteUserProfile method.

    delete deleteUserProfile
    """
    # >SEPARATOR deleteUserProfile
    # Initialize the client
    _client = PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.delete_user_profile(
        user_token="UserToken",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_personalization_strategy():
    """
    Snippet for the getPersonalizationStrategy method.

    get getPersonalizationStrategy
    """
    # >SEPARATOR getPersonalizationStrategy
    # Initialize the client
    _client = PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_personalization_strategy()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_user_token_profile():
    """
    Snippet for the getUserTokenProfile method.

    get getUserTokenProfile
    """
    # >SEPARATOR getUserTokenProfile
    # Initialize the client
    _client = PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_user_token_profile(
        user_token="UserToken",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_set_personalization_strategy():
    """
    Snippet for the setPersonalizationStrategy method.

    set setPersonalizationStrategy
    """
    # >SEPARATOR setPersonalizationStrategy
    # Initialize the client
    _client = PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.set_personalization_strategy(
        personalization_strategy_params={
            "eventScoring": [
                {
                    "score": 42,
                    "eventName": "Algolia",
                    "eventType": "Event",
                },
            ],
            "facetScoring": [
                {
                    "score": 42,
                    "facetName": "Event",
                },
            ],
            "personalizationImpact": 42,
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<
