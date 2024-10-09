import asyncio
import requests
from algoliasearch.search.client import SearchClientSync


async def main():
    # Fetch sample dataset
    url = "https://dashboard.algolia.com/sample_datasets/movie.json"
    movies = requests.get(url).json()

    # Connect and authenticate with your Algolia app
    _client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

    # Save records in Algolia index
    _client.save_objects(
        index_name="<YOUR_INDEX_NAME>",
        objects=movies,
    )


asyncio.run(main())
