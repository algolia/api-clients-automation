import json

from algoliasearch.search.client import SearchClientSync


with open("records.json", "r", encoding="utf-8") as f:
    records = json.load(f)

    _client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

    chunk_size = 10000

    for begin_index in range(0, len(records), chunk_size):
        try:
            chunk = records[begin_index : begin_index + chunk_size]
            _client.save_objects(
                index_name="<YOUR_INDEX_NAME>",
                objects=chunk,
            )
        except Exception as e:
            print(f"Error: {e}")
