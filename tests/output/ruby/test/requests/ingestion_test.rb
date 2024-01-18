require 'algolia'
require 'test/unit'
require 'dotenv'
require_relative '../helpers'

Dotenv.load('../../.env')

class TestIngestionClient < Test::Unit::TestCase
  include Algolia::Ingestion
  def setup
    @client = Algolia::IngestionClient.create(
      'APP_ID',
      'API_KEY',
      'us',
      { requester: Algolia::Transport::EchoRequester.new }
    )
  end

  # createAuthenticationOAuth
  def test_create_authentication0
    req = @client.create_authentication_with_http_info(
      AuthenticationCreate.new(
        type: 'oauth',
        name: "authName",
        input: AuthOAuth.new(url: "http://test.oauth", client_id: "myID", client_secret: "mySecret")
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/authentications', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"type":"oauth","name":"authName","input":{"url":"http://test.oauth","client_id":"myID","client_secret":"mySecret"}}'), JSON.parse(req.body)
    )
  end

  # createAuthenticationAlgolia
  def test_create_authentication1
    req = @client.create_authentication_with_http_info(
      AuthenticationCreate.new(
        type: 'algolia',
        name: "authName",
        input: AuthAlgolia.new(app_id: "myappID", api_key: "randomApiKey")
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/authentications', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"type":"algolia","name":"authName","input":{"appID":"myappID","apiKey":"randomApiKey"}}'), JSON.parse(req.body)
    )
  end

  # createDestination
  def test_create_destination0
    req = @client.create_destination_with_http_info(
      DestinationCreate.new(
        type: 'search',
        name: "destinationName",
        input: DestinationIndexPrefix.new(index_prefix: "prefix_"),
        authentication_id: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/destinations', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"type":"search","name":"destinationName","input":{"indexPrefix":"prefix_"},"authenticationID":"6c02aeb1-775e-418e-870b-1faccd4b2c0f"}'), JSON.parse(req.body)
    )
  end

  # createSource
  def test_create_source0
    req = @client.create_source_with_http_info(
      SourceCreate.new(
        type: 'commercetools',
        name: "sourceName",
        input: SourceCommercetools.new(
          store_keys: ["myStore"],
          locales: ["de"],
          url: "http://commercetools.com",
          project_key: "keyID"
        ),
        authentication_id: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/sources', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"type":"commercetools","name":"sourceName","input":{"storeKeys":["myStore"],"locales":["de"],"url":"http://commercetools.com","projectKey":"keyID"},"authenticationID":"6c02aeb1-775e-418e-870b-1faccd4b2c0f"}'), JSON.parse(req.body)
    )
  end

  # createTaskOnDemand
  def test_create_task0
    req = @client.create_task_with_http_info(
      TaskCreate.new(
        source_id: "search",
        destination_id: "destinationName",
        trigger: OnDemandTriggerInput.new(type: 'onDemand'),
        action: 'replace'
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/tasks', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"sourceID":"search","destinationID":"destinationName","trigger":{"type":"onDemand"},"action":"replace"}'), JSON.parse(req.body)
    )
  end

  # createTaskSchedule
  def test_create_task1
    req = @client.create_task_with_http_info(
      TaskCreate.new(
        source_id: "search",
        destination_id: "destinationName",
        trigger: ScheduleTriggerInput.new(type: 'schedule', cron: "* * * * *"),
        action: 'replace'
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/tasks', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"sourceID":"search","destinationID":"destinationName","trigger":{"type":"schedule","cron":"* * * * *"},"action":"replace"}'), JSON.parse(req.body)
    )
  end

  # createTaskSubscription
  def test_create_task2
    req = @client.create_task_with_http_info(
      TaskCreate.new(
        source_id: "search",
        destination_id: "destinationName",
        trigger: OnDemandTriggerInput.new(type: 'onDemand'),
        action: 'replace'
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/tasks', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"sourceID":"search","destinationID":"destinationName","trigger":{"type":"onDemand"},"action":"replace"}'), JSON.parse(req.body)
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

  # deleteAuthentication
  def test_delete_authentication0
    req = @client.delete_authentication_with_http_info("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

    assert_equal(:delete, req.method)
    assert_equal('/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # deleteDestination
  def test_delete_destination0
    req = @client.delete_destination_with_http_info("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

    assert_equal(:delete, req.method)
    assert_equal('/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # deleteSource
  def test_delete_source0
    req = @client.delete_source_with_http_info("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

    assert_equal(:delete, req.method)
    assert_equal('/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # deleteTask
  def test_delete_task0
    req = @client.delete_task_with_http_info("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

    assert_equal(:delete, req.method)
    assert_equal('/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # disableTask
  def test_disable_task0
    req = @client.disable_task_with_http_info("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

    assert_equal(:put, req.method)
    assert_equal('/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/disable', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
  end

  # enableTask
  def test_enable_task0
    req = @client.enable_task_with_http_info("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

    assert_equal(:put, req.method)
    assert_equal('/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/enable', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
  end

  # getAuthentication
  def test_get_authentication0
    req = @client.get_authentication_with_http_info("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

    assert_equal(:get, req.method)
    assert_equal('/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getAuthentications
  def test_get_authentications0
    req = @client.get_authentications_with_http_info

    assert_equal(:get, req.method)
    assert_equal('/1/authentications', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getDestination
  def test_get_destination0
    req = @client.get_destination_with_http_info("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

    assert_equal(:get, req.method)
    assert_equal('/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getDestinations
  def test_get_destinations0
    req = @client.get_destinations_with_http_info

    assert_equal(:get, req.method)
    assert_equal('/1/destinations', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getDockerSourceStreams
  def test_get_docker_source_streams0
    req = @client.get_docker_source_streams_with_http_info("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

    assert_equal(:get, req.method)
    assert_equal('/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getEvent
  def test_get_event0
    req = @client.get_event_with_http_info(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      "6c02aeb1-775e-418e-870b-1faccd4b2c0c"
    )

    assert_equal(:get, req.method)
    assert_equal(
      '/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events/6c02aeb1-775e-418e-870b-1faccd4b2c0c', req.path
    )
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getEvents
  def test_get_events0
    req = @client.get_events_with_http_info("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

    assert_equal(:get, req.method)
    assert_equal('/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getRun
  def test_get_run0
    req = @client.get_run_with_http_info("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

    assert_equal(:get, req.method)
    assert_equal('/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getRuns
  def test_get_runs0
    req = @client.get_runs_with_http_info

    assert_equal(:get, req.method)
    assert_equal('/1/runs', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getSource
  def test_get_source0
    req = @client.get_source_with_http_info("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

    assert_equal(:get, req.method)
    assert_equal('/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getSources
  def test_get_sources0
    req = @client.get_sources_with_http_info

    assert_equal(:get, req.method)
    assert_equal('/1/sources', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getTask
  def test_get_task0
    req = @client.get_task_with_http_info("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

    assert_equal(:get, req.method)
    assert_equal('/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getTasks
  def test_get_tasks0
    req = @client.get_tasks_with_http_info

    assert_equal(:get, req.method)
    assert_equal('/1/tasks', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # runTask
  def test_run_task0
    req = @client.run_task_with_http_info("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

    assert_equal(:post, req.method)
    assert_equal('/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/run', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
  end

  # searchAuthentications
  def test_search_authentications0
    req = @client.search_authentications_with_http_info(
      AuthenticationSearch.new(
        authentication_ids: [
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
        ]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/authentications/search', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"authenticationIDs":["6c02aeb1-775e-418e-870b-1faccd4b2c0f","947ac9c4-7e58-4c87-b1e7-14a68e99699a"]}'), JSON.parse(req.body)
    )
  end

  # searchDestinations
  def test_search_destinations0
    req = @client.search_destinations_with_http_info(
      DestinationSearch.new(
        destination_ids: [
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
        ]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/destinations/search', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"destinationIDs":["6c02aeb1-775e-418e-870b-1faccd4b2c0f","947ac9c4-7e58-4c87-b1e7-14a68e99699a"]}'), JSON.parse(req.body)
    )
  end

  # searchSources
  def test_search_sources0
    req = @client.search_sources_with_http_info(
      SourceSearch.new(
        source_ids: [
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
        ]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/sources/search', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"sourceIDs":["6c02aeb1-775e-418e-870b-1faccd4b2c0f","947ac9c4-7e58-4c87-b1e7-14a68e99699a"]}'), JSON.parse(req.body)
    )
  end

  # searchTasks
  def test_search_tasks0
    req = @client.search_tasks_with_http_info(
      TaskSearch.new(
        task_ids: [
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
        ]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/tasks/search', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"taskIDs":["6c02aeb1-775e-418e-870b-1faccd4b2c0f","947ac9c4-7e58-4c87-b1e7-14a68e99699a"]}'), JSON.parse(req.body)
    )
  end

  # triggerDockerSourceDiscover
  def test_trigger_docker_source_discover0
    req = @client.trigger_docker_source_discover_with_http_info("6c02aeb1-775e-418e-870b-1faccd4b2c0f")

    assert_equal(:post, req.method)
    assert_equal('/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
  end

  # updateAuthentication
  def test_update_authentication0
    req = @client.update_authentication_with_http_info(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      AuthenticationUpdate.new(name: "newName")
    )

    assert_equal(:patch, req.method)
    assert_equal('/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"name":"newName"}'), JSON.parse(req.body))
  end

  # updateDestination
  def test_update_destination0
    req = @client.update_destination_with_http_info(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      DestinationUpdate.new(name: "newName")
    )

    assert_equal(:patch, req.method)
    assert_equal('/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"name":"newName"}'), JSON.parse(req.body))
  end

  # updateSource
  def test_update_source0
    req = @client.update_source_with_http_info(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      SourceUpdate.new(name: "newName")
    )

    assert_equal(:patch, req.method)
    assert_equal('/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"name":"newName"}'), JSON.parse(req.body))
  end

  # updateTask
  def test_update_task0
    req = @client.update_task_with_http_info(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      TaskUpdate.new(enabled: false)
    )

    assert_equal(:patch, req.method)
    assert_equal('/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"enabled":false}'), JSON.parse(req.body))
  end
end
