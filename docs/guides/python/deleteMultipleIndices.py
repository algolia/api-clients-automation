from algoliasearch.search.client import SearchClientSync


# You need an API key with `deleteIndex`
_client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")


# List all indices
indices = _client.list_indices()

# Primary indices don't have a `primary` key
primary_indices = [index for index in indices.items if index.primary is None]
replica_indices = [index for index in indices.items if index.primary is not None]

# Delete primary indices first
if primary_indices:
    requests = [
        {"action": "delete", "indexName": index.name} for index in primary_indices
    ]
    _client.multiple_batch(
        batch_params={
            "requests": requests,
        },
    )
    print("Deleted primary indices.")

# Now, delete replica indices
if replica_indices:
    requests = [
        {"action": "delete", "indexName": index.name} for index in replica_indices
    ]
    _client.multiple_batch(
        batch_params={
            "requests": requests,
        },
    )
    print("Deleted replica indices.\n")
