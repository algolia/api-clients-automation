require 'algolia'

# Snippet for the createConfig method.
#
# createConfig0
def snippet_for_create_config
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  resp = client.create_config(
    QuerySuggestionsConfigurationWithIndex.new(
      index_name: "theIndexName",
      source_indices: [SourceIndex.new(
        index_name: "testIndex",
        facets: [Facet.new(attribute: "test")],
        generate: [["facetA", "facetB"], ["facetC"]]
      )],
      languages: ["french"],
      exclude: ["test"]
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
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

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
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

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
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

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
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  resp = client.custom_put("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the deleteConfig method.
#
# deleteConfig0
def snippet_for_delete_config
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  resp = client.delete_config("theIndexName")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getAllConfigs method.
#
# getAllConfigs0
def snippet_for_get_all_configs
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  resp = client.get_all_configs

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getConfig method.
#
# getConfig0
def snippet_for_get_config
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  resp = client.get_config("theIndexName")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getConfigStatus method.
#
# getConfigStatus0
def snippet_for_get_config_status
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  resp = client.get_config_status("theIndexName")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getLogFile method.
#
# getLogFile0
def snippet_for_get_log_file
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  resp = client.get_log_file("theIndexName")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the updateConfig method.
#
# updateConfig0
def snippet_for_update_config
  # Initialize the client
  client = Algolia::QuerySuggestionsClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  resp = client.update_config(
    "theIndexName",
    QuerySuggestionsConfiguration.new(
      source_indices: [SourceIndex.new(
        index_name: "testIndex",
        facets: [Facet.new(attribute: "test")],
        generate: [["facetA", "facetB"], ["facetC"]]
      )],
      languages: ["french"],
      exclude: ["test"]
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end
