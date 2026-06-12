from algoliasearch.search.client import SearchClientSync

from algoliasearch.search.config import SearchConfig, TransformationOptions


# Override the Ingestion API defaults. Any option you don't set keeps its default.
# Replace "us" with "eu" if your Algolia application uses the Europe analytics region.
_config = SearchConfig(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    transformation_options=TransformationOptions(
        region="us",
        connect_timeout=5000,
        read_timeout=30000,
    ),
)
_client = SearchClientSync.create_with_config(_config)

# Save records, transforming them through the Push connector
_client.save_objects_with_transformation(
    index_name="<YOUR_INDEX_NAME>",
    objects=[
        {
            "objectID": "1",
            "name": "Adam",
        },
        {
            "objectID": "2",
            "name": "Benoit",
        },
    ],
    wait_for_tasks=True,
)
