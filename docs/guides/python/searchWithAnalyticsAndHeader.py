from algoliasearch.search.client import SearchClientSync
from json import loads

from algoliasearch.search.models.search_params import SearchParams


_client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")


"""
'94.228.178.246' should be replaced with your user's IP address.
Depending on your stack there are multiple ways to get this information.
"""
ip = "94.228.178.246"
query = "query"

search_params = SearchParams(
    query=query,
    analytics=True,
)

_client.search_single_index(
    index_name="<YOUR_INDEX_NAME>",
    search_params=search_params,
    request_options={
        "headers": loads("""{"X-Forwarded-For":ip}"""),
    },
)
