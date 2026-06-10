import { algoliasearch } from 'algoliasearch';

// Initialize the client with gzip compression enabled
// Compression reduces the size of request bodies sent to Algolia
const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', {
  compression: 'gzip',
});

// Search with compressed request body
const searchCompression = async () => {
  const result = await client.searchSingleIndex({ indexName: 'movies_index', searchParams: { query: 'comedy' } });
  console.log(result.hits);
};

searchCompression()
  .then(() => console.log('Done!'))
  .catch((err) => console.error(err));
