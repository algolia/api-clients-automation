from algoliasearch.search.client import SearchClientSync
from algoliasearch.search.models.browse_response import BrowseResponse


if __name__ == "__main__":
    try:
        _client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

        records = []

        def _aggregator(resp: BrowseResponse):
            for hit in resp.hits:
                hit_dict = hit.to_dict()
                records.append(
                    {
                        "twitterHandle": hit_dict["twitterHandle"],
                        "nbFollowers": hit_dict["nbFollowers"],
                        "isPopular": hit_dict["nbFollowers"] > 1000000,
                    }
                )

        _client.browse_objects(
            index_name="<YOUR_INDEX_NAME>",
            aggregator=_aggregator,
        )

        _client.save_objects(
            index_name="<YOUR_INDEX_NAME>",
            objects=records,
        )
    except Exception as e:
        print(f"Error: {e}")
