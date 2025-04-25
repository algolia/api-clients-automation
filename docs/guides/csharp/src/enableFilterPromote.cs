namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class EnableFilterPromote
{
  async Task Main(string[] args)
  {
    var condition = new Condition { Anchoring = Anchoring.Is, Pattern = "{facet:brand}" };

    var consequence = new Consequence { FilterPromotes = true };

    var rule = new Rule
    {
      ObjectID = "rule_with_filterPromotes",
      Conditions = [condition],
      Consequence = consequence,
    };
  }
}
