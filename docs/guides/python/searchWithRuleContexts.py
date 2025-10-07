from algoliasearch.search.client import SearchClientSync

from algoliasearch.search.models.search_params import SearchParams


def _get_platform_tag() -> str:
    # Implement your logic here
    return ""


_client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")


# get the buyer account information
platform_tag = _get_platform_tag()
search_params = SearchParams(
    query="<YOUR_SEARCH_QUERY>",
    rule_contexts=[platform_tag],
)

_client.search_single_index(
    index_name="<YOUR_INDEX_NAME>",
    search_params=search_params,
)
