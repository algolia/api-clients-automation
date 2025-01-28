# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
# >IMPORT
require "algolia"

# IMPORT<

# Snippet for the customDelete method.
#
# allow del method for a custom path with minimal parameters
def snippet_for_custom_delete
  # >SEPARATOR customDelete allow del method for a custom path with minimal parameters
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

# Snippet for the customDelete method.
#
# allow del method for a custom path with all parameters
def snippet_for_custom_delete1
  # >SEPARATOR customDelete allow del method for a custom path with all parameters
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_delete("test/all", {query: "parameters"})

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
  # >SEPARATOR customGet allow get method for a custom path with minimal parameters
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

# Snippet for the customGet method.
#
# allow get method for a custom path with all parameters
def snippet_for_custom_get1
  # >SEPARATOR customGet allow get method for a custom path with all parameters
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_get("test/all", {query: "parameters with space"})

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the customGet method.
#
# requestOptions should be escaped too
def snippet_for_custom_get2
  # >SEPARATOR customGet requestOptions should be escaped too
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_get(
    "test/all",
    {query: "to be overriden"},
    {
      :header_params => JSON.parse("{\"x-header-1\":\"spaces are left alone\"}", :symbolize_names => true),
      :query_params => JSON.parse(
        "{\"query\":\"parameters with space\",\"and an array\":[\"array\",\"with spaces\"]}",
        :symbolize_names => true
      )
    }
  )

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
  # >SEPARATOR customPost allow post method for a custom path with minimal parameters
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

# Snippet for the customPost method.
#
# allow post method for a custom path with all parameters
def snippet_for_custom_post1
  # >SEPARATOR customPost allow post method for a custom path with all parameters
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_post("test/all", {query: "parameters"}, {body: "parameters"})

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the customPost method.
#
# requestOptions can override default query parameters
def snippet_for_custom_post2
  # >SEPARATOR customPost requestOptions can override default query parameters
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_post(
    "test/requestOptions",
    {query: "parameters"},
    {facet: "filters"},
    {:query_params => JSON.parse("{\"query\":\"myQueryParameter\"}", :symbolize_names => true)}
  )

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the customPost method.
#
# requestOptions merges query parameters with default ones
def snippet_for_custom_post3
  # >SEPARATOR customPost requestOptions merges query parameters with default ones
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_post(
    "test/requestOptions",
    {query: "parameters"},
    {facet: "filters"},
    {:query_params => JSON.parse("{\"query2\":\"myQueryParameter\"}", :symbolize_names => true)}
  )

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the customPost method.
#
# requestOptions can override default headers
def snippet_for_custom_post4
  # >SEPARATOR customPost requestOptions can override default headers
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_post(
    "test/requestOptions",
    {query: "parameters"},
    {facet: "filters"},
    {:header_params => JSON.parse("{\"x-algolia-api-key\":\"ALGOLIA_API_KEY\"}", :symbolize_names => true)}
  )

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the customPost method.
#
# requestOptions merges headers with default ones
def snippet_for_custom_post5
  # >SEPARATOR customPost requestOptions merges headers with default ones
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_post(
    "test/requestOptions",
    {query: "parameters"},
    {facet: "filters"},
    {:header_params => JSON.parse("{\"x-algolia-api-key\":\"ALGOLIA_API_KEY\"}", :symbolize_names => true)}
  )

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the customPost method.
#
# requestOptions queryParameters accepts booleans
def snippet_for_custom_post6
  # >SEPARATOR customPost requestOptions queryParameters accepts booleans
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_post(
    "test/requestOptions",
    {query: "parameters"},
    {facet: "filters"},
    {:query_params => JSON.parse("{\"isItWorking\":true}", :symbolize_names => true)}
  )

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the customPost method.
#
# requestOptions queryParameters accepts integers
def snippet_for_custom_post7
  # >SEPARATOR customPost requestOptions queryParameters accepts integers
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_post(
    "test/requestOptions",
    {query: "parameters"},
    {facet: "filters"},
    {:query_params => JSON.parse("{\"myParam\":2}", :symbolize_names => true)}
  )

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the customPost method.
#
# requestOptions queryParameters accepts list of string
def snippet_for_custom_post8
  # >SEPARATOR customPost requestOptions queryParameters accepts list of string
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_post(
    "test/requestOptions",
    {query: "parameters"},
    {facet: "filters"},
    {:query_params => JSON.parse("{\"myParam\":[\"b and c\",\"d\"]}", :symbolize_names => true)}
  )

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the customPost method.
#
# requestOptions queryParameters accepts list of booleans
def snippet_for_custom_post9
  # >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_post(
    "test/requestOptions",
    {query: "parameters"},
    {facet: "filters"},
    {:query_params => JSON.parse("{\"myParam\":[true,true,false]}", :symbolize_names => true)}
  )

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the customPost method.
#
# requestOptions queryParameters accepts list of integers
def snippet_for_custom_post10
  # >SEPARATOR customPost requestOptions queryParameters accepts list of integers
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_post(
    "test/requestOptions",
    {query: "parameters"},
    {facet: "filters"},
    {:query_params => JSON.parse("{\"myParam\":[1,2]}", :symbolize_names => true)}
  )

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
  # >SEPARATOR customPut allow put method for a custom path with minimal parameters
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

