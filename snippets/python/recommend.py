from algoliasearch.recommend.client import RecommendClient


async def snippet_for_custom_delete():
    """
    Snippet for the customDelete method.

    allow del method for a custom path with minimal parameters
    """
    # >SEPARATOR customDelete
    # Initialize the client
    _client = RecommendClient("YOUR_APP_ID", "YOUR_API_KEY")

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
    _client = RecommendClient("YOUR_APP_ID", "YOUR_API_KEY")

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
    _client = RecommendClient("YOUR_APP_ID", "YOUR_API_KEY")

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
    _client = RecommendClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.custom_put(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_delete_recommend_rule():
    """
    Snippet for the deleteRecommendRule method.

    deleteRecommendRule0
    """
    # >SEPARATOR deleteRecommendRule
    # Initialize the client
    _client = RecommendClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.delete_recommend_rule(
        index_name="indexName",
        model="related-products",
        object_id="objectID",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_recommend_rule():
    """
    Snippet for the getRecommendRule method.

    getRecommendRule0
    """
    # >SEPARATOR getRecommendRule
    # Initialize the client
    _client = RecommendClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_recommend_rule(
        index_name="indexName",
        model="related-products",
        object_id="objectID",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_recommend_status():
    """
    Snippet for the getRecommendStatus method.

    getRecommendStatus0
    """
    # >SEPARATOR getRecommendStatus
    # Initialize the client
    _client = RecommendClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_recommend_status(
        index_name="indexName",
        model="related-products",
        task_id=12345,
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_recommendations():
    """
    Snippet for the getRecommendations method.

    get recommendations for recommend model with minimal parameters
    """
    # >SEPARATOR getRecommendations
    # Initialize the client
    _client = RecommendClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_recommendations(
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

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_search_recommend_rules():
    """
    Snippet for the searchRecommendRules method.

    searchRecommendRules0
    """
    # >SEPARATOR searchRecommendRules
    # Initialize the client
    _client = RecommendClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.search_recommend_rules(
        index_name="indexName",
        model="related-products",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<
