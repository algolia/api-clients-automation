// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;
using Algolia.Search.Serializer;
using Algolia.Search.Tests.Utils;
using dotenv.net;
using Quibble.Xunit;
using Xunit;
using Action = Algolia.Search.Models.Search.Action;

namespace Algolia.Search.e2e;

public class SearchClientRequestTestsE2E
{
  private readonly SearchClient client;

  public SearchClientRequestTestsE2E()
  {
    DotEnv.Load(
      options: new DotEnvOptions(
        ignoreExceptions: true,
        probeForEnv: true,
        probeLevelsToSearch: 8,
        envFilePaths: new[] { ".env" }
      )
    );

    var appId = Environment.GetEnvironmentVariable("ALGOLIA_APPLICATION_ID");
    if (appId == null)
    {
      throw new Exception("please provide an `ALGOLIA_APPLICATION_ID` env var for e2e tests");
    }

    var apiKey = Environment.GetEnvironmentVariable("ALGOLIA_ADMIN_KEY");
    if (apiKey == null)
    {
      throw new Exception("please provide an `ALGOLIA_ADMIN_KEY` env var for e2e tests");
    }

    client = new SearchClient(new SearchConfig(appId, apiKey));
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "browse with minimal parameters")]
  public async Task BrowseTest()
  {
    try
    {
      var resp = await client.BrowseAsync<Hit>("cts_e2e_browse");
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"page\":0,\"nbHits\":33191,\"nbPages\":34,\"hitsPerPage\":1000,\"query\":\"\",\"params\":\"\"}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "getRule")]
  public async Task GetRuleTest()
  {
    try
    {
      var resp = await client.GetRuleAsync("cts_e2e_browse", "qr-1725004648916");
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"description\":\"test_rule\",\"enabled\":true,\"objectID\":\"qr-1725004648916\",\"conditions\":[{\"alternatives\":true,\"anchoring\":\"contains\",\"pattern\":\"zorro\"}],\"consequence\":{\"params\":{\"ignorePlurals\":\"true\"},\"filterPromotes\":true,\"promote\":[{\"objectIDs\":[\"Æon Flux\"],\"position\":0}]}}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "getSettings")]
  public async Task GetSettingsTest()
  {
    try
    {
      var resp = await client.GetSettingsAsync("cts_e2e_settings");
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"minWordSizefor1Typo\":4,\"minWordSizefor2Typos\":8,\"hitsPerPage\":100,\"maxValuesPerFacet\":100,\"paginationLimitedTo\":10,\"exactOnSingleWordQuery\":\"attribute\",\"ranking\":[\"typo\",\"geo\",\"words\",\"filters\",\"proximity\",\"attribute\",\"exact\",\"custom\"],\"separatorsToIndex\":\"\",\"removeWordsIfNoResults\":\"none\",\"queryType\":\"prefixLast\",\"highlightPreTag\":\"<em>\",\"highlightPostTag\":\"</em>\",\"alternativesAsExact\":[\"ignorePlurals\",\"singleWordSynonym\"]}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "search for a single hits request with minimal parameters")]
  public async Task SearchTest4()
  {
    try
    {
      var resp = await client.SearchAsync<Hit>(
        new SearchMethodParams
        {
          Requests = new List<SearchQuery>
          {
            new SearchQuery(new SearchForHits { IndexName = "cts_e2e_search_empty_index", })
          },
        }
      );
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"results\":[{\"hits\":[],\"page\":0,\"nbHits\":0,\"nbPages\":0,\"hitsPerPage\":20,\"exhaustiveNbHits\":true,\"exhaustiveTypo\":true,\"exhaustive\":{\"nbHits\":true,\"typo\":true},\"query\":\"\",\"params\":\"\",\"index\":\"cts_e2e_search_empty_index\",\"renderingContent\":{}}]}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "search with highlight and snippet results")]
  public async Task SearchTest5()
  {
    try
    {
      var resp = await client.SearchAsync<Hit>(
        new SearchMethodParams
        {
          Requests = new List<SearchQuery>
          {
            new SearchQuery(
              new SearchForHits
              {
                IndexName = "cts_e2e_highlight_snippet_results",
                Query = "vim",
                AttributesToSnippet = new List<string> { "*:20" },
                AttributesToHighlight = new List<string> { "*" },
                AttributesToRetrieve = new List<string> { "*" },
              }
            )
          },
        }
      );
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"results\":[{\"hits\":[{\"editor\":{\"name\":\"vim\",\"type\":\"beforeneovim\"},\"names\":[\"vim\",\":q\"],\"_snippetResult\":{\"editor\":{\"name\":{\"value\":\"<em>vim</em>\",\"matchLevel\":\"full\"},\"type\":{\"value\":\"beforeneovim\",\"matchLevel\":\"none\"}},\"names\":[{\"value\":\"<em>vim</em>\",\"matchLevel\":\"full\"},{\"value\":\":q\",\"matchLevel\":\"none\"}]},\"_highlightResult\":{\"editor\":{\"name\":{\"value\":\"<em>vim</em>\",\"matchLevel\":\"full\",\"fullyHighlighted\":true,\"matchedWords\":[\"vim\"]},\"type\":{\"value\":\"beforeneovim\",\"matchLevel\":\"none\",\"matchedWords\":[]}},\"names\":[{\"value\":\"<em>vim</em>\",\"matchLevel\":\"full\",\"fullyHighlighted\":true,\"matchedWords\":[\"vim\"]},{\"value\":\":q\",\"matchLevel\":\"none\",\"matchedWords\":[]}]}}],\"nbHits\":1,\"page\":0,\"nbPages\":1,\"hitsPerPage\":20,\"exhaustiveNbHits\":true,\"exhaustiveTypo\":true,\"exhaustive\":{\"nbHits\":true,\"typo\":true},\"query\":\"vim\",\"index\":\"cts_e2e_highlight_snippet_results\",\"renderingContent\":{}}]}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "search for a single facet request with minimal parameters")]
  public async Task SearchTest8()
  {
    try
    {
      var resp = await client.SearchAsync<Hit>(
        new SearchMethodParams
        {
          Requests = new List<SearchQuery>
          {
            new SearchQuery(
              new SearchForFacets
              {
                IndexName = "cts_e2e_search_facet",
                Type = Enum.Parse<SearchTypeFacet>("Facet"),
                Facet = "editor",
              }
            )
          },
          Strategy = Enum.Parse<SearchStrategy>("StopIfEnoughMatches"),
        }
      );
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"results\":[{\"exhaustiveFacetsCount\":true,\"facetHits\":[{\"count\":1,\"highlighted\":\"goland\",\"value\":\"goland\"},{\"count\":1,\"highlighted\":\"neovim\",\"value\":\"neovim\"},{\"count\":1,\"highlighted\":\"visual studio\",\"value\":\"visual studio\"},{\"count\":1,\"highlighted\":\"vscode\",\"value\":\"vscode\"}]}]}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "search filters end to end")]
  public async Task SearchTest14()
  {
    try
    {
      var resp = await client.SearchAsync<Hit>(
        new SearchMethodParams
        {
          Requests = new List<SearchQuery>
          {
            new SearchQuery(
              new SearchForHits
              {
                IndexName = "cts_e2e_search_facet",
                Filters = "editor:'visual studio' OR editor:neovim",
              }
            ),
            new SearchQuery(
              new SearchForHits
              {
                IndexName = "cts_e2e_search_facet",
                FacetFilters = new FacetFilters(
                  new List<FacetFilters>
                  {
                    new FacetFilters("editor:'visual studio'"),
                    new FacetFilters("editor:neovim")
                  }
                ),
              }
            ),
            new SearchQuery(
              new SearchForHits
              {
                IndexName = "cts_e2e_search_facet",
                FacetFilters = new FacetFilters(
                  new List<FacetFilters>
                  {
                    new FacetFilters("editor:'visual studio'"),
                    new FacetFilters(new List<FacetFilters> { new FacetFilters("editor:neovim") })
                  }
                ),
              }
            ),
            new SearchQuery(
              new SearchForHits
              {
                IndexName = "cts_e2e_search_facet",
                FacetFilters = new FacetFilters(
                  new List<FacetFilters>
                  {
                    new FacetFilters("editor:'visual studio'"),
                    new FacetFilters(
                      new List<FacetFilters>
                      {
                        new FacetFilters("editor:neovim"),
                        new FacetFilters(
                          new List<FacetFilters> { new FacetFilters("editor:goland") }
                        )
                      }
                    )
                  }
                ),
              }
            )
          },
        }
      );
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"results\":[{\"hitsPerPage\":20,\"index\":\"cts_e2e_search_facet\",\"nbHits\":2,\"nbPages\":1,\"page\":0,\"hits\":[{\"editor\":\"visual studio\",\"_highlightResult\":{\"editor\":{\"value\":\"visual studio\",\"matchLevel\":\"none\"}}},{\"editor\":\"neovim\",\"_highlightResult\":{\"editor\":{\"value\":\"neovim\",\"matchLevel\":\"none\"}}}],\"query\":\"\",\"params\":\"filters=editor%3A%27visual+studio%27+OR+editor%3Aneovim\"},{\"hitsPerPage\":20,\"index\":\"cts_e2e_search_facet\",\"nbHits\":0,\"nbPages\":0,\"page\":0,\"hits\":[],\"query\":\"\",\"params\":\"facetFilters=%5B%22editor%3A%27visual+studio%27%22%2C%22editor%3Aneovim%22%5D\"},{\"hitsPerPage\":20,\"index\":\"cts_e2e_search_facet\",\"nbHits\":0,\"nbPages\":0,\"page\":0,\"hits\":[],\"query\":\"\",\"params\":\"facetFilters=%5B%22editor%3A%27visual+studio%27%22%2C%5B%22editor%3Aneovim%22%5D%5D\"},{\"hitsPerPage\":20,\"index\":\"cts_e2e_search_facet\",\"nbHits\":0,\"nbPages\":0,\"page\":0,\"hits\":[],\"query\":\"\",\"params\":\"facetFilters=%5B%22editor%3A%27visual+studio%27%22%2C%5B%22editor%3Aneovim%22%2C%5B%22editor%3Agoland%22%5D%5D%5D\"}]}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "get searchDictionaryEntries results with minimal parameters")]
  public async Task SearchDictionaryEntriesTest()
  {
    try
    {
      var resp = await client.SearchDictionaryEntriesAsync(
        Enum.Parse<DictionaryType>("Stopwords"),
        new SearchDictionaryEntriesParams { Query = "about", }
      );
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"hits\":[{\"objectID\":\"86ef58032f47d976ca7130a896086783\",\"language\":\"en\",\"word\":\"about\"}],\"page\":0,\"nbHits\":1,\"nbPages\":1}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "searchRules")]
  public async Task SearchRulesTest()
  {
    try
    {
      var resp = await client.SearchRulesAsync(
        "cts_e2e_browse",
        new SearchRulesParams { Query = "zorro", }
      );
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"hits\":[{\"conditions\":[{\"alternatives\":true,\"anchoring\":\"contains\",\"pattern\":\"zorro\"}],\"consequence\":{\"params\":{\"ignorePlurals\":\"true\"},\"filterPromotes\":true,\"promote\":[{\"objectIDs\":[\"Æon Flux\"],\"position\":0}]},\"description\":\"test_rule\",\"enabled\":true,\"objectID\":\"qr-1725004648916\"}],\"nbHits\":1,\"nbPages\":1,\"page\":0}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "search with special characters in indexName")]
  public async Task SearchSingleIndexTest1()
  {
    try
    {
      var resp = await client.SearchSingleIndexAsync<Hit>("cts_e2e_space in index");
      // Check status code 200
      Assert.NotNull(resp);
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "single search retrieve snippets")]
  public async Task SearchSingleIndexTest3()
  {
    try
    {
      var resp = await client.SearchSingleIndexAsync<Hit>(
        "cts_e2e_browse",
        new SearchParams(
          new SearchParamsObject
          {
            Query = "batman mask of the phantasm",
            AttributesToRetrieve = new List<string> { "*" },
            AttributesToSnippet = new List<string> { "*:20" },
          }
        )
      );
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"nbHits\":1,\"hits\":[{\"_snippetResult\":{\"genres\":[{\"value\":\"Animated\",\"matchLevel\":\"none\"},{\"value\":\"Superhero\",\"matchLevel\":\"none\"},{\"value\":\"Romance\",\"matchLevel\":\"none\"}],\"year\":{\"value\":\"1993\",\"matchLevel\":\"none\"}},\"_highlightResult\":{\"genres\":[{\"value\":\"Animated\",\"matchLevel\":\"none\",\"matchedWords\":[]},{\"value\":\"Superhero\",\"matchLevel\":\"none\",\"matchedWords\":[]},{\"value\":\"Romance\",\"matchLevel\":\"none\",\"matchedWords\":[]}],\"year\":{\"value\":\"1993\",\"matchLevel\":\"none\",\"matchedWords\":[]}}}]}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "setSettings with minimal parameters")]
  public async Task SetSettingsTest1()
  {
    try
    {
      var resp = await client.SetSettingsAsync(
        "cts_e2e_settings",
        new IndexSettings { PaginationLimitedTo = 10, },
        true
      );
      // Check status code 200
      Assert.NotNull(resp);
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }
}
