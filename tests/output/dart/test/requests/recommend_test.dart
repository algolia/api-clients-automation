import 'package:algolia_client_recommend/algolia_client_recommend.dart';
import 'package:algolia_test/algolia_test.dart';
import 'package:test/test.dart';

void main() {
  // customDelete
  test(
    'allow del method for a custom path with minimal parameters',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customDelete(
        path: "/test/minimal",
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/minimal');
        expect(request.method, 'delete');
        expect(request.body, null);
      },
    ),
  );

  // customDelete
  test(
    'allow del method for a custom path with all parameters',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customDelete(
        path: "/test/all",
        parameters: {
          'query': "parameters",
        },
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/all');
        expect(request.method, 'delete');
        expectParams(request.queryParameters, """{"query":"parameters"}""");
        expect(request.body, null);
      },
    ),
  );

  // customGet
  test(
    'allow get method for a custom path with minimal parameters',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customGet(
        path: "/test/minimal",
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/minimal');
        expect(request.method, 'get');
        expect(request.body, null);
      },
    ),
  );

  // customGet
  test(
    'allow get method for a custom path with all parameters',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customGet(
        path: "/test/all",
        parameters: {
          'query': "parameters with space",
        },
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/all');
        expect(request.method, 'get');
        expectParams(request.queryParameters,
            """{"query":"parameters%20with%20space"}""");
        expect(request.body, null);
      },
    ),
  );

  // customPost
  test(
    'allow post method for a custom path with minimal parameters',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "/test/minimal",
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/minimal');
        expect(request.method, 'post');
        expectBody(request.body, """{}""");
      },
    ),
  );

  // customPost
  test(
    'allow post method for a custom path with all parameters',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "/test/all",
        parameters: {
          'query': "parameters",
        },
        body: {
          'body': "parameters",
        },
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/all');
        expect(request.method, 'post');
        expectParams(request.queryParameters, """{"query":"parameters"}""");
        expectBody(request.body, """{"body":"parameters"}""");
      },
    ),
  );

  // customPost
  test(
    'requestOptions can override default query parameters',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "/test/requestOptions",
        parameters: {
          'query': "parameters",
        },
        body: {
          'facet': "filters",
        },
        requestOptions: RequestOptions(
          urlParameters: {
            'query': "myQueryParameter",
          },
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/requestOptions');
        expect(request.method, 'post');
        expectParams(
            request.queryParameters, """{"query":"myQueryParameter"}""");
        expectBody(request.body, """{"facet":"filters"}""");
      },
    ),
  );

  // customPost
  test(
    'requestOptions merges query parameters with default ones',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "/test/requestOptions",
        parameters: {
          'query': "parameters",
        },
        body: {
          'facet': "filters",
        },
        requestOptions: RequestOptions(
          urlParameters: {
            'query2': "myQueryParameter",
          },
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/requestOptions');
        expect(request.method, 'post');
        expectParams(request.queryParameters,
            """{"query":"parameters","query2":"myQueryParameter"}""");
        expectBody(request.body, """{"facet":"filters"}""");
      },
    ),
  );

  // customPost
  test(
    'requestOptions can override default headers',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "/test/requestOptions",
        parameters: {
          'query': "parameters",
        },
        body: {
          'facet': "filters",
        },
        requestOptions: RequestOptions(
          headers: {
            'x-algolia-api-key': 'myApiKey',
          },
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/requestOptions');
        expect(request.method, 'post');
        expectHeaders(request.headers, """{"x-algolia-api-key":"myApiKey"}""");
        expectParams(request.queryParameters, """{"query":"parameters"}""");
        expectBody(request.body, """{"facet":"filters"}""");
      },
    ),
  );

  // customPost
  test(
    'requestOptions merges headers with default ones',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "/test/requestOptions",
        parameters: {
          'query': "parameters",
        },
        body: {
          'facet': "filters",
        },
        requestOptions: RequestOptions(
          headers: {
            'x-algolia-api-key': 'myApiKey',
          },
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/requestOptions');
        expect(request.method, 'post');
        expectHeaders(request.headers, """{"x-algolia-api-key":"myApiKey"}""");
        expectParams(request.queryParameters, """{"query":"parameters"}""");
        expectBody(request.body, """{"facet":"filters"}""");
      },
    ),
  );

  // customPost
  test(
    'requestOptions queryParameters accepts booleans',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "/test/requestOptions",
        parameters: {
          'query': "parameters",
        },
        body: {
          'facet': "filters",
        },
        requestOptions: RequestOptions(
          urlParameters: {
            'isItWorking': true,
          },
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/requestOptions');
        expect(request.method, 'post');
        expectParams(request.queryParameters,
            """{"query":"parameters","isItWorking":"true"}""");
        expectBody(request.body, """{"facet":"filters"}""");
      },
    ),
  );

  // customPost
  test(
    'requestOptions queryParameters accepts integers',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "/test/requestOptions",
        parameters: {
          'query': "parameters",
        },
        body: {
          'facet': "filters",
        },
        requestOptions: RequestOptions(
          urlParameters: {
            'myParam': 2,
          },
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/requestOptions');
        expect(request.method, 'post');
        expectParams(request.queryParameters,
            """{"query":"parameters","myParam":"2"}""");
        expectBody(request.body, """{"facet":"filters"}""");
      },
    ),
  );

  // customPost
  test(
    'requestOptions queryParameters accepts list of string',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "/test/requestOptions",
        parameters: {
          'query': "parameters",
        },
        body: {
          'facet': "filters",
        },
        requestOptions: RequestOptions(
          urlParameters: {
            'myParam': [
              "c",
              "d",
            ],
          },
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/requestOptions');
        expect(request.method, 'post');
        expectParams(request.queryParameters,
            """{"query":"parameters","myParam":"c%2Cd"}""");
        expectBody(request.body, """{"facet":"filters"}""");
      },
    ),
  );

  // customPost
  test(
    'requestOptions queryParameters accepts list of booleans',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "/test/requestOptions",
        parameters: {
          'query': "parameters",
        },
        body: {
          'facet': "filters",
        },
        requestOptions: RequestOptions(
          urlParameters: {
            'myParam': [
              true,
              true,
              false,
            ],
          },
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/requestOptions');
        expect(request.method, 'post');
        expectParams(request.queryParameters,
            """{"query":"parameters","myParam":"true%2Ctrue%2Cfalse"}""");
        expectBody(request.body, """{"facet":"filters"}""");
      },
    ),
  );

  // customPost
  test(
    'requestOptions queryParameters accepts list of integers',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "/test/requestOptions",
        parameters: {
          'query': "parameters",
        },
        body: {
          'facet': "filters",
        },
        requestOptions: RequestOptions(
          urlParameters: {
            'myParam': [
              1,
              2,
            ],
          },
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/requestOptions');
        expect(request.method, 'post');
        expectParams(request.queryParameters,
            """{"query":"parameters","myParam":"1%2C2"}""");
        expectBody(request.body, """{"facet":"filters"}""");
      },
    ),
  );

  // customPut
  test(
    'allow put method for a custom path with minimal parameters',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPut(
        path: "/test/minimal",
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/minimal');
        expect(request.method, 'put');
        expectBody(request.body, """{}""");
      },
    ),
  );

  // customPut
  test(
    'allow put method for a custom path with all parameters',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPut(
        path: "/test/all",
        parameters: {
          'query': "parameters",
        },
        body: {
          'body': "parameters",
        },
      ),
      intercept: (request) {
        expectPath(request.path, '/1/test/all');
        expect(request.method, 'put');
        expectParams(request.queryParameters, """{"query":"parameters"}""");
        expectBody(request.body, """{"body":"parameters"}""");
      },
    ),
  );

  // deleteRecommendRule
  test(
    'deleteRecommendRule0',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.deleteRecommendRule(
        indexName: "indexName",
        model: RecommendModels.fromJson("related-products"),
        objectID: "objectID",
      ),
      intercept: (request) {
        expectPath(request.path,
            '/1/indexes/indexName/related-products/recommend/rules/objectID');
        expect(request.method, 'delete');
        expect(request.body, null);
      },
    ),
  );

  // getRecommendRule
  test(
    'getRecommendRule0',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.getRecommendRule(
        indexName: "indexName",
        model: RecommendModels.fromJson("related-products"),
        objectID: "objectID",
      ),
      intercept: (request) {
        expectPath(request.path,
            '/1/indexes/indexName/related-products/recommend/rules/objectID');
        expect(request.method, 'get');
        expect(request.body, null);
      },
    ),
  );

  // getRecommendStatus
  test(
    'getRecommendStatus0',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.getRecommendStatus(
        indexName: "indexName",
        model: RecommendModels.fromJson("related-products"),
        taskID: 12345,
      ),
      intercept: (request) {
        expectPath(
            request.path, '/1/indexes/indexName/related-products/task/12345');
        expect(request.method, 'get');
        expect(request.body, null);
      },
    ),
  );

  // getRecommendations
  test(
    'get recommendations for recommend model with minimal parameters',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.getRecommendations(
        getRecommendationsParams: GetRecommendationsParams(
          requests: [
            RecommendationsQuery(
              indexName: "indexName",
              objectID: "objectID",
              model: RecommendationModels.fromJson("related-products"),
              threshold: 42,
            ),
          ],
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/indexes/*/recommendations');
        expect(request.method, 'post');
        expectBody(request.body,
            """{"requests":[{"indexName":"indexName","objectID":"objectID","model":"related-products","threshold":42}]}""");
      },
    ),
  );

  // getRecommendations
  test(
    'get recommendations for recommend model with all parameters',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.getRecommendations(
        getRecommendationsParams: GetRecommendationsParams(
          requests: [
            RecommendationsQuery(
              indexName: "indexName",
              objectID: "objectID",
              model: RecommendationModels.fromJson("related-products"),
              threshold: 42,
              maxRecommendations: 10,
              queryParameters: SearchParamsObject(
                query: "myQuery",
                facetFilters: [
                  "query",
                ],
              ),
              fallbackParameters: SearchParamsObject(
                query: "myQuery",
                facetFilters: [
                  "fallback",
                ],
              ),
            ),
          ],
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/indexes/*/recommendations');
        expect(request.method, 'post');
        expectBody(request.body,
            """{"requests":[{"indexName":"indexName","objectID":"objectID","model":"related-products","threshold":42,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback"]}}]}""");
      },
    ),
  );

  // getRecommendations
  test(
    'get recommendations for trending model with minimal parameters',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.getRecommendations(
        getRecommendationsParams: GetRecommendationsParams(
          requests: [
            TrendingItemsQuery(
              indexName: "indexName",
              model: TrendingItemsModel.fromJson("trending-items"),
              threshold: 42,
            ),
          ],
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/indexes/*/recommendations');
        expect(request.method, 'post');
        expectBody(request.body,
            """{"requests":[{"indexName":"indexName","model":"trending-items","threshold":42}]}""");
      },
    ),
  );

  // getRecommendations
  test(
    'get recommendations for trending model with all parameters',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.getRecommendations(
        getRecommendationsParams: GetRecommendationsParams(
          requests: [
            TrendingItemsQuery(
              indexName: "indexName",
              model: TrendingItemsModel.fromJson("trending-items"),
              threshold: 42,
              maxRecommendations: 10,
              facetName: "myFacetName",
              facetValue: "myFacetValue",
              queryParameters: SearchParamsObject(
                query: "myQuery",
                facetFilters: [
                  "query",
                ],
              ),
              fallbackParameters: SearchParamsObject(
                query: "myQuery",
                facetFilters: [
                  "fallback",
                ],
              ),
            ),
          ],
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/indexes/*/recommendations');
        expect(request.method, 'post');
        expectBody(request.body,
            """{"requests":[{"indexName":"indexName","model":"trending-items","threshold":42,"maxRecommendations":10,"facetName":"myFacetName","facetValue":"myFacetValue","queryParameters":{"query":"myQuery","facetFilters":["query"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback"]}}]}""");
      },
    ),
  );

  // getRecommendations
  test(
    'get multiple recommendations with minimal parameters',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.getRecommendations(
        getRecommendationsParams: GetRecommendationsParams(
          requests: [
            RecommendationsQuery(
              indexName: "indexName1",
              objectID: "objectID1",
              model: RecommendationModels.fromJson("related-products"),
              threshold: 21,
            ),
            RecommendationsQuery(
              indexName: "indexName2",
              objectID: "objectID2",
              model: RecommendationModels.fromJson("related-products"),
              threshold: 21,
            ),
          ],
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/indexes/*/recommendations');
        expect(request.method, 'post');
        expectBody(request.body,
            """{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"related-products","threshold":21},{"indexName":"indexName2","objectID":"objectID2","model":"related-products","threshold":21}]}""");
      },
    ),
  );

  // getRecommendations
  test(
    'get multiple recommendations with all parameters',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.getRecommendations(
        getRecommendationsParams: GetRecommendationsParams(
          requests: [
            RecommendationsQuery(
              indexName: "indexName1",
              objectID: "objectID1",
              model: RecommendationModels.fromJson("related-products"),
              threshold: 21,
              maxRecommendations: 10,
              queryParameters: SearchParamsObject(
                query: "myQuery",
                facetFilters: [
                  "query1",
                ],
              ),
              fallbackParameters: SearchParamsObject(
                query: "myQuery",
                facetFilters: [
                  "fallback1",
                ],
              ),
            ),
            RecommendationsQuery(
              indexName: "indexName2",
              objectID: "objectID2",
              model: RecommendationModels.fromJson("related-products"),
              threshold: 21,
              maxRecommendations: 10,
              queryParameters: SearchParamsObject(
                query: "myQuery",
                facetFilters: [
                  "query2",
                ],
              ),
              fallbackParameters: SearchParamsObject(
                query: "myQuery",
                facetFilters: [
                  "fallback2",
                ],
              ),
            ),
          ],
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/indexes/*/recommendations');
        expect(request.method, 'post');
        expectBody(request.body,
            """{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"related-products","threshold":21,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query1"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback1"]}},{"indexName":"indexName2","objectID":"objectID2","model":"related-products","threshold":21,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query2"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback2"]}}]}""");
      },
    ),
  );

  // getRecommendations
  test(
    'get frequently bought together recommendations',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.getRecommendations(
        getRecommendationsParams: GetRecommendationsParams(
          requests: [
            RecommendationsQuery(
              indexName: "indexName1",
              objectID: "objectID1",
              model: RecommendationModels.fromJson("bought-together"),
              threshold: 42,
            ),
          ],
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/indexes/*/recommendations');
        expect(request.method, 'post');
        expectBody(request.body,
            """{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"bought-together","threshold":42}]}""");
      },
    ),
  );

  // searchRecommendRules
  test(
    'searchRecommendRules0',
    () => runTest(
      builder: (requester) => RecommendClient(
        appId: 'appId',
        apiKey: 'apiKey',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.searchRecommendRules(
        indexName: "indexName",
        model: RecommendModels.fromJson("related-products"),
      ),
      intercept: (request) {
        expectPath(request.path,
            '/1/indexes/indexName/related-products/recommend/rules/search');
        expect(request.method, 'post');
        expectBody(request.body, """{}""");
      },
    ),
  );
}
