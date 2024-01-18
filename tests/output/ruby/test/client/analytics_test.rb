require 'algolia'
require 'test/unit'

class TestClientAnalyticsClient < Test::Unit::TestCase
  include Algolia::Analytics
  def test_common_api0
    client = Algolia::AnalyticsClient.create(
      'APP_ID',
      'API_KEY',
      'us',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_post_with_http_info("/test")
    assert(req.headers['user-agent'].match(/^Algolia for Ruby \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Analytics (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/))
  end

  def test_common_api1
    client = Algolia::AnalyticsClient.create(
      'APP_ID',
      'API_KEY',
      'us',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_get_with_http_info("/test")
    assert_equal(2000, req.connect_timeout)
    assert_equal(5000, req.timeout)
  end

  def test_common_api2
    client = Algolia::AnalyticsClient.create(
      'APP_ID',
      'API_KEY',
      'us',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_post_with_http_info("/test")
    assert_equal(2000, req.connect_timeout)
    assert_equal(30_000, req.timeout)
  end

  def test_parameters0
    client = Algolia::AnalyticsClient.create(
      'my-app-id',
      'my-api-key',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.get_average_click_position_with_http_info("my-index")
    assert_equal('analytics.algolia.com', req.host.url)
  end

  def test_parameters1
    client = Algolia::AnalyticsClient.create(
      'my-app-id',
      'my-api-key',
      'de',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_post_with_http_info("/test")
    assert_equal('analytics.de.algolia.com', req.host.url)
  end

  def test_parameters2
    Algolia::AnalyticsClient.create(
      'my-app-id',
      'my-api-key',
      'not_a_region',
      { requester: Algolia::Transport::EchoRequester.new }
    )
  rescue => e
    assert_equal('`region` must be one of the following: de, us', e.message)
  end

  def test_parameters3
    client = Algolia::AnalyticsClient.create(
      'APP_ID',
      'API_KEY',
      'us',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    begin
      client.get_click_positions_with_http_info(nil)
    rescue => e
      assert_equal('Parameter `index` is required when calling `get_click_positions`.', e.message)
    end
  end
end
