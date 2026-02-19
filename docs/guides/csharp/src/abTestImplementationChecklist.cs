namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class AbTestImplementationChecklist
{
  private static string GetUserToken()
  {
    // Implement your logic here
    return "";
  }

  async Task Main(string[] args)
  {
    var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));

    // Set the searchParams and get the current user token
    var userToken = GetUserToken();

    var searchParamsObject = new SearchParamsObject { Query = "User search query" };

    // Is the user token anonymous?
    if (string.IsNullOrEmpty(userToken) || userToken == "YOUR_ANONYMOUS_USER_TOKEN")
    {
      // Disable A/B testing for this request
      searchParamsObject.EnableABTest = false;
    }
    else
    {
      // Set the user token to the current user token
      searchParamsObject.EnableABTest = true;
      searchParamsObject.UserToken = userToken;
    }

    var searchParams = new SearchParams(searchParamsObject);

    try
    {
      // Perform the searchSingleIndex
      var result = await client.SearchSingleIndexAsync<Hit>("<YOUR_INDEX_NAME>", searchParams);
      // SearchSingleIndex results
      Console.WriteLine(result);
    }
    catch (Exception err)
    {
      // SearchSingleIndex errors
      Console.Error.WriteLine(err);
    }
  }
}
