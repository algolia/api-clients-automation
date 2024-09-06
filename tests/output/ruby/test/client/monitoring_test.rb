# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
require "algolia"
require "test/unit"

class TestClientMonitoringClient < Test::Unit::TestCase
  include Algolia::Monitoring
  # calls api with correct user agent
  def test_common_api0
    client = Algolia::MonitoringClient.create(
      "APP_ID",
      "API_KEY",

      {requester: Algolia::Transport::EchoRequester.new}
    )
    req = client.custom_post_with_http_info("1/test")
    assert(
      req.headers["user-agent"].match(
        /^Algolia for Ruby \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Monitoring (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/
      )
    )
  end

  # the user agent contains the latest version
  def test_common_api1
    client = Algolia::MonitoringClient.create(
      "APP_ID",
      "API_KEY",

      {requester: Algolia::Transport::EchoRequester.new}
    )
    req = client.custom_post_with_http_info("1/test")
    assert(req.headers["user-agent"].match(/^Algolia for Ruby \(3.3.0\).*/))
  end

  # calls api with default read timeouts
  def test_common_api2
    client = Algolia::MonitoringClient.create(
      "APP_ID",
      "API_KEY",

      {requester: Algolia::Transport::EchoRequester.new}
    )
    req = client.custom_get_with_http_info("1/test")
    assert_equal(2000, req.connect_timeout)
    assert_equal(5000, req.timeout)
  end

  # calls api with default write timeouts
  def test_common_api3
    client = Algolia::MonitoringClient.create(
      "APP_ID",
      "API_KEY",

      {requester: Algolia::Transport::EchoRequester.new}
    )
    req = client.custom_post_with_http_info("1/test")
    assert_equal(2000, req.connect_timeout)
    assert_equal(30000, req.timeout)
  end

  # use the correct host
  def test_parameters0

    client = Algolia::MonitoringClient.create(
      "my-app-id",
      "my-api-key",

      {requester: Algolia::Transport::EchoRequester.new}
    )
    req = client.custom_delete_with_http_info("test")
    assert_equal("status.algolia.com", req.host.url)
  end

  # switch API key
  def test_set_client_api_key0
    client = Algolia::MonitoringClient.create_with_config(
      Algolia::Configuration.new(
        "test-app-id",
        "test-api-key",
        [
          Algolia::Transport::StatefulHost.new(
            "localhost",
            protocol: "http://",
            port: 6683,
            accept: CallType::READ | CallType::WRITE
          )
        ],
        "monitoringClient"
      )
    )
    req = client.custom_get("check-api-key/1")
    assert_equal({:"headerAPIKeyValue" => "test-api-key"}, req.is_a?(Array) ? req.map(&:to_hash) : req.to_hash)
    client.set_client_api_key("updated-api-key")
    req = client.custom_get("check-api-key/2")
    assert_equal({:"headerAPIKeyValue" => "updated-api-key"}, req.is_a?(Array) ? req.map(&:to_hash) : req.to_hash)
  end

end
