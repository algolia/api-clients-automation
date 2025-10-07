from algoliasearch.search.client import SearchClientSync


_client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")


query = "query"

# 1. Change the sort dynamically based on the UI events
sort_by_price = False

# 2. Get the index name based on sortByPrice
index_name = "products_price_desc" if sort_by_price else "products"

# 3. Search on dynamic index name (primary or replica)
_client.search_single_index(
    index_name=index_name,
    search_params={
        "query": "query",
    },
)
