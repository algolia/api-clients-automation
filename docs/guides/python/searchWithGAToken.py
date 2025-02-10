from algoliasearch.search.client import SearchClientSync


def _get_google_analytics_user_id_from_browser_cookie(cookie_name: str) -> str:
    # Implement your logic here
    return ""


if __name__ == "__main__":
    try:
        _client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

        user_token = _get_google_analytics_user_id_from_browser_cookie("_ga")
        search_params = {
            "query": "<YOUR_SEARCH_QUERY>",
            "userToken": user_token,
        }

        _client.search_single_index(
            index_name="<YOUR_INDEX_NAME>",
            search_params=search_params,
        )

        logged_in_user = None

        search_params["user_token"] = logged_in_user or user_token

        _client.search_single_index(
            index_name="<YOUR_INDEX_NAME>",
            search_params=search_params,
        )
    except Exception as e:
        print(f"Error: {e}")
