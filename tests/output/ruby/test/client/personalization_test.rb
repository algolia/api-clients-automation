require 'algolia'
require 'test/unit'

class TestClientPersonalizationClient < Test::Unit::TestCase
  include Algolia::Personalization
  def test_common_api0
    client = Algolia::PersonalizationClient.create(
      'APP_ID',
      'API_KEY',
      'us',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_post_with_http_info("/test")
    assert(req.headers['user-agent'].match(/^Algolia for Ruby \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Personalization (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/))
  end

  def test_common_api1
    client = Algolia::PersonalizationClient.create(
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
    client = Algolia::PersonalizationClient.create(
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
    Algolia::PersonalizationClient.create(
      'my-app-id',
      'my-api-key',
      '',
      { requester: Algolia::Transport::EchoRequester.new }
    )
  rescue => e
    assert_equal('`region` is required and must be one of the following: eu, us', e.message)
  end

  def test_parameters1
    Algolia::PersonalizationClient.create(
      'my-app-id',
      'my-api-key',
      'not_a_region',
      { requester: Algolia::Transport::EchoRequester.new }
    )
  rescue => e
    assert_equal('`region` is required and must be one of the following: eu, us', e.message)
  end

  def test_parameters2
    client = Algolia::PersonalizationClient.create(
      'my-app-id',
      'my-api-key',
      'us',
      { requester: Algolia::Transport::EchoRequester.new }
    )
  end
end
