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
  public void ShouldGenerateSecuredApiKey()
  {
    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"));
    var securedApiKey = client.GenerateSecuredApiKeys("parent-api-key", new SecuredApiKeyRestriction
    {
      Query = new IndexSettingsAsSearchParams
      {
        Mode = Mode.NeuralSearch,
        HitsPerPage = 10,
        OptionalWords = ["one", "two"],
        QueryType = QueryType.PrefixNone,
        EnableRules = true,
        AlternativesAsExact = [AlternativesAsExact.IgnorePlurals, AlternativesAsExact.SingleWordSynonym],
        AttributeCriteriaComputedByMinProximity = false
      },
      RestrictIndices = ["index1", "index2"],
      RestrictSources = ["source1", "source2"],
      UserToken = "my-user-token",
      ValidUntil = 1
    });

    const string expectedQueryParams =
      "optionalWords=one%2Ctwo&alternativesAsExact=ignorePlurals%2CsingleWordSynonym&queryType=prefixNone&mode=neuralSearch&hitsPerPage=10&enableRules=true&attributeCriteriaComputedByMinProximity=false&restrictIndices=index1%2Cindex2&restrictSources=source1%2Csource2&validUntil=1&userToken=my-user-token";
    var hash = HmacShaHelper.GetHash("parent-api-key", expectedQueryParams);
    var expectedKey = HmacShaHelper.Base64Encode($"{hash}{expectedQueryParams}");

    Assert.Equal(expectedKey, securedApiKey);
  }

  [Fact]
  public void ShouldDetectExpiredKey()
  {
    // Test an expired key
    var restriction = new SecuredApiKeyRestriction
    {
      ValidUntil = new DateTimeOffset(DateTime.UtcNow.AddMinutes(-10)).ToUnixTimeSeconds(),
      RestrictIndices = ["indexName"]
    };

    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), Mock.Of<IHttpRequester>());

    var expiredKey = client.GenerateSecuredApiKeys("key", restriction);
    var remainingValidity = client.GetSecuredApiKeyRemainingValidity(expiredKey);

    Assert.True(remainingValidity.TotalSeconds < 0);
  }

  [Fact]
  public void ShouldDetectValidKey()
  {
    // Test a valid key
    var restriction = new SecuredApiKeyRestriction
    {
      ValidUntil = new DateTimeOffset(DateTime.UtcNow.AddMinutes(10)).ToUnixTimeSeconds(),
      RestrictIndices = ["indexName"]
    };

    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), Mock.Of<IHttpRequester>());

    var expiredKey = client.GenerateSecuredApiKeys("key", restriction);
    var remainingValidity = client.GetSecuredApiKeyRemainingValidity(expiredKey);

    Assert.True(remainingValidity.TotalSeconds > 0);
  }

  [Fact]
  public void TestRemainingValidityParameters()
  {
    // Test a valid key, but with no validUntil
    var restriction = new SecuredApiKeyRestriction
    {
      RestrictIndices = ["indexName"]
    };

    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), Mock.Of<IHttpRequester>());

    var key = client.GenerateSecuredApiKeys("key", restriction);

    Assert.Throws<AlgoliaException>(() => client.GetSecuredApiKeyRemainingValidity(key));
  }
}
