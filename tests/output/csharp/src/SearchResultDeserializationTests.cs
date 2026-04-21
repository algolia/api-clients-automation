using System.Text.Json;
using Algolia.Search.Models.Search;
using Algolia.Search.Serializer;
using Xunit;

namespace Algolia.Search.Tests;

public class SearchResultDeserializationTests
{
  private record Hit(string ObjectID, string Name);

  [Fact]
  public void SearchResult_WithHits_DeserializesAsSearchResponse()
  {
    var json =
      """{"page":0,"nbHits":1,"nbPages":1,"hitsPerPage":10,"processingTimeMS":1,"hits":[{"objectID":"1","name":"test"}]}""";

    var result = JsonSerializer.Deserialize<SearchResult<Hit>>(json, JsonConfig.Options);

    Assert.NotNull(result);
    Assert.True(result.IsSearchResponse());
    Assert.Single(result.AsSearchResponse().Hits);
  }

  [Fact]
  public void SearchResult_WithoutHits_DeserializesAsSearchResponse()
  {
    // Regression test for https://github.com/algolia/api-clients-automation/issues/XXXX
    // ResponseFields can exclude 'hits' from the response; the discriminator must not
    // require it to be present for SearchResponse<T> deserialization to succeed.
    var json = """{"page":0,"nbHits":100,"nbPages":2}""";

    var result = JsonSerializer.Deserialize<SearchResult<Hit>>(json, JsonConfig.Options);

    Assert.NotNull(result);
    Assert.True(result.IsSearchResponse());
  }

  [Fact]
  public void SearchResult_WithFacetHits_DeserializesAsSearchForFacetValuesResponse()
  {
    var json =
      """{"facetHits":[{"value":"red","highlighted":"red","count":10}],"exhaustiveFacetsCount":true,"processingTimeMS":1}""";

    var result = JsonSerializer.Deserialize<SearchResult<Hit>>(json, JsonConfig.Options);

    Assert.NotNull(result);
    Assert.True(result.IsSearchForFacetValuesResponse());
    Assert.Single(result.AsSearchForFacetValuesResponse().FacetHits);
  }
}
