from algoliasearch.search.client import SearchClientSync


def _get_all_app_id_configurations():
    return []  # A list of your MCM AppID/ApiKey pairs


playlists = []  # Your records

# Fetch from your own data storage and with your own code
# the list of application IDs and API keys to target each cluster
configurations = _get_all_app_id_configurations()

# Send the records to each cluster
for appID, apiKey in configurations:
    try:
        _client = SearchClientSync(appID, apiKey)
        _client.save_objects(
            index_name="<YOUR_INDEX_NAME>",
            objects=playlists,
        )
    except Exception as e:
        print(f"Error: {e}")
