# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
# >IMPORT
require 'algolia'
# IMPORT<

# Snippet for the customDelete method.
#
# allow del method for a custom path with minimal parameters
def snippet_for_custom_delete
  # >SEPARATOR customDelete default
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.custom_delete("test/minimal")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the customGet method.
#
# allow get method for a custom path with minimal parameters
def snippet_for_custom_get
  # >SEPARATOR customGet default
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.custom_get("test/minimal")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the customPost method.
#
# allow post method for a custom path with minimal parameters
def snippet_for_custom_post
  # >SEPARATOR customPost default
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.custom_post("test/minimal")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the customPut method.
#
# allow put method for a custom path with minimal parameters
def snippet_for_custom_put
  # >SEPARATOR customPut default
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.custom_put("test/minimal")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the deleteUserProfile method.
#
# delete deleteUserProfile
def snippet_for_delete_user_profile
  # >SEPARATOR deleteUserProfile default
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.delete_user_profile("UserToken")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getPersonalizationStrategy method.
#
# get getPersonalizationStrategy
def snippet_for_get_personalization_strategy
  # >SEPARATOR getPersonalizationStrategy default
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.get_personalization_strategy

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the getUserTokenProfile method.
#
# get getUserTokenProfile
def snippet_for_get_user_token_profile
  # >SEPARATOR getUserTokenProfile default
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.get_user_token_profile("UserToken")

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end

# Snippet for the setPersonalizationStrategy method.
#
# set setPersonalizationStrategy
def snippet_for_set_personalization_strategy
  # >SEPARATOR setPersonalizationStrategy default
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  )

  # Call the API
  response = client.set_personalization_strategy(
    PersonalizationStrategyParams.new(
      event_scoring: [EventScoring.new(
        score: 42,
        event_name: "Algolia",
        event_type: 'click'
      )],
      facet_scoring: [FacetScoring.new(score: 42, facet_name: "Event")],
      personalization_impact: 42
    )
  )

  # use the class directly
  puts response

  # print the JSON response
  puts response.to_json
  # SEPARATOR<
end
