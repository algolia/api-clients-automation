import datetime
import time

from algoliasearch.search.client import SearchClientSync


_client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")


date = datetime.datetime.now() - datetime.timedelta(days=365)
date_timestamp = int(time.mktime(date.timetuple()))
search_params = {
    "query": "<YOUR_SEARCH_QUERY>",
    "filters": f"date_timestamp > {date_timestamp}",
}

_client.search_single_index(
    index_name="<YOUR_INDEX_NAME>",
    search_params=search_params,
)
