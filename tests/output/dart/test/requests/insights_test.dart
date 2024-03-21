import 'package:algolia_client_insights/algolia_client_insights.dart';
import 'package:algolia_test/algolia_test.dart';
import 'package:test/test.dart';

void main() {
  // customDelete
  test(
    'allow del method for a custom path with minimal parameters',
    () => runTest(
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customDelete(
        path: "test/minimal",
      ),
      intercept: (request) {
        expectPath(request.path, '/test/minimal');
        expect(request.method, 'delete');
        expect(request.body, null);
      },
    ),
  );

  // customDelete
  test(
    'allow del method for a custom path with all parameters',
    () => runTest(
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customDelete(
        path: "test/all",
        parameters: {
          'query': "parameters",
        },
      ),
      intercept: (request) {
        expectPath(request.path, '/test/all');
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
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customGet(
        path: "test/minimal",
      ),
      intercept: (request) {
        expectPath(request.path, '/test/minimal');
        expect(request.method, 'get');
        expect(request.body, null);
      },
    ),
  );

  // customGet
  test(
    'allow get method for a custom path with all parameters',
    () => runTest(
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customGet(
        path: "test/all",
        parameters: {
          'query': "parameters with space",
        },
      ),
      intercept: (request) {
        expectPath(request.path, '/test/all');
        expect(request.method, 'get');
        expectParams(request.queryParameters,
            """{"query":"parameters%20with%20space"}""");
        expect(request.body, null);
      },
    ),
  );

  // customGet
  test(
    'requestOptions should be escaped too',
    () => runTest(
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customGet(
        path: "test/all",
        parameters: {
          'query': "to be overriden",
        },
        requestOptions: RequestOptions(
          headers: {
            'x-header-1': 'spaces are left alone',
          },
          urlParameters: {
            'query': "parameters with space",
            'and an array': [
              "array",
              "with spaces",
            ],
          },
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/test/all');
        expect(request.method, 'get');
        expectHeaders(
            request.headers, """{"x-header-1":"spaces are left alone"}""");
        expectParams(request.queryParameters,
            """{"query":"parameters%20with%20space","and%20an%20array":"array%2Cwith%20spaces"}""");
        expect(request.body, null);
      },
    ),
  );

  // customPost
  test(
    'allow post method for a custom path with minimal parameters',
    () => runTest(
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "test/minimal",
      ),
      intercept: (request) {
        expectPath(request.path, '/test/minimal');
        expect(request.method, 'post');
        expectBody(request.body, """{}""");
      },
    ),
  );

  // customPost
  test(
    'allow post method for a custom path with all parameters',
    () => runTest(
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "test/all",
        parameters: {
          'query': "parameters",
        },
        body: {
          'body': "parameters",
        },
      ),
      intercept: (request) {
        expectPath(request.path, '/test/all');
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
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "test/requestOptions",
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
        expectPath(request.path, '/test/requestOptions');
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
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "test/requestOptions",
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
        expectPath(request.path, '/test/requestOptions');
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
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "test/requestOptions",
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
        expectPath(request.path, '/test/requestOptions');
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
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "test/requestOptions",
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
        expectPath(request.path, '/test/requestOptions');
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
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "test/requestOptions",
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
        expectPath(request.path, '/test/requestOptions');
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
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "test/requestOptions",
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
        expectPath(request.path, '/test/requestOptions');
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
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "test/requestOptions",
        parameters: {
          'query': "parameters",
        },
        body: {
          'facet': "filters",
        },
        requestOptions: RequestOptions(
          urlParameters: {
            'myParam': [
              "b and c",
              "d",
            ],
          },
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/test/requestOptions');
        expect(request.method, 'post');
        expectParams(request.queryParameters,
            """{"query":"parameters","myParam":"b%20and%20c%2Cd"}""");
        expectBody(request.body, """{"facet":"filters"}""");
      },
    ),
  );

  // customPost
  test(
    'requestOptions queryParameters accepts list of booleans',
    () => runTest(
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "test/requestOptions",
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
        expectPath(request.path, '/test/requestOptions');
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
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "test/requestOptions",
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
        expectPath(request.path, '/test/requestOptions');
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
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPut(
        path: "test/minimal",
      ),
      intercept: (request) {
        expectPath(request.path, '/test/minimal');
        expect(request.method, 'put');
        expectBody(request.body, """{}""");
      },
    ),
  );

  // customPut
  test(
    'allow put method for a custom path with all parameters',
    () => runTest(
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPut(
        path: "test/all",
        parameters: {
          'query': "parameters",
        },
        body: {
          'body': "parameters",
        },
      ),
      intercept: (request) {
        expectPath(request.path, '/test/all');
        expect(request.method, 'put');
        expectParams(request.queryParameters, """{"query":"parameters"}""");
        expectBody(request.body, """{"body":"parameters"}""");
      },
    ),
  );

  // deleteUserToken
  test(
    'deleteUserToken0',
    () => runTest(
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.deleteUserToken(
        userToken: "test-user-1",
      ),
      intercept: (request) {
        expectPath(request.path, '/1/usertokens/test-user-1');
        expect(request.method, 'delete');
        expect(request.body, null);
      },
    ),
  );

  // pushEvents
  test(
    'pushEvents0',
    () => runTest(
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.pushEvents(
        insightsEvents: InsightsEvents(
          events: [
            ClickedObjectIDsAfterSearch(
              eventType: ClickEvent.fromJson("click"),
              eventName: "Product Clicked",
              index: "products",
              userToken: "user-123456",
              authenticatedUserToken: "user-123456",
              timestamp: 1641290601962,
              objectIDs: [
                "9780545139700",
                "9780439784542",
              ],
              queryID: "43b15df305339e827f0ac0bdc5ebcaa7",
              positions: [
                7,
                6,
              ],
            ),
          ],
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/events');
        expect(request.method, 'post');
        expectBody(request.body,
            """{"events":[{"eventType":"click","eventName":"Product Clicked","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7","positions":[7,6]}]}""");
      },
    ),
  );

  // pushEvents
  test(
    'Many events type',
    () => runTest(
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.pushEvents(
        insightsEvents: InsightsEvents(
          events: [
            ConvertedObjectIDsAfterSearch(
              eventType: ConversionEvent.fromJson("conversion"),
              eventName: "Product Purchased",
              index: "products",
              userToken: "user-123456",
              authenticatedUserToken: "user-123456",
              timestamp: 1710979200000,
              objectIDs: [
                "9780545139700",
                "9780439784542",
              ],
              queryID: "43b15df305339e827f0ac0bdc5ebcaa7",
            ),
            ViewedObjectIDs(
              eventType: ViewEvent.fromJson("view"),
              eventName: "Product Detail Page Viewed",
              index: "products",
              userToken: "user-123456",
              authenticatedUserToken: "user-123456",
              timestamp: 1710979200000,
              objectIDs: [
                "9780545139700",
                "9780439784542",
              ],
            ),
          ],
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/events');
        expect(request.method, 'post');
        expectBody(request.body,
            """{"events":[{"eventType":"conversion","eventName":"Product Purchased","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1710979200000,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7"},{"eventType":"view","eventName":"Product Detail Page Viewed","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1710979200000,"objectIDs":["9780545139700","9780439784542"]}]}""");
      },
    ),
  );

  // pushEvents
  test(
    'ConvertedObjectIDsAfterSearch',
    () => runTest(
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.pushEvents(
        insightsEvents: InsightsEvents(
          events: [
            ConvertedObjectIDsAfterSearch(
              eventType: ConversionEvent.fromJson("conversion"),
              eventName: "Product Purchased",
              index: "products",
              userToken: "user-123456",
              authenticatedUserToken: "user-123456",
              timestamp: 1641290601962,
              objectIDs: [
                "9780545139700",
                "9780439784542",
              ],
              queryID: "43b15df305339e827f0ac0bdc5ebcaa7",
            ),
          ],
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/events');
        expect(request.method, 'post');
        expectBody(request.body,
            """{"events":[{"eventType":"conversion","eventName":"Product Purchased","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7"}]}""");
      },
    ),
  );

  // pushEvents
  test(
    'ViewedObjectIDs',
    () => runTest(
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.pushEvents(
        insightsEvents: InsightsEvents(
          events: [
            ViewedObjectIDs(
              eventType: ViewEvent.fromJson("view"),
              eventName: "Product Detail Page Viewed",
              index: "products",
              userToken: "user-123456",
              authenticatedUserToken: "user-123456",
              timestamp: 1641290601962,
              objectIDs: [
                "9780545139700",
                "9780439784542",
              ],
            ),
          ],
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/events');
        expect(request.method, 'post');
        expectBody(request.body,
            """{"events":[{"eventType":"view","eventName":"Product Detail Page Viewed","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"]}]}""");
      },
    ),
  );

  // pushEvents
  test(
    'AddedToCartObjectIDs',
    () => runTest(
      builder: (requester) => InsightsClient(
        appId: 'appId',
        apiKey: 'apiKey',
        region: 'us',
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.pushEvents(
        insightsEvents: InsightsEvents(
          events: [
            AddedToCartObjectIDsAfterSearch(
              eventType: ConversionEvent.fromJson("conversion"),
              eventSubtype: AddToCartEvent.fromJson("addToCart"),
              eventName: "Product Added To Cart",
              index: "products",
              queryID: "43b15df305339e827f0ac0bdc5ebcaa7",
              userToken: "user-123456",
              authenticatedUserToken: "user-123456",
              timestamp: 1641290601962,
              objectIDs: [
                "9780545139700",
                "9780439784542",
              ],
              objectData: [
                ObjectDataAfterSearch(
                  price: 19.99,
                  quantity: 10,
                  discount: 2.5,
                ),
                ObjectDataAfterSearch(
                  price: "8\$",
                  quantity: 7,
                  discount: "30%",
                ),
              ],
              currency: "USD",
            ),
          ],
        ),
      ),
      intercept: (request) {
        expectPath(request.path, '/1/events');
        expect(request.method, 'post');
        expectBody(request.body,
            """{"events":[{"eventType":"conversion","eventSubtype":"addToCart","eventName":"Product Added To Cart","index":"products","queryID":"43b15df305339e827f0ac0bdc5ebcaa7","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"objectData":[{"price":19.99,"quantity":10,"discount":2.5},{"price":"8\$","quantity":7,"discount":"30%"}],"currency":"USD"}]}""");
      },
    ),
  );
}
