using Algolia.Search.Clients;
using Algolia.Search.Http;
using Xunit;

namespace Algolia.Search.Tests;

public class AddSegmentToUserAgentTests
{
  private readonly EchoHttpRequester _echo = new();

  [Fact]
  public async Task CanAddSegmentToUserAgent()
  {
    var searchConfig = new SearchConfig("appid", "apikey");
    searchConfig.UserAgent.AddSegment("My custom segment", "app-12233");
    var client = new SearchClient(searchConfig, _echo);
    
    await client.CustomPostAsync("/test");
    var result = _echo.LastResponse;
    
    Assert.Contains("; My custom segment app-12233", result.Headers["user-agent"]);
  }
}
