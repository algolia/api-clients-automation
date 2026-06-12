using System;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using Algolia.Search.Clients;
using Xunit;

namespace Algolia.Search.Tests;

public class ForgeSecuredUserTokenTests
{
  [Fact]
  [Trait("Category", "unit")]
  public void ForgeSecuredUserToken_DefaultExpiry()
  {
    var client = new AgentStudioClient("appID", "apiKey");

    var token = client.ForgeSecuredUserToken("my-secret-key", "my-key-id", "user-123");

    var parts = token.Split('.');
    Assert.Equal(3, parts.Length);

    var headerJson = Encoding.UTF8.GetString(Base64UrlDecode(parts[0]));
    var header = JsonDocument.Parse(headerJson).RootElement;
    Assert.Equal("HS256", header.GetProperty("alg").GetString());
    Assert.Equal("JWT", header.GetProperty("typ").GetString());
    Assert.Equal("my-key-id", header.GetProperty("kid").GetString());

    var payloadJson = Encoding.UTF8.GetString(Base64UrlDecode(parts[1]));
    var payload = JsonDocument.Parse(payloadJson).RootElement;
    Assert.Equal("user-123", payload.GetProperty("sub").GetString());
    var exp = payload.GetProperty("exp").GetInt64();
    var expectedExp = DateTimeOffset.UtcNow.ToUnixTimeSeconds() + 24 * 3600;
    Assert.InRange(exp, expectedExp - 5, expectedExp + 5);

    using var hmac = new HMACSHA256(Encoding.UTF8.GetBytes("my-secret-key"));
    var expectedSig = Base64UrlEncode(hmac.ComputeHash(Encoding.UTF8.GetBytes($"{parts[0]}.{parts[1]}")));
    Assert.Equal(expectedSig, parts[2]);
  }

  [Fact]
  [Trait("Category", "unit")]
  public void ForgeSecuredUserToken_CustomExpiry()
  {
    var client = new AgentStudioClient("appID", "apiKey");

    var token = client.ForgeSecuredUserToken("my-secret-key", "my-key-id", "user-456", 3600);

    var parts = token.Split('.');
    var payloadJson = Encoding.UTF8.GetString(Base64UrlDecode(parts[1]));
    var payload = JsonDocument.Parse(payloadJson).RootElement;
    var exp = payload.GetProperty("exp").GetInt64();
    var expectedExp = DateTimeOffset.UtcNow.ToUnixTimeSeconds() + 3600;
    Assert.InRange(exp, expectedExp - 5, expectedExp + 5);
  }

  private static byte[] Base64UrlDecode(string input)
  {
    var padded = input.Replace('-', '+').Replace('_', '/');
    switch (padded.Length % 4)
    {
      case 2: padded += "=="; break;
      case 3: padded += "="; break;
    }
    return Convert.FromBase64String(padded);
  }

  private static string Base64UrlEncode(byte[] data) =>
    Convert.ToBase64String(data).TrimEnd('=').Replace('+', '-').Replace('/', '_');
}
