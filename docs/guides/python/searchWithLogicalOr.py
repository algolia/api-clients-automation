from algoliasearch.search.client import SearchClientSync

from algoliasearch.search.models.search_params import SearchParams


_client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")


query = "the query"
optional_words = ["the", "query"]
search_params = SearchParams(
    query=query,
    optional_words=optional_words,
)

_client.search_single_index(
    index_name="<YOUR_INDEX_NAME>",
    search_params=search_params,
)
