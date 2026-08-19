# frozen_string_literal: true

require "algolia"
require "test/unit"

# Requester failing with a network error until the configured number of
# attempts is reached, recording the Request-ID header of every attempt.
class FailingThenSucceedingRequester
  attr_reader :request_ids

  def initialize(failures)
    @failures = failures
    @attempts = 0
    @request_ids = []
  end

  def send_request(host, method, path, body, query_params, headers, timeout, connect_timeout)
    @request_ids << headers["request-id"]
    @attempts += 1

    if @attempts <= @failures
      return Algolia::Http::Response.new(host: host, network_failure: true, error: "network down")
    end

    Algolia::Http::Response.new(host: host, status: 200, body: body, headers: headers, method: method, path: path)
  end
end

# Requester recording every request, answering DELETE calls with a cleanup
# error and everything else with a fixed root-cause error.
class CleanupRecordingRequester
  Recorded = Struct.new(:method, :path, :headers, :timeout, :connect_timeout)

  attr_reader :requests

  def initialize
    @requests = []
  end

  def send_request(host, method, path, _body, _query_params, headers, timeout, connect_timeout)
    @requests << Recorded.new(method, path, headers, timeout, connect_timeout)

    if method == :delete
      Algolia::Http::Response.new(
        host: host,
        status: 403,
        error: JSON.generate({:message => "cleanup denied"}),
        headers: {}
      )
    else
      Algolia::Http::Response.new(
        host: host,
        status: 400,
        error: JSON.generate({:message => "root cause"}),
        headers: {}
      )
    end
  end
end

# Requester answering every request with a fixed error response.
class ErrorRequester
  def initialize(status, error_body, headers, reason_phrase: nil)
    @status = status
    @error_body = error_body
    @headers = headers
    @reason_phrase = reason_phrase
  end

  def send_request(host, _method, _path, _body, _query_params, _headers, _timeout, _connect_timeout)
    Algolia::Http::Response.new(
      host: host,
      status: @status,
      error: @error_body,
      headers: @headers,
      reason_phrase: @reason_phrase
    )
  end
end

