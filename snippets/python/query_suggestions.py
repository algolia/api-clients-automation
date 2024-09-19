# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
# >IMPORT
from algoliasearch.query_suggestions.client import QuerySuggestionsClient
# IMPORT<


async def snippet_for_create_config():
    """
    Snippet for the createConfig method.

    createConfig
    """
    # >SEPARATOR createConfig default
    # Initialize the client
    client = QuerySuggestionsClient(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = await client.create_config(
        configuration_with_index={
            "indexName": "<YOUR_INDEX_NAME>",
            "sourceIndices": [
                {
                    "indexName": "<YOUR_INDEX_NAME>",
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

    print(response)

    # Skip deserialization
    raw_response = await client.create_config_with_http_info(
        configuration_with_index={
            "indexName": "<YOUR_INDEX_NAME>",
            "sourceIndices": [
                {
                    "indexName": "<YOUR_INDEX_NAME>",
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

    print(raw_response.raw_data)

    # >LOG
    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_custom_delete():
    """
    Snippet for the customDelete method.

    allow del method for a custom path with minimal parameters
    """
    # >SEPARATOR customDelete default
    # Initialize the client
    client = QuerySuggestionsClient(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = await client.custom_delete(
        path="test/minimal",
    )

    print(response)

    # Skip deserialization
    raw_response = await client.custom_delete_with_http_info(
        path="test/minimal",
    )

    print(raw_response.raw_data)

    # >LOG
    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_custom_get():
    """
    Snippet for the customGet method.

    allow get method for a custom path with minimal parameters
    """
    # >SEPARATOR customGet default
    # Initialize the client
    client = QuerySuggestionsClient(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = await client.custom_get(
        path="test/minimal",
    )

    print(response)

    # Skip deserialization
    raw_response = await client.custom_get_with_http_info(
        path="test/minimal",
    )

    print(raw_response.raw_data)

    # >LOG
    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_custom_post():
    """
    Snippet for the customPost method.

    allow post method for a custom path with minimal parameters
    """
    # >SEPARATOR customPost default
    # Initialize the client
    client = QuerySuggestionsClient(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = await client.custom_post(
        path="test/minimal",
    )

    print(response)

    # Skip deserialization
    raw_response = await client.custom_post_with_http_info(
        path="test/minimal",
    )

    print(raw_response.raw_data)

    # >LOG
    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_custom_put():
    """
    Snippet for the customPut method.

    allow put method for a custom path with minimal parameters
    """
    # >SEPARATOR customPut default
    # Initialize the client
    client = QuerySuggestionsClient(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = await client.custom_put(
        path="test/minimal",
    )

    print(response)

    # Skip deserialization
    raw_response = await client.custom_put_with_http_info(
        path="test/minimal",
    )

    print(raw_response.raw_data)

    # >LOG
    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_delete_config():
    """
    Snippet for the deleteConfig method.

    deleteConfig
    """
    # >SEPARATOR deleteConfig default
    # Initialize the client
    client = QuerySuggestionsClient(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = await client.delete_config(
        index_name="<YOUR_INDEX_NAME>",
    )

    print(response)

    # Skip deserialization
    raw_response = await client.delete_config_with_http_info(
        index_name="<YOUR_INDEX_NAME>",
    )

    print(raw_response.raw_data)

    # >LOG
    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_get_all_configs():
    """
    Snippet for the getAllConfigs method.

    getAllConfigs
    """
    # >SEPARATOR getAllConfigs default
    # Initialize the client
    client = QuerySuggestionsClient(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = await client.get_all_configs()

    print(response)

    # Skip deserialization
    raw_response = await client.get_all_configs_with_http_info()

    print(raw_response.raw_data)

    # >LOG
    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_get_config():
    """
    Snippet for the getConfig method.

    Retrieve QS config e2e
    """
    # >SEPARATOR getConfig default
    # Initialize the client
    client = QuerySuggestionsClient(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = await client.get_config(
        index_name="<YOUR_INDEX_NAME>",
    )

    print(response)

    # Skip deserialization
    raw_response = await client.get_config_with_http_info(
        index_name="<YOUR_INDEX_NAME>",
    )

    print(raw_response.raw_data)

    # >LOG
    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_get_config_status():
    """
    Snippet for the getConfigStatus method.

    getConfigStatus
    """
    # >SEPARATOR getConfigStatus default
    # Initialize the client
    client = QuerySuggestionsClient(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = await client.get_config_status(
        index_name="<YOUR_INDEX_NAME>",
    )

    print(response)

    # Skip deserialization
    raw_response = await client.get_config_status_with_http_info(
        index_name="<YOUR_INDEX_NAME>",
    )

    print(raw_response.raw_data)

    # >LOG
    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_get_log_file():
    """
    Snippet for the getLogFile method.

    getLogFile
    """
    # >SEPARATOR getLogFile default
    # Initialize the client
    client = QuerySuggestionsClient(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = await client.get_log_file(
        index_name="<YOUR_INDEX_NAME>",
    )

    print(response)

    # Skip deserialization
    raw_response = await client.get_log_file_with_http_info(
        index_name="<YOUR_INDEX_NAME>",
    )

    print(raw_response.raw_data)

    # >LOG
    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_set_client_api_key():
    """
    Snippet for the setClientApiKey method.

    switch API key
    """
    # >SEPARATOR setClientApiKey default
    # Initialize the client
    client = QuerySuggestionsClient(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    client.set_client_api_key(
        api_key="updated-api-key",
    )

    # Skip deserialization
    client.set_client_api_key_with_http_info(
        api_key="updated-api-key",
    )

    # >LOG
    # SEPARATOR<


async def snippet_for_update_config():
    """
    Snippet for the updateConfig method.

    updateConfig
    """
    # >SEPARATOR updateConfig default
    # Initialize the client
    client = QuerySuggestionsClient(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    # Call the API
    response = await client.update_config(
        index_name="<YOUR_INDEX_NAME>",
        configuration={
            "sourceIndices": [
                {
                    "indexName": "<YOUR_INDEX_NAME>",
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

    print(response)

    # Skip deserialization
    raw_response = await client.update_config_with_http_info(
        index_name="<YOUR_INDEX_NAME>",
        configuration={
            "sourceIndices": [
                {
                    "indexName": "<YOUR_INDEX_NAME>",
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

    print(raw_response.raw_data)

    # >LOG
    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<
