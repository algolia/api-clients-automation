require "algolia"
require "test/unit"
require "time"

class TestTimeoutIntegration < Test::Unit::TestCase
  include CallType

  TEST_SERVER = ENV.fetch("CI", nil) == "true" ? "localhost" : "host.docker.internal"

  def create_config_with_host(host_url)
    host = Algolia::Transport::StatefulHost.new(
      host_url,
      accept: READ | WRITE
    )
    config = Algolia::Configuration.new(
      "test-app",
      "test-key",
      [host],
      "TestClient",
      connect_timeout: 2000
    )
    [config, host]
  end

  def create_server_host
    Algolia::Transport::StatefulHost.new(
      TEST_SERVER,
      protocol: "http://",
      port: 6676,
      accept: READ | WRITE
    )
  end

  # connect timeout increases across failed requests: 2s -> 4s -> 6s
  def test_retry_count_stateful
    config, _ = create_config_with_host("10.255.255.1")
    requester = Algolia::Http::HttpRequester.new("net_http_persistent", Algolia::LoggerHelper.create)
    transporter = Algolia::Transport::Transport.new(config, requester)

    times = []
    3.times do
      start_time = Time.now
      begin
        transporter.request(READ, :GET, "/test", nil, {})
      rescue StandardError
        times << (Time.now - start_time)
      end
    end

    assert(times[0] > 1.5 && times[0] < 2.5, "Request 1 should be ~2s, got #{times[0].round(2)}s")
    assert(times[1] > 3.5 && times[1] < 4.5, "Request 2 should be ~4s, got #{times[1].round(2)}s")
    assert(times[2] > 5.5 && times[2] < 7.0, "Request 3 should be ~6s, got #{times[2].round(2)}s")
  end

  # retry_count resets to 0 after successful request
  def test_retry_count_resets
    config, bad_host = create_config_with_host("10.255.255.1")
    good_host = create_server_host
    requester = Algolia::Http::HttpRequester.new("net_http_persistent", Algolia::LoggerHelper.create)
    transporter = Algolia::Transport::Transport.new(config, requester)

    # fail twice to increment retry_count
    2.times do
      begin
        transporter.request(READ, :GET, "/test", nil, {})
      rescue StandardError
        # ignore failures
      end
    end

    # switch to good host and succeed
    config.hosts = [good_host]
    retry_strategy = Algolia::Transport::RetryStrategy.new([good_host])
    transporter.instance_variable_set(:@retry_strategy, retry_strategy)
    good_host.retry_count = bad_host.retry_count

    response = transporter.request(READ, :GET, "/1/test/instant", nil, {})
    assert_equal(200, response.status, "Request should succeed with 200")
    assert_equal(0, good_host.retry_count, "retry_count should reset to 0, got #{good_host.retry_count}")

    # point to bad host again, should timeout at 2s (not 6s)
    good_host.instance_variable_set(:@url, "10.255.255.1")
    good_host.instance_variable_set(:@protocol, "https://")

    start_time = Time.now
    begin
      transporter.request(READ, :GET, "/test", nil, {})
      flunk("Request should have timed out")
    rescue StandardError
      elapsed = Time.now - start_time
      assert(elapsed > 1.5 && elapsed < 2.5, "After reset should be ~2s, got #{elapsed.round(2)}s")
    end
  end
end
