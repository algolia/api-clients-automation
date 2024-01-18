using System.Text.RegularExpressions;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Insights;
using Xunit;

public class InsightsClientTests
{
  private readonly EchoHttpRequester _echo;
  private Exception _ex;

  public InsightsClientTests()
  {
    _echo = new EchoHttpRequester();
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "calls api with correct user agent")]
  public async Task CommonApiTest0()
  {
    var client = new InsightsClient(new InsightsConfig("appId", "apiKey", "us"), _echo);
    await client.CustomPostAsync("/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex(
        "^Algolia for Csharp \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Insights (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
      );
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "calls api with default read timeouts")]
  public async Task CommonApiTest1()
  {
    var client = new InsightsClient(new InsightsConfig("appId", "apiKey", "us"), _echo);
    await client.CustomGetAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(5000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "calls api with default write timeouts")]
  public async Task CommonApiTest2()
  {
    var client = new InsightsClient(new InsightsConfig("appId", "apiKey", "us"), _echo);
    await client.CustomPostAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(30000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "fallbacks to the alias when region is not given")]
  public async Task ParametersTest0()
  {
    var client = new InsightsClient(new InsightsConfig("my-app-id", "my-api-key"), _echo);
    await client.PushEventsAsync(
      new InsightsEvents
      {
        Events = new List<EventsItems>
        {
          new EventsItems(
            new ClickedObjectIDsAfterSearch
            {
              EventType = Enum.Parse<ClickEvent>("Click"),
              EventName = "Product Clicked",
              Index = "products",
              UserToken = "user-123456",
              AuthenticatedUserToken = "user-123456",
              Timestamp = 1641290601962L,
              ObjectIDs = new List<string> { "9780545139700", "9780439784542" },
              QueryID = "43b15df305339e827f0ac0bdc5ebcaa7",
              Positions = new List<int> { 7, 6 },
            }
          )
        },
      }
    );
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("insights.algolia.io", result.Host);
  }

  [Fact(DisplayName = "uses the correct region")]
  public async Task ParametersTest1()
  {
    var client = new InsightsClient(new InsightsConfig("my-app-id", "my-api-key", "us"), _echo);
    await client.CustomDeleteAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("insights.us.algolia.io", result.Host);
  }

  [Fact(DisplayName = "throws when incorrect region is given")]
  public async Task ParametersTest2()
  {
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new InsightsClient(
        new InsightsConfig("my-app-id", "my-api-key", "not_a_region"),
        _echo
      );
    });
    Assert.Equal(
      "`region` must be one of the following: de, us".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }
}
