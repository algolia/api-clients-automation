# frozen_string_literal: true

require "algolia"
require "base64"
require "json"
require "openssl"
require "test/unit"

class TestForgeSecuredUserToken < Test::Unit::TestCase
  def test_forge_secured_user_token
    client = Algolia::AgentStudioClient.create("appID", "apiKey")

    token = client.forge_secured_user_token("my-secret-key", "my-key-id", "user-123")

    parts = token.split(".")
    assert_equal(3, parts.length)

    header = JSON.parse(Base64.urlsafe_decode64(parts[0]))
    assert_equal("HS256", header["alg"])
    assert_equal("JWT", header["typ"])
    assert_equal("my-key-id", header["kid"])

    payload = JSON.parse(Base64.urlsafe_decode64(parts[1]))
    assert_equal("user-123", payload["sub"])
    expected_exp = Time.now.to_i + 24 * 3600
    assert_in_delta(expected_exp, payload["exp"], 5)

    expected_sig = Base64.urlsafe_encode64(
      OpenSSL::HMAC.digest("SHA256", "my-secret-key", "#{parts[0]}.#{parts[1]}"),
      padding: false
    )
    assert_equal(expected_sig, parts[2])
  end

  def test_forge_secured_user_token_custom_expiry
    client = Algolia::AgentStudioClient.create("appID", "apiKey")

    token = client.forge_secured_user_token("my-secret-key", "my-key-id", "user-456", 3600)

    parts = token.split(".")
    payload = JSON.parse(Base64.urlsafe_decode64(parts[1]))
    expected_exp = Time.now.to_i + 3600
    assert_in_delta(expected_exp, payload["exp"], 5)
  end
end
