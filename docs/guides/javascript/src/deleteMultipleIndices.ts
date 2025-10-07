import { algoliasearch } from 'algoliasearch';

import type { MultipleBatchRequest } from 'algoliasearch';

// You need an API key with `deleteIndex`
const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

// List all indices
const indices = await client.listIndices();

// Primary indices don't have a `primary` key
const primaryIndices = indices.items.filter((item) => item.primary == null);
const replicaIndices = indices.items.filter((item) => item.primary != null);

// Delete primary indices first
if (primaryIndices.length > 0) {
  const requests: MultipleBatchRequest[] = primaryIndices.map((index) => ({
    action: 'delete',
    indexName: index.name,
  }));
  await client.multipleBatch({ requests: requests });
  console.log('Deleted primary indices.');
}

// Now, delete replica indices
if (replicaIndices.length > 0) {
  const requests: MultipleBatchRequest[] = replicaIndices.map((index) => ({
    action: 'delete',
    indexName: index.name,
  }));
  await client.multipleBatch({ requests: requests });
  console.log('Deleted replica indices.');
}
