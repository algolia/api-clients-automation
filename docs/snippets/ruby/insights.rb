# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
# >IMPORT
require "algolia"

# IMPORT<

# Snippet for the customDelete method.
#
# allow del method for a custom path with minimal parameters
def snippet_for_custom_delete
  # >SEPARATOR customDelete default
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_delete("test/minimal")

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the customGet method.
#
# allow get method for a custom path with minimal parameters
def snippet_for_custom_get
  # >SEPARATOR customGet default
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_get("test/minimal")

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the customPost method.
#
# allow post method for a custom path with minimal parameters
def snippet_for_custom_post
  # >SEPARATOR customPost default
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_post("test/minimal")

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the customPut method.
#
# allow put method for a custom path with minimal parameters
def snippet_for_custom_put
  # >SEPARATOR customPut default
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_put("test/minimal")

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the deleteUserToken method.
#
# deleteUserToken
def snippet_for_delete_user_token
  # >SEPARATOR deleteUserToken default
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  client.delete_user_token("test-user-1")
  # >LOG
  # SEPARATOR<
end

# Snippet for the pushEvents method.
#
# pushEvents
def snippet_for_push_events
  # >SEPARATOR pushEvents default
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.push_events(
    Algolia::Insights::InsightsEvents.new(
      events: [
        Algolia::Insights::ClickedObjectIDsAfterSearch.new(
          event_type: "click",
          event_name: "Product Clicked",
          index: "products",
          user_token: "user-123456",
          authenticated_user_token: "user-123456",
          timestamp: 1641290601962,
          object_ids: ["9780545139700", "9780439784542"],
          query_id: "43b15df305339e827f0ac0bdc5ebcaa7",
          positions: [7, 6]
        )
      ]
    )
  )

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the setClientApiKey method.
#
# switch API key
def snippet_for_set_client_api_key
  # >SEPARATOR setClientApiKey default
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  client.set_client_api_key("updated-api-key")
  # >LOG
  # SEPARATOR<
end