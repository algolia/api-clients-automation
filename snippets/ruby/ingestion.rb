require 'algolia'

# Snippet for the createAuthentication method.
#
# createAuthenticationOAuth
def snippet_for_create_authentication
  # >SEPARATOR createAuthentication
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
  # SEPARATOR<
end

# Snippet for the createDestination method.
#
# createDestination
def snippet_for_create_destination
  # >SEPARATOR createDestination
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
  # SEPARATOR<
end

# Snippet for the createSource method.
#
# createSource
def snippet_for_create_source
  # >SEPARATOR createSource
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
  # SEPARATOR<
end

# Snippet for the createTask method.
#
# createTaskOnDemand
def snippet_for_create_task
  # >SEPARATOR createTask
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
  # SEPARATOR<
end

# Snippet for the customDelete method.
#
# allow del method for a custom path with minimal parameters
def snippet_for_custom_delete
  # >SEPARATOR customDelete
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.custom_delete("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the customGet method.
#
# allow get method for a custom path with minimal parameters
def snippet_for_custom_get
  # >SEPARATOR customGet
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.custom_get("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the customPost method.
#
# allow post method for a custom path with minimal parameters
def snippet_for_custom_post
  # >SEPARATOR customPost
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.custom_post("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the customPut method.
#
# allow put method for a custom path with minimal parameters
def snippet_for_custom_put
  # >SEPARATOR customPut
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.custom_put("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the deleteAuthentication method.
#
# deleteAuthentication
def snippet_for_delete_authentication
  # >SEPARATOR deleteAuthentication
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.delete_authentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the deleteDestination method.
#
# deleteDestination
def snippet_for_delete_destination
  # >SEPARATOR deleteDestination
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.delete_destination("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the deleteSource method.
#
# deleteSource
def snippet_for_delete_source
  # >SEPARATOR deleteSource
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.delete_source("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the deleteTask method.
#
# deleteTask
def snippet_for_delete_task
  # >SEPARATOR deleteTask
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.delete_task("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the disableTask method.
#
# disableTask
def snippet_for_disable_task
  # >SEPARATOR disableTask
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.disable_task("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the enableTask method.
#
# enable task e2e
def snippet_for_enable_task
  # >SEPARATOR enableTask
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.enable_task("76ab4c2a-ce17-496f-b7a6-506dc59ee498")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getAuthentication method.
#
# getAuthentication
def snippet_for_get_authentication
  # >SEPARATOR getAuthentication
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_authentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getAuthentications method.
#
# getAuthentications
def snippet_for_get_authentications
  # >SEPARATOR getAuthentications
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_authentications

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getDestination method.
#
# getDestination
def snippet_for_get_destination
  # >SEPARATOR getDestination
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_destination("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getDestinations method.
#
# getDestinations
def snippet_for_get_destinations
  # >SEPARATOR getDestinations
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_destinations

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getDockerSourceStreams method.
#
# getDockerSourceStreams
def snippet_for_get_docker_source_streams
  # >SEPARATOR getDockerSourceStreams
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_docker_source_streams("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getEvent method.
#
# getEvent
def snippet_for_get_event
  # >SEPARATOR getEvent
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
  # SEPARATOR<
end

# Snippet for the getEvents method.
#
# getEvents
def snippet_for_get_events
  # >SEPARATOR getEvents
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_events("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getRun method.
#
# getRun
def snippet_for_get_run
  # >SEPARATOR getRun
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_run("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getRuns method.
#
# getRuns
def snippet_for_get_runs
  # >SEPARATOR getRuns
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_runs

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getSource method.
#
# getSource
def snippet_for_get_source
  # >SEPARATOR getSource
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_source("75eeb306-51d3-4e5e-a279-3c92bd8893ac")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getSources method.
#
# getSources
def snippet_for_get_sources
  # >SEPARATOR getSources
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_sources

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getTask method.
#
# getTask
def snippet_for_get_task
  # >SEPARATOR getTask
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_task("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getTasks method.
#
# getTasks
def snippet_for_get_tasks
  # >SEPARATOR getTasks
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_tasks

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the runTask method.
#
# runTask
def snippet_for_run_task
  # >SEPARATOR runTask
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.run_task("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the searchAuthentications method.
#
# searchAuthentications
def snippet_for_search_authentications
  # >SEPARATOR searchAuthentications
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
  # SEPARATOR<
end

# Snippet for the searchDestinations method.
#
# searchDestinations
def snippet_for_search_destinations
  # >SEPARATOR searchDestinations
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
  # SEPARATOR<
end

# Snippet for the searchSources method.
#
# searchSources
def snippet_for_search_sources
  # >SEPARATOR searchSources
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
  # SEPARATOR<
end

# Snippet for the searchTasks method.
#
# searchTasks
def snippet_for_search_tasks
  # >SEPARATOR searchTasks
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.search_tasks(
    TaskSearch.new(
      task_ids: [
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a", "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
      ]
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the triggerDockerSourceDiscover method.
#
# triggerDockerSourceDiscover
def snippet_for_trigger_docker_source_discover
  # >SEPARATOR triggerDockerSourceDiscover
  # Initialize the client
  client = Algolia::IngestionClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.trigger_docker_source_discover("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the updateAuthentication method.
#
# updateAuthentication
def snippet_for_update_authentication
  # >SEPARATOR updateAuthentication
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
  # SEPARATOR<
end

# Snippet for the updateDestination method.
#
# updateDestination
def snippet_for_update_destination
  # >SEPARATOR updateDestination
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
  # SEPARATOR<
end

# Snippet for the updateSource method.
#
# updateSource
def snippet_for_update_source
  # >SEPARATOR updateSource
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
  # SEPARATOR<
end

# Snippet for the updateTask method.
#
# updateTask
def snippet_for_update_task
  # >SEPARATOR updateTask
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
  # SEPARATOR<
end
