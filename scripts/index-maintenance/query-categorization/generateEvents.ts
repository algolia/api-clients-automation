import { randomUUID } from 'node:crypto';

import { insightsClient } from '@algolia/client-insights';
import { algoliasearch } from 'algoliasearch';

import { QUERIES } from './setupIndex.ts';

const APP_ID = requireEnv('ALGOLIA_APPLICATION_ID');
const ADMIN_KEY = requireEnv('ALGOLIA_ADMIN_KEY');
const INDEX = process.env.QC_INDEX ?? 'cts_e2e_query_categorization';

const ITERATIONS = 100;
const CONVERSION_RATE = 0.25;
const QUERIES_MIN = 3;
const QUERIES_MAX = 15;
const EVENTS_PER_QUERY = 5;
const HITS_PER_QUERY = 20;
const BATCH_SIZE = 1000;

function requireEnv(name: string): string {
  const v = process.env[name];
  if (!v) throw new Error(`missing required env var ${name}`);
  return v;
}

function randomInt(min: number, max: number): number {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

function pick(n: number, k: number): number[] {
  return [...Array(n).keys()].sort(() => Math.random() - 0.5).slice(0, k);
}

export async function generateEvents(): Promise<void> {
  const client = algoliasearch(APP_ID, ADMIN_KEY);
  const insights = insightsClient(APP_ID, ADMIN_KEY);
  const events: Record<string, unknown>[] = [];

  for (let iteration = 0; iteration < ITERATIONS; iteration++) {
    if ((iteration + 1) % 10 === 0) {
      console.log(
        `session ${iteration + 1} of ${ITERATIONS} — ${events.length} click+conversion events generated so far`,
      );
    }
    const userToken = randomUUID();
    const sessionQueries = pick(QUERIES.length, randomInt(QUERIES_MIN, QUERIES_MAX)).map((i) => QUERIES[i]);

    for (const query of sessionQueries) {
      const resp = await client.searchSingleIndex({
        indexName: INDEX,
        searchParams: { query, clickAnalytics: true, hitsPerPage: HITS_PER_QUERY, userToken },
      });
      const hits = (resp.hits ?? []) as Array<{ objectID: string }>;
      const queryID = (resp as { queryID?: string }).queryID;

      if (hits.length < EVENTS_PER_QUERY) {
        throw new Error(`query '${query}' returned ${hits.length} hits; need ≥${EVENTS_PER_QUERY}`);
      }
      if (!queryID) {
        throw new Error(`query '${query}' returned no queryID — is clickAnalytics enabled?`);
      }

      for (const idx of pick(hits.length, EVENTS_PER_QUERY)) {
        const clickTs = Date.now() - randomInt(0, 500);
        events.push({
          eventType: 'click',
          eventName: 'product-clicked',
          index: INDEX,
          userToken,
          queryID,
          objectIDs: [hits[idx].objectID],
          positions: [idx + 1],
          timestamp: clickTs,
        });
        if (Math.random() < CONVERSION_RATE) {
          events.push({
            eventType: 'conversion',
            eventName: 'product-purchased',
            index: INDEX,
            userToken,
            queryID,
            objectIDs: [hits[idx].objectID],
            timestamp: clickTs + randomInt(1, 100),
          });
        }
      }
    }
  }

  for (let i = 0; i < events.length; i += BATCH_SIZE) {
    await insights.pushEvents({ events: events.slice(i, i + BATCH_SIZE) as never });
  }
  console.log(`Sent ${events.length} click+conversion events on '${INDEX}' across ${ITERATIONS} sessions.`);
}

if (import.meta.url.endsWith(process.argv[1])) {
  await generateEvents();
}
