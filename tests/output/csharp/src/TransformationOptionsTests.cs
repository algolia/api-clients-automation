using System;
using Algolia.Search.Clients;
using Algolia.Search.Exceptions;
using Xunit;

namespace Algolia.Search.Tests;

public class TransformationOptionsTests
{
  [Fact]
  [Trait("Category", "unit")]
  public void RegionRequired_NullThrows()
  {
    Assert.Throws<ArgumentException>(() => new TransformationOptions(null));
  }

  [Fact]
  [Trait("Category", "unit")]
  public void RegionRequired_EmptyThrows()
  {
    Assert.Throws<ArgumentException>(() => new TransformationOptions(""));
    Assert.Throws<ArgumentException>(() => new TransformationOptions("   "));
  }

  [Fact]
  [Trait("Category", "unit")]
  public void RegionOnly_StoresRegion()
  {
    var opts = new TransformationOptions("us");
    Assert.Equal("us", opts.Region);
    Assert.Null(opts.ClientOptions);
  }

  [Fact]
  [Trait("Category", "unit")]
  public void WithClientOptions_StoresComposition()
  {
    var ingestionConfig = new IngestionConfig("app-id", "api-key", "eu") { ReadTimeout = TimeSpan.FromSeconds(10) };
    var opts = new TransformationOptions("eu", ingestionConfig);
    Assert.Equal("eu", opts.Region);
    Assert.Same(ingestionConfig, opts.ClientOptions);
    Assert.Equal(TimeSpan.FromSeconds(10), opts.ClientOptions.ReadTimeout);
  }

  [Fact]
  [Trait("Category", "unit")]
  public void WithTransformationThrowsWhenNotConfigured()
  {
    var client = new SearchClient("app-id", "api-key");
    var ex = Assert.Throws<AlgoliaException>(() =>
      client.SaveObjectsWithTransformation("index", new[] { new { objectID = "1" } })
    );
    Assert.Contains("TransformationOptions", ex.Message);
  }

  [Fact]
  [Trait("Category", "unit")]
  public void SetTransformationOptionsEnablesMethods()
  {
    var client = new SearchClient("app-id", "api-key");

    var notConfiguredEx = Assert.Throws<AlgoliaException>(() =>
      client.SaveObjectsWithTransformation("index", new[] { new { objectID = "1" } })
    );
    Assert.Contains("TransformationOptions", notConfiguredEx.Message);

    client.SetTransformationOptions(new TransformationOptions("us"));

    var ex = Record.Exception(() =>
      client.SaveObjectsWithTransformation("index", new[] { new { objectID = "1" } })
    );
    if (ex is AlgoliaException algoliaEx)
    {
      Assert.DoesNotContain("TransformationOptions must be set", algoliaEx.Message);
    }
  }

  [Fact]
  [Trait("Category", "unit")]
  public void SetTransformationOptionsReplacesTransporter()
  {
    var client = new SearchClient("app-id", "api-key");
    client.SetTransformationOptions(new TransformationOptions("us"));
    client.SetTransformationOptions(new TransformationOptions("eu"));
  }

  [Fact]
  [Trait("Category", "unit")]
  public void DeprecatedSetTransformationRegion_StillWorks()
  {
    var client = new SearchClient("app-id", "api-key");
#pragma warning disable CS0618
    client.SetTransformationRegion("us");
#pragma warning restore CS0618

    var ex = Record.Exception(() =>
      client.SaveObjectsWithTransformation("index", new[] { new { objectID = "1" } })
    );
    if (ex is AlgoliaException algoliaEx)
    {
      Assert.DoesNotContain("TransformationOptions must be set", algoliaEx.Message);
    }
  }

  [Fact]
  [Trait("Category", "unit")]
  public void WithTransformation_DoesNotThrowConfigErrorWhenConfigured()
  {
    var client = SearchClient.WithTransformation("app-id", "api-key", new TransformationOptions("us"));

    var ex = Record.Exception(() =>
      client.SaveObjectsWithTransformation("index", new[] { new { objectID = "1" } })
    );
    if (ex is AlgoliaException algoliaEx)
    {
      Assert.DoesNotContain("TransformationOptions must be set", algoliaEx.Message);
    }
  }

  [Fact]
  [Trait("Category", "unit")]
  public void WithTransformation_NullTransformationOptions_Throws()
  {
    Assert.Throws<ArgumentNullException>(() =>
      SearchClient.WithTransformation("app-id", "api-key", null)
    );
  }

  [Fact]
  [Trait("Category", "unit")]
  public void WithTransformation_SearchConfigOverload_DoesNotThrowConfigError()
  {
    var client = SearchClient.WithTransformation(
      new SearchConfig("app-id", "api-key"),
      new TransformationOptions("us")
    );

    var ex = Record.Exception(() =>
      client.SaveObjectsWithTransformation("index", new[] { new { objectID = "1" } })
    );
    if (ex is AlgoliaException algoliaEx)
    {
      Assert.DoesNotContain("TransformationOptions must be set", algoliaEx.Message);
    }
  }

  [Fact]
  [Trait("Category", "unit")]
  public void WithTransformation_SearchConfigOverload_NullTransformationOptions_Throws()
  {
    Assert.Throws<ArgumentNullException>(() =>
      SearchClient.WithTransformation(new SearchConfig("app-id", "api-key"), null)
    );
  }
}
