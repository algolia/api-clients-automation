import { analyticsClient } from '@algolia/client-analytics';
import type { EchoResponse, RequestOptions } from '@algolia/client-common';
import { echoRequester } from '@algolia/requester-node-http';
import * as dotenv from 'dotenv';

import { union } from '../helpers';

dotenv.config({ path: '../../.env' });

const appId = process.env.ALGOLIA_APPLICATION_ID || 'test_app_id';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || 'test_api_key';

const client = analyticsClient(appId, apiKey, 'us', {
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

const e2eClient = analyticsClient(
  process.env.ALGOLIA_APPLICATION_ID,
  process.env.ALGOLIA_ADMIN_KEY,
  'us'
);

describe('customDelete', () => {
  test('allow del method for a custom path with minimal parameters', async () => {
    const req = (await client.customDelete({
      path: 'test/minimal',
    })) as unknown as EchoResponse;

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
    const req = (await client.customGet({
      path: 'test/minimal',
    })) as unknown as EchoResponse;

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
      { path: 'test/all', parameters: { query: 'to be overriden' } },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/all');
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
      path: 'test/minimal',
    })) as unknown as EchoResponse;

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
    const requestOptions: RequestOptions = {
      queryParameters: { query: 'myQueryParameter' },
    };

    const req = (await client.customPost(
      {
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
      path: 'test/minimal',
    })) as unknown as EchoResponse;

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

describe('getAddToCartRate', () => {
  test('get getAddToCartRate with minimal parameters', async () => {
    const req = (await client.getAddToCartRate({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/conversions/addToCartRate');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getAddToCartRate with all parameters', async () => {
    const req = (await client.getAddToCartRate({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/conversions/addToCartRate');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    });
  });
});

describe('getAverageClickPosition', () => {
  test('get getAverageClickPosition with minimal parameters', async () => {
    const req = (await client.getAverageClickPosition({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/clicks/averageClickPosition');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getAverageClickPosition with all parameters', async () => {
    const req = (await client.getAverageClickPosition({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/clicks/averageClickPosition');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    });
  });
});

describe('getClickPositions', () => {
  test('get getClickPositions with minimal parameters', async () => {
    const req = (await client.getClickPositions({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/clicks/positions');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getClickPositions with all parameters', async () => {
    const req = (await client.getClickPositions({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/clicks/positions');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    });
  });
});

describe('getClickThroughRate', () => {
  test('get getClickThroughRate with minimal parameters', async () => {
    const req = (await client.getClickThroughRate({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/clicks/clickThroughRate');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getClickThroughRate with all parameters', async () => {
    const req = (await client.getClickThroughRate({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/clicks/clickThroughRate');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    });
  });
});

describe('getConversionRate', () => {
  test('get getConversationRate with minimal parameters', async () => {
    const req = (await client.getConversionRate({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/conversions/conversionRate');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getConversationRate with all parameters', async () => {
    const req = (await client.getConversionRate({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/conversions/conversionRate');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    });
  });
});

describe('getNoClickRate', () => {
  test('get getNoClickRate with minimal parameters', async () => {
    const req = (await client.getNoClickRate({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/searches/noClickRate');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getNoClickRate with all parameters', async () => {
    const req = (await client.getNoClickRate({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/searches/noClickRate');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    });
  });
});

describe('getNoResultsRate', () => {
  test('get getNoResultsRate with minimal parameters', async () => {
    const req = (await client.getNoResultsRate({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/searches/noResultRate');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getNoResultsRate with all parameters', async () => {
    const req = (await client.getNoResultsRate({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/searches/noResultRate');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    });
  });
});

describe('getPurchaseRate', () => {
  test('get getPurchaseRate with minimal parameters', async () => {
    const req = (await client.getPurchaseRate({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/conversions/purchaseRate');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getPurchaseRate with all parameters', async () => {
    const req = (await client.getPurchaseRate({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/conversions/purchaseRate');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    });
  });
});

describe('getRevenue', () => {
  test('get getRevenue with minimal parameters', async () => {
    const req = (await client.getRevenue({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/conversions/revenue');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getRevenue with all parameters', async () => {
    const req = (await client.getRevenue({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/conversions/revenue');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    });
  });
});

describe('getSearchesCount', () => {
  test('get getSearchesCount with minimal parameters', async () => {
    const req = (await client.getSearchesCount({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/searches/count');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getSearchesCount with all parameters', async () => {
    const req = (await client.getSearchesCount({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/searches/count');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    });
  });
});

describe('getSearchesNoClicks', () => {
  test('get getSearchesNoClicks with minimal parameters', async () => {
    const req = (await client.getSearchesNoClicks({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/searches/noClicks');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getSearchesNoClicks with all parameters', async () => {
    const req = (await client.getSearchesNoClicks({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      limit: 21,
      offset: 42,
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/searches/noClicks');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      limit: '21',
      offset: '42',
      tags: 'tag',
    });
  });
});

describe('getSearchesNoResults', () => {
  test('get getSearchesNoResults with minimal parameters', async () => {
    const req = (await client.getSearchesNoResults({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/searches/noResults');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getSearchesNoResults with all parameters', async () => {
    const req = (await client.getSearchesNoResults({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      limit: 21,
      offset: 42,
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/searches/noResults');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      limit: '21',
      offset: '42',
      tags: 'tag',
    });
  });
});

describe('getStatus', () => {
  test('get getStatus with minimal parameters', async () => {
    const req = (await client.getStatus({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/status');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });
});

describe('getTopCountries', () => {
  test('get getTopCountries with minimal parameters', async () => {
    const req = (await client.getTopCountries({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/countries');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getTopCountries with all parameters', async () => {
    const req = (await client.getTopCountries({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      limit: 21,
      offset: 42,
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/countries');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      limit: '21',
      offset: '42',
      tags: 'tag',
    });
  });
});

describe('getTopFilterAttributes', () => {
  test('get getTopFilterAttributes with minimal parameters', async () => {
    const req = (await client.getTopFilterAttributes({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/filters');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getTopFilterAttributes with all parameters', async () => {
    const req = (await client.getTopFilterAttributes({
      index: 'index',
      search: 'mySearch',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      limit: 21,
      offset: 42,
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/filters');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      search: 'mySearch',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      limit: '21',
      offset: '42',
      tags: 'tag',
    });
  });
});

describe('getTopFilterForAttribute', () => {
  test('get getTopFilterForAttribute with minimal parameters', async () => {
    const req = (await client.getTopFilterForAttribute({
      attribute: 'myAttribute',
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/filters/myAttribute');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getTopFilterForAttribute with minimal parameters and multiple attributes', async () => {
    const req = (await client.getTopFilterForAttribute({
      attribute: 'myAttribute1,myAttribute2',
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/filters/myAttribute1%2CmyAttribute2');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getTopFilterForAttribute with all parameters', async () => {
    const req = (await client.getTopFilterForAttribute({
      attribute: 'myAttribute',
      index: 'index',
      search: 'mySearch',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      limit: 21,
      offset: 42,
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/filters/myAttribute');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      search: 'mySearch',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      limit: '21',
      offset: '42',
      tags: 'tag',
    });
  });

  test('get getTopFilterForAttribute with all parameters and multiple attributes', async () => {
    const req = (await client.getTopFilterForAttribute({
      attribute: 'myAttribute1,myAttribute2',
      index: 'index',
      search: 'mySearch',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      limit: 21,
      offset: 42,
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/filters/myAttribute1%2CmyAttribute2');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      search: 'mySearch',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      limit: '21',
      offset: '42',
      tags: 'tag',
    });
  });
});

describe('getTopFiltersNoResults', () => {
  test('get getTopFiltersNoResults with minimal parameters', async () => {
    const req = (await client.getTopFiltersNoResults({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/filters/noResults');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getTopFiltersNoResults with all parameters', async () => {
    const req = (await client.getTopFiltersNoResults({
      index: 'index',
      search: 'mySearch',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      limit: 21,
      offset: 42,
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/filters/noResults');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      search: 'mySearch',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      limit: '21',
      offset: '42',
      tags: 'tag',
    });
  });
});

describe('getTopHits', () => {
  test('get getTopHits with minimal parameters', async () => {
    const req = (await client.getTopHits({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/hits');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getTopHits with all parameters', async () => {
    const req = (await client.getTopHits({
      index: 'index',
      search: 'mySearch',
      clickAnalytics: true,
      revenueAnalytics: true,
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      limit: 21,
      offset: 42,
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/hits');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      search: 'mySearch',
      clickAnalytics: 'true',
      revenueAnalytics: 'true',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      limit: '21',
      offset: '42',
      tags: 'tag',
    });
  });
});

describe('getTopSearches', () => {
  test('get getTopSearches with minimal parameters', async () => {
    const req = (await client.getTopSearches({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/searches');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getTopSearches with all parameters', async () => {
    const req = (await client.getTopSearches({
      index: 'index',
      clickAnalytics: true,
      revenueAnalytics: true,
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      orderBy: 'searchCount',
      direction: 'asc',
      limit: 21,
      offset: 42,
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/searches');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      clickAnalytics: 'true',
      revenueAnalytics: 'true',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      orderBy: 'searchCount',
      direction: 'asc',
      limit: '21',
      offset: '42',
      tags: 'tag',
    });
  });

  test('e2e with complex query params', async () => {
    const req = (await client.getTopSearches({
      index: 'cts_e2e_space in index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/searches');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'cts_e2e_space%20in%20index',
    });

    const resp = await e2eClient.getTopSearches({
      index: 'cts_e2e_space in index',
    });

    const expectedBody = { searches: [{ search: '', nbHits: 0 }] };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});

describe('getUsersCount', () => {
  test('get getUsersCount with minimal parameters', async () => {
    const req = (await client.getUsersCount({
      index: 'index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/users/count');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ index: 'index' });
  });

  test('get getUsersCount with all parameters', async () => {
    const req = (await client.getUsersCount({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/2/users/count');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      index: 'index',
      startDate: '1999-09-19',
      endDate: '2001-01-01',
      tags: 'tag',
    });
  });
});