# Snippet for the customPut method.
#
# allow put method for a custom path with all parameters
def snippet_for_custom_put1
  # >SEPARATOR customPut allow put method for a custom path with all parameters
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.custom_put("test/all", {query: "parameters"}, {body: "parameters"})

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
  # >SEPARATOR pushEvents pushEvents
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

# Snippet for the pushEvents method.
#
# Many events type
def snippet_for_push_events1
  # >SEPARATOR pushEvents Many events type
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.push_events(
    Algolia::Insights::InsightsEvents.new(
      events: [
        Algolia::Insights::ConvertedObjectIDsAfterSearch.new(
          event_type: "conversion",
          event_name: "Product Purchased",
          index: "products",
          user_token: "user-123456",
          authenticated_user_token: "user-123456",
          timestamp: 1737936000000,
          object_ids: ["9780545139700", "9780439784542"],
          query_id: "43b15df305339e827f0ac0bdc5ebcaa7"
        ),
        Algolia::Insights::ViewedObjectIDs.new(
          event_type: "view",
          event_name: "Product Detail Page Viewed",
          index: "products",
          user_token: "user-123456",
          authenticated_user_token: "user-123456",
          timestamp: 1737936000000,
          object_ids: ["9780545139700", "9780439784542"]
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

# Snippet for the pushEvents method.
#
# ConvertedObjectIDsAfterSearch
def snippet_for_push_events2
  # >SEPARATOR pushEvents ConvertedObjectIDsAfterSearch
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.push_events(
    Algolia::Insights::InsightsEvents.new(
      events: [
        Algolia::Insights::ConvertedObjectIDsAfterSearch.new(
          event_type: "conversion",
          event_name: "Product Purchased",
          index: "products",
          user_token: "user-123456",
          authenticated_user_token: "user-123456",
          timestamp: 1641290601962,
          object_ids: ["9780545139700", "9780439784542"],
          query_id: "43b15df305339e827f0ac0bdc5ebcaa7"
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

# Snippet for the pushEvents method.
#
# ViewedObjectIDs
def snippet_for_push_events3
  # >SEPARATOR pushEvents ViewedObjectIDs
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.push_events(
    Algolia::Insights::InsightsEvents.new(
      events: [
        Algolia::Insights::ViewedObjectIDs.new(
          event_type: "view",
          event_name: "Product Detail Page Viewed",
          index: "products",
          user_token: "user-123456",
          authenticated_user_token: "user-123456",
          timestamp: 1641290601962,
          object_ids: ["9780545139700", "9780439784542"]
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

# Snippet for the pushEvents method.
#
# AddedToCartObjectIDs
def snippet_for_push_events4
  # >SEPARATOR pushEvents AddedToCartObjectIDs
  # Initialize the client
  client = Algolia::InsightsClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

  # Call the API
  response = client.push_events(
    Algolia::Insights::InsightsEvents.new(
      events: [
        Algolia::Insights::AddedToCartObjectIDsAfterSearch.new(
          event_type: "conversion",
          event_subtype: "addToCart",
          event_name: "Product Added To Cart",
          index: "products",
          query_id: "43b15df305339e827f0ac0bdc5ebcaa7",
          user_token: "user-123456",
          authenticated_user_token: "user-123456",
          timestamp: 1641290601962,
          object_ids: ["9780545139700", "9780439784542"],
          object_data: [
            Algolia::Insights::ObjectDataAfterSearch.new(price: 19.99, quantity: 10, discount: 2.5),
            Algolia::Insights::ObjectDataAfterSearch.new(price: "8$", quantity: 7, discount: "30%")
          ],
          currency: "USD"
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
