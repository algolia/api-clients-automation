# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
require "algolia"
require "test/unit"

class TestClientQuerySuggestionsClient < Test::Unit::TestCase
  # calls api with correct user agent
  def test_common_api0
    client = Algolia::QuerySuggestionsClient.create(
      "APP_ID",
      "API_KEY",
      "us",
      {requester: Algolia::Transport::EchoRequester.new}
    )
    req = client.custom_post_with_http_info("1/test")
    assert(
      req.headers["user-agent"].match(
        /^Algolia for Ruby \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; QuerySuggestions (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/
      )
    )
  end

  # the user agent contains the latest version
  def test_common_api1
    client = Algolia::QuerySuggestionsClient.create(
      "APP_ID",
      "API_KEY",
      "us",
      {requester: Algolia::Transport::EchoRequester.new}
    )
    req = client.custom_post_with_http_info("1/test")
    assert(req.headers["user-agent"].match(/^Algolia for Ruby \(3.10.2\).*/))
  end

  # throws when region is not given
  def test_parameters0
    begin

      Algolia::QuerySuggestionsClient.create(
        "my-app-id",
        "my-api-key",
        "",
        {requester: Algolia::Transport::EchoRequester.new}
      )
      assert(false, "An error should have been raised")
    rescue => e
      assert_equal(
        "`region` is required and must be one of the following: eu, us".sub(
          "%localhost%",
          ENV.fetch("CI", nil) == "true" ? "localhost" : "host.docker.internal"
        ),
        e.message
      )
    end
  end

  # throws when incorrect region is given
  def test_parameters1
    begin

      Algolia::QuerySuggestionsClient.create(
        "my-app-id",
        "my-api-key",
        "not_a_region",
        {requester: Algolia::Transport::EchoRequester.new}
      )
      assert(false, "An error should have been raised")
    rescue => e
      assert_equal(
        "`region` is required and must be one of the following: eu, us".sub(
          "%localhost%",
          ENV.fetch("CI", nil) == "true" ? "localhost" : "host.docker.internal"
        ),
        e.message
      )
    end
  end

  # does not throw when region is given
  def test_parameters2

    client = Algolia::QuerySuggestionsClient.create(
      "my-app-id",
      "my-api-key",
      "us",
      {requester: Algolia::Transport::EchoRequester.new}
    )
  end

  # switch API key
  def test_set_client_api_key0
    client = Algolia::QuerySuggestionsClient.create_with_config(
      Algolia::Configuration.new(
        "test-app-id",
        "test-api-key",
        [
          Algolia::Transport::StatefulHost.new(
            ENV.fetch("CI", nil) == "true" ? "localhost" : "host.docker.internal",
            protocol: "http://",
            port: 6683,
            accept: CallType::READ | CallType::WRITE
          )
        ],
        "query_suggestionsClient"
      )
    )
    req = client.custom_get("check-api-key/1")
    assert_equal({:"headerAPIKeyValue" => "test-api-key"}, req.is_a?(Array) ? req.map(&:to_hash) : req.to_hash)
    client.set_client_api_key("updated-api-key")
    req = client.custom_get("check-api-key/2")
    assert_equal({:"headerAPIKeyValue" => "updated-api-key"}, req.is_a?(Array) ? req.map(&:to_hash) : req.to_hash)
  end

end
