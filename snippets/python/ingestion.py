from algoliasearch.ingestion.client import IngestionClient


async def snippet_for_create_authentication():
    """
    Snippet for the createAuthentication method.

    createAuthenticationOAuth
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.create_authentication(
        authentication_create={
            "type": "oauth",
            "name": "authName",
            "input": {
                "url": "http://test.oauth",
                "client_id": "myID",
                "client_secret": "mySecret",
            },
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_create_destination():
    """
    Snippet for the createDestination method.

    createDestination
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.create_destination(
        destination_create={
            "type": "search",
            "name": "destinationName",
            "input": {
                "indexPrefix": "prefix_",
            },
            "authenticationID": "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_create_source():
    """
    Snippet for the createSource method.

    createSource
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.create_source(
        source_create={
            "type": "commercetools",
            "name": "sourceName",
            "input": {
                "storeKeys": [
                    "myStore",
                ],
                "locales": [
                    "de",
                ],
                "url": "http://commercetools.com",
                "projectKey": "keyID",
            },
            "authenticationID": "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_create_task():
    """
    Snippet for the createTask method.

    createTaskOnDemand
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.create_task(
        task_create={
            "sourceID": "search",
            "destinationID": "destinationName",
            "trigger": {
                "type": "onDemand",
            },
            "action": "replace",
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_custom_delete():
    """
    Snippet for the customDelete method.

    allow del method for a custom path with minimal parameters
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

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
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

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
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

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
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.custom_put(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_delete_authentication():
    """
    Snippet for the deleteAuthentication method.

    deleteAuthentication
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.delete_authentication(
        authentication_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_delete_destination():
    """
    Snippet for the deleteDestination method.

    deleteDestination
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.delete_destination(
        destination_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_delete_source():
    """
    Snippet for the deleteSource method.

    deleteSource
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.delete_source(
        source_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_delete_task():
    """
    Snippet for the deleteTask method.

    deleteTask
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.delete_task(
        task_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_disable_task():
    """
    Snippet for the disableTask method.

    disableTask
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.disable_task(
        task_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_enable_task():
    """
    Snippet for the enableTask method.

    enable task e2e
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.enable_task(
        task_id="76ab4c2a-ce17-496f-b7a6-506dc59ee498",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_authentication():
    """
    Snippet for the getAuthentication method.

    getAuthentication
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_authentication(
        authentication_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_authentications():
    """
    Snippet for the getAuthentications method.

    getAuthentications
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_authentications()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_destination():
    """
    Snippet for the getDestination method.

    getDestination
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_destination(
        destination_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_destinations():
    """
    Snippet for the getDestinations method.

    getDestinations
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_destinations()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_docker_source_streams():
    """
    Snippet for the getDockerSourceStreams method.

    getDockerSourceStreams
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_docker_source_streams(
        source_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_event():
    """
    Snippet for the getEvent method.

    getEvent
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_event(
        run_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        event_id="6c02aeb1-775e-418e-870b-1faccd4b2c0c",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_events():
    """
    Snippet for the getEvents method.

    getEvents
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_events(
        run_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_run():
    """
    Snippet for the getRun method.

    getRun
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_run(
        run_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_runs():
    """
    Snippet for the getRuns method.

    getRuns
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_runs()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_source():
    """
    Snippet for the getSource method.

    getSource
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_source(
        source_id="75eeb306-51d3-4e5e-a279-3c92bd8893ac",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_sources():
    """
    Snippet for the getSources method.

    getSources
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_sources()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_task():
    """
    Snippet for the getTask method.

    getTask
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_task(
        task_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_get_tasks():
    """
    Snippet for the getTasks method.

    getTasks
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.get_tasks()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_run_task():
    """
    Snippet for the runTask method.

    runTask
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.run_task(
        task_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_search_authentications():
    """
    Snippet for the searchAuthentications method.

    searchAuthentications
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.search_authentications(
        authentication_search={
            "authenticationIDs": [
                "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            ],
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_search_destinations():
    """
    Snippet for the searchDestinations method.

    searchDestinations
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.search_destinations(
        destination_search={
            "destinationIDs": [
                "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            ],
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_search_sources():
    """
    Snippet for the searchSources method.

    searchSources
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.search_sources(
        source_search={
            "sourceIDs": [
                "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            ],
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_search_tasks():
    """
    Snippet for the searchTasks method.

    searchTasks
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.search_tasks(
        task_search={
            "taskIDs": [
                "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
                "76ab4c2a-ce17-496f-b7a6-506dc59ee498",
            ],
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_trigger_docker_source_discover():
    """
    Snippet for the triggerDockerSourceDiscover method.

    triggerDockerSourceDiscover
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.trigger_docker_source_discover(
        source_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_update_authentication():
    """
    Snippet for the updateAuthentication method.

    updateAuthentication
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.update_authentication(
        authentication_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        authentication_update={
            "name": "newName",
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_update_destination():
    """
    Snippet for the updateDestination method.

    updateDestination
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.update_destination(
        destination_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        destination_update={
            "name": "newName",
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_update_source():
    """
    Snippet for the updateSource method.

    updateSource
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.update_source(
        source_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        source_update={
            "name": "newName",
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())


async def snippet_for_update_task():
    """
    Snippet for the updateTask method.

    updateTask
    """
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    resp = await _client.update_task(
        task_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        task_update={
            "enabled": False,
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
