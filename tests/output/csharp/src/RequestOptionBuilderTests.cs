using Algolia.Search.Http;
using Xunit;

namespace Algolia.Search.Tests;

public class RequestOptionBuilderTests
{
  [Fact]
  public void TestRequestOptionBuilder()
  {
    var builder = new RequestOptionBuilder();
    builder.AddExtraHeader("key", "value");
    builder.AddExtraQueryParameters("key", "value 2");
    builder.SetTimeout(TimeSpan.FromSeconds(10));

    var requestOptions = builder.Build();
    Assert.Equal("value", requestOptions.Headers["key"]);
    Assert.Equal("value 2", requestOptions.QueryParameters["key"]);
    Assert.Equal(TimeSpan.FromSeconds(10), requestOptions.Timeout);
  }
}
