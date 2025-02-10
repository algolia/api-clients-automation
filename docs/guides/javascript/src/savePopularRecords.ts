import { algoliasearch } from 'algoliasearch';

try {
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  const records: Array<Record<string, any>> = [];

  await client.browseObjects<Record<string, any>>({
    indexName: '<YOUR_INDEX_NAME>',
    browseParams: undefined,
    aggregator: (res) =>
      records.push(
        res.hits.map((record) => ({
          ...record,
          isPopular: record.nbFollowers >= 1_000_000,
        })),
      ),
  });

  await client.saveObjects({ indexName: 'indexName', objects: records });
} catch (e) {
  console.error(e);
}
