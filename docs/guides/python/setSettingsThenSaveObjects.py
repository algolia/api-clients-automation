from algoliasearch.search.client import SearchClientSync

from algoliasearch.search.models.index_settings import IndexSettings


def _get_app_id_for(_user):
    # Implement your own logic here
    return ""


def _get_indexing_api_key_for(_user):
    # Implement your own logic here
    return ""


playlists = []  # Your records

for playlist in playlists:
    app_id = _get_app_id_for(playlist["user"])
    api_key = _get_indexing_api_key_for(playlist["user"])

    _client = SearchClientSync(app_id, api_key)
    settings = IndexSettings(attributes_for_faceting=["filterOnly(user)"])
    try:
        _client.set_settings(
            index_name="<YOUR_INDEX_NAME>",
            index_settings=settings,
        )

        _client.save_objects(
            index_name="<YOUR_INDEX_NAME>",
            objects=playlists,
        )
    except Exception as e:
        print(f"Error: {e}")
