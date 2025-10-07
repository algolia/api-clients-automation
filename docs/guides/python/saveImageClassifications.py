from algoliasearch.search.client import SearchClientSync

from algoliasearch.search.models.browse_response import BrowseResponse


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
