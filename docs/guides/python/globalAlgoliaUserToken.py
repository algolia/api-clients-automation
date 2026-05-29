from algoliasearch.search.client import SearchClientSync
from algoliasearch.search.config import SearchConfig


_config = SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
_config.headers["X-Algolia-UserToken"] = "test-user-123"
_client = SearchClientSync.create_with_config(_config)
print(_client)
