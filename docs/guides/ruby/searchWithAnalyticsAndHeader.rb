require "algolia"

client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

# '94.228.178.246' should be replaced with your user's IP address.
# Depending on your stack there are multiple ways to get this information.
ip = "94.228.178.246"
query = "query"

search_params = Algolia::Search::SearchParamsObject.new(
  query: query,
  analytics: true
)

client.search_single_index("<YOUR_INDEX_NAME>", search_params, {:header_params => {"X-Forwarded-For" => ip}})
