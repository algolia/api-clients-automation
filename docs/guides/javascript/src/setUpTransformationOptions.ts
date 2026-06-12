import { algoliasearch } from 'algoliasearch';

// Set `transformationOptions` with your transformation region to use the `*WithTransformation` helper methods.
// Replace 'us' with 'eu' if your Algolia application uses the Europe analytics region.
const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', {
  transformationOptions: { region: 'us' },
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
