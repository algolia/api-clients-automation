# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
# >IMPORT
require "algolia"

# IMPORT<

# Snippet for the batchRecommendRules method.
#
# batch recommend rules
def snippet_for_batch_recommend_rules
  # >SEPARATOR batchRecommendRules default
  # Initialize the client
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.batch_recommend_rules("<YOUR_INDEX_NAME>", "related-products")

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the customDelete method.
#
# allow del method for a custom path with minimal parameters
def snippet_for_custom_delete
  # >SEPARATOR customDelete allow del method for a custom path with minimal parameters
  # Initialize the client
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.custom_get(
    "test/all",
    {query: "to be overriden"},
    {
      :header_params => {"x-header-1" => "spaces are left alone"},
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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.custom_post(
    "test/requestOptions",
    {query: "parameters"},
    {facet: "filters"},
    {:header_params => {"x-algolia-api-key" => "ALGOLIA_API_KEY"}}
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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.custom_post(
    "test/requestOptions",
    {query: "parameters"},
    {facet: "filters"},
    {:header_params => {"x-algolia-api-key" => "ALGOLIA_API_KEY"}}
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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.custom_put("test/all", {query: "parameters"}, {body: "parameters"})

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the deleteRecommendRule method.
#
# deleteRecommendRule
def snippet_for_delete_recommend_rule
  # >SEPARATOR deleteRecommendRule default
  # Initialize the client
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.delete_recommend_rule("<YOUR_INDEX_NAME>", "related-products", "objectID")

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the getRecommendRule method.
#
# getRecommendRule
def snippet_for_get_recommend_rule
  # >SEPARATOR getRecommendRule default
  # Initialize the client
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.get_recommend_rule("<YOUR_INDEX_NAME>", "related-products", "objectID")

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the getRecommendStatus method.
#
# getRecommendStatus
def snippet_for_get_recommend_status
  # >SEPARATOR getRecommendStatus default
  # Initialize the client
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.get_recommend_status("<YOUR_INDEX_NAME>", "related-products", 12345)

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the getRecommendations method.
#
# get recommendations for recommend model with minimal parameters
def snippet_for_get_recommendations
  # >SEPARATOR getRecommendations get recommendations for recommend model with minimal parameters
  # Initialize the client
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.get_recommendations(
    Algolia::Recommend::GetRecommendationsParams.new(
      requests: [
        Algolia::Recommend::RelatedQuery.new(
          index_name: "<YOUR_INDEX_NAME>",
          algolia_object_id: "objectID",
          model: "related-products",
          threshold: 42.1
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

# Snippet for the getRecommendations method.
#
# get recommendations with e2e to check oneOf model
def snippet_for_get_recommendations1
  # >SEPARATOR getRecommendations get recommendations with e2e to check oneOf model
  # Initialize the client
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.get_recommendations(
    Algolia::Recommend::GetRecommendationsParams.new(
      requests: [
        Algolia::Recommend::RelatedQuery.new(
          index_name: "<YOUR_INDEX_NAME>",
          algolia_object_id: "Æon Flux",
          model: "related-products",
          threshold: 20.0,
          max_recommendations: 2
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

# Snippet for the getRecommendations method.
#
# get recommendations for recommend model with all parameters
def snippet_for_get_recommendations2
  # >SEPARATOR getRecommendations get recommendations for recommend model with all parameters
  # Initialize the client
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.get_recommendations(
    Algolia::Recommend::GetRecommendationsParams.new(
      requests: [
        Algolia::Recommend::RelatedQuery.new(
          index_name: "<YOUR_INDEX_NAME>",
          algolia_object_id: "objectID",
          model: "related-products",
          threshold: 42.1,
          max_recommendations: 10,
          query_parameters: Algolia::Recommend::RecommendSearchParams.new(query: "myQuery", facet_filters: ["query"]),
          fallback_parameters: Algolia::Recommend::FallbackParams.new(query: "myQuery", facet_filters: ["fallback"])
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

# Snippet for the getRecommendations method.
#
# get recommendations for trending model with minimal parameters
def snippet_for_get_recommendations3
  # >SEPARATOR getRecommendations get recommendations for trending model with minimal parameters
  # Initialize the client
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.get_recommendations(
    Algolia::Recommend::GetRecommendationsParams.new(
      requests: [
        Algolia::Recommend::TrendingItemsQuery.new(
          index_name: "<YOUR_INDEX_NAME>",
          model: "trending-items",
          threshold: 42.1,
          facet_name: "facet",
          facet_value: "value"
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

# Snippet for the getRecommendations method.
#
# get recommendations for trending model with all parameters
def snippet_for_get_recommendations4
  # >SEPARATOR getRecommendations get recommendations for trending model with all parameters
  # Initialize the client
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.get_recommendations(
    Algolia::Recommend::GetRecommendationsParams.new(
      requests: [
        Algolia::Recommend::TrendingItemsQuery.new(
          index_name: "<YOUR_INDEX_NAME>",
          model: "trending-items",
          threshold: 42.1,
          max_recommendations: 10,
          facet_name: "myFacetName",
          facet_value: "myFacetValue",
          query_parameters: Algolia::Recommend::RecommendSearchParams.new(query: "myQuery", facet_filters: ["query"]),
          fallback_parameters: Algolia::Recommend::FallbackParams.new(query: "myQuery", facet_filters: ["fallback"])
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

# Snippet for the getRecommendations method.
#
# get multiple recommendations with minimal parameters
def snippet_for_get_recommendations5
  # >SEPARATOR getRecommendations get multiple recommendations with minimal parameters
  # Initialize the client
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.get_recommendations(
    Algolia::Recommend::GetRecommendationsParams.new(
      requests: [
        Algolia::Recommend::RelatedQuery.new(
          index_name: "<YOUR_INDEX_NAME>",
          algolia_object_id: "objectID1",
          model: "related-products",
          threshold: 21.7
        ),
        Algolia::Recommend::RelatedQuery.new(
          index_name: "<YOUR_INDEX_NAME>",
          algolia_object_id: "objectID2",
          model: "related-products",
          threshold: 21.7
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

# Snippet for the getRecommendations method.
#
# get multiple recommendations with all parameters
def snippet_for_get_recommendations6
  # >SEPARATOR getRecommendations get multiple recommendations with all parameters
  # Initialize the client
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.get_recommendations(
    Algolia::Recommend::GetRecommendationsParams.new(
      requests: [
        Algolia::Recommend::RelatedQuery.new(
          index_name: "<YOUR_INDEX_NAME>",
          algolia_object_id: "objectID1",
          model: "related-products",
          threshold: 21.7,
          max_recommendations: 10,
          query_parameters: Algolia::Recommend::RecommendSearchParams.new(query: "myQuery", facet_filters: ["query1"]),
          fallback_parameters: Algolia::Recommend::FallbackParams.new(query: "myQuery", facet_filters: ["fallback1"])
        ),
        Algolia::Recommend::RelatedQuery.new(
          index_name: "<YOUR_INDEX_NAME>",
          algolia_object_id: "objectID2",
          model: "related-products",
          threshold: 21.7,
          max_recommendations: 10,
          query_parameters: Algolia::Recommend::RecommendSearchParams.new(query: "myQuery", facet_filters: ["query2"]),
          fallback_parameters: Algolia::Recommend::FallbackParams.new(query: "myQuery", facet_filters: ["fallback2"])
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

# Snippet for the getRecommendations method.
#
# get frequently bought together recommendations
def snippet_for_get_recommendations7
  # >SEPARATOR getRecommendations get frequently bought together recommendations
  # Initialize the client
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.get_recommendations(
    Algolia::Recommend::GetRecommendationsParams.new(
      requests: [
        Algolia::Recommend::BoughtTogetherQuery.new(
          index_name: "<YOUR_INDEX_NAME>",
          algolia_object_id: "objectID1",
          model: "bought-together",
          threshold: 42.7
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

# Snippet for the searchRecommendRules method.
#
# searchRecommendRules
def snippet_for_search_recommend_rules
  # >SEPARATOR searchRecommendRules default
  # Initialize the client
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  response = client.search_recommend_rules("<YOUR_INDEX_NAME>", "related-products")

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
  client = Algolia::RecommendClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Call the API
  client.set_client_api_key("updated-api-key")
  # >LOG
  # SEPARATOR<
end
