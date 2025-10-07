from algoliasearch.search.client import SearchClientSync

from algoliasearch.search.models.browse_response import BrowseResponse
from algoliasearch.search.models.index_settings import IndexSettings


def _get_image_labels(image_url, object_id, score_limit):
    # Implement your image classification logic here
    return {"objectID": "", "imageURL": "", "objects": []}


_client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")


records = []


def _aggregator(res: BrowseResponse):
    for hit in res.hits:
        props = hit.to_dict()
        image_url = props["imageURL"]
        records.append(_get_image_labels(image_url, hit.object_id, 0.5))


_client.browse_objects("<YOUR_INDEX_NAME>", aggregator=_aggregator)

_client.partial_update_objects(
    index_name="<YOUR_INDEX_NAME>",
    objects=records,
    create_if_not_exists=True,
)

facets = []
attributes = []

for record in records:
    for obj in record["objects"]:
        for key, values in obj.items():
            if isinstance(values, list):
                facets.extend(
                    [
                        f"searchable(objects.{key}.label)",
                        f"searchable(objects.{key}.score)",
                    ]
                )
                attributes.append(f"objects.{key}.label)")

current_settings = _client.get_settings(
    index_name="<YOUR_INDEX_NAME>",
)

settings = IndexSettings(
    searchable_attributes=(current_settings.searchable_attributes or []) + attributes,
    attributes_for_faceting=(current_settings.attributes_for_faceting or []) + facets,
)

_client.set_settings(
    index_name="<YOUR_INDEX_NAME>",
    index_settings=settings,
)
