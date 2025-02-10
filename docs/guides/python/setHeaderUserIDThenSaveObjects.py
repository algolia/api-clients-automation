from algoliasearch.search.client import SearchClientSync
from json import loads


if __name__ == "__main__":
    playlists = []  # Your records

    try:
        _client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

        for playlist in playlists:
            playlist_user_id = playlist["userID"]
            _client.save_objects(
                index_name="<YOUR_INDEX_NAME>",
                objects=playlists,
                wait_for_tasks=False,
                batch_size=1000,
                request_options={
                    "headers": loads("""{"X-Algolia-User-ID":playlistUserID}"""),
                },
            )
    except Exception as e:
        print(f"Error: {e}")
