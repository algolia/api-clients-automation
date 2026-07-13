import { algoliasearch } from 'algoliasearch';

import { buildTimeline } from './gitHistory.ts';
import { transform } from './transform.ts';
import { buildVersionRanges } from './versionRanges.ts';

// Build the snippet + catalog records from git history and push them to Algolia.
// Pass --dry-run (or DRY_RUN=true) to run the whole pipeline and print what would be pushed, without pushing.
// SINCE_DATE=YYYY-MM-DD skips tags before that date — the escape hatch if a backport tag
// makes buildVersionRanges throw on a backwards version.

const SNIPPETS_INDEX = process.env.SNIPPETS_INDEX_NAME ?? 'api_clients_snippets_mcp';
const CATALOG_INDEX = process.env.CATALOG_INDEX_NAME ?? 'api_clients_catalog_mcp';

const snippetsSettings = {
  searchableAttributes: ['operationId'],
  attributesForFaceting: [
    'filterOnly(api)',
    'filterOnly(operationId)',
    'filterOnly(language)',
    'filterOnly(variant)',
    'filterOnly(isCurrent)',
  ],
  // Version matching happens in the MCP reader on the versionFrom/versionTo strings; no
  // numeric filtering is used. versionFromNum only feeds customRanking, so that a query
  // hitting the reader's page cap truncates the oldest eras, never the current ones.
  numericAttributesForFiltering: [],
  customRanking: ['desc(versionFromNum)'],
};

const catalogSettings = {
  searchableAttributes: ['title', 'operationId', 'description'],
  attributesForFaceting: ['filterOnly(api)', 'filterOnly(languages)'],
};

async function main(): Promise<void> {
  const dryRun = process.argv.slice(2).includes('--dry-run') || process.env.DRY_RUN === 'true';

  const ranges = buildVersionRanges(await buildTimeline({ sinceDate: process.env.SINCE_DATE }));
  const { snippets, catalog } = await transform(ranges);

  console.log(`snippets: ${snippets.length} -> ${SNIPPETS_INDEX}`);
  console.log(`catalog:  ${catalog.length} -> ${CATALOG_INDEX}`);

  if (dryRun) {
    console.log('dry run — nothing pushed');
    return;
  }

  const appId = process.env.SNIPPETS_ALGOLIA_APP_ID;
  const apiKey = process.env.SNIPPETS_ALGOLIA_API_KEY;
  if (!appId || !apiKey) {
    throw new Error('set SNIPPETS_ALGOLIA_APP_ID and SNIPPETS_ALGOLIA_API_KEY to push');
  }

  const client = algoliasearch(appId, apiKey);
  await client.setSettings({ indexName: SNIPPETS_INDEX, indexSettings: snippetsSettings });
  await client.setSettings({ indexName: CATALOG_INDEX, indexSettings: catalogSettings });
  await client.replaceAllObjects({ indexName: SNIPPETS_INDEX, objects: snippets });
  await client.replaceAllObjects({ indexName: CATALOG_INDEX, objects: catalog });
  console.log('pushed');
}

if (import.meta.url.endsWith(process.argv[1])) {
  await main();
}
