require 'algolia'
require 'test/unit'

class TestClientSearchClient < Test::Unit::TestCase
  include Algolia::Search
  # calls api with correct read host
  def test_api0
    client = Algolia::SearchClient.create(
      'test-app-id',
      'test-api-key',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_get_with_http_info("/test")
    assert_equal('test-app-id-dsn.algolia.net', req.host.url)
  end

  # calls api with correct write host
  def test_api1
    client = Algolia::SearchClient.create(
      'test-app-id',
      'test-api-key',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_post_with_http_info("/test")
    assert_equal('test-app-id.algolia.net', req.host.url)
  end

  # tests the retry strategy
  def test_api2
    client = Algolia::SearchClient.create_with_config(
      Algolia::Configuration.new(
        'test-app-id',
        'test-api-key',
        [
          Algolia::Transport::StatefulHost.new(
            'localhost',
            protocol: 'http://',
            port: 6677,
            accept: CallType::READ | CallType::WRITE
          ),
          Algolia::Transport::StatefulHost.new(
            'localhost',
            protocol: 'http://',
            port: 6678,
            accept: CallType::READ | CallType::WRITE
          )
        ],
        'searchClient'
      )
    )
    req = client.custom_get("/test/retry")
    assert_equal({ 'message': "ok test server response" }, req)
  end

  # test the compression strategy
  def test_api3
    client = Algolia::SearchClient.create_with_config(
      Algolia::Configuration.new(
        'test-app-id',
        'test-api-key',
        [Algolia::Transport::StatefulHost.new(
          'localhost',
          protocol: 'http://',
          port: 6678,
          accept: CallType::READ | CallType::WRITE
        )],
        'searchClient',
        compression_type: 'gzip'
      )
    )
    req = client.custom_post(
      "/test/gzip",
      {},
      { message: "this is a compressed body" }
    )
    assert_equal(
      { 'message': "ok compression test server response",
        'body': { 'message': "this is a compressed body" }},
      req
    )
  end

  # calls api with correct user agent
  def test_common_api0
    client = Algolia::SearchClient.create(
      'APP_ID',
      'API_KEY',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_post_with_http_info("/test")
    assert(req.headers['user-agent'].match(/^Algolia for Ruby \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Search (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/))
  end

  # calls api with default read timeouts
  def test_common_api1
    client = Algolia::SearchClient.create(
      'APP_ID',
      'API_KEY',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_get_with_http_info("/test")
    assert_equal(2000, req.connect_timeout)
    assert_equal(5000, req.timeout)
  end

  # calls api with default write timeouts
  def test_common_api2
    client = Algolia::SearchClient.create(
      'APP_ID',
      'API_KEY',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_post_with_http_info("/test")
    assert_equal(2000, req.connect_timeout)
    assert_equal(30_000, req.timeout)
  end

  # client throws with invalid parameters
  def test_parameters0
    begin
      Algolia::SearchClient.create(
        '',
        '',
        { requester: Algolia::Transport::EchoRequester.new }
      )
      assert(false, 'An error should have been raised')
    rescue => e
      assert_equal('`app_id` is missing.', e.message)
    end
    begin
      Algolia::SearchClient.create(
        '',
        'my-api-key',
        { requester: Algolia::Transport::EchoRequester.new }
      )
      assert(false, 'An error should have been raised')
    rescue => e
      assert_equal('`app_id` is missing.', e.message)
    end
    begin
      Algolia::SearchClient.create(
        'my-app-id',
        '',
        { requester: Algolia::Transport::EchoRequester.new }
      )
      assert(false, 'An error should have been raised')
    rescue => e
      assert_equal('`api_key` is missing.', e.message)
    end
  end

  # `addApiKey` throws with invalid parameters
  def test_parameters1
    client = Algolia::SearchClient.create(
      'APP_ID',
      'API_KEY',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    begin
      client.add_api_key_with_http_info(nil)
      assert(false, 'An error should have been raised')
    rescue => e
      assert_equal('Parameter `api_key` is required when calling `add_api_key`.', e.message)
    end
  end

  # `addOrUpdateObject` throws with invalid parameters
  def test_parameters2
    client = Algolia::SearchClient.create(
      'APP_ID',
      'API_KEY',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    begin
      client.add_or_update_object_with_http_info(nil, "my-object-id", {})
      assert(false, 'An error should have been raised')
    rescue => e
      assert_equal(
        'Parameter `index_name` is required when calling `add_or_update_object`.',
        e.message
      )
    end
    begin
      client.add_or_update_object_with_http_info("my-index-name", nil, {})
      assert(false, 'An error should have been raised')
    rescue => e
      assert_equal(
        'Parameter `object_id` is required when calling `add_or_update_object`.',
        e.message
      )
    end
    begin
      client.add_or_update_object_with_http_info("my-index-name", "my-object-id", nil)
      assert(false, 'An error should have been raised')
    rescue => e
      assert_equal('Parameter `body` is required when calling `add_or_update_object`.', e.message)
    end
  end
end
