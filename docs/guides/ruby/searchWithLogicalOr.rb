require "algolia"

client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

query = "the query"
optional_words = %w[the query]
search_params = Algolia::Search::SearchParamsObject.new(
  query: query,
  optional_words: optional_words
)
client.search_single_index("<YOUR_INDEX_NAME>", search_params)
