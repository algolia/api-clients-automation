using Algolia.Search.Clients;
using Algolia.Search.Exceptions;
using Algolia.Search.Http;
using Algolia.Search.Models.Common;
using Algolia.Search.Models.Search;
using Algolia.Search.Utils;
using Moq;
using Xunit;

namespace Algolia.Search.Tests;

public class SecuredApiKeysTests
{
  [Fact]
  public void ShouldDetectExpiredKey()
  {
    // Test an expired key
    var restriction = new SecuredApiKeyRestrictions
    {
      ValidUntil = new DateTimeOffset(DateTime.UtcNow.AddMinutes(-10)).ToUnixTimeSeconds(),
      RestrictIndices = ["indexName"],
    };

    var client = new SearchClient(
      new SearchConfig("test-app-id", "test-api-key"),
      Mock.Of<IHttpRequester>()
    );

    var expiredKey = client.GenerateSecuredApiKey("key", restriction);
    var remainingValidity = client.GetSecuredApiKeyRemainingValidity(expiredKey);

    Assert.True(remainingValidity.TotalSeconds < 0);
  }

  [Fact]
  public void ShouldDetectValidKey()
  {
    // Test a valid key
    var restriction = new SecuredApiKeyRestrictions
    {
      ValidUntil = new DateTimeOffset(DateTime.UtcNow.AddMinutes(10)).ToUnixTimeSeconds(),
      RestrictIndices = ["indexName"],
    };

    var client = new SearchClient(
      new SearchConfig("test-app-id", "test-api-key"),
      Mock.Of<IHttpRequester>()
    );

    var expiredKey = client.GenerateSecuredApiKey("key", restriction);
    var remainingValidity = client.GetSecuredApiKeyRemainingValidity(expiredKey);

    Assert.True(remainingValidity.TotalSeconds > 0);
  }

  [Fact]
  public void TestRemainingValidityParameters()
  {
    // Test a valid key, but with no validUntil
    var restriction = new SecuredApiKeyRestrictions { RestrictIndices = ["indexName"] };

    var client = new SearchClient(
      new SearchConfig("test-app-id", "test-api-key"),
      Mock.Of<IHttpRequester>()
    );

    var key = client.GenerateSecuredApiKey("key", restriction);

    Assert.Throws<AlgoliaException>(() => client.GetSecuredApiKeyRemainingValidity(key));
  }
}
