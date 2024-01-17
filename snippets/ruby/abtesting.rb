require 'algolia'

# Snippet for the addABTests method.
#
# addABTests with minimal parameters
def snippet_for_add_ab_tests
  # Initialize the client
  client = Algolia::AbtestingClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.add_ab_tests(
    AddABTestsRequest.new(
      end_at: "2022-12-31T00:00:00.000Z",
      name: "myABTest",
      variants: [AbTestsVariant.new(index: "AB_TEST_1", traffic_percentage: 30),
        AbTestsVariant.new(index: "AB_TEST_2", traffic_percentage: 50)]
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
  client = Algolia::AbtestingClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

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
  client = Algolia::AbtestingClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

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
  client = Algolia::AbtestingClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

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
  client = Algolia::AbtestingClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.custom_put("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the deleteABTest method.
#
# deleteABTest
def snippet_for_delete_ab_test
  # Initialize the client
  client = Algolia::AbtestingClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.delete_ab_test(42)

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getABTest method.
#
# getABTest
def snippet_for_get_ab_test
  # Initialize the client
  client = Algolia::AbtestingClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_ab_test(42)

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the listABTests method.
#
# listABTests with minimal parameters
def snippet_for_list_ab_tests
  # Initialize the client
  client = Algolia::AbtestingClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.list_ab_tests

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the stopABTest method.
#
# stopABTest
def snippet_for_stop_ab_test
  # Initialize the client
  client = Algolia::AbtestingClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.stop_ab_test(42)

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end
