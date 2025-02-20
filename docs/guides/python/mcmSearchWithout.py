from algoliasearch.search.client import SearchClientSync


def _get_app_id_for(_user):
    # Implement your own logic here
    return ""


def _get_indexing_api_key_for(_user):
    # Implement your own logic here
    return ""


app_id = _get_app_id_for("user42")
api_key = _get_indexing_api_key_for("user42")

_client = SearchClientSync(app_id, api_key)

search_params = {
    "query": "<YOUR_SEARCH_QUERY>",
    "facetFilters": ["user:user42", "user:public"],
}

_client.search_single_index(
    index_name="<YOUR_INDEX_NAME>",
    search_params=search_params,
)
