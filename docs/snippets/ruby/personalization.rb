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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

  # Call the API
  response = client.custom_put("test/all", {query: "parameters"}, {body: "parameters"})

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the deleteUserProfile method.
#
# delete deleteUserProfile
def snippet_for_delete_user_profile
  # >SEPARATOR deleteUserProfile default
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

  # Call the API
  response = client.delete_user_profile("UserToken")

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the getPersonalizationStrategy method.
#
# get getPersonalizationStrategy
def snippet_for_get_personalization_strategy
  # >SEPARATOR getPersonalizationStrategy default
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

  # Call the API
  response = client.get_personalization_strategy

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end

# Snippet for the getUserTokenProfile method.
#
# get getUserTokenProfile
def snippet_for_get_user_token_profile
  # >SEPARATOR getUserTokenProfile default
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

  # Call the API
  response = client.get_user_token_profile("UserToken")

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
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

  # Call the API
  client.set_client_api_key("updated-api-key")
  # >LOG
  # SEPARATOR<
end

# Snippet for the setPersonalizationStrategy method.
#
# set setPersonalizationStrategy
def snippet_for_set_personalization_strategy
  # >SEPARATOR setPersonalizationStrategy default
  # Initialize the client
  client = Algolia::PersonalizationClient.create(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )

  # Call the API
  response = client.set_personalization_strategy(
    Algolia::Personalization::PersonalizationStrategyParams.new(
      events_scoring: [
        Algolia::Personalization::EventsScoring.new(score: 42, event_name: "Algolia", event_type: "click")
      ],
      facets_scoring: [Algolia::Personalization::FacetsScoring.new(score: 42, facet_name: "Event")],
      personalization_impact: 42
    )
  )

  # >LOG
  # use the class directly
  puts(response)

  # print the JSON response
  puts(response.to_json)
  # SEPARATOR<
end
