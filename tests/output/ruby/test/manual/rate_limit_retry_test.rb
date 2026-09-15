# frozen_string_literal: true

require "algolia"
require "json"
require "test/unit"

# Requester answering each host from its own queue of scripted responses, in
# order, repeating the last one once the queue is spent. Records every attempt.
class ScriptedRequester
  Attempt = Struct.new(:host, :connect_timeout)

  attr_reader :attempts

  # @param script [Hash{String => Array<Hash>}] Response options per host url
  def initialize(script)
    @script = script.transform_values(&:dup)
    @attempts = []
  end

  def send_request(host, _method, _path, _body, _query_params, _headers, _timeout, connect_timeout)
    @attempts << Attempt.new(host, connect_timeout)
    queue = @script.fetch(host.url)
    opts = queue.length > 1 ? queue.shift : queue.first

    Algolia::Http::Response.new({host: host}.merge(opts))
  end
end

class TestRateLimitRetry < Test::Unit::TestCase
  include CallType

  OK = {status: 200, body: JSON.generate({:message => "ok"}), headers: {}}.freeze
  SERVER_ERROR = {status: 500, error: "unavailable", headers: {}}.freeze

  def rate_limited(headers = {"Retry-After" => "2"})
    {status: 429, error: JSON.generate({:message => "Too many requests"}), headers: headers}
  end

  def html_rate_limited
    {
      status: 429,
      error: "<html><body>429 Too Many Requests</body></html>",
      headers: {"content-type" => "text/html; charset=utf-8"},
      reason_phrase: "Too Many Requests"
    }
  end

  def host(url)
    Algolia::Transport::StatefulHost.new(url, accept: READ | WRITE)
  end

  # Builds a search client over the scripted requester, recording every wait
  # instead of sleeping.
  def client_for(script, opts = {})
    @requester = ScriptedRequester.new(script)
    @waits = []
    @hosts = script.keys.map { |url| host(url) }
    config = Algolia::Configuration.new(
      "test-app-id",
      "test-api-key",
      @hosts,
      "Search",
      {requester: @requester}.merge(opts)
    )
    client = Algolia::SearchClient.create_with_config(config)
    client.api_client.transporter.sleeper = ->(seconds) { @waits << seconds }
    client
  end

  def wait_seconds(headers)
    client = client_for({"localhost" => [OK]})
    client.api_client.transporter.send(:rate_limit_wait_seconds, headers)
  end

  def test_parses_retry_after_whole_seconds
    assert_equal(2, wait_seconds({"Retry-After" => "2"}))
    assert_equal(3, wait_seconds({"Retry-After" => " 3 "}))
    assert_equal(7, wait_seconds({"Retry-After" => "007"}))
  end

  def test_retry_after_header_key_is_case_insensitive
    assert_equal(5, wait_seconds({"retry-after" => "5"}))
    assert_equal(5, wait_seconds({"RETRY-AFTER" => "5"}))
    assert_equal(5, wait_seconds({:"Retry-After" => "5"}))
  end

  def test_invalid_retry_after_waits_one_second
    assert_equal(1, wait_seconds({}))
    assert_equal(1, wait_seconds({"Retry-After" => ""}))
    assert_equal(1, wait_seconds({"Retry-After" => "0"}))
    assert_equal(1, wait_seconds({"Retry-After" => "-5"}))
    assert_equal(1, wait_seconds({"Retry-After" => "abc"}))
    assert_equal(1, wait_seconds({"Retry-After" => "1.5"}))
    assert_equal(1, wait_seconds({"Retry-After" => "Wed, 21 Oct 2015 07:28:00 GMT"}))
    # Non-ASCII digits are not a whole number of seconds.
    assert_equal(1, wait_seconds({"Retry-After" => "٣"}))
  end

  def test_missing_headers_wait_one_second
    # Http::Response defaults headers to "" on timeouts and network failures.
    assert_equal(1, wait_seconds(""))
    assert_equal(1, wait_seconds(nil))
  end

  def test_huge_retry_after_saturates_at_the_sleep_ceiling
    ceiling = Algolia::Defaults::MAX_RATE_LIMIT_WAIT

    assert_equal(ceiling, wait_seconds({"Retry-After" => (ceiling + 1).to_s}))
    assert_equal(ceiling, wait_seconds({"Retry-After" => "9" * 40}))
    assert_equal(ceiling - 1, wait_seconds({"Retry-After" => (ceiling - 1).to_s}))
  end

  def test_retries_429_on_the_same_host_after_retry_after
    client = client_for({"host-a" => [rate_limited, OK]})

    response = client.custom_get_with_http_info("1/test")

    assert_equal(200, response.status)
    assert_equal([2], @waits)
    assert_equal(%w[host-a host-a], @requester.attempts.map { |attempt| attempt.host.url })
    # A waited-out 429 is not a failover: the host stays up and its connect
    # timeout is not inflated on the second attempt.
    assert_true(@hosts.first.up)
    assert_equal(0, @hosts.first.retry_count)
    assert_equal(@requester.attempts.first.connect_timeout, @requester.attempts.last.connect_timeout)
  end

  def test_retries_429_with_a_one_second_wait_when_retry_after_is_missing
    client = client_for({"host-a" => [rate_limited({}), OK]})

    response = client.custom_get_with_http_info("1/test")

    assert_equal(200, response.status)
    assert_equal([1], @waits)
    assert_equal(2, @requester.attempts.length)
  end

  def test_zero_retries_fails_on_the_first_429_without_waiting
    client = client_for({"host-a" => [rate_limited, OK]}, max_rate_limit_retries: 0)

    error = assert_raise(Algolia::AlgoliaHttpError) { client.custom_get("1/test") }

    assert_equal(429, error.code)
    assert_equal("429: Too many requests", error.message)
    assert_equal([], @waits)
    assert_equal(1, @requester.attempts.length)
  end

  def test_negative_retries_behave_like_zero
    client = client_for({"host-a" => [rate_limited, OK]}, max_rate_limit_retries: -1)

    error = assert_raise(Algolia::AlgoliaHttpError) { client.custom_get("1/test") }

    assert_equal(429, error.code)
    assert_equal([], @waits)
    assert_equal(1, @requester.attempts.length)
  end

  def test_returns_429_after_the_budget_is_used_up
    client = client_for({"host-a" => [rate_limited]})

    error = assert_raise(Algolia::AlgoliaHttpError) { client.custom_get("1/test") }

    assert_equal(429, error.code)
    assert_equal("429: Too many requests", error.message)
    assert_equal([2, 2, 2], @waits)
    assert_equal(4, @requester.attempts.length)
    assert_true(@hosts.first.up)
  end

  def test_html_429_is_raised_with_its_reason_phrase_after_the_budget
    client = client_for({"host-a" => [html_rate_limited]})

    error = assert_raise(Algolia::AlgoliaHttpError) { client.custom_get("1/test") }

    assert_equal("429: Too Many Requests", error.message)
    assert_equal([1, 1, 1], @waits)
    assert_equal(4, @requester.attempts.length)
  end

  def test_5xx_still_fails_over_to_the_next_host
    client = client_for({"host-a" => [SERVER_ERROR], "host-b" => [OK]})

    response = client.custom_get_with_http_info("1/test")

    assert_equal(200, response.status)
    assert_equal([], @waits)
    assert_equal(%w[host-a host-b], @requester.attempts.map { |attempt| attempt.host.url })
    assert_false(@hosts.first.up)
  end

  def test_budget_is_shared_across_hosts
    client = client_for(
      {
        "host-a" => [rate_limited, SERVER_ERROR],
        "host-b" => [rate_limited]
      }
    )

    error = assert_raise(Algolia::AlgoliaHttpError) { client.custom_get("1/test") }

    assert_equal(429, error.code)
    assert_equal([2, 2, 2], @waits)
    assert_equal(%w[host-a host-a host-b host-b host-b], @requester.attempts.map { |attempt| attempt.host.url })
  end

  def test_waited_out_429_stays_visible_when_every_host_fails
    client = client_for(
      {
        "host-a" => [rate_limited({"Retry-After" => "2", "Correlation-ID" => "abc"}), SERVER_ERROR],
        "host-b" => [SERVER_ERROR]
      }
    )

    error = assert_raise(Algolia::AlgoliaUnreachableHostError) { client.custom_get("1/test") }

    assert_equal([2], @waits)
    assert_equal("abc", error.correlation_id)
    assert_true(error.message.end_with?("(Correlation-ID: abc)"))
    assert_equal(
      [
        {host: "host-a", error: JSON.generate({:message => "Too many requests"})},
        {host: "host-a", error: "unavailable"},
        {host: "host-b", error: "unavailable"}
      ],
      error.errors
    )
  end

  def test_configuration_defaults_to_three_retries
    config = Algolia::Configuration.new("test-app-id", "test-api-key", [host("localhost")], "Search")

    assert_nil(config.max_rate_limit_retries)
    assert_equal(3, Algolia::Defaults::MAX_RATE_LIMIT_RETRIES)
  end

  def test_create_forwards_max_rate_limit_retries
    client = Algolia::SearchClient.create("test-app-id", "test-api-key", {max_rate_limit_retries: 0})

    assert_equal(0, client.api_client.config.max_rate_limit_retries)
  end

  def test_transformation_options_override_reaches_the_ingestion_transporter
    client = Algolia::SearchClient.with_transformation(
      "test-app-id",
      "test-api-key",
      Algolia::TransformationOptions.new("us", max_rate_limit_retries: 0)
    )

    ingestion_config = client.instance_variable_get(:@ingestion_transporter).api_client.config
    assert_equal(0, ingestion_config.max_rate_limit_retries)
  end

  def test_ingestion_transporter_does_not_inherit_the_parent_setting
    client = Algolia::SearchClient.with_transformation(
      "test-app-id",
      "test-api-key",
      Algolia::TransformationOptions.new("us"),
      {max_rate_limit_retries: 0}
    )

    assert_equal(0, client.api_client.config.max_rate_limit_retries)
    ingestion_config = client.instance_variable_get(:@ingestion_transporter).api_client.config
    # nil resolves to the Ingestion default of 3 in the transporter.
    assert_nil(ingestion_config.max_rate_limit_retries)
  end
end
