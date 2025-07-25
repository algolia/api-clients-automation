// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
import { describe, expect, test } from 'vitest';

import { union } from '../helpers.js';

import { algoliasearch } from 'algoliasearch';

if (!process.env.ALGOLIA_APPLICATION_ID) {
  throw new Error('please provide an `ALGOLIA_APPLICATION_ID` env var for e2e tests');
}

if (!process.env.ALGOLIA_ADMIN_KEY) {
  throw new Error('please provide an `ALGOLIA_ADMIN_KEY` env var for e2e tests');
}

const client = algoliasearch(process.env.ALGOLIA_APPLICATION_ID, process.env.ALGOLIA_ADMIN_KEY).initAbtesting({
  region: 'us',
});

describe('listABTests', () => {
  test('listABTests with parameters', async () => {
    const resp = await client.listABTests({ offset: 0, limit: 21, indexPrefix: 'cts_e2e ab', indexSuffix: 't' });

    const expectedBody = {
      abtests: [
        {
          abTestID: 85635,
          createdAt: '2024-05-13T10:12:27.739233Z',
          endAt: '2124-05-13T00:00:00Z',
          name: 'cts_e2e_abtest',
          status: 'active',
          variants: [
            {
              addToCartCount: 0,
              clickCount: 0,
              conversionCount: 0,
              description: 'this abtest is used for api client automation tests and will expire in 2124',
              index: 'cts_e2e_search_facet',
              purchaseCount: 0,
              trafficPercentage: 25,
            },
            {
              addToCartCount: 0,
              clickCount: 0,
              conversionCount: 0,
              description: '',
              index: 'cts_e2e abtest',
              purchaseCount: 0,
              trafficPercentage: 75,
            },
          ],
        },
      ],
      count: 1,
      total: 1,
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});
