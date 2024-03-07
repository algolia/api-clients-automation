from algoliasearch.abtesting.client import AbtestingClient


async def snippet_for_add_ab_tests():
    """
    Snippet for the addABTests method.

    addABTests with minimal parameters
    """
    # >SEPARATOR addABTests
    # Initialize the client
    _client = AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.add_ab_tests(
        add_ab_tests_request={
            "endAt": "2022-12-31T00:00:00.000Z",
            "name": "myABTest",
            "variants": [
                {
                    "index": "AB_TEST_1",
                    "trafficPercentage": 30,
                },
                {
                    "index": "AB_TEST_2",
                    "trafficPercentage": 50,
                },
            ],
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_custom_delete():
    """
    Snippet for the customDelete method.

    allow del method for a custom path with minimal parameters
    """
    # >SEPARATOR customDelete
    # Initialize the client
    _client = AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

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
    _client = AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

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
    _client = AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

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
    _client = AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.custom_put(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_delete_ab_test():
    """
    Snippet for the deleteABTest method.

    deleteABTest
    """
    # >SEPARATOR deleteABTest
    # Initialize the client
    _client = AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.delete_ab_test(
        id=42,
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_ab_test():
    """
    Snippet for the getABTest method.

    getABTest
    """
    # >SEPARATOR getABTest
    # Initialize the client
    _client = AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_ab_test(
        id=42,
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_list_ab_tests():
    """
    Snippet for the listABTests method.

    listABTests with minimal parameters
    """
    # >SEPARATOR listABTests
    # Initialize the client
    _client = AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.list_ab_tests()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_stop_ab_test():
    """
    Snippet for the stopABTest method.

    stopABTest
    """
    # >SEPARATOR stopABTest
    # Initialize the client
    _client = AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.stop_ab_test(
        id=42,
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<
