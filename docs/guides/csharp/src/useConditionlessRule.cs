namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class UseConditionlessRule
{
  async Task Main(string[] args)
  {
    var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));

    var objectID = "a-rule-id";

    var rule = new Rule
    {
      ObjectID = objectID,
      Consequence =
        new Consequence( /* Set relevant consequence */
        ),
      // Set validity (optional)
      Validity = [new TimeRange { From = 1688774400L, Until = 1738972800L }],
    };

    await client.SaveRuleAsync("<YOUR_INDEX_NAME>", objectID, rule);
  }
}
