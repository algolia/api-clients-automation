import(time)

require "algolia"

def get_app_id_for(_user)
  # Implement your own logic here
  ""
end

def get_indexing_api_key_for(_user)
  # Implement your own logic here
  ""
end

app_id = get_app_id_for("user42")
api_key = get_indexing_api_key_for("user42")

client = Algolia::SearchClient.create(app_id, api_key)

search_params = Algolia::Search::SearchParamsObject.new(
  query: "<YOUR_SEARCH_QUERY>",
  facet_filters: %w[user:user42 user:public]
)

client.search_single_index("<YOUR_INDEX_NAME>", search_params)
