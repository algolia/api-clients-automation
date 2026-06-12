import { algoliasearch } from 'algoliasearch';

// Override the Ingestion API defaults. Any option you don't set keeps its default.
// Replace 'us' with 'eu' if your Algolia application uses the Europe analytics region.
const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', {
  transformationOptions: {
    region: 'us',
    timeouts: { connect: 5000, read: 30000, write: 30000 },
  },
});

async function run() {
  // Save records, transforming them through the Push connector
  const response = await client.saveObjectsWithTransformation({
    indexName: '<YOUR_INDEX_NAME>',
    objects: [
      { objectID: '1', name: 'Adam' },
      { objectID: '2', name: 'Benoit' },
    ],
    waitForTasks: true,
  });
  console.log(response);
}

run().catch((err) => console.error(err));