class TestRequestId < Test::Unit::TestCase
  include CallType

  REQUEST_ID_FORMAT = /\A[0-9A-Za-z]{11}\z/

  def search_config(requester: Algolia::Transport::EchoRequester.new, hosts: nil)
    hosts ||= [Algolia::Transport::StatefulHost.new("localhost", accept: READ | WRITE)]
    Algolia::Configuration.new("test-app-id", "test-api-key", hosts, "Search", requester: requester)
  end

  def search_client(config = search_config)
    Algolia::SearchClient.create_with_config(config)
  end

  def test_generate_format_and_uniqueness
    ids = Array.new(100) { Algolia::Transport::RequestId.generate }

    ids.each { |id| assert_match(REQUEST_ID_FORMAT, id) }
    assert_operator(ids.uniq.length, :>, 90, "IDs are expected to be essentially unique")
  end

  def test_request_id_predicate_is_case_insensitive
    assert_false(Algolia::Transport::RequestId.request_id?(nil))
    assert_false(Algolia::Transport::RequestId.request_id?(""))
    assert_false(Algolia::Transport::RequestId.request_id?({"x-forwarded-for" => "1"}))
    assert_true(Algolia::Transport::RequestId.request_id?({"request-id" => "a"}))
    assert_true(Algolia::Transport::RequestId.request_id?({"ReQuEsT-iD" => "a"}))
    assert_true(Algolia::Transport::RequestId.request_id?({:"REQUEST-ID" => "a"}))
  end

  def test_request_id_query_param_predicate_is_case_insensitive
    assert_false(Algolia::Transport::RequestId.request_id_query_param?(nil))
    assert_false(Algolia::Transport::RequestId.request_id_query_param?(""))
    assert_false(Algolia::Transport::RequestId.request_id_query_param?({"query" => "a"}))
    assert_true(Algolia::Transport::RequestId.request_id_query_param?({"x-algolia-request-id" => "a"}))
    assert_true(Algolia::Transport::RequestId.request_id_query_param?({"X-Algolia-Request-Id" => "a"}))
    assert_true(Algolia::Transport::RequestId.request_id_query_param?({:"X-ALGOLIA-REQUEST-ID" => "a"}))
  end

  def test_mints_fresh_request_id_per_call
    client = search_client

    first = client.custom_get_with_http_info("1/test")
    second = client.custom_get_with_http_info("1/test")

    assert_match(REQUEST_ID_FORMAT, first.headers["request-id"])
    assert_match(REQUEST_ID_FORMAT, second.headers["request-id"])
    assert_not_equal(first.headers["request-id"], second.headers["request-id"])
  end

  def test_reuses_request_id_across_retries
    requester = FailingThenSucceedingRequester.new(2)
    hosts = Array.new(3) { Algolia::Transport::StatefulHost.new("localhost", accept: READ | WRITE) }
    client = search_client(search_config(requester: requester, hosts: hosts))

    client.custom_get("1/test")

    assert_equal(3, requester.request_ids.length)
    assert_match(REQUEST_ID_FORMAT, requester.request_ids[0])
    assert_equal([requester.request_ids[0]], requester.request_ids.uniq)
  end

  def test_caller_supplied_request_id_survives_retries
    requester = FailingThenSucceedingRequester.new(2)
    hosts = Array.new(3) { Algolia::Transport::StatefulHost.new("localhost", accept: READ | WRITE) }
    client = search_client(search_config(requester: requester, hosts: hosts))

    client.custom_get("1/test", {}, {:header_params => {"ReQuEsT-iD" => "CallerOwnedId"}})

    # Request options are consumed on attempt 1: retries must re-apply the caller's ID.
    assert_equal(3, requester.request_ids.length)
    assert_equal(["CallerOwnedId"], requester.request_ids.uniq)
  end

  def test_caller_supplied_request_id_survives_retries_when_disabled
    requester = FailingThenSucceedingRequester.new(2)
    hosts = Array.new(3) { Algolia::Transport::StatefulHost.new("localhost", accept: READ | WRITE) }
    config = search_config(requester: requester, hosts: hosts)
    config.request_id_enabled = false
    client = search_client(config)

    client.custom_get("1/test", {}, {:header_params => {"ReQuEsT-iD" => "CallerOwnedId"}})

    # Caller request options ride every attempt regardless of the flag.
    assert_equal(3, requester.request_ids.length)
    assert_equal(["CallerOwnedId"], requester.request_ids.uniq)
  end

  def test_caller_supplied_request_id_wins
    client = search_client

    res = client.custom_get_with_http_info("1/test", {}, {:header_params => {"ReQuEsT-iD" => "CallerOwnedId"}})

    # Header keys are downcased before the merge, so a minted ID could only land on this key.
    assert_equal("CallerOwnedId", res.headers["request-id"])
  end

  def test_caller_supplied_query_param_request_id_wins
    client = search_client

    res = client.custom_get_with_http_info("1/test", {}, {:query_params => {"X-Algolia-Request-Id" => "QueryOwned"}})

    # The server consults the query parameter only when the header is absent,
    # so minting a header here would override the caller's value.
    assert_false(res.headers.any? { |k, _| k.to_s.casecmp?("request-id") })
    assert_true(res.query_params.any? { |k, _| k.to_s.casecmp?("X-Algolia-Request-Id") })
  end

  def test_transport_never_mints_over_query_param_request_id
    config = search_config
    transport = Algolia::Transport::Transport.new(config, config.requester, request_id_enabled: true)

    res = transport.request(READ, :GET, "/1/test", nil, {:query_params => {:"x-algolia-request-id" => "QueryOwned"}})

    assert_false(res.headers.any? { |k, _| k.to_s.casecmp?("request-id") })
  end

  def test_config_header_request_id_wins
    config = search_config
    config.header_params["REQUEST-ID"] = "ConfigOwned"
    client = search_client(config)

    res = client.custom_get_with_http_info("1/test")

    assert_equal("ConfigOwned", res.headers["REQUEST-ID"])
    assert_nil(res.headers["request-id"])
  end

  def test_ingestion_explicit_opt_in_mints
    hosts = [Algolia::Transport::StatefulHost.new("localhost", accept: READ | WRITE)]
    config = Algolia::Configuration.new(
      "test-app-id",
      "test-api-key",
      hosts,
      "Ingestion",
      requester: Algolia::Transport::EchoRequester.new
    )
    # The generated client only applies its per-client default (off for
    # ingestion) when the setting is nil: an explicit opt-in survives.
    config.request_id_enabled = true
    client = Algolia::IngestionClient.create_with_config(config)

    res = client.custom_get_with_http_info("1/test")

    assert_match(REQUEST_ID_FORMAT, res.headers["request-id"])
  end

  def test_ingestion_default_never_mints
    hosts = [Algolia::Transport::StatefulHost.new("localhost", accept: READ | WRITE)]
    config = Algolia::Configuration.new(
      "test-app-id",
      "test-api-key",
      hosts,
      "Ingestion",
      requester: Algolia::Transport::EchoRequester.new
    )
    client = Algolia::IngestionClient.create_with_config(config)

    res = client.custom_get_with_http_info("1/test")

    assert_false(res.headers.any? { |k, _| k.to_s.casecmp?("request-id") })
  end

  def test_search_explicit_opt_out_never_mints
    config = search_config
    # An explicit opt-out wins over the search client's on-by-default.
    config.request_id_enabled = false
    client = search_client(config)

    res = client.custom_get_with_http_info("1/test")

    assert_false(res.headers.any? { |k, _| k.to_s.casecmp?("request-id") })
  end

  def test_shared_config_keeps_each_clients_default
    hosts = [Algolia::Transport::StatefulHost.new("localhost", accept: READ | WRITE)]
    config = Algolia::Configuration.new(
      "test-app-id",
      "test-api-key",
      hosts,
      "Shared",
      requester: Algolia::Transport::EchoRequester.new
    )

    Algolia::IngestionClient.create_with_config(config)
    search = Algolia::SearchClient.create_with_config(config)

    # The first client's default must not pin into the shared config and disable the second's.
    assert_nil(config.request_id_enabled)
    assert_match(REQUEST_ID_FORMAT, search.custom_get_with_http_info("1/test").headers["request-id"])
  end

  def test_helper_options_share_one_request_id
    client = search_client

    options = client.send(:with_request_id, {})
    minted = options[:header_params]["Request-ID"]

    assert_match(REQUEST_ID_FORMAT, minted)

    # Idempotent on its own output, so nested helpers reuse the caller's ID.
    assert_equal(options, client.send(:with_request_id, options))

    # A fresh helper invocation mints a fresh ID.
    assert_not_equal(minted, client.send(:with_request_id, {})[:header_params]["Request-ID"])
  end

  def test_helper_options_keep_caller_request_id
    client = search_client

    options = {:header_params => {"request-ID" => "HelperCaller"}}

    assert_equal(options, client.send(:with_request_id, options))
  end

  def test_helper_options_respect_config_header_request_id
    config = search_config
    config.header_params["ReQuEsT-Id"] = "ConfigOwned"
    client = search_client(config)

    options = {}

    # A config-level Request-ID counts as caller-supplied for helpers too.
    assert_equal(options, client.send(:with_request_id, options))
  end

  def test_cleanup_delete_keeps_root_cause_and_drops_caller_timeouts
    requester = CleanupRecordingRequester.new
    client = search_client(search_config(requester: requester))

    error = assert_raise(Algolia::AlgoliaHttpError) do
      client.replace_all_objects(
        "cleanup-idx",
        [{:objectID => "1"}],
        1000,
        [Algolia::Search::ScopeType::SETTINGS],
        {:timeout => 1234, :connect_timeout => 56}
      )
    end

    # The failing cleanup DELETE (403) must not mask the root cause (400).
    assert_equal(400, error.code)
    assert_equal("root cause", error.http_message)

    deletes = requester.requests.select { |req| req.method == :delete }
    assert_equal(1, deletes.length)
    delete = deletes.first

    # The cleanup DELETE shares the Request-ID minted for the invocation...
    first = requester.requests.first
    assert_match(REQUEST_ID_FORMAT, first.headers["request-id"])
    assert_equal(first.headers["request-id"], delete.headers["request-id"])

    # ...but runs with the default timeouts, not the caller's.
    assert_equal(1234, first.timeout)
    assert_equal(56, first.connect_timeout)
    assert_not_equal(1234, delete.timeout)
    assert_not_equal(56, delete.connect_timeout)
  end

  def test_api_error_carries_correlation_id
    requester = ErrorRequester.new(
      400,
      JSON.generate({:message => "boom"}),
      {
        "cOrReLaTiOn-Id" => "CorrTest123",
        # The unrelated edge header must never be surfaced instead.
        "X-Algolia-RequestID" => "EdgePopValue"
      }
    )
    client = search_client(search_config(requester: requester))

    error = assert_raise(Algolia::AlgoliaHttpError) { client.custom_get("1/test") }

    assert_equal("CorrTest123", error.correlation_id)
    assert_equal(400, error.code)
    assert_equal("boom", error.http_message)
    assert_equal("400: boom (Correlation-ID: CorrTest123)", error.message)
  end

  def test_html_error_carries_correlation_id
    requester = ErrorRequester.new(
      400,
      "<html>Bad Request</html>",
      {"content-type" => "text/html; charset=utf-8", "cOrReLaTiOn-Id" => "CorrHtml456"},
      reason_phrase: "Bad Request"
    )
    client = search_client(search_config(requester: requester))

    error = assert_raise(Algolia::AlgoliaHttpError) { client.custom_get("1/test") }

    assert_equal("CorrHtml456", error.correlation_id)
    assert_equal(400, error.code)
    assert_equal("Bad Request", error.http_message)
    assert_equal("400: Bad Request (Correlation-ID: CorrHtml456)", error.message)
  end

  def test_api_error_with_empty_correlation_id_has_no_suffix
    requester = ErrorRequester.new(400, JSON.generate({:message => "boom"}), {"Correlation-ID" => ""})
    client = search_client(search_config(requester: requester))

    error = assert_raise(Algolia::AlgoliaHttpError) { client.custom_get("1/test") }

    # Kept verbatim on the error, but never rendered as a dangling suffix.
    assert_equal("", error.correlation_id)
    assert_equal("400: boom", error.message)
  end

  def test_api_error_without_correlation_id_is_unchanged
    requester = ErrorRequester.new(
      400,
      JSON.generate({:message => "boom"}),
      {"X-Algolia-RequestID" => "EdgePopValue"}
    )
    client = search_client(search_config(requester: requester))

    error = assert_raise(Algolia::AlgoliaHttpError) { client.custom_get("1/test") }

    assert_nil(error.correlation_id)
    assert_equal("400: boom", error.message)
  end
