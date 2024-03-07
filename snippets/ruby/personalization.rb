require 'algolia'

# Snippet for the customDelete method.
#
# allow del method for a custom path with minimal parameters
def snippet_for_custom_delete
  # >SEPARATOR customDelete
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
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
  # SEPARATOR<
end

# Snippet for the customGet method.
#
# allow get method for a custom path with minimal parameters
def snippet_for_custom_get
  # >SEPARATOR customGet
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
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
  # SEPARATOR<
end

# Snippet for the customPost method.
#
# allow post method for a custom path with minimal parameters
def snippet_for_custom_post
  # >SEPARATOR customPost
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
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
  # SEPARATOR<
end

# Snippet for the customPut method.
#
# allow put method for a custom path with minimal parameters
def snippet_for_custom_put
  # >SEPARATOR customPut
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
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
  # SEPARATOR<
end

# Snippet for the deleteUserProfile method.
#
# delete deleteUserProfile
def snippet_for_delete_user_profile
  # >SEPARATOR deleteUserProfile
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  resp = client.delete_user_profile("UserToken")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getPersonalizationStrategy method.
#
# get getPersonalizationStrategy
def snippet_for_get_personalization_strategy
  # >SEPARATOR getPersonalizationStrategy
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  resp = client.get_personalization_strategy

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the getUserTokenProfile method.
#
# get getUserTokenProfile
def snippet_for_get_user_token_profile
  # >SEPARATOR getUserTokenProfile
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  resp = client.get_user_token_profile("UserToken")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end

# Snippet for the setPersonalizationStrategy method.
#
# set setPersonalizationStrategy
def snippet_for_set_personalization_strategy
  # >SEPARATOR setPersonalizationStrategy
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  resp = client.set_personalization_strategy(
    PersonalizationStrategyParams.new(
      event_scoring: [EventScoring.new(
        score: 42,
        event_name: "Algolia",
        event_type: "Event"
      )],
      facet_scoring: [FacetScoring.new(score: 42, facet_name: "Event")],
      personalization_impact: 42
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
  # SEPARATOR<
end
