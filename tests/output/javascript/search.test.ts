import { SearchApi, EchoRequester } from '@algolia/client-search';

describe('Common Test Suite', () => {
  const client = new SearchApi(process.env.ALGOLIA_APPLICATION_ID, process.env.ALGOLIA_SEARCH_KEY, { requester: new EchoRequester() });
  test('hello test', async () => {
    const req = await client.search("indexName",{"query":"coucou"},);
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/query',
      method: 'POST',
      data: '[object Object]',
    })
  });
});
