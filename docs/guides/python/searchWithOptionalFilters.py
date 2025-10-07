from algoliasearch.search.client import SearchClientSync

from algoliasearch.search.models.search_params import SearchParams


def _reduce_labels_to_filters(_labels):
    # Implement your logic here
    return []


labels = []  # A list of labels

_client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")


optional_filters = _reduce_labels_to_filters(labels)
search_params = SearchParams(
    query="<YOUR_SEARCH_QUERY>",
    optional_filters=optional_filters,
)

_client.search_single_index(
    index_name="<YOUR_INDEX_NAME>",
    search_params=search_params,
)
