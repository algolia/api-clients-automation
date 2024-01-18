require 'algolia'
require 'test/unit'

class TestClientInsightsClient < Test::Unit::TestCase
  include Algolia::Insights
  def test_common_api0
    client = Algolia::InsightsClient.create(
      'APP_ID',
      'API_KEY',
      'us',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_post_with_http_info("/test")
    assert(req.headers['user-agent'].match(/^Algolia for Ruby \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Insights (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/))
  end

  def test_common_api1
    client = Algolia::InsightsClient.create(
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
    client = Algolia::InsightsClient.create(
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
    client = Algolia::InsightsClient.create(
      'my-app-id',
      'my-api-key',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.push_events_with_http_info(
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
    assert_equal('insights.algolia.io', req.host.url)
  end

  def test_parameters1
    client = Algolia::InsightsClient.create(
      'my-app-id',
      'my-api-key',
      'us',
      { requester: Algolia::Transport::EchoRequester.new }
    )
    req = client.custom_delete_with_http_info("/test")
    assert_equal('insights.us.algolia.io', req.host.url)
  end

  def test_parameters2
    Algolia::InsightsClient.create(
      'my-app-id',
      'my-api-key',
      'not_a_region',
      { requester: Algolia::Transport::EchoRequester.new }
    )
  rescue => e
    assert_equal('`region` must be one of the following: de, us', e.message)
  end
end