end

# Requester failing every request with a retryable error carrying headers.
class AlwaysFailingRequester
  def initialize(headers_for_attempt)
    @attempts = 0
    @headers_for_attempt = headers_for_attempt
  end

  def send_request(host, _method, _path, _body, _query_params, _headers, _timeout, _connect_timeout)
    @attempts += 1
    Algolia::Http::Response.new(
      host: host,
      status: 500,
      error: "unavailable",
      headers: @headers_for_attempt.call(@attempts)
    )
  end
end

class TestRequestIdExhaustion < Test::Unit::TestCase
  include CallType

  def exhausted_client(requester)
    hosts = Array.new(3) { Algolia::Transport::StatefulHost.new("localhost", accept: READ | WRITE) }
    config = Algolia::Configuration.new("test-app-id", "test-api-key", hosts, "Search", requester: requester)
    Algolia::SearchClient.create_with_config(config)
  end

  def test_exhaustion_carries_last_correlation_id
    requester = AlwaysFailingRequester.new(-> (attempt) { {"cOrReLaTiOn-Id" => "CorrAttempt#{attempt}"} })
    client = exhausted_client(requester)

    error = assert_raise(Algolia::AlgoliaUnreachableHostError) { client.custom_get("1/test") }

    assert_equal("CorrAttempt3", error.correlation_id)
    assert_true(error.message.end_with?("(Correlation-ID: CorrAttempt3)"))
  end

  def test_exhaustion_keeps_correlation_id_of_earlier_attempt
    # Later attempts with an absent or empty Correlation-ID must not erase the earlier one.
    headers = [{"cOrReLaTiOn-Id" => "CorrAttempt1"}, {"Correlation-ID" => ""}, {}]
    requester = AlwaysFailingRequester.new(-> (attempt) { headers[attempt - 1] })
    client = exhausted_client(requester)

    error = assert_raise(Algolia::AlgoliaUnreachableHostError) { client.custom_get("1/test") }

    assert_equal("CorrAttempt1", error.correlation_id)
    assert_true(error.message.end_with?("(Correlation-ID: CorrAttempt1)"))
  end

  def test_exhaustion_with_empty_correlation_id_has_no_suffix
    requester = AlwaysFailingRequester.new(-> (_) { {"Correlation-ID" => ""} })
    client = exhausted_client(requester)

    error = assert_raise(Algolia::AlgoliaUnreachableHostError) { client.custom_get("1/test") }

    # An empty Correlation-ID is worthless in a support ticket: never retained.
    assert_nil(error.correlation_id)
    assert_false(error.message.include?("Correlation-ID"))
  end

  def test_exhaustion_without_correlation_id_is_unchanged
    requester = AlwaysFailingRequester.new(-> (_) { {} })
    client = exhausted_client(requester)

    error = assert_raise(Algolia::AlgoliaUnreachableHostError) { client.custom_get("1/test") }

    assert_nil(error.correlation_id)
    assert_false(error.message.include?("Correlation-ID"))
  end
end
