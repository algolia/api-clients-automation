import type { EchoResponse, RequestOptions } from '@algolia/client-common';
import { ingestionClient } from '@algolia/ingestion';
import { echoRequester } from '@algolia/requester-node-http';
import * as dotenv from 'dotenv';

import { union } from '../helpers';

dotenv.config({ path: '../../.env' });

const appId = process.env.ALGOLIA_APPLICATION_ID || 'test_app_id';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || 'test_api_key';

const client = ingestionClient(appId, apiKey, 'us', {
  requester: echoRequester(),
});

if (!process.env.ALGOLIA_APPLICATION_ID) {
  throw new Error(
    'please provide an `ALGOLIA_APPLICATION_ID` env var for e2e tests'
  );
}

if (!process.env.ALGOLIA_ADMIN_KEY) {
  throw new Error(
    'please provide an `ALGOLIA_ADMIN_KEY` env var for e2e tests'
  );
}

const e2eClient = ingestionClient(
  process.env.ALGOLIA_APPLICATION_ID,
  process.env.ALGOLIA_ADMIN_KEY,
  'us'
);

describe('createAuthentication', () => {
  test('createAuthenticationOAuth', async () => {
    const req = (await client.createAuthentication({
      type: 'oauth',
      name: 'authName',
      input: {
        url: 'http://test.oauth',
        client_id: 'myID',
        client_secret: 'mySecret',
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/authentications');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      type: 'oauth',
      name: 'authName',
      input: {
        url: 'http://test.oauth',
        client_id: 'myID',
        client_secret: 'mySecret',
      },
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('createAuthenticationAlgolia', async () => {
    const req = (await client.createAuthentication({
      type: 'algolia',
      name: 'authName',
      input: { appID: 'myappID', apiKey: 'randomApiKey' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/authentications');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      type: 'algolia',
      name: 'authName',
      input: { appID: 'myappID', apiKey: 'randomApiKey' },
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('createDestination', () => {
  test('createDestination', async () => {
    const req = (await client.createDestination({
      type: 'search',
      name: 'destinationName',
      input: { indexPrefix: 'prefix_' },
      authenticationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/destinations');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      type: 'search',
      name: 'destinationName',
      input: { indexPrefix: 'prefix_' },
      authenticationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('createSource', () => {
  test('createSource', async () => {
    const req = (await client.createSource({
      type: 'commercetools',
      name: 'sourceName',
      input: {
        storeKeys: ['myStore'],
        locales: ['de'],
        url: 'http://commercetools.com',
        projectKey: 'keyID',
      },
      authenticationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/sources');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      type: 'commercetools',
      name: 'sourceName',
      input: {
        storeKeys: ['myStore'],
        locales: ['de'],
        url: 'http://commercetools.com',
        projectKey: 'keyID',
      },
      authenticationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('createTask', () => {
  test('createTaskOnDemand', async () => {
    const req = (await client.createTask({
      sourceID: 'search',
      destinationID: 'destinationName',
      trigger: { type: 'onDemand' },
      action: 'replace',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/tasks');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      sourceID: 'search',
      destinationID: 'destinationName',
      trigger: { type: 'onDemand' },
      action: 'replace',
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('createTaskSchedule', async () => {
    const req = (await client.createTask({
      sourceID: 'search',
      destinationID: 'destinationName',
      trigger: { type: 'schedule', cron: '* * * * *' },
      action: 'replace',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/tasks');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      sourceID: 'search',
      destinationID: 'destinationName',
      trigger: { type: 'schedule', cron: '* * * * *' },
      action: 'replace',
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('createTaskSubscription', async () => {
    const req = (await client.createTask({
      sourceID: 'search',
      destinationID: 'destinationName',
      trigger: { type: 'onDemand' },
      action: 'replace',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/tasks');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      sourceID: 'search',
      destinationID: 'destinationName',
      trigger: { type: 'onDemand' },
      action: 'replace',
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('customDelete', () => {
  test('allow del method for a custom path with minimal parameters', async () => {
    const req = (await client.customDelete({
      path: '/test/minimal',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/minimal');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allow del method for a custom path with all parameters', async () => {
    const req = (await client.customDelete({
      path: '/test/all',
      parameters: { query: 'parameters' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/all');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
  });
});

describe('customGet', () => {
  test('allow get method for a custom path with minimal parameters', async () => {
    const req = (await client.customGet({
      path: '/test/minimal',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/minimal');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allow get method for a custom path with all parameters', async () => {
    const req = (await client.customGet({
      path: '/test/all',
      parameters: { query: 'parameters with space' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/all');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      query: 'parameters%20with%20space',
    });
  });

  test('requestOptions should be escaped too', async () => {
    const requestOptions: RequestOptions = {
      queryParameters: {
        query: 'parameters with space',
        'and an array': ['array', 'with spaces'],
      },
      headers: { 'x-header-1': 'spaces are left alone' },
    };

    const req = (await client.customGet(
      { path: '/test/all', parameters: { query: 'to be overriden' } },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/all');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      query: 'parameters%20with%20space',
      'and%20an%20array': 'array%2Cwith%20spaces',
    });
    expect(req.headers).toEqual(
      expect.objectContaining({ 'x-header-1': 'spaces are left alone' })
    );
  });
});

describe('customPost', () => {
  test('allow post method for a custom path with minimal parameters', async () => {
    const req = (await client.customPost({
      path: '/test/minimal',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/minimal');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({});
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allow post method for a custom path with all parameters', async () => {
    const req = (await client.customPost({
      path: '/test/all',
      parameters: { query: 'parameters' },
      body: { body: 'parameters' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/all');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ body: 'parameters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
  });

  test('requestOptions can override default query parameters', async () => {
    const requestOptions: RequestOptions = {
      queryParameters: { query: 'myQueryParameter' },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'myQueryParameter' });
  });

  test('requestOptions merges query parameters with default ones', async () => {
    const requestOptions: RequestOptions = {
      queryParameters: { query2: 'myQueryParameter' },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({
      query: 'parameters',
      query2: 'myQueryParameter',
    });
  });

  test('requestOptions can override default headers', async () => {
    const requestOptions: RequestOptions = {
      headers: { 'x-algolia-api-key': 'myApiKey' },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
    expect(req.headers).toEqual(
      expect.objectContaining({ 'x-algolia-api-key': 'myApiKey' })
    );
  });

  test('requestOptions merges headers with default ones', async () => {
    const requestOptions: RequestOptions = {
      headers: { 'x-algolia-api-key': 'myApiKey' },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
    expect(req.headers).toEqual(
      expect.objectContaining({ 'x-algolia-api-key': 'myApiKey' })
    );
  });

  test('requestOptions queryParameters accepts booleans', async () => {
    const requestOptions: RequestOptions = {
      queryParameters: { isItWorking: true },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({
      query: 'parameters',
      isItWorking: 'true',
    });
  });

  test('requestOptions queryParameters accepts integers', async () => {
    const requestOptions: RequestOptions = {
      queryParameters: { myParam: 2 },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({
      query: 'parameters',
      myParam: '2',
    });
  });

  test('requestOptions queryParameters accepts list of string', async () => {
    const requestOptions: RequestOptions = {
      queryParameters: { myParam: ['b and c', 'd'] },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({
      query: 'parameters',
      myParam: 'b%20and%20c%2Cd',
    });
  });

  test('requestOptions queryParameters accepts list of booleans', async () => {
    const requestOptions: RequestOptions = {
      queryParameters: { myParam: [true, true, false] },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({
      query: 'parameters',
      myParam: 'true%2Ctrue%2Cfalse',
    });
  });

  test('requestOptions queryParameters accepts list of integers', async () => {
    const requestOptions: RequestOptions = {
      queryParameters: { myParam: [1, 2] },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({
      query: 'parameters',
      myParam: '1%2C2',
    });
  });
});

describe('customPut', () => {
  test('allow put method for a custom path with minimal parameters', async () => {
    const req = (await client.customPut({
      path: '/test/minimal',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/minimal');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({});
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allow put method for a custom path with all parameters', async () => {
    const req = (await client.customPut({
      path: '/test/all',
      parameters: { query: 'parameters' },
      body: { body: 'parameters' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/all');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({ body: 'parameters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
  });
});

describe('deleteAuthentication', () => {
  test('deleteAuthentication', async () => {
    const req = (await client.deleteAuthentication({
      authenticationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual(
      '/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f'
    );
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('deleteDestination', () => {
  test('deleteDestination', async () => {
    const req = (await client.deleteDestination({
      destinationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual(
      '/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f'
    );
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('deleteSource', () => {
  test('deleteSource', async () => {
    const req = (await client.deleteSource({
      sourceID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('deleteTask', () => {
  test('deleteTask', async () => {
    const req = (await client.deleteTask({
      taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('disableTask', () => {
  test('disableTask', async () => {
    const req = (await client.disableTask({
      taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual(
      '/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/disable'
    );
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('enableTask', () => {
  test('enable task e2e', async () => {
    const req = (await client.enableTask({
      taskID: '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual(
      '/1/tasks/76ab4c2a-ce17-496f-b7a6-506dc59ee498/enable'
    );
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);

    const resp = await e2eClient.enableTask({
      taskID: '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
    });

    const expectedBody = { taskID: '76ab4c2a-ce17-496f-b7a6-506dc59ee498' };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});

describe('getAuthentication', () => {
  test('getAuthentication', async () => {
    const req = (await client.getAuthentication({
      authenticationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual(
      '/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f'
    );
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getAuthentications', () => {
  test('getAuthentications', async () => {
    const req = (await client.getAuthentications()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/authentications');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('getAuthentications with query params', async () => {
    const req = (await client.getAuthentications({
      itemsPerPage: 10,
      page: 1,
      type: ['basic', 'algolia'],
      platform: ['none'],
      sort: 'createdAt',
      order: 'desc',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/authentications');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      itemsPerPage: '10',
      page: '1',
      type: 'basic%2Calgolia',
      platform: 'none',
      sort: 'createdAt',
      order: 'desc',
    });

    const resp = await e2eClient.getAuthentications({
      itemsPerPage: 10,
      page: 1,
      type: ['basic', 'algolia'],
      platform: ['none'],
      sort: 'createdAt',
      order: 'desc',
    });

    const expectedBody = {
      pagination: { page: 1, itemsPerPage: 10 },
      authentications: [
        {
          authenticationID: 'b57a7ea5-8592-493b-b75b-6c66d77aee7f',
          type: 'algolia',
          name: 'Auto-generated Authentication for T8JK9S7I7X - 1704732447751',
          input: {},
          createdAt: '2024-01-08T16:47:31Z',
          updatedAt: '2024-01-08T16:47:31Z',
        },
        {},
        {},
        {},
        {},
        {},
        {},
        {},
      ],
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});

describe('getDestination', () => {
  test('getDestination', async () => {
    const req = (await client.getDestination({
      destinationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual(
      '/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f'
    );
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getDestinations', () => {
  test('getDestinations', async () => {
    const req = (await client.getDestinations()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/destinations');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getDockerSourceStreams', () => {
  test('getDockerSourceStreams', async () => {
    const req = (await client.getDockerSourceStreams({
      sourceID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual(
      '/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover'
    );
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getEvent', () => {
  test('getEvent', async () => {
    const req = (await client.getEvent({
      runID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
      eventID: '6c02aeb1-775e-418e-870b-1faccd4b2c0c',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual(
      '/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events/6c02aeb1-775e-418e-870b-1faccd4b2c0c'
    );
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getEvents', () => {
  test('getEvents', async () => {
    const req = (await client.getEvents({
      runID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual(
      '/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events'
    );
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getRun', () => {
  test('getRun', async () => {
    const req = (await client.getRun({
      runID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getRuns', () => {
  test('getRuns', async () => {
    const req = (await client.getRuns()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/runs');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getSource', () => {
  test('getSource', async () => {
    const req = (await client.getSource({
      sourceID: '75eeb306-51d3-4e5e-a279-3c92bd8893ac',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/sources/75eeb306-51d3-4e5e-a279-3c92bd8893ac');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);

    const resp = await e2eClient.getSource({
      sourceID: '75eeb306-51d3-4e5e-a279-3c92bd8893ac',
    });

    const expectedBody = {
      sourceID: '75eeb306-51d3-4e5e-a279-3c92bd8893ac',
      name: 'cts_e2e_browse',
      type: 'json',
      input: {
        url: 'https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json',
      },
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});

describe('getSources', () => {
  test('getSources', async () => {
    const req = (await client.getSources()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/sources');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getTask', () => {
  test('getTask', async () => {
    const req = (await client.getTask({
      taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getTasks', () => {
  test('getTasks', async () => {
    const req = (await client.getTasks()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/tasks');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('runTask', () => {
  test('runTask', async () => {
    const req = (await client.runTask({
      taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual(
      '/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/run'
    );
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('searchAuthentications', () => {
  test('searchAuthentications', async () => {
    const req = (await client.searchAuthentications({
      authenticationIDs: [
        '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/authentications/search');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      authenticationIDs: [
        '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('searchDestinations', () => {
  test('searchDestinations', async () => {
    const req = (await client.searchDestinations({
      destinationIDs: [
        '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/destinations/search');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      destinationIDs: [
        '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('searchSources', () => {
  test('searchSources', async () => {
    const req = (await client.searchSources({
      sourceIDs: [
        '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/sources/search');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      sourceIDs: [
        '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('searchTasks', () => {
  test('searchTasks', async () => {
    const req = (await client.searchTasks({
      taskIDs: [
        '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
        '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/tasks/search');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      taskIDs: [
        '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
        '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);

    const resp = await e2eClient.searchTasks({
      taskIDs: [
        '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
        '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
      ],
    });

    const expectedBody = [
      {
        taskID: '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
        sourceID: '75eeb306-51d3-4e5e-a279-3c92bd8893ac',
        destinationID: '506d79fa-e29d-4bcf-907c-6b6a41172153',
        trigger: { type: 'onDemand' },
        enabled: true,
        failureThreshold: 0,
        action: 'replace',
        createdAt: '2024-01-08T16:47:41Z',
      },
    ];

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});

describe('triggerDockerSourceDiscover', () => {
  test('triggerDockerSourceDiscover', async () => {
    const req = (await client.triggerDockerSourceDiscover({
      sourceID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual(
      '/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover'
    );
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('updateAuthentication', () => {
  test('updateAuthentication', async () => {
    const req = (await client.updateAuthentication({
      authenticationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
      authenticationUpdate: { name: 'newName' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual(
      '/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f'
    );
    expect(req.method).toEqual('PATCH');
    expect(req.data).toEqual({ name: 'newName' });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('updateDestination', () => {
  test('updateDestination', async () => {
    const req = (await client.updateDestination({
      destinationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
      destinationUpdate: { name: 'newName' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual(
      '/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f'
    );
    expect(req.method).toEqual('PATCH');
    expect(req.data).toEqual({ name: 'newName' });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('updateSource', () => {
  test('updateSource', async () => {
    const req = (await client.updateSource({
      sourceID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
      sourceUpdate: { name: 'newName' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f');
    expect(req.method).toEqual('PATCH');
    expect(req.data).toEqual({ name: 'newName' });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('updateTask', () => {
  test('updateTask', async () => {
    const req = (await client.updateTask({
      taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
      taskUpdate: { enabled: false },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f');
    expect(req.method).toEqual('PATCH');
    expect(req.data).toEqual({ enabled: false });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});
