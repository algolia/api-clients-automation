using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Models.Search;

class SaveObjectsMovies
{
  public static async Task Main(string[] args)
  {
    // read json file from url
    var url = "https://dashboard.algolia.com/api/1/sample_datasets?type=movie";
    var httpClient = new HttpClient();
    var response = await httpClient.GetAsync(url);
    var content = await response.Content.ReadAsStringAsync();

    // parse json
    var movies = JsonSerializer.Deserialize<List<dynamic>>(content);

    // initiate client and index
    var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));

    // push data to algolia
    try
    {
      var result = await client.SaveObjectsAsync("<YOUR_INDEX_NAME>", movies);
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}
