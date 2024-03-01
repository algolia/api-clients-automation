from algoliasearch.query_suggestions.client import QuerySuggestionsClient


async def snippet_for_create_config():
    """
    Snippet for the createConfig method.

    createConfig0
    """
    # >SEPARATOR createConfig
    # Initialize the client
    _client = QuerySuggestionsClient(
        "YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"
    )

    # Call the API
    resp = await _client.create_config(
        query_suggestions_configuration_with_index={
            "indexName": "theIndexName",
            "sourceIndices": [
                {
                    "indexName": "testIndex",
                    "facets": [
                        {
                            "attribute": "test",
                        },
                    ],
                    "generate": [
                        [
                            "facetA",
                            "facetB",
                        ],
                        [
                            "facetC",
                        ],
                    ],
                },
            ],
            "languages": [
                "french",
            ],
            "exclude": [
                "test",
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
    _client = QuerySuggestionsClient(
        "YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"
    )

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
    _client = QuerySuggestionsClient(
        "YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"
    )

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
    _client = QuerySuggestionsClient(
        "YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"
    )

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
    _client = QuerySuggestionsClient(
        "YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"
    )

    # Call the API
    resp = await _client.custom_put(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_delete_config():
    """
    Snippet for the deleteConfig method.

    deleteConfig0
    """
    # >SEPARATOR deleteConfig
    # Initialize the client
    _client = QuerySuggestionsClient(
        "YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"
    )

    # Call the API
    resp = await _client.delete_config(
        index_name="theIndexName",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_all_configs():
    """
    Snippet for the getAllConfigs method.

    getAllConfigs0
    """
    # >SEPARATOR getAllConfigs
    # Initialize the client
    _client = QuerySuggestionsClient(
        "YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"
    )

    # Call the API
    resp = await _client.get_all_configs()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_config():
    """
    Snippet for the getConfig method.

    Retrieve QS config e2e
    """
    # >SEPARATOR getConfig
    # Initialize the client
    _client = QuerySuggestionsClient(
        "YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"
    )

    # Call the API
    resp = await _client.get_config(
        index_name="cts_e2e_browse_query_suggestions",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_config_status():
    """
    Snippet for the getConfigStatus method.

    getConfigStatus0
    """
    # >SEPARATOR getConfigStatus
    # Initialize the client
    _client = QuerySuggestionsClient(
        "YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"
    )

    # Call the API
    resp = await _client.get_config_status(
        index_name="theIndexName",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_log_file():
    """
    Snippet for the getLogFile method.

    getLogFile0
    """
    # >SEPARATOR getLogFile
    # Initialize the client
    _client = QuerySuggestionsClient(
        "YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"
    )

    # Call the API
    resp = await _client.get_log_file(
        index_name="theIndexName",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_update_config():
    """
    Snippet for the updateConfig method.

    updateConfig0
    """
    # >SEPARATOR updateConfig
    # Initialize the client
    _client = QuerySuggestionsClient(
        "YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"
    )

    # Call the API
    resp = await _client.update_config(
        index_name="theIndexName",
        query_suggestions_configuration={
            "sourceIndices": [
                {
                    "indexName": "testIndex",
                    "facets": [
                        {
                            "attribute": "test",
                        },
                    ],
                    "generate": [
                        [
                            "facetA",
                            "facetB",
                        ],
                        [
                            "facetC",
                        ],
                    ],
                },
            ],
            "languages": [
                "french",
            ],
            "exclude": [
                "test",
            ],
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<
