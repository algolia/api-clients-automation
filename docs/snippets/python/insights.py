# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
# >IMPORT
from algoliasearch.insights.client import InsightsClientSync
from json import loads
# IMPORT<


def snippet_for_custom_delete():
    """
    Snippet for the customDelete method.

    allow del method for a custom path with minimal parameters
    """
    # >SEPARATOR customDelete allow del method for a custom path with minimal parameters
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_delete(
        path="test/minimal",
    )

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_delete1():
    """
    Snippet for the customDelete method.

    allow del method for a custom path with all parameters
    """
    # >SEPARATOR customDelete allow del method for a custom path with all parameters
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_delete(
        path="test/all",
        parameters={
            "query": "parameters",
        },
    )

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_get():
    """
    Snippet for the customGet method.

    allow get method for a custom path with minimal parameters
    """
    # >SEPARATOR customGet allow get method for a custom path with minimal parameters
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_get(
        path="test/minimal",
    )

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_get1():
    """
    Snippet for the customGet method.

    allow get method for a custom path with all parameters
    """
    # >SEPARATOR customGet allow get method for a custom path with all parameters
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_get(
        path="test/all",
        parameters={
            "query": "parameters with space",
        },
    )

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_get2():
    """
    Snippet for the customGet method.

    requestOptions should be escaped too
    """
    # >SEPARATOR customGet requestOptions should be escaped too
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_get(
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

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_post():
    """
    Snippet for the customPost method.

    allow post method for a custom path with minimal parameters
    """
    # >SEPARATOR customPost allow post method for a custom path with minimal parameters
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_post(
        path="test/minimal",
    )

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_post1():
    """
    Snippet for the customPost method.

    allow post method for a custom path with all parameters
    """
    # >SEPARATOR customPost allow post method for a custom path with all parameters
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_post(
        path="test/all",
        parameters={
            "query": "parameters",
        },
        body={
            "body": "parameters",
        },
    )

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_post2():
    """
    Snippet for the customPost method.

    requestOptions can override default query parameters
    """
    # >SEPARATOR customPost requestOptions can override default query parameters
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_post(
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

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_post3():
    """
    Snippet for the customPost method.

    requestOptions merges query parameters with default ones
    """
    # >SEPARATOR customPost requestOptions merges query parameters with default ones
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_post(
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

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_post4():
    """
    Snippet for the customPost method.

    requestOptions can override default headers
    """
    # >SEPARATOR customPost requestOptions can override default headers
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_post(
        path="test/requestOptions",
        parameters={
            "query": "parameters",
        },
        body={
            "facet": "filters",
        },
        request_options={
            "headers": loads("""{"x-algolia-api-key":"ALGOLIA_API_KEY"}"""),
        },
    )

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_post5():
    """
    Snippet for the customPost method.

    requestOptions merges headers with default ones
    """
    # >SEPARATOR customPost requestOptions merges headers with default ones
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_post(
        path="test/requestOptions",
        parameters={
            "query": "parameters",
        },
        body={
            "facet": "filters",
        },
        request_options={
            "headers": loads("""{"x-algolia-api-key":"ALGOLIA_API_KEY"}"""),
        },
    )

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_post6():
    """
    Snippet for the customPost method.

    requestOptions queryParameters accepts booleans
    """
    # >SEPARATOR customPost requestOptions queryParameters accepts booleans
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_post(
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

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_post7():
    """
    Snippet for the customPost method.

    requestOptions queryParameters accepts integers
    """
    # >SEPARATOR customPost requestOptions queryParameters accepts integers
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_post(
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

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_post8():
    """
    Snippet for the customPost method.

    requestOptions queryParameters accepts list of string
    """
    # >SEPARATOR customPost requestOptions queryParameters accepts list of string
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_post(
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

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_post9():
    """
    Snippet for the customPost method.

    requestOptions queryParameters accepts list of booleans
    """
    # >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_post(
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

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_post10():
    """
    Snippet for the customPost method.

    requestOptions queryParameters accepts list of integers
    """
    # >SEPARATOR customPost requestOptions queryParameters accepts list of integers
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_post(
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

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_put():
    """
    Snippet for the customPut method.

    allow put method for a custom path with minimal parameters
    """
    # >SEPARATOR customPut allow put method for a custom path with minimal parameters
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_put(
        path="test/minimal",
    )

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_custom_put1():
    """
    Snippet for the customPut method.

    allow put method for a custom path with all parameters
    """
    # >SEPARATOR customPut allow put method for a custom path with all parameters
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.custom_put(
        path="test/all",
        parameters={
            "query": "parameters",
        },
        body={
            "body": "parameters",
        },
    )

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_delete_user_token():
    """
    Snippet for the deleteUserToken method.

    deleteUserToken
    """
    # >SEPARATOR deleteUserToken default
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    client.delete_user_token(
        user_token="test-user-1",
    )

    # >LOG
    # SEPARATOR<


def snippet_for_push_events():
    """
    Snippet for the pushEvents method.

    pushEvents
    """
    # >SEPARATOR pushEvents pushEvents
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.push_events(
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

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_push_events1():
    """
    Snippet for the pushEvents method.

    Many events type
    """
    # >SEPARATOR pushEvents Many events type
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.push_events(
        insights_events={
            "events": [
                {
                    "eventType": "conversion",
                    "eventName": "Product Purchased",
                    "index": "products",
                    "userToken": "user-123456",
                    "authenticatedUserToken": "user-123456",
                    "timestamp": 1742342400000,
                    "objectIDs": [
                        "9780545139700",
                        "9780439784542",
                    ],
                    "queryID": "43b15df305339e827f0ac0bdc5ebcaa7",
                },
                {
                    "eventType": "view",
                    "eventName": "Product Detail Page Viewed",
                    "index": "products",
                    "userToken": "user-123456",
                    "authenticatedUserToken": "user-123456",
                    "timestamp": 1742342400000,
                    "objectIDs": [
                        "9780545139700",
                        "9780439784542",
                    ],
                },
            ],
        },
    )

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_push_events2():
    """
    Snippet for the pushEvents method.

    ConvertedObjectIDsAfterSearch
    """
    # >SEPARATOR pushEvents ConvertedObjectIDsAfterSearch
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.push_events(
        insights_events={
            "events": [
                {
                    "eventType": "conversion",
                    "eventName": "Product Purchased",
                    "index": "products",
                    "userToken": "user-123456",
                    "authenticatedUserToken": "user-123456",
                    "timestamp": 1641290601962,
                    "objectIDs": [
                        "9780545139700",
                        "9780439784542",
                    ],
                    "queryID": "43b15df305339e827f0ac0bdc5ebcaa7",
                },
            ],
        },
    )

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_push_events3():
    """
    Snippet for the pushEvents method.

    ViewedObjectIDs
    """
    # >SEPARATOR pushEvents ViewedObjectIDs
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.push_events(
        insights_events={
            "events": [
                {
                    "eventType": "view",
                    "eventName": "Product Detail Page Viewed",
                    "index": "products",
                    "userToken": "user-123456",
                    "authenticatedUserToken": "user-123456",
                    "timestamp": 1641290601962,
                    "objectIDs": [
                        "9780545139700",
                        "9780439784542",
                    ],
                },
            ],
        },
    )

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_push_events4():
    """
    Snippet for the pushEvents method.

    AddedToCartObjectIDs
    """
    # >SEPARATOR pushEvents AddedToCartObjectIDs
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = client.push_events(
        insights_events={
            "events": [
                {
                    "eventType": "conversion",
                    "eventSubtype": "addToCart",
                    "eventName": "Product Added To Cart",
                    "index": "products",
                    "queryID": "43b15df305339e827f0ac0bdc5ebcaa7",
                    "userToken": "user-123456",
                    "authenticatedUserToken": "user-123456",
                    "timestamp": 1641290601962,
                    "objectIDs": [
                        "9780545139700",
                        "9780439784542",
                    ],
                    "objectData": [
                        {
                            "price": 19.99,
                            "quantity": 10,
                            "discount": 2.5,
                        },
                        {
                            "price": "8$",
                            "quantity": 7,
                            "discount": "30%",
                        },
                    ],
                    "currency": "USD",
                },
            ],
        },
    )

    # >LOG
    # use the class directly
    print(response)
    # SEPARATOR<


def snippet_for_set_client_api_key():
    """
    Snippet for the setClientApiKey method.

    switch API key
    """
    # >SEPARATOR setClientApiKey default
    # Initialize the client
    # In an asynchronous context, you can use InsightsClient instead, which exposes the exact same methods.
    client = InsightsClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    client.set_client_api_key(
        api_key="updated-api-key",
    )

    # >LOG
    # SEPARATOR<
