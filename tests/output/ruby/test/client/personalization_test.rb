# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
require "algolia"
require "test/unit"

class TestClientPersonalizationClient < Test::Unit::TestCase
  include Algolia::Personalization
  # calls api with correct user agent
  def test_common_api0
    client = Algolia::PersonalizationClient.create(
      "APP_ID",
      "API_KEY",
      "us",
      {requester: Algolia::Transport::EchoRequester.new}
    )
    req = client.custom_post_with_http_info("1/test")
    assert(
      req.headers["user-agent"].match(
        /^Algolia for Ruby \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Personalization (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/
      )
    )
  end

  # the user agent contains the latest version
  def test_common_api1
    client = Algolia::PersonalizationClient.create(
      "APP_ID",
      "API_KEY",
      "us",
      {requester: Algolia::Transport::EchoRequester.new}
    )
    req = client.custom_post_with_http_info("1/test")
    assert(req.headers["user-agent"].match(/^Algolia for Ruby \(3.2.3\).*/))
  end

  # calls api with default read timeouts
  def test_common_api2
    client = Algolia::PersonalizationClient.create(
      "APP_ID",
      "API_KEY",
      "us",
      {requester: Algolia::Transport::EchoRequester.new}
    )
    req = client.custom_get_with_http_info("1/test")
    assert_equal(2000, req.connect_timeout)
    assert_equal(5000, req.timeout)
  end

  # calls api with default write timeouts
  def test_common_api3
    client = Algolia::PersonalizationClient.create(
      "APP_ID",
      "API_KEY",
      "us",
      {requester: Algolia::Transport::EchoRequester.new}
    )
    req = client.custom_post_with_http_info("1/test")
    assert_equal(2000, req.connect_timeout)
    assert_equal(30000, req.timeout)
  end

  # throws when region is not given
  def test_parameters0
    begin

      Algolia::PersonalizationClient.create(
        "my-app-id",
        "my-api-key",
        "",
        {requester: Algolia::Transport::EchoRequester.new}
      )
      assert(false, "An error should have been raised")
    rescue => e
      assert_equal("`region` is required and must be one of the following: eu, us", e.message)
    end
  end

  # throws when incorrect region is given
  def test_parameters1
    begin

      Algolia::PersonalizationClient.create(
        "my-app-id",
        "my-api-key",
        "not_a_region",
        {requester: Algolia::Transport::EchoRequester.new}
      )
      assert(false, "An error should have been raised")
    rescue => e
      assert_equal("`region` is required and must be one of the following: eu, us", e.message)
    end
  end

  # does not throw when region is given
  def test_parameters2

    client = Algolia::PersonalizationClient.create(
      "my-app-id",
      "my-api-key",
      "us",
      {requester: Algolia::Transport::EchoRequester.new}
    )
  end

end
