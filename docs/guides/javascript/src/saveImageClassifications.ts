import { algoliasearch } from 'algoliasearch';

interface Image extends Record<string, unknown> {
  imageURL: string;
  objectID: string;
  objects: Record<string, unknown>[];
}

async function saveImageClassifications() {
  // Retrieve labels
  function getImageLabels(imageURL, objectID, scoreLimit): Image {
    // Implement your image classification logic here
    return { imageURL: '', objectID: '', objects: [] };
  }

  // API key ACL should include editSettings / addObject
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  const records: Image[] = [];

  await client.browseObjects<Image>({
    indexName: '<YOUR_INDEX_NAME>',
    browseParams: undefined,
    aggregator: (browseResponse) => {
      records.push(
        ...browseResponse.hits.map((hit) => {
          return getImageLabels(hit.imageURL, hit.objectID, 0.5);
        }),
      );
    },
  });

  // Update records with image classifications
  await client.partialUpdateObjects({ indexName: 'products', objects: records, createIfNotExists: true });
}
