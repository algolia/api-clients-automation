# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
# >IMPORT
require 'algolia'
# IMPORT<

# Snippet for the createAuthentication method.
#
# createAuthenticationOAuth
def snippet_for_create_authentication
  # >SEPARATOR createAuthentication default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.create_authentication(
    AuthenticationCreate.new(
      type: 'oauth',
      name: "authName",
      input: AuthOAuth.new(url: "http://test.oauth", client_id: "myID", client_secret: "mySecret")
    )
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the createDestination method.
#
# createDestination
def snippet_for_create_destination
  # >SEPARATOR createDestination default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.create_destination(
    DestinationCreate.new(
      type: 'search',
      name: "destinationName",
      input: DestinationIndexPrefix.new(index_prefix: "prefix_"),
      authentication_id: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the createSource method.
#
# createSource
def snippet_for_create_source
  # >SEPARATOR createSource default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.create_source(
    SourceCreate.new(
      type: 'commercetools',
      name: "sourceName",
      input: SourceCommercetools.new(
        store_keys: ["myStore"],
        locales: ["de"],
        url: "http://commercetools.com",
        project_key: "keyID"
      ),
      authentication_id: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the createTask method.
#
# createTaskOnDemand
def snippet_for_create_task
  # >SEPARATOR createTask default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.create_task(
    TaskCreate.new(
      source_id: "search",
      destination_id: "destinationName",
      trigger: OnDemandTriggerInput.new(type: 'onDemand'),
      action: 'replace'
    )
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the createTransformation method.
#
# createTransformation
def snippet_for_create_transformation
  # >SEPARATOR createTransformation default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.create_transformation(
    TransformationCreate.new(
      code: "foo",
      name: "bar",
      description: "baz"
    )
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the customDelete method.
#
# allow del method for a custom path with minimal parameters
def snippet_for_custom_delete
  # >SEPARATOR customDelete default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.custom_delete("test/minimal")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the customGet method.
#
# allow get method for a custom path with minimal parameters
def snippet_for_custom_get
  # >SEPARATOR customGet default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.custom_get("test/minimal")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the customPost method.
#
# allow post method for a custom path with minimal parameters
def snippet_for_custom_post
  # >SEPARATOR customPost default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.custom_post("test/minimal")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the customPut method.
#
# allow put method for a custom path with minimal parameters
def snippet_for_custom_put
  # >SEPARATOR customPut default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.custom_put("test/minimal")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the deleteAuthentication method.
#
# deleteAuthentication
def snippet_for_delete_authentication
  # >SEPARATOR deleteAuthentication default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.delete_authentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the deleteDestination method.
#
# deleteDestination
def snippet_for_delete_destination
  # >SEPARATOR deleteDestination default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.delete_destination("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the deleteSource method.
#
# deleteSource
def snippet_for_delete_source
  # >SEPARATOR deleteSource default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.delete_source("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the deleteTask method.
#
# deleteTask
def snippet_for_delete_task
  # >SEPARATOR deleteTask default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.delete_task("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the deleteTransformation method.
#
# deleteTransformation
def snippet_for_delete_transformation
  # >SEPARATOR deleteTransformation default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.delete_transformation("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the disableTask method.
#
# disableTask
def snippet_for_disable_task
  # >SEPARATOR disableTask default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.disable_task("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the enableTask method.
#
# enable task e2e
def snippet_for_enable_task
  # >SEPARATOR enableTask default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.enable_task("76ab4c2a-ce17-496f-b7a6-506dc59ee498")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getAuthentication method.
#
# getAuthentication
def snippet_for_get_authentication
  # >SEPARATOR getAuthentication default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.get_authentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getAuthentications method.
#
# getAuthentications
def snippet_for_get_authentications
  # >SEPARATOR getAuthentications default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.get_authentications

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getDestination method.
#
# getDestination
def snippet_for_get_destination
  # >SEPARATOR getDestination default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.get_destination("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getDestinations method.
#
# getDestinations
def snippet_for_get_destinations
  # >SEPARATOR getDestinations default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.get_destinations

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getEvent method.
#
# getEvent
def snippet_for_get_event
  # >SEPARATOR getEvent default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.get_event(
    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    "6c02aeb1-775e-418e-870b-1faccd4b2c0c"
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getEvents method.
#
# getEvents
def snippet_for_get_events
  # >SEPARATOR getEvents default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.get_events("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getRun method.
#
# getRun
def snippet_for_get_run
  # >SEPARATOR getRun default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.get_run("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getRuns method.
#
# getRuns
def snippet_for_get_runs
  # >SEPARATOR getRuns default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.get_runs

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getSource method.
#
# getSource
def snippet_for_get_source
  # >SEPARATOR getSource default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.get_source("75eeb306-51d3-4e5e-a279-3c92bd8893ac")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getSources method.
#
# getSources
def snippet_for_get_sources
  # >SEPARATOR getSources default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.get_sources

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getTask method.
#
# getTask
def snippet_for_get_task
  # >SEPARATOR getTask default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.get_task("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getTasks method.
#
# getTasks
def snippet_for_get_tasks
  # >SEPARATOR getTasks default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.get_tasks

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getTransformation method.
#
# getTransformation
def snippet_for_get_transformation
  # >SEPARATOR getTransformation default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.get_transformation("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getTransformations method.
#
# getTransformations
def snippet_for_get_transformations
  # >SEPARATOR getTransformations default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.get_transformations

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the runTask method.
#
# runTask
def snippet_for_run_task
  # >SEPARATOR runTask default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.run_task("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the searchAuthentications method.
#
# searchAuthentications
def snippet_for_search_authentications
  # >SEPARATOR searchAuthentications default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.search_authentications(
    AuthenticationSearch.new(
      authentication_ids: [
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
      ]
    )
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the searchDestinations method.
#
# searchDestinations
def snippet_for_search_destinations
  # >SEPARATOR searchDestinations default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.search_destinations(
    DestinationSearch.new(
      destination_ids: [
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
      ]
    )
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the searchSources method.
#
# searchSources
def snippet_for_search_sources
  # >SEPARATOR searchSources default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.search_sources(
    SourceSearch.new(
      source_ids: [
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
      ]
    )
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the searchTasks method.
#
# searchTasks
def snippet_for_search_tasks
  # >SEPARATOR searchTasks default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.search_tasks(
    TaskSearch.new(
      task_ids: [
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a", "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
      ]
    )
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the searchTransformations method.
#
# searchTransformations
def snippet_for_search_transformations
  # >SEPARATOR searchTransformations default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.search_transformations(
    TransformationSearch.new(
      transformations_ids: [
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a", "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
      ]
    )
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the triggerDockerSourceDiscover method.
#
# triggerDockerSourceDiscover
def snippet_for_trigger_docker_source_discover
  # >SEPARATOR triggerDockerSourceDiscover default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.trigger_docker_source_discover("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the tryTransformations method.
#
# tryTransformations
def snippet_for_try_transformations
  # >SEPARATOR tryTransformations default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.try_transformations(
    TransformationTry.new(
      code: "foo",
      sample_record: { bar: "baz" }
    )
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the updateAuthentication method.
#
# updateAuthentication
def snippet_for_update_authentication
  # >SEPARATOR updateAuthentication default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.update_authentication(
    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    AuthenticationUpdate.new(name: "newName")
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the updateDestination method.
#
# updateDestination
def snippet_for_update_destination
  # >SEPARATOR updateDestination default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.update_destination(
    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    DestinationUpdate.new(name: "newName")
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the updateSource method.
#
# updateSource
def snippet_for_update_source
  # >SEPARATOR updateSource default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.update_source(
    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    SourceUpdate.new(name: "newName")
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the updateTask method.
#
# updateTask
def snippet_for_update_task
  # >SEPARATOR updateTask default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.update_task(
    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    TaskUpdate.new(enabled: false)
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the updateTransformation method.
#
# updateTransformation
def snippet_for_update_transformation
  # >SEPARATOR updateTransformation default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.update_transformation(
    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    TransformationCreate.new(code: "foo", name: "bar", description: "baz")
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the validateSource method.
#
# validateSource
def snippet_for_validate_source
  # >SEPARATOR validateSource default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.validate_source(
    SourceCreate.new(
      type: 'commercetools',
      name: "sourceName",
      input: SourceCommercetools.new(
        store_keys: ["myStore"],
        locales: ["de"],
        url: "http://commercetools.com",
        project_key: "keyID"
      ),
      authentication_id: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the validateSourceBeforeUpdate method.
#
# validateSourceBeforeUpdate
def snippet_for_validate_source_before_update
  # >SEPARATOR validateSourceBeforeUpdate default
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  response = client.validate_source_before_update(
    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    SourceUpdate.new(name: "newName")
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end
