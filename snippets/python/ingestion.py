# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
# >IMPORT
from algoliasearch.ingestion.client import IngestionClient
# IMPORT<


async def snippet_for_create_authentication():
    """
    Snippet for the createAuthentication method.

    createAuthenticationOAuth
    """
    # >SEPARATOR createAuthentication default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.create_authentication(
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
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_create_destination():
    """
    Snippet for the createDestination method.

    createDestination
    """
    # >SEPARATOR createDestination default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.create_destination(
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
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_create_source():
    """
    Snippet for the createSource method.

    createSource
    """
    # >SEPARATOR createSource default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.create_source(
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
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_create_task():
    """
    Snippet for the createTask method.

    task without cron
    """
    # >SEPARATOR createTask default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.create_task(
        task_create={
            "sourceID": "search",
            "destinationID": "destinationName",
            "action": "replace",
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_create_task_v1():
    """
    Snippet for the createTaskV1 method.

    createTaskOnDemand
    """
    # >SEPARATOR createTaskV1 default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.create_task_v1(
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
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_create_transformation():
    """
    Snippet for the createTransformation method.

    createTransformation
    """
    # >SEPARATOR createTransformation default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.create_transformation(
        transformation_create={
            "code": "foo",
            "name": "bar",
            "description": "baz",
        },
    )

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
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.custom_delete(
        path="test/minimal",
    )

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
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.custom_get(
        path="test/minimal",
    )

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
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.custom_post(
        path="test/minimal",
    )

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
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.custom_put(
        path="test/minimal",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_delete_authentication():
    """
    Snippet for the deleteAuthentication method.

    deleteAuthentication
    """
    # >SEPARATOR deleteAuthentication default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.delete_authentication(
        authentication_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_delete_destination():
    """
    Snippet for the deleteDestination method.

    deleteDestination
    """
    # >SEPARATOR deleteDestination default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.delete_destination(
        destination_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_delete_source():
    """
    Snippet for the deleteSource method.

    deleteSource
    """
    # >SEPARATOR deleteSource default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.delete_source(
        source_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_delete_task():
    """
    Snippet for the deleteTask method.

    deleteTask
    """
    # >SEPARATOR deleteTask default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.delete_task(
        task_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_delete_task_v1():
    """
    Snippet for the deleteTaskV1 method.

    deleteTaskV1
    """
    # >SEPARATOR deleteTaskV1 default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.delete_task_v1(
        task_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_delete_transformation():
    """
    Snippet for the deleteTransformation method.

    deleteTransformation
    """
    # >SEPARATOR deleteTransformation default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.delete_transformation(
        transformation_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_disable_task():
    """
    Snippet for the disableTask method.

    disableTask
    """
    # >SEPARATOR disableTask default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.disable_task(
        task_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_disable_task_v1():
    """
    Snippet for the disableTaskV1 method.

    disableTaskV1
    """
    # >SEPARATOR disableTaskV1 default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.disable_task_v1(
        task_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_enable_task():
    """
    Snippet for the enableTask method.

    enableTask
    """
    # >SEPARATOR enableTask default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.enable_task(
        task_id="76ab4c2a-ce17-496f-b7a6-506dc59ee498",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_enable_task_v1():
    """
    Snippet for the enableTaskV1 method.

    enableTaskV1
    """
    # >SEPARATOR enableTaskV1 default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.enable_task_v1(
        task_id="76ab4c2a-ce17-496f-b7a6-506dc59ee498",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_get_authentication():
    """
    Snippet for the getAuthentication method.

    getAuthentication
    """
    # >SEPARATOR getAuthentication default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.get_authentication(
        authentication_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_get_destination():
    """
    Snippet for the getDestination method.

    getDestination
    """
    # >SEPARATOR getDestination default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.get_destination(
        destination_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_get_event():
    """
    Snippet for the getEvent method.

    getEvent
    """
    # >SEPARATOR getEvent default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.get_event(
        run_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        event_id="6c02aeb1-775e-418e-870b-1faccd4b2c0c",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_get_run():
    """
    Snippet for the getRun method.

    getRun
    """
    # >SEPARATOR getRun default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.get_run(
        run_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_get_source():
    """
    Snippet for the getSource method.

    getSource
    """
    # >SEPARATOR getSource default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.get_source(
        source_id="75eeb306-51d3-4e5e-a279-3c92bd8893ac",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_get_task():
    """
    Snippet for the getTask method.

    getTask
    """
    # >SEPARATOR getTask default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.get_task(
        task_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_get_task_v1():
    """
    Snippet for the getTaskV1 method.

    getTaskV1
    """
    # >SEPARATOR getTaskV1 default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.get_task_v1(
        task_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_get_transformation():
    """
    Snippet for the getTransformation method.

    getTransformation
    """
    # >SEPARATOR getTransformation default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.get_transformation(
        transformation_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_list_authentications():
    """
    Snippet for the listAuthentications method.

    getAuthentications
    """
    # >SEPARATOR listAuthentications default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.list_authentications()

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_list_destinations():
    """
    Snippet for the listDestinations method.

    getDestinations
    """
    # >SEPARATOR listDestinations default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.list_destinations()

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_list_events():
    """
    Snippet for the listEvents method.

    getEvents
    """
    # >SEPARATOR listEvents default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.list_events(
        run_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_list_runs():
    """
    Snippet for the listRuns method.

    getRuns
    """
    # >SEPARATOR listRuns default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.list_runs()

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_list_sources():
    """
    Snippet for the listSources method.

    getSources
    """
    # >SEPARATOR listSources default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.list_sources()

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_list_tasks():
    """
    Snippet for the listTasks method.

    listTasks
    """
    # >SEPARATOR listTasks default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.list_tasks()

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_list_tasks_v1():
    """
    Snippet for the listTasksV1 method.

    listTasksV1
    """
    # >SEPARATOR listTasksV1 default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.list_tasks_v1()

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_list_transformations():
    """
    Snippet for the listTransformations method.

    getTransformations
    """
    # >SEPARATOR listTransformations default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.list_transformations()

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_push_task():
    """
    Snippet for the pushTask method.

    pushTask
    """
    # >SEPARATOR pushTask default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.push_task(
        task_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        batch_write_params={
            "requests": [
                {
                    "action": "addObject",
                    "body": {
                        "key": "bar",
                        "foo": "1",
                    },
                },
                {
                    "action": "addObject",
                    "body": {
                        "key": "baz",
                        "foo": "2",
                    },
                },
            ],
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_run_source():
    """
    Snippet for the runSource method.

    runSource
    """
    # >SEPARATOR runSource default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.run_source(
        source_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        run_source_payload={
            "indexToInclude": [
                "products_us",
                "products eu",
            ],
            "entityIDs": [
                "1234",
                "5678",
            ],
            "entityType": "product",
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_run_task():
    """
    Snippet for the runTask method.

    runTask
    """
    # >SEPARATOR runTask default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.run_task(
        task_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_run_task_v1():
    """
    Snippet for the runTaskV1 method.

    runTaskV1
    """
    # >SEPARATOR runTaskV1 default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.run_task_v1(
        task_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_search_authentications():
    """
    Snippet for the searchAuthentications method.

    searchAuthentications
    """
    # >SEPARATOR searchAuthentications default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.search_authentications(
        authentication_search={
            "authenticationIDs": [
                "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            ],
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_search_destinations():
    """
    Snippet for the searchDestinations method.

    searchDestinations
    """
    # >SEPARATOR searchDestinations default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.search_destinations(
        destination_search={
            "destinationIDs": [
                "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            ],
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_search_sources():
    """
    Snippet for the searchSources method.

    searchSources
    """
    # >SEPARATOR searchSources default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.search_sources(
        source_search={
            "sourceIDs": [
                "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            ],
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_search_tasks():
    """
    Snippet for the searchTasks method.

    searchTasks
    """
    # >SEPARATOR searchTasks default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.search_tasks(
        task_search={
            "taskIDs": [
                "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
                "76ab4c2a-ce17-496f-b7a6-506dc59ee498",
            ],
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_search_tasks_v1():
    """
    Snippet for the searchTasksV1 method.

    searchTasksV1
    """
    # >SEPARATOR searchTasksV1 default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.search_tasks_v1(
        task_search={
            "taskIDs": [
                "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
                "76ab4c2a-ce17-496f-b7a6-506dc59ee498",
            ],
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_search_transformations():
    """
    Snippet for the searchTransformations method.

    searchTransformations
    """
    # >SEPARATOR searchTransformations default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.search_transformations(
        transformation_search={
            "transformationsIDs": [
                "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
                "76ab4c2a-ce17-496f-b7a6-506dc59ee498",
            ],
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_trigger_docker_source_discover():
    """
    Snippet for the triggerDockerSourceDiscover method.

    triggerDockerSourceDiscover
    """
    # >SEPARATOR triggerDockerSourceDiscover default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.trigger_docker_source_discover(
        source_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_try_transformations():
    """
    Snippet for the tryTransformations method.

    tryTransformations
    """
    # >SEPARATOR tryTransformations default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.try_transformations(
        transformation_try={
            "code": "foo",
            "sampleRecord": {
                "bar": "baz",
            },
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_update_authentication():
    """
    Snippet for the updateAuthentication method.

    updateAuthentication
    """
    # >SEPARATOR updateAuthentication default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.update_authentication(
        authentication_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        authentication_update={
            "name": "newName",
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_update_destination():
    """
    Snippet for the updateDestination method.

    updateDestination
    """
    # >SEPARATOR updateDestination default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.update_destination(
        destination_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        destination_update={
            "name": "newName",
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_update_source():
    """
    Snippet for the updateSource method.

    updateSource
    """
    # >SEPARATOR updateSource default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.update_source(
        source_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        source_update={
            "name": "newName",
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_update_task():
    """
    Snippet for the updateTask method.

    updateTask
    """
    # >SEPARATOR updateTask default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.update_task(
        task_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        task_update={
            "enabled": False,
            "cron": "* * * * *",
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_update_task_v1():
    """
    Snippet for the updateTaskV1 method.

    updateTaskV1
    """
    # >SEPARATOR updateTaskV1 default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.update_task_v1(
        task_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        task_update={
            "enabled": False,
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_update_transformation():
    """
    Snippet for the updateTransformation method.

    updateTransformation
    """
    # >SEPARATOR updateTransformation default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.update_transformation(
        transformation_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        transformation_create={
            "code": "foo",
            "name": "bar",
            "description": "baz",
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_validate_source():
    """
    Snippet for the validateSource method.

    validateSource
    """
    # >SEPARATOR validateSource default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.validate_source(
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
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<


async def snippet_for_validate_source_before_update():
    """
    Snippet for the validateSourceBeforeUpdate method.

    validateSourceBeforeUpdate
    """
    # >SEPARATOR validateSourceBeforeUpdate default
    # Initialize the client
    _client = IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")

    # Call the API
    response = await _client.validate_source_before_update(
        source_id="6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        source_update={
            "name": "newName",
        },
    )

    # use the class directly
    print(response)

    # print the JSON response
    print(response.to_json())
    # SEPARATOR<
