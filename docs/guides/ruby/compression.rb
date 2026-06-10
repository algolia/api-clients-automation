require "algolia"

# Initialize the client with gzip compression enabled
# Compression reduces the size of request bodies sent to Algolia
client = Algolia::SearchClient.create(
  "ALGOLIA_APPLICATION_ID",
  "ALGOLIA_API_KEY",
  compression_type: "gzip"
)

# Search with compressed request body
result = client.search_single_index("<YOUR_INDEX_NAME>", Algolia::Search::SearchParamsObject.new(query: "comedy"))
puts(result)
