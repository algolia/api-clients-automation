require 'algolia'
require 'test/unit'
require 'dotenv'
require_relative '../helpers'

Dotenv.load('../../.env')

class TestInsightsClient < Test::Unit::TestCase
  include Algolia::Insights
  def setup
    @client = Algolia::InsightsClient.create(
      'APP_ID',
      'API_KEY',
      'us',
      { requester: Algolia::Transport::EchoRequester.new }
    )

    @e2e_client = Algolia::InsightsClient.create(
      ENV.fetch('ALGOLIA_APPLICATION_ID', nil),
      ENV.fetch('ALGOLIA_ADMIN_KEY', nil),
      'us'
    )
  end

  # allow del method for a custom path with minimal parameters
  def test_custom_delete0
    req = @client.custom_delete_with_http_info("/test/minimal")

    assert_equal(:delete, req.method)
    assert_equal('/1/test/minimal', req.path)
    assert_equal({}.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # allow del method for a custom path with all parameters
  def test_custom_delete1
    req = @client.custom_delete_with_http_info("/test/all", { query: "parameters" })

    assert_equal(:delete, req.method)
    assert_equal('/1/test/all', req.path)
    assert_equal({ 'query': "parameters" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # allow get method for a custom path with minimal parameters
  def test_custom_get0
    req = @client.custom_get_with_http_info("/test/minimal")

    assert_equal(:get, req.method)
    assert_equal('/1/test/minimal', req.path)
    assert_equal({}.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # allow get method for a custom path with all parameters
  def test_custom_get1
    req = @client.custom_get_with_http_info(
      "/test/all",
      { query: "parameters with space" }
    )

    assert_equal(:get, req.method)
    assert_equal('/1/test/all', req.path)
    assert_equal({ 'query': "parameters%20with%20space" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # requestOptions should be escaped too
  def test_custom_get2
    req = @client.custom_get_with_http_info(
      "/test/all",
      { query: "to be overriden" },
      {
        :header_params => JSON.parse(
          '{"x-header-1":"spaces are left alone"}',
          :symbolize_names => true
        ),
        :query_params => JSON.parse(
          '{"query":"parameters with space","and an array":["array","with spaces"]}', :symbolize_names => true
        )
      }
    )

    assert_equal(:get, req.method)
    assert_equal('/1/test/all', req.path)
    assert_equal(
      { 'query': "parameters%20with%20space",
        'and%20an%20array': "array%2Cwith%20spaces" }.to_a,
      req.query_params.to_a
    )
    assert(
      ({ 'x-header-1': "spaces are left alone" }.transform_keys(&:to_s).to_a - req.headers.to_a).empty?, req.headers.to_s
    )

    assert(req.body.nil?, 'body is not nil')
  end

  # allow post method for a custom path with minimal parameters
  def test_custom_post0
    req = @client.custom_post_with_http_info("/test/minimal")

    assert_equal(:post, req.method)
    assert_equal('/1/test/minimal', req.path)
    assert_equal({}.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{}'), JSON.parse(req.body))
  end

  # allow post method for a custom path with all parameters
  def test_custom_post1
    req = @client.custom_post_with_http_info(
      "/test/all",
      { query: "parameters" },
      { body: "parameters" }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/all', req.path)
    assert_equal({ 'query': "parameters" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"body":"parameters"}'), JSON.parse(req.body))
  end

  # requestOptions can override default query parameters
  def test_custom_post2
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"query":"myQueryParameter"}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert_equal({ 'query': "myQueryParameter" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions merges query parameters with default ones
  def test_custom_post3
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"query2":"myQueryParameter"}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert_equal(
      { 'query': "parameters", 'query2': "myQueryParameter" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions can override default headers
  def test_custom_post4
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :header_params => JSON.parse('{"x-algolia-api-key":"myApiKey"}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert_equal({ 'query': "parameters" }.to_a, req.query_params.to_a)
    assert(
      ({ 'x-algolia-api-key': "myApiKey" }.transform_keys(&:to_s).to_a - req.headers.to_a).empty?, req.headers.to_s
    )
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions merges headers with default ones
  def test_custom_post5
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :header_params => JSON.parse('{"x-algolia-api-key":"myApiKey"}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert_equal({ 'query': "parameters" }.to_a, req.query_params.to_a)
    assert(
      ({ 'x-algolia-api-key': "myApiKey" }.transform_keys(&:to_s).to_a - req.headers.to_a).empty?, req.headers.to_s
    )
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions queryParameters accepts booleans
  def test_custom_post6
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"isItWorking":true}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert_equal({ 'query': "parameters", 'isItWorking': "true" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions queryParameters accepts integers
  def test_custom_post7
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"myParam":2}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert_equal({ 'query': "parameters", 'myParam': "2" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions queryParameters accepts list of string
  def test_custom_post8
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"myParam":["b and c","d"]}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert_equal(
      { 'query': "parameters", 'myParam': "b%20and%20c%2Cd" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions queryParameters accepts list of booleans
  def test_custom_post9
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"myParam":[true,true,false]}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert_equal(
      { 'query': "parameters", 'myParam': "true%2Ctrue%2Cfalse" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions queryParameters accepts list of integers
  def test_custom_post10
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"myParam":[1,2]}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert_equal({ 'query': "parameters", 'myParam': "1%2C2" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # allow put method for a custom path with minimal parameters
  def test_custom_put0
    req = @client.custom_put_with_http_info("/test/minimal")

    assert_equal(:put, req.method)
    assert_equal('/1/test/minimal', req.path)
    assert_equal({}.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{}'), JSON.parse(req.body))
  end

  # allow put method for a custom path with all parameters
  def test_custom_put1
    req = @client.custom_put_with_http_info(
      "/test/all",
      { query: "parameters" },
      { body: "parameters" }
    )

    assert_equal(:put, req.method)
    assert_equal('/1/test/all', req.path)
    assert_equal({ 'query': "parameters" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"body":"parameters"}'), JSON.parse(req.body))
  end

  # deleteUserToken0
  def test_delete_user_token0
    req = @client.delete_user_token_with_http_info("test-user-1")

    assert_equal(:delete, req.method)
    assert_equal('/1/usertokens/test-user-1', req.path)
    assert_equal({}.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # pushEvents0
  def test_push_events0
    req = @client.push_events_with_http_info(
      InsightsEvents.new(
        events: [ClickedObjectIDsAfterSearch.new(
          event_type: 'click',
          event_name: "Product Clicked",
          index: "products",
          user_token: "user-123456",
          authenticated_user_token: "user-123456",
          timestamp: 1_641_290_601_962,
          object_ids: [
            "9780545139700", "9780439784542"
          ],
          query_id: "43b15df305339e827f0ac0bdc5ebcaa7",
          positions: [7, 6]
        )]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/events', req.path)
    assert_equal({}.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"events":[{"eventType":"click","eventName":"Product Clicked","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7","positions":[7,6]}]}'), JSON.parse(req.body)
    )
  end

  # Many events type
  def test_push_events1
    req = @client.push_events_with_http_info(
      InsightsEvents.new(
        events: [
          ConvertedObjectIDsAfterSearch.new(
            event_type: 'conversion',
            event_name: "Product Purchased",
            index: "products",
            user_token: "user-123456",
            authenticated_user_token: "user-123456",
            timestamp: 1_709_164_800_000,
            object_ids: ["9780545139700", "9780439784542"],
            query_id: "43b15df305339e827f0ac0bdc5ebcaa7"
          ),
          ViewedObjectIDs.new(
            event_type: 'view',
            event_name: "Product Detail Page Viewed",
            index: "products",
            user_token: "user-123456",
            authenticated_user_token: "user-123456",
            timestamp: 1_709_164_800_000,
            object_ids: ["9780545139700", "9780439784542"]
          )
        ]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/events', req.path)
    assert_equal({}.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"events":[{"eventType":"conversion","eventName":"Product Purchased","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1709164800000,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7"},{"eventType":"view","eventName":"Product Detail Page Viewed","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1709164800000,"objectIDs":["9780545139700","9780439784542"]}]}'), JSON.parse(req.body)
    )

    res = @e2e_client.push_events_with_http_info(
      InsightsEvents.new(
        events: [
          ConvertedObjectIDsAfterSearch.new(
            event_type: 'conversion',
            event_name: "Product Purchased",
            index: "products",
            user_token: "user-123456",
            authenticated_user_token: "user-123456",
            timestamp: 1_709_164_800_000,
            object_ids: ["9780545139700", "9780439784542"],
            query_id: "43b15df305339e827f0ac0bdc5ebcaa7"
          ),
          ViewedObjectIDs.new(
            event_type: 'view',
            event_name: "Product Detail Page Viewed",
            index: "products",
            user_token: "user-123456",
            authenticated_user_token: "user-123456",
            timestamp: 1_709_164_800_000,
            object_ids: ["9780545139700", "9780439784542"]
          )
        ]
      )
    )

    assert_equal(res.status, 200)
    res = @e2e_client.push_events(
      InsightsEvents.new(
        events: [
          ConvertedObjectIDsAfterSearch.new(
            event_type: 'conversion',
            event_name: "Product Purchased",
            index: "products",
            user_token: "user-123456",
            authenticated_user_token: "user-123456",
            timestamp: 1_709_164_800_000,
            object_ids: ["9780545139700", "9780439784542"],
            query_id: "43b15df305339e827f0ac0bdc5ebcaa7"
          ),
          ViewedObjectIDs.new(
            event_type: 'view',
            event_name: "Product Detail Page Viewed",
            index: "products",
            user_token: "user-123456",
            authenticated_user_token: "user-123456",
            timestamp: 1_709_164_800_000,
            object_ids: ["9780545139700", "9780439784542"]
          )
        ]
      )
    )
    expected_body = JSON.parse('{"message":"OK","status":200}')
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

  # ConvertedObjectIDsAfterSearch
  def test_push_events2
    req = @client.push_events_with_http_info(
      InsightsEvents.new(
        events: [ConvertedObjectIDsAfterSearch.new(
          event_type: 'conversion',
          event_name: "Product Purchased",
          index: "products",
          user_token: "user-123456",
          authenticated_user_token: "user-123456",
          timestamp: 1_641_290_601_962,
          object_ids: [
            "9780545139700", "9780439784542"
          ],
          query_id: "43b15df305339e827f0ac0bdc5ebcaa7"
        )]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/events', req.path)
    assert_equal({}.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"events":[{"eventType":"conversion","eventName":"Product Purchased","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7"}]}'), JSON.parse(req.body)
    )
  end

  # ViewedObjectIDs
  def test_push_events3
    req = @client.push_events_with_http_info(
      InsightsEvents.new(
        events: [ViewedObjectIDs.new(
          event_type: 'view',
          event_name: "Product Detail Page Viewed",
          index: "products",
          user_token: "user-123456",
          authenticated_user_token: "user-123456",
          timestamp: 1_641_290_601_962,
          object_ids: [
            "9780545139700", "9780439784542"
          ]
        )]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/events', req.path)
    assert_equal({}.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"events":[{"eventType":"view","eventName":"Product Detail Page Viewed","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"]}]}'), JSON.parse(req.body)
    )
  end

  # AddedToCartObjectIDs
  def test_push_events4
    req = @client.push_events_with_http_info(
      InsightsEvents.new(
        events: [AddedToCartObjectIDsAfterSearch.new(
          event_type: 'conversion',
          event_subtype: 'addToCart',
          event_name: "Product Added To Cart",
          index: "products",
          query_id: "43b15df305339e827f0ac0bdc5ebcaa7",
          user_token: "user-123456",
          authenticated_user_token: "user-123456",
          timestamp: 1_641_290_601_962,
          object_ids: [
            "9780545139700", "9780439784542"
          ],
          object_data: [ObjectDataAfterSearch.new(price: 19.99, quantity: 10, discount: 2.5),
            ObjectDataAfterSearch.new(price: "8$", quantity: 7, discount: "30%")],
          currency: "USD"
        )]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/events', req.path)
    assert_equal({}.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"events":[{"eventType":"conversion","eventSubtype":"addToCart","eventName":"Product Added To Cart","index":"products","queryID":"43b15df305339e827f0ac0bdc5ebcaa7","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"objectData":[{"price":19.99,"quantity":10,"discount":2.5},{"price":"8$","quantity":7,"discount":"30%"}],"currency":"USD"}]}'), JSON.parse(req.body)
    )
  end
end
