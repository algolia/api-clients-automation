from algoliasearch.search.client import SearchClientSync

from algoliasearch.search.models.search_params import SearchParams


def _get_user_token() -> str:
    # Implement your logic here
    return ""


_client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")


# Set the searchParams and get the current user token
user_token = _get_user_token()

# Is the user token anonymous?
if user_token is None or user_token == "" or user_token == "YOUR_ANONYMOUS_USER_TOKEN":
    # Disable A/B testing for this request
    search_params = SearchParams(
        query="User search query",
        enable_ab_test=False,
    )
else:
    # Set the user token to the current user token
    search_params = SearchParams(
        query="User search query",
        enable_ab_test=True,
        user_token=user_token,
    )

try:
    # Perform the searchSingleIndex
    result = _client.search_single_index(
        index_name="<YOUR_INDEX_NAME>",
        search_params=search_params,
    )
    # SearchSingleIndex results
    print(result)
except Exception as err:
    # SearchSingleIndex errors
    print(err)
