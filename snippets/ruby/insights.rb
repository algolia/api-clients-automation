require 'algolia'

# Snippet for the customDelete method.
#
# allow del method for a custom path with minimal parameters
def snippet_for_custom_delete
  # Initialize the client
  client = Algolia::InsightsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

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
  client = Algolia::InsightsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

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
  client = Algolia::InsightsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

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
  client = Algolia::InsightsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.custom_put("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the deleteUserToken method.
#
# deleteUserToken0
def snippet_for_delete_user_token
  # Initialize the client
  client = Algolia::InsightsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.delete_user_token("test-user-1")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the pushEvents method.
#
# pushEvents0
def snippet_for_push_events
  # Initialize the client
  client = Algolia::InsightsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.push_events(
    InsightsEvents.new(
      events: [ClickedObjectIDsAfterSearch.new(
        event_type: 'click',
        event_name: "Product Clicked",
        index: "products",
        user_token: "user-123456",
        authenticated_user_token: "user-123456",
        timestamp: 1_641_290_601_962,
        object_ids: [
          "9780545139700", "9780439784542"
        ],
        query_id: "43b15df305339e827f0ac0bdc5ebcaa7",
        positions: [7, 6]
      )]
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end
