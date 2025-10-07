import requests
from algoliasearch.search.client import SearchClientSync


# Fetch sample dataset
url = "https://dashboard.algolia.com/api/1/sample_datasets?type=movie"
movies = requests.get(url).json()

# Connect and authenticate with your Algolia app using your app ID and write API key
_client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")


# Save records in Algolia index
_client.save_objects(
    index_name="<YOUR_INDEX_NAME>",
    objects=movies,
)
