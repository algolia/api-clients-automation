require 'algolia'
require 'test/unit'
require 'dotenv'
require_relative '../helpers'

Dotenv.load('../../.env')

class TestAnalyticsClient < Test::Unit::TestCase
  include Algolia::Analytics
  def setup
    @client = Algolia::AnalyticsClient.create(
      'APP_ID',
      'API_KEY',
      'us',
      { requester: Algolia::Transport::EchoRequester.new }
    )

    @e2e_client = Algolia::AnalyticsClient.create(
      ENV.fetch('ALGOLIA_APPLICATION_ID', nil),
      ENV.fetch('ALGOLIA_ADMIN_KEY', nil),
      'us'
    )
  end

  # allow del method for a custom path with minimal parameters
  def test_custom_delete0
    req = @client.custom_delete_with_http_info("test/minimal")

    assert_equal(:delete, req.method)
    assert_equal('/test/minimal', req.path)
    assert_equal({}.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # allow del method for a custom path with all parameters
  def test_custom_delete1
    req = @client.custom_delete_with_http_info("test/all", { query: "parameters" })

    assert_equal(:delete, req.method)
    assert_equal('/test/all', req.path)
    assert_equal({ 'query': "parameters" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # allow get method for a custom path with minimal parameters
  def test_custom_get0
    req = @client.custom_get_with_http_info("test/minimal")

    assert_equal(:get, req.method)
    assert_equal('/test/minimal', req.path)
    assert_equal({}.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # allow get method for a custom path with all parameters
  def test_custom_get1
    req = @client.custom_get_with_http_info(
      "test/all",
      { query: "parameters with space" }
    )

    assert_equal(:get, req.method)
    assert_equal('/test/all', req.path)
    assert_equal({ 'query': "parameters%20with%20space" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # requestOptions should be escaped too
  def test_custom_get2
    req = @client.custom_get_with_http_info(
      "test/all",
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
    assert_equal('/test/all', req.path)
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
    req = @client.custom_post_with_http_info("test/minimal")

    assert_equal(:post, req.method)
    assert_equal('/test/minimal', req.path)
    assert_equal({}.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{}'), JSON.parse(req.body))
  end

  # allow post method for a custom path with all parameters
  def test_custom_post1
    req = @client.custom_post_with_http_info(
      "test/all",
      { query: "parameters" },
      { body: "parameters" }
    )

    assert_equal(:post, req.method)
    assert_equal('/test/all', req.path)
    assert_equal({ 'query': "parameters" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"body":"parameters"}'), JSON.parse(req.body))
  end

  # requestOptions can override default query parameters
  def test_custom_post2
    req = @client.custom_post_with_http_info(
      "test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"query":"myQueryParameter"}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/test/requestOptions', req.path)
    assert_equal({ 'query': "myQueryParameter" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions merges query parameters with default ones
  def test_custom_post3
    req = @client.custom_post_with_http_info(
      "test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"query2":"myQueryParameter"}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/test/requestOptions', req.path)
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
      "test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :header_params => JSON.parse('{"x-algolia-api-key":"myApiKey"}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/test/requestOptions', req.path)
    assert_equal({ 'query': "parameters" }.to_a, req.query_params.to_a)
    assert(
      ({ 'x-algolia-api-key': "myApiKey" }.transform_keys(&:to_s).to_a - req.headers.to_a).empty?, req.headers.to_s
    )
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions merges headers with default ones
  def test_custom_post5
    req = @client.custom_post_with_http_info(
      "test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :header_params => JSON.parse('{"x-algolia-api-key":"myApiKey"}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/test/requestOptions', req.path)
    assert_equal({ 'query': "parameters" }.to_a, req.query_params.to_a)
    assert(
      ({ 'x-algolia-api-key': "myApiKey" }.transform_keys(&:to_s).to_a - req.headers.to_a).empty?, req.headers.to_s
    )
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions queryParameters accepts booleans
  def test_custom_post6
    req = @client.custom_post_with_http_info(
      "test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"isItWorking":true}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/test/requestOptions', req.path)
    assert_equal({ 'query': "parameters", 'isItWorking': "true" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions queryParameters accepts integers
  def test_custom_post7
    req = @client.custom_post_with_http_info(
      "test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"myParam":2}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/test/requestOptions', req.path)
    assert_equal({ 'query': "parameters", 'myParam': "2" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions queryParameters accepts list of string
  def test_custom_post8
    req = @client.custom_post_with_http_info(
      "test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"myParam":["b and c","d"]}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/test/requestOptions', req.path)
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
      "test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"myParam":[true,true,false]}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/test/requestOptions', req.path)
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
      "test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"myParam":[1,2]}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/test/requestOptions', req.path)
    assert_equal({ 'query': "parameters", 'myParam': "1%2C2" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # allow put method for a custom path with minimal parameters
  def test_custom_put0
    req = @client.custom_put_with_http_info("test/minimal")

    assert_equal(:put, req.method)
    assert_equal('/test/minimal', req.path)
    assert_equal({}.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{}'), JSON.parse(req.body))
  end

  # allow put method for a custom path with all parameters
  def test_custom_put1
    req = @client.custom_put_with_http_info(
      "test/all",
      { query: "parameters" },
      { body: "parameters" }
    )

    assert_equal(:put, req.method)
    assert_equal('/test/all', req.path)
    assert_equal({ 'query': "parameters" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"body":"parameters"}'), JSON.parse(req.body))
  end

  # get getAddToCartRate with minimal parameters
  def test_get_add_to_cart_rate0
    req = @client.get_add_to_cart_rate_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/conversions/addToCartRate', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getAddToCartRate with all parameters
  def test_get_add_to_cart_rate1
    req = @client.get_add_to_cart_rate_with_http_info(
      "index",
      "1999-09-19",
      "2001-01-01",
      "tag"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/conversions/addToCartRate', req.path)
    assert_equal(
      { 'index': "index",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getAverageClickPosition with minimal parameters
  def test_get_average_click_position0
    req = @client.get_average_click_position_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/clicks/averageClickPosition', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getAverageClickPosition with all parameters
  def test_get_average_click_position1
    req = @client.get_average_click_position_with_http_info(
      "index",
      "1999-09-19",
      "2001-01-01",
      "tag"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/clicks/averageClickPosition', req.path)
    assert_equal(
      { 'index': "index",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getClickPositions with minimal parameters
  def test_get_click_positions0
    req = @client.get_click_positions_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/clicks/positions', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getClickPositions with all parameters
  def test_get_click_positions1
    req = @client.get_click_positions_with_http_info(
      "index",
      "1999-09-19",
      "2001-01-01",
      "tag"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/clicks/positions', req.path)
    assert_equal(
      { 'index': "index",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getClickThroughRate with minimal parameters
  def test_get_click_through_rate0
    req = @client.get_click_through_rate_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/clicks/clickThroughRate', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getClickThroughRate with all parameters
  def test_get_click_through_rate1
    req = @client.get_click_through_rate_with_http_info(
      "index",
      "1999-09-19",
      "2001-01-01",
      "tag"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/clicks/clickThroughRate', req.path)
    assert_equal(
      { 'index': "index",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getConversationRate with minimal parameters
  def test_get_conversion_rate0
    req = @client.get_conversion_rate_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/conversions/conversionRate', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getConversationRate with all parameters
  def test_get_conversion_rate1
    req = @client.get_conversion_rate_with_http_info(
      "index",
      "1999-09-19",
      "2001-01-01",
      "tag"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/conversions/conversionRate', req.path)
    assert_equal(
      { 'index': "index",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getNoClickRate with minimal parameters
  def test_get_no_click_rate0
    req = @client.get_no_click_rate_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/searches/noClickRate', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getNoClickRate with all parameters
  def test_get_no_click_rate1
    req = @client.get_no_click_rate_with_http_info("index", "1999-09-19", "2001-01-01", "tag")

    assert_equal(:get, req.method)
    assert_equal('/2/searches/noClickRate', req.path)
    assert_equal(
      { 'index': "index",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getNoResultsRate with minimal parameters
  def test_get_no_results_rate0
    req = @client.get_no_results_rate_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/searches/noResultRate', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getNoResultsRate with all parameters
  def test_get_no_results_rate1
    req = @client.get_no_results_rate_with_http_info(
      "index",
      "1999-09-19",
      "2001-01-01",
      "tag"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/searches/noResultRate', req.path)
    assert_equal(
      { 'index': "index",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getPurchaseRate with minimal parameters
  def test_get_purchase_rate0
    req = @client.get_purchase_rate_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/conversions/purchaseRate', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getPurchaseRate with all parameters
  def test_get_purchase_rate1
    req = @client.get_purchase_rate_with_http_info("index", "1999-09-19", "2001-01-01", "tag")

    assert_equal(:get, req.method)
    assert_equal('/2/conversions/purchaseRate', req.path)
    assert_equal(
      { 'index': "index",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getRevenue with minimal parameters
  def test_get_revenue0
    req = @client.get_revenue_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/conversions/revenue', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getRevenue with all parameters
  def test_get_revenue1
    req = @client.get_revenue_with_http_info("index", "1999-09-19", "2001-01-01", "tag")

    assert_equal(:get, req.method)
    assert_equal('/2/conversions/revenue', req.path)
    assert_equal(
      { 'index': "index",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getSearchesCount with minimal parameters
  def test_get_searches_count0
    req = @client.get_searches_count_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/searches/count', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getSearchesCount with all parameters
  def test_get_searches_count1
    req = @client.get_searches_count_with_http_info(
      "index",
      "1999-09-19",
      "2001-01-01",
      "tag"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/searches/count', req.path)
    assert_equal(
      { 'index': "index",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getSearchesNoClicks with minimal parameters
  def test_get_searches_no_clicks0
    req = @client.get_searches_no_clicks_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/searches/noClicks', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getSearchesNoClicks with all parameters
  def test_get_searches_no_clicks1
    req = @client.get_searches_no_clicks_with_http_info(
      "index",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/searches/noClicks', req.path)
    assert_equal(
      { 'index': "index",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'limit': "21",
        'offset': "42",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getSearchesNoResults with minimal parameters
  def test_get_searches_no_results0
    req = @client.get_searches_no_results_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/searches/noResults', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getSearchesNoResults with all parameters
  def test_get_searches_no_results1
    req = @client.get_searches_no_results_with_http_info(
      "index",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/searches/noResults', req.path)
    assert_equal(
      { 'index': "index",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'limit': "21",
        'offset': "42",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getStatus with minimal parameters
  def test_get_status0
    req = @client.get_status_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/status', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getTopCountries with minimal parameters
  def test_get_top_countries0
    req = @client.get_top_countries_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/countries', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getTopCountries with all parameters
  def test_get_top_countries1
    req = @client.get_top_countries_with_http_info(
      "index",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/countries', req.path)
    assert_equal(
      { 'index': "index",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'limit': "21",
        'offset': "42",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getTopFilterAttributes with minimal parameters
  def test_get_top_filter_attributes0
    req = @client.get_top_filter_attributes_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/filters', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getTopFilterAttributes with all parameters
  def test_get_top_filter_attributes1
    req = @client.get_top_filter_attributes_with_http_info(
      "index",
      "mySearch",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/filters', req.path)
    assert_equal(
      { 'index': "index",
        'search': "mySearch",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'limit': "21",
        'offset': "42",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getTopFilterForAttribute with minimal parameters
  def test_get_top_filter_for_attribute0
    req = @client.get_top_filter_for_attribute_with_http_info("myAttribute", "index")

    assert_equal(:get, req.method)
    assert_equal('/2/filters/myAttribute', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getTopFilterForAttribute with minimal parameters and multiple attributes
  def test_get_top_filter_for_attribute1
    req = @client.get_top_filter_for_attribute_with_http_info(
      "myAttribute1,myAttribute2",
      "index"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/filters/myAttribute1%2CmyAttribute2', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getTopFilterForAttribute with all parameters
  def test_get_top_filter_for_attribute2
    req = @client.get_top_filter_for_attribute_with_http_info(
      "myAttribute",
      "index",
      "mySearch",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/filters/myAttribute', req.path)
    assert_equal(
      { 'index': "index",
        'search': "mySearch",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'limit': "21",
        'offset': "42",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getTopFilterForAttribute with all parameters and multiple attributes
  def test_get_top_filter_for_attribute3
    req = @client.get_top_filter_for_attribute_with_http_info(
      "myAttribute1,myAttribute2",
      "index",
      "mySearch",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/filters/myAttribute1%2CmyAttribute2', req.path)
    assert_equal(
      { 'index': "index",
        'search': "mySearch",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'limit': "21",
        'offset': "42",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getTopFiltersNoResults with minimal parameters
  def test_get_top_filters_no_results0
    req = @client.get_top_filters_no_results_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/filters/noResults', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getTopFiltersNoResults with all parameters
  def test_get_top_filters_no_results1
    req = @client.get_top_filters_no_results_with_http_info(
      "index",
      "mySearch",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/filters/noResults', req.path)
    assert_equal(
      { 'index': "index",
        'search': "mySearch",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'limit': "21",
        'offset': "42",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getTopHits with minimal parameters
  def test_get_top_hits0
    req = @client.get_top_hits_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/hits', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getTopHits with all parameters
  def test_get_top_hits1
    req = @client.get_top_hits_with_http_info(
      "index",
      "mySearch",
      true,
      true,
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/hits', req.path)
    assert_equal(
      { 'index': "index",
        'search': "mySearch",
        'clickAnalytics': "true",
        'revenueAnalytics': "true",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'limit': "21",
        'offset': "42",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getTopSearches with minimal parameters
  def test_get_top_searches0
    req = @client.get_top_searches_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/searches', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getTopSearches with all parameters
  def test_get_top_searches1
    req = @client.get_top_searches_with_http_info(
      "index",
      true,
      true,
      "1999-09-19",
      "2001-01-01",
      'searchCount',
      'asc',
      21,
      42,
      "tag"
    )

    assert_equal(:get, req.method)
    assert_equal('/2/searches', req.path)
    assert_equal(
      { 'index': "index",
        'clickAnalytics': "true",
        'revenueAnalytics': "true",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'orderBy': "searchCount",
        'direction': "asc",
        'limit': "21",
        'offset': "42",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # e2e with complex query params
  def test_get_top_searches2
    req = @client.get_top_searches_with_http_info("cts_e2e_space in index")

    assert_equal(:get, req.method)
    assert_equal('/2/searches', req.path)
    assert_equal({ 'index': "cts_e2e_space%20in%20index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')

    res = @e2e_client.get_top_searches_with_http_info("cts_e2e_space in index")

    assert_equal(res.status, 200)
    res = @e2e_client.get_top_searches("cts_e2e_space in index")
    expected_body = JSON.parse('{"searches":[{"search":"","nbHits":0}]}')
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

  # get getUsersCount with minimal parameters
  def test_get_users_count0
    req = @client.get_users_count_with_http_info("index")

    assert_equal(:get, req.method)
    assert_equal('/2/users/count', req.path)
    assert_equal({ 'index': "index" }.to_a, req.query_params.to_a)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getUsersCount with all parameters
  def test_get_users_count1
    req = @client.get_users_count_with_http_info("index", "1999-09-19", "2001-01-01", "tag")

    assert_equal(:get, req.method)
    assert_equal('/2/users/count', req.path)
    assert_equal(
      { 'index': "index",
        'startDate': "1999-09-19",
        'endDate': "2001-01-01",
        'tags': "tag" }.to_a,
      req.query_params.to_a
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end
end
