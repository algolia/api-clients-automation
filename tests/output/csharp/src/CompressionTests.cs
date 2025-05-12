using System.IO.Compression;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Common;
using Algolia.Search.Tests.Utils;
using Xunit;

namespace Algolia.Search.Tests;

public class CompressionTests
{
  private readonly EchoHttpRequester _echo = new(bodyAsStream: true);

  [Fact]
  public async Task DoNotCompressRequestByDefault()
  {
    var searchConfig = new SearchConfig("test-app-id", "test-api-key"); // No compression type set, so default is NONE

    var client = new SearchClient(searchConfig, _echo);

    await client.CustomPostAsync(
      "/1/mock",
      new Dictionary<string, object>(),
      new { test = "test" }
    );

    var lastResponseBodyStream = _echo.LastResponse.BodyStream;

    Assert.IsType<MemoryStream>(lastResponseBodyStream);

    var cp = new MemoryStream();
    await lastResponseBodyStream.CopyToAsync(cp);

    lastResponseBodyStream.Position = 0;
    cp.Position = 0;

    GZipStream gZipStream = new(lastResponseBodyStream, CompressionMode.Decompress);
    var reader = new StreamReader(gZipStream);

    var exception = await Assert.ThrowsAsync<InvalidDataException>(async () =>
      await reader.ReadToEndAsync()
    );

    Assert.Equal(
      "The archive entry was compressed using an unsupported compression method.",
      exception.Message
    );

    var stdReader = new StreamReader(cp);

    Assert.Equal("{\"test\":\"test\"}", await stdReader.ReadToEndAsync());
  }

  [Fact]
  public async Task CanCompressRequestInGZip()
  {
    var searchConfig = new SearchConfig("test-app-id", "test-api-key")
    {
      Compression = CompressionType.Gzip,
    };

    var client = new SearchClient(searchConfig, _echo);

    await client.CustomPostAsync(
      "/1/mock",
      new Dictionary<string, object>(),
      new { test = "test" }
    );

    var lastResponseBodyStream = _echo.LastResponse.BodyStream;

    Assert.IsType<MemoryStream>(lastResponseBodyStream);

    GZipStream v = new(lastResponseBodyStream, CompressionMode.Decompress);
    var reader = new StreamReader(v);
    var body = await reader.ReadToEndAsync();
    Assert.Equal("{\"test\":\"test\"}", body);
  }
}
