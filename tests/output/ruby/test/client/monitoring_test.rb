require 'algolia'
require 'test/unit'

class TestClientMonitoringClient < Test::Unit::TestCase
  include Algolia::Monitoring
  def test_common_api0
    client = Algolia::MonitoringClient.create(
      'APP_ID',
      'API_KEY',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_post_with_http_info("/test")
    assert(req.headers['user-agent'].match(/^Algolia for Ruby \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Monitoring (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/))
  end

  def test_common_api1
    client = Algolia::MonitoringClient.create(
      'APP_ID',
      'API_KEY',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_get_with_http_info("/test")
    assert_equal(2000, req.connect_timeout)
    assert_equal(5000, req.timeout)
  end

  def test_common_api2
    client = Algolia::MonitoringClient.create(
      'APP_ID',
      'API_KEY',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_post_with_http_info("/test")
    assert_equal(2000, req.connect_timeout)
    assert_equal(30_000, req.timeout)
  end

  def test_parameters0
    client = Algolia::MonitoringClient.create(
      'my-app-id',
      'my-api-key',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_delete_with_http_info("/test")
    assert_equal('status.algolia.com', req.host.url)
  end
end
