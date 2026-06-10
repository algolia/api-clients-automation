from algoliasearch.search.config import SearchConfig
from algoliasearch.search.client import SearchClientSync


# Initialize the client with gzip compression enabled
# Compression reduces the size of request bodies sent to Algolia
_config = SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
_config.compression_type = "gzip"
_client = SearchClientSync.create_with_config(config=_config)

# Search with compressed request body
_client.search_single_index(
    index_name="<YOUR_INDEX_NAME>",
    search_params={
        "query": "comedy",
    },
)
