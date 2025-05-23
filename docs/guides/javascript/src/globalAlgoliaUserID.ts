import { algoliasearch } from 'algoliasearch';

const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', {
  baseHeaders: {
    'X-Algolia-User-ID': 'test-user-123',
  },
});
console.log(client);
