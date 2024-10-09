import { searchClient } from '@algolia/client-search';

const client = searchClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

// Fetch and index objects in Algolia
const processRecords = async () => {
  const datasetRequest = await fetch('https://dashboard.algolia.com/sample_datasets/movie.json');
  const movies = await datasetRequest.json();
  return await client.saveObjects({ indexName: 'movies_index', objects: movies });
};

processRecords()
  .then(() => console.log('Successfully indexed objects!'))
  .catch((err) => console.error(err));
