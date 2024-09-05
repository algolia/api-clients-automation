// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
import { insightsClient } from '@algolia/client-insights';
import * as dotenv from 'dotenv';

import { union } from '../helpers';

dotenv.config({ path: '../../.env' });

if (!process.env.ALGOLIA_APPLICATION_ID) {
  throw new Error('please provide an `ALGOLIA_APPLICATION_ID` env var for e2e tests');
}

if (!process.env.ALGOLIA_ADMIN_KEY) {
  throw new Error('please provide an `ALGOLIA_ADMIN_KEY` env var for e2e tests');
}

const client = insightsClient(process.env.ALGOLIA_APPLICATION_ID, process.env.ALGOLIA_ADMIN_KEY, 'us');

describe('pushEvents', () => {
  test('Many events type', async () => {
    const resp = await client.pushEvents({
      events: [
        {
          eventType: 'conversion',
          eventName: 'Product Purchased',
          index: 'products',
          userToken: 'user-123456',
          authenticatedUserToken: 'user-123456',
          timestamp: 1725494400000,
          objectIDs: ['9780545139700', '9780439784542'],
          queryID: '43b15df305339e827f0ac0bdc5ebcaa7',
        },
        {
          eventType: 'view',
          eventName: 'Product Detail Page Viewed',
          index: 'products',
          userToken: 'user-123456',
          authenticatedUserToken: 'user-123456',
          timestamp: 1725494400000,
          objectIDs: ['9780545139700', '9780439784542'],
        },
      ],
    });

    const expectedBody = { message: 'OK', status: 200 };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});
