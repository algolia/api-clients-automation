import { RecommendApi, EchoRequester } from '@algolia/recommend';

describe('Common Test Suite', () => {
  const client = new RecommendApi(process.env.ALGOLIA_APPLICATION_ID, process.env.ALGOLIA_SEARCH_KEY, { requester: new EchoRequester() });
});
