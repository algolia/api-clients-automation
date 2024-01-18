require 'algolia'

# Snippet for the createAuthentication method.
#
# createAuthenticationOAuth
def snippet_for_create_authentication
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.create_authentication(
    AuthenticationCreate.new(
      type: 'oauth',
      name: "authName",
      input: AuthOAuth.new(url: "http://test.oauth", client_id: "myID", client_secret: "mySecret")
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the createDestination method.
#
# createDestination
def snippet_for_create_destination
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.create_destination(
    DestinationCreate.new(
      type: 'search',
      name: "destinationName",
      input: DestinationIndexPrefix.new(index_prefix: "prefix_"),
      authentication_id: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the createSource method.
#
# createSource
def snippet_for_create_source
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.create_source(
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
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the createTask method.
#
# createTaskOnDemand
def snippet_for_create_task
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.create_task(
    TaskCreate.new(
      source_id: "search",
      destination_id: "destinationName",
      trigger: OnDemandTriggerInput.new(type: 'onDemand'),
      action: 'replace'
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the customDelete method.
#
# allow del method for a custom path with minimal parameters
def snippet_for_custom_delete
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.custom_delete("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the customGet method.
#
# allow get method for a custom path with minimal parameters
def snippet_for_custom_get
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.custom_get("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the customPost method.
#
# allow post method for a custom path with minimal parameters
def snippet_for_custom_post
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.custom_post("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the customPut method.
#
# allow put method for a custom path with minimal parameters
def snippet_for_custom_put
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.custom_put("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the deleteAuthentication method.
#
# deleteAuthentication
def snippet_for_delete_authentication
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.delete_authentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the deleteDestination method.
#
# deleteDestination
def snippet_for_delete_destination
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.delete_destination("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the deleteSource method.
#
# deleteSource
def snippet_for_delete_source
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.delete_source("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the deleteTask method.
#
# deleteTask
def snippet_for_delete_task
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.delete_task("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the disableTask method.
#
# disableTask
def snippet_for_disable_task
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.disable_task("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the enableTask method.
#
# enableTask
def snippet_for_enable_task
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.enable_task("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getAuthentication method.
#
# getAuthentication
def snippet_for_get_authentication
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_authentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getAuthentications method.
#
# getAuthentications
def snippet_for_get_authentications
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_authentications

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getDestination method.
#
# getDestination
def snippet_for_get_destination
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_destination("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getDestinations method.
#
# getDestinations
def snippet_for_get_destinations
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_destinations

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getDockerSourceStreams method.
#
# getDockerSourceStreams
def snippet_for_get_docker_source_streams
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_docker_source_streams("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getEvent method.
#
# getEvent
def snippet_for_get_event
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_event(
    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    "6c02aeb1-775e-418e-870b-1faccd4b2c0c"
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getEvents method.
#
# getEvents
def snippet_for_get_events
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_events("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getRun method.
#
# getRun
def snippet_for_get_run
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_run("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getRuns method.
#
# getRuns
def snippet_for_get_runs
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_runs

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getSource method.
#
# getSource
def snippet_for_get_source
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_source("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getSources method.
#
# getSources
def snippet_for_get_sources
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_sources

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getTask method.
#
# getTask
def snippet_for_get_task
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_task("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getTasks method.
#
# getTasks
def snippet_for_get_tasks
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_tasks

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the runTask method.
#
# runTask
def snippet_for_run_task
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.run_task("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the searchAuthentications method.
#
# searchAuthentications
def snippet_for_search_authentications
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.search_authentications(
    AuthenticationSearch.new(
      authentication_ids: [
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
      ]
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the searchDestinations method.
#
# searchDestinations
def snippet_for_search_destinations
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.search_destinations(
    DestinationSearch.new(
      destination_ids: [
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
      ]
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the searchSources method.
#
# searchSources
def snippet_for_search_sources
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.search_sources(
    SourceSearch.new(
      source_ids: [
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
      ]
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the searchTasks method.
#
# searchTasks
def snippet_for_search_tasks
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.search_tasks(
    TaskSearch.new(
      task_ids: [
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
      ]
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the triggerDockerSourceDiscover method.
#
# triggerDockerSourceDiscover
def snippet_for_trigger_docker_source_discover
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.trigger_docker_source_discover("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the updateAuthentication method.
#
# updateAuthentication
def snippet_for_update_authentication
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.update_authentication(
    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    AuthenticationUpdate.new(name: "newName")
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the updateDestination method.
#
# updateDestination
def snippet_for_update_destination
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.update_destination(
    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    DestinationUpdate.new(name: "newName")
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the updateSource method.
#
# updateSource
def snippet_for_update_source
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.update_source(
    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    SourceUpdate.new(name: "newName")
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the updateTask method.
#
# updateTask
def snippet_for_update_task
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.update_task(
    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    TaskUpdate.new(enabled: false)
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end
