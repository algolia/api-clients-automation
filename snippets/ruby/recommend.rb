require 'algolia'

# Snippet for the customDelete method.
#
# allow del method for a custom path with minimal parameters
def snippet_for_custom_delete
  # >SEPARATOR customDelete
  # Initialize the client
  client = Algolia::RecommendClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

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
  client = Algolia::RecommendClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

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
  client = Algolia::RecommendClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

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
  client = Algolia::RecommendClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.custom_put("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the deleteRecommendRule method.
#
# deleteRecommendRule0
def snippet_for_delete_recommend_rule
  # >SEPARATOR deleteRecommendRule
  # Initialize the client
  client = Algolia::RecommendClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.delete_recommend_rule("indexName", 'related-products', "objectID")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getRecommendRule method.
#
# getRecommendRule0
def snippet_for_get_recommend_rule
  # >SEPARATOR getRecommendRule
  # Initialize the client
  client = Algolia::RecommendClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.get_recommend_rule("indexName", 'related-products', "objectID")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getRecommendStatus method.
#
# getRecommendStatus0
def snippet_for_get_recommend_status
  # >SEPARATOR getRecommendStatus
  # Initialize the client
  client = Algolia::RecommendClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.get_recommend_status("indexName", 'related-products', 12_345)

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getRecommendations method.
#
# get recommendations for recommend model with minimal parameters
def snippet_for_get_recommendations
  # >SEPARATOR getRecommendations
  # Initialize the client
  client = Algolia::RecommendClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.get_recommendations(
    GetRecommendationsParams.new(
      requests: [RecommendationsQuery.new(
        index_name: "indexName", object_id: "objectID", model: 'related-products', threshold: 42
      )]
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the searchRecommendRules method.
#
# searchRecommendRules0
def snippet_for_search_recommend_rules
  # >SEPARATOR searchRecommendRules
  # Initialize the client
  client = Algolia::RecommendClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.search_recommend_rules("indexName", 'related-products')

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end
