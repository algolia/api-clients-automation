require 'algolia'
require 'test/unit'

class TestClientSearchClient < Test::Unit::TestCase
  include Algolia::Search
  def test_api0
    client = Algolia::SearchClient.create(
      'test-app-id',
      'test-api-key',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_get_with_http_info("/test")
    assert_equal('test-app-id-dsn.algolia.net', req.host.url)
  end

  def test_api1
    client = Algolia::SearchClient.create(
      'test-app-id',
      'test-api-key',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_post_with_http_info("/test")
    assert_equal('test-app-id.algolia.net', req.host.url)
  end

  def test_common_api0
    client = Algolia::SearchClient.create(
      'APP_ID',
      'API_KEY',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_post_with_http_info("/test")
    assert(req.headers['user-agent'].match(/^Algolia for Ruby \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Search (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/))
  end

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

  def test_parameters0
    begin
      Algolia::SearchClient.create(
        '',
        '',
        { requester: Algolia::Transport::EchoRequester.new }
      )
    rescue => e
      assert_equal('`app_id` is missing.', e.message)
    end
    begin
      Algolia::SearchClient.create(
        '',
        'my-api-key',
        { requester: Algolia::Transport::EchoRequester.new }
      )
    rescue => e
      assert_equal('`app_id` is missing.', e.message)
    end
    begin
      Algolia::SearchClient.create(
        'my-app-id',
        '',
        { requester: Algolia::Transport::EchoRequester.new }
      )
    rescue => e
      assert_equal('`api_key` is missing.', e.message)
    end
  end

  def test_parameters1
    client = Algolia::SearchClient.create(
      'APP_ID',
      'API_KEY',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    begin
      client.add_api_key_with_http_info(nil)
    rescue => e
      assert_equal('Parameter `api_key` is required when calling `add_api_key`.', e.message)
    end
  end

  def test_parameters2
    client = Algolia::SearchClient.create(
      'APP_ID',
      'API_KEY',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    begin
      client.add_or_update_object_with_http_info(nil, "my-object-id", {})
    rescue => e
      assert_equal(
        'Parameter `index_name` is required when calling `add_or_update_object`.',
        e.message
      )
    end
    begin
      client.add_or_update_object_with_http_info("my-index-name", nil, {})
    rescue => e
      assert_equal(
        'Parameter `object_id` is required when calling `add_or_update_object`.',
        e.message
      )
    end
    begin
      client.add_or_update_object_with_http_info("my-index-name", "my-object-id", nil)
    rescue => e
      assert_equal('Parameter `body` is required when calling `add_or_update_object`.', e.message)
    end
  end
end
