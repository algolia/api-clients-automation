require "algolia"

client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

query = "query"

# 1. Change the sort dynamically based on the UI events
sort_by_price = false

# 2. Get the index name based on sortByPrice
index_name = sort_by_price ? "products_price_desc" : "products"

# 3. Search on dynamic index name (primary or replica)
client.search_single_index(index_name, Algolia::Search::SearchParamsObject.new(query: "query"))
