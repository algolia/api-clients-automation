using System.Text.RegularExpressions;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Personalization;
using Xunit;

public class PersonalizationClientTests
{
  private readonly EchoHttpRequester _echo;
  private Exception _ex;

  public PersonalizationClientTests()
  {
    _echo = new EchoHttpRequester();
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "calls api with correct user agent")]
  public async Task CommonApiTest0()
  {
    var client = new PersonalizationClient(
      new PersonalizationConfig("appId", "apiKey", "us"),
      _echo
    );
    await client.CustomPostAsync("/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex(
        "^Algolia for Csharp \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Personalization (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
      );
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "calls api with default read timeouts")]
  public async Task CommonApiTest1()
  {
    var client = new PersonalizationClient(
      new PersonalizationConfig("appId", "apiKey", "us"),
      _echo
    );
    await client.CustomGetAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(5000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "calls api with default write timeouts")]
  public async Task CommonApiTest2()
  {
    var client = new PersonalizationClient(
      new PersonalizationConfig("appId", "apiKey", "us"),
      _echo
    );
    await client.CustomPostAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(30000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "throws when region is not given")]
  public async Task ParametersTest0()
  {
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new PersonalizationClient(
        new PersonalizationConfig("my-app-id", "my-api-key", ""),
        _echo
      );
    });
    Assert.Equal(
      "`region` is required and must be one of the following: eu, us".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }

  [Fact(DisplayName = "throws when incorrect region is given")]
  public async Task ParametersTest1()
  {
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new PersonalizationClient(
        new PersonalizationConfig("my-app-id", "my-api-key", "not_a_region"),
        _echo
      );
    });
    Assert.Equal(
      "`region` is required and must be one of the following: eu, us".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }

  [Fact(DisplayName = "does not throw when region is given")]
  public async Task ParametersTest2()
  {
    var client = new PersonalizationClient(
      new PersonalizationConfig("my-app-id", "my-api-key", "us"),
      _echo
    );
  }
}
