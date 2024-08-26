// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
import { abtestingClient } from '@algolia/client-abtesting';
import type { EchoResponse } from '@algolia/client-common';
import { echoRequester } from '@algolia/requester-node-http';

const appId = process.env.ALGOLIA_APPLICATION_ID || 'test_app_id';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || 'test_api_key';

const client = abtestingClient(appId, apiKey, 'us', { requester: echoRequester() });

describe('addABTests', () => {
  test('addABTests with minimal parameters', async () => {
    const req = (await client.addABTests({
      endAt: '2022-12-31T00:00:00.000Z',
      name: 'myABTest',
      variants: [
        { index: 'AB_TEST_1', trafficPercentage: 30 },
        { index: 'AB_TEST_2', trafficPercentage: 50 },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/abtests');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      endAt: '2022-12-31T00:00:00.000Z',
      name: 'myABTest',
      variants: [
        { index: 'AB_TEST_1', trafficPercentage: 30 },
        { index: 'AB_TEST_2', trafficPercentage: 50 },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('customDelete', () => {
  test('allow del method for a custom path with minimal parameters', async () => {
    const req = (await client.customDelete({ path: 'test/minimal' })) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/minimal');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allow del method for a custom path with all parameters', async () => {
    const req = (await client.customDelete({
      path: 'test/all',
      parameters: { query: 'parameters' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/all');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
  });
});

describe('customGet', () => {
  test('allow get method for a custom path with minimal parameters', async () => {
    const req = (await client.customGet({ path: 'test/minimal' })) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/minimal');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allow get method for a custom path with all parameters', async () => {
    const req = (await client.customGet({
      path: 'test/all',
      parameters: { query: 'parameters with space' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/all');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ query: 'parameters%20with%20space' });
  });

  test('requestOptions should be escaped too', async () => {
    const req = (await client.customGet(
      { path: 'test/all', parameters: { query: 'to be overriden' } },
      {
        queryParameters: { query: 'parameters with space', 'and an array': ['array', 'with spaces'] },
        headers: { 'x-header-1': 'spaces are left alone' },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/all');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      query: 'parameters%20with%20space',
      'and%20an%20array': 'array%2Cwith%20spaces',
    });
    expect(req.headers).toEqual(expect.objectContaining({ 'x-header-1': 'spaces are left alone' }));
  });
});

describe('customPost', () => {
  test('allow post method for a custom path with minimal parameters', async () => {
    const req = (await client.customPost({ path: 'test/minimal' })) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/minimal');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({});
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allow post method for a custom path with all parameters', async () => {
    const req = (await client.customPost({
      path: 'test/all',
      parameters: { query: 'parameters' },
      body: { body: 'parameters' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/all');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ body: 'parameters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
  });

  test('requestOptions can override default query parameters', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        queryParameters: { query: 'myQueryParameter' },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'myQueryParameter' });
  });

  test('requestOptions merges query parameters with default ones', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        queryParameters: { query2: 'myQueryParameter' },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters', query2: 'myQueryParameter' });
  });

  test('requestOptions can override default headers', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        headers: { 'x-algolia-api-key': 'myApiKey' },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
    expect(req.headers).toEqual(expect.objectContaining({ 'x-algolia-api-key': 'myApiKey' }));
  });

  test('requestOptions merges headers with default ones', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        headers: { 'x-algolia-api-key': 'myApiKey' },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
    expect(req.headers).toEqual(expect.objectContaining({ 'x-algolia-api-key': 'myApiKey' }));
  });

  test('requestOptions queryParameters accepts booleans', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        queryParameters: { isItWorking: true },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters', isItWorking: 'true' });
  });

  test('requestOptions queryParameters accepts integers', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        queryParameters: { myParam: 2 },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters', myParam: '2' });
  });

  test('requestOptions queryParameters accepts list of string', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        queryParameters: { myParam: ['b and c', 'd'] },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters', myParam: 'b%20and%20c%2Cd' });
  });

  test('requestOptions queryParameters accepts list of booleans', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        queryParameters: { myParam: [true, true, false] },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters', myParam: 'true%2Ctrue%2Cfalse' });
  });

  test('requestOptions queryParameters accepts list of integers', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        queryParameters: { myParam: [1, 2] },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters', myParam: '1%2C2' });
  });
});

describe('customPut', () => {
  test('allow put method for a custom path with minimal parameters', async () => {
    const req = (await client.customPut({ path: 'test/minimal' })) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/minimal');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({});
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allow put method for a custom path with all parameters', async () => {
    const req = (await client.customPut({
      path: 'test/all',
      parameters: { query: 'parameters' },
      body: { body: 'parameters' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/all');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({ body: 'parameters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
  });
});

describe('deleteABTest', () => {
  test('deleteABTest', async () => {
    const req = (await client.deleteABTest({ id: 42 })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/abtests/42');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getABTest', () => {
  test('getABTest', async () => {
    const req = (await client.getABTest({ id: 42 })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/abtests/42');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('listABTests', () => {
  test('listABTests with minimal parameters', async () => {
    const req = (await client.listABTests()) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/abtests');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('listABTests with parameters', async () => {
    const req = (await client.listABTests({
      offset: 0,
      limit: 21,
      indexPrefix: 'cts_e2e ab',
      indexSuffix: 't',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/abtests');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ offset: '0', limit: '21', indexPrefix: 'cts_e2e%20ab', indexSuffix: 't' });
  });
});

describe('scheduleABTest', () => {
  test('scheduleABTest with minimal parameters', async () => {
    const req = (await client.scheduleABTest({
      endAt: '2022-12-31T00:00:00.000Z',
      scheduledAt: '2022-11-31T00:00:00.000Z',
      name: 'myABTest',
      variants: [
        { index: 'AB_TEST_1', trafficPercentage: 30 },
        { index: 'AB_TEST_2', trafficPercentage: 50 },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/abtests/schedule');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      endAt: '2022-12-31T00:00:00.000Z',
      scheduledAt: '2022-11-31T00:00:00.000Z',
      name: 'myABTest',
      variants: [
        { index: 'AB_TEST_1', trafficPercentage: 30 },
        { index: 'AB_TEST_2', trafficPercentage: 50 },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('stopABTest', () => {
  test('stopABTest', async () => {
    const req = (await client.stopABTest({ id: 42 })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/abtests/42/stop');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});
