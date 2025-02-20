import { algoliasearch } from 'algoliasearch';

const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

// @ts-ignore
const { default: records } = await import('./actors.json');

const chunkSize = 10000;

for (let beginIndex = 0; beginIndex < records.length; beginIndex += chunkSize) {
  try {
    const chunk = records.slice(beginIndex, beginIndex + chunkSize);
    await client.saveObjects({ indexName: 'actors', objects: chunk });
  } catch (e: any) {
    console.error(e);
  }
}
