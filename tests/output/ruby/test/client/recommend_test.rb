require 'algolia'
require 'test/unit'

class TestClientRecommendClient < Test::Unit::TestCase
  include Algolia::Recommend
  def test_api0
    client = Algolia::RecommendClient.create(
      'test-app-id',
      'test-api-key',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_get_with_http_info("/test")
    assert_equal('test-app-id-dsn.algolia.net', req.host.url)
  end

  def test_api1
    client = Algolia::RecommendClient.create(
      'test-app-id',
      'test-api-key',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_post_with_http_info("/test")
    assert_equal('test-app-id.algolia.net', req.host.url)
  end

  def test_common_api0
    client = Algolia::RecommendClient.create(
      'APP_ID',
      'API_KEY',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_post_with_http_info("/test")
    assert(req.headers['user-agent'].match(/^Algolia for Ruby \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Recommend (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/))
  end

  def test_common_api1
    client = Algolia::RecommendClient.create(
      'APP_ID',
      'API_KEY',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_get_with_http_info("/test")
    assert_equal(2000, req.connect_timeout)
    assert_equal(5000, req.timeout)
  end

  def test_common_api2
    client = Algolia::RecommendClient.create(
      'APP_ID',
      'API_KEY',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_post_with_http_info("/test")
    assert_equal(2000, req.connect_timeout)
    assert_equal(30_000, req.timeout)
  end
end
