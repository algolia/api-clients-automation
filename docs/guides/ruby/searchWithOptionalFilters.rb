require "algolia"

def reduce_labels_to_filters(_labels)
  # Implement your logic here
  []
end

# A list of labels
labels = []

client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

optional_filters = reduce_labels_to_filters(labels)
search_params = Algolia::Search::SearchParamsObject.new(
  query: "<YOUR_SEARCH_QUERY>",
  optionalFilters: optional_filters
)

client.search_single_index("<YOUR_INDEX_NAME>", search_params)
