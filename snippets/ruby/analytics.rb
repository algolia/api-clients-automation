require 'algolia'

# Snippet for the customDelete method.
#
# allow del method for a custom path with minimal parameters
def snippet_for_custom_delete
  # >SEPARATOR customDelete
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

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
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

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
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

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
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.custom_put("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getAverageClickPosition method.
#
# get getAverageClickPosition with minimal parameters
def snippet_for_get_average_click_position
  # >SEPARATOR getAverageClickPosition
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_average_click_position("index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getClickPositions method.
#
# get getClickPositions with minimal parameters
def snippet_for_get_click_positions
  # >SEPARATOR getClickPositions
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_click_positions("index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getClickThroughRate method.
#
# get getClickThroughRate with minimal parameters
def snippet_for_get_click_through_rate
  # >SEPARATOR getClickThroughRate
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_click_through_rate("index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getConversationRate method.
#
# get getConversationRate with minimal parameters
def snippet_for_get_conversation_rate
  # >SEPARATOR getConversationRate
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_conversation_rate("index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getNoClickRate method.
#
# get getNoClickRate with minimal parameters
def snippet_for_get_no_click_rate
  # >SEPARATOR getNoClickRate
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_no_click_rate("index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getNoResultsRate method.
#
# get getNoResultsRate with minimal parameters
def snippet_for_get_no_results_rate
  # >SEPARATOR getNoResultsRate
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_no_results_rate("index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getSearchesCount method.
#
# get getSearchesCount with minimal parameters
def snippet_for_get_searches_count
  # >SEPARATOR getSearchesCount
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_searches_count("index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getSearchesNoClicks method.
#
# get getSearchesNoClicks with minimal parameters
def snippet_for_get_searches_no_clicks
  # >SEPARATOR getSearchesNoClicks
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_searches_no_clicks("index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getSearchesNoResults method.
#
# get getSearchesNoResults with minimal parameters
def snippet_for_get_searches_no_results
  # >SEPARATOR getSearchesNoResults
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_searches_no_results("index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getStatus method.
#
# get getStatus with minimal parameters
def snippet_for_get_status
  # >SEPARATOR getStatus
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_status("index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getTopCountries method.
#
# get getTopCountries with minimal parameters
def snippet_for_get_top_countries
  # >SEPARATOR getTopCountries
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_top_countries("index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getTopFilterAttributes method.
#
# get getTopFilterAttributes with minimal parameters
def snippet_for_get_top_filter_attributes
  # >SEPARATOR getTopFilterAttributes
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_top_filter_attributes("index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getTopFilterForAttribute method.
#
# get getTopFilterForAttribute with minimal parameters
def snippet_for_get_top_filter_for_attribute
  # >SEPARATOR getTopFilterForAttribute
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_top_filter_for_attribute("myAttribute", "index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getTopFiltersNoResults method.
#
# get getTopFiltersNoResults with minimal parameters
def snippet_for_get_top_filters_no_results
  # >SEPARATOR getTopFiltersNoResults
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_top_filters_no_results("index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getTopHits method.
#
# get getTopHits with minimal parameters
def snippet_for_get_top_hits
  # >SEPARATOR getTopHits
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_top_hits("index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getTopSearches method.
#
# get getTopSearches with minimal parameters
def snippet_for_get_top_searches
  # >SEPARATOR getTopSearches
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_top_searches("index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getUsersCount method.
#
# get getUsersCount with minimal parameters
def snippet_for_get_users_count
  # >SEPARATOR getUsersCount
  # Initialize the client
  client = Algolia::AnalyticsClient.create('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION')

  # Call the API
  resp = client.get_users_count("index")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end
