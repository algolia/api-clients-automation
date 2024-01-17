require 'algolia'
require 'test/unit'
require 'dotenv'
require_relative '../helpers'

Dotenv.load('../../.env')

class TestAbtestingClient < Test::Unit::TestCase
  include Algolia::Abtesting
  def setup
    @client = Algolia::AbtestingClient.create(
      'APP_ID',
      'API_KEY',
      'us',
      { requester: Algolia::Transport::EchoRequester.new }
    )
  end

  # addABTests with minimal parameters
  def test_add_ab_tests0
    req = @client.add_ab_tests_with_http_info(
      AddABTestsRequest.new(
        end_at: "2022-12-31T00:00:00.000Z",
        name: "myABTest",
        variants: [
          AbTestsVariant.new(
            index: "AB_TEST_1",
            traffic_percentage: 30
          ),
          AbTestsVariant.new(index: "AB_TEST_2", traffic_percentage: 50)
        ]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/2/abtests', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"endAt":"2022-12-31T00:00:00.000Z","name":"myABTest","variants":[{"index":"AB_TEST_1","trafficPercentage":30},{"index":"AB_TEST_2","trafficPercentage":50}]}'), JSON.parse(req.body)
    )
  end

  # allow del method for a custom path with minimal parameters
  def test_custom_delete0
    req = @client.custom_delete_with_http_info("/test/minimal")

    assert_equal(:delete, req.method)
    assert_equal('/1/test/minimal', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # allow del method for a custom path with all parameters
  def test_custom_delete1
    req = @client.custom_delete_with_http_info("/test/all", { query: "parameters" })

    assert_equal(:delete, req.method)
    assert_equal('/1/test/all', req.path)
    assert(({ 'query': "parameters" }.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # allow get method for a custom path with minimal parameters
  def test_custom_get0
    req = @client.custom_get_with_http_info("/test/minimal")

    assert_equal(:get, req.method)
    assert_equal('/1/test/minimal', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # allow get method for a custom path with all parameters
  def test_custom_get1
    req = @client.custom_get_with_http_info("/test/all", { query: "parameters" })

    assert_equal(:get, req.method)
    assert_equal('/1/test/all', req.path)
    assert(({ 'query': "parameters" }.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # allow post method for a custom path with minimal parameters
  def test_custom_post0
    req = @client.custom_post_with_http_info("/test/minimal")

    assert_equal(:post, req.method)
    assert_equal('/1/test/minimal', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
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
    assert(({ 'query': "parameters" }.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
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
    assert(
      ({ 'query': "myQueryParameter" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
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
    assert(
      ({ 'query': "parameters",
         'query2': "myQueryParameter" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
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
    assert(({ 'query': "parameters" }.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
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
    assert(({ 'query': "parameters" }.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
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
    assert(
      ({ 'query': "parameters", 'isItWorking': "true" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
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
    assert(
      ({ 'query': "parameters", 'myParam': "2" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions queryParameters accepts list of string
  def test_custom_post8
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"myParam":["c","d"]}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert(
      ({ 'query': "parameters", 'myParam': "c,d" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
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
    assert(
      ({ 'query': "parameters",
         'myParam': "true,true,false" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
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
    assert(
      ({ 'query': "parameters", 'myParam': "1,2" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # allow put method for a custom path with minimal parameters
  def test_custom_put0
    req = @client.custom_put_with_http_info("/test/minimal")

    assert_equal(:put, req.method)
    assert_equal('/1/test/minimal', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
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
    assert(({ 'query': "parameters" }.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"body":"parameters"}'), JSON.parse(req.body))
  end

  # deleteABTest
  def test_delete_ab_test0
    req = @client.delete_ab_test_with_http_info(42)

    assert_equal(:delete, req.method)
    assert_equal('/2/abtests/42', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getABTest
  def test_get_ab_test0
    req = @client.get_ab_test_with_http_info(42)

    assert_equal(:get, req.method)
    assert_equal('/2/abtests/42', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # listABTests with minimal parameters
  def test_list_ab_tests0
    req = @client.list_ab_tests_with_http_info

    assert_equal(:get, req.method)
    assert_equal('/2/abtests', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # listABTests with parameters
  def test_list_ab_tests1
    req = @client.list_ab_tests_with_http_info(42, 21, "foo", "bar")

    assert_equal(:get, req.method)
    assert_equal('/2/abtests', req.path)
    assert(
      ({ 'offset': "42",
         'limit': "21",
         'indexPrefix': "foo",
         'indexSuffix': "bar" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # stopABTest
  def test_stop_ab_test0
    req = @client.stop_ab_test_with_http_info(42)

    assert_equal(:post, req.method)
    assert_equal('/2/abtests/42/stop', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
  end
end
