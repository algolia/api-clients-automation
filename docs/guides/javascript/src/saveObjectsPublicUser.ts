import { algoliasearch } from 'algoliasearch';

const playlists: Record<string, any>[] = []; // Your records

try {
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  await client.saveObjects(
    { indexName: 'indexName', objects: playlists, waitForTasks: false, batchSize: 1000 },
    {
      headers: { 'X-Algolia-User-ID': '*' },
    },
  );
} catch (e) {
  console.error(e);
}
